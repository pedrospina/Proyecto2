package Proyecto2.model.strategy;

import Proyecto2.model.Emergencia;

public class StrategyPrioridadCercania implements StrategyPrioridad {
    private class MapaUrbano {
        public int calcularDistancia(String ubicacion) {
            switch (ubicacion.toLowerCase()) {
                case "zona-norte":
                    return 8;
                case "zona-sur":
                    return 10;
                case "zona-centro":
                    return 2;
                case "zona-oriente":
                    return 5;
                case "zona-occiendente":
                    return 6;
                default:
                    return 10;
            }
        }
    }

    private MapaUrbano mapaUrbano = new MapaUrbano();

    @Override
    public int calcularPrioridad(Emergencia emergencia) {
        int calcularDistancia = mapaUrbano.calcularDistancia(emergencia.getUbicacion());
        return 10 - calcularDistancia;
    }
}
