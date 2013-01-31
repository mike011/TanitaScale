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
import com.sun.star.util.MalformedNumberFormatException;
import com.sun.star.util.NumberFormat;
import com.sun.star.util.XNumberFormatTypes;
import com.sun.star.util.XNumberFormats;
import com.sun.star.util.XNumberFormatsSupplier;

public class Exporter {

	private XComponentContext context;
	private XMultiComponentFactory serviceManager;
	private XSpreadsheetDocument document;
	private XSpreadsheet sheet;

	public static void main(String args[]) {
		parseFiles(args);
	}

	private static void parseFiles(String[] args) {
		for (String arg : args) {
			Parser parser = new Parser();
			Map<Column, String> values = parser.parseFile(LoadFile.load(arg));
			Exporter content = new Exporter();
			content.printValues(values);
		}
	}

	private static final String oooExeFolder = "C:/Program Files (x86)/LibreOffice 3.6/program";
	private XNumberFormatTypes numberFormatTypes;
	private int percentageKey;
	private int doubleKey;
	private int dateKey;
	private int intKey;

	public Exporter() {
		// get the remote office context. If necessary a new office
		// process is started
		try {
			context = BootstrapSocketConnector.bootstrap(oooExeFolder);
		} catch (BootstrapException e) {
			throw new SpreadSheetException();
		}

		System.out.println("Connected to a running office ...");
		serviceManager = context.getServiceManager();

		// create a new spreadsheet document
		XComponentLoader aLoader = null;
		try {
			aLoader = (XComponentLoader) UnoRuntime.queryInterface(XComponentLoader.class,
					serviceManager.createInstanceWithContext("com.sun.star.frame.Desktop", context));
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
		setKeyFormats();
	}

	private void setKeyFormats() {
		// Query the number formats supplier of the spreadsheet document
		XNumberFormatsSupplier numberFormatsSupplier = (XNumberFormatsSupplier) UnoRuntime.queryInterface(XNumberFormatsSupplier.class, document);

		// Get the number formats from the supplier
		XNumberFormats numberFormats = numberFormatsSupplier.getNumberFormats();

		numberFormatTypes = (XNumberFormatTypes) UnoRuntime.queryInterface(XNumberFormatTypes.class, numberFormats);

		// Get the number format index key of the default currency format,
		// note the empty locale for default locale
		Locale aLocale = new Locale();
		try {
			percentageKey = numberFormats.addNew("##.0%", aLocale);
			doubleKey = numberFormats.addNew("##.0", aLocale);
			intKey =numberFormats.addNew("##.#", aLocale);
		} catch (MalformedNumberFormatException e) {
			e.printStackTrace();
		}
		dateKey = numberFormatTypes.getStandardFormat(NumberFormat.DATE, new Locale());
	}

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
				setDouble(value, x++);
				break;
			case DAILY_CALORIC_INTAKE:
			case METABOLIC_AGE:
				setInt(value, x++);
				break;
			case BODY_WATER_PERCENTAGE:
				setPercentage(value, x++);
				break;
			case VISCERAL_FAT:
				setInt(value, x++);
				break;
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
				setDouble(value, x++);
				break;
			case PHYSIC_RATING:
				setInt(value, x++);
				break;
			default:
				throw new ColumnNotFoundException(col.toString());
			}
		}
	}

	private void setDate(String date, int x) {
		setFormula(date, x, 0, dateKey);
	}

	private void setFormula(String formula, int x, int y, int format) {
		XCell xCell = getCell(x, y);
		xCell.setFormula(formula);
		setFormat(x, y, format);
	}

	private void setDouble(String value, int x) {
		setValue(Double.parseDouble(value), x, 0, doubleKey);
	}

	private void setPercentage(String value, int x) {
		setValue(Double.parseDouble(value), x, 0, percentageKey);
	}

	private void setInt(String value, int x) {
		setValue(Integer.parseInt(value), x, 0, intKey);

	}

	private void setValue(double value, int x, int y, int format) {
		XCell xCell = getCell(x, y);
		xCell.setValue(value);
		setFormat(x, y, format);
	}

	private void setFormat(int x, int y, int format) {
		XCell cell = getCell(x, y);
		setNumberFormat(cell, format);
	}

	private XCell getCell(int x, int y) {
		XCell cell = null;
		try {
			cell = sheet.getCellByPosition(x, y);
		} catch (IndexOutOfBoundsException e) {
			throw new SpreadSheetException();
		}
		return cell;
	}

	private void setNumberFormat(XCell cell, int format) {

		// Query the property set of the cell range
		XPropertySet xCellProp = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, cell);

		try {
			xCellProp.setPropertyValue("NumberFormat", format);
		} catch (Exception e) {
			throw new SpreadSheetException();
		}
	}
}