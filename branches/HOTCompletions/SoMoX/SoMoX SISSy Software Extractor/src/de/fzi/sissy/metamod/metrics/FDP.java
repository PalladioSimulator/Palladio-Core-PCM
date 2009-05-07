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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.Variable;

/**
 * This class computes the FDP metric - Foreign Data Providers, it is defined as a number of distinct classes in which the
 * attributes from the ATFD metric reside.
 *
 */
public class FDP extends Metric {

    /**
     * Default constructor, does nothing
     */
    public FDP() {
        super("FDP");
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.metamod.metrics.Metric#compute(de.fzi.sissy.metamod.ModelElement)
     */
    public double compute(ModelElement me) throws IllegalArgumentException {
        if ( (me instanceof Method) || (me instanceof Constructor) ) {
            Function function = (Function) me;
            Member member = (Member) me;
            Class ownerClass = member.getSurroundingClass();
            Set classes = new HashSet();
            ModelElementList mel = function.getAccessedVariables(true);
            Iterator it = mel.iterator();
            while (it.hasNext()) {
                Variable v = (Variable) it.next();
                if (v instanceof Field) {
                    Field f = (Field)v;
                    if (ownerClass.isUnrelatedTo(f.getSurroundingClass()))
                        classes.add(f.getSurroundingClass());
                }
            }

            return classes.size();
        }
            
        throw new IllegalArgumentException("Cannot compute ATFD for "+ me.toString());
    }

    

}
