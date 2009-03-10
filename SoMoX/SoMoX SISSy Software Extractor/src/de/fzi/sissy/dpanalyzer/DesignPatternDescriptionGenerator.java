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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import de.fzi.sissy.dpanalyzer.constraints.*;
import de.fzi.sissy.dpanalyzer.constraints.classes.ClassIsAbstractConstraint;
import de.fzi.sissy.dpanalyzer.constraints.classes.ClassHasSubclassConstraint;
import de.fzi.sissy.dpanalyzer.constraints.classes.ClassIsInterfaceConstraint;
import de.fzi.sissy.dpanalyzer.constraints.classes.ClassContainsMethodConstraint;
import de.fzi.sissy.dpanalyzer.constraints.constructor.ConstructorClassTypeEqualsReturnTypeOfMethodConstraint;
import de.fzi.sissy.dpanalyzer.constraints.constructor.ConstructorClassTypeFitsToReturnTypeOfMethodConstraint;
import de.fzi.sissy.dpanalyzer.constraints.formalparameter.FormalParameterIsOfTypeConstraint;
import de.fzi.sissy.dpanalyzer.constraints.functionaccess.FunctionAccessHasFunctionTargetConstraint;
import de.fzi.sissy.dpanalyzer.constraints.functionaccess.FunctionAccessTargetIsAbstractConstraint;
import de.fzi.sissy.dpanalyzer.constraints.functionaccess.FunctionAccessTargetIsInClassConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodFormalParametersAreMatching;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasBooleanReturnTypeConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasMaxNumberOfFormalParametersConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasMaxNumberOfStatementsConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasMinNumberOfFormalParameters;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasMinNumberOfStatements;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasReturnTypeConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodIsAbstractConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodContainsFormalParameterConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodContainsFunctionAccessConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodIsContainedInClassConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodIsContainedInSameClassAsMethod;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodIsReferencedByFunctionConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodHasNumberOfFormalParametersConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodContainsStatementConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodIsStaticConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodNameStartsWithConstraint;
import de.fzi.sissy.dpanalyzer.constraints.method.MethodReturnTypeFitsToReturnTypeOfMethodConstraint;
import de.fzi.sissy.dpanalyzer.constraints.statement.StatementContainsFunctionAccessConstraint;
import de.fzi.sissy.dpanalyzer.constraints.statement.StatementIsOfTypeConstraint;
import de.fzi.sissy.dpanalyzer.roles.*;
import de.fzi.sissy.metamod.LoopStatement;

public class DesignPatternDescriptionGenerator {

    private List design_pattern_description_list;
    private Map dpd_map;
    
    private static DesignPatternDescriptionGenerator singleton;
    
    private DesignPatternDescriptionGenerator() {
        design_pattern_description_list = new LinkedList();
        dpd_map = new HashMap();
    }
    
    public static DesignPatternDescriptionGenerator getSingleton() {
        if (singleton==null) {
            singleton = new DesignPatternDescriptionGenerator();
        }
            return singleton;
    }

    public void buildDesignPatternDescriptions() {

        buildGetMethod();

        buildSetMethod();

        buildAddMethod();

        buildIsMethod();

        buildFactoryMethod();
        
        buildStaticFactoryMethod();
        
        buildDelegationMethod();

        buildCreateMethod();
        
        /*
        buildFactoryMethod2();
        
        buildTemplate();
        
        buildVisitor();
        
        buildObserver();
        */
        
        
        /*
        buildFacade();
        
        buildProxy();
        */
        
        
    }

    private void buildGetMethod() {
        // GET METHOD:
        
        DesignPatternDescription dpd_get = new DesignPatternDescription("GET METHOD");
        
        MethodRole primary_role = new MethodRole("get method", "A", dpd_get);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodHasReturnTypeConstraint(primary_role.getIdentifier(), true));
        primary_role.addConstraint(new MethodNameStartsWithConstraint(primary_role.getIdentifier(), "get"));
        primary_role.addConstraint(new MethodHasNumberOfFormalParametersConstraint(primary_role.getIdentifier(), 0));
        
        dpd_get.addRole(primary_role, true);
        dpd_get.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_get);
        this.dpd_map.put(dpd_get.getDesignPatternName(), dpd_get);
    }

    private void buildSetMethod() {
        // SET METHOD:
        
        DesignPatternDescription dpd_set = new DesignPatternDescription("SET METHOD");
        
        MethodRole primary_role = new MethodRole("set method", "A", dpd_set);

        //primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        //primary_role.addConstraint(new MethodHasMinNumberOfStatements(primary_role.getIdentifier(), 6));
        primary_role.addConstraint(new MethodHasReturnTypeConstraint(primary_role.getIdentifier(), false));
        primary_role.addConstraint(new MethodNameStartsWithConstraint(primary_role.getIdentifier(), "set"));
        primary_role.addConstraint(new MethodHasMinNumberOfFormalParameters(primary_role.getIdentifier(), 1));
        
        dpd_set.addRole(primary_role, true);
        dpd_set.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_set);
        this.dpd_map.put(dpd_set.getDesignPatternName(), dpd_set);
    }

    private void buildAddMethod() {
        // ADD METHOD:
        
        DesignPatternDescription dpd_add = new DesignPatternDescription("ADD METHOD");
        
        MethodRole primary_role = new MethodRole("add method", "A", dpd_add);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodHasReturnTypeConstraint(primary_role.getIdentifier(), false));
        primary_role.addConstraint(new MethodNameStartsWithConstraint(primary_role.getIdentifier(), "add"));
        primary_role.addConstraint(new MethodHasNumberOfFormalParametersConstraint(primary_role.getIdentifier(), 1));
        
        dpd_add.addRole(primary_role, true);
        dpd_add.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_add);
        this.dpd_map.put(dpd_add.getDesignPatternName(), dpd_add);
    }

    private void buildIsMethod() {
        // IS METHOD:
        
        DesignPatternDescription dpd_is = new DesignPatternDescription("IS METHOD");
        
        MethodRole primary_role = new MethodRole("is method", "A", dpd_is);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodHasBooleanReturnTypeConstraint(primary_role.getIdentifier(), true));
        primary_role.addConstraint(new MethodNameStartsWithConstraint(primary_role.getIdentifier(), "is"));
        primary_role.addConstraint(new MethodHasMaxNumberOfFormalParametersConstraint(primary_role.getIdentifier(), 1));
        
        dpd_is.addRole(primary_role, true);
        dpd_is.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_is);
        this.dpd_map.put(dpd_is.getDesignPatternName(), dpd_is);
    }

    private void buildFactoryMethod() {
        // STATIC FACTORY METHOD:
        
        DesignPatternDescription dpd_factorymethod = new DesignPatternDescription("FACTORY METHOD");
        
        MethodRole primary_role = new MethodRole("factory method", "A", dpd_factorymethod);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("constructor access", "B", dpd_factorymethod);
        ConstructorRole constructor_role = new ConstructorRole("constructor", "C", dpd_factorymethod);

        // abstract
        primary_role.addConstraint(new MethodIsAbstractConstraint(primary_role.getIdentifier(), false));
        // static
        //primary_role.addConstraint(new MethodIsStaticConstraint(primary_role.getIdentifier(), true));
        // contains fa to constructor
        primary_role.addConstraint(new MethodNameStartsWithConstraint(primary_role.getIdentifier(), "create"));
        primary_role.addConstraint(new MethodHasReturnTypeConstraint(primary_role.getIdentifier(), true));
        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), constructor_role));
        constructor_role.addConstraint(new ConstructorClassTypeFitsToReturnTypeOfMethodConstraint(constructor_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_factorymethod.addRole(primary_role, true);
        dpd_factorymethod.addRole(functionaccess_role, false);
        dpd_factorymethod.addRole(constructor_role, false);
        dpd_factorymethod.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_factorymethod);
        this.dpd_map.put(dpd_factorymethod.getDesignPatternName(), dpd_factorymethod);
        
    }

    private void buildCreateMethod() {
        // CREATE METHOD:
        
        DesignPatternDescription dpd_create = new DesignPatternDescription("CREATE METHOD");
        
        MethodRole primary_role = new MethodRole("create method", "A", dpd_create);
        //FunctionAccessRole functionaccess_role = new FunctionAccessRole("constructor access", "B", dpd_create);
        //ConstructorRole constructor_role = new ConstructorRole("constructor", "C", dpd_create);

        //primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodHasReturnTypeConstraint(primary_role.getIdentifier(), true));
        primary_role.addConstraint(new MethodNameStartsWithConstraint(primary_role.getIdentifier(), "create"));
        //primary_role.addConstraint(new MethodHasMaxNumberOfFormalParametersConstraint(primary_role.getIdentifier(), 1));
        //primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        //functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), constructor_role));
        //constructor_role.addConstraint(new ConstructorClassTypeFitsToReturnTypeOfMethodConstraint(constructor_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_create.addRole(primary_role, true);
        //dpd_create.addRole(functionaccess_role, false);
        //dpd_create.addRole(constructor_role, false);
        dpd_create.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_create);
        this.dpd_map.put(dpd_create.getDesignPatternName(), dpd_create);
    }

    



    
    private void buildDelegationMethod() {
        // DELEGATION METHOD:
        
        DesignPatternDescription dpd_delegation = new DesignPatternDescription("DELEGATION METHOD");
        
        MethodRole primary_role = new MethodRole("delegation method", "A", dpd_delegation);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("delegate access", "B", dpd_delegation);
        MethodRole accessed_method_role = new MethodRole("accessed method", "C", dpd_delegation);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 3));
        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), accessed_method_role));
        accessed_method_role.addConstraint(new MethodReturnTypeFitsToReturnTypeOfMethodConstraint(accessed_method_role.getIdentifier(), primary_role.getIdentifier()));
        // accessed method not in same class
        accessed_method_role.addConstraint(new NOTConstraint(new MethodIsContainedInSameClassAsMethod(accessed_method_role.getIdentifier(), primary_role.getIdentifier())));
        accessed_method_role.addConstraint(new MethodFormalParametersAreMatching(accessed_method_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_delegation.addRole(primary_role, true);
        dpd_delegation.addRole(functionaccess_role, false);
        dpd_delegation.addRole(accessed_method_role, false);
        dpd_delegation.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_delegation);
        this.dpd_map.put(dpd_delegation.getDesignPatternName(), dpd_delegation);
    }

    private void buildForeignDelegationMethod() {
        // FOREIGN DELEGATION METHOD:
        
        /* - max. 5 statements
         * - functionaccess to function in foreign class
         * - class of accessed method is not same as of delegation method
         * - accessed function return type fits to return type of delegation method
         */
        
        DesignPatternDescription dpd_delegation = new DesignPatternDescription("FOREIGN DELEGATION METHOD");
        
        MethodRole primary_role = new MethodRole("foreign delegation method", "A", dpd_delegation);
        ClassRole surroundingclass_role = new ClassRole("surrounding class", "B", dpd_delegation);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("delegate access", "C", dpd_delegation);
        MethodRole accessed_method_role = new MethodRole("accessed method", "D", dpd_delegation);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodIsContainedInClassConstraint(primary_role.getIdentifier(), surroundingclass_role));
        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), accessed_method_role));
        //accessed_method_role.addConstraint(new MethodIsContainedInSameClassConstraint(accessed_method_role.getIdentifier(), "B"));
        accessed_method_role.addConstraint(new MethodReturnTypeFitsToReturnTypeOfMethodConstraint(accessed_method_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_delegation.addRole(primary_role, true);
        dpd_delegation.addRole(functionaccess_role, false);
        dpd_delegation.addRole(accessed_method_role, false);
        dpd_delegation.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_delegation);
        this.dpd_map.put(dpd_delegation.getDesignPatternName(), dpd_delegation);
    }

    private void buildChainDelegationMethod() {
        // DELEGATION METHOD:
        
        DesignPatternDescription dpd_delegation = new DesignPatternDescription("DELEGATION METHOD");
        
        MethodRole primary_role = new MethodRole("delegation method", "A", dpd_delegation);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("delegate access", "B", dpd_delegation);
        MethodRole accessed_method_role = new MethodRole("accessed method", "C", dpd_delegation);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), accessed_method_role));
        accessed_method_role.addConstraint(new MethodReturnTypeFitsToReturnTypeOfMethodConstraint(accessed_method_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_delegation.addRole(primary_role, true);
        dpd_delegation.addRole(functionaccess_role, false);
        dpd_delegation.addRole(accessed_method_role, false);
        dpd_delegation.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_delegation);
        this.dpd_map.put(dpd_delegation.getDesignPatternName(), dpd_delegation);
    }
    
    
    private void buildAliasDelegationMethod2() {
        // ALIAS DELEGATION METHOD 2: delegation in same class
        
        DesignPatternDescription dpd_delegation = new DesignPatternDescription("DELEGATION METHOD");
        
        MethodRole primary_role = new MethodRole("delegation method", "A", dpd_delegation);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("delegate access", "B", dpd_delegation);
        MethodRole accessed_method_role = new MethodRole("accessed method", "C", dpd_delegation);

        primary_role.addConstraint(new MethodHasMaxNumberOfStatementsConstraint(primary_role.getIdentifier(), 5));
        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), accessed_method_role));
        accessed_method_role.addConstraint(new MethodReturnTypeFitsToReturnTypeOfMethodConstraint(accessed_method_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_delegation.addRole(primary_role, true);
        dpd_delegation.addRole(functionaccess_role, false);
        dpd_delegation.addRole(accessed_method_role, false);
        dpd_delegation.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_delegation);
        this.dpd_map.put(dpd_delegation.getDesignPatternName(), dpd_delegation);
    }

    private void buildStaticFactoryMethod() {
        // STATIC FACTORY METHOD:
        
        DesignPatternDescription dpd_factorymethod = new DesignPatternDescription("STATIC FACTORY METHOD");
        
        MethodRole primary_role = new MethodRole("factory method", "A", dpd_factorymethod);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("constructor access", "B", dpd_factorymethod);
        ConstructorRole constructor_role = new ConstructorRole("constructor", "C", dpd_factorymethod);

        // abstract
        primary_role.addConstraint(new MethodIsAbstractConstraint(primary_role.getIdentifier(), false));
        // static
        primary_role.addConstraint(new MethodIsStaticConstraint(primary_role.getIdentifier(), true));
        // contains fa to constructor
        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), constructor_role));
        constructor_role.addConstraint(new ConstructorClassTypeFitsToReturnTypeOfMethodConstraint(constructor_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_factorymethod.addRole(primary_role, true);
        dpd_factorymethod.addRole(functionaccess_role, false);
        dpd_factorymethod.addRole(constructor_role, false);
        dpd_factorymethod.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_factorymethod);
        this.dpd_map.put(dpd_factorymethod.getDesignPatternName(), dpd_factorymethod);
        
    }

    
    private void buildFactoryMethod2() {
        // FACTORY METHOD:
        
        DesignPatternDescription dpd_factorymethod = new DesignPatternDescription("FACTORY METHOD");
        
        MethodRole primary_role = new MethodRole("factory method", "A", dpd_factorymethod);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("constructor access", "B", dpd_factorymethod);
        ConstructorRole constructor_role = new ConstructorRole("constructor", "C", dpd_factorymethod);

        primary_role.addConstraint(new MethodContainsFunctionAccessConstraint(primary_role.getIdentifier(), functionaccess_role));
        functionaccess_role.addConstraint(new FunctionAccessHasFunctionTargetConstraint(functionaccess_role.getIdentifier(), constructor_role));
        constructor_role.addConstraint(new ConstructorClassTypeEqualsReturnTypeOfMethodConstraint(constructor_role.getIdentifier(), primary_role.getIdentifier()));
        
        dpd_factorymethod.addRole(primary_role, true);
        dpd_factorymethod.addRole(functionaccess_role, false);
        dpd_factorymethod.addRole(constructor_role, false);
        dpd_factorymethod.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_factorymethod);
        this.dpd_map.put(dpd_factorymethod.getDesignPatternName(), dpd_factorymethod);
        
    }

    private void buildTemplate() {
        // TEMPLATE:
        DesignPatternDescription dpd_template = new DesignPatternDescription("TEMPLATE");
        
        ClassRole primary_role = new ClassRole("abstract class", "A", dpd_template);
        MethodRole method_role = new MethodRole("template method", "B", dpd_template);
        FunctionAccessRole functionaccess_role = new FunctionAccessRole("functionaccess", "C", dpd_template);
        ClassRole concrete_class_role = new ClassRole("concrete class", "D", dpd_template);

        // abstract class is abstract
        primary_role.addConstraint(new ClassIsAbstractConstraint(primary_role.getIdentifier(), true));
         
        primary_role.addConstraint(new ClassContainsMethodConstraint(primary_role.getIdentifier(), method_role));
        primary_role.addConstraint(new ClassHasSubclassConstraint(primary_role.getIdentifier(), concrete_class_role));
        
        method_role.addConstraint(new MethodIsAbstractConstraint(method_role.getIdentifier(), false));
        method_role.addConstraint(new MethodContainsFunctionAccessConstraint(method_role.getIdentifier(), functionaccess_role));
        
        functionaccess_role.addConstraint(new FunctionAccessTargetIsAbstractConstraint(functionaccess_role.getIdentifier(), true));
        functionaccess_role.addConstraint(new FunctionAccessTargetIsInClassConstraint(functionaccess_role.getIdentifier(), "A"));
        
        dpd_template.addRole(primary_role, true);
        dpd_template.addRole(method_role, true);
        dpd_template.addRole(functionaccess_role, false);
        dpd_template.addRole(concrete_class_role, true);
        dpd_template.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_template);
        this.dpd_map.put(dpd_template.getDesignPatternName(), dpd_template);

    }
    
    private void buildVisitor() {
        // VISITOR:
        DesignPatternDescription dpd_visitor = new DesignPatternDescription("VISITOR");
        
        // Roles:
        
        ClassRole primary_role = new ClassRole("visitor class", "A", dpd_visitor);
        ClassRole concrete_visitor_role = new ClassRole("concrete visitor classes", "B", dpd_visitor);
        MethodRole visit_method_role = new MethodRole("visit methods", "C", dpd_visitor);
        FormalParameterRole visit_method_fp_role = new FormalParameterRole("fp visit method", "D", dpd_visitor);
        ClassRole concrete_class_role = new ClassRole("concrete elements", "E", dpd_visitor);
        MethodRole accept_method_role = new MethodRole("accept methods", "F", dpd_visitor);
        FormalParameterRole fp_role_of_accept_method = new FormalParameterRole("fp of accept method", "G", dpd_visitor);
        FunctionAccessRole fa_role_in_accept_method = new FunctionAccessRole("fa in accept method", "H", dpd_visitor);
        
        // Constraints:
        
        primary_role.addConstraint(new ORConstraint(new ClassIsAbstractConstraint(primary_role.getIdentifier(), true), 
                                                    new ClassIsInterfaceConstraint(primary_role.getIdentifier(), true)));
        
        primary_role.addConstraint(new ClassContainsMethodConstraint(primary_role.getIdentifier(), visit_method_role));
        primary_role.addConstraint(new ClassHasSubclassConstraint(primary_role.getIdentifier(), concrete_visitor_role));
        
        visit_method_role.addConstraint(new MethodIsAbstractConstraint(visit_method_role.getIdentifier(), true));
        visit_method_role.addConstraint(new MethodHasNumberOfFormalParametersConstraint(visit_method_role.getIdentifier(), 1));
        visit_method_role.addConstraint(new MethodContainsFormalParameterConstraint(visit_method_role.getIdentifier(), visit_method_fp_role));
        
        visit_method_fp_role.addConstraint(new FormalParameterIsOfTypeConstraint(visit_method_fp_role.getIdentifier(), concrete_class_role));
        
        concrete_class_role.addConstraint(new ClassIsAbstractConstraint(concrete_class_role.getIdentifier(), false));
        concrete_class_role.addConstraint(new ClassContainsMethodConstraint(concrete_class_role.getIdentifier(), accept_method_role));
        
        accept_method_role.addConstraint(new MethodContainsFormalParameterConstraint(accept_method_role.getIdentifier(), fp_role_of_accept_method));
        accept_method_role.addConstraint(new MethodContainsFunctionAccessConstraint(accept_method_role.getIdentifier(), fa_role_in_accept_method));

        fp_role_of_accept_method.addConstraint(new FormalParameterIsOfTypeConstraint(fp_role_of_accept_method.getIdentifier(), "A"));
        fa_role_in_accept_method.addConstraint(new FunctionAccessHasFunctionTargetConstraint(fa_role_in_accept_method.getIdentifier(), "C"));
        
        dpd_visitor.addRole(primary_role, true);
        dpd_visitor.addRole(concrete_visitor_role, true);
        dpd_visitor.addRole(visit_method_role, true);
        dpd_visitor.addRole(visit_method_fp_role, false); //
        dpd_visitor.addRole(concrete_class_role, true);
        dpd_visitor.addRole(accept_method_role, true);
        dpd_visitor.addRole(fp_role_of_accept_method, false); //
        dpd_visitor.addRole(fa_role_in_accept_method, false);
        dpd_visitor.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_visitor);
        this.dpd_map.put(dpd_visitor.getDesignPatternName(), dpd_visitor);
    }

    private void buildObserver() {
        // OBSERVER
        
        DesignPatternDescription dpd_observer = new DesignPatternDescription("OBSERVER");
        
        ClassRole primary_role = new ClassRole("observer class", "A", dpd_observer);
        ClassRole concrete_observer_role = new ClassRole("concrete observer class", "B", dpd_observer);
        MethodRole update_method_role = new MethodRole("update method", "C", dpd_observer);
        MethodRole notify_method_role = new MethodRole("notify method", "D", dpd_observer);
        StatementRole loop_statement_role = new StatementRole("loop statement role", "E", dpd_observer);
        FunctionAccessRole fa_role_in_loop_statement = new FunctionAccessRole("fa in loop statement", "F", dpd_observer);
        ClassRole subject_role = new ClassRole("subject class", "G", dpd_observer);
        MethodRole attach_detach_method_role = new MethodRole("attach/detach method", "H", dpd_observer);
        FormalParameterRole observer_fp_role = new FormalParameterRole("attach/detach fp", "I", dpd_observer);

        primary_role.addConstraint(new ORConstraint(new ClassIsAbstractConstraint(primary_role.getIdentifier(), true), new ClassIsInterfaceConstraint(primary_role.getIdentifier(), true)));
        
        primary_role.addConstraint(new ClassContainsMethodConstraint(primary_role.getIdentifier(), update_method_role));
        primary_role.addConstraint(new ClassHasSubclassConstraint(primary_role.getIdentifier(), concrete_observer_role));
        
        update_method_role.addConstraint(new MethodIsAbstractConstraint(update_method_role.getIdentifier(), true));
        update_method_role.addConstraint(new MethodIsReferencedByFunctionConstraint(update_method_role.getIdentifier(), notify_method_role));

        notify_method_role.addConstraint(new MethodContainsStatementConstraint(notify_method_role.getIdentifier(), loop_statement_role));
        
        loop_statement_role.addConstraint(new StatementIsOfTypeConstraint(loop_statement_role.getIdentifier(), LoopStatement.class));
        
        loop_statement_role.addConstraint(new StatementContainsFunctionAccessConstraint(loop_statement_role.getIdentifier(), fa_role_in_loop_statement));
        
        fa_role_in_loop_statement.addConstraint(new FunctionAccessHasFunctionTargetConstraint(fa_role_in_loop_statement.getIdentifier(), "C"));

        notify_method_role.addConstraint(new MethodIsContainedInClassConstraint(notify_method_role.getIdentifier(), subject_role));
        
        subject_role.addConstraint(new ClassIsAbstractConstraint(subject_role.getIdentifier(), true));
        subject_role.addConstraint(new ClassContainsMethodConstraint(subject_role.getIdentifier(), attach_detach_method_role));
        
        attach_detach_method_role.addConstraint(new MethodContainsFormalParameterConstraint(attach_detach_method_role.getIdentifier(), observer_fp_role));
        observer_fp_role.addConstraint(new FormalParameterIsOfTypeConstraint(observer_fp_role.getIdentifier(), "A"));
        
        dpd_observer.addRole(primary_role, true);
        dpd_observer.addRole(concrete_observer_role, true);
        dpd_observer.addRole(update_method_role, true);
        dpd_observer.addRole(notify_method_role, true);
        dpd_observer.addRole(loop_statement_role, false);
        dpd_observer.addRole(fa_role_in_loop_statement, false);
        dpd_observer.addRole(subject_role, true);
        dpd_observer.addRole(attach_detach_method_role, true);
        dpd_observer.addRole(observer_fp_role, false);
        dpd_observer.setPrimaryRole(primary_role);
        
        this.design_pattern_description_list.add(dpd_observer);
        this.dpd_map.put(dpd_observer.getDesignPatternName(), dpd_observer);
    }

    private void buildFacade() {
        // TODO Auto-generated method stub
    }

    private void buildProxy() {
        // TODO Auto-generated method stub
    }

    public List getDesignPatternDescriptionList() {
        return design_pattern_description_list;
    }

    public static void main(String[] args) {

        DesignPatternDescriptionGenerator.getSingleton().buildDesignPatternDescriptions();

        System.out.println("LISTING OF DESIGN-PATTERN-DESCRIPTIONS:");
        System.out.println("---------------------------------------");
        System.out.println();

        Iterator dpd_itr = DesignPatternDescriptionGenerator.getSingleton().getDesignPatternDescriptionList().iterator();
        
        while (dpd_itr.hasNext()) {
            DesignPatternDescription dpd = (DesignPatternDescription)dpd_itr.next();
            
            System.out.println(dpd.toString());
            System.out.println("--");
        }
        
    }
                                            
}
