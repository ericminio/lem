package lem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
}
