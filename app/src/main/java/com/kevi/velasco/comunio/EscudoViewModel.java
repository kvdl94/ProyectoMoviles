package com.kevi.velasco.comunio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EscudoViewModel extends ViewModel {

    private final MutableLiveData<String> escudoSeleccionado = new MutableLiveData<>();

    public void setEscudoSeleccionado(String nombreEquipo) {
        escudoSeleccionado.setValue(nombreEquipo);
    }

    public LiveData<String> getEscudoSeleccionado() {
        return escudoSeleccionado;
    }
}