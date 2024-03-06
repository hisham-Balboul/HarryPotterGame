package harrypotter.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import javafx.scene.layout.Border;
//import javafx.scene.paint.Color;
//import javafx.stage.Popup;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import harrypotter.controller.GameControl;

public class Intro extends JFrame implements ActionListener{
	JPanel main;
	JButton start;
	GameControl listener;
	public Intro(){
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		main =  new JPanel();
		main.setLayout(null);
		
		BufferedImage img = null;
		try {
			img =ImageIO.read(new File("CMWTqJx.jpg"));		
			} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image h = img.getScaledInstance(getSize().width, getSize().height, img.SCALE_SMOOTH);
		
		JLabel background= new JLabel(new ImageIcon(h));
		background.setSize(getSize());
		background.setVisible(true);
		this.setContentPane(background);
		start = new JButton("Start Game");
		start.addActionListener(this);
		start.setBounds(getSize().width-350, getSize().height-150, 300, 75);
		start.setToolTipText("   START GAME   ");
		JButton exit = new JButton("EXIT");
		exit.addActionListener(this);
		exit.setBounds(50, getSize().height-150, 300, 75);
		exit.setToolTipText("   END GAME   ");
		
		getContentPane().add(start);
		getContentPane().add(exit);
		revalidate();
		repaint();
		
	   }
	   
		
	
public static void main(String[]args){
	new Intro();
}
public JPanel getMain() {
	return main;
}
public void setMain(JPanel main) {
	this.main = main;
}
public JButton getStart() {
	return start;
}
public void setStart(JButton start) {
	this.start = start;
}
public GameControl getListener() {
	return listener;
}
public void setListener(GameControl listener) {
	this.listener = listener;
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton btn = (JButton) e.getSource();
	if(btn.getText().equals("Start Game")){
		listener.onStart();
	}
	else{
		listener.onExit();
	}
	
}
}
