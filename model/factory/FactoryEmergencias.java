package Proyecto2.model.factory;

import Proyecto2.model.AccidenteVehicular;
import Proyecto2.model.Incendio;
import Proyecto2.model.Emergencia;
import Proyecto2.model.Robo;
import Proyecto2.utils.NivelGravedad;
import Proyecto2.utils.TipoEmergencia;

public class FactoryEmergencias {

    public static Emergencia crearEmergencia(TipoEmergencia tipo, String ubicacion, NivelGravedad nivelGravedad,
            int tiempoRespuesta) {

        switch (tipo) {
            case ROBO:
                return new Robo(ubicacion, nivelGravedad, tiempoRespuesta);
            case ACCIDENTE_VEHICULAR:
                return new AccidenteVehicular(ubicacion, nivelGravedad, tiempoRespuesta);
            case INCENDIO:
                return new Incendio(ubicacion, nivelGravedad, tiempoRespuesta);
            default:
                return null;
        }
    }

}
