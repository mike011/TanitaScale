package ca.charland.tanitascale.TanitaScaleReporter;

/**************************************************************
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 *************************************************************/

// __________ Imports __________

import java.util.Map;
import java.util.TreeMap;

import ooo.connector.BootstrapSocketConnector;

import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.XPropertySet;
import com.sun.star.comp.helper.BootstrapException;
import com.sun.star.container.XIndexAccess;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.IndexOutOfBoundsException;
import com.sun.star.lang.Locale;
import com.sun.star.lang.WrappedTargetException;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.XSpreadsheet;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheets;
import com.sun.star.table.XCell;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.NumberFormat;
import com.sun.star.util.XNumberFormatTypes;
import com.sun.star.util.XNumberFormats;
import com.sun.star.util.XNumberFormatsSupplier;

public class NumberFormats {

	private XComponentContext officeContext;
	private XMultiComponentFactory maServiceManager;
	private XSpreadsheetDocument document;
	private XSpreadsheet sheet; // the first sheet

	public static void main(String args[]) {
		Map<Column, String> values = new TreeMap<Column, String>();
		values.put(Column.DATE, "2013/12/12");
		values.put(Column.WEIGHT, "156");
		values.put(Column.DAILY_CALORIC_INTAKE, "3925");
		values.put(Column.METABOLIC_AGE, "15");
		values.put(Column.BODY_WATER_PERCENTAGE, ".656");
		values.put(Column.VISCERAL_FAT, "1");
		values.put(Column.BONE_MASS, "6.8");
	
		NumberFormats aSample = new NumberFormats(args);
		aSample.printValues(values);
	}

	// ____________________

	public void printValues(Map<Column, String> values) {

		int x = 0;
		for (Column col : values.keySet()) {
			String value = values.get(col);

			switch (col) {
			case DATE:
				setDate((String) value, x++);
				setFormula("=MONTH(A1)", x++, 0, NumberFormat.NUMBER);
				break;
			case WEIGHT:
			case DAILY_CALORIC_INTAKE:
			case METABOLIC_AGE:				
				setDouble(value, x++);
				break;
			case BODY_WATER_PERCENTAGE:
				setPercentage(value, x++);
				break;
			case VISCERAL_FAT:
			case BONE_MASS:
				setDouble(value, x++);
				break;
			case BODY_FAT_TOTAL:
			case BODY_FAT_LEFT_ARM:
			case BODY_FAT_RIGHT_ARM:
			case BODY_FAT_RIGHT_LEG:
			case BODY_FAT_LEFT_LEG:
			case BODY_FAT_TRUNK:
				setPercentage(value, x++);
				break;
			case MUSCLE_MASS_TOTAL:
			case MUSCLE_MASS_LEFT_ARM:
			case MUSCLE_MASS_RIGHT_ARM:
			case MUSCLE_MASS_RIGHT_LEG:
			case MUSCLE_MASS_LEFT_LEG:
			case MUSCLE_MASS_TRUNK:
			case PHYSIC_RATING:
				setDouble(value, x++);
				break;
			default:
				break;
			}
		}
	}

	private void setPercentage(String value, int x) {
		setValue(Double.parseDouble(value), x++, 0, NumberFormat.PERCENT);
	}

	private void setDate(String date, int x) {
		setFormula("01/28/2013", x++, 0, NumberFormat.DATE);
	}

	private void setDouble(String value, int x) {
		setValue(Double.parseDouble(value), x++, 0, NumberFormat.NUMBER);
	}

	private void setValue(double value, int x, int y, short format) {
		XCell xCell = getCell(x, y);
		xCell.setValue(value);
		setFormat(x, y, format);
	}

	private void setFormula(String formula, int x, int y, short format) {
		XCell xCell = getCell(x, y);
		xCell.setFormula(formula);
		setFormat(x, y, format);
	}

	private XCell getCell(int x, int y) {
		try {
			return sheet.getCellByPosition(x, y);
		} catch (IndexOutOfBoundsException e) {
			throw new SpreadSheetException();
		}
	}

	private void setFormat(int x, int y, short format) {
		// Query the number formats supplier of the spreadsheet document
		XNumberFormatsSupplier numberFormatsSupplier = (XNumberFormatsSupplier) UnoRuntime.queryInterface(XNumberFormatsSupplier.class, document);

		// Get the number formats from the supplier
		XNumberFormats numberFormats = numberFormatsSupplier.getNumberFormats();

		// Query the XNumberFormatTypes interface
		XNumberFormatTypes numberFormatTypes = (XNumberFormatTypes) UnoRuntime.queryInterface(XNumberFormatTypes.class, numberFormats);

		// Get the number format index key of the default currency format,
		// note the empty locale for default locale
		Locale aLocale = new Locale();
		int key = numberFormatTypes.getStandardFormat(format, aLocale);

		// Get cell
		XCell cell = null;
		try {
			cell = sheet.getCellByPosition(x, y);
		} catch (IndexOutOfBoundsException e) {
			throw new SpreadSheetException();
		}

		// Query the property set of the cell range
		XPropertySet xCellProp = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, cell);

		// Set number format
		try {
			xCellProp.setPropertyValue("NumberFormat", key);
		} catch (Exception e) {
			throw new SpreadSheetException();
		}
	}

	private static final String oooExeFolder = "C:/Program Files (x86)/LibreOffice 3.6/program";

	// ____________________

	public NumberFormats(String[] args) {
		// get the remote office context. If necessary a new office
		// process is started
		try {
			officeContext = BootstrapSocketConnector.bootstrap(oooExeFolder);
		} catch (BootstrapException e) {
			throw new SpreadSheetException();
		}

		System.out.println("Connected to a running office ...");
		maServiceManager = officeContext.getServiceManager();

		// create a new spreadsheet document
		XComponentLoader aLoader = null;
		try {
			aLoader = (XComponentLoader) UnoRuntime.queryInterface(XComponentLoader.class,
					maServiceManager.createInstanceWithContext("com.sun.star.frame.Desktop", officeContext));
		} catch (com.sun.star.uno.Exception e) {
			throw new SpreadSheetException();
		}

		try {
			document = (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class,
					aLoader.loadComponentFromURL("private:factory/scalc", "_blank", 0, new PropertyValue[0]));
		} catch (Exception e) {
			throw new SpreadSheetException();
		}
		initSpreadsheet();
	}

	// ____________________

	/**
	 * init the first sheet
	 */
	private void initSpreadsheet() {
		XSpreadsheets aSheets = document.getSheets();
		XIndexAccess aSheetsIA = (XIndexAccess) UnoRuntime.queryInterface(XIndexAccess.class, aSheets);
		try {
			sheet = (XSpreadsheet) UnoRuntime.queryInterface(XSpreadsheet.class, aSheetsIA.getByIndex(0));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (WrappedTargetException e) {
			e.printStackTrace();
		}
	}
}