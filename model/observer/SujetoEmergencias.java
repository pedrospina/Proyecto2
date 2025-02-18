package Proyecto2.model.observer;

import Proyecto2.model.Emergencia;

public interface SujetoEmergencias {
    void agregarObserver(ObserverEmergencias observerEmergencias);

    void eliminarObserver(ObserverEmergencias observerEmergencias);

    void notificarEmergencias(Emergencia emergencia);
}
