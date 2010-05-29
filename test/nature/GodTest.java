package nature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import lem.LemGui;

import org.junit.Before;
import org.junit.Test;

public class GodTest {

	private God god;

	@Before
	public void init() {
		god = new God();
	}
	
	@Test public void
	createsTime() {
		god.day1();
		assertNotNull(god.getTime());
		assertTrue(god.getTime().isStarted());
	}
	
	@Test public void
	createsPhysicalLaw() {
		god.day1();
		god.day2();
		assertNotNull(god.getNewton());
	}

	@Test public void
	makesTheWorldMovable() {
		god.day1();
		Time timeMock = mock(Time.class);
		god.setTime(timeMock);
		god.day2();
		verify(timeMock).addObserver(god.getNewton());
	}
	
	@Test public void
	createsLemConcept() {
		god.day1();
		god.day2();
		god.day3();
		assertEquals(god.getLem(), god.getNewton().getLem());
		assertEquals(god.getLem().getAltitude(), 50);
	}
	
	@Test public void
	makesLemTangible() {
		god.day1();
		god.day2();
		god.day3();
		god.day4();
		assertNotNull(god.getLemGui());
	}
	
	@Test public void
	givesLife() {
		god.day1();
		god.day2();
		god.day3();
		god.day4();
		LemGui guiMock = mock(LemGui.class);
		god.setLemGui(guiMock);
		god.day5();
		verify(god.getLemGui()).update(anyInt());
	}
	
	@Test public void
	createsLight() {
		god.day1();
		god.day2();
		god.day3();
		god.day4();
		god.day5();
		god.day6();
		assertTrue(god.getLemGui().isVisible());
		assertTrue(god.getLemGui().getWidth() > 0);
		assertTrue(god.getLemGui().getHeight() > 0);
	}
	
	@Test public void
	justRelax() {
		god.day7();
	}
}
