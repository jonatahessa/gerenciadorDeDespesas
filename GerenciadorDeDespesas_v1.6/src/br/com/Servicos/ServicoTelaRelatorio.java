/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Servicos;

import br.com.Classes.Movimentacao;
import java.text.ParseException;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 *
 * @author jonat
 */
public class ServicoTelaRelatorio {

    ServicoMovimentacao servicoMovimentacao = new ServicoMovimentacao();

    public String mesVigente() {
        Calendar cal = Calendar.getInstance();
        int mes = cal.get(Calendar.MONTH);
        String mesVigente;
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
            default:
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

    public int converteMesSelecionado(String mes) {
        int mesNumerico = 0;
        if (mes.equalsIgnoreCase("Janeiro")) {
            mesNumerico = 0;
        } else if (mes.equalsIgnoreCase("Fevereiro")) {
            mesNumerico = 1;
        } else if (mes.equalsIgnoreCase("Março")) {
            mesNumerico = 2;
        } else if (mes.equalsIgnoreCase("Abril")) {
            mesNumerico = 3;
        } else if (mes.equalsIgnoreCase("Maio")) {
            mesNumerico = 4;
        } else if (mes.equalsIgnoreCase("Junho")) {
            mesNumerico = 5;
        } else if (mes.equalsIgnoreCase("Julho")) {
            mesNumerico = 6;
        } else if (mes.equalsIgnoreCase("Agosto")) {
            mesNumerico = 7;
        } else if (mes.equalsIgnoreCase("Setembro")) {
            mesNumerico = 8;
        } else if (mes.equalsIgnoreCase("Outubro")) {
            mesNumerico = 9;
        } else if (mes.equalsIgnoreCase("Novembro")) {
            mesNumerico = 10;
        } else if (mes.equalsIgnoreCase("Dezembro")) {
            mesNumerico = 11;
        } else {
            mesNumerico = 80;
        }

        return mesNumerico;
    }

    public int converteAnoSelecionado(String ano) {
        if (ano.equalsIgnoreCase("selecione")){
            return 0;
        }
        int anoNumerico = Integer.parseInt(ano);

        return anoNumerico;
    }

    public boolean validaMes(Movimentacao mov, String mesText) throws ParseException {
        Calendar dataMov = Calendar.getInstance();
        Date dataMovimentacao = servicoMovimentacao.converteData(mov);
        dataMov.setTime(dataMovimentacao);
        int mesMovimentacao = dataMov.get(MONTH);
        int mesCombo = converteMesSelecionado(mesText);
        if (mesCombo == 80){
            return true;
        }
        System.out.println(mesMovimentacao);
        System.out.println(mesCombo);
        

        return mesCombo == mesMovimentacao;

    }

    public boolean validaAno(Movimentacao mov, String anoText) throws ParseException {
        Calendar dataMov = Calendar.getInstance();
        Date dataMovimentacao = servicoMovimentacao.converteData(mov);
        dataMov.setTime(dataMovimentacao);
        int anoMovimentacao = dataMov.get(YEAR);
        int anoCombo = converteAnoSelecionado(anoText);
        System.out.println(anoMovimentacao);
        System.out.println(anoCombo);
        
        
        return anoCombo == anoMovimentacao;

    }

}
