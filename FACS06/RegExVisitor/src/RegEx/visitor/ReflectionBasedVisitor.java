package RegEx.visitor;

import java.lang.reflect.*;

public abstract class ReflectionBasedVisitor {

	public ReflectionBasedVisitor() {
	}

	public void defaultVisit(Object o) {
		System.out.println(o.toString());
	}

	public void visit(Object o) {
		try {
			Method m = getMethod(o);
			m.invoke(this, new Object[] { o });
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvocationTargetException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	
	private Method getMethod(Object o) throws NoSuchMethodException 
	{
		Method method = null;
		String methodName = o.getClass().getName();
		methodName = "visit"
				+ methodName.substring(methodName.lastIndexOf('.') + 1);		
		try {
			method = getClass().getMethod(methodName, new Class[] {o.getClass()});
		} catch( NoSuchMethodException e1) {
			method = null;
			Class[] interfaces = o.getClass().getInterfaces();
			for (int i = 0; i < interfaces.length; i++) 
			{
				methodName = interfaces[i].getName();
				methodName = "visit"
						+ methodName.substring(methodName.lastIndexOf('.') + 1);
				try {
					method = getClass().getMethod(methodName, new Class[] {interfaces[i]});
					break;
				} catch (NoSuchMethodException e2){
					method = null;
				}
			}
		}
		if (method == null) 
		{
			method = getClass().getMethod("defaultVisit", new Class[] {Object.class});
		}
		return method;
	}	
}