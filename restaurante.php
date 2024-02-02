<html>
  <script> 
    alert("Guardado"); 
    window.location='restaurante.php'; 
  </script>
<body>

<?php
    $nombre = $_GET["nombre"];
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

// Crear conexiÃ³n
$conn = new mysqli($servidor, $usuario, $password, $basedatos);
// Checkear conexiÃ³n
if ($conn->connect_error) {
  die("ConexiÃ³n fallida: " . $conn->connect_error);
}

$sql_clientes = "INSERT INTO Clientes (NombreC, ApellidoC, Email, Telefono, cantPersonas, Fecha, Reserva)
VALUES ($nombre, $apellidos, $email, $telefono, $cantidadPers, $fecha, $que_elegido);";

$sql_restaurante = "SELECT idCliente FROM ZonaReatauracion 
INNER JOIN Clientes ON Clientes.idCliente = ZonaRestauracion.idCliente 
WHERE Clientes.idCliente = (SELECT idCliente FROM Clientes WHERE NombreC = $nombre);"; 

if ($conn->query($sql_clientes) === TRUE) {
  echo "Dado de alta satisfactoriamente";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}
if ($conn->query($sql_restaurante) === TRUE) {
  echo "Dado de alta satisfactoriamente";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}


// Cerrar conexiÃ³n
$conn->close();
?>

</body>
</html>