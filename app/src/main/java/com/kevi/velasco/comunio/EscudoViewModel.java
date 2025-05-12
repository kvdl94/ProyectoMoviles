package com.kevi.velasco.comunio;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EscudoViewModel extends ViewModel {
    private final MutableLiveData<Integer> escudoSeleccionado = new MutableLiveData<>();

    public MutableLiveData<Integer> getEscudoSeleccionado() {
        return escudoSeleccionado;
    }

    public void setEscudoSeleccionado(int escudo) {
        escudoSeleccionado.setValue(escudo);
    }
}