package com.kevi.velasco.comunio;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EquipoViewModel extends ViewModel {
    private final MutableLiveData<Equipo> equipoSeleccionado = new MutableLiveData<>();

    public void setEquipoSeleccionado(Equipo equipo) {
        equipoSeleccionado.setValue(equipo);
    }

    public LiveData<Equipo> getEquipoSeleccionado() {
        return equipoSeleccionado;
    }
}





