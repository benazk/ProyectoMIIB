<?php
  if ($_SERVER["REQUEST_METHOD"] == "POST") { // Solo ejecutar este código si el formulario se ha enviado
    // Guardo el contenido de los campos en variables de php
    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellidos"];
    $email = $_POST["email"];
    $telefono = $_POST["telefono"];
    $suscripcion = $_POST["suscripcion"];
    $fecha = $_POST["fecha"];
    $fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
    $idZona = $_POST["zona"];

    // Variables con las credenciales del servidor/base de datos
    $servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
    $usuario = "admin";
    $password = "ASdiioqw--ad45";
    $basedatos = "BBDDProyectoGym1";

    // Crear conexión usando las credenciales
    $conn = new mysqli($servidor, $usuario, $password, $basedatos);

    // Verificar conexión
    if ($conn->connect_error) {
      die("Conexión Fallida: " . $conn->connect_error);
    }

    // Variables en las que guardo consultas a la base de datos ("$sql_deportistas" y "$sql_entrenan")
    $sql_deportistas = "INSERT INTO Deportistas (NombreD, ApellidoD, Email, Telefono,FechaInicio, idSubs) VALUES ('$nombre', '$apellidos', '$email', '$telefono', '$fecha_format', $suscripcion);";
    // Función para ejecutar la consulta
    $conn->query($sql_deportistas);

    echo "<h1 style= 'font-family:Poppins, sans-serif; text-align:center;'>Gracias por rellenar el formulario. Tu suscripción ha sido activada</h1>";
    echo "<h2 style= 'font-family:Poppins, sans-serif; text-align:center;'>Credenciales del Solicitante</h2>
    <ul style='position:relative; left:42%;'>
     <li style= 'font-family:Poppins, sans-serif;'>Nombre: $nombre</li>
     <li style= 'font-family:Poppins, sans-serif;'>Apellidos: $apellidos</li>
     <li style= 'font-family:Poppins, sans-serif;'>Email: $email</li>
     <li style= 'font-family:Poppins, sans-serif;'>Telefono: $telefono</li>
    </ul>";
    echo "<h2 style= 'font-family:Poppins, sans-serif;  text-align:center;'><a href='../index.html' style= ' color:#5cccfc;'>Volver al Menú</a></h2>
    <h2 style= ' font-family:Poppins, sans-serif; text-align:center;'><a href='gimnasio.php' style= ' color:#5cccfc;'>Rellenar otro formulario</a></h2>";
   
    $result = $conn->query("SELECT MAX(idDeportista) AS max_id FROM Deportistas;");
    $row = $result->fetch_assoc();
    $maxId = $row['max_id'];

    $sql_entrenan = "INSERT INTO Entrenan (idZona, idDeportista) VALUES ($idZona, $maxId);";
    $conn->query($sql_entrenan);

    // Cerrar conexión
    $conn->close();
  }
