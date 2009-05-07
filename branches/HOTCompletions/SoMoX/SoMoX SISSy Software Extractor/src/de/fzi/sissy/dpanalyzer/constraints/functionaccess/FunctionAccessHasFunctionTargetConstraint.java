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
package de.fzi.sissy.dpanalyzer.constraints.functionaccess;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.MetamodRetrievalEngineImplementation;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.RoleConstraint;
import de.fzi.sissy.dpanalyzer.roles.ConstructorRole;
import de.fzi.sissy.dpanalyzer.roles.MethodRole;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

// test if we have same function-object as target
public class FunctionAccessHasFunctionTargetConstraint extends
        FunctionAccessConstraint implements RoleConstraint, IdentifierConstraint {

    public FunctionAccessHasFunctionTargetConstraint(String check_object_identifier, MethodRole function_role) {
        super(check_object_identifier, function_role);
    }

    public FunctionAccessHasFunctionTargetConstraint(String check_object_identifier, ConstructorRole constructor_role) {
        super(check_object_identifier, constructor_role);
    }

    public FunctionAccessHasFunctionTargetConstraint(String check_object_identifier, String function_identifier) {
        super(check_object_identifier, function_identifier, true);
    }

    public Collection getCandidateCollection(Object check_object) {
        if (check_object instanceof de.fzi.sissy.metamod.FunctionAccess)
            return MetamodRetrievalEngineImplementation.getSingleton().getFunctionTargetsOfFunctionAccess((de.fzi.sissy.metamod.FunctionAccess)check_object);
        else
            return new Vector();
    }

    public boolean evaluateByIdentifier(Object check_object, Object evaluation_object) {
        if ((check_object instanceof de.fzi.sissy.metamod.FunctionAccess)&&(evaluation_object instanceof de.fzi.sissy.metamod.Function))
            return MetamodRetrievalEngineImplementation.getSingleton().functionAccessHasFunctionTarget((de.fzi.sissy.metamod.FunctionAccess)check_object, (de.fzi.sissy.metamod.Function)evaluation_object);
        else
            return false;
    }

}
