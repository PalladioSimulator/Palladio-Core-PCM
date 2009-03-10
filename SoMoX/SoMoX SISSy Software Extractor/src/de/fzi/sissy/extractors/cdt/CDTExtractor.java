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
package de.fzi.sissy.extractors.cdt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

import org.eclipse.cdt.core.dom.ast.IASTProblem;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.parser.*;
import org.eclipse.cdt.core.parser.ast.*;
import org.eclipse.cdt.internal.core.dom.parser.ProblemBinding;
import org.eclipse.cdt.internal.core.dom.parser.cpp.ANSICPPParserExtensionConfiguration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.GNUCPPSourceParser;
import org.eclipse.cdt.internal.core.parser.IParserData;
import org.eclipse.cdt.internal.core.parser.scanner2.DOMScanner;
import org.eclipse.cdt.internal.core.parser.scanner2.FileCodeReaderFactory;
import org.eclipse.cdt.internal.core.parser.scanner2.GPPScannerExtensionConfiguration;
import org.eclipse.cdt.internal.core.parser.scanner2.Scanner2;

import de.fzi.sissy.extractors.GenericExtractor;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.Root;
import de.fzi.sissy.metamod.Subsystem;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.sql.ParsingErrorHelper;
import de.fzi.sissy.util.Debug;

/**
 * @author woelker
 * @author Mircea Trifu
 *
 */
public class CDTExtractor extends GenericExtractor {

	MetamodConverter converter;

	/**
	 * Constructor for the extractor.
	 */
	public CDTExtractor(String args[]) {
		super(args, new CPPFileFilterWithHeaders());
		cloneAnalyzerCommentFile = "res\\clone\\java_cpp_comments.dat";
		commentAnalyzerCommentFile = "res\\comments\\java_cpp.dat";
	}

	// ParserMode mode = ParserMode.EXTRACT_PARSE;
	ParserMode mode = ParserMode.COMPLETE_PARSE;
	ParserLanguage lang = ParserLanguage.CPP;
	ExtractorLogService log = new ExtractorLogService();
	Map definitions = new Hashtable();
	Map overwrittendefs = new Hashtable();
	ExtendedScannerInfo info = null;
	CdtToMetamodMap cdtToMetamodMapper = null;
	static boolean onlycpp;
    boolean defaultSubsys = true;    
	static boolean debugMetamod = false;
	int numFiles = 0;
	int filesProcessed = 0;
	String[] includePaths = new String[0];	
	String incFileName = "include.txt";
	String defFileName = "definitions.prop";

	protected void buildMetaModel() {
		converter = new MetamodConverter(modelElementRepository);
		setupMetamod();

		Debug.setDebugLevel(6 /* 60 */);
		File propFile = new File(defFileName);
		if (propFile.exists()) {
			Properties props = new Properties();
			try {
				props.load(new FileInputStream(defFileName));
				System.out.println("Macro definitions successfully loaded.");

				Enumeration names = props.propertyNames();
				while (names.hasMoreElements()) {
					String key = (String) names.nextElement();
					String value = props.getProperty(key);
					System.out.println(key + " = " + value);

					definitions.put(key, value);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		File inclDirFile = new File(incFileName);
		boolean useAdditionalIncludePaths = false;
		String[] additionalIncludePaths = null;

		if (inclDirFile.exists()) {
			useAdditionalIncludePaths = true;
			try {
				Vector paths = new Vector();
				BufferedReader reader = new BufferedReader(new FileReader(
						inclDirFile));
				String line = "";
				while ((line = reader.readLine()) != null) {
					paths.add(line);
				}
				additionalIncludePaths = new String[paths.size()
						+ includePaths.length];
				int i = 0;
				for (; i < includePaths.length; i++) {
					additionalIncludePaths[i] = includePaths[i];
				}

				Iterator pathIter = paths.iterator();
				while (pathIter.hasNext()) {
					String path = (String) pathIter.next();
					additionalIncludePaths[i] = path;
					i++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		if (useAdditionalIncludePaths) {
			System.out.println("Using include paths:");
			for (int i = 0; i < additionalIncludePaths.length; i++)
				System.out.println(additionalIncludePaths[i]);

			info = new ExtendedScannerInfo(definitions, additionalIncludePaths);
		} else {
			if (includePaths.length > 0) {
				System.out.println("Using include paths:");
				for (int i = 0; i < includePaths.length; i++)
					System.out.println(includePaths[i]);
			}
			info = new ExtendedScannerInfo(definitions, includePaths);
		}

		long startTime = System.currentTimeMillis();

		List srcFileList = modelElementRepository.getFileList();
		if (onlycpp) {
			FileFilter customFilter = new CPPFileFilter();
			List tmp = new ArrayList();
			for (int i = 0; i<srcFileList.size(); i++) {
				File f = new File((String)srcFileList.get(i));
				if (customFilter.accept(f)) {
					tmp.add(srcFileList.get(i));
				}
			}
			srcFileList = tmp;
		}

		if (getSsHelper() != null)
			defaultSubsys = false;
		
		numFiles = srcFileList.size();
		HashMap<String, Subsystem> map = new HashMap<String, Subsystem>();
		for (int i = 0; i<srcFileList.size(); i++) {
			File f = new File((String)srcFileList.get(i));
			de.fzi.sissy.metamod.File file = extractFileToMetamod(f);
	        if (defaultSubsys) {
				Subsystem subsys = map.get(f.getParent());
				if (subsys == null) {
					subsys = new Subsystem(f.getParentFile().getName());
					map.put(f.getParent(), subsys);
					modelElementRepository.getRoot().addStructuralAbstraction(subsys);
				}
				subsys.addModelElement(file);
	        }	
	        else {
	        	assignFileToSubsystem(file);
	        }
		}
			
		if (defaultSubsys) {
			for (String key : map.keySet()) {
				File f = new File(key);
				while (f.getParentFile() != null) {
					Subsystem parent = map.get(f.getParent());
					if (parent != null) {
						parent.addModelElement(map.get(key));
						break;
					}
					f = f.getParentFile();
				}
			}
		}
		
		// Postprocessing (e.g. computing overridden members)
		postProcess();

		long endTime = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (endTime - startTime) / 1000
				+ " s");
	}

	private void postProcess() {
		System.out.println("Postprocessing...");

		System.out.println("Computing overridden members...");

		Root root = modelElementRepository.getRoot();
		Iterator classes = root.getClasses().iterator();
		while (classes.hasNext()) {
			Class clss = (Class) classes.next();
			Iterator methods = clss.getMethods().iterator();
			while (methods.hasNext()) {
				Method m = (Method) methods.next();
				computeOverriddenMember(m);
			}
		}
	}

	private void computeOverriddenMember(Method method) {
		Class classtype = method.getSurroundingClass();

		// compute reference to overridden member (if any)
		if (method.signature() == null) {
			System.out.println(method);
		}
		Debug.mminfo("Compute overridden member of class "
				+ classtype.getSimpleName() + " (" + method.signature() + ":"
				+ method.signature().quickcompareCode() + ")...");
		Iterator supertypes = classtype.getAllSuperTypes().iterator();

		while (supertypes.hasNext()) {
			Class supertype = (Class) supertypes.next();
			Debug.mminfo("Searching " + supertype.getSimpleName() + " ("
					+ supertype.getMethods().size() + " methods)...");

			Iterator methods = supertype.getMethods().iterator();
			while (methods.hasNext()) {
				Method supermethod = (Method) methods.next();
				Debug.mminfo(supermethod.signature() + ":"
						+ supermethod.signature().quickcompareCode());

				if (method.signature().equals(supermethod.signature())
						&& supermethod.isVirtual()) {
					// found overridden member
					Debug.mminfo("Found overridden member in class "
							+ supertype.getSimpleName() + " (" + supertype
							+ ")");

					method.setOverridenMember(supermethod);
					method.setOverride();
				}
			}
		}
	}

	HashSet allTypes = new HashSet();

	private de.fzi.sissy.metamod.File getOrCreateFile(File file) {
		// only create new file if not already present
		de.fzi.sissy.metamod.File existentFile = null;

		Iterator files = modelElementRepository.getRoot().getFiles().iterator();
		while (files.hasNext()) {
			de.fzi.sissy.metamod.File f = (de.fzi.sissy.metamod.File) files
					.next();
			if (f.getPathName().toLowerCase().equals(
					file.getAbsolutePath().toLowerCase()))
				existentFile = f;
		}

		if (existentFile == null) {
			existentFile = new de.fzi.sissy.metamod.File(file.getAbsolutePath());
			modelElementRepository.getRoot().addFile(existentFile);
		}

		return existentFile;
	}

    private void assignFileToSubsystem(de.fzi.sissy.metamod.File file) {
        getSsHelper().addFile(file);
    }
    
	private de.fzi.sissy.metamod.File extractFileToMetamod(File f) {
		filesProcessed++;
		System.out.print("Parsing " + f.getAbsolutePath()
				+ " ... [" + filesProcessed + "/" + numFiles + "] ");
		System.err.println("File: " + f.getAbsolutePath());
		ParsingErrorHelper.getInstance().setCurrentFile(f.getAbsolutePath());
		Callback2 callback = new Callback2();
		callback.setExtendedReferences(true);
		StatementTracker.getInstance().clearStack();

		IExtractorASTFactory astFactory = extract(f, callback);

		de.fzi.sissy.metamod.File file = null;
		file = getOrCreateFile(f);
		return file;
	}

	/**
	 * @param file
	 * @param callback
	 */
	private void buildIncludes(de.fzi.sissy.metamod.File file,
			Callback2 callback) {
		Iterator iter = callback.getInclusions();
		while (iter.hasNext()) {
			IASTInclusion incl = (IASTInclusion) iter.next();

			// only create new file if not already present
			boolean present = false;
			Iterator files = modelElementRepository.getRoot().getFiles()
					.iterator();
			while (files.hasNext()) {
				de.fzi.sissy.metamod.File f = (de.fzi.sissy.metamod.File) files
						.next();
				// TODO: compare case insensitive! (z:\ vs. Z:\)
				if (f.getPathName().equals(incl.getFullFileName()))
					present = true;
			}
			if (!present) {
				de.fzi.sissy.metamod.File f = new de.fzi.sissy.metamod.File(
						incl.getFullFileName());
				modelElementRepository.getRoot().addFile(f);
				file.addIncludedFile(f);
			}
		}
	}

	private void setupMetamod() {
		cdtToMetamodMapper = new CdtToMetamodMap();
	}

	private CodeReader codeReader = null;

	private IExtractorASTFactory extract(File file, ISourceElementRequestor callback) {
		try {
			codeReader = new CodeReader(file.getAbsolutePath());

			IScanner scanner = new DOMScanner(codeReader, info, mode, lang,
					log, new GPPScannerExtensionConfiguration(),
					FileCodeReaderFactory.getInstance());

			// ICodeReaderFactory
			// set up overwritten macro definitions
			if (scanner instanceof Scanner2) {
				Iterator keys = overwrittendefs.keySet().iterator();
				while (keys.hasNext()) {
					String key = (String) keys.next();
					String value = (String) overwrittendefs.get(key);
				}
			}

			GNUCPPSourceParser parser = new GNUCPPSourceParser(scanner, mode,
					log, new ANSICPPParserExtensionConfiguration());
			IASTTranslationUnit trUnit = parser.parse();
			System.out.println("Done");

			converter.convert(trUnit);
			String[] paths = scanner.getIncludePaths();
			paths = info.getIncludeFiles();

			int nProblems = converter.getProblems().size();
			if (nProblems == 0) {
				System.out.println("Parsing successful");
			} else {
				System.out.println("Parsing problematic: " + nProblems
						+ " problems found");
				for(Iterator it = converter.getProblems().iterator(); it.hasNext();) { 
					Object o = it.next(); 
					if(o instanceof IASTProblem)
						Debug.error(((IASTProblem)o).getMessage()); 
					else if(o instanceof ProblemBinding)
                        Debug.error(((ProblemBinding)o).getMessage());
					else
                        Debug.error("Unknown problem found");
				}
			}
			
			if (parser instanceof IExtractorParser)
				return (IExtractorASTFactory) ((IParserData) parser)
						.getAstFactory();

		} catch (ParserFactoryError pfe) {
			pfe.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (Exception e) {
			Debug.warning("Exception caught: " + e.getClass().getCanonicalName());
			e.printStackTrace();
		}

		return null;
	}

	protected void extractLanguageSpecificParameters() {	
		onlycpp = argParser.hasParameter("cpponly");
		if (argParser.hasParameter("include"))
			incFileName = argParser.getParameter("include");
		if (argParser.hasParameter("def"))
			defFileName = argParser.getParameter("def");
	}

	protected void addLanguageSpecificOptions() {
		argParser.usage = "SISSy -cpp <path_list>\n\t" 
			+ "<path-list>\t\ta list of pathnames pointing to folders containing the sources (separated by "
			+ File.pathSeparator
			+ "). For example \"C:/tmp/"
			+ File.pathSeparator
			+ "src"
			+ File.pathSeparator
			+ "work/files\".\n";
		argParser.addOption("cpponly", null, "parse only CPP files.");
		argParser.addOption("include", "file-name" , "a file containing additional include folders (one per line)");
		argParser.addOption("def", "file-name", "a file containing the macro configuration used in the analysis. Each macro definition is a \"name = value\" pair.");
	}
}