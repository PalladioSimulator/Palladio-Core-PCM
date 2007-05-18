package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.helper.OCLParsingException;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;

public class EMFHelper {
	
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
	
	public static EObject executeOCLQuery(EObject context, String query)
	{
		IOCLHelper helper = HelperUtil.createOCLHelper(
				new EcoreEnvironmentFactory(EPackage.Registry.INSTANCE));
			
		// set our helper's context object to parse against it
		helper.setContext(context);
	   
		Object result = null;
	    try
	    {
		    result = helper.evaluate(context,query);
	    }
	    catch(OCLParsingException ex)
	    {
	    	System.out.println(ex.getMessage());
	    	System.exit(-1);
	    }
	    if (result == null)
	    {
	    	System.out.println("Query resulted in an empty result :-( "+query);
	    	System.exit(-1);
	    }
	    return (EObject)result;
	}
}
