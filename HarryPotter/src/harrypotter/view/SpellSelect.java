package harrypotter.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import harrypotter.controller.GameControl;
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.HealingSpell;
import harrypotter.model.magic.RelocatingSpell;
import harrypotter.model.magic.Spell;
import harrypotter.model.tournament.Tournament;

public class SpellSelect extends JFrame implements ActionListener{
GameControl listener;
JPanel txt;

public SpellSelect(Tournament t,String name){
	setBounds(0, 0, 100, 1300);
	setExtendedState(MAXIMIZED_BOTH);
	setUndecorated(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	setLayout(null);
	BufferedImage img = null;
	try {
		img =ImageIO.read(new File("Voldemort..jpg"));		
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	Image h = img.getScaledInstance(getSize().width, getSize().height, img.SCALE_SMOOTH);
	
	JLabel background= new JLabel(new ImageIcon(h));
	background.setSize(getSize());
	background.setVisible(true);
	this.setContentPane(background);
	
	
	
	JPanel healing = new JPanel();
	healing.setVisible(true);
	JPanel damaging =new JPanel();
	damaging.setVisible(true);
	JPanel relocating = new JPanel();
	relocating.setVisible(true);
	txt = new JPanel();
	txt.setVisible(true);
	txt.setLayout(new GridLayout(0,1));
	JPanel down = new JPanel();
	down.setVisible(true);
	down.setBounds(1000, 550, 400, 70);
	JLabel jl = new JLabel(name +" choose 3 spells.");
	jl.setFont(new Font("Harry P", Font.PLAIN, 25));
	jl.setForeground(Color.WHITE);
	down.add(jl);
	damaging.setBounds(100,100, 300, getSize().height-150);
	healing.setBounds(400, 100, 300,getSize().height-150);
	relocating.setBounds(700, 100, 300, getSize().height-150);
	txt.setBounds(1050, 100, 300, 300);
	damaging.setLayout(new GridLayout(0, 1));
	healing.setLayout(new GridLayout(0, 1));
	relocating.setLayout(new GridLayout(0, 1));
	ArrayList<Spell> spells=new ArrayList<>();
	spells=t.getSpells();
	JLabel label = new JLabel("DAMAGING SPELLS:");
	label.setFont(new Font("Harry P", Font.PLAIN, 25));
	label.setForeground(Color.WHITE);
	damaging.add(label);
	
	for(int i =0 ; i<=10;i++ ){
		JButton spel =new JButton(spells.get(i).getName());
		spel.setFont(new Font("Harry P", Font.PLAIN, 27));
		spel.setForeground(Color.WHITE);
		Spell s=spells.get(i);
		DamagingSpell s1=(DamagingSpell) s;
		spel.setToolTipText("This spell is a Damaging Spell with a damage amount of "+s1.getDamageAmount()+", and it costs "+s1.getCost()+" and its default cooldown is "+s1.getDefaultCooldown());
		spel.setContentAreaFilled(false);
		spel.setBorderPainted(false);
		damaging.add(spel);
		spel.addActionListener(this);
	}
	JLabel label2 = new JLabel("HEALING SPELLS:");
	label2.setFont(new Font("Harry P", Font.PLAIN, 25));
	label2.setForeground(Color.WHITE);
	healing.add(label2);
	for(int i =11 ; i<17;i++ ){
		JButton spel =new JButton(spells.get(i).getName());
		spel.setFont(new Font("Harry P", Font.PLAIN, 27));
		spel.setForeground(Color.WHITE);
		Spell s=spells.get(i);
		HealingSpell s3=(HealingSpell) s;
		spel.setToolTipText("This spell is a Healing Spell with a Healing amount of "+s3.getHealingAmount()+", and it costs: "+s3.getCost()+" and its default cooldown is: "+s3.getDefaultCooldown());
		spel.setContentAreaFilled(false);
		spel.setBorderPainted(false);
		healing.add(spel);
		spel.addActionListener(this);
	}
	for(int i=0;i<5;i++){
		JButton j=new JButton();
		healing.add(j);
		j.setVisible(false);
		
	}
	JLabel label3 = new JLabel("RELOCATING SPELLS:");
	label3.setFont(new Font("Harry P", Font.PLAIN, 23));
	label3.setForeground(Color.WHITE);
	relocating.add(label3);
	for(int i =17 ; i<21;i++ ){
		JButton spel =new JButton(spells.get(i).getName());
		spel.setFont(new Font("Harry P", Font.PLAIN, 27));
		spel.setForeground(Color.WHITE);
		Spell s=spells.get(i);
		RelocatingSpell s2=(RelocatingSpell) s;
		spel.setToolTipText("This spell is a Relocating Spell with a range "+s2.getRange()+", and it costs: "+s2.getCost()+" and its default cooldown is: "+s2.getDefaultCooldown());
		spel.setContentAreaFilled(false);
		spel.setBorderPainted(false);
		relocating.add(spel);
		spel.addActionListener(this);
	}
for(int i=0;i<7;i++){
	JButton j=new JButton();
	relocating.add(j);
	j.setVisible(false);
	}
    
	healing.setOpaque(false);
	damaging.setOpaque(false);
	relocating.setOpaque(false);
	txt.setOpaque(false);
	down.setOpaque(false);
	getContentPane().add(healing);
	getContentPane().add(damaging);
	getContentPane().add(relocating);
	getContentPane().add(txt);
	getContentPane().add(down);
	repaint();
	revalidate();
	
	
	
}
public static void main(String[]args) throws IOException{
	Tournament t=new Tournament();
	new SpellSelect(t,"Hisham");
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton btn = (JButton) e.getSource();
	JLabel lbl = new JLabel(btn.getText());
	lbl.setFont(new Font("Harry P", Font.PLAIN, 26));
	lbl.setForeground(Color.WHITE);
	txt.add(lbl);
	repaint();
	revalidate();
	
	
	
	try {
		listener.onSpell(btn.getText());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
}
public GameControl getListener() {
	return listener;
}
public void setListener(GameControl listener) {
	this.listener = listener;
}
}
