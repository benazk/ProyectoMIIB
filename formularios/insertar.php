<?php
$mesa_num = "";
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
for ($i = 1; $i < 40; $i++) {
    $mesa_num = $i . "A";
    $sql_mesas = "INSERT INTO ZonaRestauracion (MesaNum) VALUES ('$mesa_num');";
    $conn->query($sql_mesas);
}

if ($conn->query($sql_mesas) === TRUE) {
    echo "que pro";
}
$mesa_num = "";
$conn->close();
?>