package packman;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Geom.Point3D;
import packman.Fruit;
import packman.packman;


public class MyFrame extends JFrame implements MouseListener , ActionListener
{
	Game game=new Game();
	Iterator<Fruit> FruitsIT=game.Fruits.iterator();
	Iterator<packman> packmansIT=game.packmans.iterator();
	public BufferedImage myImage;
	ImageIcon MyFruitImage;
	ImageIcon myPackmanImage;
	private MenuItem item1;
	private MenuItem item2;
	private MenuItem save;
	private MenuItem load;
	private MenuItem run;
	private MenuItem clear;
	private int PackOrFruit=0;
	int x = -1;
	int y = -1;

	public MyFrame() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	private void initGUI()
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("input"); 
		item1 = new MenuItem("packman");
		item2 = new MenuItem("fruit");
		item1.addActionListener(this);
		item2.addActionListener(this);

		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		Menu file = new Menu("file"); 
		load = new MenuItem("load");
		save = new MenuItem("save");
		load.addActionListener(this);
		save.addActionListener(this);
		clear = new MenuItem("clear");
		run = new MenuItem("run");
		clear.addActionListener(this);
		run.addActionListener(this);

		menuBar.add(file);
		file.add(run);
		file.add(clear);
		file.add(save);
		file.add(load);
		this.setMenuBar(menuBar);

		try {
			myImage = ImageIO.read(new File("Ariel1.png"));
			myPackmanImage = new ImageIcon("packman.jpg");
			MyFruitImage = new ImageIcon("hamburger.png");
		} catch (IOException e) {
			e.printStackTrace();}
	}



	public void paint(Graphics g)
	{
		g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), this);
		for (int i=0; i<game.packmans.size();i++) {
			Point3D p= new Point3D (game.packmans.get(i).getLat(),game.packmans.get(i).getLon());
			Point3D xAndy=map.CoordsToPixel(p);
			g.drawImage(myPackmanImage.getImage(),xAndy.ix()-25,xAndy.iy()-25,(int)(this.getWidth()/28.66),(int)(this.getHeight()/12.84), null);
		}
		for (int j=0; j<game.Fruits.size();j++) {
			g.drawImage(MyFruitImage.getImage(),(int)game.Fruits.get(j).getLat()-25,(int) game.Fruits.get(j).getLon()-25,(int)(this.getWidth()/28.66),(int)(this.getHeight()/12.84), null);

		}
		if(x!=-1 && y!=-1)
		{
			int r = 10;
			x = x - (r / 2);
			y = y - (r / 2);
			g.fillOval(x, y, r, r);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		if (PackOrFruit==1) {
			String test ;
			test=JOptionPane.showInputDialog("Please input packman Radius: ");
			Double Radius=Double.parseDouble(test);
			test=JOptionPane.showInputDialog("Please input packman speed: ");
			Double speed=Double.parseDouble(test);
			test=JOptionPane.showInputDialog("Please input packman height: ");
			Double height=Double.parseDouble(test);
			Point3D pixel=new Point3D();
			pixel= map.PixelToCoords(x, y);
			packman p =new packman(pixel.x(),pixel.y(),height,speed,Radius);

			game.packmans.add(p);
		}
		if (PackOrFruit==2) {
			String test ;
			test=JOptionPane.showInputDialog("Please input fruit value: ");
			Double Weight=Double.parseDouble(test);
			test=JOptionPane.showInputDialog("Please input fruit height: ");
			Double height=Double.parseDouble(test);
			Fruit f=new Fruit (x,y,height,Weight);
			game.Fruits.add(f);
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==item1) {
			PackOrFruit=1;
		}
		if (arg0.getSource()==item2) {
			PackOrFruit=2;
		}
		if (arg0.getSource()==save) {
			String output ;
			output=JOptionPane.showInputDialog("Please input save place: ");
			game.SaveGame(output);
		}
		if (arg0.getSource()==load) {
			String load ;
			load=JOptionPane.showInputDialog("Please input load location: ");
			Game loaded=new Game (load);
			game=loaded;
			repaint();
		}
	}

}

