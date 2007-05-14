package de.uka.ipd.sdq.simucom.reflectivevisitor;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectiveVisitor {

	private static HashMap<Class,HashMap<Class,Method>> cache = new HashMap<Class, HashMap<Class,Method>>();
		
	public void visit(Object object) throws Exception {
		Method method = getMethodWithCache(object.getClass());
		method.invoke(this, new Object[] { object });
		if (object instanceof Visitable) {
			callAccept((Visitable) object);
		}
	}

	private Method getMethodWithCache(Class typeOfObjectToVisit) {
		HashMap<Class,Method> thisClassCache = cache.get(this.getClass());
		if (thisClassCache == null)
		{
			thisClassCache = new HashMap<Class, Method>();
			cache.put(this.getClass(),thisClassCache);
		}
		if (!thisClassCache.containsKey(typeOfObjectToVisit))
		{
			thisClassCache.put(typeOfObjectToVisit,getMethod(typeOfObjectToVisit));
		}
		return thisClassCache.get(typeOfObjectToVisit);
	}

	public void visitObject(Object o) throws Exception
	{
		throw new Exception("Object "+o.toString()+" is not visitable by this visitor "+this.toString());
	}
	
	public void callAccept(Visitable visitable) {
	   visitable.accept(this);
	}	
	
	protected Method getMethod(Class c) {
		Class newc = c;
		Method m = null;
		// Try the superclasses
		while (m == null && newc != Object.class) {
			String method = newc.getName();
			method = "visit" + method.substring(method.lastIndexOf('.') + 1);
			try {
				m = getClass().getMethod(method, new Class[] { newc });
			} catch (NoSuchMethodException e) {
				newc = newc.getSuperclass();
			}
		}
		// Try the interfaces. If necessary, you
		// can sort them first to define 'visitable' interface wins
		// in case an object implements more than one.
		if (newc == Object.class) {
			Class[] interfaces = c.getInterfaces();
			for (int i = 0; i < interfaces.length; i++) {
				String method = interfaces[i].getName();
				method = "visit"
						+ method.substring(method.lastIndexOf('.') + 1);
				try {
					m = getClass().getMethod(method,
							new Class[] { interfaces[i] });
				} catch (NoSuchMethodException e) {
				}
			}
		}
		if (m == null) {
			try {
				m = this.getClass().getMethod("visitObject",
						new Class[] { Object.class });
			} catch (Exception e) {
				// Can't happen
			}
		}
		return m;
	}
}
