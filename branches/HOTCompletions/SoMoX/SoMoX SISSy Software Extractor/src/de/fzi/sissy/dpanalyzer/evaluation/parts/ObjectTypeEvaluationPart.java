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

import de.fzi.sissy.dpanalyzer.evaluation.interfaces.ObjectTypeConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.RoleConstraint;
import de.fzi.sissy.dpanalyzer.roles.Role;

public class ObjectTypeEvaluationPart implements EvaluationPart {

    private ObjectTypeConstraint object_type_constraint;
    private java.lang.Class object_class;
    
    public ObjectTypeEvaluationPart(java.lang.Class object_class, ObjectTypeConstraint object_type_constraint) {
        this.object_class = object_class;
        this.object_type_constraint = object_type_constraint;
    }

    public boolean evaluate(Object check_object) {
        if (check_object == null)
            return false;
        
        return (check_object.getClass() == object_class);
    }

    public String toString() {
        return object_class.getName();
    }

}
