package packman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.element;
import GIS.layer;
import Geom.Point3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Game {
	ArrayList<Fruit> Fruits=new ArrayList<Fruit>() ;
	ArrayList<packman> packmans=new ArrayList<packman>();
	ArrayList<Box> boxes=new ArrayList<Box>();
	ArrayList<Ghost> Ghosts=new ArrayList<Ghost>();
	Player player;
	double Lat,Lon,Alt,Speed,Radius,Weight;
	int ID;
	public Game() {
	}
	public Game (String LoadGame) {

		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(LoadGame))) 
		{	
			line = br.readLine();

			while ((line = br.readLine()) != null) 
			{
				String[] AllData = line.split(cvsSplitBy);
				if (AllData[0].equals("P")) {
					ID=Integer.parseInt(AllData[1]);
					Lat=Double.parseDouble(AllData[2]);
					Lon=Double.parseDouble(AllData[3]);
					Alt=Double.parseDouble(AllData[4]);
					Speed=Double.parseDouble(AllData[5]);
					Radius=Double.parseDouble(AllData[6]);
					packman p=new packman (Lat,Lon,Alt,Speed,Radius,ID);
					packmans.add(p);
				}
				if (AllData[0].equals("F")) {
					ID=Integer.parseInt(AllData[1]);
					Lat=Double.parseDouble(AllData[2]);
					Lon=Double.parseDouble(AllData[3]);
					Alt=Double.parseDouble(AllData[4]);
					Weight=Double.parseDouble(AllData[5]);
					Fruit f=new Fruit (Lat,Lon,Alt,Weight,ID);
					Fruits.add(f);
				}
				if (AllData[0].equals("G")) {
					ID=Integer.parseInt(AllData[1]);
					Lat=Double.parseDouble(AllData[2]);
					Lon=Double.parseDouble(AllData[3]);
					Alt=Double.parseDouble(AllData[4]);
					Speed=Double.parseDouble(AllData[5]);
					Radius=Double.parseDouble(AllData[6]);
					Point3D PGhost= new Point3D (Lat,Lon,Alt);
					Ghost g= new Ghost (PGhost,Speed,Radius,ID);
					Ghosts.add(g);
				}
				if (AllData[0].equals("B")) {
					Lat=Double.parseDouble(AllData[2]);
					Lon=Double.parseDouble(AllData[3]);
					Point3D RigthUp=new Point3D (Lat,Lon);
					Lat=Double.parseDouble(AllData[5]);
					Lon=Double.parseDouble(AllData[6]);
					Point3D LeftDown=new Point3D (Lat,Lon);
					Box B= new Box (RigthUp,LeftDown);
					boxes.add(B);
				}
				
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return ;
	}
	public void load (ArrayList <String> game ) {
		String SplitBy=",";
		for (int i=1;i<game.size();i++) {
			if (game.get(i).charAt(0)=='M') {
				String[] PlayerData = game.get(i).split(SplitBy);
				Lat=Double.parseDouble(PlayerData[2]);
				Lon=Double.parseDouble(PlayerData[3]);
				Alt=Double.parseDouble(PlayerData[4]);
				Speed=Double.parseDouble(PlayerData[5]);
				Radius=Double.parseDouble(PlayerData[6]);
				Point3D PPlayer= new Point3D (Lat,Lon,Alt);
				player=new Player (PPlayer,Speed);

			}
			if (game.get(i).charAt(0)=='P') {
				String[] PackmanData = game.get(i).split(SplitBy);
				ID=Integer.parseInt(PackmanData[1]);
				Lat=Double.parseDouble(PackmanData[2]);
				Lon=Double.parseDouble(PackmanData[3]);
				Alt=Double.parseDouble(PackmanData[4]);
				Speed=Double.parseDouble(PackmanData[5]);
				Radius=Double.parseDouble(PackmanData[6]);
				Point3D PPackman= new Point3D (Lat,Lon,Alt);
				packman p=new packman (PPackman,Speed,Radius,ID);
				packmans.add(p);
			}
			if (game.get(i).charAt(0)=='G') {
				String[] GhostData = game.get(i).split(SplitBy);
				ID=Integer.parseInt(GhostData[1]);
				Lat=Double.parseDouble(GhostData[2]);
				Lon=Double.parseDouble(GhostData[3]);
				Alt=Double.parseDouble(GhostData[4]);
				Speed=Double.parseDouble(GhostData[5]);
				Radius=Double.parseDouble(GhostData[6]);
				Point3D PGhost= new Point3D (Lat,Lon,Alt);
				Ghost g= new Ghost (PGhost,Speed,Radius,ID);
				Ghosts.add(g);
			}
			if (game.get(i).charAt(0)=='F') {
				String[] FruitData = game.get(i).split(SplitBy);
				ID=Integer.parseInt(FruitData[1]);
				Lat=Double.parseDouble(FruitData[2]);
				Lon=Double.parseDouble(FruitData[3]);
				Alt=Double.parseDouble(FruitData[4]);
				Weight=Double.parseDouble(FruitData[5]);
				Fruit f=new Fruit (Lat,Lon,Alt,Weight,ID);
				Fruits.add(f);
			}
			if (game.get(i).charAt(0)=='B') {
				String[] BoxData = game.get(i).split(SplitBy);
				Lat=Double.parseDouble(BoxData[2]);
				Lon=Double.parseDouble(BoxData[3]);
				Point3D RigthUp=new Point3D (Lat,Lon);
				Lat=Double.parseDouble(BoxData[5]);
				Lon=Double.parseDouble(BoxData[6]);
				Point3D LeftDown=new Point3D (Lat,Lon);
				Box B= new Box (RigthUp,LeftDown);
				boxes.add(B);
			}
		}
		
	}

	public void SaveGame (String output) {
		Iterator<Fruit> FruitsIT=Fruits.iterator();
		Iterator<packman> packmansIT=packmans.iterator();
		int counterpack =0;
		int counterfruit=0;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(output));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Type,id,Lat,Lon,Alt,Speed/Weight,Radius\n");

		while(packmansIT.hasNext()) {
			packman p= new packman();
			p=packmansIT.next();
			sb.append("P,");
			sb.append(counterpack+",");
			sb.append(p.getLat() + ",");
			sb.append(p.getLon() + ",");
			sb.append(p.getAlt() + ",");
			sb.append(p.getSpeed() + ",");
			sb.append(p.getRadius() + ",\n");
			counterpack++;
		}
		while(FruitsIT.hasNext()) {
			Fruit f= new Fruit();
			f=FruitsIT.next();
			sb.append("F,");
			sb.append(counterfruit+",");
			sb.append(f.getLat() + ",");
			sb.append(f.getLon() + ",");
			sb.append(f.getAlt() + ",");
			sb.append(f.getWeight() + ",\n");
			counterfruit++;
			
		}
		pw.write(sb.toString());
		pw.close();
		System.out.println("congratulations , you Have your KML file in: \n" +output);
	}

}
