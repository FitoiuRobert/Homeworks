package timing;
/**
 * 
 * Timer for the benchmarking process
 * 
 * @author Fitoiu
 *
 */
public class Timer implements ITimer{

	private long totalTime, elapsedTime;
	boolean paused = false;
	
	@Override
	public void start() {
		this.totalTime = 0;
		this.elapsedTime = System.nanoTime();
	}

	@Override
	public long stop() {
		long tmp = System.nanoTime() - this.elapsedTime;
		if(paused)
			return this.totalTime;
		return tmp;
	}

	@Override
	public long pause() {
		this.paused = true;
		this.elapsedTime = System.nanoTime() - this.elapsedTime;
		this.totalTime += this.elapsedTime;
		return this.elapsedTime;
	}

	@Override
	public void resume() {
		this.elapsedTime = System.nanoTime();
	}

	
}
