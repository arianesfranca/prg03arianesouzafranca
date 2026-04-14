/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06.view;

/**
 *
 * @author ariia
 */
public class Main {
   public static void main(String[] args) {
        // Cria um objeto (instância) da classe ContaBanco
       ContaBanco p1 = new ContaBanco ();
        // Define o número da conta
       p1.setNumConta(1234);
        // Define o nome do dono da conta
       p1.setDono("Perolina");
        // Abre a conta do tipo CC (Conta Corrente)
       // Isso também ativa a conta e define saldo inicial (50)
       p1.abrirConta("CC");
        // Exibe todas as informações da conta
       p1.estadoAtual();
       
   }
}
