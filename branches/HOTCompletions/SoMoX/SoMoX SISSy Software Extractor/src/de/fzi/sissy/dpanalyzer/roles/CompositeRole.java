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

import java.util.Iterator;

import de.fzi.sissy.dpanalyzer.DesignPatternDescription;
import de.fzi.sissy.dpanalyzer.constraints.Constraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.parts.EvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.IdentifierEvaluationPart;

public class CompositeRole {

    private static int counter = 0;
    
    private DesignPatternDescription contained_dpd;
    
    public CompositeRole(DesignPatternDescription outer_dpd, DesignPatternDescription contained_dpd) {
        counter++;
        this.contained_dpd = contained_dpd;
        outer_dpd.getRoles().addAll(contained_dpd.getRoles());
        outer_dpd.getVisibleRoles().addAll(contained_dpd.getVisibleRoles());

        
        // adapting identifiers of inserted roles:
        Iterator role_itr = contained_dpd.getRoles().iterator();
        
        while (role_itr.hasNext()) {
            Role role = (Role)role_itr.next();
            
            // id of role:
            String id = role.getIdentifier();
            
            String new_id = counter + id;
            
            role.setIdentifier(new_id);
            
            // in case of identifier constraints: adapting referencing ids
            Iterator const_itr = role.getConstraints().iterator();
            
            while (const_itr.hasNext()) {
                Constraint con = (Constraint)const_itr.next();
                
                if (con instanceof IdentifierConstraint) {
                    IdentifierConstraint id_con = (IdentifierConstraint)con;
                    
                    EvaluationPart ep = id_con.getEvaluationPart();
                    
                    if (ep instanceof IdentifierEvaluationPart) {
                        IdentifierEvaluationPart iep = (IdentifierEvaluationPart)ep;
                        
                        String iep_id = iep.getEvaluationIdentifier();
                        
                        String new_iep_id = counter + iep_id;
                        
                        iep.setEvaluationIdentifier(new_iep_id);
                    }
                }
                
            }
            
        }
    }

    public DesignPatternDescription getContainedDPD() {
        return contained_dpd;
    }

    public void setContainedDPD(DesignPatternDescription contained_dpd) {
        this.contained_dpd = contained_dpd;
    }
    
}
