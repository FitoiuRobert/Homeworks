package benchmark;

public interface IBenchmark {
	public void run();
	public void run(Object ... params);
	public void initialize(Object ... params);
	public void clean();
	public void cancel();
}
