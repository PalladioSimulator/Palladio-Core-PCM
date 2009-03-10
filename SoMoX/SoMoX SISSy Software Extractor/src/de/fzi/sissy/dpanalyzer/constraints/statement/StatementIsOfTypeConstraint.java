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
package de.fzi.sissy.dpanalyzer.constraints.statement;

import de.fzi.sissy.dpanalyzer.evaluation.interfaces.ObjectTypeConstraint;
import de.fzi.sissy.metamod.Statement;

public class StatementIsOfTypeConstraint extends StatementConstraint implements ObjectTypeConstraint {

    public StatementIsOfTypeConstraint(String check_object_identifier, java.lang.Class statement_type_class) {
        super(check_object_identifier, statement_type_class);
    }
    
    // evaluation is done in ObjectTypeEvaluationPart !!!

}
