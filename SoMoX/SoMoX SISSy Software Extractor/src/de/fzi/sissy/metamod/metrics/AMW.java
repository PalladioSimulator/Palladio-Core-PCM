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
import de.fzi.sissy.metamod.ModelElement;

/**
 * This is the average complexity of all methods of the class.
 * AMW(Class) = WMC(Class)/NOM(Class)
 */
public class AMW extends Metric {

    /**
     * Default constructor, does nothing
     */
    public AMW() {
        super("AMW");
    }

    /**
     * Computes the AMW metric
     * @return returns the metric value, or 0, if the class has no methods; 
     */
    public double compute(ModelElement me) throws IllegalArgumentException {
        if (me instanceof Class) {
            Class c = (Class) me;
            WMC wmc = new WMC();
            NOM nom = new NOM();
            double wmc_result = wmc.compute(c);
            double nom_result = nom.compute(c);
            if ((wmc_result == 0) || (nom_result == 0))
                return 0;
            else
                return wmc_result/nom_result;
        }
        
        throw new IllegalArgumentException("Cannot compute AMW for "+ me.toString());
    }

}
