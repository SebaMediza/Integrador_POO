package jgame23;

import java.util.Date;

public class RecordJugador {
    private String nombre;
    private Integer puntaje;
    private Date fecha_obtencion;

    public RecordJugador(String nombre, Integer puntaje, Date fecha_obtencion){
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.fecha_obtencion = fecha_obtencion;
    }

    public Date getFecha_obtencion() {return fecha_obtencion;}

    public Integer getPuntaje() {return puntaje;}

    public String getNombre() {return nombre;}

    public void setFecha_obtencion(Date fecha_obtencion) {this.fecha_obtencion = fecha_obtencion;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setPuntaje(Integer puntaje) {this.puntaje = puntaje;}



}

