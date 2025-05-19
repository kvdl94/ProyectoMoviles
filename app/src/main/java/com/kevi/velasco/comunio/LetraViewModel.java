package com.kevi.velasco.comunio;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LetraViewModel  extends ViewModel {
MutableLiveData<Integer> tamanioLetra = new MutableLiveData<>(14);

    public MutableLiveData<Integer> getTamanioLetra() {
        return tamanioLetra;
    }

    public void setTamanioLetra(int nuevoTamanio) {
        tamanioLetra.setValue(nuevoTamanio);
    }
}
