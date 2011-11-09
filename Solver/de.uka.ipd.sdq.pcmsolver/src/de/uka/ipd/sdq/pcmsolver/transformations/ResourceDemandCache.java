package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.HashMap;

import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

/**
 * Cache for the solved resource demands. Stores both pdfs and constant demands.
 * Offers methods to retrieve the actual demand for a ParametricResourceDemand
 * as aa double (i.e. mean value or constant) or PDF.
 * 
 * @author martens
 * 
 */
class ResourceDemandCache {
	private HashMap<ParametricResourceDemand, ExpressionToPDFWrapper> resDemandDistributions = new HashMap<ParametricResourceDemand, ExpressionToPDFWrapper>();

	/**
	 * Returns the resource demand for the passed
	 * {@link ParametricResourceDemand} as a {@link Double}. May return null if
	 * there was no matching resource demand found internally. If the resource
	 * demand was only given as a pdf before, it also puts the Double in the
	 * cache for future use.
	 * 
	 * @param prd
	 * @return
	 */
	public Double getDouble(ParametricResourceDemand prd) {
		if (this.resDemandDistributions.containsKey(prd)) {
			return this.resDemandDistributions.get(prd).getMeanValue();
		}
		return null;
	}

	/**
	 * Returns the resource demand for the passed
	 * {@link ParametricResourceDemand} as a {@link ManagedPDF}. May return null
	 * if there was no matching resource demand found internally. If the
	 * resource demand was only given as a double before, it also puts the new
	 * pdf in the cache for future use.
	 * 
	 * @param prd
	 * @return
	 */
	public ManagedPDF getPDF(ParametricResourceDemand prd) {
		if (this.resDemandDistributions.containsKey(prd)) {
			return new ManagedPDF(resDemandDistributions.get(prd).getPDF());
		}
		return null;
	}

	/**
	 * Returns whether this resource demand is a derived pdf (i.e. it has been
	 * created using a mean value) or whether it is an original pdf (i.e. the
	 * mean value is derived).
	 * 
	 * @return true if it has been created using
	 *         {@link #put(ParametricResourceDemand, ProbabilityDensityFunction)}
	 *         , false if this has been created using
	 *         {@link #put(ParametricResourceDemand, Double)}.
	 */
	public boolean isOriginalPDF(ParametricResourceDemand prd) {
		if (this.resDemandDistributions.containsKey(prd)) {
			return this.resDemandDistributions.get(prd).isOriginalPDF();
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param parametricResourceDemand
	 * @param rdWrapper
	 */
	public void put(ParametricResourceDemand parametricResourceDemand,
			ExpressionToPDFWrapper rdWrapper) {
		this.resDemandDistributions.put(parametricResourceDemand, rdWrapper);

	}
}
