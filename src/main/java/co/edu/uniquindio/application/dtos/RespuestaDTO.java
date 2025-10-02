package co.edu.uniquindio.application.dtos;

public record RespuestaDTO<T>(
    boolean error, 
    T data
) {

}