package nature;


public class Time {
	
	private Newton newton;
	private Thread time;
	private boolean started;

	public Time() {
		started = false;
	}

	public void setNewton(Newton newton) {
		this.newton = newton;
	}

	public void start() {
		Runnable runnable = new Runnable() {
			
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					newton.tic();
				}
			}
		};
		time = new Thread(runnable);
		started = true;
		time.start();
	}

	public Newton getNewton() {
		return newton;
	}

	public boolean isStarted() {
		return started;
	}
}