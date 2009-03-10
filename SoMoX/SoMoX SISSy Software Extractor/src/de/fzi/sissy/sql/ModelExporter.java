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
package de.fzi.sissy.sql;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import de.fzi.sissy.metamod.*;
import de.fzi.sissy.util.Debug;
import de.fzi.sissy.util.ArgParser;

/**
 * @author Mircea Trifu
 *
 */
public class ModelExporter  extends DefaultModelVisitor implements ModelVisitor,
        SQLModelConstants, Runnable {
	
	private PrintWriter statements;
	private PipedReader inPipe;
	private JDBCWrapper jdbcWrapper;
    private Root root;
    
    public ModelExporter(Root root, String[] args) {
        try {
	        // -- Setup ArgParser
	        ArgParser argParser = new ArgParser("SISSy",
	            "SISSy -export [-cfg <cfg-file>] [{-o <output-file> | -db <dbname>}]");
	        argParser.addOption("cfg", "cfg-file",
	        	"an alternate jdbc config file. If this param is not supplied the default config file is used.");
	        argParser.addOption("o", "output-file",
	        	"the result will be stored as SQL commands in the specified file.");
	        argParser.addOption("db", "dbname",
	        	"the result will be stored in the specified database. If none of the -o or -db params is given the output will be stored in the default database specified in the <cfg-file>.");
	        
	        argParser.parse(args);
	        String jdbcConfigFile = argParser.getParameter("cfg");
	        String dbName = argParser.getParameter("db");
	        String outputFile = argParser.getParameter("o");
	
	        if ((outputFile == null) && (dbName == null)) {
	            Debug.info("Output will be written to default database");
	        }
	
	        // -- Setup JDBCWrapper
	        jdbcWrapper = new JDBCWrapper(jdbcConfigFile, dbName);
	        System.out.println("Database: " + jdbcWrapper.getDBName());
	        
	        this.root = root;

	        Debug.info("Exporting to SQL");
	        if (outputFile != null) {
	        	statements = new PrintWriter(new FileWriter(outputFile));
	        	// jdbcWrapper.printScripts(this.statements);
                export();
                this.statements.close();
	        }
	        else {
		        jdbcWrapper.getConnection();
	        	exportToSQL();
	        }
	        Debug.info("Exporting finished");
        } catch (IOException e) {
            e.printStackTrace();
		}
    }
    
    public ModelExporter(Root root, JDBCWrapper jdbcWrapper) {
        this.root = root;
        this.jdbcWrapper = jdbcWrapper;
        exportToSQL();
    }
	    
	private void exportToSQL() {
		try {
			jdbcWrapper.runScripts();
			inPipe = new PipedReader();
			PipedWriter outPipe = new PipedWriter(inPipe);
			statements = new PrintWriter(outPipe);
			Thread t = new Thread(this);
			t.start();
			export();
			statements.close();
			t.join();
			jdbcWrapper.getConnection().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDBCError e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int booleanToDB(boolean b) {
		if (b)
			return 1;
		return 0;
		
	}

	private int findAccessPosition(Access acc) {
		Iterator it = null;
    	int pos = 0;
    	if (acc instanceof DeclarationTypeAccess)
    		return 1;
    	else if (acc.getSurroundingCompositeAccess() != null) {
    		pos = findAccessPosition(acc.getSurroundingCompositeAccess());
    		it = acc.getSurroundingCompositeAccess().getAccesses().iterator();
    	}
   		else if (acc.getSurroundingStatement() != null)
			it = acc.getSurroundingStatement().getAccesses().iterator();
		else if (acc.getSurroundingFunction() != null) {
			if (acc.getSurroundingFunction().getReturnTypeDeclaration() != null)
				pos++;
			it = acc.getSurroundingFunction().getAccesses().iterator();
		}
		else if (acc.getSurroundingClass() != null)
			it = acc.getSurroundingClass().getInheritanceTypeAccesses().iterator();
		else
			return -1;
    	while (it.hasNext()) {
    		pos++;
    		Access a = (Access)it.next();
    		if (acc == a)
    			return pos;
    		if (a instanceof CompositeAccess)
    			pos += ((CompositeAccess)a).getAccessCount(); 
    	}		
    	return -1;
	}
	
    private int determineKind(de.fzi.sissy.metamod.Class c) {
    	if (c.isPrimitive())
    		return TYPE_PRIMITIVE;
    	else if (c instanceof TypeParameterClass)
    		return TYPE_TYPEPARAMCLASS;
    	else if (c instanceof GenericClass) {
    		if (c.isInterface())
    			return TYPE_GENERICINTERFACE;
    		else
    			return TYPE_GENERICCLASS;
    	}
    	else {
    		if (c.isInterface())
    			return TYPE_INTERFACE;
    		else
    			return TYPE_CLASS;
    	}
    }
    
    private int determineKind(Type t) {
    	if (t instanceof de.fzi.sissy.metamod.Class)
    		return determineKind((de.fzi.sissy.metamod.Class)t);
    	else if (t instanceof Array)
    		return TYPE_ARRAY;
    	else if (t instanceof TypeAlias)
    		return TYPE_TYPEALIAS;
    	else if (t instanceof Delegate)
    		return FUNC_TYPE_DELEGATE;
    	else if (t instanceof Reference) {
    		if (((Reference)t).isImplicit())
    			return TYPE_IMPLICITREFERENCE;
    		else
    			return TYPE_EXPLICITREFERENCE;
    	}
    	else
    		return -1;
    }
    
    private int determineKind(de.fzi.sissy.metamod.Function f) {
    	if (f instanceof GenericFunction)
    		return FUNC_GENERICFUNC;
    	else if (f instanceof GlobalFunction) {
    		if (((GlobalFunction)f).isUnitInitializer())
    			return FUNC_UNITINITIALIZER;
    		else if (((GlobalFunction)f).isUnitFinalizer())
    			return FUNC_UNITFINALIZER;    			
    		else
    			return FUNC_GLOBALFUNC;
    	}
    	else if (f instanceof GenericConstructor)
    		return FUNC_GENERICCONSTRUCTOR;
    	else if (f instanceof Constructor) {
    		if (((Constructor)f).isInitializer())
    			return FUNC_INITIALIZER;
    		return FUNC_CONSTRUCTOR;
    	}
    	else if (f instanceof Destructor)
    		return FUNC_DESTRUCTOR;
    	else if (f instanceof GenericMethod)
    		return FUNC_GENERICMETHOD;
    	else if (f instanceof Method) {
    		Method m = (Method)f;
    		Property prop = m.getSurroundingProperty();
    		if (prop != null) {
    			if (prop.getGetter() == m)
    				return FUNC_PROPGETTER;
    			else
    				return FUNC_PROPSETTER;
    		}
    		else
    			return FUNC_METHOD;
    	}
    	else if (f instanceof Delegate)
    		return FUNC_TYPE_DELEGATE;
    	else
    		return -1;
    }

    private int determineKind(Statement st) {
    	if (st instanceof SimpleStatement)
    		return STATEMENT_SIMPLE;
    	else if (st instanceof JumpStatement) {
    		JumpStatement jst = (JumpStatement)st;
    		if (jst.isReturn())
    			return STATEMENT_RETURN;
    		else if (jst.isThrow())
    			return STATEMENT_THROW;
    		else
    			return STATEMENT_JUMP;
    	}
    	else if (st instanceof LoopStatement)
    		return STATEMENT_LOOP;
    	else if (st instanceof BranchStatement)
    		return STATEMENT_BRANCH;
    	else if (st instanceof ExceptionHandler)
    		return STATEMENT_EXCEPTIONHANDLER;
    	else if (st instanceof CatchBlock)
    		return STATEMENT_CATCHBLOCK;
    	else if (st instanceof BlockStatement)
    		return STATEMENT_BLOCK;
    	else
    		return -1;
    }
    
    private void addModelElement(ModelElement elem, int kind, int scope) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TModelElements values (");
        buffer.append(elem.getUniqueId());
        buffer.append(", '");
        if (elem instanceof NamedModelElement)
            buffer.append(((NamedModelElement) elem).getSimpleName());
        else
        	buffer.append("");

        buffer.append("', ");
       	buffer.append(elem.getStatus());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", ");
        buffer.append(scope);
        buffer.append(", ");
        if (elem.getParent() != null)
            buffer.append(elem.getParent().getUniqueId());
        else
            buffer.append(-1);
        buffer.append(");");
        statements.println(buffer.toString());
        addAnnotations(elem);
    }
    
    private void addAnnotations(ModelElement elem) {
    	Iterator it = elem.getAnnotations().iterator();
    	while (it.hasNext()) {
    		StringBuffer buffer = new StringBuffer();
    		buffer.append("insert into TAnnotations values (");
    		buffer.append(elem.getUniqueId());
    		buffer.append(", ");
    		ModelAnnotation a = (ModelAnnotation)it.next();
    		if (a instanceof ModelElement) {
    			buffer.append(((ModelElement)a).getUniqueId());
    			buffer.append(");");
    			statements.println(buffer.toString());
    		}
    	}
    }

    private void addSourceEntity(SourceEntity se) {
        Position pos = se.getPosition();
        if (pos != null) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("insert into TSourceEntities values (");
            buffer.append(se.getUniqueId());
            buffer.append(", ");

            // TODO Position.SourceFiles sometimes are null, okay ??? 
            if (pos.getSourceFile() != null)
	            buffer.append(pos.getSourceFile().getUniqueId());
			else
				buffer.append(-1);
            
            buffer.append(", ");
            buffer.append(pos.getStartLine());
            buffer.append(", ");
            buffer.append(pos.getStartColumn());
            buffer.append(", ");
            buffer.append(pos.getEndLine());
            buffer.append(", ");
            buffer.append(pos.getEndColumn());
            buffer.append(", ");
            if (pos.getAssembly() != null)
            	buffer.append(pos.getAssembly().getUniqueId());
            else
            	buffer.append(-1);
            buffer.append(");");
            statements.println(buffer.toString());
        }
    }

    private void addPackage(de.fzi.sissy.metamod.Package pack, int kind, int aliasId) {
        if (pack.getSurroundingPackage() != null) {
            addModelElement(pack, kind, SCOPE_PACKAGE);
        } else
            addModelElement(pack, kind, SCOPE_GLOBAL);

        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TPackages values (");
        buffer.append(pack.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", '");
        buffer.append(pack.getSimpleName());
        buffer.append("', '");
        buffer.append(pack.getQualifiedName());
        buffer.append("', ");
        if (pack.getSurroundingPackage() != null)
        	buffer.append(pack.getSurroundingPackage().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        buffer.append(aliasId);
        buffer.append(");");
        statements.println(buffer.toString());

        if (pack.getSurroundingPackage() != null) {
            addPackageContainmentClosure(pack);
        }
}

    private void addPackageContainmentClosure(de.fzi.sissy.metamod.Package pack) {

        int depth = 1;
        de.fzi.sissy.metamod.Package parent = pack.getSurroundingPackage();
        while (parent != null) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("insert into TPackageContainmentRelations values (");
            buffer.append(pack.getUniqueId());
            buffer.append(", ");
            buffer.append(parent.getUniqueId());
            buffer.append(", ");
            buffer.append(depth);
            buffer.append(");");
            statements.println(buffer.toString());

            parent = parent.getSurroundingPackage();
            depth++;
}
    }

    private void addMember(Member m, int kind) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TMembers values (");
        buffer.append(m.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", '");
        buffer.append(m.getSimpleName());
        buffer.append("', ");
        
        if (m.getSurroundingClass() == null) {
            buffer.append("-1");
        } else {
            buffer.append(m.getSurroundingClass().getUniqueId());
        }
        buffer.append(", ");

        if (m.isPrivate())
            buffer.append(VISIBILITY_PRIVATE);
        else if (m.isProtected())
            buffer.append(VISIBILITY_PROTECTED);
        else if (m.isStrictProtected())
            buffer.append(VISIBILITY_STRICTPROTECTED);
        else if (m.isPublic())
            buffer.append(VISIBILITY_PUBLIC);
        else
            buffer.append(VISIBILITY_PACKAGE);
        buffer.append(", ");
        buffer.append(booleanToDB(m.isInternal()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isAbstract()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isFinal()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isStatic()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isVirtual()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isExtern()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isNew()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isOverride()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isTypeParameterMember()));
        buffer.append(", ");
        buffer.append(booleanToDB(m.isIntrospectable()));
        buffer.append(", ");
        if (m.getOverridenMember() != null)
        	buffer.append(m.getOverridenMember().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(");");
        statements.println(buffer.toString());
    }

    private void addType(Type t, int kind) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TTypes values (");
        buffer.append(t.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", '").append(t.getSimpleName()).append("'");
        buffer.append(", '").append(t.getQualifiedName()).append("'");
        buffer.append(", ");
        if (t.getSurroundingPackage() != null)
            buffer.append(t.getSurroundingPackage().getUniqueId());
        else
            buffer.append(-1);
        buffer.append(", ");
        if (t instanceof Member)
        	if (((Member)t).getSurroundingClass() != null)
        		buffer.append(((Member)t).getSurroundingClass().getUniqueId());
        	else
        		buffer.append(-1);
        else
            buffer.append(-1);
        buffer.append(", ");
        
        if (t instanceof TypeDecorator)
            buffer.append(((TypeDecorator) t).getDecoratedType().getUniqueId());
        else
            buffer.append(-1);
        buffer.append(", ");
        if (t instanceof Array)
            buffer.append(((Array) t).getDimensions());
        else
            buffer.append(-1);
        buffer.append(", ");
        buffer.append(booleanToDB(t.isReferenceType()));
        buffer.append(");");
        statements.println(buffer.toString());
    }

    private void addClass(de.fzi.sissy.metamod.Class ct, int kind) {
        if (ct.isLocalClass()) {
            addModelElement(ct, kind, SCOPE_LOCAL);
            addType(ct, kind);
        }
        else if (ct.isInnerClass()) {
            addModelElement(ct, kind, SCOPE_CLASS);
            addType(ct, kind);
            addInnerClassClosure(ct);
        }
        else if (kind == TYPE_PRIMITIVE) {
        	addModelElement(ct, kind, SCOPE_GLOBAL);
        	addType(ct, kind);
        }
        else {
            addModelElement(ct, kind, SCOPE_PACKAGE);
            addType(ct, kind);
        }
        addSourceEntity(ct);
       	addMember(ct, kind);
       	addFriends(ct);
    }

    private void addInnerClassClosure(de.fzi.sissy.metamod.Class ct) {

        int depth = 1;
        de.fzi.sissy.metamod.Class parent = ct.getSurroundingClass();
        while (parent != null) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("insert into TClassContainmentRelations values (");
            buffer.append(ct.getUniqueId());
            buffer.append(", ");
            buffer.append(parent.getUniqueId());
            buffer.append(", ");
            buffer.append(depth);
            buffer.append(");");
            statements.println(buffer.toString());

            parent = parent.getSurroundingClass();
            depth++;
        }
        
    }

    private void addFriends(de.fzi.sissy.metamod.Class ct) {
    	Iterator it = ct.getFriendClasses().iterator();
    	while (it.hasNext()) {
    		de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class)it.next();
    		StringBuffer buffer = new StringBuffer();
    		buffer.append("insert into TFriends values (");
    		buffer.append(ct.getUniqueId());
    		buffer.append(", ");
    		buffer.append(determineKind(c));
    		buffer.append(", ");
    		buffer.append(c.getUniqueId());
    		buffer.append(");");
            statements.println(buffer.toString());
    	}
    	it = ct.getFriendFunctions().iterator();
    	while (it.hasNext()) {
    		de.fzi.sissy.metamod.Function f = (de.fzi.sissy.metamod.Function)it.next();
    		StringBuffer buffer = new StringBuffer();
    		buffer.append("insert into TFriends values (");
    		buffer.append(ct.getUniqueId());
    		buffer.append(", ");
    		buffer.append(determineKind(f));
    		buffer.append(", ");
    		buffer.append(f.getUniqueId());
    		buffer.append(");");
            statements.println(buffer.toString());
    	}
    }
    
    private void addTypeParameter(GenericEntity ge, TypeParameterClass tpc, int pos) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TTypeParameters values (");
        buffer.append(tpc.getUniqueId());
        buffer.append(", ");
        buffer.append(pos);
        buffer.append(", ");
        if (ge instanceof de.fzi.sissy.metamod.Class)
        	buffer.append(determineKind((de.fzi.sissy.metamod.Class)ge));
        else
        	buffer.append(determineKind((Function)ge));
        buffer.append(", ");
        buffer.append(ge.getUniqueId());
        buffer.append(");");
        statements.println(buffer.toString());
    }

    private void addTypeArguments(Access access) {
    	Iterator itParam = null, itArg = null;    	
    	if (access instanceof FunctionAccess) {
    		itArg = ((FunctionAccess)access).getTypeArgs().iterator();
    	}
    	else if (access instanceof TypeAccess) {
    		itArg = ((TypeAccess)access).getTypeArgs().iterator();    		
    	}
    	if (itArg != null)
    		if (itArg.hasNext()) {
	    		ModelElement ref = access.getAccessedTarget();
	    		while ((ref != null) && !(ref instanceof GenericEntity)) {
	    			ref = ref.getParent();
	    		}
	    		if (ref != null)
	    			itParam = ((GenericEntity)ref).getTypeParameters().iterator();	    			
		    	if ((itParam != null))
		    		while (itArg.hasNext() && itParam.hasNext()) {
		    			TypeParameterClass tpc = (TypeParameterClass)itParam.next();
		    			Type targ = (Type)itArg.next();
				   		StringBuffer buffer = new StringBuffer();
						buffer.append("insert into TTypeArguments values (");
						buffer.append(access.getUniqueId());
						buffer.append(", ");
						buffer.append(tpc.getUniqueId());
						buffer.append(", ");
						buffer.append(targ.getUniqueId());
						buffer.append(");");
				        statements.println(buffer.toString());    	
		    		}
	    	}
    }
    
    private void addFunction(Function func, int kind, int scope) {
        addModelElement(func, kind, scope);
        StringBuffer buffer;
        buffer = new StringBuffer();
        buffer.append("insert into TFunctions values (");
        buffer.append(func.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", '");
        buffer.append(func.getSimpleName());
        buffer.append("', ");
        if (func.getReturnTypeDeclaration() == null)
            buffer.append("-1");
        else
            buffer.append(func.getReturnTypeDeclaration().getUniqueId());
        buffer.append(", ");
        
        de.fzi.sissy.metamod.Package tmpPack = null;
        de.fzi.sissy.metamod.Class tmpCls = null;
        Property tmpProp = null;
        ModelElement tmpElem = func.getParent();
        
        while ((tmpElem != null) && !(tmpElem instanceof de.fzi.sissy.metamod.Package)) {
        	if ((tmpElem instanceof de.fzi.sissy.metamod.Class) && (tmpCls == null))
        		tmpCls = (de.fzi.sissy.metamod.Class)tmpElem;
        	if ((tmpElem instanceof Property) && (tmpProp == null))
        		tmpProp = (Property)tmpElem;
        	tmpElem = tmpElem.getParent();
        }
        
        if (tmpElem != null)
	    	if (tmpElem instanceof de.fzi.sissy.metamod.Package)
	    		tmpPack = (de.fzi.sissy.metamod.Package)tmpElem;

        if (tmpPack != null)
        	buffer.append(tmpPack.getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (tmpCls != null)
        	buffer.append(tmpCls.getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");        
        if (tmpProp != null)
        	buffer.append(tmpProp.getUniqueId());
        else
        	buffer.append(-1);                
        buffer.append(", ");
        buffer.append(booleanToDB(func.isOperator()));
        buffer.append(", ");
        buffer.append(func.getNumberOfStatements());
        buffer.append(", ");
        buffer.append(func.getLinesOfCode());
        buffer.append(", ");
        buffer.append(func.getLinesOfComments());
        buffer.append(", ");
        buffer.append(func.getThrowTypeAccesses().size());
        buffer.append(", ");
        buffer.append(func.getMaximumNestingLevel());
        buffer.append(", ");
        buffer.append(func.getNumberOfNodesInCFG());
        buffer.append(", ");
        buffer.append(func.getNumberOfEdgesInCFG());
        buffer.append(");");
        statements.println(buffer.toString());
        addSourceEntity(func);
        addSignature(func);
    }
    
    private void addSignature(Function func) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into TSignatures values (");
		buffer.append(func.getUniqueId());
		buffer.append(", '");
		buffer.append(func.signature().toString());
		buffer.append("');");
        statements.println(buffer.toString());    	
    }
    
    private void addAccessedTargets(Access acc) {
    	//TODO: [mtrifu] Determine a conservative list of actual target candidates  
    }
    
    private void addVariable(Variable var, int kind, int scope, de.fzi.sissy.metamod.Package pack, de.fzi.sissy.metamod.Class cls, Function func, int pos) {
        addModelElement(var, kind, scope);
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TVariables values (");
        buffer.append(var.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", '");
        buffer.append(var.getSimpleName());
        buffer.append("', ");
        if (pack != null)      	
        	buffer.append(pack.getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (cls != null)      	
        	buffer.append(cls.getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (func != null)      	
        	buffer.append(func.getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");

        if (var.getTypeDeclaration() == null)
            buffer.append("-1");
        else
            buffer.append(var.getTypeDeclaration().getUniqueId());
        buffer.append(", ");
        buffer.append(pos);
        buffer.append(", ");
        buffer.append(booleanToDB(var.isConst()));
        buffer.append(", ");
        if (var instanceof FormalParameter)
        	buffer.append(booleanToDB(((FormalParameter)var).isPassedByReference()));
        else
        	buffer.append(booleanToDB(false));
        buffer.append(", ");
        if (var instanceof CatchParameter)
        	buffer.append(booleanToDB(((CatchParameter)var).isRethrown()));
        else
        	buffer.append(booleanToDB(false));
        buffer.append(", ");
        if (var instanceof Property) {
        	if (((Property)var).getImplementedInterface() != null)
        		buffer.append(((Property)var).getImplementedInterface().getUniqueId());
        	else
        		buffer.append(-1);
        }
        else
        	buffer.append(-1);        
        buffer.append(");");
        statements.println(buffer.toString());
        addSourceEntity(var);
    }

    private void addAccess(Access acc, int kind, int scope, int pos) {
        addModelElement(acc, kind, scope);
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TAccesses values (");
        buffer.append(acc.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", ");
        buffer.append(pos);
        buffer.append(", ");
        de.fzi.sissy.metamod.Package tmpPack = null;
        ModelElement tmpElem = acc.getParent();
        while ((tmpElem != null) && !(tmpElem instanceof de.fzi.sissy.metamod.Package))
        	tmpElem = tmpElem.getParent();
        if (tmpElem != null)
        	if (tmpElem instanceof de.fzi.sissy.metamod.Package)
        		tmpPack = (de.fzi.sissy.metamod.Package)tmpElem;
        
        if (tmpPack != null)
        	buffer.append(tmpPack.getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");      
        if (acc.getSurroundingClass() != null)
        	buffer.append(acc.getSurroundingClass().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (acc.getSurroundingFunction() != null)
        	buffer.append(acc.getSurroundingFunction().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (acc.getSurroundingStatement() != null)
        	buffer.append(acc.getSurroundingStatement().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (acc.getParent() != null)
        	buffer.append(acc.getParent().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (acc.getAccessedTarget() == null)
            buffer.append("-1");
        else
            buffer.append(acc.getAccessedTarget().getUniqueId());
        buffer.append(");");
        statements.println(buffer.toString());
        addSourceEntity(acc);
        addTypeArguments(acc);
        addAccessedTargets(acc);
    }

    private void addImport(File file, ModelElement target, int kind) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TImports values (");
        buffer.append(file.getUniqueId());
        buffer.append(", ");
        buffer.append(kind);
        buffer.append(", ");
        buffer.append(target.getUniqueId());
        buffer.append(");");
        statements.println(buffer.toString());
    }

    private void addIncludeClosure(File file, File includedFile, ModelElementList visited, int depth) {
    	if (visited.contains(includedFile))
        	return;
        visited.add(includedFile);   
    	StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TIncludes values (");

        buffer.append(file.getUniqueId());
        buffer.append(", ");
        buffer.append(includedFile.getUniqueId());
        buffer.append(", ");
        buffer.append(depth);
        buffer.append(");");
        statements.println(buffer.toString());
        Iterator it = includedFile.getIncludedFiles().iterator();
        while (it.hasNext()) {
            File f = (File) it.next();
            addIncludeClosure(file, f, visited, depth + 1);
        }
    }

    private void addInheritanceClosure(de.fzi.sissy.metamod.Class cls,
    		de.fzi.sissy.metamod.Class superCls, int dit) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TInheritances values (");

        buffer.append(cls.getUniqueId());
        buffer.append(", ");
        buffer.append(superCls.getUniqueId());
        buffer.append(", ");
        buffer.append(dit);
        buffer.append(");");
        statements.println(buffer.toString());
        Iterator it = superCls.getInheritanceTypeAccesses().iterator();
        while (it.hasNext()) {
            InheritanceTypeAccess inh = (InheritanceTypeAccess) it.next();
            addInheritanceClosure(cls, inh.getAccessedSuperClass(), dit + 1);
        }
    }

	private void addStructuralAbstraction(StructuralAbstraction sa, int kind) {
		addModelElement(sa, kind, SCOPE_GLOBAL);
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TAbstractions values (");
        buffer.append(sa.getUniqueId());
        buffer.append(", '");
        buffer.append(sa.getSimpleName());
        buffer.append("', ");
        buffer.append(kind);
        buffer.append(", '");
        buffer.append(sa.getType());
        buffer.append("');");
        statements.println(buffer.toString());
        Iterator it = sa.getModelElements().iterator();
        while (it.hasNext()) {
        	ModelElement elem = (ModelElement)it.next();
			buffer = new StringBuffer();
	        buffer.append("insert into TAbstractionElements values (");
	        buffer.append(sa.getUniqueId());
	        buffer.append(", ");
	        buffer.append(elem.getUniqueId());
	        buffer.append(");");
	        statements.println(buffer.toString());
        }
	}
	
    public void visitArray(Array a) {
        addModelElement(a, TYPE_ARRAY, SCOPE_GLOBAL);
        addType(a, TYPE_ARRAY);
    }

	public void visitAttribute(Attribute a) {
		visitClass(a);
	}

    public void visitCastTypeAccess(CastTypeAccess cta) {
    	if (cta.getSurroundingCompositeAccess() != null)
    		addAccess(cta, TYPEACCESS_CAST, SCOPE_ACCESS, findAccessPosition(cta));    		
    	else if (cta.getSurroundingStatement() != null)
    		addAccess(cta, TYPEACCESS_CAST, SCOPE_STATEMENT, findAccessPosition(cta));
    	else
    		addAccess(cta, TYPEACCESS_CAST, SCOPE_LOCAL, findAccessPosition(cta));
    }

    public void visitCatchParameter(CatchParameter param) {
    	de.fzi.sissy.metamod.Package pack = null;
    	if (param.getSurroundingClass() != null)
    		pack = param.getSurroundingClass().getSurroundingPackage();
    	else if (param.getSurroundingFunction() instanceof GlobalFunction)
    		pack = ((GlobalFunction)param.getSurroundingFunction()).getSurroundingPackage();
        addVariable(param, VAR_CATCHPARAM, SCOPE_STATEMENT, pack, param.getSurroundingClass(), param.getSurroundingFunction(), -1);
    }

    public void visitClass(de.fzi.sissy.metamod.Class cls) {
        if (cls.isInterface())
            addClass(cls, TYPE_INTERFACE);
        else if (cls.isPrimitive())
        	addClass(cls, TYPE_PRIMITIVE);
        else
            addClass(cls, TYPE_CLASS);
    }

	public void visitClone(Clone cl) {
		addModelElement(cl, CLONE_CLONE, SCOPE_GLOBAL);
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into TClones values (");
		buffer.append(cl.getUniqueId());
		buffer.append(", ");
		CloneInstance inst = (CloneInstance)cl.getInstances().iterator().next(); 
		buffer.append(inst.getStatements().size());
		buffer.append(", ");
		Iterator it = inst.getStatements().iterator();
		int loc = 0;
		while (it.hasNext()) {
			Statement s = (Statement)it.next();
			loc += s.getLinesOfCode();
		}
		buffer.append(loc);
		buffer.append(");");
        statements.println(buffer.toString());
	}

	public void visitCloneInstance(CloneInstance ci) {
		addModelElement(ci, CLONE_INSTANCE, SCOPE_GLOBAL);
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into TCloneInstances values (");
		buffer.append(ci.getUniqueId());
		buffer.append(", ");
		buffer.append(ci.getClone().getUniqueId());
		buffer.append(", ");
		Iterator it = ci.getStatements().iterator();
		Statement s = null;
		
		if (it.hasNext())
			s = (Statement)it.next();
		
		if (s==null) {
			Debug.warning("ModelExporter: CloneInstance without Statement found!");
			buffer.append("-1");
		} else if (s.getSurroundingFunction()==null) {
			Debug.warning("ModelExporter: CloneInstance with Statement but without SurroundingFunction found!");
			buffer.append("-1");
		} else  {
			buffer.append(s.getSurroundingFunction().getUniqueId());
		}
		
		buffer.append(");");
        statements.println(buffer.toString());
        it = ci.getStatements().iterator();
        while (it.hasNext()) {
        	Statement st = (Statement)it.next();
        	buffer = new StringBuffer();
        	buffer.append("insert into TCloneInstanceStatements values (");
        	buffer.append(st.getUniqueId());
        	buffer.append(", ");
        	buffer.append(ci.getUniqueId());
        	buffer.append(");");
        	statements.println(buffer.toString());
        }
	}
	
	public void visitComment(Comment c) {
		addModelElement(c, COMMENT, SCOPE_FILE);
		addSourceEntity(c);
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TComments values (");
        buffer.append(c.getUniqueId());
        buffer.append(", ");
       	buffer.append(booleanToDB(c.isFormal()));
        buffer.append(", ");
       	buffer.append(c.getTodoCount());
        buffer.append(", ");
       	buffer.append(c.getNumberOfCommentLines());       
        buffer.append(", '");
        /*
	        String text = c.getText().replaceAll("'", "''");
	        text = text.replaceAll("\\\\", "\\\\\\");
	        text = text.replaceAll("\n", "\\\\n");
	        text = text.replaceAll("\b", "\\\\b");
	        text = text.replaceAll("\f", "\\\\f");
	        text = text.replaceAll("\r", "\\\\r");
	       	buffer.append(text);
       	*/       	
        buffer.append("');");
        statements.println(buffer.toString());	
	}

	public void visitCompositeAccess(CompositeAccess ca) {
    	if (ca.getSurroundingCompositeAccess() != null)
    		addAccess(ca, COMPOSITEACCESS, SCOPE_ACCESS, findAccessPosition(ca));    		
    	else if (ca.getSurroundingStatement() != null)
    		addAccess(ca, COMPOSITEACCESS, SCOPE_STATEMENT, findAccessPosition(ca));
    	else
    		addAccess(ca, COMPOSITEACCESS, SCOPE_LOCAL, findAccessPosition(ca));		
	}
	
	public void visitConstructor(Constructor c) {
		int kind = FUNC_CONSTRUCTOR;
		if (c.isInitializer())
			kind = FUNC_INITIALIZER;
        addFunction(c, kind, SCOPE_CLASS);
        addMember(c, kind);
    }

	public void visitDeclarationTypeAccess(DeclarationTypeAccess dta) {
		if (dta.getSurroundingVariable() != null)
			addAccess(dta, TYPEACCESS_DECLARATION, SCOPE_DECLARATION, findAccessPosition(dta));
		else if (dta.getSurroundingFunction() != null)
			addAccess(dta, TYPEACCESS_DECLARATION, SCOPE_LOCAL, findAccessPosition(dta));
		else
			addAccess(dta, TYPEACCESS_DECLARATION, -1, findAccessPosition(dta));			
	}

	public void visitDelegate(Delegate d) {
		if (d.getSurroundingClass() != null)
	        addFunction(d, FUNC_TYPE_DELEGATE, SCOPE_CLASS);
		else
	        addFunction(d, FUNC_TYPE_DELEGATE, SCOPE_PACKAGE);
		addType(d, FUNC_TYPE_DELEGATE);
		addSourceEntity(d);
		addMember(d, FUNC_TYPE_DELEGATE);
	}

	public void visitDelegateAccess(DelegateAccess da) {
    	if (da.getSurroundingCompositeAccess() != null)
    		addAccess(da, DELEGATEACCESS, SCOPE_ACCESS, findAccessPosition(da));    		
    	else if (da.getSurroundingStatement() != null)
    		addAccess(da, DELEGATEACCESS, SCOPE_STATEMENT, findAccessPosition(da));
    	else
    		addAccess(da, DELEGATEACCESS, SCOPE_LOCAL, findAccessPosition(da));
	}

	public void visitDestructor(Destructor d) {
        addFunction(d, FUNC_DESTRUCTOR, SCOPE_CLASS);
        addMember(d, FUNC_DESTRUCTOR);
    }

    public void visitField(Field f) {
    	if (f.getSurroundingClass() != null)
    		addVariable(f, VAR_FIELD, SCOPE_CLASS, f.getSurroundingClass().getSurroundingPackage(), f.getSurroundingClass(), null, -1);
    	else
    		addVariable(f, VAR_FIELD, SCOPE_CLASS, null, null, null, -1);
        addMember(f, VAR_FIELD);
    }

    public void visitFile(File f) {
        if (f.isSourceFile())
            addModelElement(f, FILE_SOURCE, SCOPE_GLOBAL);
        else
            addModelElement(f, FILE_ASSEMBLY, SCOPE_GLOBAL);

        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TFiles values (");
        buffer.append(f.getUniqueId());
        buffer.append(", ");
        if (f.isSourceFile())
        	buffer.append(FILE_SOURCE);
        else
        	buffer.append(FILE_ASSEMBLY);
        buffer.append(", '");
        StringBuffer tmp = new StringBuffer();
        if (f.getPathName() != null) {
	        tmp.append(f.getPathName());
	        int i = 0;
	        while (i < tmp.length()) {
	        	if (tmp.charAt(i) == '\\') {
	        		tmp.insert(i, '\\');
	        		i++;
	        	}
	        	i++;
	        }
        }
        buffer.append(tmp.toString());
        buffer.append("', ");
        buffer.append(f.getLinesOfCode());
        buffer.append(");");
        statements.println(buffer.toString());
        Iterator it = f.getIncludedFiles().iterator();
        while (it.hasNext()) {
            ModelElement elem = (ModelElement) it.next();
            addImport(f, elem, FILE_SOURCE);
            addIncludeClosure(f, (File)elem, new ModelElementList(), 1);
        }
        it = f.getImportedPackages().iterator();
        while (it.hasNext()) {
        	de.fzi.sissy.metamod.Package elem = (de.fzi.sissy.metamod.Package) it.next();
            if (elem.getSurroundingPackage() != null)
                addImport(f, elem, PACK_SUBPACKAGE);
            else
                addImport(f, elem, PACK_PACKAGE);
        }
        it = f.getImportedTypes().iterator();
        while (it.hasNext()) {
        	de.fzi.sissy.metamod.Type elem = (de.fzi.sissy.metamod.Type) it.next();
        	addImport(f, elem, determineKind(elem));
        }
        it = f.getImportedGlobalFunctions().iterator();
        while (it.hasNext()) {
            Function elem = (Function) it.next();
            addImport(f, elem, determineKind(elem));
        }
        it = f.getImportedGlobalVariables().iterator();
        while (it.hasNext()) {
            ModelElement elem = (ModelElement) it.next();
            addImport(f, elem, VAR_GLOBALVAR);
        }
    }

    public void visitFormalParameter(FormalParameter param) {
    	de.fzi.sissy.metamod.Package pack = null;
    	if (param.getSurroundingClass() != null)
    		pack = param.getSurroundingClass().getSurroundingPackage();
    	else if (param.getSurroundingFunction() instanceof GlobalFunction)
    		pack = ((GlobalFunction)param.getSurroundingFunction()).getSurroundingPackage();
    	int i = 0, pos = -1;
    	if (param.getSurroundingFunction() != null) {
	    	Iterator it = param.getSurroundingFunction().getFormalParameters().iterator();
	    	while (it.hasNext()) {
	    		i++;
	    		if (it.next() == param)
	    			pos = i; 
	    	}
    	}
        addVariable(param, VAR_FORMALPARAM, SCOPE_LOCAL, pack, param.getSurroundingClass(), param.getSurroundingFunction(), pos);
    }

    public void visitFunctionAccess(FunctionAccess fa) {
    	if (fa.getSurroundingCompositeAccess() != null)
    		addAccess(fa, FUNCACCESS, SCOPE_ACCESS, findAccessPosition(fa));
    	else if (fa.getSurroundingStatement() != null)
    		addAccess(fa, FUNCACCESS, SCOPE_STATEMENT, findAccessPosition(fa));
    	else
    		addAccess(fa, FUNCACCESS, SCOPE_LOCAL, findAccessPosition(fa));
    }

    public void visitGenericClass(GenericClass gc) {
        if (gc.isInterface())
            addClass(gc, TYPE_GENERICINTERFACE);
        else
            addClass(gc, TYPE_GENERICCLASS);
        Iterator it = gc.getTypeParameters().iterator();
        int pos = 0;
        while (it.hasNext()) {
            TypeParameterClass tpc = (TypeParameterClass) it.next();
            StringBuffer buffer;
            addTypeParameter(gc, tpc, ++pos);
        }
    }

    public void visitGenericFunction(GenericFunction gf) {
        addFunction(gf, FUNC_GENERICFUNC, SCOPE_PACKAGE);
        Iterator it = gf.getTypeParameters().iterator();
        int pos = 0;
        while (it.hasNext()) {
            TypeParameterClass tpc = (TypeParameterClass) it.next();
            addTypeParameter(gf, tpc, ++pos);
        }
    }

	public void visitGenericConstructor(GenericConstructor gc) {
        addFunction(gc, FUNC_GENERICCONSTRUCTOR, SCOPE_PACKAGE);
        addMember(gc, FUNC_GENERICMETHOD);
        Iterator it = gc.getTypeParameters().iterator();
        int pos = 0;
        while (it.hasNext()) {
            TypeParameterClass tpc = (TypeParameterClass) it.next();
            addTypeParameter(gc, tpc, ++pos);
        }
	}

	public void visitGenericMethod(GenericMethod gm) {
        addFunction(gm, FUNC_GENERICMETHOD, SCOPE_PACKAGE);
        addMember(gm, FUNC_GENERICMETHOD);
        Iterator it = gm.getTypeParameters().iterator();
        int pos = 0;
        while (it.hasNext()) {
            TypeParameterClass tpc = (TypeParameterClass) it.next();
            addTypeParameter(gm, tpc, ++pos);
        }
	}    
    
    public void visitGlobalFunction(GlobalFunction gf) {
        if (gf.isUnitInitializer())
        	addFunction(gf, FUNC_UNITINITIALIZER, SCOPE_PACKAGE);
        else if (gf.isUnitFinalizer())
        	addFunction(gf, FUNC_UNITFINALIZER, SCOPE_PACKAGE);        	
        else
        	addFunction(gf, FUNC_GLOBALFUNC, SCOPE_PACKAGE);
    }

    public void visitGlobalVariable(GlobalVariable gv) {
        addVariable(gv, VAR_GLOBALVAR, SCOPE_PACKAGE, gv.getSurroundingPackage(), null, null, -1);
    }

    public void visitInheritanceTypeAccess(InheritanceTypeAccess ita) {
    	if (ita.isImplementationInheritance())
            addAccess(ita, TYPEACCESS_IMPLEMENTATIONINHERITANCE, SCOPE_CLASS, findAccessPosition(ita));
    	else 
    		addAccess(ita, TYPEACCESS_INTERFACEINHERITANCE, SCOPE_CLASS, findAccessPosition(ita));
        addInheritanceClosure(ita.getSurroundingClass(), ita.getAccessedSuperClass(), 1);
    }

    public void visitLocalVariable(LocalVariable lv) {
    	de.fzi.sissy.metamod.Package pack = null;
    	if (lv.getSurroundingClass() != null)
    		pack = lv.getSurroundingClass().getSurroundingPackage();
    	else if (lv.getSurroundingFunction() instanceof GlobalFunction)
    		pack = ((GlobalFunction)lv.getSurroundingFunction()).getSurroundingPackage();
        addVariable(lv, VAR_LOCALVAR, SCOPE_LOCAL, pack, lv.getSurroundingClass(), lv.getSurroundingFunction(), -1);
    }

    public void visitMethod(Method m) {
        if (m.isPropertyMethod()) {
        	int kind = determineKind(m);
            addFunction(m, kind, SCOPE_PROPERTY);
            addMember(m, kind);
        }
        else {
            addFunction(m, FUNC_METHOD, SCOPE_CLASS);
            addMember(m, FUNC_METHOD);
        }
    }

    public void visitPackage(de.fzi.sissy.metamod.Package pack) {
        if (pack.getSurroundingPackage() != null)
            addPackage(pack, PACK_SUBPACKAGE, -1);
        else
            addPackage(pack, PACK_PACKAGE, -1);
    }

	public void visitPackageAlias(PackageAlias pa) {
        addPackage(pa, PACK_PACKAGEALIAS, pa.getAliasedPackage().getUniqueId());
	}

    public void visitProperty(Property p) {
		if (p.getSurroundingClass() != null)
			addVariable(p, VAR_PROPERTY, SCOPE_CLASS, p.getSurroundingClass().getSurroundingPackage(), p.getSurroundingClass(), null, -1);
		else
			addVariable(p, VAR_PROPERTY, SCOPE_CLASS, null, null, null, -1);			
        addMember(p, VAR_PROPERTY);
    }

	public void visitPropertyAccess(PropertyAccess pa) {
        int kind;
        if (pa.isReadAccess())
            kind = PROPACCESS_READ;
        else
            kind = PROPACCESS_WRITE;
    	if (pa.getSurroundingCompositeAccess() != null)
    		addAccess(pa, kind, SCOPE_ACCESS, findAccessPosition(pa));
    	else if (pa.getSurroundingStatement() != null)
        	addAccess(pa, kind, SCOPE_STATEMENT, findAccessPosition(pa));
        else
        	addAccess(pa, kind, SCOPE_LOCAL, findAccessPosition(pa));
	}

	public void visitReference(Reference r) {
		if (r.isImplicit()) {
	        addModelElement(r, TYPE_IMPLICITREFERENCE, SCOPE_GLOBAL);
	        addType(r, TYPE_IMPLICITREFERENCE);
		}
		else {
	        addModelElement(r, TYPE_EXPLICITREFERENCE, SCOPE_GLOBAL);
	        addType(r, TYPE_EXPLICITREFERENCE);
		}
	}

	public void visitRoot(Root r) {
        addModelElement(r, ROOT, -1);
    }

	public void visitSelfAccess(SelfAccess sa) {
		int kind = SELFACCESS_THIS;
		if (sa.isSuperAccess())
			kind = SELFACCESS_SUPER;
    	if (sa.getSurroundingCompositeAccess() != null)
    		addAccess(sa, kind, SCOPE_ACCESS, findAccessPosition(sa));
    	else if (sa.getSurroundingStatement() != null)
        	addAccess(sa, kind, SCOPE_STATEMENT, findAccessPosition(sa));
        else
        	addAccess(sa, kind, SCOPE_LOCAL, findAccessPosition(sa));		
	}

	public void visitStatement(Statement st) {
		if (st.getContainer() != null)
			addModelElement(st, determineKind(st), SCOPE_STATEMENT);
		else
			addModelElement(st, determineKind(st), SCOPE_LOCAL);
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into TStatements values (");
        buffer.append(st.getUniqueId());
        buffer.append(", ");
        buffer.append(determineKind(st));
        buffer.append(", ");
        if (st.getSurroundingFunction() != null)
        	buffer.append(st.getSurroundingFunction().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
        if (st.getContainer() != null)
        	buffer.append(st.getContainer().getUniqueId());
        else
        	buffer.append(-1);
        buffer.append(", ");
       	buffer.append(st.getStatementPosition(st));
        buffer.append(");");
        statements.println(buffer.toString());
        addSourceEntity(st);
	}
	
	public void visitStaticTypeAccess(StaticTypeAccess sa) {
    	if (sa.getSurroundingCompositeAccess() != null)
    		addAccess(sa, TYPEACCESS_STATIC, SCOPE_ACCESS, findAccessPosition(sa));
    	else if (sa.getSurroundingStatement() != null)
    		addAccess(sa, TYPEACCESS_STATIC, SCOPE_STATEMENT, findAccessPosition(sa));
    	else
    		addAccess(sa, TYPEACCESS_STATIC, SCOPE_LOCAL, findAccessPosition(sa));		
	}

	public void visitStructuralAbstraction(StructuralAbstraction sa) {
		addStructuralAbstraction(sa, ABSTRACTION_STRUCTURALABSTRACTION);
	}

	public void visitSubsystem(Subsystem s) {
		addStructuralAbstraction(s, ABSTRACTION_SUBSYSTEM);
	}
	
    public void visitThrowTypeAccess(ThrowTypeAccess tta) {
    	if (tta.isDeclared() || (tta.getSurroundingStatement() == null))
        	addAccess(tta, TYPEACCESS_DECLAREDTHROW, SCOPE_LOCAL, findAccessPosition(tta));
        else
        	addAccess(tta, TYPEACCESS_THROW, SCOPE_STATEMENT, findAccessPosition(tta));
    }

	public void visitTypeAlias(TypeAlias ta) {
		if (ta.getSurroundingClass() != null) {
	        addModelElement(ta, TYPE_TYPEALIAS, SCOPE_CLASS);
	        addSourceEntity(ta);
			addType(ta, TYPE_TYPEALIAS);
		}
		else {
	        addModelElement(ta, TYPE_TYPEALIAS, SCOPE_PACKAGE);
	        addSourceEntity(ta);
			addType(ta, TYPE_TYPEALIAS);
		}
	}
	
	public void visitRunTimeTypeAccess(RunTimeTypeAccess rtta) {
    	if (rtta.getSurroundingCompositeAccess() != null)
    		addAccess(rtta, TYPEACCESS_RTTI, SCOPE_ACCESS, findAccessPosition(rtta));
    	else if (rtta.getSurroundingStatement() != null)
    		addAccess(rtta, TYPEACCESS_RTTI, SCOPE_STATEMENT, findAccessPosition(rtta));
    	else
    		addAccess(rtta, TYPEACCESS_RTTI, SCOPE_LOCAL, findAccessPosition(rtta));		
	}

    public void visitTypeParameterClass(TypeParameterClass cls) {
        addClass(cls, TYPE_TYPEPARAMCLASS);
    }

    public void visitVariableAccess(VariableAccess va) {
        int kind;
        if (va.isReadAccess())
            kind = VARACCESS_READ;
        else
            kind = VARACCESS_WRITE;
    	if (va.getSurroundingCompositeAccess() != null)
    		addAccess(va, kind, SCOPE_ACCESS, findAccessPosition(va));
    	else if (va.getSurroundingStatement() != null)
        	addAccess(va, kind, SCOPE_STATEMENT, findAccessPosition(va));
        else
        	addAccess(va, kind, SCOPE_LOCAL, findAccessPosition(va));
    }

	private void exportParsingErrors() {
	    Iterator it = ParsingErrorHelper.getInstance().iterator();
        while (it.hasNext()) {
            ParsingErrorHelper.TErrorElement elem = (ParsingErrorHelper.TErrorElement) it.next();
            StringBuffer buffer = new StringBuffer();
            buffer.append("insert into TErrors values (\'");
            buffer.append(elem.timestamp);
            buffer.append("\', ");
            buffer.append(elem.kindOfError);
            buffer.append(", \'");
            buffer.append(elem.filename.replace("\\", "\\\\"));
            buffer.append("\', ");
            buffer.append(elem.lineNumber);
            buffer.append(", \'");
            buffer.append(elem.message.replace("\\", "\\\\"));
            buffer.append("\');");
            statements.println(buffer.toString());
        }
    }
    
    public void export() {
		
        exportParsingErrors();
        
        ModelElementRepository rep = root.getRepository();
		int total = rep.getSize();
		int count = 1;
		System.out.print("Sorting model elements...");
		Iterator it = rep.getModelElements().iterator();
		System.out.println("Done");
		System.out.println("  0% Model export starts...");
		while (it.hasNext()) {
			if (count % 1000 == 0) {
				int proc = Math.round(((float)count) / total * 100);
				String procstr = null;
				if (proc < 10)
					procstr = "  " + String.valueOf(proc);
				else if (proc < 100)
					procstr = " " + String.valueOf(proc);
				else
					procstr = String.valueOf(proc);
				if (procstr != null)
					System.out.println(procstr + "% Exporting id: " + count + "/" + total);
			}
			ModelElement elem = (ModelElement)it.next();
			elem.acceptVisitor(this);
			count++;
		}
		System.out.println("\r100% (done)");
	}

	public void run() {
		jdbcWrapper.runStatements(inPipe);
	}
}