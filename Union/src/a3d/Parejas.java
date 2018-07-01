/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3d;

/**
 *
 * @author User
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import union.Tablero;

public class Parejas extends JFrame implements ActionListener
{
	private Tablero t;
	private JButton[][] botones;
	private ImageIcon[] imagenes;
	private static int sw;
	private static int a, b, ii, jj;
	
	public Parejas()
	{
		sw = 0;
		t = new Tablero(6);
		t.genAleatorio();
		initComponents();
		configVentana();
	}
	
	public void configVentana()
	{
		setTitle("JParejas v.1 | Esther Lara");
		setSize(380, 380);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void initComponents()
	{
		int d = t.getDim();
		imagenes = new ImageIcon[d*d/2+1];
		imagenes[0] = null;
		for (int i = 1; i <= d*d/2; i++)
			imagenes[i] = new ImageIcon(getClass().getResource("/a3d/" + i + ".bmp"));
		JPanel A = new JPanel(new GridLayout(d,d));
		botones = new JButton[d][d];
		for (int i = 0; i < d; i++)
		{
			for (int j = 0; j < d; j++)
			{
				botones[i][j] = new JButton();
				botones[i][j].addActionListener(this);
				A.add(botones[i][j]);
			}
		}
		this.add(A,"Center");
	}
	public void accion(int x, int y)
	{
		switch (sw)
		{
		case 0:
			if(!t.esClic(x, y))
			{
				t.clic(x, y);
				botones[x][y].setIcon(imagenes[t.getPos(x,y)]);
				sw = 1;
				a = x;
				b = y;
			}
			break;
		case 1:
			if(!t.esClic(x, y))
			{
				t.clic(x, y);
				botones[x][y].setIcon(imagenes[t.getPos(x,y)]);
				ii = x;
				jj = y;
				if(t.getPos(a, b) != t.getPos(ii, jj))
					sw = 2;
				else
					sw = 0;
			}
			break;
		case 2:
			botones[a][b].setIcon(null);
			botones[ii][jj].setIcon(null);
			t.clic(a, b);
			t.clic(ii, jj);
			sw = 0;
			break;
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		int d = t.getDim();
		for (int i = 0; i < d; i++)
		{
			for (int j = 0; j < d; j++)
			{
				if(botones[i][j] == ae.getSource())
				{
					accion(i,j);
					if(t.esCompleto())
					{
						JOptionPane.showMessageDialog(this,"Felicidades, ahora inténtalo hacerlo en un menor tiempo.", "Al fin terminaste!",JOptionPane.INFORMATION_MESSAGE, null);
						System.exit(0);
					}
					return;
				}
			}
		}
	}
}
