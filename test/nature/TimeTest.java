package nature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Observable;
import java.util.Observer;

import nature.Time;

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
	timeNeverStops() throws InterruptedException {
		time.setPeriod(10);
		Observer observerMock = mock(Observer.class);
		time.addObserver(observerMock);
		time.start();
		Thread.currentThread().sleep(30);
		verify(observerMock, atLeast(2)).update(time, null);
	}
	
	@Test public void
	indicatesWhenStarted() {
		assertFalse(time.isStarted());
		time.start();
		assertTrue(time.isStarted());
	}
}
