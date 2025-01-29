package Proyecto2.model;

import Proyecto2.utils.NivelGravedad;

public class Robo extends Emergencia {
    public Robo(String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
        super("Robo", ubicacion, nivelGravedad, tiempoRespuesta);
    }
}
