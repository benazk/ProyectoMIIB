<html lang="es">

<head>
    <title>Restaurante</title>
    <link rel="stylesheet" href="rest.css">
</head>

<body>
    <h1>RESERVA RESTAURANTE</h1>
    <div class="container">
        <h2>¡Rellena el formulario!</h2>
        <!-- Formulario de reserva en el restaurante -->
        <form action="#" method="post" class="form">

            <input type="text" placeholder="Nombre" class="form__input" id="nombre" name="nombre" />
            <label for="name" class="form__label">Nombre</label>

            <input type="text" placeholder="Apellido" class="form__input" id="apellido" name="apellido" />
            <label for="apellido" class="form__label">Apellido</label>

            <input type="email" placeholder="Email" class="form__input" id="email" name="email" />
            <label for="email" class="form__label">Email</label>

            <input type="tel" placeholder="Telefono" class="form__input" id="Telefono" name="telefono" />
            <label for="tel" class="form__label">Telefono</label>

            <select class="form__input" name="menu" id="menu">
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

            <input type="submit" value="Enviar Reserva" class="form__input" id="subject" onsubmit="return Mensaje();" />
        </form>
    </div>

    <script type="text/javascript">
        function Mensaje() {
            // variables en las que guardo los datos de los campos
            var nombre = document.getElementById("nombre").value;
            var apellido = document.getElementById("apellido").value;
            var email = document.getElementById("email").value;
            var telefono = document.getElementById("Telefono").value;
            var suscripcion = document.getElementById("menu").value;
            var fecha = document.getElementById("fecha").value;
            var nombre_apellido = nombre + ' ' + apellido;
            // muestra un pop up, si todos los campos estan completos, te da la bienvenida. Si no, te da error al insertar los datos y vuelve al punto de partida
            if (nombre.length !== 0 && apellido.length !== 0 && fecha.length !== 0 && email.length !== 0 && telefono.length !== 0 && suscripcion.length !== 0) {
                window.alert("Bienvenido " + nombre_apellido + " de correo " + email);
                setTimeout(function () {
                    document.getElementById("subject").disabled = true; // Deshabilitar el botón después de hacer clic
                    setTimeout(function () {
                        document.getElementById("subject").disabled = false; // Habilitar el botón después de 5 segundos
                    }, 5000);
                }, 1); // Agregar un pequeño retraso antes de deshabilitar el botón
                return true; // Permitir el envío del formulario después del retraso
            } else {
                window.alert("Error al insertar los datos, inténtelo de nuevo");
                setTimeout(function () {
                    window.location.reload();
                }, 5000);
                return false; // Evitar el envío del formulario si hay un error
            }
        }
    </script>

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
        echo "<script type='text/javascript'>Mensaje();</script>";

        // Cerrar conexión
        $conn->close();
    }
    ?>

</body>

</html>