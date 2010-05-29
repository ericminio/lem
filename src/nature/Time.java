package nature;

import java.util.Observable;

public class Time extends Observable {
	
	private int period;
	private boolean started;

	public Time() {
		started = false;
		setPeriod(1000);
	}
	
	public boolean isStarted() {
		return started;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getPeriod() {
		return period;
	}

	public void start() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep(period);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					setChanged();
					notifyObservers(period);
				}
			}
		}).start();
		started = true;
	}
}