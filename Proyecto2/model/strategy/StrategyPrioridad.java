package Proyecto2.model.strategy;

import Proyecto2.model.Emergencia;

public interface StrategyPrioridad {
    int calcularPrioridad(Emergencia emergencia);
}
