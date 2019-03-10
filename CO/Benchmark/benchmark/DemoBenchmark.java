package benchmark;

import java.util.Random;

public class DemoBenchmark implements IBenchmark {

	private int[] array;
	private Integer n;

	@Override
	public void run() {
		int tmp;
		for(int i = 0; i < n-1; ++i)
			for(int j = i+1; j < n; ++j)
				if(array[i] < array[j]) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
	}

	@Override
	public void run(Object... params) {
		int s = (int) params[0];
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(Object... params) {
		Random random = new Random();
		this.n = (Integer) params[0];
		this.array = new int[n];
		
		for(int i = 0; i < n; ++i)
			array[i] = random.nextInt(1000);
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}
