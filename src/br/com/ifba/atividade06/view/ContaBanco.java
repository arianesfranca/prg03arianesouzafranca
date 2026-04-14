/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06.view;

/**
 *
 * @author ariia
 */
public final class ContaBanco {
    //Criando atributos
     // Número da conta (público - pode ser acessado de qualquer lugar)
    public int numConta;
     // Tipo da conta (CC = Conta Corrente / CP = Conta Poupança)
    protected String tipo;
     // Nome do dono da conta (privado - só acessado por métodos)
    private String dono;
    // Saldo da conta
    private float saldo;
    // Status da conta (true = aberta / false = fechada)
    private boolean status;
    //Métodos personalizados 
     // Mostra o estado atual da conta
    public void estadoAtual(){
        
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
         
    }
    // Abre a conta com base no tipo
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);// ativa a conta
         // Define saldo inicial dependendo do tipo
        if ("CC".equals(t)){
            this.setSaldo(50);
        }else if ("CP".equals(t)) {
            this.setSaldo(150);
        }
    }
    // Fecha a conta se possível
    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada pois ainda tem dinheiro!");
        } else if (this.getSaldo() < 0){
            System.out.println("Conta não pode ser fechada pois tem débito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso");
        }
    }
    // Deposita um valor na conta
    public void depositar(float v){
        if (this.getStatus()) {
        this.setSaldo(this.getSaldo() + v);
        System.out.println("Déposito realizado na conta de" + this.getDono());
        } else {
            System.out.println("Impossivel depositar em uma conta fechada");
        }
    }
     // Realiza saque
    public void sacar(float v){
        if (this.getStatus()) { // verifica se a conta está ativa
            if (this.getSaldo() >= v) {  // verifica saldo suficiente
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                    System.out.println("Saldo insuficiente para saque");
                    }
        }  else {
        System.out.println("Impossivel sacar de uma conta fechada");
        }
    }
    // Cobra mensalidade da conta
    public void pagarMensal(){
        int v = 0;
        // Define valor da mensalidade conforme tipo
        if("CC".equals(this.getTipo())) {
            v = 12;
        } else if ("CP".equals(this.getTipo())) {
            v = 20;
        }
        // Desconta mensalidade se a conta estiver ativa
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            System.out.println("Impossivel pagar uma conta fechada!");
        }
    }
    
    
    //Metodos especiais 
   // Construtor (inicializa a conta fechada e com saldo 0)
    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }

     // ================= GETTERS E SETTERS =================
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
   
    
    
}
