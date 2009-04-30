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
package de.fzi.sissy.dpanalyzer.constraints.formalparameter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.MetamodRetrievalEngineImplementation;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.RoleConstraint;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.FormalParameter;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

public class FormalParameterIsOfTypeConstraint extends FormalParameterConstraint implements RoleConstraint, IdentifierConstraint {

    public FormalParameterIsOfTypeConstraint(String check_object_identifier, Role contained_class_role) {
        super(check_object_identifier, contained_class_role);
    }

    public FormalParameterIsOfTypeConstraint(String check_object_identifier, String container_class_identifier) {
        super(check_object_identifier, container_class_identifier, true);
    }

    public Collection getCandidateCollection(Object check_object) {
        if (check_object instanceof de.fzi.sissy.metamod.FormalParameter)
            return MetamodRetrievalEngineImplementation.getSingleton().getTypesOfFormalParameter((de.fzi.sissy.metamod.FormalParameter)check_object);
        else
            return new Vector();
    }

    public boolean evaluateByIdentifier(Object check_object, Object evaluation_object) {
        if ((check_object instanceof de.fzi.sissy.metamod.FormalParameter)&&(evaluation_object instanceof de.fzi.sissy.metamod.Type))
            return MetamodRetrievalEngineImplementation.getSingleton().formalParameterIsOfType((de.fzi.sissy.metamod.FormalParameter)check_object, (de.fzi.sissy.metamod.Type)evaluation_object);
        else
            return false;
    }

}