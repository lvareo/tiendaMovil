/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaMovilControlador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import tiendaMovilVista.TMVista;
import tiendaMovilModelo.TMModelo;
import tiendaMovilModelo.movil;
/**
 *
 * @author alumno
 */
public class TMControlador {
    private TMVista miVista;
    private TMModelo miModelo;
   
    enum listado{Apple(0),Samsung(0),LG(0),Sony(0),Huawey(0);
    
        private int recuento;
        
        listado(int recuento){
            this.recuento = recuento;
        }
        
        public void setRecuento(int recuento){
            this.recuento = recuento;
        }
        
        public int getRecuento(){
            return recuento;
        }
        
        public void addRecuento(){
            recuento += 1;
        }
    
    }
    
    /**
     *
     * @param v
     * @param m
     */
    public TMControlador(TMVista v, TMModelo m){
        miVista = v;
        miModelo = m;
    }
    
    /**
     *
     * @param value
     */
    public void setSelectionButtonGroup1(int []value){
        miVista.clearErrorjTextLabel();
        miModelo.setTamañoPantalla(value);
        ArrayList<Color> disponible;
        disponible = new ArrayList<>();
        Iterator<movil> moviles = miModelo.getStock().iterator();
        while (moviles.hasNext()){
            movil tempMovil = moviles.next();
            if(tempMovil.getPrecio()<=miModelo.getPrecio()){
                if (tempMovil.getMarca().contains(miModelo.getMarcaSeleccionada().toString().substring(0, miModelo.getMarcaSeleccionada().toString().indexOf("(")))) {
                    if (value[0]<= tempMovil.getTamañoPantalla()) {
                        if (tempMovil.getTamañoPantalla()<= value[1]) {
                            disponible.add(tempMovil.getColor());
                        }
                    }
                
                }
                
            }
            
        }
        miModelo.setDisponible(disponible);
        miVista.resetjButtonColorsBackground();
        ArrayList<Color> colores;
        colores = disponible;
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
    
    /**
     *
     */
    public void setjSlider1Value(){
        int precio = miVista.getjSlider1().getValue();
        miModelo.setPrecio(precio);
        miVista.setPanelMarcaEnabled();
        miVista.clearErrorjTextLabel();
        for(listado l: listado.values()){
            l.setRecuento(0);
        }
        int n = 1;
        ArrayList<movil> Stock = miModelo.getStock();
        Iterator<movil> moviles = Stock.iterator();
        while (moviles.hasNext()){
            movil tempMovil = moviles.next();
            if (tempMovil.getPrecio()<=miModelo.getPrecio()){
                switch(tempMovil.getMarca()){
                    case "Apple":
                        listado.Apple.addRecuento();
                        break;
                    case "Samsung":
                        listado.Samsung.addRecuento();
                        break;
                    case "LG":
                        listado.LG.addRecuento();
                        break;
                    case "Sony":
                        listado.Sony.addRecuento();
                        break;
                    case "Huawey":
                        listado.Huawey.addRecuento();
                        break;
                } 
            }
        }
        for(listado l: listado.values()){
            if(l.getRecuento()!=0){
                n++;
            }
        }
        String []modelo;
        modelo = new String [n];
        modelo[0] = "< Seleccione una marca >";
        int i=0;
        for(listado l: listado.values()){
            if (l.getRecuento()>0){
                i++;
                modelo[i] = String.format("%s(%d)\n",l,l.getRecuento());
            }
        }
        if(modelo.length == 1){
            modelo[0] = "No hay marcas disponibles";
        }
        miModelo.setMarcas(new DefaultComboBoxModel(modelo));
        miModelo.setMarcaSeleccionada(Object.class.cast("< Seleccione una marca >"));
        miVista.setjTextFieldPrecio();
        miVista.setjComboBoxMarcas();
        miVista.setSeleccionMarca();
    }

    /**
     *
     */
    public void setjTextFieldValue(){
        miVista.clearErrorjTextLabel();
        String texto  = miVista.getjTextFieldPrecio().getText();
        try{
            int value  = Integer.parseInt(texto);
            if(value>=0 && value<=1000){
                miVista.setjSlider1Value(value);
                setjSlider1Value();    
            }
            else if(value<0){
                miVista.setjSlider1Value(0);
                setjSlider1Value();
            }
            else if(value>1000){
                miVista.setjSlider1Value(1000);
                setjSlider1Value();
            }
        }
        catch(NumberFormatException nfe){
            miVista.ErrorjTextLabel();
            miModelo.setMarcaSeleccionada(miVista.getjComboBoxMarcas().getModel().getElementAt(0));
            miVista.setPanelMarcaDisabled();
            miVista.setPanelTamañoDisabled();
            miVista.setPanelColorDisabled();
            miModelo.setColor(null);
            miModelo.setPrecio(0);
            miModelo.setTamañoPantalla(null);
            miModelo.setMarcas(null);

        }
    }

    /**
     *
     */
    public void setMarcaSelection(){
        Object marca = miVista.getjComboBoxMarcas().getSelectedItem();
        miModelo.setMarcaSeleccionada(marca);
        miVista.setSeleccionMarca();
        miVista.clearButtonGroupSelection();
        miVista.setPanelColorDisabled();
        miVista.resetjButtonColorsBackground();
        miVista.setjRadioButton1Disabled();
        miVista.setjRadioButton2Disabled();
        miVista.setjRadioButton3Disabled();
        if(!marca.toString().equals("< Seleccione una marca >") && !marca.toString().equals("No hay marcas disponibles")){
            miVista.setPanelTamañoEnable();
            Iterator<movil> moviles = miModelo.getStock().iterator();
            while (moviles.hasNext()){
                movil tempMovil = moviles.next();
                if(tempMovil.getPrecio()<=miModelo.getPrecio()){
                    if (tempMovil.getMarca().contains(marca.toString().substring(0, marca.toString().indexOf("(")))) {
                        if (tempMovil.getTamañoPantalla()<= 4) {
                            miVista.setjRadioButton1Enabled();
                        }
                        if (tempMovil.getTamañoPantalla()<=5 && tempMovil.getTamañoPantalla()>4){
                            miVista.setjRadioButton2Enabled();
                            }

                        if (tempMovil.getTamañoPantalla()<=6 && tempMovil.getTamañoPantalla()>5){
                            miVista.setjRadioButton3Enabled();
                            }
                        }                    

                    }

                }
            
            }
        else{
            miVista.setPanelTamañoDisabled();
            miModelo.setTamañoPantalla(null);
            miModelo.setColor(null);
        }
        
        }

    public void setColor(int value){
        miVista.clearErrorjTextLabel();
        switch(value){
            case 1:
                miModelo.setColor(miVista.getjButtonColor1().getBackground());
            case 2:
                miModelo.setColor(miVista.getjButtonColor2().getBackground());
            case 3:
                miModelo.setColor(miVista.getjButtonColor3().getBackground());
            case 4:
                miModelo.setColor(miVista.getjButtonColor4().getBackground());
            case 5:
                miModelo.setColor(miVista.getjButtonColor5().getBackground());
            case 6:
                miModelo.setColor(miVista.getjButtonColor6().getBackground());
        }
    }
    
    public void restart(){
        miVista.setjSlider1Value(400);
        setjSlider1Value();
    }
    
    public void comprar(){
        try{
            miModelo.getColor().toString();
            System.exit(0);
        }
        catch(NullPointerException npe){
            miVista.ErrorCompra();
        }
    }
    
}

    
