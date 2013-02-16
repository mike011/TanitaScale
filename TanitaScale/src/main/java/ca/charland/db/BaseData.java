package ca.charland.db;

import java.util.Date;

public class BaseData extends Data {
	
	private long person;

	private Date date;
	
	public long getPerson() {
		return person;
	}

	public void setPerson(long person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
