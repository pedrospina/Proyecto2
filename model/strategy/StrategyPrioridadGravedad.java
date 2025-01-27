package Clase_08.model.strategy;

import Clase_08.model.Emergencia;

public class StrategyPrioridadGravedad implements StrategyPrioridad {

    @Override
    public int calcularPrioridad(Emergencia emergencia) {
        switch (emergencia.getNivelGravedad()) {
            case ALTO:
                return 3;
            case MEDIO:
                return 2;
            case BAJO:
                return 1;
            default:
                return 1;
        }
    }

}
