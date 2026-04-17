package br.com.ifba.atividade07.view;

/**
 * Classe que representa o pagamento em dinheiro.
 * Implementa a interface Pagamento aplicando 10% de desconto
 * sobre o valor original da compra.
 * @author ariia
 */
public class PagamentoDinheiro implements Pagamento {

    // Valor original da compra informado pelo usuário
    private final double valor;

    /**
     * Construtor que recebe o valor da compra.
     * @param valor valor original da compra
     */
    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }

    /**
     * Calcula o valor final aplicando 10% de desconto.
     * Exemplo: R$ 100,00 → R$ 90,00
     * @return valor com desconto de 10%
     */
    @Override
    public double calcularTotal() {
        return valor * 0.90;
    }

    /**
     * Exibe no console o recibo do pagamento em dinheiro.
     */
    @Override
    public void imprimirRecibo() {
        System.out.println("-----------RECIBO--------------");
        System.out.println("Forma de pagamento: Dinheiro");
        System.out.printf("Valor original: R$ %.2f%n", valor);
        System.out.println("Desconto aplicado: 10%");
        System.out.printf("Valor final: R$ %.2f%n", calcularTotal());
        System.out.println("--------------------------------");
    }
}