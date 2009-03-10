/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik,
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy;

import de.fzi.sissy.extractors.cdt.CDTExtractor;
import de.fzi.sissy.extractors.delphi.OPFactExtractor;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.sql.ModelExporter;
import de.fzi.sissy.sql.QueryRunner;
import de.fzi.sissy.util.ArgParser;
import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 *
 */
public class Main {
	private static String version = "0.46";

	private static ArgParser argParser;



	public static ModelElementRepository runSISSy(String args[]) {
		long currentMillis = System.currentTimeMillis();
		argParser = new ArgParser("SISSy","SISSy\n\t[-java <path-list> <params>]\n\t[-cpp <path-list> <params>]\n\t[-delphi <path-list> <params>]\n\t[-export [-cfg <cfg-file>] [{-o <output-file> | -db <dbname>}] [-logerrors]]\n\t[-query [-cfg <cfg-file>] [-db <dbname>] <params>]\n");
		argParser.addOption("java", "path-list", "analyze a JAVA project.");
		argParser.addOption("cpp", "path-list", "analyse a C/C++ project.");
		argParser.addOption("delphi", "path-list", "analyse a Delphi project.");
		argParser.addOption("export", null, "export system repository.");
		argParser.addOption("query", null, "run problem pattern queries.");
		argParser.addOption("logerrors", null, "save errors to the database for future reference.");
        argParser.addOption("cfg", "cfg-file",
    		"an alternate jdbc config file. If this param is not supplied the default config file is used.");
        argParser.addOption("o", "output-file",
    		"the result will be stored as SQL commands in the specified file.");
        argParser.addOption("db", "dbname",
    		"the result will be stored in the specified database. If none of the -o or -db params is given the output will be stored in the default database specified in the <cfg-file>.");
		argParser.parse(args);
		Debug.setDebugLevel(0);
		printHeader();

		ModelElementRepository rep = ModelElementRepository.newRepository();
		boolean paramFound = false;
		if(argParser.hasParameter("java")) {
			paramFound = true;
			new de.fzi.sissy.extractors.java.Extractor(args).extract();
		}
		if(argParser.hasParameter("cpp")) {
			paramFound = true;
			new CDTExtractor(args).extract();
		}
		if(argParser.hasParameter("delphi")) {
			paramFound = true;
			new OPFactExtractor(args).extract();
		}
		if(argParser.hasParameter("export")) {
			paramFound = true;
			new ModelExporter(rep.getRoot(), args);
		}
		if(argParser.hasParameter("query")) {
			paramFound = true;
			new QueryRunner(args);
		}
		if (!paramFound)
		{
			printUsage();
			System.exit(-1);
		}

		return rep;
	}

	public static void main(String args[]) {
		long currentMillis = System.currentTimeMillis();
		argParser = new ArgParser("SISSy","SISSy\n\t[-java <path-list> <params>]\n\t[-cpp <path-list> <params>]\n\t[-delphi <path-list> <params>]\n\t[-export [-cfg <cfg-file>] [{-o <output-file> | -db <dbname>}] [-logerrors]]\n\t[-query [-cfg <cfg-file>] [-db <dbname>] <params>]\n");
		argParser.addOption("java", "path-list", "analyze a JAVA project.");
		argParser.addOption("cpp", "path-list", "analyse a C/C++ project.");
		argParser.addOption("delphi", "path-list", "analyse a Delphi project.");
		argParser.addOption("export", null, "export system repository.");
		argParser.addOption("query", null, "run problem pattern queries.");
		argParser.addOption("logerrors", null, "save errors to the database for future reference.");
        argParser.addOption("cfg", "cfg-file",
    		"an alternate jdbc config file. If this param is not supplied the default config file is used.");
        argParser.addOption("o", "output-file",
    		"the result will be stored as SQL commands in the specified file.");
        argParser.addOption("db", "dbname",
    		"the result will be stored in the specified database. If none of the -o or -db params is given the output will be stored in the default database specified in the <cfg-file>.");
		argParser.parse(args);
		Debug.setDebugLevel(6);
		printHeader();

		ModelElementRepository rep = ModelElementRepository.newRepository();
		boolean paramFound = false;
		if(argParser.hasParameter("java")) {
			paramFound = true;
			new de.fzi.sissy.extractors.java.Extractor(args).extract();
		}
		if(argParser.hasParameter("cpp")) {
			paramFound = true;
			new CDTExtractor(args).extract();
		}
		if(argParser.hasParameter("delphi")) {
			paramFound = true;
			new OPFactExtractor(args).extract();
		}
		if(argParser.hasParameter("export")) {
			paramFound = true;
			new ModelExporter(rep.getRoot(), args);
		}
		if(argParser.hasParameter("query")) {
			paramFound = true;
			new QueryRunner(args);
		}
		if (!paramFound)
		{
			printUsage();
			System.exit(-1);
		}

		System.out.println("Time elapsed so far " +	Float.toString( (System.currentTimeMillis() - currentMillis)/1000.0f ) + " s");
	}

    public static boolean hasArg(String arg) {
	    return argParser.hasParameter(arg);
    }

	private static void printHeader() {
		System.out.println();
		System.out.println("SISSy version " + version);
		System.out.println("Created at FZI Forschungszentrum Informatik, Software Engineering Group,");
		System.out.println("10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany");
		System.out.println();
	}

	private static void printUsage() {
		argParser.printHelp();
	}

	private static void printNotImplemented() {
		Debug.info("Not implemented yet");
	}
}
