<html>
<body>

<?php
    $nombre=$_GET["nombre"];
    $edad=$_GET["edad"];
?>   

Datos recibidos:<br>
Nombre: <?php echo $nombre; ?><br>
Edad: <?php echo $edad; ?><br>

<?php
$servidor = "localhost";
$usuario = "username";
$password = "password";
$basedatos = "myDB";

// Crear conexión
$conn = new mysqli($servidor, $usuario, $password, $basedatos);
// Checkear conexión
if ($conn->connect_error) {
  die("Conexión fallida: " . $conn->connect_error);
}

$sql = "INSERT INTO Tabla1 (nombre, edad)
VALUES ($nombre, $edad)";

if ($conn->query($sql) === TRUE) {
  echo "Dado de alta satisfactoriamente";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

// Cerrar conexión
$conn->close();
?>

</body>
</html>