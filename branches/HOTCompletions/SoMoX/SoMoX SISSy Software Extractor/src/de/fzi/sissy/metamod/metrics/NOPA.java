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
import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;

/**
 * This metric measures the number of public attribute of a class
 */
public class NOPA extends Metric {

    /**
     * Default constructor, does nothing
     */
    public NOPA() {
        super("NOPA");
    }

    public double compute(ModelElement me) throws IllegalArgumentException {
        if (me instanceof Class) {
            double result = 0;
            Class c = (Class) me;
            ModelElementList attr = new ModelElementList(c.getFields());
            Iterator it = attr.iterator();
            while (it.hasNext()) {
                if (((Field)it.next()).isPublic()) 
                    result++;
            }
            return result;
        }
        
        throw new IllegalArgumentException("Cannot compute NOPA for "+ me.toString());
    }

}
