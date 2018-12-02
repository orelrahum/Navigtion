import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriter 
{
	public static void main(String[] args)
	{
		String fileName = "output.csv";
		PrintWriter pw = null;
		
		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");


		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
	}
}




