/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

//import de.uka.ipd.sdq.codegen.simudatavisualization.actions.Visualization.AppType;
//import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
//import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
//import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
//import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
//import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author admin
 *
 */
public class CreateChartAction implements IWorkbenchWindowActionDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
//		Visualization scv = new Visualization();
//		IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
//
//		List<Double> samples = new ArrayList<Double>();
//		List<Double> samples2 = new ArrayList<Double>();
//		Collections.addAll(samples, 0.2, 0.1, 0.3, 0.4);
//		Collections.addAll(samples2, 0.1, 0.4, 0.2, 0.3, 0.5, 0.6, 0.3);
//		ISamplePDF s = null;
//		s = pfFactory.createSamplePDFFromDouble(0.1, samples, null);
//
//		scv.startAs(AppType.SWT);
//		//deprecated (acc. to Ihssane)... scv.setChartTyp(ChartType.LINECHART);
//
//		try {
//			scv.addProbabilityFunction(s);
////			scv.addProbabilityFunction(pfFactory.createSamplePDFFromDouble(0.1,
////					samples2, null));
//
//		} catch (UnorderedDomainException e) {
//			e.printStackTrace();
//		} catch (UnknownPDFTypeException e) {
//			e.printStackTrace();
//		} catch (DifferentDomainsException e) {
//			e.printStackTrace();
//		}
//
//		scv
//				.setSourceConfigFile("src/de/uka/ipd/sdq/probfunction/visualization/resource/defalutconfig.xml");
//
//		scv.setMaxValue(0.4);
//		scv.setMinValue(0.1);
//
//		//scv.exportChartToImage("chart.svg", ImageFormat.SVG);
//		scv.visualize();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
