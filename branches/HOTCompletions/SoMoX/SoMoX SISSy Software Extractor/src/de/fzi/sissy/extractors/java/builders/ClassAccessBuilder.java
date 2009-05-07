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
package de.fzi.sissy.extractors.java.builders;
import java.util.List;

import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.abstraction.TypeArgument;
import recoder.java.Import;
import recoder.java.NonTerminalProgramElement;
import recoder.java.ProgramElement;
import recoder.java.declaration.ClassDeclaration;
import recoder.java.declaration.Extends;
import recoder.java.declaration.Throws;
import recoder.java.declaration.TypeArgumentDeclaration;
import recoder.java.expression.operator.Instanceof;
import recoder.java.expression.operator.TypeCast;
import recoder.java.reference.TypeReference;
import recoder.list.generic.ASTList;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.CastTypeAccess;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.RunTimeTypeAccess;
import de.fzi.sissy.metamod.ThrowTypeAccess;
import de.fzi.sissy.metamod.TypeAccess;
import de.fzi.sissy.util.Debug;

/**
 * @author haller
 * TODO: Debug and reimplement the hole class based on Mirceas OM.
 */
public class ClassAccessBuilder extends Builder {
	private static ClassAccessBuilder singleton = null;
	
	private ClassAccessBuilder() {
		super();
	}

	public static ClassAccessBuilder getSingleton() {
		if (singleton == null) {
			singleton = new ClassAccessBuilder();
		}//if
		return singleton;
	}//getSingleton
	
	public boolean handleTypeReference(ProgramElement ASTElement_recoder, Function method_metamod) {
		TypeReference typeRef_recoder =	(TypeReference) ASTElement_recoder;
		//Recoder SourceInfo provides the Type that corresponds to that TypeReference
		Type referencedType_recoder = ExtractorFassade.getSourceInfo().getType(typeRef_recoder);

		if (!(typeRef_recoder.getName().equals("void")))
		if (referencedType_recoder==null) {
			Debug.warning("CAB: Recoder-Referenced-Type was null! "+typeRef_recoder.getName());
			//continue;
			return false;
		}
		
        Type oldType_recoder = referencedType_recoder;
        if (referencedType_recoder instanceof ParameterizedType)
            referencedType_recoder = ((ParameterizedType)referencedType_recoder).getGenericType();
        
		de.fzi.sissy.metamod.Type referenced_classType_metamod =	
				(de.fzi.sissy.metamod.Type) ClassTypeBuilder.getSingleton().getInstanceFromMapper(referencedType_recoder);
		
		if (!(typeRef_recoder.getName().equals("void")))
		if (referenced_classType_metamod==null) {
			Debug.warning("CAB: Metamod-Referenced-Type was null! "+typeRef_recoder.getName());
			//continue;
			return false;
		}
		
		//get parent AST to retrieve info about the context (cast, declaration, etc.)
		NonTerminalProgramElement typeReference_parent = typeRef_recoder.getASTParent();

		if (typeReference_parent instanceof TypeCast) {
		    
			TypeCast typeCast = (TypeCast) typeReference_parent;
			CastTypeAccess castTypeAccess = new CastTypeAccess(referenced_classType_metamod);
			Common.extractTypeArguments(castTypeAccess, oldType_recoder);
			castTypeAccess.setPosition(FileBuilder.getSingleton().getSourcePosition(typeCast));
			//method_metamod.addCastTypeAccess(castTypeAccess);
			
			/*
			recoder.java.Statement statement_recoder = null;
			if (typeCast instanceof recoder.java.Statement) {
				statement_recoder = (recoder.java.Statement) typeCast;
			} 
			NonTerminalProgramElement parent = typeCast;
			while ((parent != null) && (RecoderToOMMapper.getSingleton().getInstanceFromMapper(statement_recoder) == null)) {
				parent = parent.getASTParent();

				if (parent != null)
				while((parent.getASTParent()!=null)&&!(parent instanceof recoder.java.Statement)) {
					parent = parent.getASTParent();
				}
				
				if (parent instanceof recoder.java.Statement) {
					statement_recoder = (recoder.java.Statement) parent;
				} else {
					Debug.error("Statement for CastTypeAccess could not be found !");
				}
			}*/
			
			// add CastTypeAccess to corresponding metamod-Statement:
			de.fzi.sissy.metamod.Statement statement_metamod = AccessBuilder.getSingleton().findStatement(typeCast);
				
			if (statement_metamod != null) {
		        AccessBuilder.getSingleton().addAccessToCompositeAccessOrStatement(statement_metamod, typeRef_recoder, castTypeAccess);
			} else {
				Debug.warning("Metamod-Statement for CastTypeAccess was null!");
			}
		} else if (typeReference_parent instanceof Instanceof) {
			
			Instanceof instanceof_recoder = (Instanceof) typeReference_parent;
			
			de.fzi.sissy.metamod.Statement statement_metamod = AccessBuilder.getSingleton().findStatement(instanceof_recoder);
			
			RunTimeTypeAccess rtt_access =	new RunTimeTypeAccess(referenced_classType_metamod);
			Common.extractTypeArguments(rtt_access, oldType_recoder);
            rtt_access.setPosition(FileBuilder.getSingleton().getSourcePosition(instanceof_recoder));

			if (statement_metamod != null) {
		        AccessBuilder.getSingleton().addAccessToCompositeAccessOrStatement(statement_metamod, typeRef_recoder, rtt_access);
                Common.extractTypeArguments(rtt_access, oldType_recoder);

            } else {
				Debug.warning("RunTimeType Access could not be added to Statement!");
			}
			
		} else if (typeReference_parent instanceof ClassDeclaration) {
			// TODO Why do we need this part ???? 

	/*	COMMENTED OUT BY LEV: CODE DOES NOTHING
            ClassDeclaration decl = (ClassDeclaration) typeReference_parent;
			//is our accessed type the type that is declared (as opposed to a type in the extends list)?
			if (decl.getIdentifier().equals(typeRef_recoder.getIdentifier())) {
			} else {
				//is our accessed type in the extends list of that declaration?
				Extends e = decl.getExtendedTypes();
				ASTList<TypeReference> list = e.getSupertypes();
				TypeReference[] typeRefs = list.toArray(new TypeReference[0]);
				for (int i = 0; i < typeRefs.length; i++) {
					if (typeRefs[i].equals(typeRef_recoder)); // TODO: EMPTY CONTROL STATEMENT
				}
			} */
		} 
		/*else if (
			programElement instanceof InheritanceSpecification) {
			TypeReferenceMutableList list =
				((InheritanceSpecification) programElement)
					.getSupertypes();
			TypeReference[] typeRefs = list.toTypeReferenceArray();
			for (int i = 0; i < typeRefs.length; i++) {
				if (typeRefs[i].equals(typeRef_recoder)) {
					//we add an InheritanceTypeAccess
					InheritanceTypeAccess inheritanceTypeAccess = new InheritanceTypeAccess( (de.fzi.metamod.Class)classType_metamod);
					//TODO: what does the inheritanceSpecification do here???
					superClass = true;
				}//if
			}
		} */
		else if (typeReference_parent instanceof Throws) {
			ASTList<TypeReference> list = ((Throws) typeReference_parent).getExceptions();
			TypeReference[] typeRefs = list.toArray(new TypeReference[0]);
			for (int i = 0; i < typeRefs.length; i++) {
				if (typeRefs[i].equals(typeRef_recoder) && (method_metamod != null)) {
					ThrowTypeAccess throwTypeAccess = new ThrowTypeAccess(referenced_classType_metamod);
					throwTypeAccess.setPosition(FileBuilder.getSingleton().getSourcePosition(typeReference_parent));
					throwTypeAccess.setDeclared(true);
                    Common.extractTypeArguments(throwTypeAccess, oldType_recoder);

					method_metamod.addAccess(throwTypeAccess);
					
				}//if
			}
		} else if (typeReference_parent instanceof Import) {
		}
	    
        
		// end without continue
		return true;
	}
	
	/*
	 * The job of this Method is now done by AccessBuilder.walkToFindAndCreateAccesses()
	 * 
	public void extractFromRecoder(Method method_recoder) {

	    if (method_recoder instanceof MethodDeclaration) {

			Function method_metamod = (Function) RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
			
			MethodDeclaration methodDeclaration_recoder = (MethodDeclaration) method_recoder;
			
			TreeWalker treeWalker = new TreeWalker(methodDeclaration_recoder);
			
			while (treeWalker.next()) {
				ProgramElement ASTElement_recoder =	treeWalker.getProgramElement();

				if (ASTElement_recoder instanceof TypeReference) {
				} //if
			} //while
		} //if
	}
	*/
}
