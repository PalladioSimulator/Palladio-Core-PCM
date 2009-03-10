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
package de.fzi.sissy.metamod;

import java.io.Serializable;

import de.fzi.sissy.util.Debug;

/**
 * @author povalahe
 *
 */
class SourceEntityImplementation implements Serializable{

    private Position position;
    
    private void setPosition(Position pos) {
        position = pos;    		
    }
    
    public void setPosition(Position pos, ModelElement elem) {
    	setPosition(pos);
        if ((!elem.isImplicit())&&(!elem.isFailedDependency())) {
            if (checkForLibrary()) {
                elem.setLibrary();
            } else {
                elem.setNormal();
            }
        }    	
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void moveToFile(File file) {
        if ((position == null) || (file == null))
            return;
        if (file.isAssembly())
            position.setAssembly(file);
        else
            position.setSourceFile(file);
    }
    
    public boolean checkForLibrary() {
        // here we check, if position-path is in analyse-paths
        // if NOT ==> it is a LIBRARY element
        if (position == null) {
            Debug.warning("Position for SourceEntityImpl. was null!");  
            return true;
        }

        if (position.getSourceFile() == null) {
            //Debug.warning("SourceFile of Position-Object was null!");
            return true;
        }

        return position.getSourceFile().isLibrary();
    }
}

/* this code should be used for delegation:
------------------------
	// delegation to the SourceEntityImplemenatation
	
	private SourceEntityImplementation sourceEntityImplementation = new SourceEntityImplementation();
	
	public void setPosition(Position pos) {
	    sourceEntityImplementation.setPosition(pos);
	}
	
	public Position getPosition() {
	    return sourceEntityImplementation.getPosition();
	}
	
	public void moveToFile(File file) {
	    sourceEntityImplementation.moveToFile(file);
	}
-----------------------
	*/
