/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Servicos;

import java.util.ArrayList;
import java.util.List;
import br.com.Classes.Movimentacao;
import br.com.Daos.DaoMovimentacao;
import br.com.Exceptions.MovimentacaoException;
import br.com.Exceptions.DataSourceException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 *
 * @author jonat
 */
public class ServicoMovimentacao {

    ServicoTelaInicial servicoTelaInicial = new ServicoTelaInicial();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    static int idMovimentacao = 1;
    static java.util.List<Movimentacao> listaMovimentacao = new ArrayList<>();

    public static List<Movimentacao> getListaMovimentacao() {
        return listaMovimentacao;
    }

    public static void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
        ServicoMovimentacao.listaMovimentacao = listaMovimentacao;
    }

    public static void removerMovimentacao(int id)
            throws MovimentacaoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão da despesa informada
            DaoMovimentacao.deletar(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public void adicionarMovimentacao(Movimentacao movimentacao) throws DataSourceException {
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoMovimentacao.inserir(movimentacao);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public void editarMovimentacao(int id, Movimentacao movimentacao) throws DataSourceException {
        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoMovimentacao.alterar(movimentacao, id);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um produto pela palavra na fonte de dados
    public static List<Movimentacao> procurarMovimentacao(String palavra)
            throws MovimentacaoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (palavra == null || palavra.equals("")) {
                return DaoMovimentacao.listar();
            } else {
                return DaoMovimentacao.pesquisar(palavra);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o produto com ID informado do banco de dados
    public static Movimentacao obterMovimentacao(Integer id)
            throws MovimentacaoException, DataSourceException {
        try {
            //Retorna o produto obtido com o DAO
            return DaoMovimentacao.retornarMovimentacao(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public boolean verificarNomeMovementacao(String nomeMovimentacao) {
        boolean verificarNomeMovimentacao = true;
        if (nomeMovimentacao == null || nomeMovimentacao.equals("")) {
            verificarNomeMovimentacao = false;
        }
        return verificarNomeMovimentacao;
    }

    public boolean verificarValorMovimentacao(String valorMovimentacao) {
        boolean verificarValorMovimentacao = true;
        if (valorMovimentacao == null || valorMovimentacao.equalsIgnoreCase("")) {
            verificarValorMovimentacao = false;
        }
        return verificarValorMovimentacao;
    }

    public boolean verificarDataMovimentacao(String dataMovimentacao) {
        boolean verificarDataMovimentacao = true;
        if (dataMovimentacao.equals("  /  /    ") || dataMovimentacao.equals("  /  /     ")) {
            verificarDataMovimentacao = false;
        }
        return verificarDataMovimentacao;
    }

    public boolean verificarNumeroDeParcelas(String numeroDeParcelas) {
        boolean verificarNumeroDeParcelas = true;
        if (numeroDeParcelas == null || numeroDeParcelas.equals("")) {
            verificarNumeroDeParcelas = false;
        }
        return verificarNumeroDeParcelas;
    }

    public int retornoNumeroDeParcelas(Movimentacao mov) {
        int numeroDeParcelas = Integer.parseInt(mov.getNumeroDeParcelas());

        return numeroDeParcelas;
    }

    public Date converteData(Movimentacao mov) throws ParseException {
        Date data = formato.parse(mov.getDataMovimentacao());

        return data;
    }

    public void parcelarMovimentacao(Movimentacao mov) throws Exception {
        String nomeDaMovimentacao = mov.getNomeMovimentacao();
        int contaMes = 0, cont = 1;
        int parcelas = retornoNumeroDeParcelas(mov);
        String valorParcela = operacaoDivisao(mov.getValorMovimentacao(), mov.getNumeroDeParcelas());
        Date dataDaMovimentacao = converteData(mov);
        Calendar dataConvert = Calendar.getInstance();
        dataConvert.setTime(dataDaMovimentacao);
        int mes = dataConvert.get(Calendar.MONTH);
        int ano = dataConvert.get(Calendar.YEAR);
        int decorreParcelas = mes + parcelas;

        for (int i = mes; i < decorreParcelas;) {
            mov.setValorMovimentacao(valorParcela);
            if (cont == 1) {
                mov.setNomeMovimentacao(nomeDaMovimentacao);
            } else {
                mov.setNomeMovimentacao(nomeDaMovimentacao + " (parcela " + cont + ")");
            }
            System.out.println(cont);
            dataConvert.set(MONTH, i);
            Date dataFinal = dataConvert.getTime();
            mov.setDataMovimentacao(formato.format(dataFinal));
            adicionarMovimentacao(mov);
            contaMes++;
            cont++;
            if (i == 11) {
                ano++;
                dataConvert.set(YEAR, ano);
                i = 0;
            } else {
                i++;
            }
            if (contaMes == decorreParcelas) {
                break;
            }
        }
    }

    public void movimentacaoFixa(Movimentacao mov) throws Exception {
        int contaMes = 0, cont = 1;
        Date dataDaMovimentacao = converteData(mov);
        Calendar dataConvert = Calendar.getInstance();
        dataConvert.setTime(dataDaMovimentacao);
        int mes = dataConvert.get(Calendar.MONTH);
        int ano = dataConvert.get(Calendar.YEAR);

        for (int i = mes; i < 12;) {
            System.out.println(cont);
            dataConvert.set(MONTH, i);
            Date dataFinal = dataConvert.getTime();
            mov.setDataMovimentacao(formato.format(dataFinal));
            adicionarMovimentacao(mov);
            contaMes++;
            cont++;
            if (i == 11) {
                ano++;
                dataConvert.set(YEAR, ano);
                i = 0;
            } else {
                i++;
            }
            if (contaMes == 12) {
                break;
            }
        }
    }

    public String operacaoDivisao(String valorDespesa, String numeroDeParcelas) throws Exception {
        BigDecimal valorRecebido = new BigDecimal(valorDespesa);
        BigDecimal parcelas = new BigDecimal(numeroDeParcelas);
        BigDecimal valorResultado = valorRecebido.divide(parcelas);

        return valorResultado.toString();

    }

    
}
