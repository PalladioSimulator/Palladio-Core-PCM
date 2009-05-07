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
package de.fzi.sissy.extractors.cdt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.cdt.core.dom.ast.ASTTypeUtil;
import org.eclipse.cdt.core.dom.ast.DOMException;
import org.eclipse.cdt.core.dom.ast.IASTArraySubscriptExpression;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTCaseStatement;
import org.eclipse.cdt.core.dom.ast.IASTCastExpression;
import org.eclipse.cdt.core.dom.ast.IASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTCompoundStatement;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarationStatement;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTDoStatement;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTExpressionList;
import org.eclipse.cdt.core.dom.ast.IASTExpressionStatement;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTForStatement;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTGotoStatement;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTIfStatement;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.cdt.core.dom.ast.IASTInitializerExpression;
import org.eclipse.cdt.core.dom.ast.IASTLabelStatement;
import org.eclipse.cdt.core.dom.ast.IASTLiteralExpression;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNamedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIncludeStatement;
import org.eclipse.cdt.core.dom.ast.IASTProblem;
import org.eclipse.cdt.core.dom.ast.IASTProblemStatement;
import org.eclipse.cdt.core.dom.ast.IASTReturnStatement;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTSwitchStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.IASTUnaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTWhileStatement;
import org.eclipse.cdt.core.dom.ast.IArrayType;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.dom.ast.ICompositeType;
import org.eclipse.cdt.core.dom.ast.IEnumeration;
import org.eclipse.cdt.core.dom.ast.IFunction;
import org.eclipse.cdt.core.dom.ast.IFunctionType;
import org.eclipse.cdt.core.dom.ast.IParameter;
import org.eclipse.cdt.core.dom.ast.IPointerType;
import org.eclipse.cdt.core.dom.ast.IProblemBinding;
import org.eclipse.cdt.core.dom.ast.IQualifierType;
import org.eclipse.cdt.core.dom.ast.IScope;
import org.eclipse.cdt.core.dom.ast.IType;
import org.eclipse.cdt.core.dom.ast.IVariable;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCastExpression;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCatchHandler;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTConstructorChainInitializer;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTConstructorInitializer;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTLiteralExpression;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNewExpression;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTOperatorName;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTTryBlockStatement;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTUnaryExpression;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPBasicType;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPBinding;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPClassType;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPConstructor;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPField;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPFunction;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPMember;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPMethod;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPVariable;
import org.eclipse.cdt.core.parser.Keywords;
import org.eclipse.cdt.core.parser.util.ArrayUtil;
import org.eclipse.cdt.internal.core.dom.parser.ProblemBinding;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTCastExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTCompoundStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDefaultStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDeleteExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTEnumerationSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFieldReference;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTNamedTypeSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTProblemDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTQualifiedName;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTTemplateDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTTypeId;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPClassInstance;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPClassType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPConstructor;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPField;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPFunction;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPImplicitMethod;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPMethod;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPNamespaceScope;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPParameter;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPPointerType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPQualifierType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPReferenceType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPTypedef;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPVariable;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPVisitor;
import org.eclipse.cdt.internal.core.dom.parser.cpp.ICPPInternalBinding;

import de.fzi.sissy.metamod.Access;
import de.fzi.sissy.metamod.Array;
import de.fzi.sissy.metamod.BlockStatement;
import de.fzi.sissy.metamod.BranchStatement;
import de.fzi.sissy.metamod.CastTypeAccess;
import de.fzi.sissy.metamod.CatchBlock;
import de.fzi.sissy.metamod.CatchParameter;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.CompositeAccess;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.DeclarationTypeAccess;
import de.fzi.sissy.metamod.Destructor;
import de.fzi.sissy.metamod.ExceptionHandler;
import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.File;
import de.fzi.sissy.metamod.FormalParameter;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.GlobalFunction;
import de.fzi.sissy.metamod.GlobalVariable;
import de.fzi.sissy.metamod.InheritanceTypeAccess;
import de.fzi.sissy.metamod.JumpStatement;
import de.fzi.sissy.metamod.LocalVariable;
import de.fzi.sissy.metamod.LoopStatement;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.Reference;
import de.fzi.sissy.metamod.Root;
import de.fzi.sissy.metamod.RunTimeTypeAccess;
import de.fzi.sissy.metamod.SelfAccess;
import de.fzi.sissy.metamod.SimpleStatement;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.metamod.StaticTypeAccess;
import de.fzi.sissy.metamod.ThrowTypeAccess;
import de.fzi.sissy.metamod.Type;
import de.fzi.sissy.metamod.TypeAlias;
import de.fzi.sissy.metamod.TypeDecorator;
import de.fzi.sissy.metamod.Variable;
import de.fzi.sissy.metamod.VariableAccess;
import de.fzi.sissy.util.Debug;

/**
 * @author woelker
 * @author Mircea Trifu
 *
 */
public class MetamodConverter {
	protected ModelElementRepository repository;

	// Model Root
	Root root;

	File currentFile = null;

	IASTTranslationUnit translationUnit = null;

	/** Table for all the different types, keys are full type names */
	private Hashtable typeTable = new Hashtable();

	/** Table for all the different packages (namespace), keys are full names */
	private Hashtable packageTable = new Hashtable();

	/** Table for all the different fields, keys are full names */
	private Hashtable fieldTable = new Hashtable();

	/** Table for all the different functions, keys are full names */
	private Hashtable functionTable = new Hashtable();

	/** Table for all the different global variables, keys are full names */
	private Hashtable globalVariablesTable = new Hashtable();

	/** Mapping for all the different global variables, keys are cdt objects */
	private Hashtable globalVariablesMapping = new Hashtable();

	/** Table for all the different files, keys are full path names */
	private Hashtable filesTable = new Hashtable();

	private Hashtable fieldInitializers = new Hashtable();
	
	/**
	 * Set of all defined entities, used for determining which entities still
	 * need to be processed
	 */
	private HashSet definedEntities = new HashSet();

	private HashSet declaredEntities = new HashSet();

	/** Stack of processed functions, used for inner functions */
	private Stack functionStack = new Stack();

	private Function currentFunction = null;

	/** List of all encountered problems during parsing */
	private Set problemList = new LinkedHashSet();

	/** List of classes (Metamod) */
	private List mmClasses = new ArrayList();

	/** List of classes (CDT) */
	private List cdtClasses = new ArrayList();

	/** List of funtions (Metamod) */
	private List mmFunctions = new ArrayList();

	/** List of functions (CDT) */
	private List cdtFunctions = new ArrayList();

	private String currentFilename = null;


	private Package rootPackage;

	
	final static private String REFERENCE_MARKER = "&";
	final static private String POINTER_MARKER = "*";
	
	/**
	 * Process problems that occured during parsing or semantic analysis This
	 * function just adds them to a list
	 * 
	 * @param problem
	 */
	protected void handleProblem(Object problem) {
		if (problemList.contains(problem))
			return;
		problemList.add(problem);
	}

	/**
	 * Returns the list of all problems that occured during parsing or semantic
	 * analysis
	 * 
	 * @return list of problems
	 */
	public Set getProblems() {
		return problemList;
	}

	/**
	 * Constructor
	 * 
	 * @param repository
	 *            Metamod repository
	 */
	public MetamodConverter(ModelElementRepository repository) {
		this.repository = repository;
		this.root = repository.getRoot();
		rootPackage = new Package("");
		root.addPackage(rootPackage);
	}

	/**
	 * Maps filenames to Metamod File entitities
	 * 
	 * @param filename
	 *            Absolute filename
	 * @return File entity;
	 */
	protected File mapFile(String filename) {
		if (filesTable.containsKey(filename)) {
			return (File) filesTable.get(filename);
		} else {
			File f = new File(filename);
			filesTable.put(filename, f);
			return f;
		}
	}

	/**
	 * Convert the includes in the current translation to Metamod imports
	 * 
	 */
	private void convertIncludes() {

		File thisFile = getOrCreateFile(translationUnit.getFilePath());
		IASTPreprocessorIncludeStatement[] list = translationUnit
				.getIncludeDirectives();
		for (int i = 0; i < list.length; i++) {
			String s = list[i].getFileLocation().getFileName();
			if(s.toLowerCase().equalsIgnoreCase(thisFile.getPathName()))
			{
				thisFile.addIncludedFile(getOrCreateFile(list[i].getPath()));				
			}

		}
	}

	/**
	 * Convert a Translation Unit (typically a file)
	 * 
	 * @param translationUnit
	 */
	public void convert(IASTTranslationUnit translationUnit) {
        try {
            // clear all lists & tables
            problemList.clear();
            cdtClasses.clear();
            mmClasses.clear();
            cdtFunctions.clear();
            mmFunctions.clear();
            currentFilename = translationUnit.getFilePath();
            globalVariablesMapping.clear();
    
            // initialization
            Package currentPackage = root.getPackageByName("");
            this.translationUnit = translationUnit;
    
            // Preprocessor Problems
            IASTProblem[] problems = translationUnit.getPreprocessorProblems();
            for (int i = 0; i < problems.length; i++) 
                handleProblem(problems[i]);
    
            // Includes
            convertIncludes();
    
            // Declarations
            for (int i = 0; i < translationUnit.getDeclarations().length; i++) {
                convertDeclaration(translationUnit.getDeclarations()[i],
                        currentPackage);
            }
    
            // Now convert all classes
            for (int i = 0; i < mmClasses.size(); i++) {
                convertClass((ICPPClassType) cdtClasses.get(i),
                        (Class) mmClasses.get(i));
            }
    
            // Convert all functions
            for (int i = 0; i < mmFunctions.size(); i++) {
                convertFunctionBody((CPPFunction) cdtFunctions.get(i),
                        (Function) mmFunctions.get(i));
            }
    
            Runtime rt = Runtime.getRuntime();
            System.out.print(">>> Used memory: "+((rt.totalMemory()-rt.freeMemory())/1048576)+"MB");
    
            System.out.println(" ("+((rt.totalMemory()-rt.freeMemory())/1048576)+"MB)");
		} catch (Throwable e) {
			Debug.warning("Internal error. Parse for file " + currentFilename
					+ " aborted. Stack trace follows.");
			e.printStackTrace();
		}
	}

	private boolean isInSourcePath(String fileName) {
        return (repository.getFileList().contains(fileName) || repository.getLibFileList().contains(fileName));
	}
	
	/**
	 * Converts a declaration to a Metamod entity
	 * 
	 * @param decl
	 *            declaration to convert
	 * @param pkg
	 *            current package (namespace)
	 * @return converted ModelElement
	 */
	protected ModelElement convertDeclaration(IASTDeclaration decl, Package pkg) {
		// System.out.println("FILE: "+translationUnit.getContainingFilename());
		// System.out.println("---: "+decl.getFileLocation().getFileName());
		if (!isInSourcePath(decl.getContainingFilename()))
			return null;
		System.out.print(".");

		if (decl instanceof IASTFunctionDefinition) {
			return convertFunctionDefinition((IASTFunctionDefinition) decl, pkg);
            
		} else if (decl instanceof IASTSimpleDeclaration) {
			IASTSimpleDeclaration simpleDecl = (IASTSimpleDeclaration) decl;
			if (simpleDecl.getDeclSpecifier() instanceof IASTCompositeTypeSpecifier) {
				IASTCompositeTypeSpecifier compositeTypeSpecifier = (IASTCompositeTypeSpecifier) simpleDecl.getDeclSpecifier();
				IBinding binding = compositeTypeSpecifier.getName().resolveBinding();
				if (binding instanceof ICPPClassType) {
					ICPPClassType classType = (ICPPClassType) binding;
					Class cls = mapClass(classType);
					convertClass(classType, cls);
					pkg.addClass(cls);
					return cls;
				}
			} else if (simpleDecl.getDeclSpecifier() instanceof CPPASTSimpleDeclSpecifier) {
				if (simpleDecl.getDeclarators().length == 0) {
					return null;
				}
				IBinding binding = simpleDecl.getDeclarators()[0].getName()
						.resolveBinding();
				if (binding instanceof CPPVariable
						&& !(binding instanceof CPPField)) {
					convertGlobalVariable((CPPVariable) binding, pkg);
				} else if (binding instanceof CPPTypedef) {
					CPPTypedef typedef = (CPPTypedef)binding;
					if(pkg.getTypeAliases().findByName(typedef.getName())==null)
					{
						Type t = convertType(typedef.getType());
						if(t != null)
						{
							TypeAlias ta = new TypeAlias(t,typedef.getName());						
							pkg.addTypeAlias(ta);
						}
					}
				} else if (simpleDecl.getDeclarators()[0] instanceof ICPPASTFunctionDeclarator) {
					ICPPASTFunctionDeclarator funDec = (ICPPASTFunctionDeclarator) simpleDecl
							.getDeclarators()[0];
					binding = funDec.getName().resolveBinding();
					if (binding instanceof ICPPFunction) {
						convertGlobalFunction((ICPPFunction) binding, pkg);
					}
				}
			} else if (simpleDecl.getDeclSpecifier() instanceof CPPASTEnumerationSpecifier) {
				IBinding binding = ((CPPASTEnumerationSpecifier) simpleDecl
						.getDeclSpecifier()).getName().resolveBinding();
				if (binding instanceof IEnumeration) {
					IEnumeration enu = (IEnumeration) binding;
					convertEnum(enu);
				}
			}
		} else if (decl instanceof ICPPASTNamespaceDefinition) {
			ICPPASTNamespaceDefinition nsDef = (ICPPASTNamespaceDefinition) decl;
			IBinding binding = nsDef.getName().resolveBinding();
			try {
				Package pack = getOrCreatePackage(binding);
				pkg.addSubPackage(pack);
				for (int i = 0; i < nsDef.getDeclarations().length; i++) {
					convertDeclaration(nsDef.getDeclarations()[i], pack);
				}
				return pack;
			} catch (DOMException e) {
				e.printStackTrace();
			}
		}
		if (decl instanceof CPPASTFunctionDefinition) {
			CPPASTFunctionDefinition fundef = (CPPASTFunctionDefinition) decl;
			IBinding binding = fundef.getDeclarator().getName()
					.resolveBinding();
			return null;
		}
		if (decl instanceof CPPASTSimpleDeclaration) {
			return null;
		} else if (decl instanceof CPPASTProblemDeclaration) {
			return null;
		} else if (decl instanceof CPPASTTemplateDeclaration) {
			return null;
		}

		return null;
	}

    private ModelElement convertFunctionDefinition(IASTFunctionDefinition funcDef, Package pkg) {
        IBinding binding = funcDef.getDeclarator().getName().resolveBinding();
        
        if (binding instanceof ProblemBinding) // -- Possibly unresolved types in function head - try to resolve manually
        {
        	// Build function signature manually
        	StringBuffer name = new StringBuffer();
        	name.append(funcDef.getDeclarator().getName().toString());
        	name.append("::(");
        	org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration[] params = ((CPPASTFunctionDeclarator)funcDef.getDeclarator()).getParameters();
        	for(int j=0; j < params.length; j++)
        	{
        		String str = ASTTypeUtil.getType(params[j].getDeclarator());
        		if(str.length() == 0) // Failed to get name - get it manually
        		{
        			name.append(((CPPASTNamedTypeSpecifier)(params[j].getDeclSpecifier())).getName().toString());
        		}
        		else
        		{
        			name.append(ASTTypeUtil.getType(params[j].getDeclarator()));
        		}
        		if(j < params.length-1) name.append(", ");
        	}
        	name.append(")");
        	Function func = (Function)functionTable.get(name.toString());
        	if(func != null) // Lookup succeeded
        	{
        		convertFunctionBody((IASTCompoundStatement)funcDef.getBody(), func);
        	}
        }
        if (binding instanceof CPPMethod) {
            CPPMethod method = (CPPMethod) binding;
        	String fullName = getFullSignature(method);
            IBinding methClassBinding = null;
            Class cls = null;
            try {
            	IASTDeclaration decl = method.getPrimaryDeclaration();
            	if (decl != null)
            		methClassBinding = ((ICPPASTCompositeTypeSpecifier) decl.getParent()).getName().resolveBinding();
            } catch (Exception e1) {
				Debug.warning("Exception caught: " + e1.getClass().getCanonicalName());            	
                e1.printStackTrace();
            }
            
            if ((methClassBinding != null) && (methClassBinding instanceof ICPPClassType)) {
                ICPPClassType methClass = (ICPPClassType) methClassBinding;
                cls = mapClass(methClass);
            }
        	Function meth = null;
            if (cls != null) {
                meth = convertMethod(cls, method);
            }
                
/*        	if (functionTable.containsKey(fullName)) {
        		Object o = functionTable.get(fullName);
        		if ((o instanceof Function)) {
        			meth = (Function) o;
        		}
        	}*/
        	if (meth == null) {
        		try {
                    String out = fullName.replace("::(", "(");
        		    Debug.warning("Method not found: " + out);
                } catch (Exception e) {
					Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
                    e.printStackTrace();
                }
        		// meth = new Method(method.getName());
        		// functionTable.put(fullName, meth);
        	} else {
        		setDefined(meth);
        		mmFunctions.add(meth);
        		cdtFunctions.add(method);
        	}
        	return meth;
        }
        if (binding instanceof ICPPFunction) {
        	ICPPFunction fun = (ICPPFunction) funcDef.getDeclarator().getName().resolveBinding();
        	if (!(fun instanceof CPPMethod)
        			&& !(fun instanceof CPPImplicitMethod)) {
        		return convertGlobalFunction(fun, pkg);
        	}
        } else if (binding instanceof ProblemBinding) {
        	handleProblem(binding);
        }
        return null;
    }

	/**
	 * Converts a global variable into a Metamod entity
	 * 
	 * @param cdtVar
	 *            variable to convert
	 * @param pkg
	 *            current package
	 * @return converted ModelElement
	 */
	protected GlobalVariable convertGlobalVariable(CPPVariable cdtVar,
			Package pkg) {
		String fullName = getFullName(cdtVar);
		GlobalVariable metaVar;
		if (!globalVariablesTable.containsKey(fullName)) {
			metaVar = new GlobalVariable(cdtVar.getName());
			if (cdtVar.getType() instanceof CPPQualifierType) {
				CPPQualifierType qtype = (CPPQualifierType) cdtVar.getType();
				metaVar.setConst(qtype.isConst());
				Type vType = convertType(qtype.getType());
				if (vType != null)
					metaVar.setTypeDeclaration(new DeclarationTypeAccess(vType));
			} else {
				metaVar.setTypeDeclaration(new DeclarationTypeAccess(
						convertType(cdtVar.getType())));
				if (cdtVar.getType() instanceof CPPPointerType)					
					metaVar.setConst(((CPPPointerType)cdtVar.getType()).isConst());
			}
			if (cdtVar.getDefinition() != null) {
				metaVar.setPosition(convertFileLocation(cdtVar.getDefinition().getFileLocation()));
			}
			pkg.addGlobalVariable(metaVar);
			globalVariablesTable.put(fullName, metaVar);
		} else {
			metaVar = (GlobalVariable) globalVariablesTable.get(fullName);
		}
		globalVariablesMapping.put(cdtVar, metaVar);
		return metaVar;
	}

	/**
	 * Maps a cdt classType to a Metemod Class If the class does not exist a
	 * stub is generated that is processed and extended in a later conversion
	 * step
	 * 
	 * @param classType
	 * @return
	 */
	protected Class mapClass(ICPPClassType classType) {
		if (classType instanceof IProblemBinding) {
			handleProblem((IProblemBinding) classType);
			return null;
		}
		Class cls = getOrCreateClass(classType);
		try { // reconstruct Position
			IASTFileLocation fileLoc = null;
			if(classType instanceof CPPClassType)
				fileLoc = ((CPPClassType)classType).getDefinition().getFileLocation();
			if(classType instanceof CPPClassInstance)
				fileLoc = ((CPPClassInstance)classType).getDefinition().getFileLocation();
			if(fileLoc != null)
			{
				cls.setPosition(convertFileLocation(fileLoc));
			}
		} catch(Exception e) {/*Do nothing*/}
		cls.setPublic();
		root.addType(cls);
		if (classType instanceof CPPClassType
				&& (((CPPClassType) classType).getDefinition() != null)
				&& isInSourcePath(((CPPClassType) classType).getDefinition()
						.getContainingFilename())) {
			mmClasses.add(cls);
			cdtClasses.add(classType);
		}
		return cls;
	}

	/**
	 * Actual class conversion This function does not follow references to other
	 * classes recursively to avoid infinte recursion
	 * 
	 * @param classType
	 * @param cls
	 */
	void convertClass(ICPPClassType classType, Class cls) {
		try {
			if (isDefined(cls))
				return;
			if (classType.getFriends() != null)
				for (int i = 0; i < classType.getFriends().length; i++) {
					IBinding friend = classType.getFriends()[i];
					if (friend instanceof ICPPClassType) {
						Class me = mapClass((ICPPClassType) friend);
						cls.addFriendClass(me);
					}
					if (friend instanceof ICPPMethod) {
						// TODO: Handle friend Methods
						// Function fun = convertGlobalFunction((ICPPFunction)
						// friend, null);
						// cls.addFriendFunction(fun);
					} else if (friend instanceof ICPPFunction) {
						Function fun = convertGlobalFunction(
								(ICPPFunction) friend, null);
						cls.addFriendFunction(fun);
					}
				}
			for (int i = 0; i < classType.getNestedClasses().length; i++) {
				if (ArrayUtil.contains(classType.getFriends(), classType
						.getNestedClasses()[i]))
					continue;
				Class me = mapClass(classType.getNestedClasses()[i]);
				if (me != null)
					cls.addInnerClass(me);
			}
			if (classType.getDeclaredFields() != null)
				for (int i = 0; i < classType.getDeclaredFields().length; i++) {
					Field fld = convertField(cls,
							classType.getDeclaredFields()[i]);
					if (fld == null)
						continue;
					convertVisibility(classType.getDeclaredFields()[i], fld);
					cls.addField(fld);
				}
			if (classType.getDeclaredMethods() != null)
				for (int i = 0; i < classType.getDeclaredMethods().length; i++) {
					ICPPMethod cdtMeth = classType.getDeclaredMethods()[i];
					Function meth = null;
					if (cdtMeth instanceof ICPPConstructor) {
						// TODO: Handle constructors
						convertMethod(cls, cdtMeth);
					} else if (cdtMeth instanceof ICPPMethod) {
						meth = (Function) convertMethod(cls, cdtMeth);
						if (meth != null)
						    convertVisibility(classType.getDeclaredMethods()[i],
						            (Member)meth);
					}
					if (meth == null)
						continue;
					// cls.addMethod(meth);
				}
			for (int i = 0; i < classType.getBases().length; i++) {
				Class base = (Class) convertType((IType) classType.getBases()[i]
						.getBaseClass());
				if (base == null)
					continue;
				InheritanceTypeAccess ita = new InheritanceTypeAccess(base);
				cls.addInheritanceTypeAccess(ita);
			}
			if (cls.getPosition() == null) {
				try {
					cls
							.setPosition(convertFileLocation(((CPPClassType) classType)
									.getDefinition().getParent()
									.getFileLocation()));
				} catch (Exception ex) {/* No Position */
					Debug.warning("Exception caught: " + ex.getClass().getCanonicalName());                	
                    ex.printStackTrace();
				}
			}
			setDefined(cls);
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * Enum conversion
	 */
	public Type convertEnum(IEnumeration enu) {
		String fullName = getFullName(enu);
		if (typeTable.containsKey(fullName))
			return (Class) typeTable.get(fullName);
		else {
			Class cls = new Class(enu.getName());
			typeTable.put(fullName, cls);
			root.addType(cls);
			return cls;
		}
	}

	/**
	 * Converts the visibility/access modifiers
	 * 
	 * @param member
	 * @param mem
	 */
	protected void convertVisibility(ICPPMember member, Member mem) {
		if (member instanceof IProblemBinding)
			return;
		try {
			if (member.getVisibility() == ICPPMember.v_public) {
				mem.setPublic();
			} else if (member.getVisibility() == ICPPMember.v_protected) {
				mem.setProtected();
			} else {
				mem.setPrivate();
			}
		} catch (DOMException e) {
			e.printStackTrace();
			mem.setPrivate();
		}
	}

	/**
	 * Actual global function conversion routine
	 * 
	 * @param function
	 * @param pkg
	 * @return
	 */
	protected Function convertGlobalFunction(ICPPFunction function, Package pkg) {
		GlobalFunction func = null;
		boolean isInline = false;
		try {
			isInline = function.isInline();
		} catch (DOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CPPNamespaceScope scope = null;
		String fullName = getFullSignature(function);
		if (functionTable.containsKey(fullName)) {
			Object o = functionTable.get(fullName);
			if (!(o instanceof GlobalFunction)) {
				IASTCompoundStatement stmt = (IASTCompoundStatement) ((CPPASTFunctionDefinition) ((CPPFunction) o)
						.getDefinition().getParent()).getBody();
				Debug.error("GlobalFunction error" + stmt.toString());
			}
			func = (GlobalFunction) o;
			if (pkg != null)
				pkg.addGlobalFunction(func);
			return func;
		}
		try {
			func = getOrCreateGlobalFunction(function);
			Type retTyp = convertType(function.getType().getReturnType());
			if (retTyp != null)
				func
						.setReturnTypeDeclaration(new DeclarationTypeAccess(
								retTyp));
			for (int i = 0; i < function.getParameters().length; i++) {
				IParameter cdtParam = function.getParameters()[i];
				Type parType = convertType(cdtParam.getType());
				if (parType != null) {

					FormalParameter fp = new FormalParameter(cdtParam.getName());
					DeclarationTypeAccess dta = new DeclarationTypeAccess(parType);
					if (cdtParam instanceof CPPParameter) {
						CPPParameter param = (CPPParameter) cdtParam;
						if(param.getDeclarations()[0] != null)
						{
							Position pos = convertFileLocation(param.getDeclarations()[0].getFileLocation());
							if(pos!=null)
							{
								fp.setPosition(pos);
								dta.setPosition(pos);
							}
						}
					}
					fp.setTypeDeclaration(dta);
					func.addFormalParameter(fp);
				} else {
				    Debug.error("Converting parameter failed");
                    Debug.error("Parameter: " + cdtParam.getName() + " in function: " + function.getName());
                }

			}
			if (function instanceof CPPFunction) {
				if (((CPPFunction) function).getDefinition() != null) {
					func.setPosition(convertFileLocation(((CPPFunction) function)
							.getDefinition().getFileLocation()));
				}
				if (func.getPosition() == null) {
					if (((CPPFunction) function).getDeclarations() != null) {
						Position pos = convertFileLocation(((CPPFunction) function)
								.getDeclarations()[0].getFileLocation());
						func.setPosition(pos);
						if(func.getReturnTypeDeclaration()!= null) func.getReturnTypeDeclaration().setPosition(pos);
					}
				}
			}
			if (pkg != null)
				pkg.addGlobalFunction(func);
			if (func.getPosition() != null
					&& isInSourcePath(func.getPosition().getSourceFile().getPathName()))
			{
				mmFunctions.add(func);
				cdtFunctions.add(function);
			}
		} catch (Exception e) {
			Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
			e.printStackTrace();
		}
		return func;
	}

	/**
	 * Converts the body of a function from CDT to Metamod entities
	 * 
	 * @param func
	 *            CDT function
	 * @param mfunc
	 *            Metamod function
	 * @param decl
	 */
	protected void convertFunctionBody(CPPFunction func, Function mfunc) {
		if(mfunc == null)
		{
			System.err.println(func);
			return;
		}
		functionStack.push(mfunc);
		currentFunction = mfunc;
        // convert parameter names
		int max = mfunc.getFormalParameters().size();
		if (max > func.getParameters().length)
			max = func.getParameters().length;
        for (int i=0; i<max; i++) {
            FormalParameter fp = (FormalParameter) mfunc.getFormalParameters().get(i);
           	fp.setSimpleName(func.getParameters()[i].getName());
        }
		try {
			if (mfunc instanceof Constructor && ((Constructor)mfunc).isInitializer()) {
				Statement s = ((Statement)mfunc.getBody().getStatements().get(0));
				ModelElementList accList = s.getAccesses();
				IASTInitializer init = (IASTInitializer)fieldInitializers.get(mfunc);
				if (init instanceof IASTInitializerExpression)
					accList.addAll(convertExpression(((IASTInitializerExpression)init).getExpression(), false));
				s.setAccesses(accList);					
			}
			else {
				IASTNode def;
				def = func.getDefinition();
				if (def != null && def.getParent() != null) {
					IASTFileLocation loc = def.getParent().getFileLocation();
					mfunc.setPosition(convertFileLocation(loc));
					if (mfunc.getBody() == null) {
						mfunc
								.setBody((BlockStatement) convertBlockStatement((IASTCompoundStatement) ((CPPASTFunctionDefinition) def
										.getParent()).getBody()));
					}
	
				}
			}
		} catch (Exception e) {
			Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
			e.printStackTrace();
		}
		functionStack.pop();
		currentFunction = null;
	}

	protected void convertFunctionBody(IASTCompoundStatement body, Function mfunc) {
		if(mfunc == null)
		{
			System.err.println("func");
			return;
		}
		functionStack.push(mfunc);
		currentFunction = mfunc;
		try {
//				mfunc.setPosition(convertFileLocation(loc));
				if (body != null) {
					mfunc.setBody((BlockStatement) convertBlockStatement(body));
				}

		} catch (Exception e) {
			Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
			e.printStackTrace();
		}
		functionStack.pop();
		currentFunction = null;
	}
	/**
	 * Converts a CDT Statement to a Metamod Statement
	 * 
	 * @param stmt
	 * @return
	 */
	protected Statement convertStatement(IASTStatement stmt, BlockStatement parentMetaStmt) {
		if (stmt instanceof IASTDeclarationStatement) {
			
            IASTDeclarationStatement declstmt = (IASTDeclarationStatement) stmt;
			if (declstmt.getDeclaration() instanceof IASTSimpleDeclaration && 
                    (((IASTSimpleDeclaration) declstmt.getDeclaration()).getDeclarators().length > 0) &&
                    (((IASTSimpleDeclaration) declstmt.getDeclaration()).getDeclarators()[0]
                                                    .getName().resolveBinding() instanceof IVariable)) {
				IASTSimpleDeclaration simpleDecl = (IASTSimpleDeclaration) declstmt.getDeclaration();
                return convertSimpleDeclaration(simpleDecl);
			}
            
		} else if (stmt instanceof IASTIfStatement) {
			return convertIfStatement(parentMetaStmt, (IASTIfStatement) stmt);
		} else if (stmt instanceof IASTForStatement) {
			return convertForStatement(parentMetaStmt, (IASTForStatement) stmt);
		} else if (stmt instanceof IASTDoStatement) {
			return convertDoStatement(parentMetaStmt, (IASTDoStatement) stmt);
		} else if (stmt instanceof IASTWhileStatement) {
			return convertWhileStatement(parentMetaStmt, (IASTWhileStatement) stmt);
		} else if (stmt instanceof IASTCompoundStatement) {
			return convertBlockStatement((IASTCompoundStatement) stmt);
		} else if (stmt instanceof IASTLabelStatement) {
			// For now, return the nested statement
			return convertStatement(((IASTLabelStatement) stmt).getNestedStatement(), parentMetaStmt);
		} else if (stmt instanceof ICPPASTTryBlockStatement) {
			return convertTryBlockStatement(parentMetaStmt, (ICPPASTTryBlockStatement) stmt);
		} else if (stmt instanceof IASTSwitchStatement) {
            return convertSwitchStatement(parentMetaStmt, (IASTSwitchStatement) stmt);
		} else if (stmt instanceof IASTExpressionStatement) {
			return convertExpressionStatement((IASTExpressionStatement) stmt);
		} else if (stmt instanceof IASTReturnStatement) {
			return convertReturnStatement((IASTReturnStatement) stmt);
		} else if (stmt instanceof IASTGotoStatement) {
			return convertGotoStatement(stmt);
		} else if (stmt instanceof IASTProblemStatement) {
			return convertProblemStatement((IASTProblemStatement) stmt);
		}
		Statement metastmt = new SimpleStatement();
		metastmt.setPosition(convertFileLocation(stmt.getFileLocation()));
		return metastmt;
	}

    private Statement convertSimpleDeclaration(IASTSimpleDeclaration simpleDecl) {
        Statement metastmt = new SimpleStatement();
        metastmt.setPosition(convertFileLocation(simpleDecl.getFileLocation()));
        ModelElementList accList = new ModelElementList();
        for (int i = 0; i < simpleDecl.getDeclarators().length; i++) {
        	IASTDeclarator declarator = simpleDecl.getDeclarators()[i];
        	LocalVariable metaVar = null;
        	if(declarator.getName()	.resolveBinding() instanceof IVariable)
        	{
        		IVariable var = (IVariable) declarator.getName().resolveBinding();
        		metaVar = new LocalVariable(var.getName());
        		Type vType = null;
                try {
                    vType = convertType(var.getType());
                } catch (DOMException e1) {
                    e1.printStackTrace();
                }
        		metaVar.setTypeDeclaration(new DeclarationTypeAccess(vType));
        		
                Position p = null;
                try {
                    p = convertFileLocation(var.getScope().getPhysicalNode().getFileLocation());
                } catch (DOMException e) {
                    e.printStackTrace();
                }
                metaVar.setPosition(p);
        		currentFunction.addLocalVariable(metaVar);
        		if(declarator.getInitializer() instanceof ICPPASTConstructorInitializer)
        		{
        			ICPPASTConstructorInitializer init = (ICPPASTConstructorInitializer)declarator.getInitializer();
        			// TODO: Get accessed Constructor
        			// Unfortunately there seems to be no direct way to determine the constructor used to initialize the variable...do it by hand then
        			String className = "";
                    try {
                        className = ASTTypeUtil.getType(var.getType());
                    } catch (DOMException e) {
                        e.printStackTrace();
                    }

        			StringBuffer str = new StringBuffer(className+"::"+className+"::(");

        			IASTExpression expr = init.getExpression();
        			if(expr instanceof IASTExpressionList)
        			{
        				IASTExpression[] exprlist = ((IASTExpressionList)expr).getExpressions();
        				int j;
        				for(j = 0; j<exprlist.length; j++)
        				{
        					str.append(ASTTypeUtil.getType(CPPVisitor.getExpressionType(exprlist[j])));
        					str.append(", ");
        				}
        				str.delete(str.length()-2,str.length());
        			}
        			else
        			{
        				str.append(ASTTypeUtil.getType(CPPVisitor.getExpressionType(expr)));
        			}
        			str.append(")");
        			Function func = (Function)functionTable.get(str.toString());
        			if(func != null)
        			{
        				accList.add(new FunctionAccess(func));
        				if(expr instanceof IASTExpressionList)
        				{
        					accList.addAll(convertExpression(expr,false));
        				}
        				else
        				{
        					CompositeAccess compAcc = new CompositeAccess();
        					compAcc.setAccesses(convertExpression(expr,false));
        					accList.add(compAcc);
        				}
        			}
        		}
        	}
        	if(declarator.getInitializer() instanceof IASTInitializerExpression)
        	{
        		IASTInitializerExpression init = (IASTInitializerExpression)declarator.getInitializer();
        		if(init != null)
        		{
        			if (metaVar != null)
        				accList.add(new VariableAccess(metaVar, true));
        			accList.addAll(convertExpression(init.getExpression(), false));							
        			metastmt.setAccesses(accList);
        		}
        	}
        }
        metastmt.setAccesses(accList);
        return metastmt;
    }

    private Statement convertIfStatement(BlockStatement parentMetaStmt, IASTIfStatement ifstmt) {
        BranchStatement metastmt = new BranchStatement();
        metastmt.setAccesses(convertExpression(ifstmt.getConditionExpression(),
        		false));
        metastmt.addBranch(convertStatement(ifstmt.getThenClause(), parentMetaStmt));
        if (ifstmt.getElseClause() == null) {
        	// -- no else, create empty statement
        	Statement elseStmt = new BlockStatement();
        	Position pos = convertFileLocation(ifstmt.getFileLocation());
        	if (pos != null) {
        		pos.setStartLine(pos.getEndLine());
        	}
        	elseStmt.setPosition(pos);
        	metastmt.addBranch(elseStmt);
        } else {
        	metastmt.addBranch(convertStatement(ifstmt.getElseClause(), parentMetaStmt));
        }
        metastmt.setPosition(convertFileLocation(ifstmt.getFileLocation()));
        return metastmt;
    }

    private Statement convertForStatement(BlockStatement parentMetaStmt, IASTForStatement forstmt) {
        LoopStatement metastmt = new LoopStatement();

        // -- Fill in accesses (init, iter,cond)
        ModelElementList accList = new ModelElementList();

        // get accesses from forstmt.getInitializerStatement() but do not create an additional statement
        Statement initStmt = convertStatement(forstmt.getInitializerStatement(), parentMetaStmt);
        initStmt.setPosition(convertFileLocation(forstmt.getInitializerStatement().getFileLocation()));
        parentMetaStmt.addStatement(initStmt);
/*			accList.addAll(initStmt.getAccesses());	
        initStmt.setAccesses(new ModelElementList());*/

        accList.addAll(convertExpression(forstmt.getIterationExpression(),false));
        accList.addAll(convertExpression(forstmt.getConditionExpression(),false));
        metastmt.setAccesses(accList);
        
        // -- handle Block
        metastmt.setBody(convertStatement(forstmt.getBody(), parentMetaStmt));

        metastmt.setPosition(convertFileLocation(forstmt.getFileLocation()));
        return metastmt;
    }

    private Statement convertDoStatement(BlockStatement parentMetaStmt, IASTDoStatement dostmt) {
        LoopStatement metastmt = new LoopStatement();
        metastmt.setAccesses(convertExpression(dostmt.getCondition(), false));
        metastmt.setBody(convertStatement(dostmt.getBody(), parentMetaStmt));
        metastmt.setPosition(convertFileLocation(dostmt.getFileLocation()));
        return metastmt;
    }

    private Statement convertWhileStatement(BlockStatement parentMetaStmt, IASTWhileStatement whilestmt) {
        LoopStatement metastmt = new LoopStatement();
        metastmt.setAccesses(convertExpression(whilestmt.getCondition(), false));
        metastmt.setBody(convertStatement(whilestmt.getBody(), parentMetaStmt));
        metastmt.setPosition(convertFileLocation(whilestmt.getFileLocation()));
        return metastmt;
    }

    private Statement convertTryBlockStatement(BlockStatement parentMetaStmt, ICPPASTTryBlockStatement trystmt) {
        ExceptionHandler exHandler = new ExceptionHandler();
        exHandler.setPosition(convertFileLocation(trystmt.getFileLocation()));
        exHandler.setGuardedBlock((BlockStatement)convertStatement(trystmt.getTryBody(), parentMetaStmt));
        for (int i = 0; i < trystmt.getCatchHandlers().length; i++) {
        	try {
        		ICPPASTCatchHandler handler = trystmt.getCatchHandlers()[i];
        		IASTDeclaration tdecl = handler.getDeclaration();
        		IBinding binding = null;
        		if (tdecl != null)
        			binding = ((IASTSimpleDeclaration)tdecl).getDeclarators()[0].getName().resolveBinding();
        		CatchBlock catchblock = new CatchBlock();
        		if (binding != null) {
	        		CPPVariable var = (CPPVariable) binding;
	        		CatchParameter metaVar = new CatchParameter(var.getName());
	        		metaVar.setTypeDeclaration(new DeclarationTypeAccess(convertType(var.getType())));
	        		metaVar.setPosition(convertFileLocation(var.getDefinition().getFileLocation()));
	        		catchblock.setCatchParameter(metaVar);
        		}
        		convertBlockStatement((IASTCompoundStatement)handler.getCatchBody(),catchblock);
        		catchblock.setPosition(convertFileLocation(handler.getFileLocation()));
        		exHandler.addCatchBlock(catchblock);
        	} catch (Exception e) {
				Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
                e.printStackTrace();
        	}

        }
        return exHandler;
    }

    private Statement convertSwitchStatement(BlockStatement parentMetaStmt, IASTSwitchStatement switchstmt) {
        // For now, return the nested statement
        BranchStatement metastmt = new BranchStatement();
        metastmt.setPosition(convertFileLocation(switchstmt.getFileLocation()));
        metastmt.setAccesses(convertExpression(switchstmt.getControllerExpression(), false));
        IASTStatement body = switchstmt.getBody();

        boolean defaultFound = false;
        if (body instanceof CPPASTCompoundStatement) {
        	IASTStatement[] stmts = ((CPPASTCompoundStatement) body).getStatements();
        	for (int i = 0; i < stmts.length; i++) {
        		IASTStatement cstmt = stmts[i];
        		if (cstmt instanceof CPPASTDefaultStatement) {
        			defaultFound = true;
        			continue;
        		}
        		if (cstmt instanceof IASTCaseStatement)
        			continue;
        		metastmt.addBranch(convertStatement(cstmt, parentMetaStmt));
        	}
        } else {
        	metastmt.addBranch(convertStatement(body, parentMetaStmt));
        }

        // Add empty default branch when it is missing
        // TODO: Position of default branch?
        if (!defaultFound) {
        	BlockStatement st = new BlockStatement();
        	metastmt.addBranch(st);
        }
        return metastmt;
    }

    private Statement convertExpressionStatement(IASTExpressionStatement exstmt) {
        IASTExpression expression = exstmt.getExpression();
        ModelElementList list = convertExpression(expression, false);
        Statement metastmt;
        // -- Handle throw statements
        if(!list.isEmpty() && list.get(0) instanceof ThrowTypeAccess)
        {
        	metastmt = new JumpStatement();
        }
        else
        {
        	metastmt = new SimpleStatement();
        }
        metastmt.setPosition(convertFileLocation(exstmt.getFileLocation()));
        metastmt.setAccesses(list);
        return metastmt;
    }

    private Statement convertProblemStatement(IASTProblemStatement stmt) {
        Debug.error(stmt.getProblem().getMessage());
        Statement metastmt = new SimpleStatement();
        metastmt.setPosition(convertFileLocation(stmt.getFileLocation()));
        return metastmt;
    }

    private Statement convertGotoStatement(IASTStatement stmt) {
        Statement metastmt = new JumpStatement();
        metastmt.setPosition(convertFileLocation(stmt.getFileLocation()));			
        return metastmt;
    }

    private Statement convertReturnStatement(IASTReturnStatement stmt) {
        IASTExpression expression = stmt.getReturnValue();
        Statement metastmt = new JumpStatement();
        metastmt.setPosition(convertFileLocation(stmt.getFileLocation()));
        ModelElementList list = convertExpression(expression, false);
        metastmt.setAccesses(list);
        return metastmt;
    }

	/**
	 * Converts an CDT expression to a Metamod Access entity
	 * 
	 * @param exp
	 * @return
	 */
	protected ModelElementList convertExpression(IASTExpression exp, boolean isWrite) {

		ModelElementList list = new ModelElementList();
		if (exp instanceof IASTBinaryExpression) {
			IASTBinaryExpression binexp = (IASTBinaryExpression) exp;
			int op = binexp.getOperator();
			ModelElementList acc1 = convertExpression(binexp.getOperand1(),
					(op == IASTBinaryExpression.op_assign)
							|| (op == IASTBinaryExpression.op_divideAssign)
							|| (op == IASTBinaryExpression.op_minusAssign)
							|| (op == IASTBinaryExpression.op_multiplyAssign)
							|| (op == IASTBinaryExpression.op_plusAssign)
							|| (op == IASTBinaryExpression.op_binaryAndAssign)
							|| (op == IASTBinaryExpression.op_binaryOrAssign)
							|| (op == IASTBinaryExpression.op_binaryXorAssign)
							|| (op == IASTBinaryExpression.op_moduloAssign)
							|| (op == IASTBinaryExpression.op_shiftLeftAssign)
							|| (op == IASTBinaryExpression.op_shiftRightAssign));
			ModelElementList acc2 = convertExpression(binexp.getOperand2(), false);
			list.addAll(acc1);
			list.addAll(acc2);				
		} else if (exp instanceof IASTCastExpression) {
			  CPPASTCastExpression castExp = (CPPASTCastExpression) exp; 
			  CPPASTTypeId tid = (CPPASTTypeId)castExp.getTypeId();
			  Type type = convertType(CPPVisitor.createType(tid));
			  
			  list.add(new CastTypeAccess(type));
			  if(castExp.getOperator() == ICPPASTCastExpression.op_dynamic_cast)
			  {
				  list.add(new RunTimeTypeAccess(type));				  
			  }
			  list.addAll(convertExpression(castExp.getOperand(), false));
			 
		} else if (exp instanceof IASTUnaryExpression) {
			IASTUnaryExpression unexp = (IASTUnaryExpression) exp;
			int op = unexp.getOperator();
			list.addAll(convertExpression(unexp.getOperand(),isWrite ||
					(op == IASTUnaryExpression.op_postFixDecr)
							|| (op == IASTUnaryExpression.op_postFixIncr)
							|| (op == IASTUnaryExpression.op_prefixDecr)
							|| (op == IASTUnaryExpression.op_prefixIncr)));

			if(op == ICPPASTUnaryExpression.op_throw)
			{
				IType type = CPPVisitor.getExpressionType(unexp.getOperand());
				list.add(new ThrowTypeAccess(convertType(type)));
			}
			return list; 
		} else if (exp instanceof IASTIdExpression) {
			IASTIdExpression id = (IASTIdExpression) exp;
			IBinding bind = id.getName().resolveBinding();
			if (bind instanceof ICPPVariable) {
				ICPPVariable var = (ICPPVariable) bind;
				ModelElement mmVar = null;
				mmVar = currentFunction.getFormalParameters().findByName(
						var.getName());
				if (mmVar == null)
					mmVar = currentFunction.getLocalVariables().findByName(
							var.getName());
				if (mmVar == null && globalVariablesMapping.containsKey(var))
					mmVar = (Variable) globalVariablesMapping.get(var);
				if (mmVar == null && var instanceof CPPField) {
					CPPField field = (CPPField) var;
					Field mmFld = (Field) fieldTable.get(getFullName(field));
					if (mmFld == null)
						return list;
					mmVar = mmFld;
					if ((id.getName() instanceof CPPASTQualifiedName)) {
						if (mmFld.isStatic())
							list.add(new StaticTypeAccess(mmFld.getSurroundingClass()));
					}
					else if (currentFunction instanceof Member)
					{
						SelfAccess selfAccess = new SelfAccess(((Member)currentFunction).getSurroundingClass());
						list.add(selfAccess);
					}
				}
				if (mmVar == null && var instanceof CPPVariable) {
					mmVar = convertGlobalVariable((CPPVariable)var, rootPackage);
				}
				if (mmVar == null && var instanceof CPPVariable.CPPVariableDelegate) {
					bind = ((CPPVariable.CPPVariableDelegate)var).getBinding();
					if (bind instanceof CPPVariable)
						mmVar = convertGlobalVariable((CPPVariable)bind, rootPackage);
				}
				if (mmVar != null) {
					list.add(new VariableAccess((Variable) mmVar, isWrite));
					return list;
				} else {					
					Debug.error("Var Access is null: " + var.getName() + "(" + var.getClass().getName() + ")");
					Debug.error("Containing function: " + currentFunction.signature().toString());
					Debug.error(currentFunction.getFormalParameters().toString());					
				}
				return list;
			} else if (bind instanceof CPPFunction) {
				CPPFunction function = (CPPFunction) bind;
				return convertFunctionBinding(function, id.getName() instanceof CPPASTQualifiedName);
			}
			/*
			else if (bind instanceof IProblemBinding) {
				Debug.warning("Access to failed dep variable / function.");
			}
			*/
		} else if (exp instanceof IASTExpressionList) {
			IASTExpressionList expList = (IASTExpressionList) exp;
			for (int i = 0; i < expList.getExpressions().length; i++) {
				CompositeAccess acc = new CompositeAccess();
				acc.setAccesses(convertExpression(expList.getExpressions()[i],
						false));
				list.add(acc);
			}
			return list;
		} else if (exp instanceof IASTFunctionCallExpression) {
			IASTFunctionCallExpression funcall = (IASTFunctionCallExpression) exp;
			ModelElementList funcList = convertExpression(funcall.getFunctionNameExpression(), false);
			// -- Handling of Self-Accesses
			if (funcList.size() > 0)
				if(funcall.getFunctionNameExpression() instanceof IASTIdExpression && ((Access)funcList.get(0)).getAccessedTarget() instanceof Method)
					if (currentFunction instanceof Member)
					{
						SelfAccess selfAccess = new SelfAccess(((Member)currentFunction).getSurroundingClass());
						list.add(selfAccess);
					}
			list.addAll(funcList);
			if(funcall.getParameterExpression() instanceof IASTExpressionList)
			{
				list.addAll(convertExpression(funcall.getParameterExpression(), false));
			}
			else if(funcall.getParameterExpression() != null)
			{
				CompositeAccess compAcc = new CompositeAccess();
				compAcc.setAccesses(convertExpression(funcall.getParameterExpression(), false));
				list.add(compAcc);
			}
			return list;
		} else if (exp instanceof ICPPASTNewExpression) {
			ICPPASTNewExpression conCall = (ICPPASTNewExpression)exp;
			if (conCall.isNewTypeId()) {
				IASTDeclSpecifier dspec = conCall.getTypeId().getDeclSpecifier();
				if (dspec instanceof IASTNamedTypeSpecifier) {
					IBinding bind = ((IASTNamedTypeSpecifier)dspec).getName().resolveBinding();
					if (bind instanceof CPPFunction) {
						list.addAll(convertFunctionBinding((CPPFunction)bind, false));
						if (conCall.getNewInitializer() instanceof IASTExpressionList)
							list.addAll(convertExpression(conCall.getNewInitializer(), false));
						else if (conCall.getNewInitializer() != null) {
							CompositeAccess compAcc = new CompositeAccess();
							compAcc.setAccesses(convertExpression(conCall.getNewInitializer(), false));
							list.add(compAcc);							
						}
					}
					/*
					else if (bind instanceof IProblemBinding) {
						Debug.warning("Access to failed dep constructor.");
					}
					*/
				}				
			}
			return list;
		} else if (exp instanceof CPPASTFieldReference) {
			CPPASTFieldReference ref = (CPPASTFieldReference) exp;

			list.addAll(convertExpression(ref.getFieldOwner(), false));
			IBinding bind = ref.getFieldName().resolveBinding();
			if (bind instanceof CPPField) {
				CPPField field = (CPPField) bind;
				Field mmFld = (Field) fieldTable.get(getFullName(field));
				if (list.size() > 0)
					if (list.get(0) instanceof SelfAccess)
						if (ref.getFieldName() instanceof CPPASTQualifiedName) {
							IASTName[] names = ((CPPASTQualifiedName)ref.getFieldName()).getNames();
							if (names.length > 1) {
								de.fzi.sissy.metamod.Class mmcls = getOrCreateClass((ICPPClassType)names[names.length - 2].resolveBinding());
								SelfAccess sa = (SelfAccess)list.get(0);
								if (currentFunction instanceof Member)
									if (((Member)currentFunction).getSurroundingClass().extendsClass(mmcls))
										sa.setSuperAccess(true);
							}
						}
				list.add(new VariableAccess((Variable) mmFld, isWrite));
				return list;
			} else if (bind instanceof CPPFunction) {
				CPPFunction function = (CPPFunction) bind;
				if (list.size() > 0)
					if (list.get(0) instanceof SelfAccess)
						if (ref.getFieldName() instanceof CPPASTQualifiedName) {
							IASTName[] names = ((CPPASTQualifiedName)ref.getFieldName()).getNames();
							if (names.length > 1) {
								de.fzi.sissy.metamod.Class mmcls = getOrCreateClass((ICPPClassType)names[names.length - 2].resolveBinding());
								SelfAccess sa = (SelfAccess)list.get(0);
								if (currentFunction instanceof Member)
									if (((Member)currentFunction).getSurroundingClass().extendsClass(mmcls))
										sa.setSuperAccess(true);
							}
						}
				list.addAll(convertFunctionBinding(function, false));
				return list;
			} else {
				if (bind instanceof IProblemBinding) { // -- Handle Failed Dependencies in members
					IProblemBinding problem = (IProblemBinding)bind;
					IType type = CPPVisitor.getExpressionType((ref.getFieldOwner()));
					Type metaType = convertType(type);
					if(metaType != null) // Found a class
					{
						while(metaType instanceof TypeDecorator) metaType = ((TypeDecorator)metaType).getDecoratedType();
						String name = problem.getASTNode().getRawSignature();			
						if(problem.getASTNode().getParent().getParent() instanceof IASTFunctionCallExpression)
						{ // Seems to be a method
							Method met =  getOrCreateFailedDepMethod((Class)metaType, name);
							list.add(new FunctionAccess(met));
						}
						else
						{ // just a field
							Variable var = getOrCreateFailedDepField((Class)metaType, name);
							list.add(new VariableAccess((Variable) var, isWrite));
						}
					}
					//Debug.warning("Access to failed dep member found.");
					
				}
				return list;
			}
		} else if (exp instanceof IASTLiteralExpression || exp == null) {
			if (exp == null || ((IASTLiteralExpression)exp).getKind() == ICPPASTLiteralExpression.lk_this) {
				if (currentFunction instanceof Member)
					list.add(new SelfAccess(((Member)currentFunction).getSurroundingClass()));
			}
			return list; // No access
		} else if (exp instanceof IASTArraySubscriptExpression) {
			return convertExpression(((IASTArraySubscriptExpression) exp)
					.getArrayExpression(), false);
		} else if (exp instanceof CPPASTDeleteExpression) {
			return convertExpression(((CPPASTDeleteExpression) exp)
					.getOperand(), false);
		}

		return list;
	}

	protected ModelElementList convertFunctionBinding(CPPFunction bind, boolean qualified) {
		ModelElementList list = new ModelElementList();
		String s = getFullSignature((CPPFunction) bind);
		Function func = (Function) functionTable.get(s);
		if (func != null)
		{
			if (func instanceof Method && ((Method) func).isStatic()) {
				Method meth = (Method) func;
				Type cls = (Type) meth.getParent();
				
				if (qualified)
					list.add(new StaticTypeAccess(cls));
			}
			if(func instanceof Constructor)
			{
				Constructor cons = (Constructor) func;
				// list.add(new StaticTypeAccess((Type)cons.getSurroundingClass()));
			}
			FunctionAccess fa = new FunctionAccess(func);
			list.add(fa);
		}
		else
		{
			if (!(bind instanceof ICPPMethod)) {
				func = convertGlobalFunction((CPPFunction) bind, rootPackage);
			}
			else
			{
				func = convertMethod((ICPPMethod)bind);
			}
			FunctionAccess fa = new FunctionAccess(func);
			list.add(fa);
		}
		return list;
	}

    protected Statement convertBlockStatement(IASTCompoundStatement stmt, BlockStatement metastmt) {
		metastmt.setPosition(convertFileLocation(stmt.getFileLocation()));
		for (int i = 0; i < stmt.getStatements().length; i++) {
			Statement s = convertStatement(stmt.getStatements()[i],metastmt);
			metastmt.addStatement(s);

		}
		return metastmt;
	}
    
    /**
	 * Converts a CDT CompoundStatement to a Metamod Block Statement
	 * 
	 * @param stmt
	 * @return
	 */
	protected Statement convertBlockStatement(IASTCompoundStatement stmt) {
		BlockStatement metastmt = new BlockStatement();
		return convertBlockStatement(stmt, metastmt);
	}
    
	protected Function convertMethod(ICPPMethod met)
	{
		if (met instanceof IProblemBinding) {
			handleProblem((IProblemBinding) met);
			return null;
		}
		String fullName = getFullSignature(met);
		if (functionTable.containsKey(fullName)) {
			Object o = functionTable.get(fullName);
			return (Function) o;		
		}
		try {			
			IASTDeclaration decl = null;
			if (met instanceof CPPMethod)
				decl = (IASTDeclaration)((CPPMethod)met).getPrimaryDeclaration().getParent().getParent();
			else if (met instanceof CPPImplicitMethod)
				decl = (IASTDeclaration)((CPPImplicitMethod)met).getScope().getPhysicalNode().getParent();							
			IASTNode n = ((CPPASTSimpleDeclaration)decl).getDeclSpecifier();
			IType type = CPPVisitor.createType((IASTDeclSpecifier)(n));
			if(type instanceof CPPClassType)
			{
				Class cls = mapClass((CPPClassType)type);
				return convertMethod(cls, met);
			}
			return null;
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        
    private boolean isMethodVirtual(ICPPMethod method) {
        try {
            if (method.isVirtual())
                return true;
        } catch (DOMException e) {
            e.printStackTrace();
        }
        return false;
    }
        
	/**
	 * Converts a CDT Method to a Metamod Method
	 * 
	 * @param cls
	 * @param method
	 * @return
	 */
	protected Function convertMethod(Class cls, ICPPMethod method) {
		Function meth = null;
		if (method instanceof IProblemBinding) {
			handleProblem((IProblemBinding) method);
			return null;
		}
		String fullName = getFullSignature(method);
		if (functionTable.containsKey(fullName)) {
			Object o = functionTable.get(fullName);
			meth = (Function) o;
		} else {
			meth = getOrCreateMethod(cls, method);
		}
        if (meth == null)
            return null;
		try {
			if (!isDeclared(meth)) {
				setDeclared(meth);
				ICPPASTFunctionDeclarator declarator = null;
				if (method instanceof CPPFunction) {
					if (((CPPFunction) method).getDeclarations() != null
							&& ((CPPFunction) method).getDeclarations().length > 0) {
						declarator = (ICPPASTFunctionDeclarator) ((CPPFunction) method)
								.getDeclarations()[0];
						if (((CPPFunction) method).getDeclarations().length > 0
								&& meth.getPosition() != null) {
							meth
									.setPosition(convertFileLocation(((CPPFunction) method)
											.getDeclarations()[0]
											.getFileLocation()));
						}
					} else {
						declarator = (ICPPASTFunctionDeclarator) ((CPPFunction) method)
								.getDefinition();
					}
					if (declarator != null) {
						if (meth instanceof Method) {
							try {
								((Method) meth).setOperator(declarator.getName() instanceof ICPPASTOperatorName);
								((Method) meth).setAbstract(declarator.isPureVirtual());
								((Method) meth).setVirtual(method.isVirtual());
								((Method) meth).setStatic(method.isStatic());
							} catch (Exception ex) {/*Nothing*/
								Debug.warning("Exception caught: " + ex.getClass().getCanonicalName());
			                    ex.printStackTrace();
							}
						}
						else if (meth instanceof Destructor) {
							boolean isVirtual = method.isVirtual();
							try { // Cirumenvent CDT Bug with virtual destructors
								isVirtual = ((CPPASTSimpleDeclSpecifier)((CPPASTSimpleDeclaration)declarator.getParent()).getDeclSpecifier()).isVirtual();
							} catch(Exception e) {/*Nothing*/}
							((Destructor) meth).setVirtual(isVirtual);
						}
						Type retType = convertType(method.getType().getReturnType());
						if (retType != null)
							meth.setReturnTypeDeclaration(new DeclarationTypeAccess(retType));
					}
					for (int i = 0; i < method.getParameters().length; i++) {
						IParameter cdtParam = method.getParameters()[i];
						Type parType = convertType(cdtParam.getType());

						if (parType != null) {
							if(parType.getSimpleName().equals("void")) continue;	// No void parameters
							FormalParameter fp = new FormalParameter(cdtParam.getName());
							DeclarationTypeAccess dta = new DeclarationTypeAccess(parType);
							if (cdtParam instanceof CPPParameter) {
								CPPParameter param = (CPPParameter) cdtParam;
								if ((param.getDeclarations() != null) && (param.getDeclarations().length > 0))
									if(param.getDeclarations()[0] != null)
									{
										Position pos = convertFileLocation(param.getDeclarations()[0].getFileLocation());
										if(pos!=null)
										{
											fp.setPosition(pos);
											dta.setPosition(pos);
										}
									}
							}
							fp.setTypeDeclaration(dta);
							meth.addFormalParameter(fp);

						}
					}
					if (declarator != null) {
						// Add Constructor chain accesses
						ICPPASTConstructorChainInitializer[] chain = declarator.getConstructorChain();
						for(int i = 0; i<chain.length; i++)
						{
							IBinding bind = chain[i].getMemberInitializerId().resolveBinding();
							ModelElementList list = new ModelElementList();
							if (bind instanceof CPPFunction) {
								list = convertFunctionBinding((CPPFunction)bind, false);
								Function oldFunc = currentFunction;
								currentFunction = meth;
								if (chain[i].getInitializerValue() instanceof IASTExpressionList)
									list.addAll(convertExpression(chain[i].getInitializerValue(), false));
								else if (chain[i].getInitializerValue() != null) {
									CompositeAccess compAcc = new CompositeAccess();
									compAcc.setAccesses(convertExpression(chain[i].getInitializerValue(), false));
									list.add(compAcc);							
								}								
								currentFunction = oldFunc;
							}
							else if (bind instanceof CPPField) {								
								CPPField cdtfld = (CPPField)bind;
								Field mmfld = convertField(cls, cdtfld);
								list.add(new VariableAccess(mmfld, true));
								Function oldFunc = currentFunction;
								currentFunction = meth;
								list.addAll(convertExpression(chain[i].getInitializerValue(), false));
								currentFunction = oldFunc;
							}
							if(!list.isEmpty())
								meth.setAccesses(list);
						}
					}
					if (((CPPFunction) method).getDefinition() != null) {
						meth
								.setPosition(convertFileLocation(((CPPFunction) method)
										.getDefinition().getFileLocation()));
						Position pos = convertFileLocation(((CPPFunction) method)
								.getDefinition().getFileLocation());
						meth.setPosition(pos);
						if(meth.getReturnTypeDeclaration()!= null) meth.getReturnTypeDeclaration().setPosition(pos);
					}
				}
			}
		} catch (Exception e) {
			Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
			e.printStackTrace();
		}
		if (method instanceof CPPFunction && !isDefined(meth)) {
			CPPFunction cppmethod = (CPPFunction) method;
			if (cppmethod.getDefinition() != null) {
				meth.setPosition(convertFileLocation(cppmethod.getDefinition()
						.getParent().getFileLocation()));
				setDefined(meth);
				mmFunctions.add(meth);
				cdtFunctions.add(method);
				// convertFunctionBody(method, meth,
				// (ICPPASTFunctionDeclarator) cppmethod.getDefinition());
			} else if (cppmethod.getDeclarations()!= null && cppmethod.getDeclarations()[0] != null) {
				meth.setPosition(convertFileLocation(cppmethod
						.getDeclarations()[0].getFileLocation()));
			}

		}
		if(method instanceof CPPConstructor)
		{
			CPPConstructor cons = (CPPConstructor)method;
			//System.out.println(cons);
		}
		return meth;
	}

	/**
	 * Converts a CDT Field to a Metamod Field
	 * 
	 * @param cls
	 * @param field
	 * @return
	 */
	protected Field convertField(Class cls, ICPPField field) {
		if (field instanceof IProblemBinding) {
			handleProblem((IProblemBinding) field);
			return null;
		}
		String fullName;
		fullName = getFullName(field);
		if (fieldTable.containsKey(fullName))
			return (Field) fieldTable.get(fullName);
		Field fld = null;
		try {
			fld = getOrCreateField(cls, field);
			if (field instanceof CPPField) {
				IASTNode def = ((CPPField)field).getDefinition();
				if (def != null)
					if (def.getParent() instanceof CPPASTDeclarator) {
						CPPASTDeclarator d = (CPPASTDeclarator)def.getParent();
						if (d.getInitializer() != null) {
							Constructor init = new Constructor(fld.getSimpleName());
							init.setInitializer();							
							init.setPosition(convertFileLocation(d.getInitializer().getFileLocation()));							
							BlockStatement blk = new BlockStatement();				
							blk.setPosition(convertFileLocation(d.getInitializer().getFileLocation()));
							SimpleStatement initializationStatement = new SimpleStatement(); 
							initializationStatement.setPosition(convertFileLocation(d.getInitializer().getFileLocation()));
							blk.addStatement(initializationStatement);
							init.setBody(blk);
							ModelElementList accList = new ModelElementList();
							accList.add(new VariableAccess(fld, true));
							initializationStatement.setAccesses(accList);
							cls.addConstructor(init);
							setDefined(init);
							fieldInitializers.put(init, d.getInitializer());
							mmFunctions.add(init);
							cdtFunctions.add(null);
						}
					}
			}
			if (field instanceof IProblemBinding)
				return fld;
			if (field instanceof CPPField && !isDefined(fld)) {
				CPPField cppfield = (CPPField) field;
				if (cppfield.getDefinition() != null) {
					fld.setPosition(convertFileLocation(cppfield
							.getDefinition().getFileLocation()));
					setDefined(fld);
				} else if (cppfield.getDeclarations()[0] != null) {
					fld.setPosition(convertFileLocation(cppfield
							.getDeclarations()[0].getFileLocation()));
				}
			}
			IType type = field.getType();
			Type typ = convertType(type);
			if (typ != null)
				fld.setTypeDeclaration(new DeclarationTypeAccess(typ));
			fld.setStatic(field.isStatic());
			if (type instanceof IQualifierType)
				fld.setConst(((IQualifierType)type).isConst());
			if (type instanceof IPointerType)
				fld.setConst(((IPointerType)type).isConst());

		} catch (DOMException e) {
			e.printStackTrace();
		}
		return fld;
	}

	public Type convertType(IType type) {
		if (type instanceof CPPQualifierType) {
			return convertType(((CPPQualifierType) type).getType());
		} else if (type instanceof CPPTypedef) {
			return convertType(((CPPTypedef) type).getType());
		}
		String fullname = getFullName(type);
		if(fullname.length() == 0) return null;
		// test if it really needs converting
		if (typeTable.containsKey(fullname)) {
			return (Type) typeTable.get(fullname);
		} else if (type instanceof ICPPClassType) {
			return mapClass((ICPPClassType) type);
		} else if (type instanceof IProblemBinding) {
			handleProblem((IProblemBinding) type);
			Class cls = new Class(fullname); //create dummy class
			cls.setFailedDependency();
			typeTable.put(fullname, cls);
			root.addType(cls);
			return cls;
		} else if (type instanceof ICPPBasicType) {
			ICPPBasicType basicType = (ICPPBasicType) type;
			Class cls = new Class(getFullName(basicType));
			cls.setPrimitive();
			cls.setImplicit();
			typeTable.put(fullname, cls);
			root.addType(cls);
			return cls;
		} else if (type instanceof IEnumeration) {
			return convertEnum((IEnumeration) type);
		} else if (type instanceof IArrayType) {
			IArrayType arrayType = (IArrayType) type;
			try {
				Type contentType = convertType(arrayType.getType());
				if (contentType == null)
					return null;
				Array a = new Array(contentType);
				typeTable.put(fullname, a);
				root.addType(a);
				return a;
			} catch (DOMException e) {
				e.printStackTrace();
			}
		} else if (type instanceof CPPTypedef) {
			Type contentType = convertType(((CPPTypedef) type).getType());
			if (contentType == null)
				return null;
			TypeAlias aliasType = new TypeAlias(contentType, ((CPPTypedef) type).getName());
			aliasType.setPosition(convertFileLocation(((CPPTypedef) type).getDefinition().getFileLocation()));
			typeTable.put(fullname, aliasType);
			root.addType(aliasType);
			return aliasType;
//			return convertType(((CPPTypedef) type).getType());

		} else if (type instanceof CPPReferenceType) {
			Type contentType = convertType(((CPPReferenceType) type).getType());
			if (contentType == null)
				return null;
			Reference refType = new Reference(contentType, contentType.getSimpleName()+REFERENCE_MARKER);
			refType.setImplicit();
			typeTable.put(fullname, refType);
			root.addType(refType);
			return refType;
		} else if (type instanceof CPPPointerType) {
			Type contentType = convertType(((CPPPointerType) type).getType());
			if (contentType == null)
				return null;
			Reference refType = new Reference(contentType, contentType.getSimpleName()+POINTER_MARKER);
			refType.setExplicit();
			typeTable.put(fullname, refType);
			root.addType(refType);
			return refType;
		}
		return null;
	}

	public Field getOrCreateField(Class cls, ICPPField field) {
		String fullName;
		fullName = getFullName(field);
		if (fieldTable.containsKey(fullName))
			return (Field) fieldTable.get(fullName);
		else {
			Field fld = new Field(field.getName());
			fieldTable.put(fullName, fld);
			cls.addField(fld);
			return fld;
			// cls.set
		}
	}

	public Field getOrCreateFailedDepField(Class cls, String name) {
		// -- find field
		ModelElementList list = cls.getFields();
		Field field = (Field)list.findByName(name);
		if(field!= null) return field;

		Field fld = new Field(name);
		cls.addField(fld);
		return fld;
	}

	public Method getOrCreateFailedDepMethod(Class cls, String name) {
		// -- find method
		ModelElementList list = cls.getMethods();
		Method meth = (Method)list.findByName(name);
		if(meth!= null) return meth;

		meth = new Method(name);
		cls.addMethod(meth);
		return meth;
	}

	public Function getOrCreateMethod(Class cls, ICPPMethod method) {
		String fullName = null;
		fullName = getFullSignature(method);
		if (functionTable.containsKey(fullName))
			return (Function) functionTable.get(fullName);

		Function meth = null;
        boolean isDestructor = false;
        try {
        	isDestructor = method.isDestructor();
        } catch (DOMException e) {
        }
        if (method instanceof ICPPConstructor) {
        	meth = new Constructor(method.getName());
        	cls.addConstructor((Constructor) meth);
        }
        else if (isDestructor) {
        		meth = new Destructor(method.getName());
        		cls.addDestructor((Destructor) meth);
        } else {
        	meth = new Method(method.getName());
        	cls.addMethod((Method) meth);
        }
        functionTable.put(fullName, meth);
        return meth;
	}

	public GlobalFunction getOrCreateGlobalFunction(ICPPFunction function) {
		String fullName = null;
		fullName = getFullSignature(function);
		if (functionTable.containsKey(fullName))
			return (GlobalFunction) functionTable.get(fullName);
		else {
			GlobalFunction func = new GlobalFunction(function.getName());
			functionTable.put(fullName, func);
			return func;
		}
	}

	public Class getOrCreateClass(ICPPClassType binding) {
		String fullName = getFullName((IType) binding);
		if (typeTable.containsKey(fullName))
			return (Class) typeTable.get(fullName);
		else {
			Class cls = new Class(binding.getName());
			try {				
				IASTNode def = null;
				if (binding instanceof ICPPInternalBinding)
					def = ((ICPPInternalBinding)binding).getDefinition();
				if (def != null)
					cls.setPosition(convertFileLocation(def.getParent().getFileLocation()));
			} catch (Exception ex) {/* No Position */
				Debug.warning("Exception caught: " + ex.getClass().getCanonicalName());                	
                ex.printStackTrace();
			}
			typeTable.put(fullName, cls);
			root.addType(cls);
			return cls;
		}
	}

	/**
	 * Computes the full name of a given Type, that uniquely identifies it
	 * 
	 * @param type
	 * @return
	 */
	protected String getFullName(IType type) {
		Stack stack = new Stack();
		IScope scope;
		StringBuffer buffer = new StringBuffer();

		try {
			if (type instanceof IProblemBinding) {
				return ((ProblemBinding) type).getASTNode().getRawSignature();
			} else if (type instanceof ICompositeType) {
				scope = ((ICompositeType) type).getScope();
				while (scope != null && scope.getScopeName() != null) {
					stack.push(scope.getScopeName().toString());
					scope = scope.getParent();
				}
				while (!stack.empty()) {
					buffer.append(stack.pop());
					buffer.append("::");
				}
			}
			buffer.append(ASTTypeUtil.getType(type));
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * generates the full name for a specific Binding
	 * 
	 * @param binding
	 * @return
	 */
	protected String getFullName(ICPPBinding binding) {
		if (binding instanceof ProblemBinding) {
			return (((ProblemBinding) binding).getMessage());
		}
		try {
			return joinName(binding.getQualifiedName());
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * generates the full signature for a given function
	 * 
	 * @param function
	 * @return
	 */
	protected String getFullSignature(ICPPFunction function) {
		String str = getFullName(function);
		try {
			str = str + getParameterTypeString(function.getType());
			str = str.replaceAll("\\(void\\)", "()");
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return str;
	}

	public Package getOrCreatePackage(IBinding binding) throws DOMException {
		String fullName = binding.getName();
		if (packageTable.containsKey(fullName))
			return (Package) packageTable.get(fullName);
		else {
			Package pkg = new Package(fullName);
			packageTable.put(fullName, pkg);
			return pkg;
		}
	}

	protected static String joinName(String[] name) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < name.length; i++) {
			buffer.append(name[i]);
			buffer.append("::");
		}
		return buffer.toString();
	}

	public Position convertFileLocation(IASTFileLocation location) {
		if (location == null) {
			return null;
		}
		return new Position(getOrCreateFile(location.getFileName()), location
				.getStartingLineNumber(), 0, location.getEndingLineNumber(), 0);
	}

	private de.fzi.sissy.metamod.File getOrCreateFile(String str) {
		String filename = new java.io.File(str).getAbsolutePath();
		// only create new file if not already present
		de.fzi.sissy.metamod.File existentFile = null;

		Iterator files = root.getFiles().iterator();
		while (files.hasNext()) {
			de.fzi.sissy.metamod.File f = (de.fzi.sissy.metamod.File) files
					.next();
			if (f.getPathName().toLowerCase().equals(filename.toLowerCase()))
				existentFile = f;
		}

		if (existentFile == null) {
			existentFile = new de.fzi.sissy.metamod.File(filename);
			root.addFile(existentFile);
		}

		return existentFile;
	}

	private void setDefined(Object o) {
		definedEntities.add(o);
	}

	private boolean isDefined(Object o) {
		return definedEntities.contains(o);
	}

	private void setDeclared(Object o) {
		declaredEntities.add(o);
	}

	private boolean isDeclared(Object o) {
		return declaredEntities.contains(o);
	}

	/**
	 * Returns String[] corresponding to the types of the parameters for the IFunctionType.
	 * 
	 * @param type
	 * @return the types of the parameters for the IFunctionType
	 */
	public static String[] getParameterTypeStringArray(IType[] parms) {
		String[] result = new String[parms.length];
		
		for(int i=0; i<parms.length; i++) {
			if (parms[i] != null) {
				if(parms[i] instanceof ProblemBinding)
				{
					result[i] = ((ProblemBinding)parms[i]).getPhysicalNode().toString();
				}
				else
				{
					result[i] = ASTTypeUtil.getType(parms[i]);
				}

			}
		}
		
		return result;
	}

	/**
	 * Returns a String represnetation of the parameter type of an IFunctionType.
	 * 
	 * This function calls ASTTypeUtil#getParameterTypeStringArray(IFunctionType) and wraps the
	 * results in "()" with a comma separated list.
	 * 
	 * @param type
	 * @return the represnetation of the parameter type of an IFunctionType
	 */
	public static String getParameterTypeString(IFunctionType type) {
		IType[] parms = null;
		try {
			parms = type.getParameterTypes();
		} catch (DOMException e) { return ""; }
		
		return getParameterTypeString(parms);
		
	}
	/**
	 * Returns a String represnetation of the parameter type of an IFunctionType.
	 * 
	 * This function calls ASTTypeUtil#getParameterTypeStringArray(IFunctionType) and wraps the
	 * results in "()" with a comma separated list.
	 * 
	 * @param type
	 * @return the represnetation of the parameter type of an IFunctionType
	 */
	public static String getParameterTypeString(IType[] tparms) {
		StringBuffer result = new StringBuffer();
		
		String[] parms = getParameterTypeStringArray(tparms);
		
		result.append(Keywords.cpLPAREN);
		for(int i=0; i<parms.length; i++) {
			if (parms[i] != null) {
				result.append(parms[i]);
				if (i<parms.length-1) result.append(", ");
			}
		}
		result.append(Keywords.cpRPAREN);
		return result.toString();
	}
}
