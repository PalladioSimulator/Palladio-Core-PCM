package org.instrument.MethodCall;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.MethodInfo;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class InstrumentMethodCall {
	
	public static void main (String[] args) throws CannotCompileException{
		// 1. Call Method m before instrumentation
		System.out.println("[IMC] Invoking the \"caller\" method m " +
				"BEFORE replacing callee method \"x\"");
		ClassToInstrument clazz_orig = new ClassToInstrument();
		clazz_orig.m();
		
		InstrumentMethodCall instrumentation = new InstrumentMethodCall();
		
		// 2. Now instrument the method m by replacing the call to method x 
		//by an empty byte code sequence
		Class<?> clazz = instrumentation.instrument(
				"org.instrument.MethodCall.ClassToInstrument", 
				"m", 
				"x", 
				new byte[]{});
		
		// 3. Call Method m before instrumentation
		System.out.println("[IMC] Invoking the \"caller\" method m " +
				"AFTER replacing callee method \"x\" with a method containing " +
				"just a new (empty) bytecode sequence");
		try {
			((IClassToInstrument)clazz.newInstance()).m(); //non-Javassist, non-Reflection invocation!
		} catch (/*MK Instantiation*/Exception e) { //java.lang exception
			e.printStackTrace();
		}/* MK  catch (IllegalAccessException e) { //java.lang exception
			e.printStackTrace();
		}*/
		System.out.println("[IMC] FINISHED org.instrument.MethodCall.InstrumentMethodCall.main(...)");
	}
	
	/**
	 * Creates a new hook method that contains the byte code sequence. The newly
	 * generated method is added to the class that is going to be instrumented
	 * 
	 * @param cc
	 *            the class to instrument (in our case the class contaning the method m)
	 * @param b
	 *            the byte code sequence to inject in the method
	 */
	public void addNewMethod(CtClass cc, byte[] b){
		CtMethod hook;
		try {
			hook = CtNewMethod.make("private void hook();", cc);
			cc.addMethod(hook);
			hook.setBody("{int x = 1;}");
			MethodInfo minfo = hook.getMethodInfo();
			CodeAttribute ca = minfo.getCodeAttribute();
			CodeIterator iterator = ca.iterator();
			iterator.append(b);
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} 
		
		//Injecting a member to a CtClass makes it abstract 
		cc.setModifiers(cc.getModifiers() & ~Modifier.ABSTRACT);
	}
	
	private ClassLoader createNewClassLoader(){
		// Get the directory (URL) of the reloadable class
        URL[] urls = null;
        try {
           // Convert the file object to a URL
            File dir = new File(System.getProperty("user.dir")
                +File.separator+"dir"+File.separator);
            URL url = dir.toURI().toURL();   
            urls = new URL[]{url};
        } catch (MalformedURLException e) {
        }
         // Create a new class loader with the directory
         ClassLoader cl = new URLClassLoader(urls);
         return cl;
	}
	
	/**
	 * This method instruments a class given by <code>className</code> param 
	 * by replacing the call to a method <code>calleeMethodName_ToReplace</code> 
	 * in a method <code>callerMethodName</code> by calling an alternative 
	 * bytecode sequence <code>replacementBytecodeSequence</code>.
	 * 
	 * Because Javassist allows only the instrumentation by using source code
	 * representations, the bytecode sequence is injected in a newly created 
	 * method which is created at runtime by the method 
	 * {@link #addNewMethod(CtClass, byte[])}. Consequently, we replace 
	 * the call to the method <code>calleeMethodName_ToReplace</code>  
	 * with a call to the newly generated method.
	 * 
	 * @param className class name for which the instrumentation takes place
	 * @param callerMethodName the method <b>in</b> which a call will be replaced
	 * @param calleeMethodName_ToReplace the method call <b>which</b> whill be replaced
	 * @param replacementBytecodeSequence bytecode sequence that will replace the call to 
	 * <code>callToReplace</code>, embedded in a new method
	 * @return TODO
	 * @throws CannotCompileException (of Javassist)
	 */
	public Class<?> instrument(
			String className, 
			String callerMethodName, 
			final String calleeMethodName_ToReplace, 
			byte[] replacementBytecodeSequence
	) throws CannotCompileException{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = null;
		try {
			cc = pool.get(className);
			this.addNewMethod(cc, replacementBytecodeSequence);
			CtMethod cm = cc.getDeclaredMethod(callerMethodName);
			
			cm.instrument( //Javassist method
				    new ExprEditor() {
				        public void edit(MethodCall m)
				                      throws CannotCompileException
				        {
				            if (m.getMethodName().equals(calleeMethodName_ToReplace)){
				                m.replace("{hook();}");
				            }
				        }
				    });
			boolean writeFile=false;
			if(writeFile){
				cc.writeFile();
			}else{
				System.out.println("[IMC] instrument(..): not writing file...");
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return cc.toClass(createNewClassLoader(), null);
	}
	

}
