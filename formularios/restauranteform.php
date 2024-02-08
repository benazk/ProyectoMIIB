<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") { // Solo ejecutar este código si el formulario se ha enviado
    // Guardo el contenido de los campos en variables de php
    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellido"];
    $email = $_POST["email"];
    $telefono = $_POST["telefono"];
    $fecha = $_POST["fecha"];
    $fecha_format = substr($fecha, 0, 10) . ' ' . substr($fecha, 11, 5) . ':00';
    $menu = $_POST["menu"];
    $mesa = rand(1, 40);
    $cod = "A";
    $num_mesa = $mesa . '' . $cod;

    // Variables con las credenciales del servidor/base de datos
    $servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
    $usuario = "admin";
    $password = "ASdiioqw--ad45";
    $basedatos = "BBDDProyectoGym1";

    // Crear conexión usando las credenciales
    $conn = new mysqli($servidor, $usuario, $password, $basedatos);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }
    // Variables en las que guardo consultas a la base de datos ("$sql_comensales" y "$sql_servir")
    $sql_comensales = "INSERT INTO Comensales (NombreC, ApellidoC, Email, Telefono, DiaYHora, idMesa, idMenu)
VALUES ('$nombre', '$apellidos', '$email', '$telefono', '$fecha_format', '$mesa', '$menu');";
    // Función para ejecutar la consulta 
    $conn->query($sql_comensales);


    $sql_servir = "INSERT INTO SeSirve (idMesa, idMenu) VALUES ('$mesa', '$menu');";
    $conn->query($sql_servir);
    echo "<h1 style= 'font-family:Poppins, sans-serif; text-align:center;'>Gracias por rellenar el formulario. Tu suscripción ha sido activada</h1>";
    echo "<h2 style= 'font-family:Poppins, sans-serif; text-align:center;'>Credenciales del Solicitante</h2>
        <ul style='position:relative; left:42%;'>
        <li style= 'font-family:Poppins, sans-serif;'>Nombre: $nombre</li>
        <li style= 'font-family:Poppins, sans-serif;'>Apellidos: $apellidos</li>
        <li style= 'font-family:Poppins, sans-serif;'>Email: $email</li>
        <li style= 'font-family:Poppins, sans-serif;'>Telefono: $telefono</li>
        </ul>";
    echo "<h2 style= 'font-family:Poppins, sans-serif;  text-align:center;'><a href='../index.html' style= ' color:#5cccfc;'>Volver al Menú</a></h2>
        <h2 style= ' font-family:Poppins, sans-serif; text-align:center;'><a href='restaurante.php' style= ' color:#5cccfc;'>Rellenar otro formulario</a></h2>";


    // Cerrar conexión
    $conn->close();
}
?>