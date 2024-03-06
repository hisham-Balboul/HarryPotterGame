package harrypotter.view;

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

import harrypotter.controller.GameControl;
import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.tournament.FirstTask;
import harrypotter.model.tournament.SecondTask;
import harrypotter.model.tournament.Task;
import harrypotter.model.tournament.ThirdTask;
import harrypotter.model.tournament.Tournament;

public class Trans extends JFrame implements ActionListener{
	GameControl listener;
	Task task;
	public Trans(Task task){
		setTitle("Transition");
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.task=task;
		BufferedImage img = null;
		if(task instanceof FirstTask){
		try {
			img =ImageIO.read(new File("First Task.jpeg"));		
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image h = img.getScaledInstance(getSize().width, getSize().height, img.SCALE_SMOOTH);
		
		JLabel background= new JLabel(new ImageIcon(h));
		background.setSize(getSize());
		background.setVisible(true);
		this.setContentPane(background);
		JButton next =new JButton();
		next.setText("NEXT");
		next.setBounds(getWidth()/2-200, getHeight()-60, 400, 50);
		getContentPane().add(next);
		next.addActionListener(this);
		
		}
		if(task instanceof SecondTask){
			try {
				img =ImageIO.read(new File("Second Task2.jpeg"));		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Image h = img.getScaledInstance(getSize().width, getSize().height, img.SCALE_SMOOTH);
			
			JLabel background= new JLabel(new ImageIcon(h));
			background.setSize(getSize());
			background.setVisible(true);
			this.setContentPane(background);
			JButton next =new JButton();
			next.setText("NEXT");
			next.setBounds(getWidth()/2-200, getHeight()-60, 400, 50);
			getContentPane().add(next);
			next.addActionListener(this);
		}
		if(task instanceof ThirdTask){
			try {
				img =ImageIO.read(new File("Third Task.jpeg"));		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Image h = img.getScaledInstance(getSize().width, getSize().height, img.SCALE_SMOOTH);
			
			JLabel background= new JLabel(new ImageIcon(h));
			background.setSize(getSize());
			background.setVisible(true);
			this.setContentPane(background);
			JButton next =new JButton();
			next.setText("NEXT");
			next.setBounds(getWidth()/2-200, getHeight()-60, 400, 50);
			getContentPane().add(next);
			next.addActionListener(this);
		}
		revalidate();
		repaint();
		
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
		if(btn.getText().equals("NEXT")){
			if(task instanceof FirstTask){
				
					listener.startFirst();
				
			}
			if(task instanceof SecondTask){
				listener.startSecond();
				this.dispose();
			}
			if(task instanceof ThirdTask){
				listener.startThird();
				this.dispose();
			}
			this.dispose();
    	}		
	}
	public static void main(String[]args) throws IOException{
		GryffindorWizard z =new GryffindorWizard("Wizard1");
		SlytherinWizard s =new SlytherinWizard("Wizard2");
		RavenclawWizard r=new RavenclawWizard("Wizard3");
		HufflepuffWizard h=new HufflepuffWizard("Wizard4");
		Tournament t=new Tournament();
		t.addChampion(h);
		t.addChampion(z);
		t.addChampion(s);
		t.addChampion(r);
		t.beginTournament();
		ArrayList<Champion> winners = new ArrayList<Champion>();
		winners.add(z);
		winners.add(r);
		t.onFinishingFirstTask(winners);
		winners.clear();
		winners.add(h);
		t.onFinishingSecondTask(winners);
		new Trans(t.getThirdTask());
	}

}
