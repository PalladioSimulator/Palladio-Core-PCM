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
package de.fzi.sissy.extractors.java;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import recoder.ParserException;
import de.fzi.sissy.extractors.GenericExtractor;
import de.fzi.sissy.util.Debug;

/**
 * @author szulman
 *
 * It extractes a model based on the source code of a system.
 * It builds up a MOF conform model using MDR and then exports
 * the model into XMI.
 */
public class Extractor extends GenericExtractor {
	/**
	 * Constructor for the extractor. 
	 * @param sourcePath Source path of the code to analyze.
	 */
	public Extractor(String args[])
	{
		super(args, new JavaFileFilter());
		cloneAnalyzerCommentFile = "res\\clone\\java_cpp_comments.dat";
		commentAnalyzerCommentFile = "res\\comments\\java_cpp.dat";
	}
		
	protected void addLanguageSpecificOptions()
	{
        argParser.usage = "SISSy -java <path-list>\n\t"+
		"<path-list>\t\ta list of pathnames pointing to folders containing the sources (separated by "
		+ File.pathSeparator
		+ "). For example \"C:/tmp/"
		+ File.pathSeparator
		+ "src"
		+ File.pathSeparator
		+ "work/files\".\n";
        argParser.addOption("source", "level", "sets the JAVA compiler compliance level of the analyzed sources. It can be 1.3, 1.4 or 5.0 and the default value is 1.4.");
	}	

	protected void buildMetaModel()
	{
		try
		{
			long currentTimeMillisBeforeAnalyzing = System.currentTimeMillis();
	
			Debug.info("Time before analyzing project " + 
					 	new Date(currentTimeMillisBeforeAnalyzing));
	
			ExtractorFassade recoderFassade = new ExtractorFassade(modelElementRepository);
            recoderFassade.setLangVersion(argParser.getParameter("source"));
            recoderFassade.extract();
				
			
			long currentTimeMillisAfterAnalyzing = System.currentTimeMillis();
	
			Debug.info("Time elapsed so far " +	
						Float.toString( (currentTimeMillisAfterAnalyzing - currentTimeMillisBeforeAnalyzing)/1000.0f ) + 
						" s");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void extractLanguageSpecificParameters()
	{
		// Nothing to do here
	}
}
