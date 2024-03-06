package harrypotter.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import harrypotter.controller.GameControl;
import harrypotter.model.magic.Spell;
import harrypotter.model.world.Direction;

public class SlythTrait extends JFrame implements KeyListener , ActionListener {
	JPanel main;
	JPanel sub;
	JTextField txt;
	JButton btn;
	GameControl listener;
	Spell s;
	
	public SlythTrait(){
		this.s=s;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(getHeight()/2, getWidth()/2, 1100, 150);
		main=new JPanel();
		JLabel lbl =new JLabel();
		lbl.setText("PLEASE CHOOSE A DIRECTION FOR THE TRAIT");
		lbl.setVisible(true);
		add(main);
		main.add(lbl);
		main.setVisible(true);
		addKeyListener(this);
		this.setVisible(true);


}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code =e.getKeyCode();
		if(code==KeyEvent.VK_UP){
			Direction d=Direction.FORWARD;
				listener.onTrait(d);
				this.dispose();
				}
			
		if(code==KeyEvent.VK_DOWN){
			Direction d=Direction.BACKWARD;
			listener.onTrait(d);
			this.dispose();
		}
		if(code==KeyEvent.VK_LEFT){
			
			Direction d=Direction.LEFT;
			listener.onTrait(d);
			this.dispose();
		}
			
		if(code==KeyEvent.VK_RIGHT){
			
			Direction d=Direction.RIGHT;
			listener.onTrait(d);
			this.dispose();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public GameControl getListener() {
		return listener;
	}

	public void setListener(GameControl listener) {
		this.listener = listener;
	}}
