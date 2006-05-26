package RegEx.visitor;


import java.io.File;
import java.util.Iterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.RegExPackage;
import RegEx.TimeConsumption;
import RegEx.util.Serialization;
import RegEx.util.Visualization;

public class MainClass {

	/**
	 * <!-- begin-user-doc --> Prints diagnostics with indentation. <!--
	 * end-user-doc -->
	 * 
	 * @param diagnostic
	 *            the diagnostic to print.
	 * @param indent
	 *            the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Iterator i = diagnostic.getChildren().iterator(); i.hasNext();) {
			printDiagnostic((Diagnostic) i.next(), indent + "  ");
		}
	}

	public static void main(String[] args) {
		Expression expr = 
			(Expression)Serialization.loadFromXMI(
			"C:\\Dokumente und Einstellungen\\koziolek\\workspace\\RegExVisitor\\Parallel.regex");
		
		// get measured distribution function
		DistributionFunction distFunc = 
			(DistributionFunction)Serialization.loadFromXMI(
			"C:\\Dokumente und Einstellungen\\koziolek\\workspace\\Example\\single_thread.xmi");
		
		// add measured distribution function to symbol nodes
		RegExInitVisitor initVisitor = new RegExInitVisitor(expr,distFunc);

		RegExPerformanceVisitor perfVisitor = new RegExPerformanceVisitor(expr,2);
	
		TimeConsumption[] cpuTimes = perfVisitor.getResultCpuTimes();
		Visualization vis = new Visualization(cpuTimes[0].getNormDF().getDistance());

		for (int i = 0; i < cpuTimes.length; i++) {
			printDF(cpuTimes[i].getNormDF());
			vis.addDistributionFunction(cpuTimes[i].getNormDF(), "CPU"+i);
		}
		vis.visualize();

	}
	
	public static void printDF(DistributionFunction df){
		Complex[] points = getPointArray(df);
		double sum = 0;
		for (int i = 0; i < points.length; i++) {
			if (points[i].getRe() < 0.0001){
				System.out.println("0");				
			} else {
				System.out.println(points[i].getRe());				
			}
			sum += points[i].getRe();
		}		
		System.out.println();
		System.out.println(sum);
		System.out.println();
	}
	
	public static Complex[] getPointArray(DistributionFunction df){
		return (Complex[]) df.getPoints().toArray();
	}
	
}
