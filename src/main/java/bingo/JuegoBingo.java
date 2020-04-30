/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class JuegoBingo {

    private Bombo bombo;
    private Carton carton;

    public JuegoBingo() {
        bombo = new Bombo();
        carton = new Carton();
    }

    // Mostrará el cartón, sacará una bola, la mostrará y dirá si la bola se encuentra o no en el cartón.
    // Después comprobará si se han realizado líneas o no, dentro del cual se confirma si hay bingo.
    public void jugar() {
        Scanner teclado = new Scanner(System.in);
        boolean terminar = false;
        do {
            System.out.println(this.carton.toString());
            int bolaSeleccionada = sacarBola();
            System.out.println("Ha salido la bola " + bolaSeleccionada);
            comprobarBola(bolaSeleccionada);
            if (comprobandoLineas()){
                // Entra si ha cantado bingo, terminando la partida aquí mismo.
                terminar = true;
                System.out.println("Gracias por jugar.");
            } else {
                // Sino, pide al usuario que escriba algo para continuar.
                System.out.println("Escriba algo para continuar:");
                teclado.nextLine();
            }
        } while (!terminar);
    }

    // Saca una bola.
    public int sacarBola() {
        return bombo.sacarBola();
    }

    // Comprueba que la bola esté en el cartón.
    public void comprobarBola(int bolaSeleccionada) {
        int[][] valoresCarton = carton.getValoresCarton();
        for (int x = 0; x < valoresCarton.length; x++) {
            for (int y = 0; y < valoresCarton[0].length; y++) {
                if (valoresCarton[x][y] == bolaSeleccionada) {
                    System.out.println("La bola " + bolaSeleccionada + " se encuentra en el cartón. ");
                    valoresCarton[x][y] = -1;
                }
            }
        }
    }

    // Comprueba que se hayan completado líneas al recorrer las 3 filas. Si las 3 filas dan correcto,
    // significará que no hay casillas que no hayan salido, y cantará bingo, terminando la partida.
    public boolean comprobandoLineas() {
        int[][] valoresCarton = this.carton.getValoresCarton();
        int contadorExtra = 0;
        for (int x = 0; x < valoresCarton.length; x++) {
            int contador = 0;
            for (int y = 0; y < valoresCarton[0].length; y++) {
                if (valoresCarton[x][y] == -1) {
                    contador++;
                }
            }
            if (contador == 5) {
                System.out.println("La línea " + (x + 1) + " está tachada.");
                contadorExtra++;
                if (contadorExtra == 3) {
                    System.out.println("¡Bingo! Se termina la partida.");
                    return true;
                }
            }
        }
        return false;
    }

}
