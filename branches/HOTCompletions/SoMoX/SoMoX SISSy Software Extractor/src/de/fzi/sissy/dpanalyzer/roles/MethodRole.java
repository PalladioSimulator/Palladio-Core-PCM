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
package de.fzi.sissy.dpanalyzer.roles;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.DesignPatternDescription;
import de.fzi.sissy.dpanalyzer.DesignPatternRetrievalProcess;
import de.fzi.sissy.dpanalyzer.constraints.classes.ClassConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodConstraint;
import de.fzi.sissy.util.Debug;

public class MethodRole extends Role {
    
    public MethodRole(String role_name, String identifier, DesignPatternDescription dp_description) {
        super(role_name, identifier, dp_description);
    }

}
