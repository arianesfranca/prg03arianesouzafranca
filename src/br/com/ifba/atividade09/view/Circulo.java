/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 * Representa um Círculo.
 * @author ariia
 */
public class Circulo extends Forma2D {

    private double raio; // raio do círculo

    public Circulo(double raio) {
        this.raio = raio;
    }

    // Calcula a área: π × raio²
    @Override
    public double obterArea() {
        return Math.PI * raio * raio;
    }

    // Retorna a descrição do objeto
    @Override
    public String toString() {
        return "Circulo com raio " + raio;
    }
}