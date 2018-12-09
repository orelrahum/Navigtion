package map;
import javax.swing.JFrame;


public class Main  
{
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(window.getHeight()+"\n" + window.myImage.getWidth());
		if (window.getSize().width!=window.myImage.getWidth() ||window.getSize().height!=window.myImage.getHeight()) {
			System.out.println("pic size was change");
		}
	}
}
