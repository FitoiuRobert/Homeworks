package testbench;

import timing.*;
import benchmark.DemoBenchmark;
import benchmark.IBenchmark;
import logging.*;

public class Testbench {

	public static void main(String[] args) {
		ITimer timer = new Timer();
		ILogger clog = new ConsoleLogger();
		ILogger flog = new FileLogger("test.txt");
		IBenchmark bench = new DemoBenchmark();
		TimeUnit timeUnit = TimeUnit.Sec;
		
		timer.start();
		final int workload = 100;
		bench.initialize(workload);
		for(int i = 0; i < 12; ++i) {
			timer.resume();
			bench.run();
			long _time = timer.pause();
			clog.writeTime(_time, timeUnit);
//			flog.writeTime(_time, timeUnit);
//			clog.write("Run ", i, ": ", _time);
//			clog.write(_time,"");
		}
		long time = timer.stop();
		clog.writeTime("Finished in ", time, timeUnit);
//		flog.writeTime("Finished in ", time, timeUnit);
//		flog.close();
	}
}
