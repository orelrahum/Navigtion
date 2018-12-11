package map;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Geom.Point3D;


public class MainWindow extends JFrame implements MouseListener , ActionListener
{
	ArrayList<Fruit> Fruits=new ArrayList<Fruit>() ;
	ArrayList<packman> packmans=new ArrayList<packman>();
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

	public MainWindow() 
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			myPackmanImage = new ImageIcon("packman.jpg");
		} catch(HeadlessException e) {e.printStackTrace();}
		try {
			MyFruitImage = new ImageIcon("hamburger.png");
		} catch(HeadlessException e) {e.printStackTrace();}
	}

	int x = -1;
	int y = -1;

	public void paint(Graphics g)
	{
		g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), this);
		for (int i=0; i<packmans.size();i++) {
			Point3D p= new Point3D (packmans.get(i).getLat(),packmans.get(i).getLon());
			Point3D xAndy=CoordsToPixel(p);
			g.drawImage(myPackmanImage.getImage(),xAndy.ix()-25,xAndy.iy()-25,50,50, null);
		}
		for (int j=0; j<Fruits.size();j++) {
			g.drawImage(MyFruitImage.getImage(),(int)Fruits.get(j).getLat()-25,(int) Fruits.get(j).getLon()-25,50,50, null);

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
			test=JOptionPane.showInputDialog("Please input fruit Radius: ");
			Double Radius=Double.parseDouble(test);
			test=JOptionPane.showInputDialog("Please input fruit speed: ");
			Double speed=Double.parseDouble(test);
			test=JOptionPane.showInputDialog("Please input fruit height: ");
			Double height=Double.parseDouble(test);
			Point3D pixel=new Point3D();
			pixel= PixelToCoords(x, y);
			packman p =new packman(pixel.x(),pixel.y(),height,speed,Radius);
			packmans.add(p);
		}
		if (PackOrFruit==2) {
			String test ;
			test=JOptionPane.showInputDialog("Please input fruit value: ");
			Double value=Double.parseDouble(test);
			test=JOptionPane.showInputDialog("Please input fruit height: ");
			Double height=Double.parseDouble(test);
			Fruit f=new Fruit (value,x,y,height);
			Fruits.add(f);
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
	}
	public Point3D PixelToCoords(int x, int y) {
		Point3D leftUp = new Point3D(32.105770,  35.202469);
		Point3D leftDown = new Point3D(32.101899, 35.202469);
		Point3D RightUp = new Point3D(32.105770 , 35.211588);
		Point3D RightDown = new Point3D(32.101899, 35.211588);
		int widthPixel=this.getWidth();
		int HeightPixel=this.getHeight();
		double Heightcoords= leftUp.distance3D(leftDown);
		double widthcoords= RightUp.distance3D(leftUp);
		Point3D p2=new Point3D(32.105770+(((double)x/HeightPixel)*Heightcoords ), (35.202469+(((double)y/widthPixel)*widthcoords)));
		System.out.println(p2.toString());
		return p2;
	}
	public Point3D CoordsToPixel(Point3D p) {
		Point3D leftUp = new Point3D(32.105770,  35.202469);
		Point3D leftDown = new Point3D(32.101899, 35.202469);
		Point3D RightUp = new Point3D(32.105770 , 35.211588);
		Point3D RightDown = new Point3D(32.101899, 35.211588);
		double x=p.x()-32.105770;
		double y=p.y()-35.202469;
		int widthPixel=this.getWidth();
		int HeightPixel=this.getHeight();
		double Heightcoords= leftUp.distance3D(leftDown);
		double widthcoords= RightUp.distance3D(leftUp);
		Point3D p2=new Point3D((x/Heightcoords)*(double)HeightPixel , (y/widthcoords)*(double)widthPixel);
		return p2;
	}
}

