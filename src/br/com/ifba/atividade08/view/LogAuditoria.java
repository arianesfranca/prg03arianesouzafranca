/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.view;
import java.time.LocalDateTime;

/**
 *
 * @author ariia
 */
public class LogAuditoria {

    LogAuditoria(Object object, Usuario aThis, String acao, LocalDateTime now, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     private Long id;
     private Usuario usuario;
     private String acao;
     private LocalDataTime dataHora;
     private String ip;
     
     public LogAuditoria(){}
     
     public LogAuditoria(Long id, Usuario usuario, String acao, LocalDataTime dataHora, String ip) {
        this.id = id;
        this.usuario = usuario;
        this.acao = acao;
        this.dataHora = dataHora;
        this.ip = ip;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDataTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDataTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
     @Override
    public String toString() {
        return "LogAuditoria{" +
               "id=" + id +
               ", usuario=" + usuario.getNomeUsuario() +
               ", acao='" + acao + '\'' +
               ", dataHora=" + dataHora +
               ", ip='" + ip + '\'' +
               '}';
    }

    private static class LocalDataTime {

        public LocalDataTime() {
        }
    }
}
