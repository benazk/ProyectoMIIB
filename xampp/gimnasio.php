<html>
<body>

<?php
    $nombre=$_GET["nombre"];
    $apellidos=$_GET["apellidos"];
    $email =$_GET["email"];
    $telefono= $_GET["telefono"];
    $fecha= $_GET["fechaInicio"];
    $fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
    $suscripcion=$_GET["suscripcion"];
    $zona = rand(1,20);

?>   

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

$sql_deportistas = "INSERT INTO Deportistas (NombreD, ApelidoD, Email, Telefono, fechaInicio, idSubs)
VALUES ($nombre, $apellidos, $email, $telefono, $fechahora, $suscripcion);";
echo $sql_deportistas;
$conn->query($sql_deportistas);

$result = $conn->query("SELECT MAX(idSubs) as max_id FROM Deportistas");
$row = $result->fetch_assoc();
$maxId = $row['max_id'];
echo $maxId;

$sql_entrenan = "INSERT INTO Entrenan(idZona, idDeportista) 
VALUES ($zona, $sql_extraer)";
echo $sql_entrenan;
$conn->query($sql_entrenan);

// Cerrar conexión
$conn->close();
?>

</body>
</html>