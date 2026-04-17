package br.com.ifba.atividade07.view;

/**
 * Classe que representa o pagamento via Pix.
 * Implementa a interface Pagamento aplicando 2% de cashback,
 * ou seja, o cliente paga 2% a menos sobre o valor original.
 * @author ariia
 */
public class PagamentoPix implements Pagamento {

    // Valor original da compra informado pelo usuário
    private final double valor;

    /**
     * Construtor que recebe o valor da compra.
     * @param valor valor original da compra
     */
    public PagamentoPix(double valor) {
        this.valor = valor;
    }

    /**
     * Calcula o valor final aplicando 2% de cashback.
     * Exemplo: R$ 100,00 → R$ 98,00
     * @return valor com desconto de 2%
     */
    @Override
    public double calcularTotal() {
        return valor * 0.98;
    }

    /**
     * Exibe no console o recibo do pagamento via Pix.
     */
    @Override
    public void imprimirRecibo() {
        System.out.println("-----------RECIBO--------------");
        System.out.println("Forma de pagamento: Pix"); // corrigido: estava escrito "Cartão"
        System.out.printf("Valor original: R$ %.2f%n", valor);
        System.out.println("Cashback aplicado: 2%");
        System.out.printf("Valor final: R$ %.2f%n", calcularTotal());
        System.out.println("--------------------------------");
    }
}