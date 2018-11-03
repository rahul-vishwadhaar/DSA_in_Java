/**
 * 
 */
package com.fcs.authenticationTest;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fcs.authentication.Authentication;

/**
 * @author rahul kumar
 * 
 */
public class AuthenticationTest {

	private Authentication auth = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		auth = new Authentication();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateValidCredentials() {
		String userName = "admin";
		char[] password = "admin".toCharArray();

		assertTrue(auth.validate(userName, password));
	}

	@Test
	public void testValidatewithNullValues() {
		assertFalse(auth.validate(null, null));
	}

	@Test
	public void testValidatewithInvalidCredentials() {

		String userName = "admin";
		char[] password = "admin1".toCharArray();
		assertFalse(auth.validate(userName, password));
	}

	@Test
	public void testvalidateFromDBValidValues() {

		Method validateFromDB;

		String userName = "admin";
		char[] password = "admin".toCharArray();

		try {
			validateFromDB = initValidateFromDB();

			assertTrue((boolean) validateFromDB.invoke(userName, password));

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testvalidateFromDBNullValues() {

		Method validateFromDB = null;

		try {
			validateFromDB = initValidateFromDB();

			assertFalse((boolean) validateFromDB.invoke((String) null,
					(char[]) null));

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testvalidateFromDBInvalidValues() {

		Method validateFromDB;

		String userName = "admin";
		char[] password = "admin1".toCharArray();

		try {
			validateFromDB = initValidateFromDB();

			validateFromDB.invoke(userName, password);

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	private Method initValidateFromDB() throws NoSuchMethodException,
			SecurityException {

		Class[] cArg = new Class[2];
		cArg[0] = String.class;
		cArg[1] = long.class;

		Method validateFromDB = Authentication.class.getDeclaredMethod(
				"validateFromDB", cArg);

		validateFromDB.setAccessible(true);

		return validateFromDB;
	}

}
