/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 * Representa uma Esfera.
 * @author ariia
 */
public class Esfera extends Forma3D {

    private double raio; // raio da esfera

    public Esfera(double raio) {
        this.raio = raio;
    }

    // Calcula a área da superfície: 4 × π × raio²
    @Override
    public double obterArea() {
        return 4 * Math.PI * raio * raio;
    }

    // Calcula o volume: (4/3) × π × raio³
    @Override
    public double obterVolume() {
        return (4.0 / 3.0) * Math.PI * raio * raio * raio;
    }

    // Retorna a descrição do objeto
    @Override
    public String toString() {
        return "Esfera com raio " + raio;
    }
}