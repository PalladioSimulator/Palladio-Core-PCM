package de.uka.ipd.simucom.reflectivevisitor;

import java.lang.reflect.Method;

public class ReflectiveVisitor {
	public void visit(Object object) throws Exception {
		Method method = getMethod(object.getClass());
		method.invoke(this, new Object[] { object });
		if (object instanceof Visitable) {
			callAccept((Visitable) object);
		}
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
