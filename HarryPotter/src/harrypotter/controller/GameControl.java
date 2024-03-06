package harrypotter.controller;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import harrypotter.exceptions.InCooldownException;
import harrypotter.exceptions.InvalidTargetCellException;
import harrypotter.exceptions.NotEnoughIPException;
import harrypotter.exceptions.OutOfBordersException;
import harrypotter.exceptions.OutOfRangeException;
import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.Collectible;
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.HealingSpell;
import harrypotter.model.magic.Potion;
import harrypotter.model.magic.RelocatingSpell;
import harrypotter.model.magic.Spell;
import harrypotter.model.tournament.FirstTask;
import harrypotter.model.tournament.SecondTask;
import harrypotter.model.tournament.Task;
import harrypotter.model.tournament.ThirdTask;
import harrypotter.model.tournament.Tournament;
import harrypotter.model.world.Direction;
import harrypotter.view.AllDead;
import harrypotter.view.ChampSelect;
import harrypotter.view.Intro;
import harrypotter.view.Map;
import harrypotter.view.Name;
import harrypotter.view.SpellSelect;
import harrypotter.view.Trans;
import harrypotter.view.Victory;


public class GameControl {
	Tournament tournament;
	JFrame oldWindow;
	JFrame frame;
	int ctr;
	int spellctr;
	Task currTask;
	Map m1;
	Map m2;
	Map m3;
	
	
	public GameControl() throws IOException{
		tournament=new Tournament();
		Intro in =new Intro();
		frame=in;
		oldWindow =in;
		in.setListener(this);
		 ctr=0;
		spellctr=0;
	
	}
	public void onStart(){
		ChampSelect select =new ChampSelect();
		select.setListener(this);
		frame=select;
		oldWindow.dispose();
		oldWindow=select;
	}
	public void onExit(){
		frame.dispose();
	}
	public void onGryff(){
		ctr++;
		Wizard Gryf=new GryffindorWizard("G");
		tournament.addChampion((Champion)(Gryf));
		Name name = new Name();
		name.setListener(this);
		frame=name;
	}
	public void onSlyth(){
		ctr++;
		Wizard Slyth=new SlytherinWizard("S");
		tournament.addChampion((Champion)(Slyth));
		Name name = new Name();
		name.setListener(this);
		frame=name;
	}
	public void onRaven(){
		ctr++;
		Wizard Raven=new RavenclawWizard("R");
		tournament.addChampion((Champion)(Raven));
		Name name = new Name();
		name.setListener(this);
		frame=name;
	}
	public void onHuff(){
		ctr++;
		Wizard Huff=new HufflepuffWizard("H");
		tournament.addChampion((Champion)(Huff));
		Name name = new Name();
		name.setListener(this);
		frame=name;
	}
	public void onName(String name){
		((Wizard) tournament.getChampions().get(ctr-1)).setName(name);
		SpellSelect ss = new SpellSelect(tournament,name);
		ss.setListener(this);
		frame.dispose();
		frame = ss;
		oldWindow.dispose();
		oldWindow = ss;
	}
	public void onSpell(String name) throws IOException{
		spellctr++;
		if(spellctr <3){
		for(int i = 0;i<21;i++){
			if(tournament.getSpells().get(i).getName() .equals(name)){
				if(tournament.getSpells().get(i) instanceof DamagingSpell){
					DamagingSpell s=(DamagingSpell) tournament.getSpells().get(i);
					DamagingSpell s2 = new DamagingSpell(s.getName(),s.getCost(),s.getDefaultCooldown(),s.getDamageAmount());
					Wizard current=(Wizard) tournament.getChampions().get(ctr-1);
					current.getSpells().add(s2);
				}
				if(tournament.getSpells().get(i) instanceof RelocatingSpell){
					RelocatingSpell s=(RelocatingSpell) tournament.getSpells().get(i);
					RelocatingSpell s2= new RelocatingSpell(s.getName(),s.getCost(),s.getDefaultCooldown(),s.getRange());
					Wizard current=(Wizard) tournament.getChampions().get(ctr-1);
					current.getSpells().add(s2);
				}
				if(tournament.getSpells().get(i) instanceof HealingSpell){
					HealingSpell s=(HealingSpell) tournament.getSpells().get(i);
					HealingSpell s2= new HealingSpell(s.getName(),s.getCost(),s.getDefaultCooldown(),s.getHealingAmount());
					Wizard current=(Wizard) tournament.getChampions().get(ctr-1);
					current.getSpells().add(s2);
				}
			}
		}
		}
		if(spellctr==3){
			for(int i = 0;i<21;i++){
				if(tournament.getSpells().get(i).getName() .equals(name)){
					if(tournament.getSpells().get(i) instanceof DamagingSpell){
						DamagingSpell s=(DamagingSpell) tournament.getSpells().get(i);
						DamagingSpell s2 = new DamagingSpell(s.getName(),s.getCost(),s.getDefaultCooldown(),s.getDamageAmount());
						Wizard current=(Wizard) tournament.getChampions().get(ctr-1);
						current.getSpells().add(s2);
				
					}
					if(tournament.getSpells().get(i) instanceof RelocatingSpell){
						RelocatingSpell s=(RelocatingSpell) tournament.getSpells().get(i);
						RelocatingSpell s2= new RelocatingSpell(s.getName(),s.getCost(),s.getDefaultCooldown(),s.getRange());
						Wizard current=(Wizard) tournament.getChampions().get(ctr-1);
						current.getSpells().add(s2);
						
					}
					if(tournament.getSpells().get(i) instanceof HealingSpell){
						HealingSpell s=(HealingSpell) tournament.getSpells().get(i);
						HealingSpell s2= new HealingSpell(s.getName(),s.getCost(),s.getDefaultCooldown(),s.getHealingAmount());
						Wizard current=(Wizard) tournament.getChampions().get(ctr-1);
						current.getSpells().add(s2);
						
						
					}
				}
			}
			
			oldWindow.dispose();
			frame.dispose();
			spellctr=0;
			if(ctr==4){
				tournament.beginTournament();
				tournament.setListener1(this);
				currTask=tournament.getFirstTask();
				currTask.setListener1(this);
				Trans t1=new Trans(currTask);
				t1.setListener(this);
				frame=t1;
			}
			else{
				
				onStart();
			}
		}
		
	}
    public void onMoveUp() {
    	try {
    	currTask.moveForward();
    	 ((Map) frame).PaintMap();
    	((Map)frame).getMain().validate();
    	 frame.revalidate();
    	 frame.repaint();
    	} catch (OutOfBordersException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	} catch (InvalidTargetCellException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	} catch (IOException e) {
    		System.out.println("EXCEPTION3");
    	}
    	
    }
 public void onMoveDown() {
	 try {
		 currTask.moveBackward();
		 ((Map) frame).PaintMap();
		 ((Map)frame).getMain().validate();
		 frame.revalidate();
    	 frame.repaint();
		} catch (OutOfBordersException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InvalidTargetCellException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 public void onMoveLeft()  {
	 try {
		 currTask.moveLeft();
		 ((Map) frame).PaintMap();
		 ((Map)frame).getMain().validate();
		 frame.revalidate();
    	 frame.repaint();	
		 } catch (OutOfBordersException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		 } catch (InvalidTargetCellException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		 } catch (IOException e) {
			 e.printStackTrace();
	}
 }
 public void onMoveRight() {
	 try {
		 currTask.moveRight();
		 ((Map) frame).PaintMap();
		 ((Map)frame).getMain().validate();
		 frame.revalidate();
    	 frame.repaint();
		} catch (OutOfBordersException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InvalidTargetCellException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
 }
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public static void main(String[]args) throws IOException{
		new GameControl();
	} 
	public void onCastingSpell(Spell s,Direction d,Direction t,int range){
		
		if(s instanceof DamagingSpell){
		try {
			currTask.castDamagingSpell((DamagingSpell) s, d);
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();

		} catch (InCooldownException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();
		} catch (NotEnoughIPException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();
		} catch (OutOfBordersException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();
		} catch (InvalidTargetCellException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();
		} catch (IOException e) {
			e.printStackTrace();
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();
		}
		}
		if(s instanceof RelocatingSpell){
			try {
				currTask.castRelocatingSpell((RelocatingSpell) s, d, t, range);
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (NotEnoughIPException e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (OutOfBordersException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InvalidTargetCellException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (OutOfRangeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (IOException e) {
				e.printStackTrace();
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			}
			
		}
		if(s instanceof HealingSpell){
			try {
				currTask.castHealingSpell((HealingSpell) s);
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (NotEnoughIPException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (IOException e) {
				e.printStackTrace();
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			}
		}
		
	}
	public void onTrait(Direction d){
		if(currTask.getCurrentChamp() instanceof GryffindorWizard){
			try {
				currTask.onGryffindorTrait();
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			}
		}
		
				
			
		if(currTask.getCurrentChamp() instanceof RavenclawWizard){
			if(currTask instanceof FirstTask){
			try {
				currTask.onRavenclawTrait();
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			}}
			if(currTask instanceof SecondTask){
				ArrayList<Direction> dir =new ArrayList<>();
				try {
					dir=(ArrayList<Direction>) ((SecondTask)currTask).onRavenclawTrait();
					((Map) frame).PaintMap();
					((Map)frame).getMain().validate();
					 frame.revalidate();
			    	 frame.repaint();
			    	 Direction d1=dir.get(0);
			    	 Direction d2 =dir.get(1);
			    	 JOptionPane.showMessageDialog(null, "Your hidden treasure is in the direction "+d1+"& "+d2);
			    	 
				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					((Map) frame).PaintMap();
					((Map)frame).getMain().validate();
					 frame.revalidate();
			    	 frame.repaint();
				}
				
				
			}
			if(currTask instanceof ThirdTask){
				ArrayList<Direction> dir =new ArrayList<>();
				try {
					dir=(ArrayList<Direction>) ((ThirdTask)currTask).onRavenclawTrait();
					((Map) frame).PaintMap();
					((Map)frame).getMain().validate();
					 frame.revalidate();
			    	 frame.repaint();
			    	 Direction d1=dir.get(0);
			    	 Direction d2 =dir.get(1);
			    	 JOptionPane.showMessageDialog(null, "The Cup is in the direction "+d1+"& "+d2);
			    	 
				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					((Map) frame).PaintMap();
					((Map)frame).getMain().validate();
					 frame.revalidate();
			    	 frame.repaint();
				}
				
			}
			
		}
				
		if(currTask.getCurrentChamp() instanceof HufflepuffWizard){
			
			try {
				currTask.onHufflepuffTrait();
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			}
			
		}
		if(currTask.getCurrentChamp() instanceof SlytherinWizard){
			try {
				currTask.onSlytherinTrait(d);
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (OutOfBordersException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (InvalidTargetCellException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			} catch (IOException e) {
				e.printStackTrace();
				((Map) frame).PaintMap();
				((Map)frame).getMain().validate();
				 frame.revalidate();
		    	 frame.repaint();
			}}
		
	}
	public void onEndTurn() throws IOException{
		if(currTask.getChampions().size()==0 ){
			if(currTask instanceof FirstTask){
				if(((FirstTask) currTask).getWinners().size()==0){
					frame.dispose();
					AllDead d=new AllDead();
					frame=d;
					d.setListener(this);
				}
				else{
					frame.dispose();
					currTask=tournament.getSecondTask();
					currTask.setListener1(this);
					((SecondTask) currTask).setListener2(this);
					Trans v =new Trans(currTask);
					v.setListener(this);
				}
				}
			else{
				if(currTask instanceof SecondTask){
					if(((SecondTask) currTask).getWinners().size()==0){
						frame.dispose();
						AllDead d=new AllDead();
						frame=d;
						d.setListener(this);
					}	
					else{
						frame.dispose();
						currTask=tournament.getThirdTask();
						currTask.setListener1(this);
						Trans v =new Trans(currTask);
						v.setListener(this);
					}
				}
			}
		}

			
			
		else{
			((Map) frame).PaintMap();
			((Map)frame).getMain().validate();
			 frame.revalidate();
	    	 frame.repaint();
			JOptionPane.showMessageDialog(null, "It's "+((Wizard)currTask.getCurrentChamp()).getName()+"'s Turn!");

		}
	}
	public void startFirst() {
		 Map m=new Map(tournament,currTask,tournament.getFirstTask().getMap(), tournament.getChampions());
		 m.setListener(this);
		 frame=m;
	}
	public void startSecond(){
		Map m2 = new Map(tournament,tournament.getSecondTask(),tournament.getSecondTask().getMap(), tournament.getSecondTask().getChampions());
		m2.setListener(this);
		frame=m2;
		
	}
	public void startThird(){
		Map m3 =new Map(tournament,tournament.getThirdTask(),tournament.getThirdTask().getMap(),tournament.getThirdTask().getChampions());
		m3.setListener(this);
		frame=m3;
		m3.PaintMap();
		m3.getMain().validate();
		m3.revalidate();
		m3.repaint();
	}
	public void onUsePotion(String name){
		for(int i=0;i<((Wizard) currTask.getCurrentChamp()).getInventory().size();i++){
			if(((Wizard) currTask.getCurrentChamp()).getInventory().get(i).getName().equals(name)){
				currTask.usePotion((Potion) ((Wizard) currTask.getCurrentChamp()).getInventory().get(i));
			}
		}
		((Map) frame).PaintMap();
		((Map)frame).getMain().validate();
		 frame.revalidate();
    	 frame.repaint();
	}
	public void onCollctible(Collectible c){
		((Map) frame).PaintMap();
		((Map)frame).getMain().validate();
		 frame.revalidate();
    	 frame.repaint();
		JOptionPane.showMessageDialog(null, "You have collected a Potion!! "+c.getName()+" can increase your ip by " +((Potion)c).getAmount());
		
	}
	public void onFire(ArrayList<Point> markedCells){
		((Map) frame).PaintMap();
		((Map)frame).getMain().validate();
		 frame.revalidate();
		 frame.repaint();
		((Map) frame).Fire(markedCells);
		JOptionPane.showMessageDialog(null, "The Dragon will Fire on these 2 Orange cells!!");
	}
	public void onMereperson(int dmg){
		JOptionPane.showMessageDialog(null, "A Mereperson damaged on you for "+dmg+"Health Points");
	}
	public void onVictory(Champion winner){
		Victory v =new Victory();
		v.setListener(this);
		frame=v;
	}
	}
	
	

