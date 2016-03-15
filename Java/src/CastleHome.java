package castleHome;

import java.io.*;
import java.util.ArrayList;

class Vertex
{
	int x,y;
	public Vertex(int a, int b)
	{
		x = a;
		y = b;
	}
	boolean equals(Vertex v)
	{
		if(x == v.x && y == v.y)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return "( "+y+" , "+x+" )";
	}
}

class PathNode
{
	Vertex vertex;
	char action;
	public PathNode(Vertex v, char act)
	{
		vertex = v;
		action = act;
	}
}

class Path extends ArrayList<PathNode> 
{

	public Path(PathNode pathNode) {
		this.add(pathNode);
	}
	
	public Path() {
		super();
	}
	
}

class Board
{
	int MAX_ROW , MAX_COL , MIN_ROW , MIN_COL;
	ArrayList<Vertex> Soldiers = new ArrayList<Vertex>();
	Vertex home;
	public Board(ArrayList<Vertex> Soldiers, Vertex home)
	{
		this.home = home;
		this.Soldiers = Soldiers;
		MAX_ROW = 10;
		MAX_COL = 10;
		MIN_ROW = 1;
		MIN_COL = 1;
	}
	
	public Board(ArrayList<Vertex> Soldiers, Vertex home, int maxRows, int maxCols)
	{
		this.home = home;
		this.Soldiers = Soldiers;
		MAX_ROW = maxRows;
		MAX_COL = maxCols;
		MIN_ROW = 1;
		MIN_COL = 1;
	}
	
	public boolean isSoldierPresent(Vertex v)
	{
		for(Vertex sol: Soldiers)
			if(v.equals(sol))
				return true;
		return false;
	}
}

public class CastleHome {
	
	static final int UP = 0;
	static final int LEFT = 1;
	static final int DOWN = 2;
	static final int RIGHT = 3;
	
	static ArrayList<Path> PathList = new ArrayList<Path>();
	static Board board;
	
	static int readInt() throws NumberFormatException, IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
	}
	
	static ArrayList<Vertex> getSoldiers()
	{
		ArrayList<Vertex> soldiers = new ArrayList<Vertex>();
		try
		{
			System.out.println("Enter the number of Soldiers on board: ");
			int numSold = readInt();
			for(int i=0; i<numSold; i++)
			{
				Vertex sold ;
				while(true)
				{
					boolean unique = true;
					System.out.println("Enter the co-ords for Soldier "+(i+1)+": ");
					int x,y;
					x = readInt();
					y = readInt();
					sold = new Vertex(y,x);
					for(int s=0;s<soldiers.size();s++)
						if(soldiers.get(s).equals(sold))
						{
							unique = false;
							System.out.println("Sorry, the same co-ordinates exists at "+(s+1)+" , Please enter again");
							break;
						}
					if(unique)
						break;
				}
				soldiers.add(sold);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return soldiers;
	}
	
	static boolean hitBoundary(Vertex v)
	{
		if(v.x < board.MIN_ROW || v.x > board.MAX_ROW || v.y < board.MIN_COL || v.y > board.MAX_COL)
			return true;
		else
			return false;
	}
	
	static Vertex move(Vertex cur , int dir)
	{
		Vertex v = new Vertex(cur.x, cur.y);
		if(dir == LEFT)
			v.y--;
		else if(dir== RIGHT)
			v.y++;
		else if(dir== UP)
			v.x--;
		else if(dir== DOWN)
			v.x++;
		return v;
	}
	
	static int turnLeft(int dir)
	{
		return (++dir)%4;
	}
	
	static void walk(Vertex source, int dir, Path path)
	{
		Vertex current = source;
		while(!hitBoundary(current))
		{
			current = move(current , dir);
			if(current.equals( board.home ))
			{
				path.add(new PathNode(current,'a'));
				PathList.add(path);
				break;
			}
			else if(board.isSoldierPresent(current))
			{
				Path path1 = new Path();
				path1.addAll(path);
				path1.add(new PathNode(current,'k'));
				walk(current , turnLeft(dir), path1);
				
				Path path2 = new Path();
				path2.addAll(path);
				path2.add(new PathNode(current,'j'));
				walk(current , dir, path2);
				break;
			}
			
		}
	}
	
	static void printPaths()
	{
		System.out.println("Paths found : "+PathList.size());
		for(Path path: PathList)
		{
			System.out.println("<<<PATH>>>:");
			for(PathNode pn : path)
			{
				switch(pn.action)
				{
				case 'a': System.out.println("Arrive "+pn.vertex);
					break;
				case 'j': System.out.println("Jump "+pn.vertex);
				break;
				case 'k': System.out.println("Kill "+pn.vertex+". Turn Left");
				break;
				case 's': System.out.println("Start "+pn.vertex);
				break;
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Enter the co-ords for castle :");
		Vertex home;
		try {
			int x = readInt();
			int y = readInt();
			home = new Vertex(y,x);
			board = new Board(getSoldiers(), home);
			walk(home , DOWN , new Path(new PathNode(home, 's')));
		} catch (Exception e) {			e.printStackTrace();		}
		printPaths();
	}
}
