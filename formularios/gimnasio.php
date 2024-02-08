<html>
<!DOCTYPE html>
<html lang="es">

<head>
  <title>Reserva Gimnasio</title>
  <link rel="stylesheet" href="gym.css">
  <script type="text/javascript">
funcion Mensaje(){
      window.alert("nombre");
      // variables en las que guardo los datos de los campos
      var nombre = document.forms["formGym"]["nombre"].value;
      var apellido = document.forms["formGym"]["apellidos"].value;
      var email = document.forms["formGym"]["email"].value;
      var telefono = document.forms["formGym"]["telefono"].value;
      var suscripcion = document.forms["formGym"]["suscripcion"].value;
      var fecha = document.forms["formGym"]["fecha"].value;
      var zona = document.forms["formGym"]["zona"].value;
      var nombre_apellido = nombre + " " + apellido;
      window.alert("Error al insertar los datos, inténtelo de nuevo");
      // muestra un pop up, si todos los campos estan completos, te da la bienvenida. Si no, te da error al insertar los datos y vuelve al punto de partida
      if (nombre == "" || apellido == "" || fecha == "" || email == "" || telefono == "" || suscripcion == "" || zona == "") {
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
  <h1>RESERVA GIMNASIO</h1>
  <div class="container">
    <h2>¡Rellena el formulario!</h2>
    <!-- formulario de suscripcion al gimnasio -->
    <form action="gimnasioform.php" class="form" name="formGym" onsubmit="return Mensaje();" method="POST">

      <input type="text" placeholder="Nombre" class="form__input" id="nombre" name="nombre" />
      <label for="name" class="form__label">Nombre</label>

      <input type="text" placeholder="Apellido" class="form__input" id="apellidos" name="apellidos" />
      <label for="apellido" class="form__label">Apellido</label>

      <input type="email" placeholder="Email" class="form__input" id="email" name="email" />
      <label for="email" class="form__label">Email</label>

      <input type="tel" placeholder="Telefono" class="form__input" id="telefono" name="telefono" />
      <label for="tel" class="form__label">Telefono</label>


      <select name="zona" class="form__input" id="zona">
        <option value="0">Elige la zona</option>
        <option value="1">Kayak</option>
        <option value="2">Tenis</option>
        <option value="3">Gimnasio</option>
        <option value="4">Yoga</option>
        <option value="5">Pilates</option>
        <option value="6">Golf</option>
        <option value="7">Surf</option>
        <option value="8">Baloncesto/Fútbol</option>
        <option value="9">Anaeróbicos</option>
        <option value="10">Piscina</option>
      </select>
      <select name="suscripcion" class="form__input" id="suscripcion">
        <option value="0">Elige tu suscripción</option>
        <option value="1">Una sesión(20€) </option>
        <option value="2">Dos sesiones</option>
        <option value="3">Semanal</option>
        <option value="4">Mensual</option>
        <option value="5">Dos meses</option>
        <option value="6">Seis meses</option>
        <option value="7">Anual</option>
      </select>

      <input type="datetime-local" placeholder="Extra" class="form__input" id="fecha" name="fecha" />
      <label for="subject" class="form__label"></label>

      <input type="submit" placeholder="Extra" class="form__input" id="subject" />

    </form>
  </div>  
</body>

</html>