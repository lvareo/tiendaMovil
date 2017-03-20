/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaMovilModelo;

import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class movil {
    
    private String Marca;
    private Color color;
    private double tamañoPantalla;
    private int precio;
    
    public movil(String Marca, Color color, double tamañoPantalla, int precio){
        this.Marca = Marca;
        this.color = color;
        this.precio = precio;
        this.tamañoPantalla = tamañoPantalla;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(double tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
