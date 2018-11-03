import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MedianSortedArraysTest {

	static MedianTwoSortedArrays median = null;
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

	@SuppressWarnings("deprecation")
	@Test
	public void testMedian1() {
		
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.add(-50);
		a.add(-41);
		a.add(-40);
		a.add(-19);
		a.add(5);
		a.add(21);
		a.add(28);

		ArrayList<Integer> b = new ArrayList<Integer>();

		b.add(-50);
		b.add(-21);
		b.add(-10);
		Assert.assertEquals(-30.0, MedianTwoSortedArrays.median(a, b), 0.0);
	}

}
