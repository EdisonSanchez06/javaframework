/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

/**
 *
 * @author Edison
 */
public class ClienteEstudiantes {

    private final Gson gson = new Gson();
    private final HttpClient cliente = HttpClient.newHttpClient();
    private final String ApiUrl = "http://localhost/SOA/api.php";

    public ArrayList<Estudiante> obtenerEstudiantes() {
        try {
            HttpRequest peticionGet = HttpRequest.newBuilder()
                    .uri(new URI(ApiUrl))
                    .GET()
                    .build();
            HttpResponse<String> respuestaGet = cliente.send(peticionGet, BodyHandlers.ofString());
            System.out.println("HTTP " + respuestaGet.statusCode());
            System.out.println("BODY: " + respuestaGet.body());
            if (respuestaGet.statusCode() == 200) {
                String jsonRespuesta = respuestaGet.body();
                //System.out.println(jsonRespuesta);
                java.lang.reflect.Type tipoArray = new TypeToken<ArrayList<Estudiante>>() {
                }.getType();
                ArrayList<Estudiante> estudianteLista = gson.fromJson(jsonRespuesta, tipoArray);
                return estudianteLista;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();

    }

    public boolean registrarEstudiante(Estudiante estudiante) {
        String parametros = construirParametros(estudiante);
        try {
            HttpRequest peticionPost = HttpRequest.newBuilder()
                    .uri(new URI(ApiUrl))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(BodyPublishers.ofString(parametros))
                    .build();
            HttpResponse<String> respuesta = cliente.send(peticionPost, BodyHandlers.ofString());
            if (respuesta.statusCode() == 200) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
                    return false;
    }
    public boolean eliminarEstudiante(String cedula){
        String urlBorrar = construirConsulta("EST_CED=" +cedula );
         try {
            HttpRequest peticionDelete = HttpRequest.newBuilder()
                    .uri(new URI(urlBorrar))
                    .DELETE()
                    .build();
            HttpResponse<String> respuesta = cliente.send(peticionDelete, BodyHandlers.ofString());
            if (respuesta.statusCode() == 200) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         return false;
    }
    
    public String construirConsulta(String parametros){
        return ApiUrl + "?" + parametros;
    }
    
    
    public boolean editarEstudiante(Estudiante estudiante){
        String urlEditar = construirConsulta(construirParametros(estudiante) );
         try {
            HttpRequest peticionPut = HttpRequest.newBuilder()
                    .uri(new URI(urlEditar))
                    .PUT(BodyPublishers.noBody())
                    .build();
            HttpResponse<String> respuesta = cliente.send(peticionPut, BodyHandlers.ofString());
            if (respuesta.statusCode() == 200) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         return false;
    }
    
    
    private String construirParametros(Estudiante estudiante) {
        return "EST_CED=" + estudiante.getEST_CED()
                + "&EST_NOM=" + estudiante.getEST_NOM()
                + "&EST_APE=" + estudiante.getEST_APE()
                + "&EST_DIR=" + estudiante.getEST_DIR()
                + "&EST_TEL=" + estudiante.getEST_TEL();
    }
}
