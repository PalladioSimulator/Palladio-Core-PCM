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
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.DesignPatternDescription;
import de.fzi.sissy.dpanalyzer.DesignPatternRetrievalProcess;
import de.fzi.sissy.dpanalyzer.MetamodRetrievalEngineImplementation;
import de.fzi.sissy.dpanalyzer.constraints.CheckObjectConstraint;
import de.fzi.sissy.dpanalyzer.constraints.Constraint;
import de.fzi.sissy.dpanalyzer.constraints.formalparameter.FormalParameterConstraint;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.NamedModelElement;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.SourceEntity;
import de.fzi.sissy.util.Debug;

public abstract class Role {
    
    protected DesignPatternDescription dp_description;
    
    protected String role_name;
    protected String identifier;
    protected List constraints;
    
    private static int ident_level=0;
    
    public static void increaseIdentLevel() {
        ident_level++;
    }

    public static void decreaseIdentLevel() {
        ident_level--;
    }

    public Role(String role_name, String identifier, DesignPatternDescription dp_description) {
        this.role_name = role_name;
        this.identifier = identifier;
        this.dp_description = dp_description;
        this.constraints = new  LinkedList();
    }
    
    public Collection evaluate(Collection candidate_list) {
        
        increaseIdentLevel();
        
        Vector result = new Vector();
        result.addAll(candidate_list);
        
        printStart(result.size());

        Iterator constraint_itr = constraints.iterator();
        
        while ((!result.isEmpty())&&constraint_itr.hasNext()) {
            
            Constraint constraint  = (Constraint) constraint_itr.next();
            
            System.out.println(getEmptyString(ident_level*3+2)+"CheckObjectConstraint: "+ constraint.getShortString());

            Vector neu_result = (Vector)result.clone();
            
            Iterator candidateelement_itr = result.iterator();
            
            candidate_loop:
            while (candidateelement_itr.hasNext()) {
                Object candidate_element  = candidateelement_itr.next();
                
                
                
                this.getDesignPatternDescription().mapIdentifierToRoleCandidate(this.identifier, candidate_element);
                
                System.out.println(getEmptyString(ident_level*3+4)+"Check Candidate: \""+MetamodRetrievalEngineImplementation.getSingleton().getFullQualifiedNameOfMetamodObject((ModelElement)candidate_element)+"\"");
                //this.setCurrentCandidate(candidate_element);
                if (!constraint.check()) {
                    /*
                    if (candidate_element instanceof NamedModelElement)
                        System.out.println(getEmptyString(ident_level*3+4)+"Candidate: "+ ((NamedModelElement)candidate_element).getSimpleName()+ " does NOT keep constraint: "+ constraint.getShortString());
                    else
                        System.out.println(getEmptyString(ident_level*3+4)+"Candidate: "+ candidate_element.getClass().getName()+ " does NOT keep constraint: "+ constraint.getShortString());
                    */
                    neu_result.remove(candidate_element);
                } else {
                    if (candidate_element instanceof NamedModelElement)
                        System.out.println(getEmptyString(ident_level*3+6)+"Candidate: \""+ ((NamedModelElement)candidate_element).getSimpleName()+ "\" KEEPS constraint: "+ constraint.getShortString());
                    else
                        System.out.println(getEmptyString(ident_level*3+6)+"Candidate: "+MetamodRetrievalEngineImplementation.getSingleton().getFullQualifiedNameOfMetamodObject((ModelElement)candidate_element)+"\" KEEPS constraint: "+ constraint.getShortString());
                }
                
                this.getDesignPatternDescription().unmapIdentifier(this.identifier);
            
            }
            
            result = neu_result;
            //printLeft(result.size());

        }
        
        printEnd(result.size());

        if (!result.isEmpty()) {
            // insert role-mapping in dp-instance
            DesignPatternRetrievalProcess.getSingleton().getCurrentDesignPatternInstance().addRoleMapping(this.role_name, result);
        }
        
        decreaseIdentLevel();

        return result;
    }

    public void addConstraint(Constraint constraint) {
        constraints.add(constraint);
        constraint.setDesignPatternDescription(this.getDesignPatternDescription());
    }

    public void setDesignPatternDescription(DesignPatternDescription dp_description) {
        this.dp_description = dp_description;
    }

    public DesignPatternDescription getDesignPatternDescription() {
        return this.dp_description;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(this.toSmallString());
        sb.append("\n"); 
        
        Iterator constraint_itr = constraints.iterator();
        
        while (constraint_itr.hasNext()) {
            Constraint constraint  = (Constraint) constraint_itr.next();
            
            sb.append("--> "+constraint.toString());
            sb.append("\n"); 
        }

        sb.append("\n"); 
        sb.append("\n"); 
        
        return sb.toString();
    }

    public String toSmallString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(this.getClass().getSimpleName()+"("+this.role_name+")");

        if (this.identifier != null)
            sb.append(":"+this.identifier);

        return sb.toString();
    }

    protected void printStart(int number) {
        System.out.println(getEmptyString(ident_level*3)+"Start Evaluating "+this.getClass().getSimpleName()+"("+role_name+"): Candidates: "+number);
    }

    protected void printLeft(int number) {
        System.out.println(getEmptyString(ident_level*3)+"Evaluating "+this.getClass().getSimpleName()+"("+role_name+"): Left Candidates: "+number);
    }

    protected void printEnd(int number) {
        System.out.println(getEmptyString(ident_level*3)+"Stop Evaluating "+this.getClass().getSimpleName()+"("+role_name+"): Result-Objects: "+ number);
    }
    
    public static String getEmptyString(int length){
        
        StringBuffer sb = new StringBuffer();
        
        for (int i=1; i<=length; i++) {
            sb.append(" ");
        }
        
        return sb.toString();
        
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String role_name) {
        this.role_name = role_name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List getConstraints() {
        return constraints;
    }

    public void setConstraints(List constraints) {
        this.constraints = constraints;
    }

}
