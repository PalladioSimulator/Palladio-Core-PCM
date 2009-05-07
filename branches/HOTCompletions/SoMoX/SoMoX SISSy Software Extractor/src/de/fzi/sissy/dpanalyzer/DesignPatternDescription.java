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
import java.util.List;
import java.util.Map;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.ModelElement;

public class DesignPatternDescription {

   private Map identifierToRoleMapping; 
   private String design_pattern_name;
   private Role primary_role;
   private Collection role_collection;
   private Collection visible_role_collection;
   private Collection id_constraint_collection;
   
   public DesignPatternDescription(String design_pattern_name) {
       this.design_pattern_name = design_pattern_name;
       this.identifierToRoleMapping = new HashMap();
       this.primary_role = null;
       this.role_collection = new Vector();
       this.visible_role_collection = new Vector();
       this.id_constraint_collection = new Vector();
   }

   public void addRole(Role role, boolean isVisible) {
       this.role_collection.add(role);
      
       this.id_constraint_collection.addAll(role.getConstraints());
       
       if (isVisible)
           this.visible_role_collection.add(role);
   }

   public Collection getRoles() {
       return this.role_collection;
   }

   public Collection getVisibleRoles() {
       return this.visible_role_collection;
   }

   public void setPrimaryRole(Role role) {
       this.primary_role = role;
   }
   
   public Role getPrimaryRole() {
       return primary_role;
   }
   
   public String getDesignPatternName() {
       return design_pattern_name;
   }

   public void setDesignPatternName(String design_pattern_name) {
       this.design_pattern_name = design_pattern_name;
   }
   
   public String toString() {
       StringBuffer sb = new StringBuffer();
       
       sb.append(this.design_pattern_name+ "-DESCRIPTION: \n\n");
       
       Iterator itr = this.role_collection.iterator();
       
       while(itr.hasNext()) {
           Role role = (Role)itr.next();
           sb.append(role.toString());
       }
       
       sb.append("\n");
       
       return sb.toString();
   }
   
   
   public void mapIdentifierToRoleCandidate(String identifier, Object model_element) {
       if (identifier==null) {
           return;
       }
       if (model_element==null) {
           return;
       }
       // überschreibt altes mapping, falls vorhanden:
       if (identifierToRoleMapping.containsKey(identifier))
           identifierToRoleMapping.remove(identifier);
       
       this.identifierToRoleMapping.put(identifier, model_element);
   }

   public void unmapIdentifier(String identifier) {
       if (identifier==null) {
           return;
       }
       
       if (identifierToRoleMapping.containsKey(identifier))
           identifierToRoleMapping.remove(identifier);
   }

   public ModelElement getRoleCandidateByIdentifier(String identifier) {
       if (identifier==null) {
           return null;
       }
       
       if (identifierToRoleMapping.containsKey(identifier))
           return (ModelElement)identifierToRoleMapping.get(identifier);
       
       return null;
   }

   private Map getIdentifierToRoleMapping() {
       return identifierToRoleMapping;
   }
	
   private void setIdentifierToRoleMapping(Map identifierToRoleMapping) {
       this.identifierToRoleMapping = identifierToRoleMapping;
   }

}
