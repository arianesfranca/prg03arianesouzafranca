/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

/**
 *
 * @author ariia
 */
public class PagamentoPix {
    
    private final double valor;
    
    public PagamentoPix(double valor) {
        this.valor = valor;
    }
    
    public double calcularTotal() {
        return valor * 0.98;
    }

    public void imprimirRecibo() {
        System.out.println("-----------RECIBO--------------");
        System.out.printf("Forma de pagamento: Cartão");
        System.out.printf("Valor original: R$ %.2f%n", valor);
        System.out.printf("Cashback aplicado: 2%%");
        System.out.printf("Valor final: R$ %.2f%n", calcularTotal());
        System.out.printf("-------------------------");
    }
}
