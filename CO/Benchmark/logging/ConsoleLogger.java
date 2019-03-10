package logging;


/**
 * 
 * Writes timing into console
 * 
 *
 */

public class ConsoleLogger implements ILogger{

	@Override
	public void write(long l) {
	      System.out.println(l);
		
	}
	

	@Override
	public void write(Object... values) {
		String s = "";
		for (int i = 0; i < values.length ; i++) {
			s += values[i];
		}
		System.out.println(s);
		
	}

	@Override
	public void close() {
		
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
		System.out.println(newVal + " " + unit.toString());
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
		System.out.println(string + newVal + " " + unit.toString());
		
	}

//	@Override
//	public void write(String s, long l) {
//		// TODO Auto-generated method stub
//		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
//		String numberAsString = numberFormat.format(l);
//		System.out.println(s + numberAsString);
//	}

}
