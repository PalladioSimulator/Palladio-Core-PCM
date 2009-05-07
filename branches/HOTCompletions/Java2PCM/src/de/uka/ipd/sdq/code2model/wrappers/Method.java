package de.uka.ipd.sdq.code2model.wrappers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * Encapsulates a method with enough information to identify it unambiguously.
 * <p>
 * One reason for this class is that we deal with classes and methods both in
 * the Eclipse UI (package explorer) and in the code analysis (using
 * org.eclipse.jdt.dom). For example, we must compare if a method encountered in
 * the analysis is among the ones selected by the user in Eclipse. However, the
 * classes encountered in both cases are different: {@link IMethod} in the UI
 * and {@link IMethodBinding} or {@link MethodDeclaration} in the analysis. All
 * variants can be turned into an instance of this class and can then be
 * compared to each other.
 * </p>
 * <p>
 * Only the method name and the types of its parameters, in the correct order,
 * are guaranteed to be kept. Parameter names are not available from {@link IMethodBinding}.
 * Different return types are not allowed for methods with equal name and
 * parameter types.
 * </p>
 * <p>
 * Optionally, a {@link IMethodBinding} and a {@link Package} can be stored,
 * too. Clients should not rely on these being present. The package is used to
 * arrange packages and their methods in a tree structure for the external call
 * wizard.
 * </p>
 * 
 * @author thomas
 */
public class Method implements Iterable<Method.MethodParameter>{
	public static final String UNKOWN_PARAMETER_NAME = "";

	private Logger logger;
	
	private IMethodBinding binding = null;
	private String simpleMethodName;
	private String declaringClassName;
	private Package pkg = null;
	private String returnType;

	private List<MethodParameter> params = new ArrayList<MethodParameter>();

	private Hashtable<String, String> bindingTypesToSignatureTypes;


	private void initialize() {
		logger = Logger.getLogger(this.getClass());

		bindingTypesToSignatureTypes = new Hashtable<String, String>();
		bindingTypesToSignatureTypes.put("byte", "B");
		bindingTypesToSignatureTypes.put("char", "C");
		bindingTypesToSignatureTypes.put("double", "D");
		bindingTypesToSignatureTypes.put("float", "F");
		bindingTypesToSignatureTypes.put("int", "I");
		bindingTypesToSignatureTypes.put("long", "J");
		bindingTypesToSignatureTypes.put("short", "S");
		bindingTypesToSignatureTypes.put("void", "V");
		bindingTypesToSignatureTypes.put("boolean", "Z");
	}
	
	public Method(IMethod imethod) {
		initialize();
		declaringClassName = imethod.getDeclaringType().getFullyQualifiedName();
		simpleMethodName = imethod.getElementName();
		logger.info("Method " + simpleMethodName + " is in class " + declaringClassName);
		try {
			returnType = imethod.getReturnType();
		} catch (JavaModelException e) {
			logger.debug("IMethod " + simpleMethodName + " has no return type.");
		}
		
		// Parameters
		String[] paramNames;
		try {
			paramNames = imethod.getParameterNames();
		} catch (JavaModelException e1) {
			logger.debug("IMethod " + simpleMethodName + " has no parameter names.");
			paramNames = new String[0];
		}
		String[] paramTypes = imethod.getParameterTypes();
		for (int i = 0; i < paramNames.length; i++) {
			MethodParameter p = new MethodParameter(paramNames[i], paramTypes[i]);
			this.params.add(p);
		}
		logger.debug("Created Method " + this + " from IMethod.");
	}
	
	public Method(Signature sig) {
		initialize();

		simpleMethodName = sig.getServiceName();
		declaringClassName = sig.getInterface_Signature().getEntityName();
		DataType retType = sig.getReturntype__Signature();
		if (retType != null) {
			returnType = retType.toString();
		}

		for (Parameter sigParam : sig.getParameters__Signature()) {
			MethodParameter param = new MethodParameter(UNKOWN_PARAMETER_NAME, sigParam
					.getDatatype__Parameter().toString());
			this.params.add(param);
		}
		logger.debug("Created Method " + this + " from signature");
	}

	/**
	 * No parameter names are available for {@link IMethodBinding}!
	 * 
	 * @param binding
	 *            the {@link IMethodBinding} to encapsulate
	 */
	public Method(IMethodBinding binding) {
		initialize();

		constructForBinding(binding);

		for (ITypeBinding t : binding.getParameterTypes()) {
			String type = t.getName();
			String sigType = convertTypeToSignatureNotation(type);
			
			MethodParameter param = new MethodParameter(UNKOWN_PARAMETER_NAME,
					sigType);
			this.params.add(param);
		}
		logger.debug("Created Method " + this + " from binding.");
	}

	public Method(MethodDeclaration decl) {
		initialize();
				
		IMethodBinding binding = decl.resolveBinding();
		constructForBinding(binding);

		for (Object varDeclObject : decl.parameters()) {
			SingleVariableDeclaration varDecl = (SingleVariableDeclaration) varDeclObject;
			String paramName = varDecl.getName().toString();
			String paramType = varDecl.getType().toString();
			paramType = convertTypeToSignatureNotation(paramType);
			
			//MethodParameter param = new MethodParameter(varDecl);
			MethodParameter param = new MethodParameter(paramName, paramType);
			this.params.add(param);
		}
		logger.debug("Created Method " + this + " from declaration.");
	}

	/**
	 * Convert the type notation from {@link IMethodBinding}s to the
	 * {@link org.eclipse.jdt.core.Signature} notation.
	 * <p>
	 * Parameter types in their String form look different in {@link IMethod}s
	 * and {@link IMethodBinding}s. {@link IMethod}s use the notation defined
	 * in {@link org.eclipse.jdt.core.Signature}. This method converts the
	 * {@link IMethodBinding} form to the {@link org.eclipse.jdt.core.Signature}
	 * form, as the latter seems to be somewhat standardized.
	 * </p>
	 * 
	 * @param type
	 *            a type notation
	 * @return a type notation conforming to the
	 *         {@link org.eclipse.jdt.core.Signature} notation
	 */
	private String convertTypeToSignatureNotation(String type) {
		String prefix = "";
		String sigType = type;
		
		//Arrays are given as "[<type>"
		for (int i=0; i<2; i++) {
			if (sigType.endsWith("[]")) {
				sigType = sigType.substring(0, sigType.length()-2);
				prefix += "[";
			}
		}

		sigType = bindingTypesToSignatureTypes.get(sigType);
		if (sigType == null) {
			sigType = "Q" + type + ";";
		}
		logger.debug("Converted type " + type + " to " + prefix + sigType);
		return prefix + sigType;
	}

	/**
	 * Extracts information from {@link IMethodBinding}s. Holds the common
	 * parts of {@link #Method(IMethodBinding)} and
	 * {@link #Method(MethodDeclaration)}, as declarations are resolved and
	 * then their bindings are further processed.
	 * 
	 * @param binding
	 *            the binding to get the info from
	 */
	private void constructForBinding(IMethodBinding binding) {
		this.simpleMethodName = binding.getName();
		this.returnType = binding.getReturnType().getName();
		this.declaringClassName = binding.getDeclaringClass().getQualifiedName();
		this.binding = binding;
	}

	/**
	 * @return the name of the declaring class
	 */
	public String getQualifiedDeclaringClassName() {
		return declaringClassName;
	}

	/**
	 * @return the method's name, without package or parameters
	 */
	public String getMethodName() {
		return this.simpleMethodName;
	}
	
	/**
	 * @return the number of parameters
	 */
	protected int getNumberOfParams() {
		return this.params.size();
	}

	/**
	 * @return the return type
	 */
	public String getReturnType() {
		return this.returnType;
	}

	/**
	 * @return the package the method is in, if recorded; null otherwise
	 */
	public Package getPackage() {
		return this.pkg;
	}

	/**
	 * Set the package the method is in.
	 * 
	 * @param pkg
	 *            the {@link Package}
	 */
	public void setPackage(Package pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * Create a representation of the form <code>name(type1, type2)</code>.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String params = "";
		for (MethodParameter p : this) {
			String pname = "";
			if (p.name.length() > 0) {
				pname = p.name + ":";
			}
			params += pname + p.type + ", ";
		}
		if (params.length() > 0) {
			params = params.substring(0, params.length()-2);
		}
		String representation = declaringClassName + "." + getMethodName()
				+ "(" + params + ")";
		return representation;
	}

	/**
	 * If the name, all parameter types, in the correct order, and the package,
	 * if set, are equal, two methods are equal.
	 * <p>
	 * If one or both of the methods have the package not set, it is left out of
	 * the comparison. This can lead to wrong results.
	 * </p>
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if (arg0 == this) {
			return true;
		}
		if (arg0 == null || arg0.getClass() != this.getClass()) {
			return false;
		}
		Method compMethod = (Method) arg0;
		boolean namesAreEqual = this.simpleMethodName.equals(compMethod
				.getMethodName());
		boolean pkgsAreEqual = this.declaringClassName.equals(compMethod
				.getQualifiedDeclaringClassName());
		return (namesAreEqual && paramTypesAreEqual(compMethod) && pkgsAreEqual);
	}

	/**
	 * Helper method to compare the parameter types of two methods.
	 * 
	 * @param compMethod
	 *            the "other" method to be compared against <code>this</code>
	 * @return true if all types, in the correct order, are equal, false
	 *         otherwise
	 */
	private boolean paramTypesAreEqual(Method compMethod) {
		if (this.getNumberOfParams() != compMethod.getNumberOfParams()) {
			return false;
		}

		Iterator<MethodParameter> it = compMethod.iterator();
		for (MethodParameter ownParam : this) {
			MethodParameter compParam = it.next();
			if (! ownParam.type.equals(compParam.type)) {
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = this.simpleMethodName.hashCode();
		for (MethodParameter p : this.params) {
			hash = 31 * hash + p.type.hashCode();
		}
		/*
		 * TODO Commenting this out is prone to failure if there are identical
		 * methods in different classes. Commenting it in destroys the "only
		 * methods declared in an interface" option. 
		 if (this.declaringClassName != null) { 
		 	hash = 31 * hash + this.declaringClassName.hashCode(); 
		 }
		 */
		return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Method.MethodParameter> iterator() {
		return this.params.iterator();
	}

	/**
	 * Encapsulates a method parameter with name and type.
	 * <p>
	 * Only for internal use, thus as simple as possible: name and type are given
	 * via the constructor and are queried directly via the fields.
	 * </p>
	 * 
	 * @author thomas
	 */
	public class MethodParameter {
		private String name;
		private String type;

		public MethodParameter(String name, String type) {
			this.name = name;
			this.type = type;
		}
		/**
		 * Get the parameter name.
		 */
		public String getName() {
			return name;
		}
		/**
		 * Get the parameter type.
		 */
		public String getType() {
			return type;
		}
	}

}
