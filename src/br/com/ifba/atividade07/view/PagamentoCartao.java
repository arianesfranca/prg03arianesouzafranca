/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

/**
 * Classe que representa um pagamento realizado com cartão.
 * Implementa a interface Pagamento.
 * 
 * @author ariia
 */
public class PagamentoCartao implements Pagamento {

    // Valor original da compra (imutável após ser definido)
    private final double valor;
    
    /**
     * Construtor da classe PagamentoCartao
     * @param valor Valor da compra
     */
    public PagamentoCartao(double valor) {
        this.valor = valor;
    }

    /**
     * Calcula o valor total com taxa de 5% para pagamento no cartão
     * @return valor final com acréscimo
     */
    @Override
    public double calcularTotal() {
        return valor * 1.05; // adiciona 5% de taxa
    }

    /**
     * Imprime o recibo do pagamento no console
     */
    @Override
    public void imprimirRecibo() {
        System.out.println("-----------RECIBO--------------");
        System.out.printf("Forma de pagamento: Cartão\n");
        System.out.printf("Valor original: R$ %.2f%n", valor);
        System.out.printf("Taxa aplicada: 5%%\n"); // %% para mostrar %
        System.out.printf("Valor final: R$ %.2f%n", calcularTotal());
        System.out.printf("-------------------------\n");
    }
    
}