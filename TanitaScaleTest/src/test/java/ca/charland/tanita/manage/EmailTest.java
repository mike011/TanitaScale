package ca.charland.tanita.manage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.utils.Email;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class EmailTest {

	@Test
	public void testGetTo() {
		Email email = new Email();
		String expected = "frank@hotmail.com";
		email.setToAdress(expected);
		assertThat(email.getToAddress(), is(expected));
	}

	@Test
	public void testGetSubject() {
		Email email = new Email();
		String expected = new Date().toString();
		email.setSubject(expected);
		assertThat(email.getSubject(), is(expected));
	}

	@Test
	public void testAddToBodyDoubleExtraDigit() {
		Email email = new Email();
		String key = "key";
		double value = 1.53;
		email.addToBodyDouble(key, value);
		String expected = "key = 1.5\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}

	@Test
	public void testAddToBodyDoubleNoDigit() {
		Email email = new Email();
		String key = "key";
		double value = 1.;
		email.addToBodyDouble(key, value);
		String expected = "key = 1.0\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}

	@Test
	public void testAddToBodyDoubleZero() {
		Email email = new Email();
		String key = "key";
		double value = 0;
		email.addToBodyDouble(key, value);
		String expected = "key = 0.0\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}

	@Test
	public void testAddToBodyPercentExtraDigits() {
		Email email = new Email();
		String key = "key";
		double value = 53.013;
		email.addToBodyPercent(key, value);
		String expected = "key = 53.0%\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}

	@Test
	public void testAddToBodyPercentNoDigits() {
		Email email = new Email();
		String key = "key";
		double value = 53;
		email.addToBodyPercent(key, value);
		String expected = "key = 53.0%\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}

	@Test
	public void testAddToBodyPercentZero() {
		Email email = new Email();
		String key = "key";
		double value = 0;
		email.addToBodyPercent(key, value);
		String expected = "key = 0.0%\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}

	@Test
	public void testAddToBodyInteger() {
		Email email = new Email();
		String key = "key";
		int value = 9514;
		email.addToBodyInteger(key, value);
		String expected = "key = 9514\r\n";
		String actual = email.getBody();
		assertThat(actual, is(expected));
	}
}
