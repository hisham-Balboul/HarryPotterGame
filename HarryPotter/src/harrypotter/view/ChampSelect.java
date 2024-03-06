package harrypotter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import harrypotter.controller.GameControl;

public class ChampSelect extends JFrame implements ActionListener{
	JPanel main ;
	JButton gryff;
	JButton slyth;
	JButton raven;
	JButton huff;
	GameControl listener;
	public ChampSelect() {
			setBounds(0, 0, 100, 1600);
			setExtendedState(MAXIMIZED_BOTH);
			setUndecorated(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			main =  new JPanel();
			main.setLayout(new GridLayout(1, 4));
			main.setBackground(Color.black);
			main.setVisible(true);
			getContentPane().add(main );
			ImageIcon icon1 = new ImageIcon("gryff1.png");
			gryff = new JButton(icon1);
			gryff.setSize(new Dimension(getWidth()/4, getHeight()));
			gryff.addActionListener(this);
			ImageIcon icon2 = new ImageIcon("slyth1.jpg");
			slyth =new JButton(icon2);
			slyth.setSize(new Dimension(getWidth()/4, getHeight()));
			slyth.addActionListener(this);
			ImageIcon icon3 = new ImageIcon("raven.png");
			raven = new JButton(icon3);
			raven.setSize(new Dimension(getWidth()/4, getHeight()));
			raven.addActionListener(this);
			ImageIcon icon4 = new ImageIcon("huff1.png");
			huff = new JButton(icon4);
			huff.setSize(new Dimension(getWidth()/4, getHeight()));
			huff.addActionListener(this);
			main.add(gryff);
			main.add(slyth);
			main.add(raven);
			main.add(huff);
		
			repaint();
			revalidate();
			
		}


public static void main(String[]args){
new ChampSelect();
	
}


@Override
public void actionPerformed(ActionEvent e) {
	JButton btn = (JButton) e.getSource();
	if(btn.equals(gryff)){
		listener.onGryff();
	}
	if(btn.equals(slyth)){
		listener.onSlyth();
	}
	if(btn.equals(raven)){
		listener.onRaven();
	}
	if(btn.equals(huff)){
		listener.onHuff();
	}
	
}


public GameControl getListener() {
	return listener;
}


public void setListener(GameControl listener) {
	this.listener = listener;
}
}