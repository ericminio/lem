package lem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

public class LemTest {

	private Lem lem;
	
	@Before public void
	init() {
		lem = new Lem();
	}
	
	@Test public void
	canModifyAltitude() {
		lem.setAltitude(50);
		assertThat(lem.getAltitude(), equalTo(50));
		lem.setAltitude(40);
		assertThat(lem.getAltitude(), equalTo(40));
	}
	
	@Test public void
	isObservable() {
		assertTrue(lem instanceof Observable);
	}
	
	@Test public void
	notifyObserversWhenAltitudeIsSet() {
		Observer observerMock = mock(Observer.class);
		lem.addObserver(observerMock);
		lem.setAltitude(40);
		verify(observerMock).update(lem, null);
	}
}
