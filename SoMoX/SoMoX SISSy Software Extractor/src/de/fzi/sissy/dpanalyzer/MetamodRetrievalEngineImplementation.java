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
import java.util.Vector;

import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Access;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.FormalParameter;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.NamedModelElement;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.metamod.StatementTreeWalker;
import de.fzi.sissy.metamod.Type;
import de.fzi.sissy.metamod.Variable;

public class MetamodRetrievalEngineImplementation implements MetamodRetrievalEngine {

    private static MetamodRetrievalEngineImplementation singleton;
    private ModelElementRepository metamod_repository;
    
    private MetamodRetrievalEngineImplementation() {
    }
    
    public static MetamodRetrievalEngineImplementation getSingleton() {
        if (singleton==null) {
            singleton = new MetamodRetrievalEngineImplementation();
        }
            return singleton;
    }
   
    public List getClasses() {
       
       List result = new LinkedList();
       
       result.addAll(metamod_repository.getRoot().getClasses());
       
       return result;
   
    }

    public ModelElementRepository getMetamodRepository() {
        return metamod_repository;
    }

    public void setMetamodRepository(ModelElementRepository metamod_repository) {
        this.metamod_repository = metamod_repository;
    }

    public List getMethods() {
        List result = new LinkedList();
        
        List class_list = getClasses();
        
        Iterator class_itr = class_list.iterator();
        
        while (class_itr.hasNext()) {
            Class classobj = (Class) class_itr.next();
            
            result.addAll(classobj.getMethods());
        }
        
        return result;
    }

    
    
    public boolean classIsAbstract(Class class_obj, boolean isTrue) {
        if (isTrue) 
            return class_obj.isAbstract();
        else
            return !class_obj.isAbstract();
    }

    public boolean classIsInterface(Class class_obj, boolean isTrue) {
        if (isTrue) 
            return class_obj.isInterface();
        else
            return !class_obj.isInterface();
    }

    public boolean classContainsMethod(Class class_obj, Method contained_method_obj) {
        return getContainedMethodsOfClass(class_obj).contains(contained_method_obj);
    }

    public Collection getContainedMethodsOfClass(Class class_obj) {
        return class_obj.getMethods();
    }
    
    public boolean classHasSubclass(Class class_obj, Class sub_class_obj) {
        return getSubclassesOfClass(class_obj).contains(sub_class_obj);
    }

    public Collection getSubclassesOfClass(Class class_obj) {
        return class_obj.getAllDescendants();
    }

    public boolean classHasSuperclass(Class class_obj, Class super_class_obj) {
        return getSuperclassesOfClass(class_obj).contains(super_class_obj);
    }

    public Collection getSuperclassesOfClass(Class class_obj) {
        // TODO Superclass-Retrieval OKAY ????
        return class_obj.getAllAncestors(true);
    }

    public Collection getContainedConstructorsOfClass(Class class_obj) {
        return class_obj.getConstructors();
    }

    public boolean classContainsConstructor(Class class_obj, Constructor constructor) {
        return getContainedConstructorsOfClass(class_obj).contains(constructor);
    }

    
    
    
    public boolean methodIsAbstract(Method method_obj, boolean isTrue) {
        if (isTrue) 
            return method_obj.isAbstract();
        else
            return !method_obj.isAbstract();
    }

    public boolean methodContainsFormalParameter(Method method_obj, FormalParameter contained_formalparameter_obj) {
        return getFormalParametersOfMethod(method_obj).contains(contained_formalparameter_obj);
    }

    public Collection getFormalParametersOfMethod(Method method_obj) {
        return method_obj.getFormalParameters();
    }

    public boolean methodContainsFunctionAccess(Method method_obj, FunctionAccess contained_functionaccess_obj) {
        return getContainedFunctionAccessesOfMethod(method_obj).contains(contained_functionaccess_obj);
    }

    public Collection getContainedFunctionAccessesOfMethod(Method method_obj) {
        // this function gets all contained functionaccesses 
        // in statement-tree of method
        return method_obj.getFunctionAccesses();
    }

    public boolean methodContainsStatement(Method method_obj, Statement contained_statement_obj) {
        return getContainedStatementsOfMethod(method_obj).contains(contained_statement_obj);
    }

    public Collection getContainedStatementsOfMethod(Method method_obj) {
        Collection result = new Vector();

        Statement body = method_obj.getBody();

        if (body == null)
            return result;
        
        StatementTreeWalker walker = new StatementTreeWalker(body);
        
        do {
           Statement stm = walker.getStatement();
           
           result.add(stm);
        } while(walker.next());
        
        return result;
    }

    public boolean methodHasNumberOfFormalParameters(Method method_obj, int number_of_formalparameters) {
        return getFormalParametersOfMethod(method_obj).size()==number_of_formalparameters;
    }

    public boolean methodIsReferencedByFunction(Method method_obj, Function referencing_function_obj) {
        return getReferencingFunctionsOfMethod(method_obj).contains(referencing_function_obj);
    }

    public Collection getReferencingFunctionsOfMethod(Method method_obj) {
        return method_obj.referencingFunctions();
    }

    public Object getReturnTypeOfMethod(Method method) {
        return method.getReturnType();
    }

    public boolean methodIsContainedInClass(Method method, Class class1) {
        if (class1 == null)
            return false;
        
        if (method.getSurroundingClass()==class1)
            return true;
        
        return false;
    }

    public boolean methodIsStatic(Method method, boolean isTrue) {
        if (isTrue)
            return method.isStatic();
        else
            return !method.isStatic();
    }

    public int numberOfStatements(Method method) {
        return method.getNumberOfStatements();
    }

    public String nameOfMethod(Method method) {
        return method.getSimpleName();
    }

    public boolean methodHasReturnType(Method method, boolean isTrue) {
        if (method.getReturnType()==null)
            return false;
        
        if (isTrue)
            return !method.getReturnType().getSimpleName().equals("void");
        else
            return method.getReturnType().getSimpleName().equals("void");
    }

    public boolean methodHasBooleanReturnType(Method method, boolean isTrue) {
        
        boolean hasReturnType = methodHasReturnType(method, true);
        
        if (!hasReturnType && isTrue) {
            return false;
        }
        
        boolean result = false;
        if (hasReturnType) {
            result = method.getReturnType().getSimpleName().equals("boolean");
        } else {
            result = false;
        }
        
        if (isTrue)
            return result;
        else
            return !result;
        
    }

    public boolean methodHasMaxNumberOfFormalParameters(Method method, int number) {
        return getFormalParametersOfMethod(method).size()<=number;
    }

    public boolean methodHasMinNumberOfFormalParameters(Method method, int number) {
        return getFormalParametersOfMethod(method).size()>=number;
    }

    public Collection getContainerClassOfMethod(Method method) {
        Vector result = new Vector();
        result.add(method.getSurroundingClass());
        return result;
    }

    public Object getContainerClassOfConstructor(Constructor constructor) {
        return constructor.getSurroundingClass();
    }


    
    
    public boolean formalParameterIsOfType(FormalParameter formalparameter_obj, Type type_of_formalparameter_obj) {
        if (formalparameter_obj.getType()==null)
            return false;
        
        return formalparameter_obj.getType()==type_of_formalparameter_obj;
    }

    public Collection getTypesOfFormalParameter(FormalParameter parameter) {
        Collection result = new Vector();
        
        if (parameter.getType()!=null)
            result.add(parameter.getType());
        
        return result;
    }

    
    
    
    public boolean functionAccessHasFunctionTarget(FunctionAccess functionaccess_obj, Function target_function_obj) {
        Function target_function_real = functionaccess_obj.getAccessedFunction();
        
        if (target_function_real==null)
            return false;
        
        return target_function_real==target_function_obj;
    }

    public boolean functionAccessTargetIsAbstract(FunctionAccess functionaccess_obj, boolean isTrue) {
        Function target_function_real = functionaccess_obj.getAccessedFunction();
        
        if (target_function_real==null)
            return false;
        
        if (target_function_real instanceof Method) {
            return methodIsAbstract((Method)target_function_real, isTrue);
        } else {
            return false;
        }
    }

    public boolean functionAccessTargetIsInClassConstraint(FunctionAccess functionaccess_obj, Class container_class_obj) {
        Function target_function_real = functionaccess_obj.getAccessedFunction();

        if (target_function_real==null) {
            System.out.println("functionAccessTargetIsInClassConstraint(): target function null");
            return false;
        }
        
        if (target_function_real instanceof Method) {
            boolean result = classContainsMethod(container_class_obj, (Method)target_function_real);
            return result;
        } else if (target_function_real instanceof Constructor) {
            boolean result = classContainsConstructor(container_class_obj, (Constructor)target_function_real);
            return result;
        } else {
            System.out.println("functionAccessTargetIsInClassConstraint(): target function not method");
            return false;
        }
    }

    public Collection getFunctionTargetsOfFunctionAccess(FunctionAccess access) {
        Collection result = new Vector();
        
        if (access.getAccessedFunction()!=null)
            result.add(access.getAccessedFunction());
        
        return result;
    }

    public Collection getSurroundingClassesOfFunctionAccessTarget(FunctionAccess access) {
        Collection result = new Vector();
        
        if ((access.getAccessedFunction()!=null)&&(access.getAccessedFunction() instanceof Member)) {
            Member member_function = (Member)access.getAccessedFunction();
            
            if (member_function.getSurroundingClass()!=null) {
                result.add(member_function.getSurroundingClass());
            } else {
                System.out.println("getSurroundingClassesOfFunctionAccessTarget(): surrounding class of accessed function was null.");
            }
            
        } else {
           System.out.println("getSurroundingClassesOfFunctionAccessTarget(): accessed function was null or not member");
        }
        
        return result;
    }

    
    
    
    public boolean statementContainsFunctionAccess(Statement statement_obj, FunctionAccess contained_functionaccess_obj) {
        return getContainedFunctionAccessesOfStatement(statement_obj).contains(contained_functionaccess_obj);
    }

    public Collection getContainedFunctionAccessesOfStatement(Statement statement_obj) {
        Collection result = new Vector();
        
        StatementTreeWalker walker = new StatementTreeWalker(statement_obj);
        
        do {
            Statement stm = walker.getStatement();
            
            Collection accesses = stm.getAccesses();

            Iterator itr = accesses.iterator();
            
            while(itr.hasNext()) {
                Access access = (Access)itr.next();
                
                if (access instanceof FunctionAccess) {
                    result.add(access);
                }
            }
            
        } while (walker.next());
        
        return result;
    }

    public boolean statementIsOfType(Statement statement_obj, java.lang.Class statement_class) {
        // TODO Implement Nicer Without General Class-Object
        return statement_obj.getClass()==statement_class;
    }

    
    
        
    public String getFullQualifiedNameOfMetamodObject(ModelElement obj) {

        if (obj instanceof ModelElement) {
            return calculateFullQualifiedName(obj);
        } else {
            return obj.toString();
        }
    }

    public static String calculateFullQualifiedName(ModelElement nme) {
        String fqn = "";

        if (nme==null)
            return fqn;
        
        if (nme instanceof Package) {
            return ((Package)nme).getQualifiedName();
        } else if (nme instanceof Class){
            return ((Class)nme).getQualifiedName();
        } else if (nme instanceof Method) {
            Method method = (Method)nme;
            
            Iterator itr = method.getFormalParameters().iterator();
            
            String fp_text = "";
            while (itr.hasNext()) {
                FormalParameter fp = (FormalParameter)itr.next();
                fp_text = fp_text + fp.getType().getQualifiedName(); 
                if (itr.hasNext())
                    fp_text = fp_text + ",";
            }
            
            return calculateFullQualifiedName(((Method)nme).getSurroundingClass()) + "." + ((Method)nme).getSimpleName()  + "(" + fp_text + ")";
        } else if (nme instanceof Constructor) {
            Constructor constr = (Constructor)nme;
            
            Iterator itr = constr.getFormalParameters().iterator();
            
            String fp_text = "";
            while (itr.hasNext()) {
                FormalParameter fp = (FormalParameter)itr.next();
                fp_text = fp_text + fp.getType().getQualifiedName(); 
                if (itr.hasNext())
                    fp_text = fp_text + ",";
            }
            
            return calculateFullQualifiedName(((Constructor)nme).getSurroundingClass()) + "." + ((Constructor)nme).getSimpleName()  + "(" + fp_text + ")";
        } else if (nme instanceof Field) {
            return calculateFullQualifiedName(((Field)nme).getSurroundingClass()) + "." + ((Field)nme).getSimpleName();
        } else if (nme instanceof Access) {
            Access access = (Access)nme;
            return "target: "+calculateFullQualifiedName(access.getAccessedTarget());
        } else if (nme instanceof NamedModelElement) {
            return ((NamedModelElement)nme).getSimpleName();
        }
        
        return nme.toString();
    }

    public static boolean typesAreFitting(Type type1, Type type2) {
        if ((type1 instanceof Class)&&(type2 instanceof Class))
            return (((Class)type1).getAllSuperTypes().contains(type2) || ((Class)type2).getAllSuperTypes().contains(type1) || type1==type2);
        else
            return false;
        
        // TODO Implement Correct Handling of Array-ReturnType!!!   
    }

    public boolean methodsAreContainedInSameClass(Method method, Method method2) {
        Class  class1 = method.getSurroundingClass();
        Class  class2 = method2.getSurroundingClass();
        
        if (class1.isSubTypeOf(class2)||class2.isSubTypeOf(class1)||class1==class2) {
            return true;
        }
        
        return false;
    }

    public boolean methodFormalParametersAreMatching(Method method, Method method2) {
        if (method.getFormalParameters().size() != method2.getFormalParameters().size()) {
            return false;
        }

        boolean matching = true;
        for (int i=0; i<method.getFormalParameters().size(); i++) {
            
            FormalParameter fp1 = (FormalParameter) method.getFormalParameters().get(i);
            FormalParameter fp2 = (FormalParameter) method2.getFormalParameters().get(i);
            
            if (fp1.getType() != fp2.getType()) {
                matching = false;
                break;
            }
        }
            
        return matching;
    }

}
