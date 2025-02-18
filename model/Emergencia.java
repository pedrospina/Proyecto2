package Proyecto2.model;

import Proyecto2.utils.NivelGravedad;

public abstract class Emergencia {
    private String tipo;
    private String ubicacion;
    private NivelGravedad nivelGravedad;
    private int tiempoRespuesta; // en minutos
    private boolean atendida;
    private long tiempoInicioAtencion;
    private long tiempoFinalAtencion;

    public Emergencia(String tipo, String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.nivelGravedad = nivelGravedad;
        this.tiempoRespuesta = tiempoRespuesta;
        this.atendida = false;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public NivelGravedad getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(NivelGravedad nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    public long getTiempoInicioAtencion() {
        return tiempoInicioAtencion;
    }

    public void setTiempoInicioAtencion(long tiempoInicioAtencion) {
        this.tiempoInicioAtencion = tiempoInicioAtencion;
    }

    public long getTiempoFinalAtencion() {
        return tiempoFinalAtencion;
    }

    public void setTiempoFinalAtencion(long tiempoFinalAtencion) {
        this.tiempoFinalAtencion = tiempoFinalAtencion;
    }

    public void iniciarAtencion() {
        this.tiempoInicioAtencion = System.currentTimeMillis();
    }

    public void finalizarAtencion() {
        this.atendida = true;
        this.tiempoFinalAtencion = System.currentTimeMillis();
    }

    public long calcularTiempoAtencion() {
        return (tiempoFinalAtencion - tiempoInicioAtencion);
    }

    public String getDescripcion() {
        return String.format("%s en %s (gravedad: %s)", tipo, ubicacion, nivelGravedad);
    }

    public String toString() {
        return getDescripcion() + " Tiempo estimado: " + tiempoRespuesta + " minutos";
    }

}
