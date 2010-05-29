package lem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

public class LemGuiTest {

	private LemGui gui;
	
	@Before public void
	init() {
		gui = new LemGui();
		assertEquals(gui.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);
	}
	
	@Test public void
	acceptsAbsolutePositions() {
		assertNull(gui.getContentPane().getLayout());
	}
	
	@Test public void
	containsTheLemPanel() {
		Component[] comps = gui.getContentPane().getComponents();
		assertEquals(1, comps.length);
		assertEquals(comps[0], gui.getLemPanel());
	}
	
	@Test public void
	lemPanelIsVisible() {
		assertEquals(Color.green.darker(), gui.getLemPanel().getBackground());
		assertEquals(gui.getLemPanel().getWidth(), 10);
		assertEquals(gui.getLemPanel().getHeight(), 10);
	}
	
	@Test public void
	spaceSize() {
		assertEquals(300, gui.getWidth());
		assertEquals(200, gui.getHeight());
	}
	
	@Test public void
	lemPositionMovesWithAltitude() {
		gui.update(50);
		assertEquals(new Point(100, 5), gui.getLemPanel().getLocation());
		gui.update(40);
		assertEquals(new Point(100, 25), gui.getLemPanel().getLocation());
		gui.update(0);
		assertEquals(new Point(100, 105), gui.getLemPanel().getLocation());
	}
	
}
