package ca.charland.tanitascale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class DayData implements Comparable<DayData>{

	private Map<Column, String> values;

	public DayData(Map<Column, String> values) {
		this.values = values;
	}

	public Set<Column> keySet() {
		return values.keySet();
	}

	public String get(Column col) {
		return values.get(col);
	}

	@Override
	public int compareTo(DayData o) {
		Date date1 = getDate(this);
		Date date2 = getDate(o);
		return date1.compareTo(date2);
	}

	private Date getDate(DayData values) {
		String date = values.get(Column.DATE);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
         try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
