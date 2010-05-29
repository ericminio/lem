package lem;

import java.util.Observable;

public class Lem extends Observable {

	private int altitude;
	
	public void setAltitude(int newAltitude) {
		altitude = newAltitude;
		setChanged();
		notifyObservers();
	}

	public int getAltitude() {
		return altitude;
	}

}
