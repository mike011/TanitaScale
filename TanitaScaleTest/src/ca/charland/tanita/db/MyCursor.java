/*
 * 
 */
package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/**
 * Custom cursor for testing.
 * 
 * @author mcharland
 * 
 */
class MyCursor implements Cursor {

	/** The long value. */
	private List<Long> longValue = new ArrayList<Long>();
	
	/** The string value. */
	private String stringValue;

	/** {@inheritDoc} */
	@Override
	public int getCount() {
		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public int getPosition() {
		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public boolean move(int offset) {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean moveToPosition(int position) {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean moveToFirst() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean moveToLast() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean moveToNext() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean moveToPrevious() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isFirst() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isLast() {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isBeforeFirst() {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAfterLast() {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public int getColumnIndex(String columnName) {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public String getColumnName(int columnIndex) {

		return null;
	}

	/** {@inheritDoc} */
	@Override
	public String[] getColumnNames() {

		return null;
	}

	/** {@inheritDoc} */
	@Override
	public int getColumnCount() {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public byte[] getBlob(int columnIndex) {

		return null;
	}

	/** {@inheritDoc} */
	@Override
	public String getString(int columnIndex) {

		return stringValue;
	}
	
	/**
	 * Sets the string.
	 *
	 * @param newStringValue the new string
	 */
	void setString(String newStringValue) {
		this.stringValue = newStringValue;
	}

	/** {@inheritDoc} */
	@Override
	public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {

	}

	/** {@inheritDoc} */
	@Override
	public short getShort(int columnIndex) {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public int getInt(int columnIndex) {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public long getLong(int columnIndex) {

		return longValue.get(columnIndex);
	}
	
	void setLong(long newLongValue) {
		this.longValue.add(newLongValue);
	}

	/** {@inheritDoc} */
	@Override
	public float getFloat(int columnIndex) {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public double getDouble(int columnIndex) {

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isNull(int columnIndex) {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public void deactivate() {

	}

	/** {@inheritDoc} */
	@Override
	public boolean requery() {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public void close() {

	}

	/** {@inheritDoc} */
	@Override
	public boolean isClosed() {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public void registerContentObserver(ContentObserver observer) {

	}

	/** {@inheritDoc} */
	@Override
	public void unregisterContentObserver(ContentObserver observer) {

	}

	/** {@inheritDoc} */
	@Override
	public void registerDataSetObserver(DataSetObserver observer) {

	}

	/** {@inheritDoc} */
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {

	}

	/** {@inheritDoc} */
	@Override
	public void setNotificationUri(ContentResolver cr, Uri uri) {

	}

	/** {@inheritDoc} */
	@Override
	public boolean getWantsAllOnMoveCalls() {

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public Bundle getExtras() {

		return null;
	}

	/** {@inheritDoc} */
	@Override
	public Bundle respond(Bundle extras) {

		return null;
	}

}
