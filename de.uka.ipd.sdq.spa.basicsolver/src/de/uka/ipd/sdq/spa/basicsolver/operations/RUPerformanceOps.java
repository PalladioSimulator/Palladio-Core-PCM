package de.uka.ipd.sdq.spa.basicsolver.operations;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.spa.basicsolver.exceptions.BothNullExpeception;
import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

public class RUPerformanceOps {

	private PDFPerformanceOps pdfPerformanceOps;

	public RUPerformanceOps(PDFPerformanceOps pdfPerformanceOps) {
		super();
		this.pdfPerformanceOps = pdfPerformanceOps;
	}

	public RUPerformanceOps() {
		pdfPerformanceOps = new PDFPerformanceOps();
	}

	public Hashtable<ActiveResource, ManagedPDF> computeIteration(
			Hashtable<ActiveResource, ManagedPDF> innerRUs,
			IProbabilityMassFunction iterations) throws ConfigurationNotSetException {
		Hashtable<ActiveResource, ManagedPDF> resultTable = new Hashtable<ActiveResource, ManagedPDF>();

		try {
			for (ActiveResource resource : innerRUs.keySet()) {
				ManagedPDF ru = pdfPerformanceOps.computeIteration(innerRUs.get(resource),
						iterations);
				resultTable.put(resource, ru);
			}
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return resultTable;

	}

	public Hashtable<Resource, ManagedPDF> getResourceUsageTimes(
			List<ResourceUsage> resourceUsageList) {

		Hashtable<Resource, ManagedPDF> resultTable = new Hashtable<Resource, ManagedPDF>();
		for (ResourceUsage resourceUsage : resourceUsageList) {
			Resource resource = resourceUsage.getResource();
			ManagedPDF managedPDF = new ManagedPDF(
					resourceUsage.getUsageTime(), true);
			resultTable.put(resource, managedPDF);
		}
		return resultTable;
	}

	public Hashtable<ActiveResource, ManagedPDF> computeAlternative(
			Hashtable<ActiveResource, ManagedPDF> leftRUs, double leftProb,
			Hashtable<ActiveResource, ManagedPDF> rightRUs, double rightProb) {

		return performOperation(BinaryOperation.ALTERNATIVE, leftRUs, leftProb,
				rightRUs, rightProb);
	}

	public Hashtable<ActiveResource, ManagedPDF> computeParallel(
			Hashtable<ActiveResource, ManagedPDF> leftRUs,
			Hashtable<ActiveResource, ManagedPDF> rightRUs) {

		return performOperation(BinaryOperation.PARALLEL, leftRUs, 0, rightRUs,
				0);
	}

	public Hashtable<ActiveResource, ManagedPDF> computeSequence(
			Hashtable<ActiveResource, ManagedPDF> leftRUs,
			Hashtable<ActiveResource, ManagedPDF> rightRUs) {

		return performOperation(BinaryOperation.SEQUENCE, leftRUs, 0, rightRUs,
				0);
	}

	private Hashtable<ActiveResource, ManagedPDF> performOperation(
			BinaryOperation op, Hashtable<ActiveResource, ManagedPDF> leftRUs,
			double leftProbability,
			Hashtable<ActiveResource, ManagedPDF> rightRUs,
			double rightProbability) {

		Hashtable<ActiveResource, ManagedPDF> resultTable = new Hashtable<ActiveResource, ManagedPDF>();

		try {
			List<ActiveResource> keyList = getDisjointUnion(leftRUs.keySet(),
					rightRUs.keySet());
			for (ActiveResource resource : keyList) {
				ManagedPDF leftRU = leftRUs.get(resource);
				ManagedPDF rightRU = rightRUs.get(resource);
				ManagedPDF resultRU = performOperation(op, leftRU,
						leftProbability, rightRU, rightProbability);
				resultTable.put(resource, resultRU);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return resultTable;
	}

	private ManagedPDF performOperation(BinaryOperation op, ManagedPDF leftRU,
			double leftProbability, ManagedPDF rightRU, double rightProbability)
			throws ProbabilityFunctionException, BothNullExpeception, ConfigurationNotSetException {
		leftRU = ensureNotNull(leftRU, rightRU);
		rightRU = ensureNotNull(rightRU, leftRU);
		return pdfPerformanceOps.performOperation(op, leftRU, leftProbability, rightRU,
				rightProbability);
	}

	private ManagedPDF ensureNotNull(ManagedPDF rightRU, ManagedPDF leftRU)
			throws BothNullExpeception, ConfigurationNotSetException {
		if (rightRU == null) {
			if (leftRU == null) {
				throw new BothNullExpeception();
			} else {
				rightRU = ManagedPDF.createDiracImpulse(); 
			}
		}
		return rightRU;
	}

	private List<ActiveResource> getDisjointUnion(Set<ActiveResource> setOne,
			Set<ActiveResource> name) {
		List<ActiveResource> resultList = new ArrayList<ActiveResource>(setOne);
		for (ActiveResource resource : name) {
			if (!resultList.contains(resource)) {
				resultList.add(resource);
			}
		}
		return resultList;
	}
}
