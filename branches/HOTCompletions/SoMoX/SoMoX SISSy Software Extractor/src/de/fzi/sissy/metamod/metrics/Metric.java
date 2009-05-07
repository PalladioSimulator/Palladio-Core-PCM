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

import de.fzi.sissy.metamod.ModelElement;

/**
 * Base class for all metrics, containing a type of a metric.
 * @author povalahe
 *
 */
public abstract class Metric {
    
    private String type;
    
    /**
     * Constructs a metric with specified type.
     * @param type the type of a metric
     */
    public Metric(String type) {
        this.type = type;
    }
    
    /**
     * Returns the type of a metric
     * @return the type of a metric
     */
    public String getType() {
        return type;
    }
    
    /**
     * Computes a metric for given mode element. Each concrete metric is able to compute "itself" for all applicable
     * types. Here polymorphism is not used for simplicity, since using polymorphism would require a complex custom-rtt
     * which is an overkill IMHO
     * @param me The model element for which the metric should be computed
     * @return the value of the computed metric
     * @throws IllegalArgumentException is thrown if a metric cannot be computed for a given model element
     */
    public abstract double compute(ModelElement me) throws IllegalArgumentException ;
    
}
