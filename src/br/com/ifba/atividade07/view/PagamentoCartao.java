/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

/**
 *
 * @author ariia
 */
public class PagamentoCartao implements Pagamento {

    private double valor;
    
    public PagamentoCartao(double valor) {
        this.valor = valor;
    }
    @Override
    public double calcularTotal() {
        return valor * 1.05;
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("-----------RECIBO--------------");
        System.out.println("Forma de pagamento: Cartão");
        System.out.println("Valor original: R$ %.2f%n", valor);
        System.out.println("Taxa aplicada: 5%");
        System.out.println("Valor final: R$ %.2f%n", calcularTotal());
        System.out.println("-------------------------");
    }
    
}
