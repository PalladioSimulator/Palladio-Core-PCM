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
import java.util.Map;
import java.util.StringTokenizer;

import de.fzi.sissy.Main;
import de.fzi.sissy.dpanalyzer.constraints.CheckObjectConstraint;
import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.*;
import de.fzi.sissy.util.Debug;

public class DesignPatternAnalyzer {

    private static Map resultPatternMap;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Debug.info("==================================");
        Debug.info("WELCOME TO DESIGN-PATTERN-ANALYZER");
        Debug.info("==================================");
        Debug.info("");
        
        // run factextraction ==> import metamod
        Debug.info("Extracting Metamod...");
        ExtractorFassade.activateCloneAnalyses(false);
        Main.main(args);
        Debug.setDebugLevel(6);
        Debug.info("");
        Debug.info("Extracting Metamod...finished");
        
        // get metamod-repository
        ModelElementRepository metamod_repository = ModelElementRepository.getWorkingRepository();

        // create and setup metamod-retrieval-engine
        MetamodRetrievalEngineImplementation metamod_retrieval_engine = MetamodRetrievalEngineImplementation.getSingleton();
        metamod_retrieval_engine.setMetamodRepository(metamod_repository);

        
        // create retrieval-process
        DesignPatternRetrievalProcess retrieval_process = DesignPatternRetrievalProcess.getSingleton();
        
        
        resultPatternMap = new HashMap();
        
        // build DesignPatternDescriptions
        Debug.info("Build DesignPatternDescriptions...");
        DesignPatternDescriptionGenerator.getSingleton().buildDesignPatternDescriptions();
        
        Iterator dpd_itr = DesignPatternDescriptionGenerator.getSingleton().getDesignPatternDescriptionList().iterator();

        Debug.info("");
        Debug.info("--------------------------------------------------------------------------");
        Debug.info("          STARTING DESIGN-PATTERN-ANALYSES NOW !!!                        ");
        Debug.info("--------------------------------------------------------------------------");
        Debug.info("");
        
        while(dpd_itr.hasNext()) {
            DesignPatternDescription dpd = (DesignPatternDescription)dpd_itr.next();

            Debug.info("Extracting "+ dpd.getDesignPatternName() + ": ");

            retrieval_process.setup(dpd);
            
            retrieval_process.start();
            
            Collection dp_instances = retrieval_process.getResultDPInstances();
            
            if (!dp_instances.isEmpty()) {
                resultPatternMap.put(dpd.getDesignPatternName(), dp_instances);
            } else {
                Debug.info("No DP-Instances found for "+ dpd.getDesignPatternName());
            }

            Debug.info("--------------------------------------------------------------------------");
            Debug.info("");

        }
        
        //printExtractionSummary();
        
        XMLExporter.getSingleton().exportToXMLFile(resultPatternMap);

        printExtractionSummary();
        
        // TEMPLATE:
        
        // Create Roles And Constraints !
        
        /*
        Role class_role_a = new Role("Abstract Class", "class-role");
        
        CheckObjectConstraint constraint_class_abstract = new CheckObjectConstraint("abstract") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.Class)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.Class class_obj = (de.fzi.sissy.metamod.Class)object;
                
                return class_obj.isAbstract();
            }
            
        };

        CheckObjectConstraint constraint_class_method_containment = new CheckObjectConstraint("class-method-containment") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.Class)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.Class class_obj = (de.fzi.sissy.metamod.Class)object;
                
                Collection method_list = class_obj.getMethods();
                
                return !evaluation_role.evaluate(method_list).isEmpty();
            }
            
        };

        Role method_role = new Role("Template Methods", "method-role");

        CheckObjectConstraint constraint_method_not_abstract = new CheckObjectConstraint("not abstract") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.Method)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.Method method_obj = (de.fzi.sissy.metamod.Method)object;
                
                return !method_obj.isAbstract();
            }
            
        };

        CheckObjectConstraint constraint_method_functionaccess_containment = new CheckObjectConstraint("method-functionaccess-containment") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.Class)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.Method method_obj = (de.fzi.sissy.metamod.Method)object;

                Collection function_access_list = method_obj.getFunctionAccesses();
                
                return !evaluation_role.evaluate(function_access_list).isEmpty();
            }
            
        };
        
        
        Role function_access_role = new Role("function accesses", "functionaccess-role");
        
        CheckObjectConstraint constraint_functionaccess_target_is_abstract = new CheckObjectConstraint("target abstract") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.FunctionAccess)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.FunctionAccess metamod_obj = (de.fzi.sissy.metamod.FunctionAccess)object;
                
                Function accessed_function = metamod_obj.getAccessedFunction();
                
                if (accessed_function==null)
                    return false;
                
                if (accessed_function instanceof de.fzi.sissy.metamod.Method) {
                    return ((de.fzi.sissy.metamod.Method)accessed_function).isAbstract();
                    
                } else {
                    return false;
                    
                }
            }
            
        };

        CheckObjectConstraint constraint_class_method_containment_b = new CheckObjectConstraint("class-method-containment") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.FunctionAccess)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.FunctionAccess metamod_obj = (de.fzi.sissy.metamod.FunctionAccess)object;
                
                Function accessed_function = metamod_obj.getAccessedFunction();
                
                de.fzi.sissy.metamod.Class class_obj = (de.fzi.sissy.metamod.Class) outer_role.getCurrentCandidate(); 
                
                if (accessed_function==null)
                    return false;
                
                if (accessed_function instanceof de.fzi.sissy.metamod.Method) {
                    return class_obj.getMethods().contains(accessed_function);
                    
                } else {
                    return false;
                    
                }
            }
        };
        
        
        // Link Roles And Constraints

        Role concrete_class_role = new Role("conrecte classes",  "class-role");
        
        CheckObjectConstraint constraint_subclass = new CheckObjectConstraint("subclass") {

            public boolean check(Object object) {
                if (!(object instanceof de.fzi.sissy.metamod.Class)) {
                    return false;
                    
                }
                
                de.fzi.sissy.metamod.Class class_obj = (de.fzi.sissy.metamod.Class)object;

                de.fzi.sissy.metamod.Class super_class_obj = (de.fzi.sissy.metamod.Class) outer_role.getCurrentCandidate(); 

                return class_obj.extendsClass(super_class_obj);
            }
            
        };
        
        class_role_a.addConstraint(constraint_class_abstract);
        class_role_a.addConstraint(constraint_class_method_containment);
        constraint_class_method_containment.setEvaluation_role(method_role);

        method_role.addConstraint(constraint_method_not_abstract);
        method_role.addConstraint(constraint_method_functionaccess_containment);

        constraint_method_functionaccess_containment.setEvaluation_role(function_access_role);

        function_access_role.addConstraint(constraint_functionaccess_target_is_abstract);
        function_access_role.addConstraint(constraint_class_method_containment_b);
        constraint_class_method_containment_b.setOuterRole(class_role_a);
        
        concrete_class_role.addConstraint(constraint_subclass);
        constraint_subclass.setOuterRole(class_role_a);
*/        

    }

    private static void printExtractionSummary() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("DESIGNPATTERN EXTRACTION-SUMMARY");
        System.out.println("--------------------------------");
        System.out.println();

        Iterator dpd_itr = resultPatternMap.keySet().iterator();

        while(dpd_itr.hasNext()) {
            String dpd_name = (String)dpd_itr.next();
            
            System.out.println("======================================================");
            System.out.println(dpd_name+"-Instances:");
            System.out.println("======================================================");
            System.out.println();
            

            Iterator dpi_itr = ((Collection)resultPatternMap.get(dpd_name)).iterator();

            while(dpi_itr.hasNext()) {
                DesignPatternInstance dpi = (DesignPatternInstance)dpi_itr.next();
                
                System.out.println(dpd_name+"-Instance:");
                System.out.println();
                System.out.println(dpi.toString());

                /*
                StringTokenizer st = new StringTokenizer(dpi.toString(), "], ");
                
                while (st.hasMoreTokens()) {
                    System.out.println(st.nextToken());
                }
                */
                //System.out.println();
                
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println();

            }
            
            System.out.println();


        }

        dpd_itr = resultPatternMap.keySet().iterator();

        while(dpd_itr.hasNext()) {
            String dpd_name = (String)dpd_itr.next();
            
            System.out.println("Found "+dpd_name+"-Instances: " + ((Collection)resultPatternMap.get(dpd_name)).size());

        }
        System.out.println();

    }

}
