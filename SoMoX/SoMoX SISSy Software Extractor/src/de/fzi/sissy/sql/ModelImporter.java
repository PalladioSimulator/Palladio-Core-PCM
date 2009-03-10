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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import de.fzi.sissy.metamod.*;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.util.Debug;

/**
 * The ModelImporter connects to a given database (specified in res/sql/jdbc.cfg
 * or by special parameters given to the constructor of the ModelImporter) and
 * tries to build up the Metamodel of the QBench-Project only with the data
 * given in that database!
 * 
 * Therefore I reference on (Abbildung 3.10: Der Kern der Modellelemente) in the
 * MetaMod-v2.0.pdf (doc/*).
 *
 * @author Thorsten Blum
 * @author Mircea Trifu
 * 
 */
public class ModelImporter implements SQLModelConstants {

    private Root root;

    private int counter = 0;

    private ModelElementRepository repository;

    private JDBCWrapper connectionManager;

    private HashMap idToModelElement;

    /* Constructor / no parameters */
    public ModelImporter() {
        try {
            connectionManager = new JDBCWrapper();
            restoreDbTables();
            connectionManager.getConnection().close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    /* Special constructor with parameters */
    public ModelImporter(JDBCWrapper jdbcWrapper) {
        try {
            connectionManager = jdbcWrapper;
            restoreDbTables();
            connectionManager.getConnection().close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     * Restore tables from database.
     */
    private void restoreDbTables() {
        try {
            // Create new HashMap.
            idToModelElement = new HashMap();

            // Create new ModelElementRepository using static method
            // "ModelElementRepository.newRepository()"
            repository = ModelElementRepository.newRepository();

            root = repository.getRoot();

            restorePackages();
            restoreFiles();
            restoreTypes();
            restoreFunctions();
            // restoreDelegateInvocations();            
            restoreFriends();
            restoreTypeParameters();            
            restoreStatements();
            restoreClones();            
            restoreVariables();            
            restoreMembers();    
            restorePropertyAccessors();            
            restoreFileInclusionsAndImports();           
            restoreAccesses();
            restoreTypeArguments();
            restoreStructuralAbstractions();
            restoreComments();
            restorePositions();
            // Add annotations to model elements and set the failed dependency flag
            restoreAnnotationsAndStatus();
            System.out.println("Import finished.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Restores packages.
     */
    private void restorePackages() throws SQLException {
        ModelElementList packageList = new ModelElementList();

        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT p.*, e.Scope FROM TPackages AS p, TModelElements AS e WHERE p.id = e.id";
        System.out.println(">>> restorePackages :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        /* For each package ... */
        while (rs.next()) {
            loadPackage(rs);
        }

        // Moves cursor to the front of ResultSet object
        rs = stmt.executeQuery(query);

        /* For each package... */
        while (rs.next()) {
            loadSubPackagesAndAliases(rs);
        }

        System.out.println();
    } /* done */

    /*
     * Load package from given ResultSet.
     */
    private void loadPackage(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        String simpleName = rs.getString("Name");

        de.fzi.sissy.metamod.Package pack;
        if (rs.getInt("KindOfPackage") == PACK_PACKAGEALIAS)
        	pack = new PackageAlias(simpleName, root, null);
        else
        	pack = new de.fzi.sissy.metamod.Package(simpleName, root);
        pack.setUniqueId(id);

        idToModelElement.put(new Integer(id), pack);
    } /* done */

    /*
     * Load package from given ResultSet including subpackages.
     */
    private void loadSubPackagesAndAliases(ResultSet rs) throws SQLException {
        int parentid = rs.getInt("ParentPackageId");
        int aliasid = rs.getInt("AliasedPackageId");
        int id = rs.getInt("Id");

        de.fzi.sissy.metamod.Package currentPackage = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(id));

        /*
         * If the package is a SUBPACKAGE or the scope field in the tmodelelemts
         * is SCOPE_PACKAGE, then add the current package to its parent package.
         * If scope is SCOPE_GLOBAL, simply add the package to the Root.
         */
        if (rs.getInt("Scope") == SCOPE_PACKAGE) {
        	de.fzi.sissy.metamod.Package parent = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(parentid));
            // Add current package to its parent package.
            parent.addSubPackage(currentPackage);
        }
        
        if (rs.getInt("KindOfPackage") == PACK_PACKAGEALIAS)
        	((PackageAlias)currentPackage).setAliasedPackage((de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(aliasid)));
    }

    //#########################################

    /*
     * Restores files.
     */
    private void restoreFiles() throws SQLException {
        // Open database connection...
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TFiles";
        System.out.println(">>> restoreFiles :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        // Build File-Object with pathname for each file ...
        while (rs.next()) {
            File file = loadFile(rs);

            // Add "file" to Root.
            root.addFile(file);
        }
    } /* done */

    /*
     * Load file from given ResultSet.
     */
    private File loadFile(ResultSet rs) throws SQLException {
        File file = new File(rs.getString("pathname"));

        int id = rs.getInt("Id");
        int loc = rs.getInt("LinesOfCode");
        
        // Set unique id for each file.
        file.setUniqueId(id);
        file.setLinesOfCode(loc);
        
        if (rs.getInt("KindOfFile") == FILE_ASSEMBLY)
        	file.setAssembly();
        else
        	file.setSourceFile();

        // Store "id" and associated "file" in hashmap.
        idToModelElement.put(new Integer(id), file);

        return file;
    } /* done */

    /*
     * Restore types.
     */
    private void restoreTypes() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TTypes t ORDER BY t.Id";
        System.out.println(">>> restoreTypes :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        /* For each type ... */
        while (rs.next()) {
            int id = rs.getInt("Id");
            int kindoftype = rs.getInt("KindOfType");
            String name = new String(rs.getString("Name"));

            de.fzi.sissy.metamod.Class c = null;

            if (kindoftype == TYPE_CLASS || kindoftype == TYPE_INTERFACE) {
                c = new de.fzi.sissy.metamod.Class(name, false);
            } else if (kindoftype == TYPE_GENERICCLASS || kindoftype == TYPE_GENERICINTERFACE) {
                c = new GenericClass(name, false);
            } else if (kindoftype == TYPE_TYPEPARAMCLASS) {
                c = new TypeParameterClass(name, false);
	        } else if (kindoftype == TYPE_PRIMITIVE) {
	            c = new de.fzi.sissy.metamod.Class(name, false);
	            c.setPrimitive();
	        }

            if (c != null) {
                c.setUniqueId(id);
                                
                root.addType(c);
                int packId = rs.getInt("PackageId");

                if (packId != -1) {
                	de.fzi.sissy.metamod.Package pack = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(packId));
                    pack.addClass(c);
                }

                if (kindoftype == TYPE_GENERICINTERFACE || kindoftype == TYPE_INTERFACE)
                    c.setInterface();
                
                if (rs.getBoolean("IsReferenceType"))
                	c.setReferenceType();

                // Store "id" and associated "class" in hashmap.
                idToModelElement.put(new Integer(id), c);
            }
  
            if (kindoftype == FUNC_TYPE_DELEGATE) {
            	Delegate d = new Delegate(name);
            	root.addType(d);
                int packId = rs.getInt("PackageId");

                if (packId != -1) {
                	de.fzi.sissy.metamod.Package pack = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(packId));
                    pack.addDelegate(d);
                }
                
                if (rs.getBoolean("IsReferenceType"))
                	d.setReferenceType();

                // Store "id" and associated "delegate" in hashmap.
                idToModelElement.put(new Integer(id), d);            	
            }
            else if (kindoftype == TYPE_TYPEALIAS) {
            	int decoratedTypeId = rs.getInt("DecoratedTypeId");
            	Type dType = (Type)idToModelElement.get(new Integer(decoratedTypeId));
            	TypeAlias a = new TypeAlias(dType, name);
            	root.addType(a);
                int packId = rs.getInt("PackageId");

                if (packId != -1) {
                	de.fzi.sissy.metamod.Package pack = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(packId));
                    pack.addTypeAlias(a);
                }
                
                if (rs.getBoolean("IsReferenceType"))
                	a.setReferenceType();

                // Store "id" and associated "type alias" in hashmap.
                idToModelElement.put(new Integer(id), a);            	            	
            }
            else if (kindoftype == TYPE_IMPLICITREFERENCE || kindoftype == TYPE_EXPLICITREFERENCE) {
            	int decoratedTypeId = rs.getInt("DecoratedTypeId");
            	Type dType = (Type)idToModelElement.get(new Integer(decoratedTypeId));
                Reference ref = new Reference(dType, name);
                ref.setUniqueId(id);
                
                if (kindoftype == TYPE_IMPLICITREFERENCE)
                	ref.setImplicit();
                else
                	ref.setExplicit();
                
                root.addType(ref);
                
                if (rs.getBoolean("IsReferenceType"))
                	ref.setReferenceType();

                idToModelElement.put(new Integer(id), ref);
            } else if (kindoftype == TYPE_ARRAY) {
            	int decoratedTypeId = rs.getInt("DecoratedTypeId");
            	Type dType = (Type)idToModelElement.get(new Integer(decoratedTypeId));
            	Array array = new Array(dType);

                array.setUniqueId(id);
                root.addType(array);

                if (rs.getBoolean("IsReferenceType"))
                	array.setReferenceType();

                idToModelElement.put(new Integer(id), array);
            }
        }

        // Moves cursor to the front of ResultSet object
        rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("Id");
            int classId = rs.getInt("ClassId");

            if (classId != -1) {
            	de.fzi.sissy.metamod.Member innerType = (de.fzi.sissy.metamod.Member)idToModelElement.get(new Integer(id));
                de.fzi.sissy.metamod.Class parentClass = (de.fzi.sissy.metamod.Class) idToModelElement.get(new Integer(classId));
                if (innerType instanceof Delegate)
                	parentClass.addInnerDelegate((Delegate)innerType);
                else if (innerType instanceof TypeAlias)
                	parentClass.addInnerTypeAlias((TypeAlias)innerType);
                else if (innerType instanceof de.fzi.sissy.metamod.Class)
                	parentClass.addInnerClass((de.fzi.sissy.metamod.Class)innerType);
            }
        }
    } /* done */
    
    private void restoreFriends() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TFriends";
        System.out.println(">>> restoreFriends: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int typeId = rs.getInt("TypeId");
        	int kindoffriend = rs.getInt("KindOfFriend");
        	int friendId = rs.getInt("FriendId");
        	de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(typeId));        	
        	ModelElement elem = (ModelElement)idToModelElement.get(new Integer(friendId));
        	if (elem instanceof de.fzi.sissy.metamod.Class)
        		c.addFriendClass((de.fzi.sissy.metamod.Class)elem);
        	else
        		c.addFriendFunction((Function)elem);
        }
    }

    private void restoreTypeParameters() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TTypeParameters ORDER BY GenericElementId, Position";
        System.out.println(">>> restoreTypeParameters: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int genElemId = rs.getInt("GenericElementId");
        	int typeId = rs.getInt("TypeParameterId");
        	GenericEntity ge = (GenericEntity)idToModelElement.get(new Integer(genElemId));        	
        	TypeParameterClass tpc = (TypeParameterClass)idToModelElement.get(new Integer(typeId));
        	ge.addTypeParameter(tpc);
        }    	
    }

    /*
     * Restore functions.
     */
    private void restoreFunctions() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT TFunctions.*, TAccesses.Id as AccId, TAccesses.TargetId, TModelElements.ParentId FROM TFunctions INNER JOIN TModelElements ON TFunctions.Id = TModelElements.Id LEFT OUTER JOIN TAccesses ON TFunctions.ReturnTypeDeclarationId = TAccesses.Id";
        System.out.println(">>> restoreFunctions :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        /* For each function... */
        while (rs.next()) {
            int id = rs.getInt("Id");
            int parentId = rs.getInt("Parentid");
            int kindoffunction = rs.getInt("KindOfFunction");

            Function function = null;

            if (kindoffunction == FUNC_GLOBALFUNC || kindoffunction == FUNC_UNITINITIALIZER || kindoffunction == FUNC_UNITFINALIZER) {
                function = loadGlobalFunction(rs);
                if (kindoffunction == FUNC_UNITINITIALIZER)
                	((GlobalFunction)function).setKind(GlobalFunction.UNIT_INITIALIZER);
                else if (kindoffunction == FUNC_UNITFINALIZER)
                	((GlobalFunction)function).setKind(GlobalFunction.UNIT_FINALIZER);
            } else if (kindoffunction == FUNC_GENERICFUNC) {
                function = loadGenericFunction(rs);
            } else if (kindoffunction == FUNC_GENERICCONSTRUCTOR) {
                function = loadGenericConstructor(rs);
            } else if (kindoffunction == FUNC_GENERICMETHOD) {
                function = loadGenericMethod(rs);                
            } else if (kindoffunction == FUNC_METHOD || kindoffunction == FUNC_PROPGETTER || kindoffunction == FUNC_PROPSETTER) {
                function = loadMethod(rs);
            } else if (kindoffunction == FUNC_CONSTRUCTOR) {
                function = loadConstructor(rs);
            } else if (kindoffunction == FUNC_DESTRUCTOR) {
                function = loadDestructor(rs);
            } else if (kindoffunction == FUNC_INITIALIZER) {
                function = loadInitializer(rs);
            } else if (kindoffunction != FUNC_TYPE_DELEGATE) {
            	function = (Delegate)idToModelElement.get(new Integer(id));
            } else {
                System.out.println("Didn't catch this type of function yet.\n");
                continue;
            }

            function.setOperator(rs.getBoolean("IsOperator"));
            function.setLinesOfComments(rs.getInt("NumberOfComments"));
            function.setNumberOfStatements(rs.getInt("NumberOfStatements"));
            function.setNumberOfEdgesInCFG(rs.getInt("NumberOfEdges"));
            function.setNumberOfNodesInCFG(rs.getInt("NumberOfNodes"));
            function.setMaximumNestingLevel(rs.getInt("MaxNestingLevel"));
            
            if (rs.getInt("ReturnTypeDeclarationId") != -1) {
	            Type type = (Type)idToModelElement.get(new Integer(rs.getInt("TargetId")));
	            DeclarationTypeAccess dta = new DeclarationTypeAccess(type);
	            dta.setUniqueId(rs.getInt("AccId"));
	            function.setReturnTypeDeclaration(dta);
	            idToModelElement.put(new Integer(dta.getUniqueId()), dta);	            
            }

            // Store "id" and associated "function" in hashmap.
            idToModelElement.put(new Integer(id), function);
        }
    } /* done */

    /*
     * Load global function from given ResultSet.
     */
    private GlobalFunction loadGlobalFunction(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int packid = rs.getInt("PackageId");
        String name = rs.getString("Name");

        GlobalFunction globalFunction = new GlobalFunction(name);
        globalFunction.setUniqueId(id);
        root.addGlobalFunction(globalFunction);
        de.fzi.sissy.metamod.Package pack = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(packid));
        if (pack != null) 
        	pack.addGlobalFunction(globalFunction);
        
        return globalFunction;
    } /* done */

    /*
     * Load generic function from given ResultSet.
     */
    private GenericFunction loadGenericFunction(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int packid = rs.getInt("PackageId");
        String name = rs.getString("Name");

        GenericFunction genericFunction = new GenericFunction(name);
        genericFunction.setUniqueId(id);
        root.addGlobalFunction(genericFunction);
        de.fzi.sissy.metamod.Package pack = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(packid));
        pack.addGlobalFunction(genericFunction);

        return genericFunction;
    } /* done */

    /*
     * Load constructor from given ResultSet.
     */
    private Constructor loadGenericConstructor(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int classId = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Constructor c = new GenericConstructor(name);
        c.setUniqueId(id);
        de.fzi.sissy.metamod.Class cls = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(classId));
        if (cls == null) 
        	System.err.println("Error reconstructing constructor: " + name + "(" + classId + ")");
        else
        	cls.addConstructor(c);
        
        return c;
    } /* done */

    /*
     * Load method from given ResultSet.
     */
    private Method loadGenericMethod(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int classId = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Method method = new GenericMethod(name);
        method.setUniqueId(id);
        de.fzi.sissy.metamod.Class cls = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(classId));
        if (cls != null) {
        	cls.addMethod(method);
        } else {
        	System.err.println("Error reconstructing method " + name);
        }
        
        return method;
    } /* done */

    
    
    /*
     * Load method from given ResultSet.
     */
    private Method loadMethod(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int classId = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Method method = new Method(name);
        method.setUniqueId(id);
        de.fzi.sissy.metamod.Class cls = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(classId));
        if (cls != null) {
        	cls.addMethod(method);
        } else {
        	System.err.println("Error reconstructing method " + name);
        }
        
        return method;
    } /* done */

    /*
     * Load constructor from given ResultSet.
     */
    private Constructor loadConstructor(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int classId = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Constructor c = new Constructor(name);
        c.setUniqueId(id);
        de.fzi.sissy.metamod.Class cls = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(classId));
        if (cls == null) 
        	System.err.println("Error reconstructing constructor: " + name + "(" + classId + ")");
        else
        	cls.addConstructor(c);
        
        return c;
    } /* done */

    /*
     * Load destructor from given ResultSet.
     */
    private Destructor loadDestructor(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int classId = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Destructor d = new Destructor(name);
        d.setUniqueId(id);
        de.fzi.sissy.metamod.Class cls = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(classId));
        cls.addDestructor(d);
        
        return d;
    } /* done */

    /*
     * Load initializer from given ResultSet.
     */
    private Constructor loadInitializer(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int classId = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Constructor i = new Constructor(name);
        i.setUniqueId(id);
        i.setInitializer();
        de.fzi.sissy.metamod.Class cls = (de.fzi.sissy.metamod.Class)idToModelElement.get(new Integer(classId));
        cls.addConstructor(i);
        
        return i;
    } /* done */
    
    private void restoreDelegateInvocations() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TDelegateInvocations";
        System.out.println(">>> restoreDelegateInvocations :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int delegateId = rs.getInt("DelegateId");
        	int funcId = rs.getInt("FunctionId");
        	Delegate d = (Delegate)idToModelElement.get(new Integer(delegateId));
        	Function f = (Function)idToModelElement.get(new Integer(funcId));
        	d.addInvokedFunction(f);
        }
    }
        
    private void restoreClones() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TClones";
        System.out.println(">>> restoreClones :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int id = rs.getInt("Id");
        	Clone c = new Clone();
        	c.setUniqueId(id);
        	root.addClone(c);
        	idToModelElement.put(new Integer(id), c);
        }

        stmt = con.createStatement();
        query = "SELECT * FROM TCloneInstances";
        rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int id = rs.getInt("Id");
        	int cid = rs.getInt("CloneId");
        	CloneInstance ci = new CloneInstance();
        	ci.setUniqueId(id);
        	Clone c = (Clone)idToModelElement.get(new Integer(cid));
        	c.addCloneInstance(ci);
        	idToModelElement.put(new Integer(id), ci);
        }

        stmt = con.createStatement();
        query = "SELECT * FROM TCloneInstanceStatements";
        rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int sid = rs.getInt("StatementId");
        	int ciid = rs.getInt("CloneInstanceId");
        	CloneInstance ci = (CloneInstance)idToModelElement.get(new Integer(ciid));
        	de.fzi.sissy.metamod.Statement s = (de.fzi.sissy.metamod.Statement)idToModelElement.get(new Integer(sid));
        	ci.addStatement(s);
        }    
    }

    private void restoreStatements() throws SQLException {
        // Open database connection ...
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TStatements ORDER BY FunctionId, Id";
        System.out.println(">>> restoreStatements :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int id = rs.getInt("Id");
        	int kind = rs.getInt("KindOfStatement");

        	de.fzi.sissy.metamod.Statement st = null;
        	if (kind == STATEMENT_SIMPLE)
        		st = new SimpleStatement();
        	else if (kind == STATEMENT_JUMP) {
        		st = new JumpStatement();
        		((JumpStatement)st).setJump();
        	}
        	else if (kind == STATEMENT_THROW) {
        		st = new JumpStatement();
        		((JumpStatement)st).setThrow();
        	}
        	else if (kind == STATEMENT_RETURN) {
        		st = new JumpStatement();
        		((JumpStatement)st).setReturn();
        	}
        	else if (kind == STATEMENT_LOOP)
        		st = new LoopStatement();
        	else if (kind == STATEMENT_BRANCH)
        		st = new BranchStatement();
        	else if (kind == STATEMENT_BLOCK)
        		st = new BlockStatement();
        	else if (kind == STATEMENT_CATCHBLOCK)
        		st = new CatchBlock();
        	else if (kind == STATEMENT_EXCEPTIONHANDLER)
        		st = new ExceptionHandler();
        	
       		st.setUniqueId(id);
       		idToModelElement.put(new Integer(id), st);
        }
       	
        rs = stmt.executeQuery(query);
        
        while (rs.next()) {
        	int id = rs.getInt("Id");
        	int funcid = rs.getInt("FunctionId");
        	int parentid = rs.getInt("ParentStatementId");
        	de.fzi.sissy.metamod.Statement st = (de.fzi.sissy.metamod.Statement)idToModelElement.get(new Integer(id));

        	if (parentid != -1) {
        		de.fzi.sissy.metamod.Statement parentSt = (de.fzi.sissy.metamod.Statement)idToModelElement.get(new Integer(parentid));
        		if (parentSt instanceof LoopStatement)
        			((LoopStatement)parentSt).setBody(st);
        		else if (parentSt instanceof BranchStatement)
        			((BranchStatement)parentSt).addBranch(st);
        		else if (parentSt instanceof CatchBlock)
        			((CatchBlock)parentSt).addStatement(st);
        		else if (parentSt instanceof BlockStatement)
        			((BlockStatement)parentSt).addStatement(st);
        		else if (parentSt instanceof ExceptionHandler) {
        			ExceptionHandler exHandler = (ExceptionHandler)parentSt;
        			if ((exHandler.getGuardedBlock() == null))
        				exHandler.setGuardedBlock((BlockStatement)st);
        			else if (st instanceof CatchBlock)
        				exHandler.addCatchBlock((CatchBlock)st);
        			else
        				exHandler.setFinallyBlock((BlockStatement)st);
        		}
        		if (st.getParent() == null)
        			Debug.warning("Statement parent was not found");
        	}
        	else if (st instanceof BlockStatement) {
        		Function func = (Function)idToModelElement.get(new Integer(funcid));
        		if (func != null)
        			func.setBody((BlockStatement)st);
        	}        	
        }    	
    }

    /*
     * Restore variables.
     */
    private void restoreVariables() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT TVariables.*, TAccesses.Id as AccId, TAccesses.TargetId, TModelElements.ParentId FROM TVariables JOIN TModelElements ON TVariables.Id = TModelElements.Id LEFT OUTER JOIN TAccesses ON TVariables.TypeDeclarationId = TAccesses.Id ORDER BY TVariables.Position";
        System.out.println(">>> restoreVariables :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        // Build GlobalVariable-Object for each global variable ...
        while (rs.next()) {
            int id = rs.getInt("Id");
            int kindofvariable = rs.getInt("KindOfVariable");
            Variable var;

            if (kindofvariable == VAR_GLOBALVAR) {
                var = loadGlobalVar(rs);
            } else if (kindofvariable == VAR_LOCALVAR) {
                var = loadLocalVar(rs);
            } else if (kindofvariable == VAR_FIELD) {
                var = loadFieldVar(rs);
            } else if (kindofvariable == VAR_PROPERTY) {
                var = loadPropertyVar(rs);
            } else if (kindofvariable == VAR_FORMALPARAM) {
                var = loadFormalParamVar(rs);
            } else if (kindofvariable == VAR_CATCHPARAM) {
                var = loadCatchParamVar(rs);
            } else {
                System.out.println("Didn't catch this type of variable yet.\n");
                continue;            	
            }
            var.setConst(rs.getBoolean("IsConst"));
            
            Type type = (Type)idToModelElement.get(new Integer(rs.getInt("TargetId")));
            if (type != null) {
	            DeclarationTypeAccess dta = new DeclarationTypeAccess(type);
	            dta.setUniqueId(rs.getInt("AccId"));
	            var.setTypeDeclaration(dta);
	            idToModelElement.put(new Integer(dta.getUniqueId()), dta);	            
            }
                     
            idToModelElement.put(new Integer(id), var);
        }
    } /* done */

    /*
     * Load global variable from given ResultSet.
     */
    private GlobalVariable loadGlobalVar(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int packid = rs.getInt("PackageId");
        String name = rs.getString("Name");

        GlobalVariable globalVar = new GlobalVariable(name);
        globalVar.setUniqueId(id);

        root.addGlobalVariable(globalVar);
        de.fzi.sissy.metamod.Package pack = (de.fzi.sissy.metamod.Package)idToModelElement.get(new Integer(packid));
        if (pack != null) {
        	pack.addGlobalVariable(globalVar);
        }
        return globalVar;
    } /* done */

    /*
     * Load local variable from given ResultSet.
     */
    private LocalVariable loadLocalVar(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int functionID = rs.getInt("FunctionId");
        String name = rs.getString("Name");

        LocalVariable localVar = new LocalVariable(name);
        localVar.setUniqueId(id);

        Function func = (Function) idToModelElement.get(new Integer(functionID));
        func.addLocalVariable(localVar);

        return localVar;
    } /* done */

    /*
     * Load field variable from given ResultSet.
     */
    private Field loadFieldVar(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int parentID = rs.getInt("ClassId");
        String name = rs.getString("Name");

        Field field = null;
        if (name.equals("<self>")) {
	        field = new Field(name);
	        field.setUniqueId(id);
            de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class) idToModelElement.get(new Integer(parentID));
        	c.setSelf(field);
        }
        else {
	        field = new Field(name);
	        field.setUniqueId(id);
	
	        de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class) idToModelElement.get(new Integer(parentID));
	        c.addField(field);
        }

        return field;
    } /* done */

    /*
     * Load property variable from given ResultSet.
     */
    private Property loadPropertyVar(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int parentID = rs.getInt("ClassId");
        int implementedInterfaceId = rs.getInt("ImplementedInterfaceId");
        String name = rs.getString("Name");
        
        Property p = new Property(name);
        p.setUniqueId(id);
        
        de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class) idToModelElement.get(new Integer(parentID));
        if (c != null) {
        	c.addProperty(p);
        	c = (de.fzi.sissy.metamod.Class) idToModelElement.get(new Integer(implementedInterfaceId));
            p.setImplementedInterface(c);
        }
        else {
        	System.err.println("Error reconstructing property " +name);
        }
        
        return p;
    } /* done */

    /*
     * Load formalparam variable from given ResultSet.
     */
    private FormalParameter loadFormalParamVar(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int parentID = rs.getInt("FunctionId");
        String name = rs.getString("Name");

        FormalParameter formalParam = new FormalParameter(name);
        formalParam.setUniqueId(id);
        if (rs.getBoolean("IsPassedByRef"))
        	formalParam.setPassedByReference();
        else
        	formalParam.setPassedByValue();

        Function function = (Function) idToModelElement.get(new Integer(parentID));
        function.addFormalParameter(formalParam);

        return formalParam;
    } /* done */

    /*
     * Load catchparam variable from given ResultSet.
     */
    private CatchParameter loadCatchParamVar(ResultSet rs) throws SQLException {
        int id = rs.getInt("Id");
        int parentID = rs.getInt("ParentId");
        String name = rs.getString("Name");

        CatchParameter catchParam = new CatchParameter(name);
        catchParam.setUniqueId(id);
        catchParam.setRethrown(rs.getBoolean("IsRethrown"));

        ModelElement elem = (ModelElement) idToModelElement.get(new Integer(parentID));
        if (elem instanceof CatchBlock)
        	((CatchBlock)elem).setCatchParameter(catchParam);
        else if (elem instanceof Function)
        	((Function)elem).addCatchParameter(catchParam);

        return catchParam;
    } /* done */

    private void restoreMembers() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TMembers";
        System.out.println(">>> restoreMembers :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	Member m = (Member)idToModelElement.get(new Integer(rs.getInt("Id")));
            if (rs.getBoolean("IsInternal"))
                m.setInternal(true);
            if (rs.getBoolean("IsAbstract"))
                m.setAbstract(true);
            if (rs.getBoolean("IsFinal"))
                m.setFinal(true);
            if (rs.getBoolean("IsStatic"))
                m.setStatic(true);
            if (rs.getBoolean("IsVirtual"))
                m.setVirtual(true);
            if (rs.getBoolean("IsExtern"))
                m.setExtern(true);
            if (rs.getBoolean("IsNew"))
                m.setNew();
            if (rs.getBoolean("IsOverride"))
                m.setOverride();
        	int omid = rs.getInt("OverridenMemberId");
        	Member om = null;
        	if (omid != -1) {
        		om = (Member)idToModelElement.get(new Integer(omid));
        		m.setOverridenMember(om);
        	}

            switch (rs.getInt("Visibility")) {
            case VISIBILITY_PRIVATE:
                m.setPrivate();
                break;

            case VISIBILITY_PROTECTED:
                m.setProtected();
                break;

            case VISIBILITY_STRICTPROTECTED:
                m.setStrictProtected();
                break;

            case VISIBILITY_PUBLIC:
                m.setPublic();
                break;
            case VISIBILITY_PACKAGE:
            	m.setPackage();
            	break;
            }
            
            if (rs.getBoolean("IsIntrospectable"))
            	m.setIntrospectable(true);
        }    	    	
    }
    
    /*
     * Restore Property Accessors.
     */
    private void restorePropertyAccessors() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT TModelElements.* FROM TModelElements, TConstants WHERE TModelElements.KindOfElement = TConstants.Value AND TConstants.Name LIKE 'FUNC_PROP%'";
        System.out.println(">>> restorePropertyAccessors :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        /* For each propertyAccessor ... */
        while (rs.next()) {
            int id = rs.getInt("Id");
            int propId = rs.getInt("ParentId");
            int kind = rs.getInt("KindOfElement");

            Method m = (Method) idToModelElement.get(new Integer(id));
            Property prop = (Property)idToModelElement.get(new Integer(propId));
            
            if (kind == FUNC_PROPGETTER)
            	prop.setGetter(m);
            else
            	prop.setSetter(m);
        }
    } /* done */

    /*
     * Restore file inclusions and imports.
     */
    private void restoreFileInclusionsAndImports() throws SQLException {
        // Open database connection ...
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TImports";
        System.out.println(">>> restoreFileInclusionsAndImports :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int fileid = rs.getInt("FileId");
            int targetid = rs.getInt("TargetId");

            // Get related file from Hashmap by "fileid".
            File file = (File)idToModelElement.get(new Integer(fileid));

        	ModelElement target = (ModelElement)idToModelElement.get(new Integer(targetid));

        	if (target instanceof File)
        		file.addIncludedFile((File)target);
        	else if (target instanceof de.fzi.sissy.metamod.Package)
        		file.addImportedPackage((de.fzi.sissy.metamod.Package)target);
        	else if (target instanceof Type)
        		file.addImportedType((Type)target);
        	else if (target instanceof GlobalFunction)
        		file.addImportedGlobalFunction((GlobalFunction)target);
        	else if (target instanceof GlobalVariable)
        		file.addGlobalVariable((GlobalVariable)target);
        }
    } /* done */

    
    /*
     * Restore accesses.
     */
    private void restoreAccesses() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT a.* FROM TAccesses a join TConstants c on a.kindOfAccess = c.value and c.name != 'TYPEACCESS_DECLARATION' ORDER BY a.SourceId, a.Position";
        System.out.println(">>> restoreAccesses :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("Id");
            int kindofaccess = rs.getInt("KindOfAccess");
            int targetId = rs.getInt("TargetId");
            int sourceId = rs.getInt("SourceId");
            int funcId = rs.getInt("FunctionId");
            ModelElement elem = (ModelElement) idToModelElement.get(new Integer(sourceId));
            if (elem == null)
            	elem = (ModelElement) idToModelElement.get(new Integer(funcId));

            if (kindofaccess == FUNCACCESS) {
                Function target = (Function)idToModelElement.get(new Integer(targetId));
                FunctionAccess acc = new FunctionAccess(target);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == DELEGATEACCESS) {
                Delegate target = (Delegate)idToModelElement.get(new Integer(targetId));
                DelegateAccess acc = new DelegateAccess(target);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == VARACCESS_WRITE || kindofaccess == VARACCESS_READ) {
                boolean pWrite = false;
            	if (kindofaccess == VARACCESS_WRITE)
            		pWrite = true;
            	Variable target = (Variable)idToModelElement.get(new Integer(targetId));
                VariableAccess acc = new VariableAccess(target, pWrite);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == PROPACCESS_WRITE || kindofaccess == PROPACCESS_READ) {
                boolean pWrite = false;
            	if (kindofaccess == PROPACCESS_WRITE)
            		pWrite = true;
            	Property target = (Property)idToModelElement.get(new Integer(targetId));
                PropertyAccess acc = new PropertyAccess(target, pWrite);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == SELFACCESS_THIS || kindofaccess == SELFACCESS_SUPER) {
            	Variable target = (Variable)idToModelElement.get(new Integer(targetId));
                SelfAccess acc = new SelfAccess((Class)target.getType());
            	if (kindofaccess == SELFACCESS_SUPER)
            		acc.setSuperAccess(true);
            	acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == COMPOSITEACCESS) {
                CompositeAccess acc = new CompositeAccess();
            	acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);                
            } else if (kindofaccess == TYPEACCESS_CAST) {
                Type target = (Type)idToModelElement.get(new Integer(targetId));
                CastTypeAccess acc = new CastTypeAccess(target);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == TYPEACCESS_STATIC) {
                Type target = (Type)idToModelElement.get(new Integer(targetId));
                StaticTypeAccess acc = new StaticTypeAccess(target);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == TYPEACCESS_RTTI) {
                Type target = (Type)idToModelElement.get(new Integer(targetId));
                RunTimeTypeAccess acc = new RunTimeTypeAccess(target);
                acc.setUniqueId(id);
                if (elem instanceof CompositeAccess)
                	((CompositeAccess)elem).addAccess(acc);
                else if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == TYPEACCESS_THROW || kindofaccess == TYPEACCESS_DECLAREDTHROW) {
                Type target = (Type)idToModelElement.get(new Integer(targetId));
                ThrowTypeAccess acc = new ThrowTypeAccess(target);
            	if (kindofaccess == TYPEACCESS_DECLAREDTHROW)
            		acc.setDeclared(true);
            	else
            		acc.setDeclared(false);
                acc.setUniqueId(id);
                if (elem instanceof de.fzi.sissy.metamod.Statement)
                	((de.fzi.sissy.metamod.Statement)elem).addAccess(acc);
                else if (elem instanceof Function)
                	((Function)elem).addAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            } else if (kindofaccess == TYPEACCESS_IMPLEMENTATIONINHERITANCE || kindofaccess == TYPEACCESS_INTERFACEINHERITANCE) {
                Type target = (Type)idToModelElement.get(new Integer(targetId));
                InheritanceTypeAccess acc = new InheritanceTypeAccess((de.fzi.sissy.metamod.Class)target);
            	if (kindofaccess == TYPEACCESS_IMPLEMENTATIONINHERITANCE)
            		acc.setImplementationInheritance();
            	else
            		acc.setInterfaceInheritance();
                acc.setUniqueId(id);
                de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class) idToModelElement.get(new Integer(sourceId));
                c.addInheritanceTypeAccess(acc);
                idToModelElement.put(new Integer(id), acc);
            }            
        }
    } /* done */

    private void restoreTypeArguments() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TTypeArguments JOIN TTypeParameters ON TTypeArguments.TypeParameterId = TTypeParameters.TypeParameterId ORDER BY AccessId, Position";
        System.out.println(">>> restoreTypeArguments :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int accId = rs.getInt("AccessId");
        	int typeId = rs.getInt("TargetTypeId");
        	Access acc = (Access)idToModelElement.get(new Integer(accId));
        	Type type = (Type)idToModelElement.get(new Integer(typeId));
        	if (acc instanceof TypeAccess)
        		((TypeAccess)acc).addTypeArg(type);
        	else if (acc instanceof FunctionAccess)
        		((FunctionAccess)acc).addTypeArg(type);
        }
    }

    private void restoreStructuralAbstractions() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TAbstractions";
        System.out.println(">>> restoreAbstractions :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int id = rs.getInt("Id");
        	int kind = rs.getInt("KindOfAbstraction");
        	String name = rs.getString("Name");
        	String type = rs.getString("Type");

        	StructuralAbstraction a;
        	if (kind == ABSTRACTION_SUBSYSTEM) {
        		a = new Subsystem(name);
        	}
        	else {
	        	a = new StructuralAbstraction(name, type);
        	}
        	a.setUniqueId(id);
        	root.addStructuralAbstraction(a);
        	idToModelElement.put(new Integer(id), a);        		
        }

        stmt = con.createStatement();
        query = "SELECT * FROM TAbstractionElements";
        rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int id = rs.getInt("AbstractionId");
        	int elemId = rs.getInt("ModelElementId");
        	ModelElement elem = (ModelElement)idToModelElement.get(new Integer(elemId));
        	StructuralAbstraction a = (StructuralAbstraction)idToModelElement.get(new Integer(id));
        	a.addModelElement(elem);
        }    	
    }
    
    
    /*
     * Restore comments.
     */
    private void restoreComments() throws SQLException {
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TComments";
        System.out.println(">>> restoreComments :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int id = rs.getInt("Id");
        	int formal = rs.getInt("IsFormal");
        	int todo = rs.getInt("NumberOfTodos");
        	String text = rs.getString("CommentText");

        	Comment c = new Comment((formal == 1), text, todo);
        	c.setUniqueId(id);
        	idToModelElement.put(new Integer(id), c);        		
        }
    	
    }
    
    /*
     * Restore positions.
     */
    private void restorePositions() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM TSourceEntities";
        System.out.println(">>> restorePositions :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("Id");

            SourceEntity element = (SourceEntity)idToModelElement.get(new Integer(id));

            Position pos = loadPosition(rs);

            if (element != null) {
                element.setPosition(pos);
            }
        }
    } /* done */

    /*
     * Load Position from given ResultSet.
     */
    private Position loadPosition(ResultSet rs) throws SQLException {
        int srcFileId = rs.getInt("SourceFileId");
        int startline = rs.getInt("StartLine");
        int startchar = rs.getInt("StartChar");
        int endline = rs.getInt("EndLine");
        int endchar = rs.getInt("EndChar");
        int assemblyId = rs.getInt("AssemblyFileId");

        File srcFile = (File)idToModelElement.get(new Integer(srcFileId));
        File assemblyFile = (File)idToModelElement.get(new Integer(assemblyId));

        Position pos;
        if ((srcFile == null) && (assemblyFile == null))
        	pos = new Position(null, -1, -1, -1, -1);
        else {
        	pos = new Position(srcFile, startline, startchar, endline, endchar);
	        if (assemblyFile != null)
	        	pos.setAssembly(assemblyFile);
        }

        return pos;
    } /* done */

    private void restoreAnnotationsAndStatus() throws SQLException {
        // Open database connection.
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT elem.* FROM TModelElements elem JOIN TConstants c on elem.Status = c.Value and c.Name != 'STATUS_NORMAL'";
        System.out.println(">>> restoreStatus :: query =\n" + query + "\n");
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	ModelElement elem = (ModelElement)idToModelElement.get(new Integer(rs.getInt("Id")));
        	if (elem != null) 
        		elem.setStatus(rs.getInt("ResultStatus"));
        }    	
        
        stmt = con.createStatement();
        query = "SELECT * FROM TAnnotations ORDER BY ModelElementId, AnnotationId";
        System.out.println(">>> restoreAnnotations :: query =\n" + query + "\n");
        rs = stmt.executeQuery(query);

        while (rs.next()) {
        	int elemId = rs.getInt("ModelElementId");
        	int annId = rs.getInt("AnnotationId");
        	ModelElement elem = (ModelElement)idToModelElement.get(new Integer(elemId));
        	ModelAnnotation ann = (ModelAnnotation)idToModelElement.get(new Integer(annId));
        	if ((elem != null) && (ann != null))
	        	if (! (ann instanceof CloneInstance))
	        		elem.addAnnotation(ann);
        }    	        
    }
    
    public Root getRoot() {
        return root;
    } /* done */

    public static void main(String[] args) {
        new ModelImporter();
    } /* done */
}
