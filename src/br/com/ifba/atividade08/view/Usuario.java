/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.view;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author ariia
 */
public class Usuario {
    
    private Long id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private boolean ativo;
    
    public Usuario(){}
    
    public Usuario(Long id, PerfilUsuario pirfil, String nomeUsuario, String email, String senha, Boolean ativo){
        this.id = id;
        this.perfil = perfil;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    
    }
    
    public LogAuditoria logar(String senhaInformada){
        String acao;
        if(this.senha.equals(senhaInformada)) {
            this.ultimoLogin = LocalDateTime.now();
            acao = "LOGIN REALIZADO COM SUCESSO";
        } else {
            acao = "TENTATIVA DE LOGIN COM SENHA INCORRETA";
        }
        
        return new LogAuditoria(null, this, acao, LocalDateTime.now(), "127.0..1");
    }
    
    public Sessao cariarSessao() {
        String token = UUID.randomUUID().toString();
        return new Sessao(null, this, token);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nomeUsuario='" + nomeUsuario + '\'' +
               ", email='" + email + '\'' +
               ", ativo=" + ativo +
               ", ultimoLogin=" + ultimoLogin +
               ", perfil=" + perfil +
               '}';
    } 
    }
    
   

