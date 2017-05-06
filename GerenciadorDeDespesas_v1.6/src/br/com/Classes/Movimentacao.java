/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Classes;

import java.math.BigDecimal;

/**
 *
 * @author jonat
 */
public class Movimentacao {

    private int idMovimentacao;
    private String tipoMovimentacao;
    private String nomeMovimentacao;
    private String proprietarioDaMovimentacao;
    private String valorMovimentacao;
    private String dataMovimentacao;
    private String numeroDeParcelas;
    private String statusDespesa;
    private String movimentacaoFixa;
    private String movimentacaoEnabled;

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getNomeMovimentacao() {
        return nomeMovimentacao;
    }

    public void setNomeMovimentacao(String nomeMovimentacao) {
        this.nomeMovimentacao = nomeMovimentacao;
    }

    public String getProprietarioDaMovimentacao() {
        return proprietarioDaMovimentacao;
    }

    public void setProprietarioDaMovimentacao(String proprietarioDaMovimentacao) {
        this.proprietarioDaMovimentacao = proprietarioDaMovimentacao;
    }

    public String getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(String valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(String numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public String getStatusDespesa() {
        return statusDespesa;
    }

    public void setStatusDespesa(String statusDespesa) {
        this.statusDespesa = statusDespesa;

    }

    public String getMovimentacaoFixa() {
        return movimentacaoFixa;
    }

    public void setMovimentacaoFixa(String movimentacaoFixa) {
        this.movimentacaoFixa = movimentacaoFixa;
    }

    public String getMovimentacaoEnabled() {
        return movimentacaoEnabled;
    }

    public void setMovimentacaoEnabled(String movimentacaoEnabled) {
        this.movimentacaoEnabled = movimentacaoEnabled;
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    

}
