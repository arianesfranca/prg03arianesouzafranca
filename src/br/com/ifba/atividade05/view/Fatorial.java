/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade05.view;

/**
 *
 * @author ariia
 */
public class Fatorial {
    //guarda número digitado por usuário 
    private int valor;
    //método que recebe e salva o num digitado 
    public void setValor(int n){
        this.valor = n;
    }
    //método que calcula e retorna o fatorial 
    public int getFatorial() {
        //começa de 1 pois é o elemento neutro da multiplicação
        int resultado = 1;
        //multiplica de 2 até o valor
        for (int i = 2; i <= valor; i++){
            resultado *= i;
        }
        //retorna o resultado calculado
        return resultado;
    }
    //metodo que monta e retorna a fórmula em texto 
    public String getFormula(){
        if (valor == 0 || valor == 1) return valor + "! = 1";
        
        StringBuilder formula = new StringBuilder(); //montar a formula
        for (int i = valor; i >= 1; i--) { //percorre o valor até 1
            formula.append(i);
            if (i > 1) formula.append(" x "); //adiciona x entre os numeros 
        }
        formula.append(" = ").append(getFatorial()); //adiciona o resultado no final 
        return formula.toString(); //retorna a fórmula completa
    }
}
