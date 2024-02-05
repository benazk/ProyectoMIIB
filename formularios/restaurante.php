
<html lang="es">

<head>
    <title>Restaurante</title>
    <link rel="stylesheet" href="rest.css">
</head>

<body>
    <h1>RESERVA RESTAURANTE</h1>
    <div class="container">
        <h2>¡Rellena el formulario!</h2>
        <form action="#" method="post" class="form">

            <input type="text" placeholder="Nombre" class="form__input" id="nombre" name="nombre" />
            <label for="name" class="form__label">Nombre</label>

            <input type="text" placeholder="Apellido" class="form__input" id="apellido" name="apellido" />
            <label for="apellido" class="form__label">Apellido</label>

            <input type="email" placeholder="Email" class="form__input" id="email" name="email" />
            <label for="email" class="form__label">Email</label>

            <input type="tel" placeholder="Telefono" class="form__input" id="Telefono" name="telefono" />
            <label for="tel" class="form__label">Telefono</label>

            <select class="form__input" name="menu">
                <option value="0" id="0">Elige comida</option>
                <option value="1" id="1">Pescado + postre</option>
                <option value="2" id="2">Marisco + postre</option>
                <option value="3" id="3">Carne + postre</option>
                <option value="4" id="4">Pollo + postre</option>
                <option value="5" id="5">Sopa + postre</option>
                <option value="6" id="6">Menu Vegano</option>
                <option value="7" id="7">Menu Protéico</option>
                <option value="8" id="8">Legumbres + postre</option>
            </select>

            <input type="datetime-local" placeholder="Extra" class="form__input" id="fecha" name="fecha" />
            <label for="subject" class="form__label"></label>
            <input type="hidden" value="restaurante" name="restaurante" id="restaurante">

            <input type="submit" value="Enviar Reserva" class="form__input" id="subject" />
        </form>
        <input type="hidden" placeholder="Reserva" class="form__input" id="reserva" />
    </div>
    
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

$sql_comensales = "INSERT INTO Comensales (NombreC, ApellidoC, Email, Telefono, DiaYHora, idMesa, idMenu)
VALUES ('$nombre', '$apellidos', '$email', '$telefono', '$fecha_format', '$mesa', '$menu');";
echo $sql_comensales;
$conn->query($sql_comensales);


$sql_servir = "INSERT INTO SeSirve (idMesa, idMenu) VALUES ('$mesa', '$menu');";
$conn->query($sql_servir);


// Cerrar conexión
$conn->close();
?>

</body>
</html>