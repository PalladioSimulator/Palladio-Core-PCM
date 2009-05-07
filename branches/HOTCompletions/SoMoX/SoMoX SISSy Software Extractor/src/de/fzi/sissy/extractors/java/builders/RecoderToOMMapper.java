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
package de.fzi.sissy.extractors.java.builders;

import java.util.HashMap;

import recoder.NamedModelElement;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

/**
 * @author szuli
 */
public class RecoderToOMMapper {

	private static RecoderToOMMapper singleton = null;
	
	//Accelerates the lookup of recoder objects to the approprieate OM object
	private HashMap recoderToOMMapper = null;

	public RecoderToOMMapper() {
		super();
		recoderToOMMapper = new HashMap();
	}
	
	public static RecoderToOMMapper getSingleton() {
		if (singleton == null) {
			singleton = new RecoderToOMMapper();
		}
		return singleton;
	}

	public void addInstanceToMapper(Object recoderObject, ModelElement OMModelElement) {
	    
	    //String s = "not a NamedModelElement";
	    String s = recoderObject.getClass().getName();
        if (recoderObject instanceof NamedModelElement)
            s = ((NamedModelElement)recoderObject).getName(); 
	    
	    if (recoderToOMMapper.containsKey(recoderObject)) {
	        Debug.warning("Mapper already contains the value to the key with following name: " + s);
	        return;
	    }
	    
	    if (OMModelElement == null) {
	        Debug.warning("Mapped target was null");
	        return;	    	
	    }
	    
		this.recoderToOMMapper.put(recoderObject, OMModelElement);
	} //addInstanceToMapper

	public ModelElement getInstanceFromMapper(Object recoderObject) {
		return (ModelElement) this.recoderToOMMapper.get(recoderObject);
	} //getInstanceFromMapper
	
}
