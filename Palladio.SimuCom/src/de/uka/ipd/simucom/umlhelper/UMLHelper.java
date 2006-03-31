package de.uka.ipd.simucom.umlhelper;

import java.util.Set;

import org.eclipse.uml2.Element;
import org.eclipse.uml2.NamedElement;
import org.eclipse.uml2.Stereotype;

public class UMLHelper {
	public static Object getStereotypeValue(Element e, String stereotype, String property)
	{
		Stereotype s = e.getAppliedStereotype(stereotype);
		return e.getValue(s, property);
	}

	public static boolean isStereotypeApplied(Element e, String stereotype)
	{
		Stereotype s = e.getAppliedStereotype(stereotype);
		return s != null;
	}
	
	private static void dumpStereotypes(Element e)
	{
		System.out.println("Applicable Stereotypes: ");
		Set stereotypes = e.getApplicableStereotypes();
		for (Object s : stereotypes)
		{
			System.out.println(((Stereotype)s).getQualifiedName());
		}
		System.out.println("Applied Stereotypes: ");
		stereotypes = e.getAppliedStereotypes();
		for (Object s : stereotypes)
		{
			System.out.println(((Stereotype)s).getQualifiedName());
		}
	}
	
	public static String ElementToString(Element e)
	{
		String result = e.getClass().getSimpleName().replaceAll("Impl","");
		
		if (e instanceof NamedElement){
			result += " " + ((NamedElement)e).getLabel();
		}
		return result;
	}
}
