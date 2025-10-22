<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type");
include_once("cruds.php");
if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    http_response_code(200);
    exit();
}
$opc=$_SERVER['REQUEST_METHOD'];
//print_r($opc);

switch ($opc){
     case 'GET' :
        CRUD::selectEstudiante();
        break;

        case 'POST':
        CRUD:: insertStudent();
        
        break;
     

        case 'DELETE':
          CRUD:: deleteStudent();
      
        break;

        case 'PUT':
          CRUD:: updateStudent();
        break;
      }
      

?>