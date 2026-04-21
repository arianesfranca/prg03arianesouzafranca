/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 * Representa um Quadrado.
 * @author ariia
 */
public class Quadrado extends Forma2D {

    private double lado; // lado do quadrado

    public Quadrado(double lado) {
        this.lado = lado;
    }

    // Calcula a área: lado²
    @Override
    public double obterArea() {
        return lado * lado;
    }

    // Retorna a descrição do objeto
    @Override
    public String toString() {
        return "Quadrado com lado " + lado; // adicionado espaço antes do valor
    }
}