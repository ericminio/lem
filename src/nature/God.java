package nature;

import java.util.Observable;
import java.util.Observer;

import lem.Lem;
import lem.LemGui;

public class God implements Observer {

	private Time time;
	private Newton newton;
	private Lem lem;
	private LemGui gui;
	
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
	
	public void setTime(Time time) {
		this.time = time;
	}

	public void day1() {
		time = new Time();
		time.start();
	}

	public void day2() {
		newton = new Newton();
		time.addObserver(newton);
	}

	public void day3() {
		lem = new Lem();
		newton.setLem(lem);
		lem.setAltitude(50);
	}

	public void day4() {
		gui = new LemGui();
	}

	public void day5() {
		lem.addObserver(this);
		gui.update(lem.getAltitude());
	}

	public void day6() {
		gui.setVisible(true);
	}

	public void day7() {
		// just relax ;)
	}

	public void update(Observable o, Object arg) {
		gui.update(((Lem)o).getAltitude());
	}
}
