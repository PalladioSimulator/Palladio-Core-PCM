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
package de.fzi.sissy.dpanalyzer;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.fzi.sissy.dpanalyzer.roles.ClassRole;
import de.fzi.sissy.dpanalyzer.roles.MethodRole;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

public class DesignPatternRetrievalProcess {

    private static DesignPatternRetrievalProcess singleton;
    
    private DesignPatternRetrievalProcess() {
    }
    
    public static DesignPatternRetrievalProcess getSingleton() {
        if (singleton==null) {
            singleton = new DesignPatternRetrievalProcess();
        }
            return singleton;
    }
    
    private DesignPatternDescription dp_description;
    
    private DesignPatternInstance current_dp_instance;
    
    private Collection dp_instances;

    public void setup(DesignPatternDescription dp_description) {
        this.dp_description = dp_description;
        this.dp_instances = new LinkedList(); 
    }
    
    public void start() {

        /*
        Iterator itr = this.dp_description.getPrimaryRoleList().iterator();
        
        while(itr.hasNext()) {
        */
            Role primary_role = this.dp_description.getPrimaryRole();
            
            List all_list = null;
            
            // get type of role
            if (primary_role instanceof ClassRole) {
                all_list = MetamodRetrievalEngineImplementation.getSingleton().getClasses();
            } else if (primary_role instanceof MethodRole) {
                all_list = MetamodRetrievalEngineImplementation.getSingleton().getMethods();
            } else {
                //continue;
                Debug.info("No usable primary role type!" + primary_role.getClass());
                return;
            }
            
            Iterator cand_itr = all_list.iterator();
            Debug.info("Primary Role Elements to test: "+all_list.size());
            
            while(cand_itr.hasNext()) {
                ModelElement candidate_model_element = (ModelElement)cand_itr.next();
                
                int candidates_left = all_list.size() - all_list.indexOf(candidate_model_element);
                System.out.println(dp_description.getDesignPatternName() + ": Primary Candidates Left: "+candidates_left);
                
                Collection candidates = new LinkedList();
                
                candidates.add(candidate_model_element);
                
                // create new dp_instance
                this.current_dp_instance = new DesignPatternInstance(dp_description);

                // start evaluation of role-constraint-tree for current candidate
                Collection result = primary_role.evaluate(candidates);
                
                if (!result.isEmpty()) {
                    // if we get a result ==> dp_instance properly found ==> add to result 
                    this.dp_instances.add(this.current_dp_instance);
                }
            }

            // } primary-role-loop
        
        
    }
    
    public Collection getResultDPInstances() {
        return this.dp_instances;
    }

    public DesignPatternInstance getCurrentDesignPatternInstance() {
        return current_dp_instance;
    }

}
