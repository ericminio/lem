package lem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class NewtonTest {

	private Newton newton;
	
	@Before public void
	init() {
		newton = new Newton();
	}
	
	@Test public void
	changesLemAltitudeEachTic() {
		Lem lemMock = mock(Lem.class);
		newton.setLem(lemMock);
		newton.tic();
		verify(lemMock).setAltitude(anyInt());
	}
	
	@Test public void
	youCannotNegociateWithNewton() {
		Lem lem = new Lem();
		lem.setAltitude(10);
		newton.setLem(lem);
		newton.tic();
		assertThat(lem.getAltitude(), equalTo(9));
	}
	
	@Test public void
	theLawOfNewtoNeverStops() throws InterruptedException {
		Lem lemMock = mock(Lem.class);
		newton.setLem(lemMock);
		newton.start();
		Thread.currentThread().sleep(3000);
		verify(lemMock, atLeast(2)).setAltitude(anyInt());
	}
}
