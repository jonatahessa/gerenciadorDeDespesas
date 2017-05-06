package br.com.Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jonata.hmoliveira
 */
public class Fila {

    // atributos
    private final Object[] dados;
    private int inicio;
    private int fim;

    // construtor
    public Fila() {
        dados = new Object[50];
        inicio = 0;
        fim = 0;

    }

    public boolean isFull() {
        return (fim + 1) % dados.length == inicio;
    }

    public boolean isEmpty() {
        return (inicio == fim);
    }

    public void enqueue(Object x) {
        if (!isFull()) {
            dados[fim] = x;
            fim++;
            if (fim == dados.length) {
                fim = 0;
            }
        }
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object x = dados[inicio];
            inicio++;
            if (inicio == dados.length) {
                inicio = 0;
            }
            return x;
        }
        return null;
    }

    public Object furarFila(Object x) {
        if (!isFull()) {
                if (inicio == 0) {
                    for (int j = dados.length - 1; j > 0; j--) {
                        if (dados[j] == null) {
                            dados[j] = x;
                            inicio = j;
                            return x;
                        }
                    }

                } else {
                    inicio--;
                    dados[inicio] = x;
                    return x;
                }
            }
        
        return null;
    }
}
