package nature;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Observer;

import lem.Lem;

import org.junit.Before;
import org.junit.Test;

public class NewtonTest {

	private Newton newton;
	
	@Before public void
	init() {
		newton = new Newton();
	}
	
	@Test public void
	isObserver() {
		assertTrue(newton instanceof Observer);
	}
	
	@Test public void
	changesLemAltitudeEachTic() {
		Lem lemMock = mock(Lem.class);
		newton.setLem(lemMock);
		newton.update(null, null);
		verify(lemMock).setAltitude(anyInt());
	}
	
	@Test public void
	youCannotNegociateWithNewton() {
		Lem lem = new Lem();
		lem.setAltitude(10);
		newton.setLem(lem);
		newton.update(null, null);
		assertThat(lem.getAltitude(), equalTo(9));
	}
	
}
