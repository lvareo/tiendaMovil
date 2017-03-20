/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaMovilControlador;
import java.awt.Color;
import java.util.ArrayList;
import tiendaMovilVista.TMVista;
import tiendaMovilModelo.TMModelo;
/**
 *
 * @author alumno
 */
public class TMControlador {
    private TMVista miVista;
    private TMModelo miModelo;
   
    
    public TMControlador(TMVista v, TMModelo m){
        miVista = v;
        miModelo = m;
    }
    
    public void setSelectionButtonGroup1(int []value){
        miModelo.setTamañoPantalla(value);
        miModelo.setDisponible();
        ArrayList<Color> colores;
        colores = miModelo.getDisponible();
        System.out.println(colores.toString());
        for(int i=0;i<colores.size();i++){
            switch (i){
                case 0:
                    miVista.setjButtonColor1Background(colores.get(i));
                    break;
                case 1:
                    miVista.setjButtonColor2Background(colores.get(i));
                    break;
                case 2:
                    miVista.setjButtonColor3Background(colores.get(i));
                    break;
                case 3:
                    miVista.setjButtonColor4Background(colores.get(i));
                    break;
                case 4:
                    miVista.setjButtonColor5Background(colores.get(i));
                    break;
                case 5:
                    miVista.setjButtonColor6Background(colores.get(i));
                    break;           
            }
        }
        miVista.setPanelColorEnable();
    }
    
    public void setjSlider1Value(){
        int precio = miVista.getjSlider1().getValue();
        miModelo.setPrecio(precio);
        miModelo.setMarcas();
        miVista.setjTextFieldPrecio();
        miVista.setjComboBoxMarcas();
    }
    
    public void setMarcaSelection(){
        Object marca = miVista.getjComboBoxMarcas().getSelectedItem();
        miModelo.setMarcaSeleccionada(marca);
        miVista.setSeleccionMarca();
    }
    /**
     * @param args the command line arguments
     */
    
    
}
