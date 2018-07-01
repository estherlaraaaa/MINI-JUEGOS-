/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package union;

import a3d.Parejas;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Union {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
        
        
       /** Scanner leer = new Scanner(System.in);
        int opc = 0;
        System.out.println("¿Que deseas jugar? \033[34m\n1.Juego de la culebrita. \033[34m\n2.Juego de ahorcado. \033[34m\n3.Juego de memoria. ");

        while (opc != 4) {
            opc = leer.nextInt();
            try {
                switch (opc) {
                    case 1:
                        new Snake();
                        break;
                    case 2:
                        Ahorcado a = new Ahorcado();
                        break;
                    case 3:
                        new Parejas();
                        break;
                    case 7:
                        System.out.println("\033[31mHAS ABANDONADO LA PARTIDA");
                        break;
                    default:
                        System.out.println("\033[31mPor favor ingrese una opción valida.");
                }
            } catch (InputMismatchException e) {
                System.err.println("\033[31mPor favor, ingrese una de las opciones.");
                leer.nextLine();
            }
        }

    }*/
}
}
