package com.example.appcalificacion;

public class estudiante {
    public String rude, nombre, apellido, curso, materia;

    public estudiante(String rude, String nombre, String apellido, String curso, String materia) {
        this.rude = rude;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.materia = materia;
    }

    public estudiante(String rude, String nombre, String apellido) {
        this.rude = rude;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public estudiante() {
    }

    public String getRude() {
        return rude;
    }

    public void setRude(String rude) {
        this.rude = rude;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
