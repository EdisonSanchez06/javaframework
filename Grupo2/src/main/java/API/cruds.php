<?php
include_once("conexion.php");

class CRUD{

    public static function selectEstudiante(){
        $objetoConn = new Conexion();
        $conectar = $objetoConn->conectar();
        $sqlSelect = "SELECT * FROM alumnos";
        $resultado = $conectar->prepare($sqlSelect);
        $resultado->execute();
        $data = $resultado->fetchAll(PDO::FETCH_ASSOC);
        echo json_encode($data);
    }
public static function deleteStudent(){
    $objetoConn = new Conexion();
    $conectar = $objetoConn->conectar();
    $cedula = isset($_GET['EST_CED']) ? trim($_GET['EST_CED']) : '';

    // Detecta si es número o texto
    if (is_numeric($cedula)) {
        $sqlDelete = "DELETE FROM alumnos WHERE EST_CED = $cedula";
    } else {
        $sqlDelete = "DELETE FROM alumnos WHERE EST_CED = '$cedula'";
    }

    $resultado = $conectar->prepare($sqlDelete);
    $resultado->execute();
    $filas = $resultado->rowCount();

    echo json_encode($filas > 0 ? "Se eliminó correctamente" : "No se encontró el registro");
}


    public static function insertStudent(){
        $objetoConn = new Conexion();
        $conectar = $objetoConn->conectar();

        // 🔹 POST x-www-form-urlencoded con llaves EST_*
        $cedula    = $_POST['EST_CED'];
        $nombre    = $_POST['EST_NOM'];
        $apellido  = $_POST['EST_APE'];
        $direccion = $_POST['EST_DIR'];
        $telefono  = $_POST['EST_TEL'];

        $sqlInsert = "INSERT INTO alumnos (EST_CED, EST_NOM, EST_APE, EST_DIR, EST_TEL)
                      VALUES ('$cedula','$nombre','$apellido','$direccion','$telefono')";
        $resultado = $conectar->prepare($sqlInsert);
        $resultado->execute();

        echo json_encode("Se insertó correctamente");
    }

    public static function updateStudent(){
        $objetoConn = new Conexion();
        $conectar = $objetoConn->conectar();

        // 🔹 En PUT, tus parámetros van en la URL → $_GET
        $cedula    = $_GET['EST_CED'];
        $nombre    = $_GET['EST_NOM'];
        $apellido  = $_GET['EST_APE'];
        $direccion = $_GET['EST_DIR'];
        $telefono  = $_GET['EST_TEL'];

        $sqlUpdate = "UPDATE alumnos
                         SET EST_NOM='$nombre',
                             EST_APE='$apellido',
                             EST_DIR='$direccion',
                             EST_TEL='$telefono'
                       WHERE EST_CED='$cedula'";
        $resultado = $conectar->prepare($sqlUpdate);
        $resultado->execute();

        echo json_encode("Se actualizó correctamente");
    }
}
?>
