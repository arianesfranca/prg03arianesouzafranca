/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 *
 * @author ariia
 */
public class Main {
    public static void main(String[] args){
    
        Forma[] formas = new Forma[6];
        
        formas[0] = new Circulo(5);
        formas[1] = new Quadrado(4);
        formas[2] = new Triangulo(3, 6);
        formas[3] = new Esfera(7);
        formas[4] = new Cubo(3);
        formas[5] = new Piramide(4, 9);
        
        for (Forma f : formas) {
            System.out.println("---------------------------");
            System.out.println(f.toString());
            
            if (f instanceof Forma2D) {
                Forma2D f2d = (Forma2D) f;
                System.out.printf("Área: %.2f%n", f2d.obterArea());
               
            } else if (f instanceof Forma3D) {
                Forma3D f3d = (Forma3D) f;
                System.out.printf("Área: %.2f%n\", f3d.obterArea()");
                System.out.printf("Volume: %.2f%n", f3d.obterVolume());
            }
        }   
    }
}
