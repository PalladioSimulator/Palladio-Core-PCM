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

import java.util.HashMap;

import de.fzi.delphi.symbols.Symbol;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 */
public class OPParserToMetamodMapper {

	private static OPParserToMetamodMapper singleton = null;
	
	//Accelerates the lookup of recoder objects to the approprieate OM object
	private HashMap opParserToMetamodMapper = null;

	public OPParserToMetamodMapper() {
		super();
		opParserToMetamodMapper = new HashMap();
	}
	
	public static OPParserToMetamodMapper getSingleton() {
		if (singleton == null) {
			singleton = new OPParserToMetamodMapper();
		}
		return singleton;
	}

	public void addInstanceToMapper(Object opObject, ModelElement OMModelElement) {
	    
	    //String s = "not a NamedModelElement";
	    String s = opObject.getClass().getName();
        if (opObject instanceof Symbol)
            s = ((Symbol)opObject).getFullName(); 
	    
	    if (opParserToMetamodMapper.containsKey(opObject)) {
	        Debug.warning("Mapper already contains the value to the key with following name: " + s);
	        return;
	    }
		this.opParserToMetamodMapper.put(opObject, OMModelElement);
	} //addInstanceToMapper

	public ModelElement getInstanceFromMapper(Object opObject) {
		return (ModelElement) this.opParserToMetamodMapper.get(opObject);
	} //getInstanceFromMapper
}
