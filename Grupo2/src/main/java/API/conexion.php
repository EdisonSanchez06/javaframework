<?php

class Conexion{

    public function conectar(){

   
        $server ="localhost";
        $user = "root";
        $password= "";
        $dataBase="soa";
            try{
            $conn= new PDO("mysql:host=$server; dbname=$dataBase",$user,$password);
            }catch(Exception $e){
              die("Fallo". $e->getMessage());
            }
            return $conn;
    }
 }



?> 