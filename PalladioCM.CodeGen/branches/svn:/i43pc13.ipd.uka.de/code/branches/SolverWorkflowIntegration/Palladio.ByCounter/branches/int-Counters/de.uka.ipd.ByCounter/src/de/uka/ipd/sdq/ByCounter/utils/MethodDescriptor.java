package de.uka.ipd.sdq.ByCounter.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.objectweb.asm.Type;

/**
 * Unambiguous description for a method in bytecode compatible format. Such a 
 * signature can be constructed through the constructor that takes a single 
 * string argument <code>MethodDescriptor(String signature)</code>.
 * @see MethodDescriptor(String signature)
 * @author Michael Kuperberg
 * @author Martin Krogmann
 * @since 0.1
 * @version 0.9
 */
public class MethodDescriptor {
	private static final String BOOLEAN_TYPE	= "Z";
	private static final String BYTE_TYPE		= "B";
	private static final String CHAR_TYPE		= "C";
	private static final String DOUBLE_TYPE		= "D";
	private static final String FLOAT_TYPE		= "F";
	private static final String INT_TYPE		= "I";
	private static final String LONG_TYPE		= "J";
	private static final String SHORT_TYPE		= "S";
	private static final String VOID_TYPE		= "V";
	private static final String OBJECT_TYPE		= "L";
	private static final String ARRAY_TYPE		= "[";

	// have a static log for the class to use
	private static Logger log = 
		Logger.getLogger(MethodDescriptor.class.getCanonicalName());
	
	private String descriptor = null;
	private String methodName = null;
	
	/**
	 * Constructs a MethodDesciptor from the bytecode compatible descriptor string.
	 * For Construction from a standard Java method signature, see the static method
	 * getFromJavaSignature.
	 * @see getFromJavaSignature()
	 * @param methodName The simple name of the method.
	 * @param descriptor Method descriptor string as used in java bytecode.
	 */
	public MethodDescriptor(String methodName, String descriptor) {
		construct(methodName, descriptor);
	}

	protected void construct(String methodName, String descriptor) {
		this.methodName = methodName;
		this.descriptor = descriptor;
	}

	/**
	 * Constructs a MethodDescriptor directly from a java reflection Method.
	 * @param m Method that is described by the MethodDescriptor.
	 */
	public MethodDescriptor(Method m) {
		this(m.getName(), Type.getMethodDescriptor(m));
	}
	

	/**
	 * Gets the descriptor string as used in java bytecode for descriptor.
	 * @return The method descriptor string.
	 */
	public String getDescriptor() {
		return descriptor;
	}
	
	/**
	 * Construct a MethodDescriptor from a java method signature.
	 * @param signature A string containing a standard Java method signature 
	 * as for example:
	 * <code>public static de.uka.ipd.sdq.ByCounter.MethodDescriptor getFromJavaSignature(String sig)</code>
	 * Object types need to be specified with the full canonical name.
	 * Specifically, only the two tokens before the first '(', as well as 
	 * everything between '(' and ')' is evaluated.
	 * Whitespaces and qualifiers like "public", "static" are ignored. Generic
	 * types may be ommited (and are ignored) so that "List" and "List<Integer>"
	 * are treated as the same since bytecode signatures ignore generics.
	 * For method parameters, only one or two tokens are allowed 
	 * (example: "int[]" or "int[] abc").
	 * It is advised to take the method declaration from sourcecode or from 
	 * documentation and only adapt it, if necessary. The thing that needs to 
	 * be adapted is type names for object types. So instead of giving the String 
	 * "String myString", this has to be expanded to "java.lang.String".
	 * @return A Descriptor for the specified method or null if the signature 
	 * is invalid. An error message will be logged in the latter case.
	 */
	public MethodDescriptor(String signature) {
		String retType = null;
		String simpleMethodName = null;
		ArrayList<String> argTypes = new ArrayList<String>();
		
		String sig = removeGenericTyping(signature);
		
		int split1 = sig.indexOf('(');
		int split2 = sig.lastIndexOf(')');

		String returnStr = sig.substring(0, split1);	 // the first part contains the return type
		String inBracesStr = sig.substring(split1+1, split2);	// the part in braces contains the parameters
		
		String[] tokens = null;
		// try to parse out the return type
		tokens = returnStr.split("(\\s)+");	// split at whitespaces
		if(tokens.length < 2) {
			log.error("Error parsing return type for java signature. " +
					"Expecting at least two tokens before '('");
		} else {
			// the last token should be the method name.
			simpleMethodName = tokens[tokens.length-1];
			// the second last token should be the type.
			// example: "public static void main"
			retType = parseType(tokens[tokens.length-2]);
		}
		
		if(inBracesStr.length() > 0) {
			// try to parse the parameters
			String[] params = inBracesStr.split(",");
			for(String s : params) {
				s = s.trim();	// remove leading and trailing whitespaces 
				tokens = s.split("(\\s)+");	// split at whitespaces
				if(tokens.length < 1 || tokens.length > 2) {
					log.error("Error parsing java signature \"" + signature + "\":");
					log.error("Parameter definition does not contain 1 or 2 tokens");
					break;
				} else {
					// if the array braces "[]" are appended to the parameter name,
					// cut them of and append them to the type string:
					String parameterName = tokens[tokens.length-1];
					String arrayBraces = "";
					int end;
					for(end = parameterName.length();
						end > 0 && parameterName.substring(0, end).endsWith("[]");
						end -= 2) {
						arrayBraces += "[]";
					}
					
					// the second last token should be the type.
					// example: "int xyz"					
					argTypes.add(parseType(tokens[tokens.length - 2] + arrayBraces));	
				}
			}
		}

		// construct the descriptor
		StringBuilder b = new StringBuilder();
		b.append("(");
		for(String arg : argTypes) {
			b.append(arg);
		}
		b.append(")");
		b.append(retType);
		this.construct(simpleMethodName, b.toString());
	}
	
	/**
	 * Used for parsing from a java signature.
	 * Since generic types are not respected at bytecode signature level,
	 * remove those declarations from the signature.
	 * @param signature A java signature.
	 * @return The cleaned signature.
	 */
	public static String removeGenericTyping(String signature) {
		String sig = signature;
		int braceLevel = 0;
		int cutStart = -1;
		int cutEnd = -1;
		while (sig.contains("<")) {
			for(int i = 0; i < sig.length(); i++) {
				if(sig.charAt(i) == '<') {
					braceLevel++;
					if(braceLevel == 1) {
						// first brace
						cutStart = i;
					}
				} else if(sig.charAt(i) == '>') {
					braceLevel--;
					if(braceLevel == 0) {
						cutEnd = i;
						// cut the part from cutStart to cutEnd out
						sig = sig.substring(0, cutStart) + sig.substring(cutEnd+1, sig.length());
						// start to search again
						i = 0;
					} else if(braceLevel < 0) {
						log.error("Error in method signature " + signature + 
								". Number of '<' does not match number of '>'");
						return "";
					}
				}
			}
		}
		return sig;
	}

	/**
	 * Parse a type string as written in a java signature into a type descriptor.
	 * @param typeString String of a type definition. For example: "void".
	 * Leading or trailing whitespaces are not allowed!
	 * @return A type descriptor string representing the type defined by typeString.
	 * For example: "V" for "void".
	 */
	private static String parseType(String typeString) {
		String tStr = typeString;
		StringBuilder returnString = new StringBuilder();
		
		while (tStr.endsWith("]")) {
			returnString.append(ARRAY_TYPE);
			// cut off "[]" and parse again
			tStr = typeString.substring(0, tStr.length() - 2);
		}
		
		if (tStr.equals("boolean")) {
			returnString.append(BOOLEAN_TYPE);
		} else if (tStr.equals("byte")) {
			returnString.append(BYTE_TYPE);
		} else if (tStr.equals("char")) {
			returnString.append(CHAR_TYPE);
		} else if (tStr.equals("double")) {
			returnString.append(DOUBLE_TYPE);
		} else if (tStr.equals("float")) {
			returnString.append(FLOAT_TYPE);
		} else if (tStr.equals("int")) {
			returnString.append(INT_TYPE);
		} else if (tStr.equals("long")) {
			returnString.append(LONG_TYPE);
		} else if (tStr.equals("short")) {
			returnString.append(SHORT_TYPE);
		} else if (tStr.equals("void")) {
			returnString.append(VOID_TYPE);
		} else {
			if(!tStr.contains(".") && !tStr.contains("/")) {
				log.error("Signature error! Object type is not given as full canonical name. (\"" 
						+ tStr + "\")");
			}
			returnString.append(OBJECT_TYPE + (tStr.replace('.', '/') + ";"));
		}
		
		return returnString.toString();
	}

	/**
	 * Gets the simple method name of the described method.
	 * @return The method name.
	 */
	public String getMethodName() {
		return methodName;
	}
	
	public String toString(){
		String ret = "Method name: "+this.methodName+"\tDescriptor: "+this.descriptor;
		return ret;
	}
}
