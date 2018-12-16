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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Game {
	ArrayList<Fruit> Fruits=new ArrayList<Fruit>() ;
	ArrayList<packman> packmans=new ArrayList<packman>();
	double ID,Lat,Lon,Alt,Speed,Radius,Weight;
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
					ID=Double.parseDouble(AllData[1]);
					Lat=Double.parseDouble(AllData[2]);
					Lon=Double.parseDouble(AllData[3]);
					Alt=Double.parseDouble(AllData[4]);
					Speed=Double.parseDouble(AllData[5]);
					Radius=Double.parseDouble(AllData[6]);
					packman p=new packman (Lat,Lon,Alt,Speed,Radius);
					packmans.add(p);
				}
				if (AllData[0].equals("F")) {
					ID=Double.parseDouble(AllData[1]);
					Lat=Double.parseDouble(AllData[2]);
					Lon=Double.parseDouble(AllData[3]);
					Alt=Double.parseDouble(AllData[4]);
					Weight=Double.parseDouble(AllData[5]);
					Fruit f=new Fruit (Lat,Lon,Alt,Weight);
					Fruits.add(f);
				}
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return ;
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

	public static void main(String[] args)
	{
		MyFrame window = new MyFrame();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
