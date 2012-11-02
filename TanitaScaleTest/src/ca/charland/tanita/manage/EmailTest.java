package ca.charland.tanita.manage;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class EmailTest {

	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#getToAddress()}.
	 */
	@Test
	public void testGetTo() {
		Email email = new Email();
		String expected = "frank@hotmail.com";
		email.setToAdress(expected);
		assertEquals(expected, email.getToAddress());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#getSubject()}.
	 */
	@Test
	public void testGetSubject() {
		Email email = new Email();
		String expected = new Date().toString();
		email.setSubject(expected);
		assertEquals(expected, email.getSubject());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyDouble(String, double)}.
	 */
	@Test
	public void testAddToBodyDoubleExtraDigit() {
		Email email = new Email();
		String key = "key";
		double value = 1.53;
		email.addToBodyDouble(key, value);
		String expected = "key = 1.5\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyDouble(String, double)}.
	 */
	@Test
	public void testAddToBodyDoubleNoDigit() {
		Email email = new Email();
		String key = "key";
		double value = 1.;
		email.addToBodyDouble(key, value);
		String expected = "key = 1.0\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyDouble(String, double)}.
	 */
	@Test
	public void testAddToBodyDoubleZero() {
		Email email = new Email();
		String key = "key";
		double value = 0;
		email.addToBodyDouble(key, value);
		String expected = "key = 0.0\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyPercent(String, double)}.
	 */
	@Test
	public void testAddToBodyPercentExtraDigits() {
		Email email = new Email();
		String key = "key";
		double value = 53.013;
		email.addToBodyPercent(key, value);
		String expected = "key = 53.0%\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyPercent(String, double)}.
	 */
	@Test
	public void testAddToBodyPercentNoDigits() {
		Email email = new Email();
		String key = "key";
		double value = 53;
		email.addToBodyPercent(key, value);
		String expected = "key = 53.0%\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyPercent(String, double)}.
	 */
	@Test
	public void testAddToBodyPercentZero() {
		Email email = new Email();
		String key = "key";
		double value = 0;
		email.addToBodyPercent(key, value);
		String expected = "key = 0.0%\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}

	
	/**
	 * Test method for {@link ca.charland.tanita.manage.Email#addToBodyPercent(String, double)}.
	 */
	@Test
	public void testAddToBodyInteger() {
		Email email = new Email();
		String key = "key";
		int value = 9514;
		email.addToBodyInteger(key, value);
		String expected = "key = 9514\r\n";
		String actual = email.getBody();
		assertEquals(expected, actual);
	}
}
