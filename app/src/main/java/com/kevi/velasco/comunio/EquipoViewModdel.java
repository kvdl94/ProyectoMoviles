package com.kevi.velasco.comunio;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class EquipoViewModdel extends ViewModel {
    private final MutableLiveData<ArrayList<Jugador>> equipoUsuario = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<ArrayList<Jugador>> getEquipoUsuario() {
        return equipoUsuario;
    }
    public void setEquipoUsuario(ArrayList<Jugador> lista) {
        equipoUsuario.setValue(lista);
    }
}




