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
package de.fzi.sissy.metamod.metrics;

import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;

/**
 * LAA - Locality of Attribute Accesses. This metric is defined as a number of attributes from the methods definition class
 * divided by the total number of variables accessed. 
 *
 */
public class LAA extends Metric {

    /**
     * Default constructor, does nothing special.
     */
    public LAA() {
        super("LAA");
    }

    public double compute(ModelElement me) throws IllegalArgumentException {
        if ( (me instanceof Method) || (me instanceof Constructor) ) {
            Function function = (Function) me;
            Member member = (Member) me;
            Class ownerClass = member.getSurroundingClass();
            return ((double)function.getAccessedVariables(true).size())/ownerClass.getFields().size();
        }
        
        throw new IllegalArgumentException("Cannot compute LAA for "+ me.toString());
    }

}
