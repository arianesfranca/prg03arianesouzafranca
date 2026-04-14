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
       ContaBanco p1 = new ContaBanco ();
       p1.setNumConta(1111);
       p1.setDono("Jubileu");
       p1.abrirConta("CC");
       p1.estadoAtual();
       
   }
}
