package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
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
			// TODO: Quick fix. Adjust wrong PDFs
			EList samples = object.getSamples();
			double sum = 0;
			for(ContinuousSample sample : (Collection<ContinuousSample>)samples) {
				sum += sample.getProbability();
			}
			if (Math.abs(sum - 1) > 10e-10 ){
				ContinuousSample fix = ProbfunctionFactory.eINSTANCE.createContinuousSample();
				fix.setProbability(1-sum);
				fix.setValue(((ContinuousSample)object.getSamples().get(object.getSamples().size()-1)).getValue()+0.00001);
				object.getSamples().add(fix);
			}
			// END TODO: Quick fix. Adjust wrong PDFs
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
			try {
				pdf.checkConstrains();
			} catch(Exception ex) {
				throw new RuntimeException("PMF not valid: "+new ProbFunctionPrettyPrint().doSwitch(object));
			}
			probFunctions.put(object, pdf);
			return super.caseBoxedPDF(object);
		}

		@Override
		public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
			// TODO: Quick fix. Adjust wrong PDFs
			EList samples = object.getSamples();
			double sum = 0;
			for(Sample sample : (Collection<Sample>)samples) {
				sum += sample.getProbability();
			}
			if (Math.abs(sum - 1) > 10e-10 ){
				Sample fix = ProbfunctionFactory.eINSTANCE.createSample();
				fix.setProbability(1-sum);
				fix.setValue(((Sample)object.getSamples().get(object.getSamples().size()-1)).getValue());
				object.getSamples().add(fix);
			}
			// END TODO: Quick fix. Adjust wrong PDFs

			IProbabilityMassFunction pmf = IProbabilityFunctionFactory.eINSTANCE.transformToPMF(object);		
			try {
				pmf.checkConstrains();
			} catch(Exception ex) {
				throw new RuntimeException("PMF not valid: "+new ProbFunctionPrettyPrint().doSwitch(object));
			}
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
