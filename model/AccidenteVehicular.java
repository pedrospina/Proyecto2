package Proyecto2.model;

import Proyecto2.utils.NivelGravedad;

public class AccidenteVehicular extends Emergencia {
    public AccidenteVehicular(String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
        super("AccidenteVehicular", ubicacion, nivelGravedad, tiempoRespuesta);
    }
}
