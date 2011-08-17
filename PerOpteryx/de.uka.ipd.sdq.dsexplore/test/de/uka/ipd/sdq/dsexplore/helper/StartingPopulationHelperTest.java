package de.uka.ipd.sdq.dsexplore.helper;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.startingPopulation.impl.StartingPopulationHeuristicImpl;

public class StartingPopulationHelperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetResourceContainers() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAllocationContexts() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetNumberOfComponentsPerResourceContainer() {
		Collection<Integer> numbers = StartingPopulationHeuristicImpl.getNumberOfComponentsPerResourceContainer(10, 3);
		assertEquals(3, numbers.size());
		Iterator<Integer> iterator = numbers.iterator();
		assertEquals(3, (int)iterator.next());
		assertEquals(3, (int)iterator.next());
		assertEquals(4, (int)iterator.next());
		
		numbers = StartingPopulationHeuristicImpl.getNumberOfComponentsPerResourceContainer(11, 3);
		assertEquals(3, numbers.size());
		iterator = numbers.iterator();
		assertEquals(3, (int)iterator.next());
		assertEquals(4, (int)iterator.next());
		assertEquals(4, (int)iterator.next());
		
		numbers = StartingPopulationHeuristicImpl.getNumberOfComponentsPerResourceContainer(12, 3);
		assertEquals(3, numbers.size());
		iterator = numbers.iterator();
		assertEquals(4, (int)iterator.next());
		assertEquals(4, (int)iterator.next());
		assertEquals(4, (int)iterator.next());
		
		numbers = StartingPopulationHeuristicImpl.getNumberOfComponentsPerResourceContainer(11, 7);
		assertEquals(7, numbers.size());
		iterator = numbers.iterator();
		assertEquals(1, (int)iterator.next());
		assertEquals(1, (int)iterator.next());
		assertEquals(1, (int)iterator.next());
		assertEquals(2, (int)iterator.next());
		assertEquals(2, (int)iterator.next());
		assertEquals(2, (int)iterator.next());
		assertEquals(2, (int)iterator.next());
		
		numbers = StartingPopulationHeuristicImpl.getNumberOfComponentsPerResourceContainer(0, 2);
		assertEquals(2, numbers.size());
		iterator = numbers.iterator();
		assertEquals(0, (int)iterator.next());
		assertEquals(0, (int)iterator.next());
	}

}
