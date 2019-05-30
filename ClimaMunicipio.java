/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climeaemet_xml;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ClimaMunicipio {
    private String municipio,  provincia;
    private ArrayList<Prediccion> lista_predicciones;

    public ClimaMunicipio(String municipio, String provincia, ArrayList<Prediccion> lista_predicciones) {
        this.municipio = municipio;
        this.provincia = provincia;
        this.lista_predicciones = lista_predicciones;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public ArrayList<Prediccion> getLista_predicciones() {
        return lista_predicciones;
    }

    @Override
    public String toString() {
        String aux="PROVINCIA: "+provincia+" MUNICIPIO: "+municipio+"\n";
        for (Prediccion prediccion : lista_predicciones) {
            aux+=prediccion.toString()+"\n";
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
