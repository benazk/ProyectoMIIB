<html>
<body>

<?php
    $nombre = $_GET["nombre"];
    $apellidos=$_GET["apellido"];
    $email=$_GET["email"];
    $telefono=$_GET["telefono"];
    $fecha=$_GET["fecha"];
    $menu=$_GET["menu"];
    $mesa = rand (1,40)
    $mesanum = $mesa + "A";
?>   

Datos recibidos:<br>
Nombre: <?php echo $nombre; ?><br>
apellido: <?php echo $apellidos; ?><br>
email: <?php echo $email; ?><br>
telefono: <?php echo $telefono; ?><br>
fecha: <?php echo $fecha; ?><br>
menu: <?php echo $menu; ?><br>
mesa: <?php echo $mesa; ?><br>
<?php
$servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
$usuario = "admin";
$password = "benala139";
$basedatos = "bbddproyectogym";

// Crear conexiÃ³n
$conn = new mysqli($servidor, $usuario, $password, $basedatos);
// Checkear conexiÃ³n
if ($conn->connect_error) {
  die("ConexiÃ³n fallida: " . $conn->connect_error);
}

$sql_comensales = "INSERT INTO Comensales (NombreC, ApellidoC, Email, Telefono, DiaYHora, idMenu, idMesa)
VALUES ($nombre, $apellidos, $email, $telefono, $fecha, $menu, $mesa);";

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