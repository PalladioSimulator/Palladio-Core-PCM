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
package de.fzi.sissy.extractors.delphi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import antlr.ASTIterator;
import antlr.collections.AST;

import recoder.ParserException;

import de.fzi.delphi.OPMain;
import de.fzi.delphi.OPProjectManager;
import de.fzi.delphi.ProjectListEntry;
import de.fzi.delphi.CommonASTWithLineNumber;
import de.fzi.sissy.extractors.GenericExtractor;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.extractors.java.builders.RecoderToOMMapper;
import de.fzi.sissy.extractors.java.builders.StatementViewer;
import de.fzi.sissy.extractors.meta.GeneralMapper;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.Root;
import de.fzi.sissy.sql.JDBCWrapper;
import de.fzi.sissy.sql.ModelExporter;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 */
public class OPFactExtractor extends GenericExtractor /*implements Runnable*/ {
	private String list_file_name = "dpinput.lst";
	private String includePath = null;
	private StatementViewer sv;
	
	private DelphiMetamodBuilder metamod_builder;
	
	/**
	 * Constructor for the extractor. 
	 */
	public OPFactExtractor(String args[])
	{
		super(args, new DelphiFileFilter());
		cloneAnalyzerCommentFile = "res\\clone\\delphi_comments.dat";
		commentAnalyzerCommentFile = "res\\comments\\delphi.dat";
	}
	
		
	/**
	 * Analyses source and builds up a model. A model is an instance of the METAMOD metamodel.
	 * @param model
	 */
	private synchronized void analyse()
		throws
			ParserException,
			IOException,
			MalformedURLException,
			ParserException {

		long currentTimeMillisBeforeAnalyzing = System.currentTimeMillis();

		Debug.info("Time before analyzing project " + 
				 	new Date(currentTimeMillisBeforeAnalyzing));

		extractOP();
			
		
		long currentTimeMillisAfterAnalyzing = System.currentTimeMillis();

		Debug.info("Time elapsed so far " +	
					Float.toString( (currentTimeMillisAfterAnalyzing - currentTimeMillisBeforeAnalyzing)/1000.0f ) + 
					" s");

		
		
		
		// when testing with StatementViewer enable waiting:
		/*
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		
		
	} //analyse
	
	public void extractOP() {
    	File lst_file = new File(list_file_name);

        try {
            lst_file.createNewFile();
            FileWriter fw = new FileWriter(lst_file);
            Iterator itr = modelElementRepository.getWorkingRepository().getFileList().iterator();            
            while(itr.hasNext()) {
                String path_name = (String)itr.next() + "\n";
                fw.write(path_name);
            }           
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//Vector configParameter = new Vector();
/*
		String[] configParameter = new String[]{
			"-v", "2", "--scope-tree", 
			"--format", "sissy", "-l", listFilePath
		};
*/
		
		String[] configParameter;
		
		if (includePath != null)
			configParameter = new String[]{
					"-v", "2",
//					"-p",
//					"--scope-tree", 
//                    "--transformed-tree",
					"--format", "sissy", 
					"-l", list_file_name,
					"-I", includePath
				};
		else
			configParameter = new String[]{
				"-v", "2", 
//				"-p",
//				"--scope-tree", 
//                "--transformed-tree",
//                "--parse-tree",
//                "--symbol-tree",
				"--format", "sissy", 
				"-l", list_file_name,
			};

		//   -v 1 --scope-tree -l tests\test5.lst
		
		SissyOutput sissyOutput = new SissyOutput();

		OPProjectManager.setOutput(sissyOutput);
		
		try {
			OPMain.main(configParameter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    GeneralMapper mapper = new GeneralMapper();
	    
	    DelphiCollector collector = new DelphiCollector(sissyOutput, mapper);

		metamod_builder = new DelphiMetamodBuilder(collector, mapper, modelElementRepository);
		
		metamod_builder.buildAll();
		
		//metamod_builder.createStatementViewer();
		
		//sv = metamod_builder.getStatementViewer();
		
	}
	
    /**
     * extracts language specific Options from the ArgParser 
     * 
     */
    protected void extractLanguageSpecificParameters()
    {        
		includePath = argParser.getParameter("I");    	
    }

    /**
     * adds language specific Options from the ArgParser 
     * 
     */
    protected void addLanguageSpecificOptions()
    {
		argParser.usage = "SISSy -delphi <path-list>\n\t" +
		"<path-list>\t\ta list of pathnames pointing to folders containing the sources (separated by "
		+ File.pathSeparator
		+ "). For example \"C:/tmp/"
		+ File.pathSeparator
		+ "src"
		+ File.pathSeparator
		+ "work/files\".\n";
		argParser.addOption("I","include-list", "path list containing all include directories.");    	
    }

    /**
     * builds the SISSy meta model
     * 
     */
    protected void buildMetaModel()
    {
		try {
			analyse();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
