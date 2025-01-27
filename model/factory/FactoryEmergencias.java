package Clase_08.model.factory;

import Clase_08.model.AccidenteVehicular;
import Clase_08.model.Incendio;
import Clase_08.model.Emergencia;
import Clase_08.model.Robo;
import Clase_08.utils.NivelGravedad;
import Clase_08.utils.TipoEmergencia;

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
