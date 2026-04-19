/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.view;

import java.util.Arrays;

/**
 *
 * @author ariia
 */
public class Main {
    public static void main(String[] args) {

        // 1. Criar perfil com permissoes
        PerfilUsuario perfil = new PerfilUsuario(
            1L,
            "Administrador",
            Arrays.asList("CRIAR_USUARIO", "EDITAR_USUARIO", "DELETAR_USUARIO")
        );
        System.out.println("=== PERFIL ===");
        System.out.println(perfil);

        // 2. Criar usuario e associar ao perfil
        Usuario usuario = new Usuario(
            1L, perfil, "joao.silva",
            "joao@email.com", "senha123", true
        );
        System.out.println("\n=== USUARIO ===");
        System.out.println(usuario);

        // 3. Testar login correto e gerar LogAuditoria
        LogAuditoria log1 = usuario.logar("senha123");
        System.out.println("\n=== LOG DE AUDITORIA (login correto) ===");
        System.out.println(log1);

        // 4. Testar login incorreto e gerar LogAuditoria
        LogAuditoria log2 = usuario.logar("senhaErrada");
        System.out.println("\n=== LOG DE AUDITORIA (login incorreto) ===");
        System.out.println(log2);

        // 5. Criar sessao para o usuario
        Sessao sessao = usuario.criarSessao();
        System.out.println("\n=== SESSAO ===");
        System.out.println(sessao);
    }
}
