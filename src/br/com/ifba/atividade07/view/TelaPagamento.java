package br.com.ifba.atividade07.view;

import javax.swing.*;
import java.awt.*;

/**
 * Tela principal do sistema de pagamentos.
 * Exibe uma janela onde o usuário escolhe o tipo de pagamento,
 * informa o valor e visualiza o recibo gerado.
 * @author ariia
 */
public class TelaPagamento extends JFrame {

    // Componente para o usuário escolher o tipo de pagamento (Dinheiro, Cartão ou Pix)
    private JComboBox<String> comboPagamento;

    // Campo onde o usuário digita o valor da compra
    private JTextField campoValor;

    // Área de texto onde o recibo será exibido
    private JTextArea areaRecibo;

    // Botão que dispara o cálculo e exibe o recibo
    private JButton btnCalcular;

    /**
     * Construtor: monta a janela chamando os métodos de configuração.
     */
    public TelaPagamento() {
        configurarJanela();
        inicializarComponentes();
    }

    /**
     * Define as propriedades básicas da janela:
     * título, tamanho, comportamento ao fechar e layout.
     */
    private void configurarJanela() {
        setTitle("Sistema de Pagamentos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerra o programa ao fechar
        setLocationRelativeTo(null); // centraliza a janela na tela
        setLayout(new BorderLayout(10, 10));
    }

    /**
     * Cria e posiciona todos os componentes visuais da tela.
     */
    private void inicializarComponentes() {

        // Painel superior com grade de 3 linhas e 2 colunas para organizar os campos
        JPanel painelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        // Linha 1: label + combo de tipo de pagamento
        painelEntrada.add(new JLabel("Tipo de pagamento:"));
        comboPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão", "Pix"});
        painelEntrada.add(comboPagamento);

        // Linha 2: label + campo de valor
        painelEntrada.add(new JLabel("Valor da compra (R$):"));
        campoValor = new JTextField();
        painelEntrada.add(campoValor);

        // Linha 3: espaço vazio + botão calcular
        btnCalcular = new JButton("Calcular e Exibir Recibo");
        painelEntrada.add(new JLabel()); // célula vazia para alinhar o botão à direita
        painelEntrada.add(btnCalcular);

        // Adiciona o painel de entrada na parte superior da janela
        add(painelEntrada, BorderLayout.NORTH);

        // Área de texto para exibir o recibo (não editável pelo usuário)
        areaRecibo = new JTextArea();
        areaRecibo.setEditable(false);
        areaRecibo.setFont(new Font("Monospaced", Font.PLAIN, 13)); // fonte mono para alinhar o recibo
        areaRecibo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Adiciona a área de recibo com barra de rolagem no centro da janela
        add(new JScrollPane(areaRecibo), BorderLayout.CENTER);

        // Quando o botão for clicado, chama o método processarPagamento()
        btnCalcular.addActionListener(e -> processarPagamento());
    }

    /**
     * Lê os dados informados pelo usuário, cria o objeto de pagamento
     * correto e exibe o recibo na tela.
     */
    private void processarPagamento() {
        try {
            // Lê o valor digitado, substituindo vírgula por ponto para aceitar ambos os formatos
            double valor = Double.parseDouble(campoValor.getText().replace(",", "."));

            // Valida se o valor é positivo
            if (valor <= 0) {
                JOptionPane.showMessageDialog(this,
                    "Digite um valor maior que zero.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Descobre qual tipo de pagamento foi selecionado no combo
            String tipoPagamento = (String) comboPagamento.getSelectedItem();

            // Cria o objeto correto de forma dinâmica (polimorfismo)
            Pagamento pagamento = criarPagamento(tipoPagamento, valor);

            // Exibe o recibo na área de texto da tela
            areaRecibo.setText(gerarTextoRecibo(pagamento, tipoPagamento, valor));

            // Também imprime o recibo no console
            pagamento.imprimirRecibo();

        } catch (NumberFormatException ex) {
            // Exibe mensagem de erro se o usuário digitou algo que não é número
            JOptionPane.showMessageDialog(this,
                "Valor inválido! Use apenas números.", "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cria e retorna o objeto de pagamento correto conforme o tipo escolhido.
     * Aplica o conceito de polimorfismo: todos retornam a interface Pagamento.
     *
     * @param tipo  tipo de pagamento selecionado
     * @param valor valor original da compra
     * @return objeto que implementa a interface Pagamento
     */
    private Pagamento criarPagamento(String tipo, double valor) {
        switch (tipo) {
            case "Dinheiro" -> { return new PagamentoDinheiro(valor); }
            case "Cartão"   -> { return new PagamentoCartao(valor); }
            case "Pix"      -> { return (Pagamento) new PagamentoPix(valor); }
            default -> throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
    }

    /**
     * Monta e retorna o texto formatado do recibo para exibição na tela.
     *
     * @param pagamento     objeto com as regras do tipo de pagamento
     * @param tipo          nome do tipo de pagamento
     * @param valorOriginal valor digitado pelo usuário antes de calcular
     * @return texto completo do recibo
     */
    private String gerarTextoRecibo(Pagamento pagamento, String tipo, double valorOriginal) {
        StringBuilder sb = new StringBuilder();

        sb.append("===========================\n");
        sb.append("         RECIBO\n");
        sb.append("===========================\n");
        sb.append("Forma de pagamento: ").append(tipo).append("\n");
        sb.append(String.format("Valor original:  R$ %.2f%n", valorOriginal));

        // Exibe a regra aplicada conforme o tipo de pagamento
        switch (tipo) {
            case "Dinheiro" -> sb.append("Desconto aplicado: 10%\n");
            case "Cartão"   -> sb.append("Taxa aplicada:      5%\n");
            case "Pix"      -> sb.append("Cashback aplicado:  2%\n");
        }

        // Chama calcularTotal() da interface — cada classe aplica sua própria regra
        sb.append(String.format("Valor final:     R$ %.2f%n", pagamento.calcularTotal()));
        sb.append("===========================");

        return sb.toString();
    }

    /**
     * Ponto de entrada do programa.
     * Usa invokeLater para garantir que a janela seja criada
     * na thread correta do Swing.
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPagamento().setVisible(true));
    }
}