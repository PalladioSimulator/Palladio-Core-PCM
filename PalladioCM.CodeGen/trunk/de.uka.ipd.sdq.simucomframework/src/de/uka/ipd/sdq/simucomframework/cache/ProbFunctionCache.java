package de.uka.ipd.sdq.simucomframework.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.print.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;
import de.uka.ipd.sdq.stoex.Expression;

public class ProbFunctionCache {

	private HashMap<EObject,IProbabilityFunction> probFunctions = new HashMap<EObject,IProbabilityFunction>();
	private ProbfunctionSwitch probFunctionAnnotator = new ProbfunctionSwitch() {
		@Override
		public Object caseBoxedPDF(BoxedPDF object) {
			IProbabilityDensityFunction pdf = null;
			try {
				pdf = IProbabilityFunctionFactory.eINSTANCE.transformToPDF(object);
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (ProbabilitySumNotOneException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (DoubleSampleException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			if (!pdf.checkConstrains())
				throw new RuntimeException("PDF not valid: "+new ProbFunctionPrettyPrint().doSwitch(object));
			probFunctions.put(object, pdf);
			return super.caseBoxedPDF(object);
		}

		@Override
		public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
			IProbabilityMassFunction pmf = IProbabilityFunctionFactory.eINSTANCE.transformToPMF(object);		
			if (!pmf.checkConstrains())
				throw new RuntimeException("PMF not valid: "+new ProbFunctionPrettyPrint().doSwitch(object));
			probFunctions.put(object, pmf);
			return super.caseProbabilityMassFunction(object);
		}
	};
	
	public ProbFunctionCache(Expression ex) {
		for (Iterator it=EcoreUtil.getAllContents(Collections.singleton(ex));
			it.hasNext(); ) {
			EObject eObject = (EObject) it.next();
			probFunctionAnnotator.doSwitch(eObject);
		}
	}

	public IProbabilityFunction getProbFunction(EObject e) {
		assert probFunctions.containsKey(e);
		return probFunctions.get(e);
	}
}
