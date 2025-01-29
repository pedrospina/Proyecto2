package Proyecto2.model.services;

import Proyecto2.model.Emergencia;

public class Bomberos extends ServicioBase {

    public Bomberos(String id, int personalDisponible, int combustible) {
        super(id, personalDisponible, combustible);
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
        System.out.println("Bomberos en camino!!!");
        System.out.println("-> [Bomberos" + getId() + "]: " + emergencia.toString());

        asignarPersonal(5);
        gastarCombustible(10);

    }

}
