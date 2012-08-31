package ca.charland.tanita.manage;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import android.content.Intent;

/**
 * Holds an Email.
 * 
 * @author mcharland
 */
public class Email {

	/**
	 * The Class Pair.
	 * 
	 * @author mcharland
	 */
	private class Pair {

		/** The key. */
		private String key;

		/** The value. */
		private String value;

		/**
		 * Instantiates a new pair.
		 * 
		 * @param key
		 *            the key
		 * @param value
		 *            the value
		 */
		Pair(String key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Gets the key.
		 * 
		 * @return the key
		 */
		public String getKey() {
			return key;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
	}

	/** The to. */
	private String to;

	/** The subject. */
	private String subject;

	/** The pairs. */
	private List<Pair> pairs;

	public Email() {
		pairs = new ArrayList<Pair>();
	}

	/**
	 * Gets the to.
	 * 
	 * @return the to
	 */
	public String getToAddress() {
		return to;
	}

	/**
	 * Sets the to.
	 * 
	 * @param address
	 *            the new to
	 */
	public void setToAdress(String address) {
		this.to = address;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject
	 *            the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * A quick format to make the lines outputted to the email body consistent.
	 * 
	 * @param id
	 *            the id
	 * @param extracted
	 *            (value) the value
	 * @return the line
	 */
	private String getLine(Pair pair) {
		StringBuffer line = new StringBuffer();
		line.append(pair.getKey());
		line.append(" = ");
		line.append(pair.getValue());
		line.append('\r');
		line.append('\n');
		return line.toString();
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		StringBuffer body = new StringBuffer();
		for (Pair p : pairs) {
			body.append(getLine(p));
		}
		return body.toString();
	}

	/**
	 * Adds to the body a double value.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void addToBodyDouble(String key, double value) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("%.1f", value);
		addToBody(key, sb.toString());
	}

	/**
	 * Adds to the body a percent value.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void addToBodyPercent(String key, double value) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("%.1f", value);
		sb.append('%');
		addToBody(key, sb.toString());
	}

	/**
	 * Adds to the body an integer value.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void addToBodyInteger(String key, int value) {
		addToBody(key, String.valueOf(value));

	}

	/**
	 * Adds the to body.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private void addToBody(String key, String value) {
		this.pairs.add(new Pair(key, value));
	}

	/**
	 * Gets the intent.
	 * 
	 * @return the intent
	 */
	public Intent getIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getToAddress() });
		intent.putExtra(Intent.EXTRA_SUBJECT, getSubject());
		intent.putExtra(Intent.EXTRA_TEXT, getBody());
		return intent;
	}
}
