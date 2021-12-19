package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static int calcularProba() {
        double random = Math.random();// generar un numero al azar entre 0 y 1
        if (random < 0.6)// el 60% de las veces
            return 1;
        else if (random < 0.85)// el 25% de las veces
            return 2;
        else// el 15% restante
            return 3;
    }

    public static float calcularMarco(int validar) {
        // velocidad del sipote: de 10 a 15 Km/h
        float velocidadMarco = (float) Math.round(((float) (Math.random() * (14 - 10 + 1) + 10)) * 100) / 100;

        // horas de trayecto
        float horasMarco = (float) Math.round(((float) (Math.random() * (9 - 8 + 1) + 8)) * 100) / 100;

        String msgMarco = "";

        // 1 = lluvia fuerte, 2 = lluvia normal, 3 = buen clima
        List<Integer> lista_clima = Arrays.asList(1, 2, 2, 2, 3, 3, 3, 3, 3, 3);
        Random aleatorio = new Random();
        int clima = lista_clima.get(aleatorio.nextInt(lista_clima.size()));

        msgMarco = "";
        float vel = 0;
        float distanciaRecorrida = 0;

        if (clima == 1) {
            msgMarco += "Ha llovido muchísimo\n";
            vel = (float) Math.round((velocidadMarco / 4) * 100) / 100;
        } else if (clima == 2) {
            msgMarco += "Ha llovido un poco\n";
            vel = (float) Math.round((velocidadMarco - (velocidadMarco / 4)) * 100) / 100;
        } else {
            msgMarco += "Ha hecho un buen día\n";
            vel = velocidadMarco;
        }

        if (calcularProba() == 2) {
            vel = (float) Math.round((vel - (vel / 10)) * 100) / 100;
            distanciaRecorrida = (float) Math.round((horasMarco * vel) * 100) / 100;
            msgMarco += "Amedio se ha cansado\nAvance " + horasMarco + " horas a " + vel + " Km/h recorriendo "
                    + distanciaRecorrida
                    + " Km";
        } else if (calcularProba() == 3) {
            float hrs = (float) Math.round((horasMarco - 2) * 100) / 100;
            distanciaRecorrida = (float) Math.round((hrs * vel) * 100) / 100;
            msgMarco += "He perdido tiempo buscando a Amedio\nAvance " + hrs + " horas a " + vel
                    + " Km/h recorriendo "
                    + distanciaRecorrida + " Km";
        } else {
            distanciaRecorrida = (float) Math.round((horasMarco * vel) * 100) / 100;
            msgMarco += "Avance " + horasMarco + " horas a " + vel + " Km/h recorriendo "
                    + distanciaRecorrida + " Km";
        }
        System.out.println(msgMarco);
        if (validar == 1) {
            distanciaRecorrida += 25;
        }
        return distanciaRecorrida;

    }

    public static float calcularMama() {
        // velocidad de la mamá: de 6 a 9 Km/h
        float velocidadMama = (float) Math.round(((float) (Math.random() * (8 - 6 + 1) + 6)) * 100) / 100;

        // horas de trayecto
        float horasMama = (float) Math.round(((float) (Math.random() * (8 - 6 + 1) + 6)) * 100) / 100;

        String msgMama = "";

        // 1 = lluvia fuerte, 2 = lluvia normal, 3 = buen clima
        List<Integer> lista_clima = Arrays.asList(1, 2, 2, 2, 3, 3, 3, 3, 3, 3);
        Random aleatorio = new Random();
        int clima = lista_clima.get(aleatorio.nextInt(lista_clima.size()));

        msgMama = "";
        float vel = 0;
        float distanciaRecorrida = 0;

        if (clima == 1) {
            msgMama += "A mamá le ha llovido muchísimo\n";
            vel = (float) Math.round((velocidadMama / 2) * 100) / 100;
        } else if (clima == 2) {
            msgMama += "A mamá le ha llovido un poco\n";
            vel = (float) Math.round((velocidadMama - (velocidadMama / 4)) * 100) / 100;
        } else {
            msgMama += "A mamá le ha hecho un buen día\n";
            vel = velocidadMama;
        }

        distanciaRecorrida = (float) Math.round((horasMama * vel) * 100) / 100;
        msgMama += "Mamá pudo avanzar " + horasMama + " horas a " + vel + " Km/h recorriendo "
                + distanciaRecorrida + " Km";

        System.out.println(msgMama);
        return distanciaRecorrida;

    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("DIARIO DEL VIAJE DE MARCO");
        System.out.println("=========================");

        // para contar la distancia total en cada dia
        float distanciaTotal = 350;

        // para contar los dias
        int contadorDias = 1;

        while (distanciaTotal > 0) {
            System.out.println("DIA " + (contadorDias));
            if (distanciaTotal < 50) {
                distanciaTotal = (float) Math.round((distanciaTotal - (calcularMarco(1) - calcularMama())) * 100) / 100;

                double random = Math.random();
                if (random < 0.5) { // el 50% de las veces
                    System.out.println("A Marco le dicen que ha visto a su mamá, y rompe a correr!!!");
                }
            } else {
                distanciaTotal = (float) Math.round((distanciaTotal - (calcularMarco(0) - calcularMama())) * 100) / 100;
            }
            if (distanciaTotal > 0) {
                System.out.println("Al final del día " + contadorDias + " la distancia entre Marco y su mamá es de "
                        + distanciaTotal + " Km");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println("");
            } else {
                System.out.println("************************************************************");
                System.out.println("Al final del día " + contadorDias + " Marco encuentra a su mamá!!!");
                System.out.println(
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            contadorDias += 1;
        }

    }
}
