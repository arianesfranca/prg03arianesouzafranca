/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

import javax.swing.*;
import java.awt.*;

/**
 * Tela principal do sistema de pagamentos.
 * @author ariia
 */
public class TelaPagamento extends JFrame {

    private JComboBox<String> comboPagamento;
    private JTextField campoValor;
    private JTextArea areaRecibo;
    private JButton btnCalcular;

    public TelaPagamento() {
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setTitle("Sistema de Pagamentos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        JPanel painelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        painelEntrada.add(new JLabel("Tipo de pagamento:"));
        comboPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão", "Pix"});
        painelEntrada.add(comboPagamento);

        painelEntrada.add(new JLabel("Valor da compra (R$):"));
        campoValor = new JTextField();
        painelEntrada.add(campoValor);

        btnCalcular = new JButton("Calcular e Exibir Recibo");
        painelEntrada.add(new JLabel());
        painelEntrada.add(btnCalcular);

        add(painelEntrada, BorderLayout.NORTH);

        areaRecibo = new JTextArea();
        areaRecibo.setEditable(false);
        areaRecibo.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaRecibo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(new JScrollPane(areaRecibo), BorderLayout.CENTER);

        btnCalcular.addActionListener(e -> processarPagamento());
    }

    private void processarPagamento() {
        try {
            double valor = Double.parseDouble(campoValor.getText().replace(",", "."));

            if (valor <= 0) {
                JOptionPane.showMessageDialog(this,
                    "Digite um valor maior que zero.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String tipoPagamento = (String) comboPagamento.getSelectedItem();
            Pagamento pagamento = criarPagamento(tipoPagamento, valor);

            areaRecibo.setText(gerarTextoRecibo(pagamento, tipoPagamento, valor));
            pagamento.imprimirRecibo();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Valor inválido! Use apenas números.", "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private Pagamento criarPagamento(String tipo, double valor) {
        switch (tipo) {
            case "Dinheiro" -> {
                return new PagamentoDinheiro(valor);
            }
            case "Cartão" -> {
                return new PagamentoCartao(valor);
            }
            case "Pix" -> {
                return (Pagamento) new PagamentoPix(valor);
            }
            default -> throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
    }

    private String gerarTextoRecibo(Pagamento pagamento, String tipo, double valorOriginal) {
        StringBuilder sb = new StringBuilder();
        sb.append("===========================\n");
        sb.append("         RECIBO\n");
        sb.append("===========================\n");
        sb.append("Forma de pagamento: ").append(tipo).append("\n");
        sb.append(String.format("Valor original:  R$ %.2f%n", valorOriginal));

        switch (tipo) {
            case "Dinheiro" -> sb.append("Desconto aplicado: 10%\n");
            case "Cartão" -> sb.append("Taxa aplicada:      5%\n");
            case "Pix" -> sb.append("Cashback aplicado:  2%\n");
        }

        sb.append(String.format("Valor final:     R$ %.2f%n", pagamento.calcularTotal()));
        sb.append("===========================");
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPagamento().setVisible(true));
    }
}