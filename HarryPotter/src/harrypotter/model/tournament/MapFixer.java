package harrypotter.model.tournament;

import java.awt.Point;
import java.io.IOException;

import harrypotter.exceptions.InvalidTargetCellException;
import harrypotter.exceptions.OutOfBordersException;
import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.Potion;
import harrypotter.model.world.Cell;
import harrypotter.model.world.ChampionCell;
import harrypotter.model.world.CollectibleCell;
import harrypotter.model.world.CupCell;
import harrypotter.model.world.EmptyCell;
import harrypotter.model.world.Merperson;
import harrypotter.model.world.ObstacleCell;
import harrypotter.model.world.PhysicalObstacle;
import harrypotter.model.world.TreasureCell;
import harrypotter.model.world.WallCell;

public class MapFixer {
	
	public static void setAllEmpty(Task t)
	{
		Cell[][] m = t.getMap();
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				m[i][j] = new EmptyCell();
			}
		}
	}
	
	public static void FixM1(FirstTask f)
	{
		Cell[][]m = f.getMap();
		setAllEmpty(f);
		
		m[1][0] = new ObstacleCell(new PhysicalObstacle(100));
		m[1][2] = new ObstacleCell(new PhysicalObstacle(100));
		m[8][1] = new ObstacleCell(new PhysicalObstacle(100));
		m[8][9] = new ObstacleCell(new PhysicalObstacle(100));
		
		m[1][8] = new CollectibleCell(new Potion("Senzu", 450));
		
		pc(f);
		
	}
	
	public static void FixM2(SecondTask s)
	{
		Cell[][]m = s.getMap();
		setAllEmpty(s);
		
		m[1][8] = new ObstacleCell(new Merperson(100, 400));
		m[6][1] = new ObstacleCell(new Merperson(100, 400));
		m[6][8] = new ObstacleCell(new Merperson(100, 400));
		m[7][0] = new ObstacleCell(new Merperson(100, 400));
		m[7][2] = new ObstacleCell(new Merperson(100, 400));
		m[7][7] = new ObstacleCell(new Merperson(100, 400));
		m[7][9] = new ObstacleCell(new Merperson(100, 400));
		
		Champion g = getGry(s);
		Champion r = getRav(s);
		Champion h = getHuf(s);
		Champion sl = getSly(s);
		
		m[2][3] = new TreasureCell(r);
		m[2][6] = new TreasureCell(sl);
		m[5][1] = new TreasureCell(g);
		m[5][8] = new TreasureCell(h);
		
		pc(s);
		
	}
	
	public static void FixM3(ThirdTask t)
	{
		Cell[][]m = t.getMap();
		setAllEmpty(t);
		
		for(int j = 0; j < m[7].length - 1; j++)
		{
			m[7][j] = new WallCell();
		}
		
		for(int i = 1; i <= 5; i++)
		{
			m[i][2] = new WallCell();
		}
		
		
		Champion r = getRav(t);
		Champion sl = getSly(t);
		
		t.setCurrentChamp(sl);
		t.getChampions().clear();
		t.getChampions().add(sl);
		t.getChampions().add(r);
		
		m[8][1] = new ChampionCell(sl);
		((Wizard)sl).setLocation(new Point(8,1));
		m[8][7] = new ChampionCell(r);
		((Wizard)r).setLocation(new Point(8,7));
		m[9][3] = new CupCell();
		
	}
	
	

	
	public static Champion getGry(Task t)
	{
		for(Champion c : t.getChampions())
		{
			if (c instanceof GryffindorWizard)
			{
				return c;
			}
		}
		return null;
	}

	
	public static Champion getRav(Task t)
	{
		for(Champion c : t.getChampions())
		{
			if (c instanceof RavenclawWizard)
			{
				return c;
			}
		}
		return null;
	}
	
	public static Champion getHuf(Task t)
	{
		for(Champion c : t.getChampions())
		{
			if (c instanceof HufflepuffWizard)
			{
				return c;
			}
		}
		return null;
	}
	
	public static Champion getSly(Task t)
	{
		for(Champion c : t.getChampions())
		{
			if (c instanceof SlytherinWizard)
			{
				return c;
			}
		}
		return null;
	}
	
	public static void pc(Task t)
	{
		Cell[][]m = t.getMap();
		
		Champion g = getGry(t);
		Champion r = getRav(t);
		Champion h = getHuf(t);
		Champion s = getSly(t);
		
		t.setCurrentChamp(g);
		t.getChampions().clear();
		t.getChampions().add(g);
		t.getChampions().add(s);
		t.getChampions().add(h);
		t.getChampions().add(r);
		
		m[0][0] = new ChampionCell(r);
		((Wizard)r).setLocation(new Point(0,0));
		m[0][9] = new ChampionCell(s);
		((Wizard)s).setLocation(new Point(0,9));
		m[9][0] = new ChampionCell(g);
		((Wizard)g).setLocation(new Point(9,0));
		m[9][9] = new ChampionCell(h);
		((Wizard)h).setLocation(new Point(9,9));
		
	}
	public static void printMap(Task t)
	{
		Cell[][]m = t.getMap();
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				System.out.print(m[i][j].getClass().getSimpleName().substring(0, 4));
			}
			System.out.println();
		}
		System.out.println("=======================================================");
	}
	
	public static void main(String[] args) throws IOException {
		Tournament t = new Tournament();
		
		t.addChampion(new GryffindorWizard("Harry"));
		t.addChampion(new RavenclawWizard("Luna"));
		t.addChampion(new SlytherinWizard("Draco"));
		t.addChampion(new HufflepuffWizard("Ced"));
		
		t.beginTournament();

		try {
			t.getFirstTask().moveForward();
			t.getFirstTask().moveLeft();
		} catch (OutOfBordersException | InvalidTargetCellException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MapFixer.printMap(t.getFirstTask());
		
		
	}
}
