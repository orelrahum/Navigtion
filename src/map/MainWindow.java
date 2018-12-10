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


public class MainWindow extends JFrame implements MouseListener , ActionListener
{
	ArrayList<Fruit> Fruits=new ArrayList<Fruit>() ;
	ArrayList<packman> packmans=new ArrayList<packman>();
	public BufferedImage myImage;
	ImageIcon MyFruitImage;
	ImageIcon myPackmanImage;
	private MenuItem item1;
	private MenuItem item2;
	private int PackOrFruit=0;
	public MainWindow() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	private void initGUI()
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Add"); 
		item1 = new MenuItem("packman");
		item2 = new MenuItem("fruit");
		item1.addActionListener(this);
		item2.addActionListener(this);

		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
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
			MyFruitImage = new ImageIcon("fruit.png");
		} catch(HeadlessException e) {e.printStackTrace();}
	}

	int x = -1;
	int y = -1;

	public void paint(Graphics g)
	{
		g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), this);
		if (PackOrFruit==1 || PackOrFruit==2) {
			for (int i=0; i<packmans.size();i++) {
				g.drawImage(myPackmanImage.getImage(),(int)packmans.get(i).getLat()-25,(int) packmans.get(i).getLon()-25,50,50, null);

			}
			for (int j=0; j<Fruits.size();j++) {
				g.drawImage(MyFruitImage.getImage(),(int)Fruits.get(j).getLat()-25,(int) Fruits.get(j).getLon()-25,50,50, null);

			}
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
			packman p =new packman(x,y,height,speed,Radius);
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
			System.out.println("packman adds");
			PackOrFruit=1;
		}
		if (arg0.getSource()==item2) {
			System.out.println("fruit adds");
			PackOrFruit=2;
		}
	}


}
