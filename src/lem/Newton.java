package lem;

public class Newton {

	private Lem lem;
	private Thread time;
	
	public void setLem(Lem aLem) {
		lem = aLem;
	}

	public void tic() {
		lem.setAltitude(lem.getAltitude() - 1);
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
					tic();
				}
			}
		};
		time = new Thread(runnable);
		time.start();
	}

}
