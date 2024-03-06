package harrypotter.tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestKey implements KeyListener , ActionListener {
	public void Key(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == 37) {
	        System.out.println("Left");
	    }

	    if (key == 39) {
	    	System.out.println("Left");
	    }

	    if (key == 38) {
	    	System.out.println("Left");
	    }

	    if (key == 40) {
	    	System.out.println("Left");
	    }
	}
	public static void main (String[]args){
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		Key(e);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
