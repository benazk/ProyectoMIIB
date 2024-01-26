<html>
<body>

<?php
    $nombre = $_GET["nombre"]
    $apellidos=$_GET["apellido"];
    $email=$_GET["email"];
    $telefono=$_GET["telefono"];
    $cantidadPers=$_GET["cantidadPers"];
    $fecha=$_GET["fecha"];
    $que_elegido=$_GET["restaurante"];
?>   

Datos recibidos:<br>
Nombre: <?php echo $nombre; ?><br>
apellido: <?php echo $apellidos; ?><br>
email: <?php echo $email; ?><br>
telefono: <?php echo $telefono; ?><br>
cantidad de personas: <?php echo $cantidadPers; ?><br>
fecha: <?php echo $fecha; ?><br>

<?php
$servidor = "localhost";
$usuario = "root";
$password = "";
$basedatos = "bbddhoteldeportivo";

// Crear conexión
$conn = new mysqli($servidor, $usuario, $password, $basedatos);
// Checkear conexión
if ($conn->connect_error) {
  die("Conexión fallida: " . $conn->connect_error);
}

$sql_clientes = "INSERT INTO Clientes (NombreC, ApellidoC, Email, Telefono, cantPersonas, Fecha, Reserva)
VALUES ($nombre, $apellidos, $email, $telefono, $cantidadPers, $fecha, $reserva)";
$sql_restaurante = "SELECT idCliente FROM Restaurante INNER JOIN 
if ($conn->query($sql_clientes) === TRUE) {
  echo "Dado de alta satisfactoriamente";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

// Cerrar conexión
$conn->close();
?>

</body>
</html>