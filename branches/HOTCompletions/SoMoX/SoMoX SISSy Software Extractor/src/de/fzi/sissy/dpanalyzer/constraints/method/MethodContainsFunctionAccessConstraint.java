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
package de.fzi.sissy.dpanalyzer.constraints.method;

import java.util.Collection;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.MetamodRetrievalEngineImplementation;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.RoleConstraint;
import de.fzi.sissy.dpanalyzer.roles.FunctionAccessRole;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;

public class MethodContainsFunctionAccessConstraint extends MethodConstraint implements RoleConstraint, IdentifierConstraint {

    public MethodContainsFunctionAccessConstraint(String check_object_identifier, FunctionAccessRole contained_functionaccess_role) {
        super(check_object_identifier, contained_functionaccess_role);
    }

    public MethodContainsFunctionAccessConstraint(String check_object_identifier, String contained_functionaccess_identifier) {
        super(check_object_identifier, contained_functionaccess_identifier, true);
    }

    public Collection getCandidateCollection(Object check_object) {
        if (check_object instanceof de.fzi.sissy.metamod.Method)
            return MetamodRetrievalEngineImplementation.getSingleton().getContainedFunctionAccessesOfMethod((de.fzi.sissy.metamod.Method)check_object);
        else
            return new Vector();
    }

    public boolean evaluateByIdentifier(Object check_object, Object evaluation_object) {
        if ((check_object instanceof de.fzi.sissy.metamod.Method)&&(evaluation_object instanceof de.fzi.sissy.metamod.FunctionAccess))
            return MetamodRetrievalEngineImplementation.getSingleton().methodContainsFunctionAccess((de.fzi.sissy.metamod.Method)check_object, (de.fzi.sissy.metamod.FunctionAccess)evaluation_object);
        else
            return false;
    }

}
