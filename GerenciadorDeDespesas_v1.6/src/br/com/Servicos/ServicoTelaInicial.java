/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Servicos;

import br.com.Classes.Fila;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 *
 * @author jonat
 */
public class ServicoTelaInicial {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public String mesVigente() {
        Calendar cal = Calendar.getInstance();
        int mes = cal.get(Calendar.MONTH);
        String mesVigente = null;
        switch (mes) {
            case 0:
                mesVigente = "Janeiro";
                break;
            case 1:
                mesVigente = "Fevereiro";
                break;
            case 2:
                mesVigente = "Março";
                break;
            case 3:
                mesVigente = "Abril";
                break;
            case 4:
                mesVigente = "Maio";
                break;
            case 5:
                mesVigente = "Junho";
                break;
            case 6:
                mesVigente = "Julho";
                break;
            case 7:
                mesVigente = "Agosto";
                break;
            case 8:
                mesVigente = "Setembro";
                break;
            case 9:
                mesVigente = "Outubro";
                break;
            case 10:
                mesVigente = "Novembro";
                break;
            case 11:
                mesVigente = "Dezembro";
                break;
        }
        return mesVigente;
    }

    public String anoVigente() {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        String anoVigente;
        anoVigente = Integer.toString(ano);

        return anoVigente;
    }

    public int importar(int id) {

        return id;
    }

    public float conversaoValor(String valor) throws Exception {
        Fila fila = new Fila();
        float resultado;
        String palavraConvertida;
        int cont = valor.length() - 1;
        StringBuilder convert = new StringBuilder(cont);
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) == ',') {
                fila.enqueue('.');
                i++;
            }
            fila.enqueue(valor.charAt(i));
        }

        for (int i = 0; i < valor.length(); i++) {
            char x = (char) fila.dequeue();
            convert.append(x);

        }
        palavraConvertida = convert.toString();
        resultado = Float.parseFloat(palavraConvertida);

        return resultado;
    }

    public String converteMes(String mesRecebido) {
        if (mesRecebido.equalsIgnoreCase("Janeiro")) {
            return "0";
        } else if (mesRecebido.equalsIgnoreCase("Fevereiro")) {
            return "1";
        } else if (mesRecebido.equalsIgnoreCase("Março")) {
            return "2";
        } else if (mesRecebido.equalsIgnoreCase("Abril")) {
            return "3";
        } else if (mesRecebido.equalsIgnoreCase("Maio")) {
            return "4";
        } else if (mesRecebido.equalsIgnoreCase("Junho")) {
            return "5";
        } else if (mesRecebido.equalsIgnoreCase("Julho")) {
            return "6";
        } else if (mesRecebido.equalsIgnoreCase("Agosto")) {
            return "7";
        } else if (mesRecebido.equalsIgnoreCase("Setembro")) {
            return "8";
        } else if (mesRecebido.equalsIgnoreCase("Outubro")) {
            return "9";
        } else if (mesRecebido.equalsIgnoreCase("Novembro")) {
            return "10";
        } else if (mesRecebido.equalsIgnoreCase("Dezembro")) {
            return "11";

        }
        return null;
    }

    public boolean verificaMesTabela(String recebeDataMovimentacao, String dataSelecionada) throws ParseException {
        String mes = converteMes(dataSelecionada);
        int mesConvertido = Integer.parseInt(mes);
        Date dataRecebida = formato.parse(recebeDataMovimentacao);
        Calendar dataMovimentacao = Calendar.getInstance();
        dataMovimentacao.setTime(dataRecebida);
        int mesRecebido = dataMovimentacao.get(Calendar.MONTH);
        Calendar dataEscolhida = Calendar.getInstance();
        dataEscolhida.set(MONTH, mesConvertido);
        int mesSelecionado = dataEscolhida.get(Calendar.MONTH);
        System.out.println(mesRecebido + " " + mesSelecionado);

        return mesRecebido == mesSelecionado;
    }

    public boolean verificaAnoTabela(String recebeDataMovimentacao, String recebeDataSelecionada) throws ParseException {
        int converte = Integer.parseInt(recebeDataSelecionada);
        Date dataRecebida1 = formato.parse(recebeDataMovimentacao);
        Calendar dataMovimentacao = Calendar.getInstance();
        dataMovimentacao.setTime(dataRecebida1);
        int anoRecebido = dataMovimentacao.get(Calendar.YEAR);
        Calendar dataEscolhida = Calendar.getInstance();
        dataEscolhida.set(YEAR, converte);
        int anoSelecionado = dataEscolhida.get(Calendar.YEAR);

        return anoRecebido == anoSelecionado;
    }

}
