/**
 *
 */
package de.fzi.se.quality.util;

import java.util.logging.Logger;

import de.fzi.se.quality.qualityannotation.PCMPE;
import de.fzi.se.quality.qualityannotation.PCMPEAllDecisions;
import de.fzi.se.quality.qualityannotation.PCMPEDecision;
import de.fzi.se.quality.qualityannotation.PCMRE;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMREInterface;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.PCMRERole;
import de.fzi.se.quality.qualityannotation.PCMRESignature;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;
import de.uka.ipd.sdq.pcm.seff.BranchAction;

/**Lookup functions for elements in QualityAnnotation instances.
 * @author groenda
 *
 */
public class QualityAnnotationLookup {
	/** Logger for this class. */
	public static final Logger LOGGER = Logger.getLogger(QualityAnnotationLookup.class.getCanonicalName());

	/** The quality annotation which is used for lookups. */
	private QualityAnnotation qualityAnnotation;

	public QualityAnnotationLookup(QualityAnnotation qualityAnnotation) {
		this.qualityAnnotation = qualityAnnotation;
	}
	
	/**Retrieves the probabilistic element for the given PCM entity.
	 * @param branchAction The PCM entity.
	 * @return The probabilistic element description. <code>null</code> if no matching element was found.
	 */
	public PCMPE getPCMPE(final BranchAction branchAction) {
		for (ProbabilisticElement pe : qualityAnnotation.getProbabilisticElements()) {
			if (pe instanceof PCMPEAllDecisions) {
				PCMPEAllDecisions allDecisions = (PCMPEAllDecisions) pe;
				for (ProbabilisticElement peLevel2 : allDecisions.getChildPEs()) {
					if (peLevel2 instanceof PCMPEDecision) {
						PCMPEDecision decision = (PCMPEDecision) peLevel2;
						if (decision.getBranchAction().equals(branchAction)) {
							return decision;
						}
					}
				}
				return allDecisions;
			}
		}
		return null;
	}

	/**Retrieves the precision for the given PCM entity.
	 * @param branchAction The PCM entity.
	 * @return The precision. <code>null</code> if no matching element was found.
	 */
	public Precision getPCMPEPrecision(final BranchAction branchAction) {
		PCMPE pcmpe = getPCMPE(branchAction);
		if (pcmpe == null) {
			return null;
		} else {
			return pcmpe.getPrecision();
		}
	}
	
	/**Retrieves a required element for the given PCM entity.
	 * @param category The category for which the required element is requested.
	 * @return The required element. {@code null} if no matching element was found.
	 */
	public PCMRECategory getRequiredElement(final PCMRERequestCategory category) {
		int found = 0;
		PCMRECategory foundRE;
		PCMRECategory result = null;
		for (RequiredElement re : qualityAnnotation.getStipulatedREPrecisions()) {
			if (re instanceof PCMRECategory) {
				foundRE = (PCMRECategory) re;
				if (foundRE.getCategory().equals(category)) {
					result = foundRE;
					found++;
				}
			}
		}
		if (found > 1) {
			throw new IllegalStateException("Cardinality of [0..1] breached. " + found + " request elements satisfied the search condition. ");
		}
		return result;
	}

	/**Retrieves a required element for the given PCM entity.
	 * @param iface The interface for which the required element is requested.
	 * @return The required element. {@code null} if no matching element was found.
	 */
	public PCMREInterface getRequiredElement(final Interface iface) {
		int found = 0;
		PCMREInterface foundRE;
		PCMREInterface result = null;
		for (RequiredElement re : qualityAnnotation.getStipulatedREPrecisions()) {
			if (re instanceof PCMREInterface) {
				foundRE = (PCMREInterface) re;
				if (foundRE.getInterface() == iface) {
					result = foundRE;
					found++;
				}
			}
		}
		if (found > 1) {
			throw new IllegalStateException("Cardinality of [0..1] breached. " + found + " request elements satisfied the search condition. ");
		}
		return result;
	}

	/**Retrieves a required element for the given PCM entity.
	 * @param role The interface for which the required element is requested.
	 * @return The required element. {@code null} if no matching element was found.
	 */
	public PCMRERole getRequiredElement(final Role role) {
		int found = 0;
		PCMRERole foundRE;
		PCMRERole result = null;
		for (RequiredElement re : qualityAnnotation.getStipulatedREPrecisions()) {
			if (re instanceof PCMRERole) {
				foundRE = (PCMRERole) re;
				if (foundRE.getRole() == role) {
					result = foundRE;
					found++;
				}
			}
		}
		if (found > 1) {
			throw new IllegalStateException("Cardinality of [0..1] breached. " + found + " request elements satisfied the search condition. ");
		}
		return result;
	}

	/**Retrieves a required element for the given PCM entity.
	 * @param signature The interface for which the required element is requested.
	 * @return The required element. {@code null} if no matching element was found.
	 */
	public PCMRESignature getRequiredElement(final Signature signature) {
		int found = 0;
		PCMRESignature foundRE;
		PCMRESignature result = null;
		for (RequiredElement re : qualityAnnotation.getStipulatedREPrecisions()) {
			if (re instanceof PCMRESignature) {
				foundRE = (PCMRESignature) re;
				if (foundRE.getSignature() == signature) {
					result = foundRE;
					found++;
				}
			}
		}
		if (found > 1) {
			throw new IllegalStateException("Cardinality of [0..1] breached. " + found + " request elements satisfied the search condition. ");
		}
		return result;
	}

	/**Gets the stated precision for the number of calls.
	 * @param signature Signature of the resource service.
	 * @param role Role of the resource service. {@code null} if unknown.
	 * @return The stated precision.
	 */
	public Precision getPCMREPrecisionNoC(InfrastructureSignature signature, InfrastructureRequiredRole role) {
		REPrecision precision = getPCMREPrecision(signature, role);
		return precision==null ? null : precision.getDefaultPrecisionNumberOfCalls();
	}

	/**Gets the stated precision for the call parameters.
	 * @param signature Signature of the resource service.
	 * @param role Role of the resource service. {@code null} if unknown.
	 * @return The stated precision.
	 */
	public Precision getPCMREPrecisionCP(InfrastructureSignature signature, InfrastructureRequiredRole role) {
		REPrecision precision = getPCMREPrecision(signature, role);
		return precision==null ? null : precision.getDefaultPrecisionCallParameter();
	}

	/**Gets the stated precision for the number of calls.
	 * @param signature Signature of the operation.
	 * @param role Role of the interface. {@code null} if unknown.
	 * @return The stated precision.
	 */
	public Precision getPCMREPrecisionNoC(OperationSignature signature, OperationRequiredRole role) {
		REPrecision precision = getPCMREPrecision(signature, role);
		return precision==null ? null : precision.getDefaultPrecisionNumberOfCalls();
	}

	/**Gets the stated precision for the number of calls.
	 * @param signature Signature of the operation.
	 * @param role Role of the interface. {@code null} if unknown.
	 * @return The stated precision.
	 */
	public Precision getPCMREPrecisionCP(OperationSignature signature, OperationRequiredRole role) {
		REPrecision precision = getPCMREPrecision(signature, role);
		return precision==null ? null : precision.getDefaultPrecisionCallParameter();
	}

	/**Gets the statement for a required element.
	 * @param signature Signature of the operation.
	 * @param role Role of the interface. {@code null} if unknown.
	 * @return The stated required element.
	 */
	public REPrecision getPCMREPrecision(OperationSignature signature, OperationRequiredRole role) {
		PCMRERequestCategory category = PCMRERequestCategory.COMPONENT;
		Interface iface = signature.getInterface__OperationSignature();
		PCMRE current = getPCMRE(signature, role, category, iface);
		return current==null ? null : current.getPrecision();
	}

	/**Gets the statement for a required element.
	 * @param signature Signature of the resource service.
	 * @param role Role of the resource service. {@code null} if unknown.
	 * @return The stated required element.
	 */
	public REPrecision getPCMREPrecision(InfrastructureSignature signature, InfrastructureRequiredRole role) {
		PCMRERequestCategory category = PCMRERequestCategory.INFRASTRUCTURE;
		InfrastructureInterface iface = signature==null ? null : signature.getInfrastructureInterface__InfrastructureSignature();
		PCMRE current = getPCMRE(signature, role, category, iface);
		return current==null ? null : current.getPrecision();
	}

	/**Gets the statement for a required element.
	 * @param signature Signature of the resource service.
	 * @param role Role of the resource service. {@code null} if unknown.
	 * @return The stated required element.
	 */
	public REPrecision getPCMREPrecision(ResourceSignature signature, ResourceRequiredRole role) {
		PCMRERequestCategory category = PCMRERequestCategory.RESOURCE;
		ResourceInterface iface = signature==null ? null : signature.getResourceInterface__ResourceSignature();
		PCMRE current = getPCMRE(signature, role, category, iface);
		return current==null ? null : current.getPrecision();
	}

	/**Gets the statement for a required element.
	 * @param signature Signature of the resource service.
	 * @param role Role of the resource service. {@code null} if unknown.
	 * @return The stated required element.
	 */
	public REPrecision getPCMREPrecisionCategoryResourceDemand() {
		PCMRERequestCategory category = PCMRERequestCategory.RESOURCE_DEMAND;
		PCMRECategory current = getRequiredElement(category);
		return current==null ? null : current.getPrecision();
	}

	/**Gets the statement for a required element.
	 * @param signature Signature of the resource service.
	 * @param role Role of the resource service. {@code null} if unknown.
	 * @return The stated required element.
	 */
	public REPrecision getPCMREPrecisionCategoryComponentInternal() {
		PCMRERequestCategory category = PCMRERequestCategory.COMPONENT_INTERNAL;
		PCMRECategory current = getRequiredElement(category);
		return current==null ? null : current.getPrecision();
	}

	/**Gets the most specific PCM Required Element for the given target.
	 * @param signature Requested Signature.
	 * @param role Required role.
	 * @param category Requested Category.
	 * @param iface Requested Interface.
	 * @return {@link PCMRE} or {@code null} if none could be found.
	 */
	private PCMRE getPCMRE(Signature signature,
			Role role, PCMRERequestCategory category,
			Interface iface) {
		assert(category == PCMRERequestCategory.INFRASTRUCTURE || category == PCMRERequestCategory.COMPONENT);

		PCMRE current =  null;
		PCMRECategory reCategory = null;
		reCategory = getRequiredElement(category);
		if (reCategory != null) {
			current = reCategory;
			PCMREInterface reInterface = null;
			for (RequiredElement req : EMFHelper.getObjectsByType(reCategory.getChildREs(), PCMREInterface.class)) {
				reInterface = (PCMREInterface) req;
				if (reInterface.getInterface() == iface) {
					current = reInterface;
					PCMRERole reRole = null;
					for (RequiredElement req2 : reInterface.getChildREs()) {
						reRole = (PCMRERole) req2;
						if (reRole.getRole() == role) {
							current = reRole;
							PCMRESignature reSignature = null;
							for (RequiredElement req3 : EMFHelper.getObjectsByType(reRole.getChildREs(), PCMRESignature.class)) {
								reSignature = (PCMRESignature) req3;
								if (reSignature.getSignature() == signature) {
									current = reSignature;
								}
							}
						}
					}
				}
			}
		} else {
			String msg = "Could not find a RE Precision for the category " + category + ". Add an RE Precision for this category.";
			LOGGER.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		return current;
	}

	/**Gets the most specific PCM Required Element for the given target.
	 * @param signature Requested Resource Signature.
	 * @param role Required role.
	 * @param category Requested Category.
	 * @param iface Requested Resource Interface.
	 * @return {@link PCMRE} or {@code null} if none could be found.
	 */
	private PCMRE getPCMRE(ResourceSignature signature,
			Role role, PCMRERequestCategory category,
			ResourceInterface iface) {
		assert(category == PCMRERequestCategory.RESOURCE);

		PCMRE current =  null;
		PCMRECategory reCategory = null;
		reCategory = getRequiredElement(category);
		if (reCategory != null) {
			current = reCategory;
			PCMREResourceInterface reInterface = null;
			for (RequiredElement req : EMFHelper.getObjectsByType(reCategory.getChildREs(), PCMREResourceInterface.class)) {
				if (req instanceof PCMREResourceInterface) {
					reInterface = (PCMREResourceInterface) req;
					if (reInterface.getResourceInterface() == iface) {
						current = reInterface;
						PCMRERole reRole = null;
						for (RequiredElement req2 : reInterface.getChildREs()) {
							reRole = (PCMRERole) req2;
							if (reRole.getRole() == role) {
								current = reRole;
								PCMREResourceSignature reSignature = null;
								for (RequiredElement req3 : EMFHelper.getObjectsByType(reRole.getChildREs(), PCMREResourceSignature.class)) {
									reSignature = (PCMREResourceSignature) req3;
									if (reSignature.getResourceSignature() == signature) {
										current = reSignature;
									}
								}
							}
						}
					}
				}
			}
		} else {
			String msg = "Could not find a RE Precision for the category " + category + ". Add an RE Precision for this category.";
			LOGGER.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		return current;
	}
	
	/**
	 * @return the qualityAnnotation
	 */
	public QualityAnnotation getQualityAnnotation() {
		return qualityAnnotation;
	}
	
}
