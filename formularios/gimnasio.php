<html>
<!DOCTYPE html>
<html lang="es">

<head>
  <title>Reserva Gimnasio</title>
  <link rel="stylesheet" href="gym.css">
</head>

<body>
  <h1>RESERVA GIMNASIO</h1>
  <div class="container">
    <h2>¡Rellena el formulario!</h2>
    <!-- formulario de suscripcion al gimnasio -->
    <form action="#" class="form" method="POST">
    
      <input type="text" placeholder="Nombre" class="form__input" id="name" name="nombre" />
      <label for="name" class="form__label">Nombre</label>

      <input type="text" placeholder="Apellido" class="form__input" id="apellido" name="apellidos" />
      <label for="apellido" class="form__label">Apellido</label>

      <input type="email" placeholder="Email" class="form__input" id="email" name="email" />
      <label for="email" class="form__label">Email</label>

      <input type="tel" placeholder="Telefono" class="form__input" id="Telefono" name="telefono" />
      <label for="tel" class="form__label">Telefono</label>


      <select name="zona" id="zona" class="form__input">
        <option value="0">Elige la zona</option>
        <option value="1">Kayak</option>
        <option value="2">Tenis</option>
        <option value="3">Gimnasio</option>
        <option value="4">Yoga</option>
        <option value="5">Pilates</option>
        <option value="6">Golf</option>
        <option value="7">Surf</option>
        <option value="8">Baloncesto/Fútbol</option>
        <option value="9">Anaeróbicos</option>
        <option value="10">Piscina</option>
      </select>
      <select name="suscripcion" class="form__input" id="select" name="suscripcion">
        <option value="0">Elige tu suscripción</option>
        <option value="1">Una sesión(20€) </option>
        <option value="2">Dos sesiones</option>
        <option value="3">Semanal</option>
        <option value="4">Mensual</option>
        <option value="5">Dos meses</option>
        <option value="6">Seis meses</option>
        <option value="7">Anual</option>
      </select>

      <input type="datetime-local" placeholder="Extra" class="form__input" id="subject" name="fecha" />
      <label for="subject" class="form__label"></label>

      <input type="submit" placeholder="Extra" class="form__input" id="subject" onsubmit="return Mensaje();"/>

    </form>
</div>



<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") { // Solo ejecutar este código si el formulario se ha enviado
    sleep(5);
    // Guardo el contenido de los campos en variables de php
    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellidos"];
    $email = $_POST["email"];
    $telefono = $_POST["telefono"];
    $suscripcion = $_POST["suscripcion"];
    $fecha = $_POST["fecha"];
    $fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
    $idZona = $_POST["zona"];
    echo $nombre . " " . $apellidos . " " . $email . " " . $telefono . " " . $suscripcion . " " . $fecha_format . " " . $zona;

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

    $result = $conn->query("SELECT MAX(idDeportista) AS max_id FROM Deportistas;");
    $row = $result->fetch_assoc();
    $maxId = $row['max_id'];

    $sql_entrenan = "INSERT INTO Entrenan (idZona, idDeportista) VALUES ($idZona, $maxId);";
    $conn->query($sql_entrenan);
    
    // Esto llama a la funcion de JavaScript 
    echo '<script type="text/javascript">',
    'function Mensaje()',
    '</script>';

    // Cerrar conexión
    $conn->close();
}
?>
</body>

</html>