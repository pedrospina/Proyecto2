package Proyecto2.model;

import Proyecto2.utils.NivelGravedad;

public class Incendio extends Emergencia {
    public Incendio(String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
        super("Incendio", ubicacion, nivelGravedad, tiempoRespuesta);
    }
}
