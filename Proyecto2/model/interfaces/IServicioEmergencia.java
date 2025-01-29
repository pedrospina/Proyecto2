package Proyecto2.model.interfaces;

import Proyecto2.model.Emergencia;

public interface IServicioEmergencia {
    String getId();

    int getPersonalDisponible();

    int getCombustible();

    boolean estaDisponible();

    void asignarPersonal(int cantidad);

    void libreraPersonal(int cantidad);

    void gastarCombustible(int cantidad);

    void tanquearCombustible(int cantidad);

    void atenderEmergencia(Emergencia emergencia);

}
