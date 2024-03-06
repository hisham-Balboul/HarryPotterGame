package harrypotter.view;

import java.awt.Font;
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
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.Spell;
import harrypotter.model.world.Direction;

public class DamageView extends JFrame implements KeyListener , ActionListener{
	JPanel main;
	JPanel sub;
	JTextField txt;
	JButton btn;
	GameControl listener;
	Spell s;
	
	public DamageView(Spell s){
		this.s=s;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(getHeight()/2, getWidth()/2, 1000, 150);
		main=new JPanel();
		JLabel lbl =new JLabel();
		lbl.setText("PLEASE CHOOSE A DIRECTION FOR THE SPELL USING ARROW KEYS");
		lbl.setVisible(true);
		add(main);
		main.add(lbl);
		main.setVisible(true);
		addKeyListener(this);
		this.setVisible(true);
		lbl.setFont(new Font("Harry p", Font.PLAIN, 26));
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
	    DamagingSpell s =new DamagingSpell("name", 1, 1, 1);
		new DamageView(s);
			
		}


	@Override
	public void keyPressed(KeyEvent e) {
		int code =e.getKeyCode();
		if(code==KeyEvent.VK_UP){
			Direction d=Direction.FORWARD;
				listener.onCastingSpell(s, d,null,0);
				this.dispose();
				}
			
		if(code==KeyEvent.VK_DOWN){
			Direction d=Direction.BACKWARD;
			listener.onCastingSpell(s, d,null,0);
			this.dispose();
		}
		if(code==KeyEvent.VK_LEFT){
			
			Direction d=Direction.LEFT;
			listener.onCastingSpell(s, d,null,0);
			this.dispose();
		}
			
		if(code==KeyEvent.VK_RIGHT){
			
			Direction d=Direction.RIGHT;
			listener.onCastingSpell(s, d,null,0);
			this.dispose();
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
