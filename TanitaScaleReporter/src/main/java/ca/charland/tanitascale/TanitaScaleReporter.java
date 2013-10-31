package ca.charland.tanitascale;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class TanitaScaleReporter {

	public static void main(String args[]) {
		parse(args);
	}

	private static void parse(String[] args) {
		if (args[0].startsWith("Date")) {
			parseSingleDay(args);
		} else if (new File(args[0]).isDirectory()) {
			parseDirectory(args[0]);
		} else {
			parseFiles(args);
		}
	}

	private static void parseSingleDay(String[] args) {
		Parser parser = new Parser();
		Reporter content = new Reporter();

		DayData values = parser.parseSingleDay(args);
		content.printValues(values, 0);
	}

	private static void parseFiles(String[] args) {
		Parser parser = new Parser();
		Reporter content = new Reporter();
		printDates("", parser, content, args);
	}

	private static void parseDirectory(String dir) {
		Parser parser = new Parser();
		Reporter content = new Reporter();
		String args[] = new File(dir).list();
		printDates(dir, parser, content, args);
	}

	private static void printDates(String dir, Parser parser, Reporter content, String[] args) {

		Set<DayData> days = new TreeSet<DayData>();
		for (String arg : args) {
			DayData values = parser.parseFileContents(LoadFile.load(dir + arg));
			days.add(values);
			new File(dir + arg).delete();
		}

		int y = 0;
		for (DayData d : days) {
			content.printValues(d, y++);
		}
	}
}
