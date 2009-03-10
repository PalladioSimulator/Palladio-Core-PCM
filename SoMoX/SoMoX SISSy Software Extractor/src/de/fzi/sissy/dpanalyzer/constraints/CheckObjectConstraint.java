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
package de.fzi.sissy.dpanalyzer.constraints;

import java.util.Iterator;

import de.fzi.sissy.dpanalyzer.DesignPatternDescription;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IdentifierConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.IntegerConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.ObjectTypeConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.RoleConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.BooleanConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.interfaces.StringConstraint;
import de.fzi.sissy.dpanalyzer.evaluation.parts.EvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.IdentifierEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.IntegerEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.ObjectTypeEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.RoleEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.BooleanEvaluationPart;
import de.fzi.sissy.dpanalyzer.evaluation.parts.StringEvaluationPart;
import de.fzi.sissy.dpanalyzer.roles.CompositeRole;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.util.Debug;

public abstract class CheckObjectConstraint extends ConstraintImplementation {
    
    protected String check_object_identifier;
    
    protected EvaluationPart evaluation_part;
    
    public CheckObjectConstraint(String check_object_identifier, boolean isTrue) {
        this(check_object_identifier);
        if (this instanceof BooleanConstraint)
            this.evaluation_part = new BooleanEvaluationPart(isTrue, (BooleanConstraint)this);
        else
            Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+BooleanConstraint.class.getName());
    }

    public CheckObjectConstraint(String check_object_identifier, Role evaluation_role) {
        this(check_object_identifier);
        if (this instanceof RoleConstraint)
            this.evaluation_part = new RoleEvaluationPart(evaluation_role, (RoleConstraint)this);
        else
            Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+RoleConstraint.class.getName());
    }

    /*
    public CheckObjectConstraint(String check_object_identifier, CompositeRole composite_role) {
        this(check_object_identifier, composite_role.getContainedDPD().getPrimaryRole());
        if (this instanceof RoleConstraint)
            this.evaluation_part = new RoleEvaluationPart(evaluation_role, (RoleConstraint)this);
        else
            Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+RoleConstraint.class.getName());
    }
    */

    public CheckObjectConstraint(String check_object_identifier, String evaluation_string, boolean isID) {
        this(check_object_identifier);

        if (isID) {
            if (this instanceof IdentifierConstraint)
                this.evaluation_part = new IdentifierEvaluationPart(evaluation_string, (IdentifierConstraint)this);
            else
                Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+IdentifierConstraint.class.getName());
        } else {
            if (this instanceof StringConstraint)
                this.evaluation_part = new StringEvaluationPart(evaluation_string, (StringConstraint)this);
            else
                Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+StringConstraint.class.getName());
            }
    }
    
    public CheckObjectConstraint(String check_object_identifier, java.lang.Class evaluation_class) {
        this(check_object_identifier);
        if (this instanceof ObjectTypeConstraint)
            this.evaluation_part = new ObjectTypeEvaluationPart(evaluation_class, (ObjectTypeConstraint)this);
        else
            Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+ObjectTypeConstraint.class.getName());
    }

    public CheckObjectConstraint(String check_object_identifier, int evaluation_number) {
        this(check_object_identifier);
        if (this instanceof IntegerConstraint)
            this.evaluation_part = new IntegerEvaluationPart(evaluation_number, (IntegerConstraint)this);
        else
            Debug.warning("Constraint "+this.getClass().getName()+" does not implement "+IntegerConstraint.class.getName());
    }

    
    private CheckObjectConstraint(String check_object_identifier) {
        this.check_object_identifier = check_object_identifier;
    }
    
    public boolean check() {
        // get check_object by identifier:
        Object check_object = this.getModelElementByIdentifier(check_object_identifier);
        
        if (check_object==null) {
            Debug.warning("Check-Object was null!");
            return false;
        }
        
        return checkObject(check_object);
        
    }

    protected abstract boolean checkObject(Object check_object);

    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(this.getClass().getSimpleName()+"("+check_object_identifier+", "+stringOfInnerParts()+")");
        
        return sb.toString();
    }
    
    protected String stringOfInnerParts() {
        return this.evaluation_part.toString();
    }

    public EvaluationPart getEvaluationPart() {
        return evaluation_part;
    }

    public void setEvaluationPart(EvaluationPart evaluation_part) {
        this.evaluation_part = evaluation_part;
    }

    
}
