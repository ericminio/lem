package nature;

import java.util.Observable;
import java.util.Observer;

import lem.Lem;
import lem.LemGui;

public class God implements Observer {

	private Newton newton;
	private Lem lem;
	private LemGui gui;
	private Time time;
	
	public God() {
	}
	
	public Newton getNewton() {
		return newton;
	}

	public LemGui getLemGui() {
		return gui;
	}
	
	public void setLemGui(LemGui gui) {
		this.gui = gui;
	}

	public Lem getLem() {
		return lem;
	}
	
	public Time getTime() {
		return time;
	}

	public void day1() {
		newton = new Newton();
	}

	public void day2() {
		lem = new Lem();
		newton.setLem(lem);
		lem.setAltitude(50);
	}

	public void day3() {
		gui = new LemGui();
	}

	public void day4() {
		lem.addObserver(this);
		gui.update(lem.getAltitude());
	}

	public void update(Observable o, Object arg) {
		gui.update(((Lem)o).getAltitude());
	}

	public void day5() {
		gui.setVisible(true);
	}

	public void day6() {
		time = new Time();
		time.setNewton(newton);
		time.start();
	}

	public void day7() {
		// just relax ;)
	}

	
}
