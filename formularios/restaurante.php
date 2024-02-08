<html lang="es">

<head>
    <title>Restaurante</title>
    <link rel="stylesheet" href="rest.css">
    <script type="text/javascript">
funcion Mensaje(){
      window.alert("nombre");
      // variables en las que guardo los datos de los campos
      var nombre = document.forms["formRest"]["nombre"].value;
      var apellido = document.forms["formRest"]["apellidos"].value;
      var email = document.forms["formRest"]["email"].value;
      var telefono = document.forms["formRest"]["telefono"].value;
      var menu = document.forms["formRest"]["menu"].value;
      var fecha = document.forms["formRest"]["fecha"].value;
      var nombre_apellido = nombre + " " + apellido;
      window.alert("Error al insertar los datos, inténtelo de nuevo");
      // muestra un pop up, si todos los campos estan completos, te da la bienvenida. Si no, te da error al insertar los datos y vuelve al punto de partida
      if (nombre == "" || apellido == "" || fecha == "" || email == "" || telefono == "" || menu == "" || fecha == "" ) {
        window.alert("Error al insertar los datos, inténtelo de nuevo");
        return false; // Evitar el envío del formulario si hay un error
      }
      else {
        return true; // Enviar el formulario en caso de que todos los datos sean correctos
      }
    }
  </script>
</head>

<body>
    <h1>RESERVA RESTAURANTE</h1>
    <div class="container">
        <h2>¡Rellena el formulario!</h2>
        <!-- Formulario de reserva en el restaurante -->
        <form action="restauranteform.php" name="formRest" onsubmit="return Mensaje()" method="POST" class="form">

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

            <input type="submit" value="Enviar Reserva" class="form__input" id="subject" />
        </form>
    </div>
</body>

</html>