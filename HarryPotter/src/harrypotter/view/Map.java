package harrypotter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

//import javafx.scene.control.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import harrypotter.controller.GameControl;
import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.HealingSpell;
import harrypotter.model.magic.RelocatingSpell;
import harrypotter.model.magic.Spell;
import harrypotter.model.tournament.FirstTask;
import harrypotter.model.tournament.SecondTask;
import harrypotter.model.tournament.Task;
import harrypotter.model.tournament.ThirdTask;
import harrypotter.model.tournament.Tournament;
import harrypotter.model.world.Cell;
import harrypotter.model.world.ChampionCell;
import harrypotter.model.world.CollectibleCell;
import harrypotter.model.world.CupCell;
import harrypotter.model.world.Direction;
import harrypotter.model.world.EmptyCell;
import harrypotter.model.world.Merperson;
import harrypotter.model.world.ObstacleCell;
import harrypotter.model.world.TreasureCell;
import harrypotter.model.world.WallCell;



public class Map extends JFrame implements KeyListener , ActionListener{
	 Cell[][] map;
	JLabel stats;
	KeyListener keylisten;
	GameControl listener;
	private JPanel main;
	JPanel top;
	ArrayList<Champion> c;
	Tournament t;
	Task task;
	JPanel right;
	JPanel left;
	JPanel bottom;
	JButton spell1;
	JButton spell2;
	JButton spell3;
	Spell currSpell1;
	Spell currSpell2;
	Spell currSpell3;
	JButton trait;
	Direction d;
	JLabel [][] lblarray;
	Wizard wz;
	JButton ptn;
	int ctr1;
	int ctr2;
	int ctr3;
	int ctr4;
	
	public Map( Tournament t,Task task,Cell[][] map , ArrayList<Champion> c){
		ptn=new JButton();
		this.task=task;
		lblarray =new JLabel [10][10];
		this.t=t;
		this.c=c;
		d=null;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setBounds(0, 0, 100, 1600);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setLayout(new BorderLayout());
		
		setMain(new JPanel());
		getMain().setVisible(true);
		getMain().setLayout(new GridLayout(10, 10));
		this.map =map;
		top = new JPanel();
		top.setLayout(new GridLayout(0,6));
		right = new JPanel();
		right.setLayout(new GridLayout(9,1));
		add(right,BorderLayout.EAST);
		add(top,BorderLayout.NORTH);
		add(main,BorderLayout.CENTER);
		bottom = new JPanel();
		bottom.setLayout(new GridLayout(0,3));
		add(bottom,BorderLayout.SOUTH);
		left= new JPanel();
		left.setLayout(new GridLayout(17, 1));
		add(left, BorderLayout.WEST);
		
		PaintMap();
	}
	public static void main(String [] args) throws IOException{
		ArrayList<Champion> c =new ArrayList<>();
		GryffindorWizard z =new GryffindorWizard("Wizard1");
		GryffindorWizard s =new GryffindorWizard("Wizard2");
		GryffindorWizard r=new GryffindorWizard("Wizard3");
		GryffindorWizard h=new GryffindorWizard("Wizard4");
		c.add(z);
		c.add(s);
		c.add(r);
		c.add(h);
		Tournament t=new Tournament();
		t.addChampion(h);
		t.addChampion(z);
		t.addChampion(s);
		t.addChampion(r);
		t.beginTournament();
		SecondTask s1=new SecondTask(c);
		ThirdTask s2= new ThirdTask(c);
		new Map(t,s2,s2.getMap() , c);
		
		
	}
	public void updateStats(Champion c){
		stats =new JLabel(((Wizard) c).getName());
	   }
	
	
	public void keyPressed(KeyEvent e) {
		int code =e.getKeyCode();
		if(code==KeyEvent.VK_UP){
			listener.onMoveUp();
		}
			
		if(code==KeyEvent.VK_DOWN){
			listener.onMoveDown();
		}
		if(code==KeyEvent.VK_LEFT){
			listener.onMoveLeft();
		}
		if(code==KeyEvent.VK_RIGHT){
			listener.onMoveRight();}
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
		Wizard z = (Wizard) c.get(0);
		JButton	btn = (JButton) e.getSource();

		if(btn.getText().equals("EXIT")){
			listener.onExit();
		}
		if(btn.equals(trait)){
			if(z instanceof SlytherinWizard){
				SlythTrait n= new SlythTrait();
				n.setListener(this.getListener());
			}
			else{
			listener.onTrait(d);}
		}
		if(btn.equals(spell1)){
			if(currSpell1 instanceof HealingSpell){
				listener.onCastingSpell(currSpell1, null, null, 0);
			}
			if(currSpell1 instanceof DamagingSpell){
			DamageView m=	new DamageView(currSpell1);
			m.setListener(this.getListener());
			}
			if(currSpell1 instanceof RelocatingSpell){
			RelocateView r=	new RelocateView(currSpell1);
			r.setListener(this.getListener());
			}
				
		}
		if(btn.equals(spell2)){
			if(currSpell2 instanceof HealingSpell){
				listener.onCastingSpell(currSpell2, null, null, 0);
			}
			if(currSpell2 instanceof DamagingSpell){
				DamageView m=	new DamageView(currSpell2);
				m.setListener(this.getListener());
				}
				if(currSpell2 instanceof RelocatingSpell){
				RelocateView r=	new RelocateView(currSpell2);
				r.setListener(this.getListener());
				}}
		if(btn.equals(spell3)){
			if(currSpell3 instanceof HealingSpell){
				listener.onCastingSpell(currSpell3, null, null, 0);
			}
			if(currSpell3 instanceof DamagingSpell){
				DamageView m=	new DamageView(currSpell3);
				m.setListener(this.getListener());
			}
			if(currSpell3 instanceof RelocatingSpell){
				RelocateView r=	new RelocateView(currSpell3);
				r.setListener(this.getListener());
			}
		}
		if(btn.getText().equals("Felix Felicis")){
			listener.onUsePotion("Felix Felicis");
			left.remove(btn);
			PaintMap();
		}
		if(btn.getText().equals("Pepperup Potion")){
			listener.onUsePotion("Pepperup Potion");
			left.remove(btn);
			PaintMap();
		}
		if(btn.getText().equals("Skele-Gro")){
			listener.onUsePotion("Skele-Gro");
			left.remove(btn);
			PaintMap();
		}
		if(btn.getText().equals("Amortentia")){
			listener.onUsePotion("Amortentia");
			left.remove(btn);
			PaintMap();
		}
		if(btn.getText().equals("Senzu")){
			listener.onUsePotion("Senzu");
			left.remove(btn);
			PaintMap();
		}
		if(btn.getText().equals("Thunder Bolt")){
			listener.onUsePotion("Thunder Bolt");
			left.remove(btn);
			PaintMap();
		}
		
	}
	public GameControl getListener() {
		return listener;
	}
	public void setListener(GameControl listener) {
		this.listener = listener;
	}
	public void PaintMap(){
		wz=(Wizard) task.getCurrentChamp();
		main.removeAll();
		top.removeAll();
		right.removeAll();
		bottom.removeAll();
		left.removeAll();
		for(int i =0; i< map.length;i++ ){
			for(int j=0;j<map.length;j++){
				if(i==4 && j==4 && task instanceof FirstTask){
					ImageIcon icon = new ImageIcon("egg_copy.jpg");
					JLabel a = new JLabel(icon);
					a.setBackground(Color.WHITE);
					a.setOpaque(true);
					getMain().add(a);
					lblarray[4][4]=a;
				}
				else{
				if(map[i][j] instanceof EmptyCell){
					JLabel a =new JLabel();
					a.setBackground(Color.WHITE);
					a.setOpaque(true);
					getMain().add(a);
					lblarray[i][j]=a;
				}
				if(map[i][j] instanceof ChampionCell){
					Wizard z = (Wizard) ((ChampionCell) map[i][j]).getChamp();
					if(((ChampionCell) map[i][j]).getChamp() instanceof GryffindorWizard ){
						ImageIcon icon = new ImageIcon("haaaaaryboootar.jpg");
						JLabel a =new JLabel(icon);
						ctr1++;
						switch (ctr1){
							case 1 :a.setBackground(Color.RED);break;
							case 2 :a.setBackground(Color.GREEN);break;
							case 3 :a.setBackground(Color.BLUE);break;
							case 4 :a.setBackground(Color.YELLOW);break;
						}
						a.setOpaque(true);
						getMain().add(a);
						lblarray[i][j]=a;
						
					}
					if(((ChampionCell) map[i][j]).getChamp() instanceof SlytherinWizard ){
						ImageIcon icon = new ImageIcon("vold.jpg");
						JLabel a =new JLabel(icon);
						ctr2++;
						switch (ctr2){
						case 1 :a.setBackground(Color.RED);break;
						case 2 :a.setBackground(Color.GREEN);break;
						case 3 :a.setBackground(Color.BLUE);break;
						case 4 :a.setBackground(Color.YELLOW);break;
					}
						a.setOpaque(true);
						getMain().add(a);
						lblarray[i][j]=a;
					}
					if(((ChampionCell) map[i][j]).getChamp() instanceof RavenclawWizard ){
						ImageIcon icon = new ImageIcon("snape.jpg");
						JLabel a =new JLabel(icon);
						ctr3++;
						switch (ctr3){
						case 1 :a.setBackground(Color.RED);break;
						case 2 :a.setBackground(Color.GREEN);break;
						case 3 :a.setBackground(Color.BLUE);break;
						case 4 :a.setBackground(Color.YELLOW);break;
					}
						a.setOpaque(true);
						getMain().add(a);
						lblarray[i][j]=a;
					}
					if(((ChampionCell) map[i][j]).getChamp() instanceof HufflepuffWizard ){
						ImageIcon icon = new ImageIcon("drigory.jpg");
						JLabel a =new JLabel(icon);
						ctr4++;
						switch (ctr4){
						case 1 :a.setBackground(Color.RED);break;
						case 2 :a.setBackground(Color.GREEN);break;
						case 3 :a.setBackground(Color.BLUE);break;
						case 4 :a.setBackground(Color.YELLOW);break;
					}
						a.setOpaque(true);
						getMain().add(a);
						lblarray[i][j]=a;
						
					}
				}
				if(map[i][j] instanceof CupCell){
					JLabel a =new JLabel();
					a.setBackground(Color.WHITE);
					a.setOpaque(true);
					getMain().add(a);
					lblarray[i][j]=a;				}
				if(map[i][j] instanceof CollectibleCell){
					JLabel a =new JLabel();
					a.setBackground(Color.WHITE);
					a.setOpaque(true);
					getMain().add(a);
					lblarray[i][j]=a;
				}
				if(map[i][j] instanceof ObstacleCell){
					if(((ObstacleCell)map[i][j]).getObstacle() instanceof Merperson  ){
						Cell c=map[i][j];
						ObstacleCell c1=(ObstacleCell) c;
						ImageIcon icon = new ImageIcon("popariel.jpg");
						JLabel a =new JLabel(icon);
						a.setBackground(Color.WHITE);
						a.setOpaque(true);
						a.setToolTipText("HP: "+c1.getObstacle().getHp());
						getMain().add(a);
						lblarray[i][j]=a;
					}else{
						Cell c=map[i][j];
						ImageIcon icon = new ImageIcon("spike A.png");
						ObstacleCell c1=(ObstacleCell) c;
						JLabel a =new JLabel(icon);
						a.setBackground(Color.WHITE);
						a.setOpaque(true);
						a.setToolTipText("HP: "+c1.getObstacle().getHp());
						getMain().add(a);
						lblarray[i][j]=a;
					}
				}
				if(map[i][j] instanceof WallCell){
					ImageIcon icon = new ImageIcon("hedgee.jpg");
					JLabel a =new JLabel(icon);
					getMain().add(a);
					lblarray[i][j]=a;				}
				if(map[i][j] instanceof TreasureCell){
					JLabel a =new JLabel();
					a.setBackground(Color.WHITE);
					a.setOpaque(true);
					getMain().add(a);
					lblarray[i][j]=a;				
				}
			}
				
			}
		}
		ctr1=0;
		ctr2=0;
		ctr3=0;
		ctr4=0;
		if(c.size()!=0){
		Wizard z = (Wizard) c.get(0);
		lblarray[z.getLocation().x][z.getLocation().y].setBackground(Color.LIGHT_GRAY);
		lblarray[z.getLocation().x][z.getLocation().y].setOpaque(true);
		JLabel champName =new JLabel("Current Champion: "+z.getName());
		JLabel champHouse= new JLabel();
		if(z instanceof GryffindorWizard)
			champHouse=new JLabel("Gryffindor");
		if(z instanceof HufflepuffWizard)
			champHouse=new JLabel("Huffelpuff");
		if(z instanceof RavenclawWizard)
			champHouse=new JLabel("Ravenclaw");
		if(z instanceof SlytherinWizard)
			champHouse=new JLabel("Slyherin");
		top.add(champName);
		top.add(champHouse);
		JLabel champHp = new JLabel("HP: "+z.getHp());
		top.add(champHp);
		JLabel champIp = new JLabel("IP "+z.getIp());
		top.add(champIp);
		JLabel ChampMoves = new JLabel("Allowed Moves: "+task.getAllowedMoves());
		top.add(ChampMoves);
		JButton exit =new JButton("EXIT");
		exit.addActionListener(this);
		top.add(exit);
		JLabel champSpells = new JLabel("Spells:-");
		right.add(champSpells);
		spell1=new JButton();
		spell2=new JButton();
		spell3=new JButton();
		boolean spl1=false;
		boolean spl2=false;
		boolean spl3=false;
		for(int i=0;i<z.getSpells().size();i++){
			Spell s=z.getSpells().get(i);
			if(s instanceof DamagingSpell){
				DamagingSpell s1 =(DamagingSpell) s;
				if(i==0){
					spell1.setText(s1.getName());
					spell1.setToolTipText("This spell is a Damaging Spell with a damage amount of "+s1.getDamageAmount()+", and it costs "+s1.getCost()+" and its cooldown is "+s1.getCoolDown());
					currSpell1=s1;
					if(s1.getCoolDown()>0)
						spl1=true;
				}
				if(i==1){
					spell2.setText(s1.getName());
					currSpell2=s1;
					spell2.setToolTipText("This spell is a Damaging Spell with a damage amount of "+s1.getDamageAmount()+", and it costs "+s1.getCost()+" and its cooldown is "+s1.getCoolDown());
					if(s1.getCoolDown()>0)
						spl2=true;
				}
				if(i==2){
					spell3.setText(s1.getName());
					currSpell3=s1;
					spell3.setToolTipText("This spell is a Damaging Spell with a damage amount of "+s1.getDamageAmount()+", and it costs "+s1.getCost()+" and its cooldown is "+s1.getCoolDown());
					if(s1.getCoolDown()>0)
						spl3=true;
				}
				
			}
			if(s instanceof RelocatingSpell){
				RelocatingSpell s2 = (RelocatingSpell) s;
				if(i==0){
					spell1.setText(s2.getName());
					spell1.setToolTipText("This spell is a Relocating Spell with a range "+s2.getRange()+", and it costs: "+s2.getCost()+" and its cooldown is: "+s2.getCoolDown());
					currSpell1=s2;
					if(s2.getCoolDown()>0)
						spl1=true;
				}
				if(i==1){
					spell2.setText(s2.getName());
					spell2.setToolTipText("This spell is a Relocating Spell with a range "+s2.getRange()+", and it costs: "+s2.getCost()+" and its cooldown is: "+s2.getCoolDown());
					currSpell2=s2;
					if(s2.getCoolDown()>0)
						spl2=true;
				}
				if(i==2){
					spell3.setText(s2.getName());
					spell3.setToolTipText("This spell is a Relocating Spell with a range "+s2.getRange()+", and it costs: "+s2.getCost()+" and its cooldown is: "+s2.getCoolDown());
					currSpell3=s2;
					if(s2.getCoolDown()>0)
						spl3=true;
				}
					
			}
			if(s instanceof HealingSpell){
				HealingSpell s3 = (HealingSpell) s;
				if(i==0){
					spell1.setText(s3.getName());
					spell1.setToolTipText("This spell is a Healing Spell with a Healing amount of "+s3.getHealingAmount()+", and it costs: "+s3.getCost()+" and its cooldown is: "+s3.getCoolDown());
					currSpell1=s3;
					if(s3.getCoolDown()>0)
						spl1=true;
				}
				if(i==1){
					spell2.setText(s3.getName());
					spell2.setToolTipText("This spell is a Healing Spell with a Healing amount of "+s3.getHealingAmount()+", and it costs: "+s3.getCost()+" and its cooldown is: "+s3.getCoolDown());
					currSpell2=s3;
					if(s3.getCoolDown()>0)
						spl2=true;
				}
				if(i==2){
					spell3.setText(s3.getName());
					spell3.setToolTipText("This spell is a Healing Spell with a Healing amount of "+s3.getHealingAmount()+", and it costs: "+s3.getCost()+" and its cooldown is: "+s3.getCoolDown());
					currSpell3=s3;
					if(s3.getCoolDown()>0)
						spl3=true;
				}
				
			}
		}
		spell1.addActionListener(this);
		spell2.addActionListener(this);
		spell3.addActionListener(this);
		
		right.add(spell1);
		right.add(spell2);
		right.add(spell3);
		if(!(task instanceof ThirdTask)){
			JLabel winners=new JLabel("Winners:-");
			right.add(winners);
			}
		if(task instanceof FirstTask){
			for(int i=0;i<((FirstTask)task).getWinners().size();i++){
				
			    Wizard w=(Wizard)((FirstTask)task).getWinners().get(i);
				JLabel win =new JLabel(w.getName());
			    right.add(win);
				
			}}
		if(task instanceof SecondTask){
			for(int i=0;i<((SecondTask)task).getWinners().size();i++){
				Wizard w=(Wizard)((SecondTask)task).getWinners().get(i);
				JLabel win =new JLabel(w.getName());
				right.add(win);
			}
			}
		
		if(spl1){
			spell1.setEnabled(false);
		}
		if(spl2){
			spell2.setEnabled(false);
		}
		if(spl3){
			spell3.setEnabled(false);
		}
		trait= new JButton("Use Trait");
		trait.addActionListener(this);
		
		bottom.add(trait);

		JLabel cd=new JLabel();
		cd.setText("Trait Cooldown is "+z.getTraitCooldown());
		if(z instanceof GryffindorWizard)
			trait.setToolTipText("This turn, the champion can make 2 moves instead of 1");
		if(z instanceof HufflepuffWizard){
			if(task instanceof FirstTask){
				trait.setToolTipText("This turn, the dragon doesn�t attack");
			}	
			if(task instanceof SecondTask){
				trait.setToolTipText("This turn, the merpeople won�t do any damage");
			}
			if(task instanceof ThirdTask){
				trait.setToolTipText("Attacks from other champions will only deal half the damage");
			}	
		}
		if(z instanceof RavenclawWizard){
			if(task instanceof FirstTask){
				trait.setToolTipText("This turn, the champion is shown where the dragon is going to attack ");
			}	
			if(task instanceof SecondTask){
				trait.setToolTipText("This turn, the champion is given a hint on where the target is hidden relative to the current position");
			}
			if(task instanceof ThirdTask){
				trait.setToolTipText("This turn, the champion is given a hint on where the cup is hidden relative to the current position");
			}
		}
		if(z instanceof SlytherinWizard){
			if(task instanceof FirstTask){
				trait.setToolTipText("This turn, the champion can choose between 1. Jumping over a cell containing an obstacle without destroying or moving the obstacle; provided that he ends up in an empty cell.  2. Traversing two cells instead of one ");
			}	
			if(task instanceof SecondTask){
				trait.setToolTipText("This turn, the champion�s movement traverses two cells instead of one; provided that he ends up in an empty cell ");
			}
			if(task instanceof ThirdTask){
				trait.setToolTipText("This turn, the champion can choose between: 1.  Moving through a wall given that the cell he ends up in is not another wall 2. Jumping over a cell containing an obstacle without destroying or moving the obstacle; provided that he ends up in an empty cell.  3. Traversing two cells instead of one");
			}
		}
			bottom.add(cd);
			JLabel trt=new JLabel("Trait Activated: "+task.isTraitActivated());
			bottom.add(trt);
			JLabel potion=new JLabel("Potions:-");
			left.add(potion);
		for(int i=0;i<z.getInventory().size();i++){
			JButton ptn=new JButton(z.getInventory().get(i).getName());
			ptn.addActionListener(this);
			left.add(ptn);
		
		}
		for(int i=0;i<task.getChampions().size();i++){
			JLabel name= new JLabel("Name: "+((Wizard)task.getChampions().get(i)).getName());
			JLabel hp= new JLabel("HP: "+((Wizard)task.getChampions().get(i)).getHp());
			JLabel ip= new JLabel("IP: "+((Wizard)task.getChampions().get(i)).getIp());
			left.add(name);
			left.add(hp);
			left.add(ip);
		}
		if(task instanceof FirstTask && z instanceof RavenclawWizard && task.isTraitActivated()){
			FirstTask t=(FirstTask) task;
			ArrayList<Point> marked=t.getMarkedCells();
			lblarray[marked.get(0).x][marked.get(0).y].setBackground(Color.ORANGE);
			lblarray[marked.get(0).x][marked.get(0).y].setOpaque(true);
			lblarray[marked.get(1).x][marked.get(1).y].setBackground(Color.ORANGE);
			lblarray[marked.get(1).x][marked.get(1).y].setOpaque(true);
		}
		validate();
		revalidate();
		repaint();
		}
		else{
			this.dispose();
		}
	}
	public JPanel getMain() {
		return main;
	}
	public void setMain(JPanel main) {
		this.main = main;
	}
	public JPanel getLeft() {
		return left;
	}
	public void setLeft(JPanel left) {
		this.left = left;
	}
	public void Fire(ArrayList<Point> mark){
		lblarray[mark.get(0).x][mark.get(0).y].setBackground(Color.ORANGE);
		lblarray[mark.get(0).x][mark.get(0).y].setOpaque(true);
		lblarray[mark.get(1).x][mark.get(1).y].setBackground(Color.ORANGE);
		lblarray[mark.get(1).x][mark.get(1).y].setOpaque(true);
	}
	

}
