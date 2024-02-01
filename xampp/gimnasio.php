<html>

<body>

  <?php
  $nombre = $_GET["nombre"];
  $apellidos = $_GET["apellidos"];
  $email = $_GET["email"];
  $telefono = $_GET["telefono"];
  $suscripcion = $_GET["suscripcion"];
  $fecha = $_GET["fecha"];
  $fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
  $idZona = rand(0, 20);

  ?>

  Datos recibidos:<br>
  nombre:
  <?php echo $nombre; ?><br>
  apellido:
  <?php echo $apellidos; ?><br>
  email:
  <?php echo $email; ?><br>
  telefono:
  <?php echo $telefono; ?><br>
  fecha:
  <?php echo $fecha_format; ?><br>
  suscripcion:
  <?php echo $suscripcion; ?><br>
  idZona:
  <?php echo $idZona; ?><br>



  <?php
  $servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
  $usuario = "admin";
  $password = "ASdiioqw--ad45";
  $basedatos = "BBDDProyectoGym1";

  // Crear conexión
  $conn = new mysqli($servidor, $usuario, $password, $basedatos);
  // Checkear conexión
  if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
  }

  $sql_deportistas = "INSERT INTO Deportistas (NombreD, ApellidoD, Email, Telefono,FechaInicio, idSubs)
VALUES ('$nombre', '$apellidos', '$email', '$telefono', '$fecha_format', $suscripcion);";

  echo $sql_deportistas;

  if ($conn->query($sql_deportistas) === TRUE) {
    echo "Insercion en Deportistas";

  }
  $sql_id = "SELECT MAX(idDeportista) FROM Deportistas;";
  echo $sql_id; 
  $select = $conn->query("SELECT MAX(idDeportista) FROM Deportistas;");
  echo $select;

  $sql_entrenan = "INSERT INTO Entrena (idZona, idDeportista)
    VALUES ($idZona, $sql_id);";
    echo $sql_entrenan;
    if ($conn->query($sql_entrenan) === TRUE) {
    echo "Insercion en Entrena";
    
  }




  // Cerrar conexión
  $conn->close();
  ?>

</body>

</html>