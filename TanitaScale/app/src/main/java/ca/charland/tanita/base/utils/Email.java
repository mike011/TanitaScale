package ca.charland.tanita.base.utils;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import android.content.Intent;

/**
 * @author mcharland
 */
public class Email {

	/**
	 * @author mcharland
	 */
	private class Pair {

		private String key;

		private String value;

		Pair(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}

	private String to;

	private String subject;

	private List<Pair> pairs;

	public Email() {
		pairs = new ArrayList<Pair>();
	}

	public String getToAddress() {
		return to;
	}

	public void setToAdress(String address) {
		this.to = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	private String getLine(Pair pair) {
		StringBuffer line = new StringBuffer();
		line.append(pair.getKey());
		line.append(" = ");
		line.append(pair.getValue());
		line.append('\r');
		line.append('\n');
		return line.toString();
	}

	public String getBody() {
		StringBuffer body = new StringBuffer();
		for (Pair p : pairs) {
			body.append(getLine(p));
		}
		return body.toString();
	}

	public void addToBodyDouble(String key, double value) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("%.1f", value);
		addToBody(key, sb.toString());
		formatter.close();
	}

	public void addToBodyPercent(String key, double value) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("%.1f", value);
		sb.append('%');
		addToBody(key, sb.toString());
		formatter.close();
	}

	public void addToBodyInteger(String key, int value) {
		addToBody(key, String.valueOf(value));
	}

	public void addToBody(String key, String value) {
		this.pairs.add(new Pair(key, value));
	}

	public Intent getIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getToAddress() });
		intent.putExtra(Intent.EXTRA_SUBJECT, getSubject());
		intent.putExtra(Intent.EXTRA_TEXT, getBody());
		return intent;
	}
}
