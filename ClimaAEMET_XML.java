/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climeaemet_xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.*;

import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Admin
 */
public class ClimaAEMET_XML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SAXBuilder builder=new SAXBuilder();
        File file=new File("D:\\clima.xml");
        try {
            //Document documento_ppal= builder.build(new URL("http://www.aemet.es/xml/municipios/localidad_40216.xml"));
           Document documento_ppal= builder.build(file);
           Element elemento_raiz=documento_ppal.getRootElement();
           Element elemento_nombre=elemento_raiz.getChild("nombre");
           String municipio=elemento_nombre.getValue();
           String provincia=elemento_raiz.getChild("provincia").getValue();
           Element elemento_prediccion=elemento_raiz.getChild("prediccion");
           List<Element> lista_elementos_dia=elemento_prediccion.getChildren("dia");
           ArrayList<Prediccion> lista_predicciones=new ArrayList();
           for(Element elemento_dia: lista_elementos_dia)
           {
               Attribute atributo_fecha=elemento_dia.getAttribute("fecha");
               String fecha=atributo_fecha.getValue();
               String datos[]=fecha.split("-");//2019-05-29
               fecha=datos[2]+"/"+datos[1]+"/"+datos[0];
               Element elemento_temperatura=elemento_dia.getChild("temperatura");
               Element elemento_minima=elemento_temperatura.getChild("minima");
               Element elemento_maxima=elemento_temperatura.getChild("maxima");
               String temp_min=elemento_minima.getValue();
               String temp_max=elemento_maxima.getValue();
               Prediccion p=new Prediccion(fecha, Integer.parseInt(temp_min),
                       Integer.parseInt(temp_max));
               lista_predicciones.add(p);
               
           }
           ClimaMunicipio clima_total=new ClimaMunicipio(municipio, provincia, lista_predicciones);
            System.out.println(clima_total);
        } catch (JDOMException ex) {
            Logger.getLogger(ClimaAEMET_XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClimaAEMET_XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
