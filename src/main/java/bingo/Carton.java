/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Carton {

    private int[][] valoresCarton;

    public Carton() {
        Random random = new Random();
        boolean repetir = true;
        this.valoresCarton = new int[3][9];

        // Redundante
        for (int[] fila : this.valoresCarton) {
            Arrays.fill(fila, 0);
        }

        ArrayList<Integer> indicesPorElegir = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        int[] indicesElegidos = new int[9];

        for (int i = 0; i < 9; i++) {
            indicesElegidos[i] = random.nextInt(indicesPorElegir.size());
            indicesPorElegir.remove(indicesElegidos[i]);
        }

        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                int fila = random.nextInt(3);
                if (i == 3) {
                    if (valoresCarton[i - 1][fila] == -1) {
                        i--;
                    } else {
                        valoresCarton[indicesElegidos[i]][fila] = -1;
                    }
                } else {
                    valoresCarton[indicesElegidos[i]][fila] = -1;
                }
            } else {
                int filaUno = 0;
                int filaDos = 0;
                do{
                    filaUno = random.nextInt(3);
                    filaDos = random.nextInt(3);
                    for (int j = 0; j < 9; j++){
                        
                    }
                } while (filaUno == filaDos);
            }
        }

        // Los espacios en 0 igualarán a espacios en blanco. Los -1 (en este momento) representan los espacios
        // que luego serán ocupados por el número aleatorio. Aquí se deciden esos espacios a ocupar.
        for (int j = 0; j < valoresCarton.length; j++) {
            for (int x = 0; x < 5; x++) {
                int espacioSeleccionado;
                do {
                    espacioSeleccionado = random.nextInt(9);
                    int contador = 0;
                    for (int y = 0; y < valoresCarton.length; y++) {
                        if (valoresCarton[y][espacioSeleccionado] == -1) {
                            contador++;
                        }
                    }
                    if (this.valoresCarton[j][espacioSeleccionado] != -1 && contador < 2) {
                        repetir = false;
                        valoresCarton[j][espacioSeleccionado] = -1;
                    }

                } while (repetir);
                repetir = true;
            }
            repetir = true;
        }

        // Aquí se decide el número que se le pondrán a los -1 de cada columna. Este número dependerá de si
        // hay un número en una fila superior en la misma columna.
        for (int j = 0; j < valoresCarton[0].length; j++) {
            int contador = -1;
            for (int y = 0; y < valoresCarton.length; y++) {
                if (valoresCarton[y][j] == -1) {
                    contador++;
                }
            }
            int numeroAnterior = 0;
            if (j == 0) {
                numeroAnterior = 1;
            }
            for (int y = 0; y < valoresCarton.length; y++) {
                if (valoresCarton[y][j] == -1) {
                    valoresCarton[y][j] = random.nextInt(10 - numeroAnterior - contador) + numeroAnterior;
                    numeroAnterior = valoresCarton[y][j] + 1;
                    valoresCarton[y][j] += 10 * j;
                    contador--;
                }
            }
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int[] fila : this.valoresCarton) {
            for (int numero : fila) {
                resultado = (numero == -1) ? resultado + "X\t" : resultado + numero + "\t";
            }
            resultado += "\n";
        }
        return resultado;
    }

    public int[][] getValoresCarton() {
        return valoresCarton;
    }

    public void setValoresCarton(int[][] valoresCarton) {
        this.valoresCarton = valoresCarton;
    }

    public static void main(String[] args) {
        Carton carton = new Carton();
        System.out.println(carton.toString());
    }
}
