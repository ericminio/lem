package nature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import nature.Time;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {

	private Time time;
	
	@Before public void
	init() {
		time = new Time();
	}
	
	public void
	timeNeverStops() throws InterruptedException {
		Newton newtonMock = mock(Newton.class);
		time.setNewton(newtonMock);
		time.start();
		Thread.currentThread().sleep(3000);
		verify(newtonMock, atLeast(2)).tic();
	}
	
	@Test public void
	indicatesWhenStarted() {
		assertFalse(time.isStarted());
		time.start();
		assertTrue(time.isStarted());
	}
}
