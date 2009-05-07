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
package de.fzi.sissy.extractors.clone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.generationjava.io.xml.XmlWriter;

import de.fzi.cloneanalyzer.CloneAnalyzerConsole;
import de.fzi.cloneanalyzer.core.CloneInstance;
import de.fzi.cloneanalyzer.core.CloneSetStructure;
import de.fzi.cloneanalyzer.core.MaxCloneSet;
import de.fzi.sissy.metamod.Clone;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 */
public class CloneStructureBuilder {
	private static CloneStructureBuilder singleton = null;
    
    public static final String MIN_CLONE_LENGTH = "MIN_CLONE_LENGTH";
    public static final String FILE_FILTER = "FILE_FILTER";
    public static final String COMMENT_FILE_NAME = "COMMENT_FILE_NAME";
    public static final String IGNORE_WHITESPACE = "IGNORE_WHITESPACE";
    public static final String IGNORE_COMMENTS = "IGNORE_COMMENTS";
    
	/**
	 *  
	 */
	public CloneStructureBuilder() {
		super();
	}

	public static CloneStructureBuilder getSingleton() {
		if (singleton == null) {
			singleton = new CloneStructureBuilder();
		} //if
		return singleton;
	} //getSingleton

    public static Properties getDefaultParameters() {
        
        // default parameters

        Properties default_parameters = new Properties();
        
        default_parameters.setProperty(MIN_CLONE_LENGTH, "5");
        default_parameters.setProperty(FILE_FILTER, ".*\\.(java|c|cpp|h|hpp|pas|dpr)");
        default_parameters.setProperty(COMMENT_FILE_NAME, "comments.dat");
        default_parameters.setProperty(IGNORE_WHITESPACE, "false");
        default_parameters.setProperty(IGNORE_COMMENTS, "false");
        
        return default_parameters;
        
    }
    
    /**
     * this method creates the xml temp file needed for the clone analyzer and returns the path to this file
     * @param pathList the path list which contains the directories to analyze
     * @return the path to the temp file, or null if an error occured
     */
    private String createCloneAnalyzerParamTempFile(List pathList) {
        String result = null;
        try {
            File tempFile = File.createTempFile("cloneanalyzerconfig", ".xmltemp");
            tempFile.deleteOnExit();
            FileWriter fw = new FileWriter(tempFile);
            XmlWriter writer = new XmlWriter(fw);
            fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.writeEntity("CloneAnalyzerConfig");
            Iterator it = pathList.iterator();
            while (it.hasNext()) {
                String path = (String)it.next();
                writer.writeEntity("IncludeDirectory");
                writer.writeAttribute("path", path);
                writer.endEntity();
            }
            writer.endEntity();
            writer.close();
            fw.close();
            result = tempFile.getCanonicalPath();
        } catch (Exception e) {
            Debug.error("Exception occured while initializing clone analyzer arguments: " + e.getMessage());
            result = null;
        }    
        return result;
    }
    
    // this method is waaaaaay to long
    // TODO: split this method
    public void executeCloneAnalyseAndCreateCloneStructure(ModelElementRepository modelElementRepository, 
            Properties parameters) {
        
    	List pathList = modelElementRepository.getAnalysisPathList(); 
    	// setup parameters
		String minCloneLength = parameters.getProperty(MIN_CLONE_LENGTH);
        String fileFilter = parameters.getProperty(FILE_FILTER);
        String ignoreWhitespace = parameters.getProperty(IGNORE_WHITESPACE);
        String ignoreComments = parameters.getProperty(IGNORE_COMMENTS);
        String commentFileName = parameters.getProperty(COMMENT_FILE_NAME);

        /*
		System.out
		.println("\nusage:   CloneAnalyzerConsole -m MinCloneLength\n"
				+ "-d InputDirectory -f FileFilter -c CommentFileName\n"
				+ "-iw [true|false] -ic [true|false]\n\n"
				+ "default: CloneAnalyzerConsole -m 15 "
				+ "-d . -f .*\\.(java|c|cpp|pas) -c comments.conf\n");
*/
		

        String analysisFile = createCloneAnalyzerParamTempFile(pathList);
        
        if (analysisFile == null)
            return;

        
            
        String[] args = new String[]{
                "CloneAnalyzerConsole", 
                "-m", minCloneLength+"", 
                "-d", analysisFile, 
                "-f", fileFilter,
                "-iw", ignoreWhitespace,
                "-ic", ignoreComments,
                "-c", commentFileName};

        CloneSetStructure css = CloneAnalyzerConsole.main(args);

        // In the next part we get a rough structure
        // of cloneSets -- cloneInstances -- Statements
		
        // get Array with CloneSets
        if(css==null) return;
        Object[] cloneSetObjects = css.getArray();
        Vector cloneSet_collection = new Vector();

        // For each CloneSet
        for (int j = 0; j < cloneSetObjects.length; j++) {
            MaxCloneSet mcs = (MaxCloneSet) cloneSetObjects[j];

            Object[] cloneInstanceObjects = mcs.getArray();
            Vector cloneInstance_collection = new Vector();

            // For each CloneInstance in this CloneSet
            for (int k = 0; k < cloneInstanceObjects.length; k++) {
                de.fzi.cloneanalyzer.core.CloneInstance ci = (de.fzi.cloneanalyzer.core.CloneInstance) cloneInstanceObjects[k];

                String filename = ""+ci.getStartLine().getFile();

                // write Drive-Name uppercase
                if (filename.charAt(1) == ':')
                    filename = new String(filename.substring(0, 1).toLowerCase() + filename.substring(1));
                /*					
					StringBuffer fb = new StringBuffer(filename);
					int colonindex = fb.indexOf(":");
					if (colonindex==1) {
						char drivename = fb.charAt(0);
						String drive = drivename + "";
						fb.replace(0,1,drive.toLowerCase());
						filename = fb.toString();
					}else {
						if (colonindex!=-1)
							Debug.warning("Filename with Colon not as second char: "+ filename);
					}
                 */					

                // get statements:
                ModelElementList statement_list = FilenameToStatementMapper.getSingleton().getStatements(filename);

                Vector statement_collection = new Vector();

                if (statement_list == null) {
                    Debug.warning("CA: Statement-List for File "+ filename + " was null !");
                    //continue;
                } else {
                    if (statement_list.size()==0) {
                        Debug.warning("CA: Statement-List for File "+ filename + " was empty !");
                    }
                    //Debug.info("CA: Statement-List for File "+ filename + " was okay !");
                    for (int t=0; t<statement_list.size(); t++) {
                        Statement statement = (Statement)statement_list.get(t);

                        // We decided, to add overlapping statements also to CloneInstance!!
                        if (isOverlapping(ci, statement)) {
                            statement_collection.add(statement);
                        } else if (contains(ci, statement)) {
                            statement_collection.add(statement);
                        }
                    }
                }

                cloneInstance_collection.add(statement_collection);
            }
            cloneSet_collection.add(cloneInstance_collection);
        }

        // now we have to fine-tune the collections:
        // - split Statement-Collections from different
        //   methods into different Collections for different
        //   cloneInstances

        // Linear parsing of one statement-collection per cloneSet
        // and transfering of statements of same method into same
        // collection-set for cloneInstances!

        Vector new_cloneSet_collection = new Vector();

        for (int i_cs = 0; i_cs < cloneSet_collection.size(); i_cs++) {
            // collection with cloneInstances for current CloneSet
            Vector current_cloneInstance_collection = (Vector) cloneSet_collection.get(i_cs);
            int number_statement_collections = current_cloneInstance_collection.size();

            Vector new_cloneInstance_collection = null;

            // get statement_collection of first CloneInstance for current CloneSet
            Vector statement_collection = (Vector) current_cloneInstance_collection.get(0);

            // parse statements:
            String current_method_signature = "";
            for (int i_stm = 0; i_stm < statement_collection.size(); i_stm++) {
                Statement current_statement = (Statement)statement_collection.get(i_stm);
                Function method_of_statement = current_statement.getSurroundingFunction();
                if (method_of_statement == null) {
                    Debug.warning("CA: Method of Statement was null !");
                    Debug.warning(current_statement.getPosition().getSourceFile().getPathName());
                    continue;
                }


                if (current_method_signature.equals(method_of_statement.signature().toString())) {
                    // Case: Method-Signature equal ==> same method as before!
                } else {
                    // Case: Method changed! ==> split sets!
                    new_cloneInstance_collection = new Vector();

                    // create new statement-collection for each new-cloneInstance!
                    for (int j=0; j<number_statement_collections; j++) {
                        new_cloneInstance_collection.add(new Vector());
                    }

                    new_cloneSet_collection.add(new_cloneInstance_collection);
                }

                // transfer statements from cloneInstances into statement_collections of new cloneInstances!
                for (int i_t=0; i_t < number_statement_collections; i_t++) {
                    try {
                        Statement transfer_statement = (Statement)((Vector)current_cloneInstance_collection.get(i_t)).get(i_stm);
                        ((Vector)new_cloneInstance_collection.get(i_t)).add(transfer_statement);
                    } catch (ArrayIndexOutOfBoundsException aie) {
//                      aie.printStackTrace();
                        Debug.warning("Some Statements for CloneInstance were incomplete!");
                    }
                }

                current_method_signature = method_of_statement.signature().toString();
            }
        }

        // at this point we have a hierachical collection-structure
        // which can be mapped directly to the appropriate 
        // metamod-Clone-CloneInstance-Statement-Structure!

        /* Construction-Process:
         * =====================
         * - For each CloneInstance-collection in the CloneSet-Collection 
         * 		==> create a Metamod-Clone-Object
         * 		==> For each statement-collection of the CloneInstance-Collection
         * 				==> create a Metamod-CloneIntance-Object
         * 						==> add statements   
         */ 

        Debug.info("After Processing of Data from CloneAnalyzer:");
        Debug.info("Number of Metamod-Clones: "+ new_cloneSet_collection.size());


        for (int i_cs = 0; i_cs < new_cloneSet_collection.size(); i_cs++) {
            Vector current_cloneInstance_collection = (Vector) new_cloneSet_collection.get(i_cs);

            Debug.info("For Clone "+i_cs + ":");

            // create Metamod-Clone-Object
            Clone metamod_clone = new Clone();

            for (int i_ci = 0; i_ci < current_cloneInstance_collection.size(); i_ci++) {
                Vector current_statement_collection = (Vector) current_cloneInstance_collection.get(i_ci);

                Debug.info("For CloneInstance "+i_ci + ": ");
                Debug.info("Number of Statements: " + current_statement_collection.size());

                // create Metamod-CloneInstance-Object 
                de.fzi.sissy.metamod.CloneInstance metamod_cloneInstance = new de.fzi.sissy.metamod.CloneInstance();

                metamod_clone.addCloneInstance(metamod_cloneInstance);

                // add statements
                for (int i_stm = 0; i_stm < current_statement_collection.size(); i_stm++) {
                    Statement current_statement = (Statement)current_statement_collection.get(i_stm);
                    metamod_cloneInstance.addStatement(current_statement);
                }

            }

            // add Metamod-Clone-Object to Root
            modelElementRepository.getRoot().addClone(metamod_clone);
        }
		
	}

	private boolean contains(CloneInstance ci, Statement statement) {

		int startLine_statement = statement.getPosition().getStartLine();
		int endLine_statement = statement.getPosition().getEndLine();

		// CloneAnalyzer hat 
		int startLine_cloneInstance = ci.getStartLine().getLineNumber()+1;
		int endLine_cloneInstance = ci.getEndLine().getLineNumber()+1;

		boolean ergebnis =
			((startLine_statement >= startLine_cloneInstance)&&
			 (endLine_statement <= endLine_cloneInstance));
			
		
		return ergebnis;
	}

    private boolean isOverlapping(CloneInstance ci, Statement statement) {

        //     CI_S                     CI_E
        //            STM_S                     STM_E
        // ------------------------------------------------
        // small                                       big 
        
        int startLine_statement = statement.getPosition().getStartLine();
        int endLine_statement = statement.getPosition().getEndLine();

        // CloneAnalyzer hat 
        int startLine_cloneInstance = ci.getStartLine().getLineNumber()+1;
        int endLine_cloneInstance = ci.getEndLine().getLineNumber()+1;

        boolean ergebnis =
            ((startLine_statement >= startLine_cloneInstance)&&(startLine_statement <= endLine_cloneInstance)&&
             (endLine_statement > endLine_cloneInstance));
            
        
        return ergebnis;
    }

	
}
