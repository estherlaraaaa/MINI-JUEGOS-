/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package union;

import a3d.Parejas;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Esther
 */
public class Gui extends JFrame {

    public Gui() {
        super("MINI JUEGOS");
        setSize(650, 100);
        initialComponents();
    }

    private void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton snake = new JButton("JUEGO DE LA CULEBRITA");
        JButton memory = new JButton("JUEGO DE MEMORIA");
        JButton ahorcado = new JButton("JUEGO DE AHORCADO");
        Container container = getContentPane();

        snake.setBounds(10, 0, 180, 30);
        container.add(snake);

        memory.setBounds(200, 0, 180, 30);
        container.add(memory);

        ahorcado.setBounds(390, 0, 180, 30);
        container.add(ahorcado);

        snake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Snake();
            }
        });

        memory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Parejas();
            }
        });

        ahorcado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ahorcado a = new Ahorcado();
            }
        });

    }

}
