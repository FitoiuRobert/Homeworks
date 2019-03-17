package testbench;

import benchmark.DemoBenchmark;
import benchmark.IBenchmark;
import benchmark.cpu.*;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestDigitsOfPi {

	public static void main(String[] args) {
		ITimer timer = new Timer();
		ILogger clog = new ConsoleLogger();
//		ILogger flog = new FileLogger("test.txt");
//		IBenchmark bench = new DemoBenchmark();
		TimeUnit timeUnit = TimeUnit.Sec;
		
		timer.start();
		CPUDigitsOfPi.calcpi(10);
		for(int i = 0; i < 12; ++i) {
			timer.resume();
			CPUDigitsOfPi.calcpi(20);
			long _time = timer.pause();
			clog.writeTime(_time, timeUnit);
//			flog.writeTime(_time, timeUnit);
//			clog.write("Run ", i, ": ", _time);
//			clog.write(_time,"");
		}
		long time = timer.stop();
		clog.writeTime("Finished in ", time, timeUnit);

	}

}
