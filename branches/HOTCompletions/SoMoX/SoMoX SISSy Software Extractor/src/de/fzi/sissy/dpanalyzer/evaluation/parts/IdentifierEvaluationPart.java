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
package de.fzi.sissy.dpanalyzer.evaluation.parts;

import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.BooleanConstraint;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

public class IdentifierEvaluationPart implements EvaluationPart {

    private IdentifierConstraint identifier_constraint;
    private String evaluation_identifier;
    
    public IdentifierEvaluationPart(String evaluation_identifier, IdentifierConstraint identifier_constraint) {
        this.evaluation_identifier = evaluation_identifier;
        this.identifier_constraint = identifier_constraint;
    }
    
    public boolean evaluate(Object check_object) {
        ModelElement evaluation_object = identifier_constraint.getModelElementByIdentifier(this.evaluation_identifier);
        
        if (evaluation_object == null) {
            System.out.println("IdentifierEvaluationPart.evaluate(): mapped evaluation-object was null!");
        }
        
        return identifier_constraint.evaluateByIdentifier(check_object, evaluation_object);
    }
    
    public String toString() {
        return evaluation_identifier;
    }

    public String getEvaluationIdentifier() {
        return evaluation_identifier;
    }

    public void setEvaluationIdentifier(String evaluation_identifier) {
        this.evaluation_identifier = evaluation_identifier;
    }
    
}
