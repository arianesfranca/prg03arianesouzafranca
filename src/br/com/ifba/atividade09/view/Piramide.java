/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 * Representa uma Pirâmide de base quadrada.
 * @author ariia
 */
public class Piramide extends Forma3D {

    private double base;   // lado da base quadrada
    private double altura; // altura da pirâmide

    public Piramide(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Calcula a área total: base² + (2 × base × apótema)
    @Override
    public double obterArea() {
        double apotema = Math.sqrt((base / 2) * (base / 2) + altura * altura);
        return (base * base) + (2 * base * apotema);
    }

    // Calcula o volume: (base² × altura) / 3
    @Override
    public double obterVolume() {
        return (base * base * altura) / 3;
    }

    // Retorna a descrição do objeto
    @Override
    public String toString() {
        return "Piramide com base " + base + " e altura " + altura; // adicionado espaço antes de "e"
    }
}