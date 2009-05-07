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
import java.util.List;
import java.util.Vector;

import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.FormalParameter;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;

public interface MetamodRetrievalEngine {

    public List getClasses();
    public List getMethods();
    
    public boolean classIsAbstract(de.fzi.sissy.metamod.Class class_obj, boolean isTrue);
    public boolean classIsInterface(de.fzi.sissy.metamod.Class class_obj, boolean isTrue);
    public boolean classContainsMethod(de.fzi.sissy.metamod.Class class_obj, de.fzi.sissy.metamod.Method contained_method_obj);
    public Collection getContainedMethodsOfClass(de.fzi.sissy.metamod.Class class_obj);
    public boolean classHasSubclass(de.fzi.sissy.metamod.Class class_obj, de.fzi.sissy.metamod.Class sub_class_obj);
    public Collection getSubclassesOfClass(de.fzi.sissy.metamod.Class class_obj);
    public boolean classHasSuperclass(de.fzi.sissy.metamod.Class class_obj, de.fzi.sissy.metamod.Class super_class_obj);
    public Collection getSuperclassesOfClass(de.fzi.sissy.metamod.Class class_obj);
    public Collection getContainedConstructorsOfClass(Class class_obj);
    public boolean classContainsConstructor(Class class_obj, Constructor constructor);
    
    public boolean methodIsAbstract(de.fzi.sissy.metamod.Method method_obj, boolean isTrue);
    public boolean methodContainsFormalParameter(de.fzi.sissy.metamod.Method method_obj, de.fzi.sissy.metamod.FormalParameter contained_formalparameter_obj);
    public Collection getFormalParametersOfMethod(de.fzi.sissy.metamod.Method method_obj);
    public boolean methodContainsFunctionAccess(de.fzi.sissy.metamod.Method method_obj, de.fzi.sissy.metamod.FunctionAccess contained_functionaccess_obj);
    public Collection getContainedFunctionAccessesOfMethod(de.fzi.sissy.metamod.Method method_obj);
    public boolean methodContainsStatement(de.fzi.sissy.metamod.Method method_obj, de.fzi.sissy.metamod.Statement contained_statement_obj);
    public Collection getContainedStatementsOfMethod(de.fzi.sissy.metamod.Method method_obj);
    public boolean methodHasNumberOfFormalParameters(de.fzi.sissy.metamod.Method method_obj, int number_of_formalparameters);
    public boolean methodIsReferencedByFunction(de.fzi.sissy.metamod.Method method_obj, de.fzi.sissy.metamod.Function referencing_function_obj);
    public Collection getReferencingFunctionsOfMethod(de.fzi.sissy.metamod.Method method_obj);
    public Object getReturnTypeOfMethod(Method method);
    public boolean methodIsContainedInClass(Method method, Class class1);
    public boolean methodIsStatic(Method method, boolean isTrue);
    public int numberOfStatements(Method method);
    public String nameOfMethod(Method method);
    public boolean methodHasReturnType(Method method, boolean isTrue);
    public boolean methodHasBooleanReturnType(Method method, boolean isTrue);
    public boolean methodHasMaxNumberOfFormalParameters(Method method, int number);
    public Collection getContainerClassOfMethod(Method method);

    public Object getContainerClassOfConstructor(Constructor constructor);

    
    public boolean formalParameterIsOfType(de.fzi.sissy.metamod.FormalParameter formalparameter_obj, de.fzi.sissy.metamod.Type type_of_formalparameter_obj);
    
    public boolean functionAccessHasFunctionTarget(de.fzi.sissy.metamod.FunctionAccess functionaccess_obj, de.fzi.sissy.metamod.Function target_function_obj);
    public boolean functionAccessTargetIsAbstract(de.fzi.sissy.metamod.FunctionAccess functionaccess_obj, boolean isTrue);
    public boolean functionAccessTargetIsInClassConstraint(de.fzi.sissy.metamod.FunctionAccess functionaccess_obj, de.fzi.sissy.metamod.Class container_class_obj);

    public boolean statementContainsFunctionAccess(de.fzi.sissy.metamod.Statement statement_obj, de.fzi.sissy.metamod.FunctionAccess contained_functionaccess_obj);
    public Collection getContainedFunctionAccessesOfStatement(de.fzi.sissy.metamod.Statement statement_obj);
    public boolean statementIsOfType(de.fzi.sissy.metamod.Statement statement_obj, java.lang.Class statement_class);
    
    public Collection getTypesOfFormalParameter(FormalParameter parameter);
    public Collection getFunctionTargetsOfFunctionAccess(FunctionAccess access);
    public Collection getSurroundingClassesOfFunctionAccessTarget(FunctionAccess access);

    public String getFullQualifiedNameOfMetamodObject(ModelElement obj);
}
