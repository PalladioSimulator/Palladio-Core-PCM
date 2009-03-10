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
package de.fzi.sissy.extractors;

import de.fzi.sissy.extractors.clone.CloneStructureBuilder;
import de.fzi.sissy.extractors.clone.FilenameToStatementMapper;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.Root;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.metamod.StatementTreeWalker;
import de.fzi.sissy.sql.JDBCWrapper;
import de.fzi.sissy.sql.ModelExporter;
import de.fzi.sissy.sql.ParsingErrorHelper;
import de.fzi.sissy.util.ArgParser;
import de.fzi.sissy.util.Debug;
import de.fzi.sissy.util.DuplicateStream;

import jargs.gnu.CmdLineParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileFilter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;


/**
 * Generic SISSy Fact Extractor
 * Handles Clone Analysis & SQL export
 * Sub classes should implment Language specific fact extraction 
 *
 * @author woelker
 */
public abstract class GenericExtractor {
    protected String sourcePath = null;
    protected String libPath = null;
    protected ModelElementRepository modelElementRepository = ModelElementRepository.getWorkingRepository();
    protected String[] args;
    protected String cloneAnalyzerCommentFile = null;
    protected String commentAnalyzerCommentFile = null;
    protected FileFilter fileFilter = null;
    protected ArgParser argParser = new ArgParser("SISSy", "");
    private SubsystemHelper ssHelper = null;
    
    protected SubsystemHelper getSsHelper() {
        return ssHelper;
    }

    protected Properties clone_analyzer_parameters = null;
    
    /**
     * Creates a new GenericExtractor object.
     *
     * @param args Program parameters
     */
    public GenericExtractor(String[] args, FileFilter ff) {
        this.args = args;
        this.fileFilter = ff;
	}

    protected void analyseComments() {
    	String fileName = "res/comments/comment_analyzer.cfg";
    	fileName = fileName.replace("/", java.io.File.separator);
    	String[] args = {sourcePath, "-all", fileName, "-c", commentAnalyzerCommentFile};
    	de.fzi.sissy.commentanalyzer.Main.main(args);
    }

    protected void analyseClones() {
        if (this.clone_analyzer_parameters == null) {
            return;
        }
        
        FilenameToStatementMapper mapper = FilenameToStatementMapper.getSingleton();
        ModelElementList list = modelElementRepository.getRoot().getFunctions();
        Iterator fit = list.iterator();

        while (fit.hasNext()) {
            Function func = (Function) fit.next();
            StatementTreeWalker walker = new StatementTreeWalker(func.getBody());

            if (func.getBody() != null) {
                do {
                    Statement stmt = walker.getStatement();

                    if (stmt.getPosition() != null) { //TODO: Position should

                        // not be null
                        mapper.addStatement(stmt.getPosition().getSourceFile()
                                                .getPathName(), stmt);
                    } else {
                        ModelElement function = stmt.getSurroundingFunction();

                        while (!(function instanceof Function)) {
                            function = function.getParent();
                        }

                        Debug.warning(
                            "CA: Metamod Statement Position is null in function " +
                            ((Function) function).getSimpleName());
                    }
                } while (walker.next());
            }
        }

        CloneStructureBuilder.getSingleton().executeCloneAnalyseAndCreateCloneStructure(modelElementRepository, clone_analyzer_parameters);
    }

    protected void addGenericOptions() {
        argParser.addOption("libsrc", "path-list",
        	"a list of pathnames pointing to folders containing library source code included in the project.");
        argParser.addOption("clone", null,
            "clone analysis will be executed.");
        argParser.addOption("min", "min-len",
            "the minimum clone length.");
        argParser.addOption("ff", "file-filter",
            "specify your own file-filter for clone-analysis.");
        argParser.addOption("cf", "comment-file",
            "syntactic form of comments is specified in this file.");
        argParser.addOption("iw", null,
            "ignore whitespace during clone-analysis.");
        argParser.addOption("ic", null,
            "ignore comments during clone-analysis.");
        argParser.addOption("subsys", "filename", "path to the xml subsystem specification file.");
    }

    protected void extractSubsystemStructure() {
        String name = argParser.getParameter("subsys");
        if (name != null) {
        	ssHelper = new SubsystemHelper();
            ssHelper.loadConfigFromFile(name);
            ssHelper.addSubsystemsToRoot(modelElementRepository.getRoot());
        }
    }
    
    protected void extractGenericParameters() {
        sourcePath = (String) argParser.TargetList.get(0);
        libPath = argParser.getParameter("libsrc");
        
        if (argParser.hasParameter("clone")) {
            String min_clone_length = argParser.getParameter("min");
            String file_filter = argParser.getParameter("ff");
            String comment_file = argParser.getParameter("cf");
            boolean ignore_whitespace = argParser.hasParameter("iw");
            boolean ignore_comments = argParser.hasParameter("ic");
        
            Properties default_parameters = CloneStructureBuilder.getDefaultParameters();
            if (cloneAnalyzerCommentFile != null)
            	default_parameters.setProperty(CloneStructureBuilder.COMMENT_FILE_NAME, cloneAnalyzerCommentFile);
            Properties ca_parameters = new Properties(default_parameters);
            
            if (min_clone_length != null)
            	ca_parameters.setProperty(CloneStructureBuilder.MIN_CLONE_LENGTH, min_clone_length);
            if (file_filter != null)
            	ca_parameters.setProperty(CloneStructureBuilder.FILE_FILTER, file_filter);
            if (comment_file != null)
            	ca_parameters.setProperty(CloneStructureBuilder.COMMENT_FILE_NAME, comment_file);
            if (ignore_whitespace)
            	ca_parameters.setProperty(CloneStructureBuilder.IGNORE_WHITESPACE, "true");
            if (ignore_comments)
            	ca_parameters.setProperty(CloneStructureBuilder.IGNORE_COMMENTS, "true");
            
            this.clone_analyzer_parameters = ca_parameters;
        }
    }

    protected void printUsage() {
        argParser.printHelp();
    }

    /**
     * extracts language specific Options from the ArgParser 
     * 
     */
    protected abstract void extractLanguageSpecificParameters();

    /**
     * adds language specific Options from the ArgParser 
     * 
     */
    protected abstract void addLanguageSpecificOptions();

    /**
     * builds the SISSy meta model
     * 
     */
    protected abstract void buildMetaModel();

    /**
     * Strategy method for fact extraction 
     */
    public void extract() {
        // -- Parameter handling
    	addGenericOptions();
        addLanguageSpecificOptions();
        argParser.parse(args);

        if (argParser.TargetList.size() < 1) {
            printUsage();
            System.exit(-2);
        }
        
        extractGenericParameters();
        extractLanguageSpecificParameters();

        if (sourcePath == null) {
        	Debug.error("No analysis path list specified. Aborting.");
        	System.exit(-2);
        }
        
        DuplicateStream errLog = null;
        
        if (de.fzi.sissy.Main.hasArg("logerrors")) {
        	ArrayList outStreams = new ArrayList();
        	outStreams.add(Debug.getErrStream());
        	outStreams.add(ParsingErrorHelper.getInstance().startCollectErrors());
        	errLog = new DuplicateStream(outStreams);
            Debug.redirectOutputToWriterStream(Debug.getOutStream(), errLog);
        }
        
        modelElementRepository.setFileList(parsePathList(sourcePath));
        if (libPath != null)
        	modelElementRepository.setLibFileList(parsePathList(libPath));

        extractSubsystemStructure();
        
        buildMetaModel();
        analyseComments();
        analyseClones();

        if (de.fzi.sissy.Main.hasArg("logerrors")) {
            Debug.endRedirect();
            try {
	            if (errLog != null)
	            	errLog.close();
            } catch (IOException ex) {
            }
            ParsingErrorHelper.getInstance().endCollectErrors();
        }
        
        /*
    	Iterator it =  modelElementRepository.getRoot().getPackages().iterator();
    	while(it.hasNext())
    	{
    		Package pack = (Package)it.next();
    		System.out.println(pack.getQualifiedName()+": "+pack.getLinesOfCode());
    	}
    	System.out.println("--Total: "+modelElementRepository.getRoot().getLinesOfCode());
    	System.out.println("--Total: "+modelElementRepository.getRoot().getLinesOfComments());
    */
    }
    
    protected ArrayList parsePathList(String pathList) {
    	ArrayList list = new ArrayList();    	
        StringTokenizer pathTokenizer = new StringTokenizer(pathList, File.pathSeparator, false);
        while (pathTokenizer.hasMoreTokens()) {
            String token = pathTokenizer.nextToken();
            File file = new File(token);
            ArrayList tmpList = collectFiles(file);
            if (tmpList.size() > 0) {
            	list.addAll(tmpList);
            }
            else if (file.exists() && file.isFile()) {
            	ArrayList incList = new ArrayList();
            	ArrayList excList = new ArrayList();
                try {                
                	BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while (((line = br.readLine()) != null)) {
                    	if (line.startsWith("i ") || line.startsWith("I ")) {
                    		incList.add(line.substring(2));
                    	}
                    	else if (line.startsWith("e ") || line.startsWith("E ")) {
                    		excList.add(line.substring(2));
                    	}
                    }    
                    br.close();
                } catch (IOException e) {
                    Debug.error(e.getMessage());
                }
                for (int i=0; i<incList.size(); i++) {
                	File f = new File((String)incList.get(i));
                	list.addAll(collectFiles(f));
                }
                for (int i=0; i<excList.size(); i++) {
                	File f = new File((String)excList.get(i));
                	list.removeAll(collectFiles(f));
                }
            }
        }
        return list;
    }
    
    private ArrayList collectFiles(File file) {
    	ArrayList list = new ArrayList();
        if (file.isDirectory()) {            	
        	File[] flist = file.listFiles();
        	for (int i=0; i<flist.length; i++) {
       			list.addAll(collectFiles(flist[i]));        			
        	}
        }
        else if (fileFilter.accept(file)) {
        	try {
        		list.add(file.getCanonicalPath());
        	} catch (IOException e) {        		
                Debug.error(e.getMessage());
        	}
        }
    	return list;
    }
}