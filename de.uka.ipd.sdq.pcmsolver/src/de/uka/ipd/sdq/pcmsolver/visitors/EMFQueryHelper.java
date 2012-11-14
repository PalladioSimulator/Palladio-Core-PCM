package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

public class EMFQueryHelper {
	
	@SuppressWarnings("unchecked")
	public static Object getObjectByType(EList collection, Class c) {
		Iterator i = collection.iterator();
		Object o = null;
		while ((o = i.next()) != null) {
			if (c.isAssignableFrom(o.getClass()))
				break;
		}
		return o;
	}

	protected static final OCL EOCL_ENV = OCL.newInstance();

	public static EObject executeOCLQuery(EObject context, String query)
	{
		OCL.Helper helper = EOCL_ENV.createOCLHelper(); 
		helper.setContext(context.eClass());

		// set our helper's context object to parse against it
	   
		Object result = null;
	    try {
			OCLExpression oclQuery = helper.createQuery(query);
			result = EOCL_ENV.evaluate(context, oclQuery);
		} catch (ParserException e) {
	    	System.out.println("Query failed "+query);
	    	throw new RuntimeException(e);
		}
	    if (result == null)
	    {
	    	System.out.println("Query resulted in an empty result :-( "+query);
	    	throw new RuntimeException("Query resulted in an empty result :-( "+query);
	    }
	    return (EObject)result;
	}
}
