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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

public class DesignPatternInstance {

    private DesignPatternDescription dp_description;
    
    public DesignPatternInstance(DesignPatternDescription dp_description) {
        this.dp_description = dp_description;
        this.roleToMetamodMapping = new HashMap();
    }
    
    // role-to-metamod-object-mapping
    private Map roleToMetamodMapping;
    
/*
    public void addRoleMapping(String role_name, Object metamod_object) {
        
        if (roleToMetamodMapping.get(role_name)==null) {
            roleToMetamodMapping.put(role_name, new LinkedList());
        }
        
        ((LinkedList)roleToMetamodMapping.get(role_name)).add(metamod_object);
    }
*/
    public void addRoleMapping(String role_name, Collection metamod_object_collection) {
        
        if (roleToMetamodMapping.get(role_name)==null) {
            roleToMetamodMapping.put(role_name, new LinkedList());
        }
        
        ((LinkedList)roleToMetamodMapping.get(role_name)).addAll(metamod_object_collection);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator role_itr = dp_description.getVisibleRoles().iterator();

        while(role_itr.hasNext()) {
            Role role = (Role)role_itr.next();
            String role_name = role.getRoleName();
            
            sb.append("Role "+role_name+":");
            sb.append("\n\n");

            if (!roleToMetamodMapping.containsKey(role_name)) {
                Debug.warning("RoleName "+role_name + " was not mapped!");
                continue;
            }
            
            Iterator dpi_itr = ((Collection)roleToMetamodMapping.get(role_name)).iterator();

            while(dpi_itr.hasNext()) {
                Object obj = (Object)dpi_itr.next();
                
                sb.append("   "+MetamodRetrievalEngineImplementation.getSingleton().getFullQualifiedNameOfMetamodObject((ModelElement)obj));
                sb.append("\n\n");
            }
            //sb.append("\n");
        }
        
        return sb.toString();
    }

    public String getDesignPatternName() {
        return dp_description.getDesignPatternName();
    }

    public DesignPatternDescription getDesignPatternDescription() {
        return dp_description;
    }

    public Map getRoleToMetamodMapping() {
        return roleToMetamodMapping;
    }
    
}
