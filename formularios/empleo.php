<!DOCTYPE html>
<html lang="es">
<body>

<?php
    $nombre = $_POST["nombre"];
    $puesto = $_POST["puesto"];
    $salario = $_POST["salario"];
    $telefono = $_POST["telefono"];
    $sector = $_POST["sector"];
    $idMesa = $_POST["idMesa"];
    $idZona = $_POST["idZona"];

    // Datos para la conexión a la base de datos
    $servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
    $usuario = "admin";
    $password = "ASdiioqw--ad45";
    $basedatos = "BBDDProyectoGym1";

    // Crear conexión
    $conn = new mysqli($servidor, $usuario, $password, $basedatos);

    // Chequear conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    // SQL para insertar en la tabla Empleados
    $sql_empleados = "INSERT INTO Empleados (NombreE, PuestoTrabajo, Salario, Telefono, Sector, idMesa, idZona)
                      VALUES ('$nombre', '$puesto', '$salario', '$telefono', '$sector', '$idMesa', '$idZona');";

    // Ejecutar la consulta
    if ($conn->query($sql_empleados) === TRUE) {
        echo "Solicitud de empleo enviada satisfactoriamente";
    } else {
        echo "Error: " . $sql_empleados . "<br>" . $conn->error;
    }

    // Cerrar conexión
    $conn->close();
?>

</body>
</html>
