package packman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import Coords.MyCoords;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Coords.MyCoords;
import Geom.Point3D;
import Robot.Play;
import packman.Fruit;
import packman.packman;


public class MyFrame extends JFrame implements MouseListener , ActionListener
{
	Play play1;
	MyCoords Coords= new MyCoords();
	private boolean ans=false;
	Game game=new Game();
	Iterator<Fruit> FruitsIT=game.Fruits.iterator();
	Iterator<packman> packmansIT=game.packmans.iterator();
	double azimuth;
	private int IDfruit=1;
	private int IDpackman=1;
	public BufferedImage myImage;
	ImageIcon MyFruitImage;
	ImageIcon myPackmanImage;
	ImageIcon myPlayerImage;
	ImageIcon myGhostImage;
	private MenuItem Player;
	private MenuItem packman;
	private MenuItem Fruit;
	private MenuItem save;
	private MenuItem load;
	private MenuItem run;
	private MenuItem StartServer;
	private MenuItem PlayAlone;
	private MenuItem clear;
	private int PackOrFruitOrPlayer=0;
	double Playalone=0;
	public MyFrame() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	private void initGUI()
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("input"); 
		Player=new MenuItem("Player");
		packman = new MenuItem("packman");
		Fruit = new MenuItem("fruit");
		Player.addActionListener(this);
		packman.addActionListener(this);
		Fruit.addActionListener(this);

		menuBar.add(menu);
		menu.add(Player);
		menu.add(packman);
		menu.add(Fruit);
		Menu file = new Menu("file"); 
		load = new MenuItem("load");
		save = new MenuItem("save");
		load.addActionListener(this);
		save.addActionListener(this);
		clear = new MenuItem("clear");
		run = new MenuItem("run");
		PlayAlone=new MenuItem("Play Alone");
		StartServer=new MenuItem ("Start Server");
		PlayAlone.addActionListener(this);
		clear.addActionListener(this);
		run.addActionListener(this);
		StartServer.addActionListener(this);

		menuBar.add(file);
		file.add(run);
		file.add(clear);
		file.add(save);
		file.add(PlayAlone);
		file.add(StartServer);
		file.add(load);
		this.setMenuBar(menuBar);

		try {
			myImage = ImageIO.read(new File("Ariel1.png"));
			myPackmanImage = new ImageIcon("packman.jpg");
			MyFruitImage = new ImageIcon("hamburger.png");
			myPlayerImage=new ImageIcon("Player.JPG");
			myGhostImage=new ImageIcon ("Ghost.jpg");
		} catch (IOException e) {
			e.printStackTrace();}
	}



	public void paint(Graphics g)
	{

		g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), this);
		for (int j=0; j<game.Fruits.size();j++) {
			Point3D f=game.Fruits.get(j).getPoint();
			Point3D xAndy=map.CoordsToPixel(f,this.getHeight(),this.getWidth());
			g.drawImage(MyFruitImage.getImage(),xAndy.ix()-25,xAndy.iy()-25,(int)(this.getWidth()/28.66),(int)(this.getHeight()/12.84), null);

		}
		Graphics2D g2 = (Graphics2D) g;
		for (int k=0; k<game.boxes.size();k++) {
			Point3D p2 = map.CoordsToPixel(game.boxes.get(k).getLeftDown(), this.getWidth(), this.getHeight());
			Point3D p = map.CoordsToPixel(game.boxes.get(k).getRightUp(), this.getWidth(), this.getHeight());
			g2.setColor(Color.black);
			g2.drawRect(p2.iy(), p.ix(), Math.abs(p2.iy() - p.iy()), Math.abs(p2.ix() - p.ix()));
			g2.fillRect(p2.iy(), p.ix(), Math.abs(p2.iy() - p.iy()), Math.abs(p2.ix() - p.ix()));
		}
		for (int i=0; i<game.packmans.size();i++) {
			Point3D p=game.packmans.get(i).getPoint();
			Point3D xAndy=map.CoordsToPixel(p,this.getHeight(),this.getWidth());
			g.drawImage(myPackmanImage.getImage(),xAndy.ix()-25,xAndy.iy()-25,(int)(this.getWidth()/28.66),(int)(this.getHeight()/12.84), null);
			Iterator<Point3D> pathIT=game.packmans.get(i).pathPack.path.iterator();}


		for (int z=0; z<game.Ghosts.size();z++) {
			Point3D f=game.Ghosts.get(z).getPoint();
			Point3D xAndy=map.CoordsToPixel(f,this.getHeight(),this.getWidth());
			g.drawImage(myGhostImage.getImage(),xAndy.ix()-25,xAndy.iy()-25,(int)(this.getWidth()/28.66),(int)(this.getHeight()/12.84), null);

		}


		//			for (int z=0;z<game.packmans.get(i).pathPack.path.size()-1;z++) {
		//				Point3D PathXY=new Point3D();
		//				PathXY=map.CoordsToPixel(game.packmans.get(i).pathPack.path.get(z), this.getHeight(), this.getWidth());
		//				Point3D PathXY2=new Point3D();
		//				PathXY2=map.CoordsToPixel(game.packmans.get(i).pathPack.path.get(z+1), this.getHeight(), this.getWidth());
		//				g.drawLine(PathXY.ix(),PathXY.iy(),PathXY2.ix(),PathXY2.iy());
		//			}
		if (game.player!=null) {
			Point3D p=game.player.getPoint();
			Point3D xAndy=map.CoordsToPixel(p,this.getHeight(),this.getWidth());
			g.drawImage(myPlayerImage.getImage(),xAndy.ix()-25,xAndy.iy()-25,(int)(this.getWidth()/28.66),(int)(this.getHeight()/12.84), null);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		int x = arg.getX();
		int y = arg.getY();
		if (PackOrFruitOrPlayer==1) {
			String rad,sp,hei;
			double Radius=0,speed=0,height=0;
			boolean boo=true;
			while (boo) {
				try {
					rad=JOptionPane.showInputDialog("Please input packman Radius : ");
					Radius=Integer.parseInt(rad);
					boo=false;}
				catch (NumberFormatException e) {
				}
			}
			boo=true;
			while (boo) {
				try {
					sp=JOptionPane.showInputDialog("Please input packman speed: ");
					speed=Integer.parseInt(sp);
					boo=false;}
				catch (NumberFormatException e) {
				}
			}
			boo=true;
			while (boo) {
				try {
					hei=JOptionPane.showInputDialog("Please input packman height: ");
					height=Integer.parseInt(hei);
					boo=false;}
				catch (NumberFormatException e) {
				}
			}
			Point3D xANDy = new Point3D (x,y);
			Point3D LatLon=map.PixelToCoords(xANDy,this.getHeight(),this.getWidth());
			packman p =new packman(LatLon.x(),LatLon.y(),height,speed,Radius,IDpackman);
			IDpackman++;
			game.packmans.add(p);
		}
		if (PackOrFruitOrPlayer==2) {
			String test ;
			double Weight=0 ;
			double height=0;
			boolean boo=true;
			while (boo) {
				try {
					test=JOptionPane.showInputDialog("Please input fruit value: ");
					Weight=Integer.parseInt(test);
					boo=false;}
				catch (NumberFormatException e) {
				}
			}
			boo=true;
			while (boo) {
				try {
					test=JOptionPane.showInputDialog("Please input fruit height: ");
					height=Integer.parseInt(test);
					boo=false;}
				catch (NumberFormatException e) {
				}
			}

			Point3D xANDy = new Point3D (x,y);
			Point3D LatLon=map.PixelToCoords(xANDy,this.getHeight(),this.getWidth());
			Fruit f=new Fruit (LatLon.x(),LatLon.y(),height,Weight,IDfruit);
			IDfruit++;
			game.Fruits.add(f);
		}
		if (PackOrFruitOrPlayer==3) {
			Point3D xANDy = new Point3D (x,y);
			Point3D LatLon=map.PixelToCoords(xANDy,this.getHeight(),this.getWidth());
			double Speed=2 ;
			game.player= new Player (LatLon,Speed);
		}
		repaint();

		if (Playalone==1 && game.player!=null) {
			Point3D xANDy= new Point3D (x,y);
			xANDy=map.PixelToCoords(xANDy, this.getHeight(), this.getWidth());
			azimuth=Coords.azimuth_elevation_dist(game.player.getPoint(),xANDy)[0];
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==packman) {
			PackOrFruitOrPlayer=1;
		}
		if (arg0.getSource()==Fruit) {
			PackOrFruitOrPlayer=2;
		}
		if (arg0.getSource()==Player) {
			PackOrFruitOrPlayer=3;
		}
		if (arg0.getSource()==save) {
			JFileChooser j = new JFileChooser(); 
			int t=j.showSaveDialog(null);
			if (t!=1) {
				game.SaveGame(j.getSelectedFile().getPath());
			}
		}
		if (arg0.getSource()==load) {
			JFileChooser j = new JFileChooser(); 
			int t=j.showOpenDialog(null);
			if (t!=1) {
				Game loaded=new Game (j.getSelectedFile().getPath());
				game=loaded;
				repaint();
			}
		}
		if (arg0.getSource()==clear) {
			game.packmans.clear();
			game.Fruits.clear();
			repaint();
		}

		if (arg0.getSource()==run) {
			ShortestPathAlgo Algo= new ShortestPathAlgo(game);
			repaint();
			ans=true;
		}
		if (arg0.getSource()==StartServer) {
			// 1) Create a "play" from a file (attached to Ex4)

			String file_name = "data/Ex4_OOP_example9.csv";
			Play play1 = new Play(file_name);

			// 2) Set your ID's - of all the group members
			play1.setIDs(1111, 2222, 3333);

			// 3)Get the GPS coordinates of the "arena"
			String map_data = play1.getBoundingBox();
			System.out.println("Bounding Box info: " + map_data);

			// 4) get the game-board data
			ArrayList<String> board_data = play1.getBoard();
			for (int i = 0; i < board_data.size(); i++) {
				System.out.println(board_data.get(i));
			}
			game.load(board_data);
			repaint();
			System.out.println();
			System.out.println("Init Player Location should be set using the bounding box info");
		}
		if (arg0.getSource()==PlayAlone) {
			Playalone=1;
			// 1) Create a "play" from a file (attached to Ex4)

						String file_name = "data/Ex4_OOP_example9.csv";
						Play play1 = new Play(file_name);

						// 2) Set your ID's - of all the group members
						play1.setIDs(1111, 2222, 3333);

						// 3)Get the GPS coordinates of the "arena"
						String map_data = play1.getBoundingBox();
						System.out.println("Bounding Box info: " + map_data);

						// 4) get the game-board data
						ArrayList<String> board_data = play1.getBoard();
						for (int i = 0; i < board_data.size(); i++) {
							System.out.println(board_data.get(i));
						}
						game.load(board_data);
						repaint();
						System.out.println();
						System.out.println("Init Player Location should be set using the bounding box info");
			// 5) Set the "player" init location - should be a valid location
			System.out.println(game.player.getPoint().toString());
			play1.setInitLocation(game.player.getPoint().x(), game.player.getPoint().y());

			// 6) Start the "server"
			play1.start(); // default max time is 100 seconds (1000*100 ms).

			// 7) "Play" as long as there are "fruits" and time
			if (play1.isRuning()) {
				// 7.1) this is the main command to the player (on the server side)
				play1.rotate(azimuth);
				System.out.println(azimuth);
				// 7.2) get the current score of the game
				String info = play1.getStatistics();
				System.out.println(info);
				// 7.3) get the game-board current state
				for (int a = 0; a < board_data.size(); a++) {
					System.out.println(board_data.get(a));

				}
				System.out.println();
				game.load(board_data);
			}
			// 8) stop the server - not needed in the real implementation.
			// play1.stop();
			repaint();
			if (!play1.isRuning()) {
				System.out.println("**** Done Game (user stop) ****");

				// 9) print the data & save to the course DB
				String info = play1.getStatistics();
				System.out.println(info);
			}
		}
	}
	public int getmaxpath(ArrayList<packman>arr) {
		int max=0;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).getPath().path.size()>max)
				max=arr.get(i).getPath().path.size();
		}
		return max;
	}
}

