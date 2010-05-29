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
	createsTheNature_thisWasDay1() {
		god.day1();
		assertNotNull(god.getNewton());
	}
	
	@Test public void
	createsTheLemConcept_ThisWasDay2() {
		god.day1();
		god.day2();
		assertEquals(god.getLem(), god.getNewton().getLem());
		assertEquals(god.getLem().getAltitude(), 50);
	}
	
	@Test public void
	givesASkinToTheLem_ThisWasDay3() {
		god.day1();
		god.day2();
		god.day3();
		assertNotNull(god.getLemGui());
	}
	
	@Test public void
	joinTheOpposites_ThisWasDay4() {
		god.day1();
		god.day2();
		god.day3();
		LemGui guiMock = mock(LemGui.class);
		god.setLemGui(guiMock);
		god.day4();
		verify(god.getLemGui()).update(anyInt());
	}
	
	@Test public void
	createsLight_ThisWasDay5() {
		god.day1();
		god.day2();
		god.day3();
		god.day4();
		god.day5();
		assertTrue(god.getLemGui().isVisible());
		assertTrue(god.getLemGui().getWidth() > 0);
		assertTrue(god.getLemGui().getHeight() > 0);
	}
	
	@Test public void
	createsTimeAndStartIt_ThisWasDay6() {
		god.day1();
		god.day2();
		god.day3();
		god.day4();
		god.day5();
		god.day6();
		assertNotNull(god.getTime());
		assertEquals(god.getNewton(), god.getTime().getNewton());
		assertTrue(god.getTime().isStarted());
	}
	
	@Test public void
	justRelaxOnDay7() {
		god.day1();
		god.day2();
		god.day3();
		god.day4();
		god.day5();
		god.day6();
		god.day7();
	}
}
