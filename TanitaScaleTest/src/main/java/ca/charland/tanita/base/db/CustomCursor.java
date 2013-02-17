package ca.charland.tanita.base.db;

import java.util.Map;
import java.util.TreeMap;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public class CustomCursor implements Cursor {

	private Map<Integer, Object> values = new TreeMap<Integer, Object>();

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public int getPosition() {
		return 0;
	}

	@Override
	public boolean move(int offset) {
		return false;
	}

	@Override
	public boolean moveToPosition(int position) {
		return false;
	}

	@Override
	public boolean moveToFirst() {
		return false;
	}

	@Override
	public boolean moveToLast() {
		return false;
	}

	@Override
	public boolean moveToNext() {
		return false;
	}

	@Override
	public boolean moveToPrevious() {
		return false;
	}

	@Override
	public boolean isFirst() {
		return false;
	}

	@Override
	public boolean isLast() {
		return false;
	}

	@Override
	public boolean isBeforeFirst() {
		return false;
	}

	@Override
	public boolean isAfterLast() {
		return false;
	}

	@Override
	public int getColumnIndex(String columnName) {
		return 0;
	}

	@Override
	public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return null;
	}

	@Override
	public String[] getColumnNames() {
		return null;
	}

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public byte[] getBlob(int columnIndex) {
		return null;
	}

	@Override
	public String getString(int columnIndex) {
		return (String) values.get(columnIndex);
	}

	public void setString(Integer key, String newStringValue) {
		values.put(key, newStringValue);
	}

	@Override
	public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
	}

	@Override
	public short getShort(int columnIndex) {
		return 0;
	}

	@Override
	public int getInt(int columnIndex) {
		return (Integer) values.get(columnIndex);
	}

	public void setInt(Integer key, int amount) {
		values.put(key, amount);

	}

	@Override
	public long getLong(int columnIndex) {
		return (Long) values.get(columnIndex);
	}

	public void setLong(Integer key, long newLongValue) {
		values.put(key, newLongValue);
	}

	@Override
	public float getFloat(int columnIndex) {
		return 0;
	}

	@Override
	public double getDouble(int columnIndex) {
		return (Double) values.get(columnIndex);
	}

	public void setDouble(Integer key, double d) {
		values.put(key, d);
	}

	@Override
	public boolean isNull(int columnIndex) {
		return false;
	}

	@Override
	public void deactivate() {
	}

	@Override
	public boolean requery() {
		return false;
	}

	@Override
	public void close() {

	}

	@Override
	public boolean isClosed() {

		return false;
	}

	@Override
	public void registerContentObserver(ContentObserver observer) {

	}

	@Override
	public void unregisterContentObserver(ContentObserver observer) {

	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {

	}

	@Override
	public void setNotificationUri(ContentResolver cr, Uri uri) {
	}

	@Override
	public boolean getWantsAllOnMoveCalls() {
		return false;
	}

	@Override
	public Bundle getExtras() {
		return null;
	}

	@Override
	public Bundle respond(Bundle extras) {
		return null;
	}
}
