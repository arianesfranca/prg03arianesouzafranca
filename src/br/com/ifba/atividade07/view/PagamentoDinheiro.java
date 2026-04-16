/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

/**
 *
 * @author ariia
 */
public class PagamentoDinheiro implements Pagamento {
    
    private double valor; //valor original da  compra
    
    public PagamentoDinheiro(double valor){
        this.valor = valor;
    }

    @Override
    public double calculatTotal() {
        return valor * 0.90;
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("-----------RECIBO--------------");
        System.out.println("Forma de pagamento: Dinheiro");
        System.out.println("Valor original: R$ %.2f%n", valor);
        System.out.println("Desconto aplicado: 10%");
        System.out.println("Valor final: R$ %.2f%n", calcularTotal());
        System.out.println("-------------------------");
        
    }
    
    
}
