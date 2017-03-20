/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaMovilModelo;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import tiendaMovilControlador.TMControlador;
import tiendaMovilVista.TMVista;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alumno
 */
public class TMModelo {
    
    ComboBoxModel Marcas;
    int Precio;
    int []tamañoPantalla;
    Color color;
    ArrayList<movil> Stock;
    Object marcaSeleccionada;
    ArrayList<Color> disponible;
    Color JetBlack = new Color(0,0,0);
    Color Black = new Color(51,51,51);
    Color Silver = new Color(153,153,153);
    Color Gold = new Color(204,204,0);
    Color RoseGold = new Color(255,153,153);
    Color LightBlue = new Color (51,153,255);
    Color PakistanGreen = new Color (0,153,0);
    Color PlasticRed = new Color (255,0,51);
    Color Teal  =   new Color   (51,153,0);
    
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
    
    public TMModelo(int Precio,int []tamañoPantalla, Color color){
        disponible = new ArrayList<>();
        Stock = new ArrayList<>();
        Stock.add(new movil("Apple",JetBlack,5.5,909));
        Stock.add(new movil("Apple",Black,5.5,909));
        Stock.add(new movil("Apple",Silver,5.5,909));
        Stock.add(new movil("Apple",Gold,5.5,909));
        Stock.add(new movil("Apple",RoseGold,5.5,909));
        Stock.add(new movil("Apple",JetBlack,4.7,769));
        Stock.add(new movil("Apple",Black,4.7,769));
        Stock.add(new movil("Apple",Silver,4.7,769));
        Stock.add(new movil("Apple",Gold,4.7,769));
        Stock.add(new movil("Apple",RoseGold,4.7,769));
        Stock.add(new movil("Apple",JetBlack,4,489));
        Stock.add(new movil("Apple",Black,4,489));
        Stock.add(new movil("Apple",Silver,4,489));
        Stock.add(new movil("Apple",Gold,4,489));
        Stock.add(new movil("Apple",RoseGold,4,489));
        Stock.add(new movil("Samsung",Black,5.1,619));
        Stock.add(new movil("Samsung",Silver,5.1,619));
        Stock.add(new movil("Samsung",Gold,5.1,619));
        Stock.add(new movil("Samsung",RoseGold,5.1,619));
        Stock.add(new movil("Samsung",Black,5.5,718));
        Stock.add(new movil("Samsung",Silver,5.5,718));
        Stock.add(new movil("Samsung",Gold,5.5,718));
        Stock.add(new movil("Samsung",RoseGold,5.5,718));
        Stock.add(new movil("Samsung",LightBlue,5.5,718));
        Stock.add(new movil("Samsung",Black,5.1,325));
        Stock.add(new movil("Samsung",Silver,5.1,325));
        Stock.add(new movil("Samsung",RoseGold,5.1,325));
        Stock.add(new movil("Samsung",LightBlue,5.1,325));
        Stock.add(new movil("Samsung",PakistanGreen,5.1,325));
        Stock.add(new movil("LG",Black,5.5,549));
        Stock.add(new movil("LG",Silver,5.5,549));
        Stock.add(new movil("LG",Gold,5.5,549));
        Stock.add(new movil("LG",PlasticRed,5.5,549));
        Stock.add(new movil("LG",LightBlue,5.5,549));
        Stock.add(new movil("LG",PakistanGreen,5.5,549));
        Stock.add(new movil("LG",JetBlack,5.2,479));
        Stock.add(new movil("LG",Silver,5.2,479));
        Stock.add(new movil("LG",Gold,5.2,479));
        Stock.add(new movil("LG",PlasticRed,5.2,479));
        Stock.add(new movil("LG",LightBlue,5.2,479));
        Stock.add(new movil("LG",PakistanGreen,5.2,479));
        Stock.add(new movil("Sony",Black,3.5,270));
        Stock.add(new movil("Sony",Silver,3.5,270));
        Stock.add(new movil("Sony",Teal,3.5,270));
        Stock.add(new movil("Sony",PlasticRed,3.5,270));
        Stock.add(new movil("Sony",LightBlue,3.5,270));
        Stock.add(new movil("Huawey",JetBlack,3.8,374));
        Stock.add(new movil("Huawey",Black,3.8,374));
        Stock.add(new movil("Huawey",Teal,3.8,374));
        Stock.add(new movil("Huawey",PlasticRed,3.8,374));
        Stock.add(new movil("Huawey",LightBlue,3.8,374));
        Stock.add(new movil("Huawey",PakistanGreen,3.8,374));
        this.Precio = Precio;
        Iterator<movil> moviles = Stock.iterator();
        while (moviles.hasNext()){
            movil tempMovil = moviles.next();
            if (tempMovil.getPrecio()<=this.Precio){
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
        int n=1;
        for(listado l: listado.values()){
            if(l.getRecuento()!=0){
                n++;
            }
        }
        String modelo[];
        modelo = new String [n];
        modelo[0] = "< Seleccione una marca >";
        int i=0;
        for(listado l: listado.values()){
            if (l.getRecuento()>0){
                i++;
                modelo[i] = String.format("%s(%d)\n",l,l.getRecuento());
            }
        }
        this.Marcas = new DefaultComboBoxModel(modelo);
        System.out.println(this.Marcas.toString());
        this.tamañoPantalla = tamañoPantalla;
        this.color = color;
        
        
                
    }
    
    public void setTamañoPantalla(int []tamaño){
        tamañoPantalla = tamaño;
    }
  
    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public ComboBoxModel getMarcas() {
        return Marcas;
    }

    public void setMarcas() {
        for(listado l: listado.values()){
            l.setRecuento(0);
        }
        int n = 1;
        Iterator<movil> moviles = Stock.iterator();
        while (moviles.hasNext()){
            movil tempMovil = moviles.next();
            if (tempMovil.getPrecio()<=this.Precio){
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
        Marcas = new DefaultComboBoxModel(modelo);
        marcaSeleccionada = Object.class.cast("< Seleccione una marca >");
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<movil> getStock() {
        return Stock;
    }

    public void setStock(ArrayList<movil> Stock) {
        this.Stock = Stock;
    }

    public Object getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Object marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }
    
    public ArrayList<Color> getDisponible(){
        return disponible;
    }
    
    public void setDisponible(){
        Iterator<movil> moviles = Stock.iterator();
        while (moviles.hasNext()){
            movil tempMovil = moviles.next();
            if(tempMovil.getPrecio()<=Precio){
                if (tempMovil.getMarca().contains(marcaSeleccionada.toString().substring(0, marcaSeleccionada.toString().indexOf("(")))) {
                    if (tamañoPantalla[0]<= tempMovil.getTamañoPantalla()) {
                        if (tempMovil.getTamañoPantalla()<= tamañoPantalla[1]) {
                            disponible.add(tempMovil.getColor());
                        }
                    }
                }
                
            }
            
        }
        
    }
    
}
