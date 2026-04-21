/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 * Representa um Triângulo.
 * @author ariia
 */
public class Triangulo extends Forma2D {

    private double base;   // base do triângulo
    private double altura; // altura do triângulo

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Calcula a área: (base × altura) / 2
    @Override
    public double obterArea() {
        return (base * altura) / 2;
    }

    // Retorna a descrição do objeto
    @Override
    public String toString() {
        return "Triangulo com base " + base + " e altura " + altura;
    }
}