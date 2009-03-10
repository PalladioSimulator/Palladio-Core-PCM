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
 * This metric computes the number of accessor methods for a given class
 */
public class NOAM extends Metric {

    /**
     * Default constructor, sets the type
     */
    public NOAM() {
        super("NOAM");
    }

    public double compute(ModelElement me) throws IllegalArgumentException {
        if (me instanceof Class) {
            double result = 0;
            Class c = (Class) me;
            ModelElementList methods = c.getMethods().filter("de.fzi.sissy.metamod.Method");
            Iterator it = methods.iterator();
            while (it.hasNext()) {
                if (((Method)it.next()).isAccessor())
                    result++;
            }
            return result;
        }
        
        throw new IllegalArgumentException("Cannot compute NOAM for "+ me.toString());
    }

}
