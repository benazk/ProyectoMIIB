<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="#" method="get">
    <input type="submit" name="" id="">
    </form>
    <?php 
        $servidor = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
        $usuario = "admin";
        $password = "ASdiioqw--ad45";
        $basedatos = "BBDDProyectoGym1";
        
        // Crear conexión
        $conn = new mysqli($servidor, $usuario, $password, $basedatos);
        // Checkear conexión
        if ($conn->connect_error) {
          die("Conexión Fallida: " . $conn->connect_error);
        }

        for($i = 10; $i < 20;$i++){
            $num = rand(0, 999999);
            $zona = "Zona " . $i;
            $insert = "INSERT INTO ZonaDeporte(NumTarjeta, Zona) VALUES($num, '$zona')";
            $conn->query($insert);
        }
    ?>
</body>
</html>