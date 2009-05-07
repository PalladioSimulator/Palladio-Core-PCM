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

import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;

/**
 * This is the Coupling Intensity metric, defined as a number of distinct function calls from a given function 
 */
public class CINT extends Metric {

    /**
     *  Default constructor 
     */
    public CINT() {
        super("CINT");
    }

    public double compute(ModelElement me) throws IllegalArgumentException {
        if (me instanceof Function) {
            Function function = (Function) me;
            ModelElementList mel = function.getAllAccesses().filter("de.fzi.sissy.metamod.FunctionAccess");
            Set set = new HashSet(mel);
            Iterator it = mel.iterator();
            while (it.hasNext()) 
                set.add(((FunctionAccess)it.next()).getAccessedFunction());
            return set.size();
        }
        
        throw new IllegalArgumentException("Cannot compute CINT for "+ me.toString());
    }

}
