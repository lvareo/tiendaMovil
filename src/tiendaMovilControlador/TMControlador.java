/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaMovilControlador;
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
    
    public void setSelectionButtonGroup1(double value){
        miModelo.setTamañoPantalla(value);
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
        miVista.setjComboBoxMarcas();
        miVista.setSeleccionMarca();
    }
    /**
     * @param args the command line arguments
     */
    
    
}
