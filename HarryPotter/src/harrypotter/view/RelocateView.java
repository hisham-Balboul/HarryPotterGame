package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class RelocateView extends JFrame implements KeyListener,ActionListener{
	int ctr;
	JPanel main;
	JPanel sub;
	JTextField txt;
	JButton btn;
	GameControl listener;
	Spell s;
	JLabel lbl;
	Direction d;
	Direction t;
	int range;
	public RelocateView(Spell s){
		
		this.s=s;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(getHeight()/2, getWidth()/2, 1300, 150);
		this.setLayout(new BorderLayout());
		main=new JPanel();
		 lbl =new JLabel();
		lbl.setText("PLEASE  CHOOSE  THE  DIRECTION  OF  THE  CELL  YOU  WANT  TO  RELOCATE");
		lbl.setVisible(true);
		add(main,BorderLayout.CENTER);
		main.add(lbl);
		main.setVisible(true);
		addKeyListener(this);
		lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
		this.setVisible(true);
		}


	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		this.range = Integer.parseInt(txt.getText());
		listener.onCastingSpell(s, d,t,range);
		this.dispose();
		
	}
	public GameControl getListener() {
		return listener;
	}


	public void setListener(GameControl listener) {
		this.listener = listener;
	}


	public static void main(String[]args){
		DamagingSpell s = new DamagingSpell("hi", 1, 1, 100);
		new RelocateView(s);
			
		}


	@Override
	public void keyPressed(KeyEvent e) {
		int code =e.getKeyCode();
		if(code==KeyEvent.VK_UP){
			if(ctr==0){
				 d=Direction.FORWARD;
				main.removeAll();
				revalidate();
				repaint();
				ctr++;
				lbl=new JLabel();
				lbl.setText("PLEASE CHOOSE THE DIRECTION OF THE CELL YOU WANT TO RELOCATE TO");
				lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
				main.add(lbl);
				revalidate();
				repaint();
				
			}
			else{
			     t=Direction.FORWARD;
			     main.removeAll();
			     revalidate();
					repaint();
					lbl=new JLabel();
					lbl.setText("                                            Please enter the desired Range");
					lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
					add(lbl,BorderLayout.NORTH);
					main.setLayout(new GridLayout(0, 2));
					txt=new JTextField();
					txt.setVisible(true);
					btn=new JButton("Enter");
					btn.setVisible(true);
					btn.addActionListener(this);
					main.add(txt);
					main.add(btn);
					revalidate();
			}
				}
			
		if(code==KeyEvent.VK_DOWN){
			if(ctr==0){
				ctr++;
				d=Direction.BACKWARD;
				main.removeAll();
				revalidate();
				repaint();
				lbl=new JLabel();
				lbl.setText("PLEASE CHOOSE THE DIRECTION OF THE CELL YOU WANT TO RELOCATE TO");
				lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
				main.add(lbl);
				revalidate();
				repaint();
			
				
			}
			else{
				t=Direction.BACKWARD;
				main.removeAll();
			     revalidate();
					repaint();
					lbl=new JLabel();
					lbl.setText("                                            Please enter the desired Range");
					lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
					add(lbl,BorderLayout.NORTH);
					main.setLayout(new GridLayout(0, 2));
					txt=new JTextField();
					txt.setVisible(true);
					btn=new JButton("Enter");
					btn.setVisible(true);
					btn.addActionListener(this);
					main.add(txt);
					main.add(btn);
					revalidate();
				//listener.onCastingSpell(s, d,t,range);
			}
		}
		if(code==KeyEvent.VK_LEFT){
			
			if(ctr==0){
				ctr++;
				d=Direction.LEFT;
				main.removeAll();
				revalidate();
				repaint();
				lbl=new JLabel();
				lbl.setText("PLEASE CHOOSE THE DIRECTION OF THE CELL YOU WANT TO RELOCATE TO");
				lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
				main.add(lbl);
				revalidate();
				repaint();
				
			}
			else{
				 t=Direction.LEFT;
				main.removeAll();
			     revalidate();
					repaint();
					lbl=new JLabel();
					lbl.setText("                                            Please enter the desired Range");
					lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
					add(lbl,BorderLayout.NORTH);
					main.setLayout(new GridLayout(0, 2));
					txt=new JTextField();
					txt.setVisible(true);
					btn=new JButton("Enter");
					btn.setVisible(true);
					btn.addActionListener(this);
					main.add(txt);
					main.add(btn);
					revalidate();
				//listener.onCastingSpell(s, d,t,range);
			}}
		if(code==KeyEvent.VK_RIGHT){
			
			if(ctr==0){
				ctr++;
				d=Direction.RIGHT;
				main.removeAll();
				revalidate();
				repaint();
				lbl=new JLabel();
				lbl.setText("PLEASE CHOOSE THE DIRECTION OF THE CELL YOU WANT TO RELOCATE TO");
				lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
				main.add(lbl);
				revalidate();
				repaint();
				
			}
			else{
				t=Direction.RIGHT;
				main.removeAll();
			     revalidate();
					repaint();
					lbl=new JLabel();
					lbl.setText("                                            Please enter the desired Range");
					lbl.setFont(new Font("Harry P", Font.PLAIN, 30));
					add(lbl,BorderLayout.NORTH);
					main.setLayout(new GridLayout(0, 2));
					txt=new JTextField();
					txt.setVisible(true);
					btn=new JButton("Enter");
					btn.setVisible(true);
					btn.addActionListener(this);
					main.add(txt);
					main.add(btn);
					revalidate();
			}}
		
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



