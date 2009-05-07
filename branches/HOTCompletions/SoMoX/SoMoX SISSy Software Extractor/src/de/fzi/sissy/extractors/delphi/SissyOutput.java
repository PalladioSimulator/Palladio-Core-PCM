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

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import de.fzi.delphi.output.IOPOutput;
import de.fzi.delphi.output.IOPOutputImplementation;
import de.fzi.delphi.parser.OPReferencesParser;
import de.fzi.delphi.symbols.Attribute;
import de.fzi.delphi.symbols.CompilationUnit;
import de.fzi.delphi.symbols.Method;
import de.fzi.delphi.symbols.Scope;
import de.fzi.delphi.symbols.Symbol;
import de.fzi.delphi.types.Type;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 */ 
public class SissyOutput extends IOPOutputImplementation implements IOPOutput {

	private Vector opNewCompilationUnits;
	private Vector opUsesCompilationUnits;
	private Vector opTypeReferences;
	private Vector opTypeDeclarations;
	private Vector opTypeCasts;
	private Vector opAttributDeclarations;
	private Vector opAttributReferences;
	private Vector opMethodDeclarations;
	private Vector opMethodReferences;
    private Vector opSelfAccesses;
    private Vector opRuntimeTypeAccesses;
    private Vector opStaticTypeAccesses;
    private Vector opCompositeAccesses;
	private Scope opRootScope;
	private Vector collectedCompilationUnits;
	private Vector collectedTypes;
	private Map opSymbolToCompilationUnitMapper;
	
	public SissyOutput() {
		opNewCompilationUnits = new Vector();
		opUsesCompilationUnits = new Vector();
		opTypeReferences = new Vector();
		opTypeDeclarations = new Vector();
		opTypeCasts = new Vector();
		opAttributDeclarations = new Vector();
		opAttributReferences = new Vector();
		opMethodDeclarations = new Vector();
		opMethodReferences = new Vector();
        opSelfAccesses = new Vector();
        opStaticTypeAccesses = new Vector();
        opRuntimeTypeAccesses = new Vector();
        opCompositeAccesses = new Vector();
		opRootScope = null;
		
		collectedCompilationUnits = new Vector();
		collectedTypes = new Vector();
		opSymbolToCompilationUnitMapper = new HashMap();
	}

	private void setRootScope(Scope location) {
		if (opRootScope==null){
			if (location != null) {
				opRootScope = location.getRootScope();
			}
		}
	}
	
	private void collectCompilationUnit(Symbol op_symbol) {
		Scope scope = op_symbol.getScope();
		
		if (scope != null) {
			CompilationUnit op_compilation_unit = scope.getCompilationUnit();
			
			if (op_compilation_unit != null) {
			if (!collectedCompilationUnits.contains(op_compilation_unit)) {
				// insert in collection
				collectedCompilationUnits.add(op_compilation_unit);
				// map symbol to compilationUnit
				if (!opSymbolToCompilationUnitMapper.containsKey(op_symbol))
				opSymbolToCompilationUnitMapper.put(op_symbol, op_compilation_unit);
				else 
					Debug.warning("Symbol already mapped to Compilation Unit");
				
				
			} 
			} else {
				Debug.warning("CompilationUnit was null!");
			}
			
		} else {
			Debug.warning("collectCompUnits: Scope of Symbol was null!");
		}
	}
	
	/*
	 *  The mark-Methods of this Class are CallBack-Methods which are
	 *  called by des OP-Parser while running the extraction-process.
	 */
	public void markTypeDeclaration(Scope location, Type t) {
		Debug.verbose("markTypeDeclaration executed");
		setRootScope(location);
		if (!collectedTypes.contains(t)) 
			collectedTypes.add(t);
		OutputPair outputPair = new OutputPair(location, t);
		this.opTypeDeclarations.add(outputPair);
		
	}

	public void markTypeReference(Scope location, Type t) {
		Debug.verbose("markTypeReference executed");
		setRootScope(location);
		if (!collectedTypes.contains(t)) 
			collectedTypes.add(t);
		OutputPair outputPair = new OutputPair(location, t);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Type-Reference was there!");
  } else {
            Debug.warning("Statement for Type-Reference was null!");
        }
		this.opTypeReferences.add(outputPair);
	}

	public void markTypeCast(Scope location, Type t) {
		Debug.verbose("markTypeCast executed");
		setRootScope(location);
		OutputPair outputPair = new OutputPair(location, t);
		this.opTypeCasts.add(outputPair);
	}
	
	public void markAttributeDeclaration(Scope location, Attribute v) {
		Debug.verbose("markAttributeDeclaration executed");
		setRootScope(location);
		OutputPair outputPair = new OutputPair(location, v);
		this.opAttributDeclarations.add(outputPair);
	}

	public void markAttributeReference(Scope location, Attribute v) {
		Debug.verbose("markAttributeReference executed");
		setRootScope(location);
		OutputPair outputPair = new OutputPair(location, v);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Attribute-Reference was there!");
        } else {
            Debug.warning("Statement for Attribute-Reference was null!");
        }
        
		this.opAttributReferences.add(outputPair);
	}

	

	public void markMethodDeclaration(Scope location, Method f) {
		Debug.verbose("markMethodDeclaration executed");
		setRootScope(location);
		OutputPair outputPair = new OutputPair(location, f);
		this.opMethodDeclarations.add(outputPair);
	}

	public void markMethodReference(Scope location, Method f) {
        Debug.verbose("markMethodReference executed");
		setRootScope(location);
		OutputPair outputPair = new OutputPair(location, f);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Method-Reference was there!");
        } else {
            Debug.info("Statement for Method-Reference was null!");
        }
		this.opMethodReferences.add(outputPair);
	}

	
	
	public void markNewCompilationUnit(String name) {
		Debug.verbose("markNewCompilationUnit executed");
		this.opNewCompilationUnits.add(name);
	}

	public void markUsesCompilationUnit(Scope location, String name) {
		Debug.verbose("markUsesCompilationUnit executed");
		setRootScope(location);
		OutputPair outputPair = new OutputPair(location, name);
		this.opUsesCompilationUnits.add(outputPair);
	}
	
	public void printCommentLine(String comment) {
	}

	public void printAllScopeEntities(Scope scope) {
	}

	public void close() {
	}

	public void printOutput() {
		Debug.info("OP-Extraction-Summary:");
		Debug.info("#AttributDeclarations: " + this.getOpAttributDeclarations().size());
		Debug.info("#AttributReferences:   " + this.getOpAttributReferences().size());
		Debug.info("#MethodDeclarations:   " + this.getOpMethodDeclarations().size());
		Debug.info("#MethodReferences:     " + this.getOpMethodReferences().size());
		Debug.info("#TypeDeclarations:     " + this.getOpTypeDeclarations().size());
		Debug.info("#TypeReferences:       " + this.getOpTypeReferences().size());
		Debug.info("#NewCompUnits:         " + this.getOpNewCompilationUnits().size());
		Debug.info("#UsesCompUnits:        " + this.getOpUsesCompilationUnits().size());
		Debug.info("#TypeCasts:            " + this.getOpTypeCasts().size());
	}
	
	/**
	 * @return Returns the opAttributDeclarations.
	 */
	public Vector getOpAttributDeclarations() {
		return opAttributDeclarations;
	}
	/**
	 * @param opAttributDeclarations The opAttributDeclarations to set.
	 */
	public void setOpAttributDeclarations(Vector opAttributDeclarations) {
		this.opAttributDeclarations = opAttributDeclarations;
	}
	/**
	 * @return Returns the opAttributReferences.
	 */
	public Vector getOpAttributReferences() {
		return opAttributReferences;
	}
	/**
	 * @param opAttributReferences The opAttributReferences to set.
	 */
	public void setOpAttributReferences(Vector opAttributReferences) {
		this.opAttributReferences = opAttributReferences;
	}
	/**
	 * @return Returns the opMethodDeclarations.
	 */
	public Vector getOpMethodDeclarations() {
		return opMethodDeclarations;
	}
	/**
	 * @param opMethodDeclarations The opMethodDeclarations to set.
	 */
	public void setOpMethodDeclarations(Vector opMethodDeclarations) {
		this.opMethodDeclarations = opMethodDeclarations;
	}
	/**
	 * @return Returns the opMethodReferences.
	 */
	public Vector getOpMethodReferences() {
		return opMethodReferences;
	}
	/**
	 * @param opMethodReferences The opMethodReferences to set.
	 */
	public void setOpMethodReferences(Vector opMethodReferences) {
		this.opMethodReferences = opMethodReferences;
	}
	/**
	 * @return Returns the opNewCompilationUnits.
	 */
	public Vector getOpNewCompilationUnits() {
		return opNewCompilationUnits;
	}
	/**
	 * @param opNewCompilationUnits The opNewCompilationUnits to set.
	 */
	public void setOpNewCompilationUnits(Vector opNewCompilationUnits) {
		this.opNewCompilationUnits = opNewCompilationUnits;
	}
	/**
	 * @return Returns the opTypeCasts.
	 */
	public Vector getOpTypeCasts() {
		return opTypeCasts;
	}
	/**
	 * @param opTypeCasts The opTypeCasts to set.
	 */
	public void setOpTypeCasts(Vector opTypeCasts) {
		this.opTypeCasts = opTypeCasts;
	}
	/**
	 * @return Returns the opTypeDeclarations.
	 */
	public Vector getOpTypeDeclarations() {
		return opTypeDeclarations;
	}
	/**
	 * @param opTypeDeclarations The opTypeDeclarations to set.
	 */
	public void setOpTypeDeclarations(Vector opTypeDeclarations) {
		this.opTypeDeclarations = opTypeDeclarations;
	}
	/**
	 * @return Returns the opTypeReferences.
	 */
	public Vector getOpTypeReferences() {
		return opTypeReferences;
	}

    public Vector getOpStaticTypeAccesses() {
        return opStaticTypeAccesses;
    }

    public Vector getOpRuntimeTypeAccesses() {
        return opRuntimeTypeAccesses;
    }

    public Vector getOpCompositeAccesses() {
        return opCompositeAccesses;
    }

    public Vector getOpSelfAccesses() {
        return opSelfAccesses;
    }
/**
	 * @param opTypeReferences The opTypeReferences to set.
	 */
	public void setOpTypeReferences(Vector opTypeReferences) {
		this.opTypeReferences = opTypeReferences;
	}
	/**
	 * @return Returns the opUsesCompilationUnits.
	 */
	public Vector getOpUsesCompilationUnits() {
		return opUsesCompilationUnits;
	}
	/**
	 * @param opUsesCompilationUnits The opUsesCompilationUnits to set.
	 */
	public void setOpUsesCompilationUnits(Vector opUsesCompilationUnits) {
		this.opUsesCompilationUnits = opUsesCompilationUnits;
	}
	/**
	 * @return Returns the collectedCompilationUnits.
	 */
	public Vector getCollectedCompilationUnits() {
		return collectedCompilationUnits;
	}
	/**
	 * @param collectedCompilationUnits The collectedCompilationUnits to set.
	 */
	public void setCollectedCompilationUnits(Vector collectedCompilationUnits) {
		this.collectedCompilationUnits = collectedCompilationUnits;
	}
	/**
	 * @return Returns the opSymbolToCompilationUnitMapper.
	 */
	public Map getOpSymbolToCompilationUnitMapper() {
		return opSymbolToCompilationUnitMapper;
	}
	/**
	 * @param opSymbolToCompilationUnitMapper The opSymbolToCompilationUnitMapper to set.
	 */
	public void setOpSymbolToCompilationUnitMapper(
			Map opSymbolToCompilationUnitMapper) {
		this.opSymbolToCompilationUnitMapper = opSymbolToCompilationUnitMapper;
	}
	/**
	 * @return Returns the opRootScope.
	 */
	public Scope getOpRootScope() {
		return opRootScope;
	}
	/**
	 * @return Returns the collectedTypes.
	 */
	public Vector getCollectedTypes() {
		return collectedTypes;
	}
	/**
	 * @param collectedTypes The collectedTypes to set.
	 */
	public void setCollectedTypes(Vector collectedTypes) {
		this.collectedTypes = collectedTypes;
	}

    public void markSelfAccess(Scope location, Symbol inheritedSymbol) {
        Debug.info("markSelfAccess executed");
        OutputPair outputPair = new OutputPair(location, inheritedSymbol);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Method-Reference was there!");
        } else {
            Debug.warning("Statement for SelfAccess was null!");
        }
        this.opSelfAccesses.add(outputPair);
    }


    public void markStaticTypeAccess(Scope location, Symbol typeSymbol) {
        Debug.verbose("markStaticTypeAccess executed");
        OutputPair outputPair = new OutputPair(location, typeSymbol);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Method-Reference was there!");
        } else {
            Debug.warning("Statement for StaticTypeAccess was null!");
        }
        this.opStaticTypeAccesses.add(outputPair);
    }

    public void markRuntimeTypeAccess(Scope location, Symbol typeSymbol) {
        Debug.verbose("markRuntimeTypeAccess executed");
        OutputPair outputPair = new OutputPair(location, typeSymbol);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Method-Reference was there!");
        } else {
            Debug.warning("Statement for RuntimeTypeAccess was null!");
        }
        this.opRuntimeTypeAccesses.add(outputPair);
    }

    public void markCompositeAccess(Scope location, Symbol typeSymbol) {
        Debug.verbose("markCompositeTypeAccess executed");
        OutputPair outputPair = new OutputPair(location, typeSymbol);
        if (OPReferencesParser.getCurrentStatement()!=null) {
            outputPair.setCurrentStatement(OPReferencesParser.getCurrentStatement());
            //Debug.info("Statement for Method-Reference was there!");
        } else {
            Debug.warning("Statement for CompositeAccess was null!");
        }
        this.opCompositeAccesses.add(outputPair);
    }

    
}
