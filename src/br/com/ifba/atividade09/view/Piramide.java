/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 *
 * @author ariia
 */
public class Piramide extends Forma3D {
    private double base;
    private double altura;

    public Piramide(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double obterArea() {
       double apotema = Math.sqrt((base / 2) * (base / 2) + altura * altura);
        return (base * base) + (2 * base * apotema);
    }

    @Override
    public double obterVolume() {
        return (base * base  * altura) / 3;
    }

    @Override
    public String toString() {
        return "Piramide com base " + base + "e altura " + altura;
    }
    
    
    
}
