package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import harrypotter.controller.GameControl;

public class Name extends JFrame implements ActionListener{
	JPanel main;
	JPanel sub;
	JLabel lbl;
	JTextField txt;
	JButton btn;
	GameControl listener;
	public Name(){
		this.setTitle("NAME");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 900, 200);
		setLayout(new BorderLayout());
		main=new JPanel();
		sub = new JPanel();
		sub.setLayout(new GridLayout(0,2));
		main.setLayout(new FlowLayout());
		txt=new JTextField();
		txt.setSize(new Dimension(350,100));
		txt.setVisible(true);
		btn=new JButton("Enter");
		btn.setVisible(true);
		btn.setSize(new Dimension(50,50));
		btn.addActionListener(this);
		lbl =new JLabel("Please enter your name");
		lbl.setFont(new Font("Harry P", Font.PLAIN, 26));
		lbl.setPreferredSize(new Dimension(350,100));
		lbl.setVisible(true);
		add(main,BorderLayout.CENTER);
		add(sub,BorderLayout.SOUTH);
		sub.add(txt);
		sub.add(btn);
		main.add(lbl);
		this.setVisible(true);
		}


	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		String name = txt.getText();
		listener.onName(name);
		
		
	}
	public GameControl getListener() {
		return listener;
	}


	public void setListener(GameControl listener) {
		this.listener = listener;
	}


	public static void main(String[]args){
		new Name();
			
		}


}
