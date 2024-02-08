<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitud de Empleo</title>
    <link rel="stylesheet" href="empleo.css">
</head>

<body>
    <div class="container">
        <h1>Solicitud de Empleo</h1>
        <form class="form" action="empleo.php" method="POST">
            <!-- Nombre -->
            <div class="form__group">
                <input type="text" class="form__input" id="nombre" name="nombre" placeholder="Nombre" required>
                <label for="nombre" class="form__label">Nombre</label>
            </div>

            <!-- Puesto de Trabajo -->
            <div class="form__group">
                <select class="form__input" id="puesto" name="puesto" required>
                    <option value="" disabled selected>Seleccione el puesto</option>
                    <option value="Cocinero">Cocinero</option>
                    <option value="Camarero">Camarero</option>
                    <option value="Limpieza">Personal de Limpieza</option>
                    <option value="Entrenador">Entrenador</option>
                    <option value="Recepcionista">Recepcionista</option>
                    <!-- Agrega más opciones según sea necesario -->
                </select>
                <label for="puesto" class="form__label">Puesto de Trabajo</label>
            </div>

            <!-- Salario -->
            <div class="form__group">
                <input type="text" class="form__input" id="salario" name="salario" placeholder="Salario" readonly>
                <label for="salario" class="form__label">Salario</label>
            </div>

            <!-- Teléfono -->
            <div class="form__group">
                <input type="tel" class="form__input" id="telefono" name="telefono" placeholder="Teléfono" required>
                <label for="telefono" class="form__label">Teléfono</label>
            </div>

            <!-- Sector -->
            <div class="form__group" id="sectorGroup">
                <input type="text" class="form__input" id="sector" name="sector" placeholder="Sector" readonly>
                <label for="sector" class="form__label">Sector</label>
            </div>

            <!-- Campo oculto para idMesa -->
            <input type="hidden" id="idMesa" name="idMesa">

            <!-- Campo oculto para idZona -->
            <input type="hidden" id="idZona" name="idZona">

            <button type="submit" class="form__input">Enviar Solicitud</button>

        </form>
    </div>

    <script type="text/javascript">
        // Script para ajustar dinámicamente el salario, la visibilidad del campo de sector, y asignar idMesa/idZona
        const puestoInput = document.getElementById('puesto');
        const salarioInput = document.getElementById('salario');
        const sectorInput = document.getElementById('sector');
        const idMesaInput = document.getElementById('idMesa');
        const idZonaInput = document.getElementById('idZona');

        puestoInput.addEventListener('change', () => {
            if (puestoInput.value === 'Cocinero') {
                salarioInput.value = '2000.00€';
                sectorInput.value = 'Restaurante';
                idMesaInput.value = ''; // Aquí debes asignar el idMesa correspondiente
                idZonaInput.value = ''; // Resetear idZona
            } else if (puestoInput.value === 'Camarero') {
                salarioInput.value = '1800.00€';
                sectorInput.value = 'Restaurante';
                idMesaInput.value = ''; // Aquí debes asignar el idMesa correspondiente
                idZonaInput.value = ''; // Resetear idZona
            } else if (puestoInput.value === 'Limpieza') {
                salarioInput.value = '1300.00€';
                sectorInput.value = 'Restaurante y Gimnasio';
                idMesaInput.value = ''; // Resetear idMesa
                idZonaInput.value = ''; // Resetear idZona
            } else if (puestoInput.value === 'Entrenador') {
                salarioInput.value = '1800.00€';
                sectorInput.value = 'Gimnasio';
                idMesaInput.value = ''; // Resetear idMesa
                idZonaInput.value = ''; // Resetear idZona
            } else if (puestoInput.value === 'Recepcionista') {
                salarioInput.value = '1900.00€';
                sectorInput.value = 'Gimnasio';
                idMesaInput.value = ''; // Resetear idMesa
                idZonaInput.value = ''; // Resetear idZona
            } else {
                salarioInput.value = '';
                sectorInput.value = '';
                idMesaInput.value = ''; // Resetear idMesa
                idZonaInput.value = ''; // Resetear idZona
            }
        });
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
                window.location.href("../index.html")
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
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
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
        $conn->query($sql_empleados);

        // Llamar a la funcion de JavaScript
        echo "<script type='text/javascript'>Mensaje();</script>";
        // Cerrar conexión
        $conn->close();
    }
    ?>

</body>

</html>