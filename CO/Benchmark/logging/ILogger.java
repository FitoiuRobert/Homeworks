package logging;

public interface ILogger {
	public void write(long value);
	public void write(Object ... values);
	public void writeTime(long value, TimeUnit unit);
	public void writeTime(String string, long value, TimeUnit unit);
	public void close();
}
