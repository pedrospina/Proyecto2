package Clase_08.model.strategy;

import Clase_08.model.Emergencia;

public interface StrategyPrioridad {
    int calcularPrioridad(Emergencia emergencia);
}
