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

import java.util.Iterator;

import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;

/**
 * This class computes the WOC metric: the number of "functional" (non-accessor) public methods, divided by the total
 * number of public methods 
 */
public class WOC extends Metric {

    /**
     * Default constructor
     *
     */
    public WOC() {
        super("WOC");
    }

    public double compute(ModelElement me) throws IllegalArgumentException {
        if (me instanceof Class) {
            Class c = (Class) me;
            ModelElementList publicMethods = c.getMethods().filter("de.fzi.sissy.metamod.Method");
            Iterator it = publicMethods.iterator();
            double accessorCount = 0;
            while (it.hasNext()) {
                Method m = (Method) it.next();
                if (!m.isPublic()) {
                    it.remove();
                    //it = publicMethods.iterator();
                } else {
                    if (m.isAccessor())
                        accessorCount++;
                }
            }

            return accessorCount/publicMethods.size();
        }
        
        throw new IllegalArgumentException("Cannot compute NOM for "+ me.toString());
    }

}
