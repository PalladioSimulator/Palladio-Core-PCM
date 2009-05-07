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
package de.fzi.sissy.extractors.meta;

import java.util.HashMap;

import recoder.NamedModelElement;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 */
public class GeneralMapper {

	private HashMap map = null;
	
	public GeneralMapper() {
	    map = new HashMap();
	}
	
	public void addInstance(Object key, ModelElement model_element) {
	    String s = key.getClass().getName();
	    
	    if (map.containsKey(key)) {
	        Debug.warning("Mapper already contains the value to the key with following name: " + s);
	        return;
	    }
        
        if (model_element==null) {
            Debug.warning("Tried to map null-object! (key: "+key+")");
            return;
        }
	    
		this.map.put(key, model_element);

	}

	public ModelElement getInstance(Object key) {
        if (key==null)
            return null;
		return (ModelElement) this.map.get(key);
	}
    
    
}
