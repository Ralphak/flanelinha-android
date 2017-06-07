//Objeto estacionamento

package com.example.ralp.flanelinha;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ralph on 07/06/2017.
 */

public class Estacionamento {
    private String local;
    private LatLng coordenadas;

    public Estacionamento(String local, LatLng coordenadas) {
        this.local = local;
        this.coordenadas = coordenadas;
    }

    public String getLocal() {
        return local;
    }

    public LatLng getCoordenadas() {
        return coordenadas;
    }
}
