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
package de.fzi.sissy.dpanalyzer.constraints.classes;

import java.util.Collection;

import de.fzi.sissy.dpanalyzer.constraints.CheckObjectConstraint;
import de.fzi.sissy.dpanalyzer.constraints.Constraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.RoleConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.BooleanConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.parts.EvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.IdentifierEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.RoleEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.BooleanEvaluationPart;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

public abstract class ClassConstraint extends CheckObjectConstraint {

    public ClassConstraint(String check_object_identifier, boolean isTrue) {
        super(check_object_identifier, isTrue);
    }

    public ClassConstraint(String check_object_identifier, Role evaluation_role) {
        super(check_object_identifier, evaluation_role);
    }

    public ClassConstraint(String check_object_identifier, String evaluation_string, boolean isID) {
        super(check_object_identifier, evaluation_string, isID);
    }
    
    protected boolean checkObject(Object check_object) {
        if (!(check_object instanceof de.fzi.sissy.metamod.Class)) {
            Debug.warning("ClassConstraint: check_object was not Class-Object");
            return false;
        }
        
        //return checkClass((de.fzi.sissy.metamod.Class)check_object);
        return evaluation_part.evaluate(check_object);
    }

    //protected abstract boolean checkClass(de.fzi.sissy.metamod.Class class_object);
    
}
