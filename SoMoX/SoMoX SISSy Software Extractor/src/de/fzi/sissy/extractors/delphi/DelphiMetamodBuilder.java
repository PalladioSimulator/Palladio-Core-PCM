/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
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
package de.fzi.sissy.extractors.delphi;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import de.fzi.sissy.extractors.java.builders.StatementViewer;
import de.fzi.sissy.extractors.meta.GeneralCollector;
import de.fzi.sissy.extractors.meta.GeneralMapper;
import de.fzi.sissy.extractors.meta.GeneralMetamodBuilder;
import de.fzi.sissy.metamod.File;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Array;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.Destructor;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.GlobalVariable;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.metamod.StatementTreeWalker;
import de.fzi.sissy.metamod.StructuralAbstraction;
import de.fzi.sissy.util.Debug;
import de.fzi.delphi.symbols.types.*;
import de.fzi.delphi.symbols.*;

/**
 * @author stammel
 *
 */
public class DelphiMetamodBuilder extends GeneralMetamodBuilder {

    /**
     * @param collector
     * @param mapper
     * @param modelElementRepository
     */
    public DelphiMetamodBuilder(GeneralCollector collector, GeneralMapper mapper, ModelElementRepository modelElementRepository) {
        super(collector, mapper, modelElementRepository);
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralMetamodBuilder#buildImportedPackages(java.lang.Object, java.lang.Package)
     */
    public void buildImportedPackages(Object file_element, File file_metamod) {
        
        if (! (file_element instanceof CompilationUnit)) 
        	return;
 
        CompilationUnit cu = (CompilationUnit) file_element;
        
        List imports = new ArrayList();
        imports.addAll(cu.getInterfaceUsesList());
        imports.addAll(cu.getImplementationUsesList());
        
        Iterator it = imports.iterator();
        while (it.hasNext()) {
        	Scope scope = (Scope) it.next();
        	if (scope != null) {
        		Object pack = this.mapper.getInstance(scope);
        		if ((pack != null) && (pack instanceof Package)) {
        			file_metamod.addImportedPackage((Package) pack);
        		}
        	}
        }
        
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralMetamodBuilder#buildStatements(java.lang.Object, de.fzi.sissy.metamod.Function)
     */
    protected void buildStatements(Object function_element,
            Function function_metamod) {

        /* Metamod-Statement-Hierarchy is created in OPParser
         * within an ANTLR Grammar (see op_declarations.g)
         *  
         */
        de.fzi.sissy.metamod.BlockStatement body = 
            ((de.fzi.delphi.symbols.Method)function_element).getBody();
         
        if (body == null) {
            Debug.info("buildStatements(): Function-Element "+function_metamod.getSimpleName()+" (OPParser) with null-body found. ==> Build empty BlockStatement as body!");
            
            // TODO build empty-body-BlockStatement !!!
            body = new de.fzi.sissy.metamod.BlockStatement();
        }
        
        // TODO File-Setting of Statement-Positions!!!
        // update file-objects in position-objects of statements!
        StatementTreeWalker walker = new StatementTreeWalker(body);
        
        do {
            Statement stm = walker.getStatement();
            Position stm_position = stm.getPosition();
            if (stm_position!=null) {
                stm_position.setSourceFile(function_metamod.getPosition().getSourceFile());
            }
        } while(walker.next());
        
        function_metamod.setBody(body);
    }

    // MB : Properly set overriddenMember for methods
    protected void buildOverriddenMembers() {
    	Iterator it = this.collector.getClassElements().iterator();
    	
    	while (it.hasNext()) {
    		
    		Object class_element = (Object) it.next();
    		
    		Class class_metamod = (Class) mapper.getInstance(class_element);
    		
    		if (class_metamod != null) {
    			
    			Iterator m_it = class_metamod.getMethods().iterator();
    			while (m_it.hasNext()) {
    				
    				Method m = (Method) m_it.next();
    				Member overridden = computeOverriddenMember(m);  
    				if (overridden != null) {
    					m.setOverridenMember(overridden);
    					m.setOverride();
    				}
    			
    			}
    			
    			Iterator c_it = class_metamod.getConstructors().iterator();
    			while (c_it.hasNext()) {
    				
    				Constructor c = (Constructor) c_it.next();
    				Member overridden = computeOverriddenMember(c);  
    				if (overridden != null) { 
    					c.setOverridenMember(overridden);
    					c.setOverride();
    				}
    			
    			}
    			Iterator d_it = class_metamod.getDestructors().iterator();
    			while (d_it.hasNext()) {
    				
    				Destructor d = (Destructor) d_it.next();
    				Member overridden = computeOverriddenMember(d);  
    				if (overridden != null) { 
    					d.setOverridenMember(overridden);
    					d.setOverride();
    				}
    			
    			}

    			
    		}
 
    	}
    }

    private Member computeOverriddenMember(Member m) {
    	Class cls = m.getSurroundingClass();
    	if (cls != null) {
    		
    		Iterator super_it = cls.getAllSuperTypes().iterator();
    		while (super_it.hasNext()) {
    			
    			Class super_cls = (Class) super_it.next();
    			
    			ModelElementList candidates = new ModelElementList();
    			candidates.addAll(super_cls.getMethods());
    			candidates.addAll(super_cls.getConstructors());
    			candidates.addAll(super_cls.getDestructors());
    			Iterator m_it = candidates.iterator();
    			while (m_it.hasNext()) {
    				
    				Member overridden = (Member) m_it.next();
    				
    				// Case 1: m has directive override
    				if (m.isOverride() && ((Function) m).hasIdenticalSignature((Function) overridden))
    					return overridden;
    				// Case 2: m's class is derived from an interface and m provides an implementation 
    				// to one of its methods
    				if (super_cls.isInterface() && ((Function) m).hasIdenticalSignature((Function) overridden))
    					return overridden;
    			}

    		}
    	}
    	return null;
    }


    
    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralMetamodBuilder#buildCatchParameters()
     */
    protected void buildCatchParameters() {
        // TODO catch-parameters??

    }


    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralMetamodBuilder#establishPackagePackageContainmentRelation()
     */
    public void establishPackagePackageContainmentRelation() {
        // no packages ==> empty
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralMetamodBuilder#establishClassClassContainmentRelation()
     */
    public void establishClassClassContainmentRelation() {
        // TODO class-member in delphi ???
    }
    
    /**
     * Adds some default abstractions to the repository.
     * 
     * For delphi, project files define suitable abstractions. Those contain all unit imports.
     * 
     */
    public void buildDefaultAbstractions() {
    	
    	Iterator file_it = modelElementRepository.getRoot().getFiles().iterator();
    	while (file_it.hasNext()) {
    		File file = (File) file_it.next();
    		
    		if (isProjectFile(file)) {
    			buildAbstractionFromProject(file);
    		}
    	}
    	
    }
    
    private boolean isProjectFile(File file) {
    	if (file.getPathName().toLowerCase().endsWith(".dpr")
    			|| file.getPathName().toLowerCase().endsWith(".dpk")) {
    		return true;
    	}
    	return false;
    }
    
    private void buildAbstractionFromProject(File file) {
    	
    	StructuralAbstraction abstraction = new StructuralAbstraction(file.getPathName(), "PROJECT");
    	
    	Iterator pack_it = file.getImportedPackages().iterator();
    	while (pack_it.hasNext()) {
    		Package pack = (Package) pack_it.next();
    		abstraction.addModelElement(pack);
    	}
    	
    	modelElementRepository.getRoot().addStructuralAbstraction(abstraction);
    	
    }
    	
    /**
     * @return
     */
    public StatementViewer getStatementViewer() {
        return sv;
    }

}
