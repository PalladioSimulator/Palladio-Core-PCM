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
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;

/**
 * Tight Class Cohesion metric. It is defined as a relative number of directly connected methods in a class
 */
public class TCC extends Metric {

    private ModelElementList classFieldCache;
    private Class cachedClass;
    
    /**
     * Default constructor, sets the type, and does nothing special beyond that
     */
    public TCC() {
        super("TCC");
    }

    public double compute(ModelElement me) throws IllegalArgumentException {
        if (me instanceof Class) {
            Class c = (Class) me;
            ModelElementList methods = c.getMethods().filter("de.fzi.sissy.metamod.Method");
            int connectedMethods = 0;
            Object[] methodArray = methods.toArray();
            for (int i=0; i<methodArray.length; i++) {
                for (int k=i+1; k<methodArray.length; k++) {
                    Method m1 = (Method) methodArray[i];
                    Method m2 = (Method) methodArray[k];
                    if (connected(m1, m2))
                        connectedMethods++;
                }
            }
            
            if ((connectedMethods == 0) || (methods.size()<2))
                return 0;
            return ((double)connectedMethods)/(methods.size()*(methods.size()-1)/2);
            
        }
        
        throw new IllegalArgumentException("Cannot compute TCC for "+ me.toString());
    }

    private boolean connected(Method m1, Method m2) {
        if (cachedClass != m1.getSurroundingClass()) {
            cachedClass = m1.getSurroundingClass();
            classFieldCache = m1.getSurroundingClass().getFields();
        }
        
        if (cachedClass.getFields().size() == 0)
            return false;
        
        ModelElementList m1Vars = m1.getAccessedVariables(true);
        ModelElementList m2Vars = m2.getAccessedVariables(true);
        
        m1Vars.retainAll(m2Vars);
        m1Vars.retainAll(classFieldCache);
        
        if (!m1Vars.isEmpty())
            return true;
        
        return false;
    }
    
}
