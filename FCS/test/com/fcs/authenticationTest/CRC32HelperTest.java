package com.fcs.authenticationTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fcs.authentication.CRC32Helper;

public class CRC32HelperTest {

	private CRC32Helper crc = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		crc = new CRC32Helper();
	}

	@After
	public void tearDown() throws Exception {
		crc = null;
	}

	@Test
	public void testcrc32FromStringSucess() {

		long expected = 63605748;
		long result = crc.crc32FromString("SampleString");
		assertEquals(expected, result);
	}

	@Test
	public void testcrc32FromStringFailure() {

		long expected = 12232;
		long result = crc.crc32FromString("SampleString");
		assertNotEquals(expected, result);
	}

}
