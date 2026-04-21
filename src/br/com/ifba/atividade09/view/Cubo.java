/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 * Representa um Cubo.
 * @author ariia
 */
public class Cubo extends Forma3D {

    private double lado; // lado do cubo

    public Cubo(double lado) {
        this.lado = lado;
    }

    // Calcula a área da superfície: 6 × lado²
    @Override
    public double obterArea() {
        return 6 * lado * lado;
    }

    // Calcula o volume: lado³
    @Override
    public double obterVolume() {
        return lado * lado * lado;
    }

    // Retorna a descrição do objeto
    @Override
    public String toString() {
        return "Cubo com lado " + lado; // adicionado espaço antes do valor
    }
}