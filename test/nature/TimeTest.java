package nature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {

	private Time time;
	
	@Before public void
	init() {
		time = new Time();
	}
	
	@Test public void
	isObservable() {
		assertTrue(time instanceof Observable);
	}
	
	@Test public void
	productionPeriodIsOneSecond() {
		assertEquals(1000, time.getPeriod());
	}
	
	@Test public void
	indicatesWhenStarted() {
		assertFalse(time.isStarted());
		time.start();
		assertTrue(time.isStarted());
	}
	
	@Test public void
	timeNeverStops() throws InterruptedException {
		expectAtLeastGivenTicNumberAfterDelayWhenPeriodIs(2, 30, 10);
		expectAtLeastGivenTicNumberAfterDelayWhenPeriodIs(5, 100, 20); 
	}

	private void expectAtLeastGivenTicNumberAfterDelayWhenPeriodIs(int expectedTics, int delay, int period) throws InterruptedException {
		time.setPeriod(period);
		Observer observerMock = mock(Observer.class);
		time.addObserver(observerMock);
		time.start();
		verify(observerMock, timeout(delay).atLeast(expectedTics)).update(time, period);
	}
	
}
