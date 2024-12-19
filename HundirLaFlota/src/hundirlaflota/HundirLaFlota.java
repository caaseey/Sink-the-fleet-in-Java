/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author grier
 */
public class HundirLaFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("  _    _                 _ _        _          __ _       _        ");
        System.out.println(" | |  | |               | (_)      | |        / _| |     | |       ");
        System.out.println(" | |__| |_   _ _ __   __| |_ _ __  | | __ _  | |_| | ___ | |_ __ _ ");
        System.out.println(" |  __  | | | | '_ \\ / _` | | '__| | |/ _` | |  _| |/ _ \\| __/ _` |");
        System.out.println(" | |  | | |_| | | | | (_| | | |    | | (_| | | | | | (_) | || (_| |");
        System.out.println(" |_|  |_|\\__,_|_| |_|\\__,_|_|_|    |_|\\__,_| |_| |_|\\___/ \\__\\__,_|");
        System.out.println("");
        System.out.println("By: Casey Cleto");
        char[][] panelJugador = new char[5][5];
        char[][] panelMaquina = new char[5][5];
        int barcosJugador, barcosMaquina, cantidad = 0;

        cantidad = cantidadBarcos();
        barcosJugador = cantidad;
        barcosMaquina = cantidad;
        iniciarMatriz(panelJugador);
        iniciarMatriz(panelMaquina);
        situarBarcosJugador(panelJugador, cantidad);
        situarBarcosMaquina(panelMaquina, cantidad);

        System.out.println("");
        System.out.println("  ______                 _                 _                          _   _     _       ");
        System.out.println(" |  ____|               (_)               | |                        | | (_)   | |      ");
        System.out.println(" | |__   _ __ ___  _ __  _  ___ ______ _  | | __ _   _ __   __ _ _ __| |_ _  __| | __ _ ");
        System.out.println(" |  __| | '_ ` _ \\| '_ \\| |/ _ \\_  / _` | | |/ _` | | '_ \\ / _` | '__| __| |/ _` |/ _` |");
        System.out.println(" | |____| | | | | | |_) | |  __// / (_| | | | (_| | | |_) | (_| | |  | |_| | (_| | (_| |");
        System.out.println(" |______|_| |_| |_| .__/|_|\\___/___\\__,_| |_|\\__,_| | .__/ \\__,_|_|   \\__|_|\\__,_|\\__,_|");
        System.out.println("                  | |                               | |                                 ");
        System.out.println("                  |_|                               |_|                                 ");
        System.out.println("");
        do {
            if (disparaJugador(panelMaquina)) {
                barcosMaquina--;
            }
            System.out.println("Panel maquina");
            mostrarPanel(panelMaquina);
            if (disparaMaquina(panelJugador)) {
                barcosJugador--;
            }
            System.out.println("Panel jugador");
            mostrarPanel(panelJugador);

        } while (barcosJugador > 0 && barcosMaquina > 0);
        mostrarGanador(barcosJugador, barcosMaquina);

    }

    public static int cantidadBarcos() {
        Scanner sc = new Scanner(System.in);
        int barcos = 0;
        while (true) {
            System.out.println("");
            System.out.print("Cantidad de barcos: ");
            barcos = sc.nextInt();
            if (barcos > 5) {
                System.out.println("Rango maximo alcanzado: (5)");
            } else {
                System.out.println("");
                break;
            }
        }
        return barcos;
    }

    public static void iniciarMatriz(char[][] panelJugador) {
        for (int i = 0; i < panelJugador.length; i++) {
            for (int j = 0; j < panelJugador[i].length; j++) {
                panelJugador[i][j] = '.';
            }
        }
    }

    public static void situarBarcosJugador(char[][] panelJugador, int cantidad) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Situe los barcos (Tenga en cuenta que es un tablero de 5x5)");
        System.out.println("-------------------------------------------------------------");
        int contador = 0;
        int fila;
        int columna;
        do {
            System.out.println("Introduce tu barco numero " + (contador + 1));
            while (true) {
                System.out.print("Introduzca la fila: ");
                fila = sc.nextInt() - 1;
                if (fila >= 5 || fila <= -1) {
                    System.out.println("Introduzca de nuevo otro numero (Rango permitido: 1-5)");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("Introduzca la columna: ");
                columna = sc.nextInt() - 1;
                if (columna >= 5 || columna <= -1) {
                    System.out.println("Introduzca de nuevo otro numero (Rango permitido: 1-5)");
                } else {
                    System.out.print("");
                    System.out.println("-----------------------------");
                    break;
                }
            }
            if (panelJugador[fila][columna] == 'B') {
                System.out.println("   / \\");
                System.out.println("  / ! \\");
                System.out.println(" /_____\\");
                System.out.println("Ya hay un barco situado en esta posicion");
                System.out.println("-----------------------------");
                continue;
            } else {
                panelJugador[fila][columna] = 'B';
            }
            contador++;
        } while (contador < cantidad);
    }

    public static void situarBarcosMaquina(char[][] panelMaquina, int cantidad) {
        int fila, columna, contador = 0;
        while (contador < cantidad) {
            fila = (int) (Math.random() * 5);
            columna = (int) (Math.random() * 5);
            if (panelMaquina[fila][columna] != 'B') {
                panelMaquina[fila][columna] = 'B';
                contador++;
            }
        }
    }

    public static void mostrarPanel(char[][] panelJugador) {
        for (char[] panelJugador1 : panelJugador) {
            for (int j = 0; j < panelJugador1.length; j++) {
                System.out.print(panelJugador1[j]);
            }
            System.out.println("");
        }
    }

    public static boolean disparaJugador(char[][] panelMaquina) {
        Scanner sc = new Scanner(System.in);
        boolean hit = false;
        while (true) {
            System.out.println("");
            System.out.print("Introduzca la fila donde quieras atacar: ");
            int fila = sc.nextInt() - 1;
            System.out.print("Introduzca la columna donde quieras atacar: ");
            int columna = sc.nextInt() - 1;
            if (fila >= 5 || columna >= 5 || fila <= -1 || columna <= - 1) {
                System.out.println("   / \\");
                System.out.println("  / ! \\");
                System.out.println(" /_____\\");
                System.out.println("Valores introducidos incorrectos (Rango: 1-5)");
                continue;
            } else {
                if (panelMaquina[fila][columna] == 'B') {
                    panelMaquina[fila][columna] = 'A';
                    hit = true;
                    System.out.println(" _      _____  ______ _____ _____ _____ _____ _ ");
                    System.out.println("| |    |  ___| |  _  \\_   _/  ___|_   _|  ___| |");
                    System.out.println("| |    | |__   | | | | | | \\ `--.  | | | |__ | |");
                    System.out.println("| |    |  __|  | | | | | |  `--. \\ | | |  __|| |");
                    System.out.println("| |____| |___  | |/ / _| |_/\\__/ / | | | |___|_|");
                    System.out.println("\\_____/\\____/  |___/  \\___/\\____/  \\_/ \\____/(_)");
                    System.out.println("");
                    System.out.println("     _.-^^---....,,--       ");
                    System.out.println(" _--                  --_  ");
                    System.out.println("<                        >)");
                    System.out.println("|                         | ");
                    System.out.println(" \\._                   _./  ");
                    System.out.println("    ```--. . , ; .--'''       ");
                    System.out.println("          | |   |             ");
                    System.out.println("       .-=||  | |=-.   ");
                    System.out.println("       `-=#$%&%$#=-'   ");
                    System.out.println("          | ;  :|     ");
                    System.out.println(" _____.,-#%&$@%#&#~,._____");
                    System.out.println("");
                } else if (panelMaquina[fila][columna] == '.') {
                    panelMaquina[fila][columna] = 'A';
                    hit = false;
                    System.out.println("");
                    System.out.println("Sigue intentandolo");
                } else if (panelMaquina[fila][columna] == 'A') {
                    System.out.println("   / \\");
                    System.out.println("  / ! \\");
                    System.out.println(" /_____\\");
                    System.out.print("Ya hay un ataque en esta posicion");
                    System.out.println("");
                    continue;
                }
            }
            break;

        }
        return hit;

    }

    public static boolean disparaMaquina(char[][] panelJugador) {
        boolean hit = false;
        while (true) {
            int fila = (int) (Math.random() * 5);
            int columna = (int) (Math.random() * 5);
            columna = (int) (Math.random() * 5);
            if (fila > 5 && columna > 5) {
                continue;
            } else {
                if (panelJugador[fila][columna] == 'B') {
                    panelJugador[fila][columna] = 'A';
                    hit = true;
                    System.out.println("Te dio a un barco");
                } else if (panelJugador[fila][columna] == 'A') {
                    continue;
                } else {
                    panelJugador[fila][columna] = 'A';
                    hit = false;
                    System.out.println("");
                    System.out.println("Ha habido suerte y no le dio a ningun barco");
                }
            }
            break;

        }
        return hit;

    }

    public static void mostrarGanador(int barcosJugador, int barcosMaquina) {
        if (barcosJugador > 0) {
            System.out.println(" _____   ___   _   _   ___   _____ _____ _____ _ ");
            System.out.println("|  __ \\ / _ \\ | \\ | | / _ \\ /  ___|_   _|  ___| |");
            System.out.println("| |  \\// /_\\ \\|  \\| |/ /_\\ \\\\ `--.  | | | |__ | |");
            System.out.println("| | __ |  _  || . ` ||  _  | `--. \\ | | |  __|| |");
            System.out.println("| |_\\ \\| | | || |\\  || | | |/\\__/ / | | | |___|_|");
            System.out.println(" \\____/\\_| |_/\\_| \\_/\\_| |_/\\____/  \\_/ \\____/(_)");
            System.out.println("");
            System.out.println("Gracias por jugar :)");
            System.out.println("- Casey Cleto");
        } else if (barcosJugador == 0 && barcosMaquina == 0) {
            System.out.println("  ______                       _       ");
            System.out.println(" |  ____|                     | |      ");
            System.out.println(" | |__   _ __ ___  _ __   __ _| |_ ___ ");
            System.out.println(" |  __| | '_ ` _ \\| '_ \\ / _` | __/ _ \\");
            System.out.println(" | |____| | | | | | |_) | (_| | ||  __/");
            System.out.println(" |______|_| |_| |_| .__/ \\__,_|\\__\\___|");
            System.out.println("                  | |                  ");
            System.out.println("                  |_|                  ");
            System.out.println("");
            System.out.println("Gracias por jugar :)");
            System.out.println("- Casey Cleto");
        } else {
            System.out.println("______ _________________ _____ _____ _____ _____        __");
            System.out.println("| ___ \\  ___| ___ \\  _  \\_   _/  ___|_   _|  ___|  _   / /");
            System.out.println("| |_/ / |__ | |_/ / | | | | | \\ `--.  | | | |__   (_) | | ");
            System.out.println("|  __/|  __||    /| | | | | |  `--. \\ | | |  __|      | | ");
            System.out.println("| |   | |___| |\\ \\| |/ / _| |_/\\__/ / | | | |___   _  | | ");
            System.out.println("\\_|   \\____/\\_| \\_|___/  \\___/\\____/  \\_/ \\____/  (_) | | ");
            System.out.println("                                                       \\_\\");
            System.out.println("");
            System.out.println("Gracias por jugar :)");
            System.out.println("- Casey Cleto");
        }
    }

}
