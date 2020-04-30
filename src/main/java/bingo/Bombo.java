/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Bombo {

    private ArrayList<Integer> numerosElegidos;

    // Constructor
    public Bombo() {
        this.numerosElegidos = new ArrayList<Integer>();
    }

    // Este método vacía el Array de números que ya han salido 
    public void llenarBombo() {
        this.numerosElegidos = new ArrayList<Integer>();
    }

    // Sacará una bola del Bombo añadiéndola a la lista de bolas seleccionadas.
    // Saca una hasta que la que haya salido no esté en el array.
    public int sacarBola() {
        Random random = new Random();
        int bolaSeleccionada;
        do {
            bolaSeleccionada = random.nextInt(90) + 1;
        } while (this.numerosElegidos.contains(bolaSeleccionada));
        this.numerosElegidos.add(bolaSeleccionada);
        return bolaSeleccionada;
    }

    // Devuelve el número de bolas que quedan restantes en el Bombo
    public int cuantasBolasQuedan() {
        return 90 - this.numerosElegidos.size();
    }

    public ArrayList<Integer> getNumerosElegidos() {
        return numerosElegidos;
    }

    public void setNumerosElegidos(ArrayList<Integer> numerosElegidos) {
        this.numerosElegidos = numerosElegidos;
    }

    @Override
    public String toString() {
        return "Bombo{" + "numerosElegidos=" + numerosElegidos + '}';
    }
    
}
