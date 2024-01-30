<html>
<body>

<?php
    $nombre = $_GET["nombre"];
    $apellidos=$_GET["apellido"];
    $email=$_GET["email"];
    $telefono=$_GET["telefono"];
    $fecha=$_GET["fecha"];
    $fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
    $menu=$_GET["menu"];
    $mesa = rand (1,40);
    $cod = "A";
    $num_mesa = $mesa . '' . $cod; 
?>   

Datos recibidos:<br>
Nombre: <?php echo $nombre; ?><br>
apellido: <?php echo $apellidos; ?><br>
email: <?php echo $email; ?><br>
telefono: <?php echo $telefono; ?><br>
fecha: <?php echo $fecha_format; ?><br>
menu: <?php echo $menu; ?><br>
mesa: <?php echo $mesa; ?><br>
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

$sql_comensales = "INSERT INTO Comensales (NombreC, ApellidoC, Email, Telefono, DiaYHora, idMesa, idMenu)
VALUES ('$nombre', '$apellidos', '$email', '$telefono', '$fecha_format', 1, $num_mesa);";


if ($conn->query($sql_comensales) === TRUE) {
  echo "Dado de alta satisfactoriamente";
} else {
  echo "Error: " . $sql_comensales . "<br>" . $conn->error;
}

// Cerrar conexión
$conn->close();
?>

</body>
</html>