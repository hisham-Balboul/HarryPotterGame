package harrypotter.view;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.Potion;

public class ExceptionView extends JFrame{
	public ExceptionView(Wizard z){
		JPanel p=new JPanel();
		p.setPreferredSize(new Dimension(1000,1000));
		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		JComboBox petList = new JComboBox(petStrings);
		petList.setSelectedIndex(4);
		p.add(petList);
		add(p);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		
	}
	public static void main(String[] args) {
		GryffindorWizard z=new GryffindorWizard("NAME");
		Potion p1=new Potion("name1", 10);
		Potion p2=new Potion("name2", 10);
		Potion p3=new Potion("name3", 10);
		Potion p4=new Potion("name4", 10);
		z.getInventory().add(p1);
		z.getInventory().add(p2);
		z.getInventory().add(p3);
		z.getInventory().add(p4);
		new ExceptionView(z);
	}

}
