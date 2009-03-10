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
package de.fzi.sissy.extractors.java.recoder;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import recoder.ParserException;
import recoder.ServiceConfiguration;
import recoder.convenience.Format;
import recoder.io.DefaultProjectFileIO;
import recoder.io.DefaultSourceFileRepository;
import recoder.io.SourceFileRepository;
import recoder.java.CompilationUnit;
import recoder.kit.Problem;
import recoder.kit.ProblemReport;
import recoder.kit.Transformation;
import recoder.list.generic.ASTArrayList;
import recoder.list.generic.ASTList;
import recoder.util.FileCollector;
import de.fzi.sissy.util.Debug;
 
/**
 * @author szulman
 *
 */
public class RecoderProgram {
	
	private static void warn(String message) {
		Debug.warning(message);
	}

	private static void fail(String message) {
		Debug.error(message);
		System.exit(1);
	}

	private static void ensureSystemClassesAreInPath(ServiceConfiguration sc) {
		if (!sc.getProjectSettings().ensureSystemClassesAreInPath()) {
			fail("Problem with system setup: Cannot locate system classes");
		}
	}

	private static boolean isLogicalClassName(String name) {
		if (!Character.isJavaIdentifierStart(name.charAt(0))) {
			return false;
		}
		for (int i = 1, s = name.length(); i < s; i++) {
			char x = name.charAt(i);
			if (x == '.') {
				if (name.charAt(i - 1) == '.') {
					return false;
				}
			} else if (!Character.isJavaIdentifierPart(x)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Collect all Java files in directory dir.
	 * @param dir Directory to search for Java files.
	 * @return String array containing all Java files found.
	 */
	private static String[] collectJavaFiles(String dir) {
		FileCollector col = new FileCollector(dir);
		List<String> list = new ArrayList<String>();
		while (col.next(DefaultSourceFileRepository.JAVA_FILENAME_FILTER)) {
			String path;
			try {
				path = col.getFile().getCanonicalPath();
			} catch (IOException ioe) {
				path = col.getFile().getAbsolutePath();
			}
			list.add(path);
		}
		return list.toArray(new String[0]);
	}
    
	/**
	   Checks the arguments for a single project file, attempts to open
	   the file and reads in all classes defined within.
	   @param sc the service configuration to use, usually CrossReference.
	   @param main the caller object, used for usage instructions.
	   @param args the command line arguments.
	 */
	public static void setup(ServiceConfiguration sc, Class main, List fileList) {
		if (sc == null) 
			throw new IllegalArgumentException("Service configuration required");
		if (main == null) 
			throw new IllegalArgumentException("Main class required");
		if (fileList == null) 
			throw new IllegalArgumentException("File list required");

		SourceFileRepository sfr = sc.getSourceFileRepository();
		
		try {
			ensureSystemClassesAreInPath(sc);
			sc.getProjectSettings().ensureExtensionClassesAreInPath();
			
			String[] files = new String[fileList.size()];
			for (int i=0; i<fileList.size(); i++) {
				files[i] = (String)fileList.get(i);
			}
			List<CompilationUnit> culist = sfr.getCompilationUnitsFromFiles(files);

			if (culist.size() < files.length) {
				warn("Could not load some files from analysis path.");
			}
		} catch (ParserException pe) {
			fail("A Parse Error has occured: " + pe);
		}
	}

	/**
	   Calls the proper setup routine, executes the given transformation,
	   and writes back all changed compilation units automatically.
	   @param transform the transformation to execute.
	   @param args the command line arguments, should contain the project file
	   name as only argument.
	 */
	public static void execute(Transformation transform, List fileList) {
		ServiceConfiguration sc = transform.getServiceConfiguration();
		setup(sc, transform.getClass(), fileList);
		ProblemReport report = transform.execute();
		if (report instanceof Problem) {
			warn(report.toString());
		} else {
			Debug.info("Transformation succeeded - writing results");
			SourceFileRepository sfr = sc.getSourceFileRepository();
			List<CompilationUnit> units = sfr.getCompilationUnits();
			for (int i = 0; i < units.size(); i += 1) {
				CompilationUnit cu = units.get(i);
				if (!sfr.isUpToDate(cu)) {
					Debug.info(Format.toString("%u [%f]", cu));
					try {
						sc.getSourceFileRepository().print(cu);
					} catch (IOException ioe) {
						warn("An IO Exception has occured: " + ioe);
					}
				}
			}
		}
	}

}
