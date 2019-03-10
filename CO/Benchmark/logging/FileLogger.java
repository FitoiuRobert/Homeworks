package logging;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * Writes timing into file
 * 
 * @author Fitoiu
 *
 */

public class FileLogger implements ILogger{

	private PrintWriter file;
	/**
	 * FileLogger constructor
	 * 
	 * @param fullPath Full path to file(must escape backslashes)
	 */
	public FileLogger(String fullPath) {

		try {
			BufferedWriter logFile = new BufferedWriter(new FileWriter(fullPath, false));
			file = new PrintWriter(logFile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void write(long l)
	{
		file.println(l);
	}

	public void write(Object...values)
	{
		String s = "";
		for (int i = 0; i < values.length ; i++) {
			s += values[i];
		}
		file.println(s);
	}
	
	public void close(){
			file.close();
	}

	@Override
	public void writeTime(long value, TimeUnit unit) {
		double newVal = 0;
		switch(unit) {
		case Nano:
			newVal = (double)(value);
			break;
		case Micro:
			newVal = (double)(value / Math.pow(10, 3));
			break;
		case Milli:
			newVal = (double)(value / Math.pow(10, 6));
			break;
		case Sec:
			newVal = (double)(value / Math.pow(10, 9));
			break;
		default:
			break;
		}
		file.println(newVal + " " + unit.toString());
	}


	@Override
	public void writeTime(String string, long value, TimeUnit unit) {
		double newVal = 0;
		switch(unit) {
		case Nano:
			newVal = (double)(value);
			break;
		case Micro:
			newVal = (double)(value / Math.pow(10, 3));
			break;
		case Milli:
			newVal = (double)(value / Math.pow(10, 6));
			break;
		case Sec:
			newVal = (double)(value / Math.pow(10, 9));
			break;
		default:
			break;
		}
		file.println(string + newVal + " " + unit.toString());
		
	}

}
