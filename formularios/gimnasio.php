<html>
<!DOCTYPE html>
<html lang="es">
<script type='text/javascript'>
    function Mensaje() {
      
    var nombre = document.getElementById("name").value;
    var apellido = document.getElementById("apellido").value;
    var email = document.getElementById("email").value;
    var telefono = document.getElementById("telefono").value;
    var suscripcion = document.getElementById("suscripcion").value;
    var fecha = document.getElementById("fecha").value;
    var nombre_apellido = document.getElementById("name").value + ' ' + document.getElementById("apellido").value;
    window.alert("ola gente");
    if (nombre.length !=== 0) {
      window.alert('Bienvenido ' + nombre_apellido + 'de correo ' + email);
      sleepES5(5000);
      window.location('C:\Users\alu01\Desktop\ProyectoHotelDeportivo\index.html');
    }
    else {
      window.alert('Error al insertar los datos, intentelo de nuevo');
      sleepES5(5000);
      window.location('C:\Users\alu01\Desktop\ProyectoHotelDeportivo\index.html');
    }
    
  }
  </script>
<head>
  <title>Reserva Gimnasio</title>
  <link rel="stylesheet" href="gym.css">
</head>

<body>
  <h1>RESERVA GIMNASIO</h1>
  <div class="container">
    <h2>¡Rellena el formulario!</h2>
    <form action="#" class="form" method="get">

      <input type="text" placeholder="Nombre" class="form__input" id="name" name="nombre" />
      <label for="name" class="form__label">Nombre</label>

      <input type="text" placeholder="Apellido" class="form__input" id="apellido" name="apellidos" />
      <label for="apellido" class="form__label">Apellido</label>

      <input type="email" placeholder="Email" class="form__input" id="email" name="email" />
      <label for="email" class="form__label">Email</label>

      <input type="tel" placeholder="Telefono" class="form__input" id="Telefono" name="telefono" />
      <label for="tel" class="form__label">Telefono</label>



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

      <input type="submit" placeholder="Extra" class="form__input" id="subject" onclick="Mensaje()" />

    </form>



</div>
<?php


$nombre = $_GET["nombre"];
$apellidos = $_GET["apellidos"];
$email = $_GET["email"];
$telefono = $_GET["telefono"];
$suscripcion = $_GET["suscripcion"];
$fecha = $_GET["fecha"];
$fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
$idZona = rand(0, 19);
echo $nombre . " " . $apellidos . " " . $email . " " . $telefono . " " . $suscripcion . " " . $fecha_format;

$servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
$usuario = "admin";
$password = "ASdiioqw--ad45";
$basedatos = "BBDDProyectoGym1";

// Crear conexión
$conn = new mysqli($servidor, $usuario, $password, $basedatos);
// Checkear conexión
if ($conn->connect_error) {
  die("Conexión Fallida: " . $conn->connect_error);
}

$sql_deportistas = "INSERT INTO Deportistas (NombreD, ApellidoD, Email, Telefono,FechaInicio, idSubs)
VALUES ('$nombre', '$apellidos', '$email', '$telefono', '$fecha_format', $suscripcion);";


$conn->query($sql_deportistas);

$result = $conn->query("SELECT MAX(idDeportista) AS max_id FROM Deportistas;");
$row = $result->fetch_assoc();
$maxId = $row['max_id'];

$sql_entrenan = "INSERT INTO Entrenan (idZona, idDeportista)
    VALUES ($idZona, $maxId);";
$conn->query($sql_entrenan);



echo "<script type='text/javascript'>Mensaje();</script>";
// Cerrar conexión
$conn->close();
?>
</body>

</html>