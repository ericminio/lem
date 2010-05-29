package nature;

import lem.Lem;

public class Newton {

	private Lem lem;

	public void setLem(Lem aLem) {
		lem = aLem;
	}

	public void tic() {
		lem.setAltitude(lem.getAltitude() - 1);
	}

	public Lem getLem() {
		return lem;
	}

}
