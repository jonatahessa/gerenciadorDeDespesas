/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Exceptions;
public class MovimentacaoException extends Exception {

    /**
     * Construtor de exceções que permite informar uma mensagem *
     */
    public MovimentacaoException(String message) {
        super(message);
    }
}
