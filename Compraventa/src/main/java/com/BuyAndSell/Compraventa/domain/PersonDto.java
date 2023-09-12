package com.BuyAndSell.Compraventa.domain;
import lombok.Getter;

@Getter
public class PersonDto {
    private Integer cc;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer edad;
    private String genero;
    private String estado;

    public PersonDto(Integer cc, String nombre, String apellido1, String apellido2, Integer edad, String genero, String estado) {
        this.cc = cc;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.genero = genero;
        this.estado = estado;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
