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

import java.util.HashMap;

import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.Statement;

/**
 * @author stammel
 *
 */
public class FilenameToStatementMapper {

	private static FilenameToStatementMapper singleton = null;
	
	//Accelerates the lookup of recoder objects to the approprieate OM object
	private HashMap filenameToStatementMapper = null;

	public FilenameToStatementMapper() {
		super();
		filenameToStatementMapper = new HashMap();
	}
	
	public static FilenameToStatementMapper getSingleton() {
		if (singleton == null) {
			singleton = new FilenameToStatementMapper();
		}
		return singleton;
	}

	
	public void addStatement(String filename, Statement metamod_statement) {
		if (filename.startsWith("FILE"))
			filename = filename.substring(5);

		if (filename.charAt(1) == ':')
			filename = new String(filename.substring(0, 1).toLowerCase() + filename.substring(1));
	    if (filenameToStatementMapper.containsKey(filename)) {
	    	ModelElementList list = (ModelElementList) filenameToStatementMapper.get(filename);
	    	list.addUnique(metamod_statement);
	    } else {
	    	ModelElementList list = new ModelElementList();
	    	list.addUnique(metamod_statement);
	    	filenameToStatementMapper.put(filename, list);
	    }
	    
	} 

	public ModelElementList getStatements(String filename) {
	    if (filenameToStatementMapper.containsKey(filename)) {
	    	ModelElementList list = (ModelElementList) filenameToStatementMapper.get(filename);
	    	return list;
	    } else {
	    	return null;
	    }
	    
	} 


}
