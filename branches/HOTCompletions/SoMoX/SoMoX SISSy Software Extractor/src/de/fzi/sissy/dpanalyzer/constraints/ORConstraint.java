/**
 * Copyright (c) 2005-2006 FZI Forschungszentrum Informatik, 
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
package de.fzi.sissy.dpanalyzer.constraints;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import de.fzi.sissy.dpanalyzer.DesignPatternDescription;
import de.fzi.sissy.metamod.ModelElement;

public class ORConstraint extends ConstraintImplementation {

    private Collection constraint_collection;
    
    public ORConstraint(Constraint[] constraints) {
        constraint_collection = new LinkedList();
        
        for (int i=0; i<constraints.length; i++) {
            constraints[i].setDesignPatternDescription(this.getDesignPatternDescription());
            constraint_collection.add(constraints[i]);
        }
    }

    public ORConstraint(Constraint constraint1, Constraint constraint2) {
        constraint_collection = new LinkedList();
        
        constraint1.setDesignPatternDescription(this.getDesignPatternDescription());
        constraint2.setDesignPatternDescription(this.getDesignPatternDescription());
        
        constraint_collection.add(constraint1);
        constraint_collection.add(constraint2);
    }

    public boolean check() {
        Iterator itr = constraint_collection.iterator();
        
        while(itr.hasNext()) {
            Constraint constraint = (Constraint)itr.next();
            
            if (constraint.check()) {
                return true;
            }
            
        }
        
        return false;
    }

    protected String stringOfInnerParts() {
        StringBuffer sb = new StringBuffer();

        Iterator constraint_itr = constraint_collection.iterator();
        
        while (constraint_itr.hasNext()) {
            Constraint constraint  = (Constraint) constraint_itr.next();
            
            sb.append(constraint.toString());
            if (constraint_itr.hasNext())
                sb.append(", ");
            //sb.append("\n");
        }
        
        return sb.toString();

    }
    
    public void setDesignPatternDescription(DesignPatternDescription dpd) {
        super.setDesignPatternDescription(dpd);

        Iterator itr = constraint_collection.iterator();
        
        while(itr.hasNext()) {
            Constraint constraint = (Constraint)itr.next();
            constraint.setDesignPatternDescription(dpd);
        }

    }

}
