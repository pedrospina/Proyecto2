package Clase_08.model.observer;

import Clase_08.model.Emergencia;

public interface SujetoEmergencias {
    void agregarObserver(ObserverEmergencias observerEmergencias);

    void eliminarObserver(ObserverEmergencias observerEmergencias);

    void notificarEmergencias(Emergencia emergencia);
}
