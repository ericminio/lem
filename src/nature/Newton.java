package nature;

import java.util.Observable;
import java.util.Observer;

import lem.Lem;

public class Newton implements Observer {

	private Lem lem;

	public void setLem(Lem aLem) {
		lem = aLem;
	}

	public Lem getLem() {
		return lem;
	}

	public void update(Observable o, Object arg) {
		lem.setAltitude(lem.getAltitude() - 1);
	}

}
