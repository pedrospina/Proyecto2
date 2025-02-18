package Proyecto2.model.services;

import Proyecto2.model.Emergencia;

public class Ambulancia extends ServicioBase {

    public Ambulancia(String id, int personalDisponible, int combustible) {
        super(id, personalDisponible, combustible);
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
        System.out.println("Ambulacia en camino!!!");
        System.out.println("-> [Ambulancia" + getId() + "]: " + emergencia.toString());

        asignarPersonal(3);
        gastarCombustible(5);
    }

}
