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

import ooo.connector.BootstrapSocketConnector;

import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.PropertyVetoException;
import com.sun.star.beans.UnknownPropertyException;
import com.sun.star.beans.XPropertySet;
import com.sun.star.container.XIndexAccess;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.IllegalArgumentException;
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
		try {
			NumberFormats aSample = new NumberFormats(args);
			aSample.doFunction();
		} catch (Exception ex) {
			System.err.println("Sample caught exception! " + ex);
			ex.printStackTrace();
			System.exit(1);
		}

		System.out.println("Sample done.");
		System.exit(0);
	}

	// ____________________

	public void doFunction() throws RuntimeException, Exception {
		// Assume:
		// com.sun.star.sheet.XSpreadsheetDocument maSpreadsheetDoc;
		// com.sun.star.sheet.XSpreadsheet maSheet;

		int x = 0;
		setFormula("01/28/2013", x++, 0, NumberFormat.DATE);
		setFormula("=MONTH(A1)", x++, 0, NumberFormat.NUMBER);
		setValue(150, x++, 0, NumberFormat.NUMBER);
		setValue(0.15, x++, 0, NumberFormat.PERCENT);
	}

	private void setValue(double value, int x, int y, short format) throws IndexOutOfBoundsException, UnknownPropertyException,
			PropertyVetoException, IllegalArgumentException, WrappedTargetException {
		XCell xCell = sheet.getCellByPosition(x, y);
		xCell.setValue(value);
		setFormat(x, y, format);
	}

	private void setFormula(String formula, int x, int y, short format) throws IndexOutOfBoundsException, UnknownPropertyException,
			PropertyVetoException, IllegalArgumentException, WrappedTargetException {
		XCell xCell = sheet.getCellByPosition(x, y);
		xCell.setFormula(formula);
		setFormat(x, y, format);
	}

	private void setFormat(int x, int y, short format) throws IndexOutOfBoundsException, UnknownPropertyException, PropertyVetoException,
			IllegalArgumentException, WrappedTargetException {
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
		XCell cell = sheet.getCellByPosition(x, y);

		// Query the property set of the cell range
		XPropertySet xCellProp = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, cell);

		// Set number format
		xCellProp.setPropertyValue("NumberFormat", key);
	}

	private static final String oooExeFolder = "C:/Program Files (x86)/LibreOffice 3.6/program";

	// ____________________

	public NumberFormats(String[] args) throws java.lang.Exception {
		// get the remote office context. If necessary a new office
		// process is started
		officeContext = BootstrapSocketConnector.bootstrap(oooExeFolder);

		System.out.println("Connected to a running office ...");
		maServiceManager = officeContext.getServiceManager();

		// create a new spreadsheet document
		XComponentLoader aLoader = (XComponentLoader) UnoRuntime.queryInterface(XComponentLoader.class,
				maServiceManager.createInstanceWithContext("com.sun.star.frame.Desktop", officeContext));

		document = (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class,
				aLoader.loadComponentFromURL("private:factory/scalc", "_blank", 0, new PropertyValue[0]));

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