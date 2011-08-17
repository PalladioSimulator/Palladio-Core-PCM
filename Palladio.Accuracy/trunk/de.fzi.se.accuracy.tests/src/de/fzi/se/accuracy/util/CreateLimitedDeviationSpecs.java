/**
 *
 */
package de.fzi.se.accuracy.util;

import de.fzi.se.quality.QualityFactory;
import de.fzi.se.quality.QualityRepository;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

/**Creates default specifications for all RD-SEFFs in an repository.
 * The default values can be set with the methods {@link #createPrecisionNumberOfCalls()} and {@link #createPrecisionCallParameter()}.
 * An exception for the default is the handling of the number of calls for components / external calls.
 * @author groenda
 *
 */
public class CreateLimitedDeviationSpecs {

	/**Example application.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		createQualitaAnnotationRepository("mediastore");
	}

	/**Creates a quality annotation repository and stores it into a file.
	 * Loads the repository from {@code repositoryFilename}.repository and stores the resulting quality annotations in {@code repositoryFilename}.validation.
	 * @param repositoryFilename Filename (without extension) of the repository. Also used to store the quality annotation repository.
	 */
	public static void createQualitaAnnotationRepository(String repositoryFilename) {
		ModelHandlingUtil.initializeEmfFactories();
		Repository repo = (Repository) ModelHandlingUtil.loadFromFile(repositoryFilename + ".repository");
		QualityRepository qRepo = QualityFactory.eINSTANCE.createQualityRepository();
		for (RepositoryComponent rcomp : repo.getComponents__Repository()) {
			if (rcomp instanceof BasicComponent) {
				for (final ServiceEffectSpecification seff : ((BasicComponent)rcomp).getServiceEffectSpecifications__BasicComponent()) {
					final QualityAnnotation qa = QualityAnnotationFactory.eINSTANCE.createQualityAnnotation();
					qa.setIsValid(true);
					Boolean infrastructureRECategory = false;
					Boolean operationRECategory = false;
					Boolean resourceRECategory = false;
					Boolean resourceDemandRECategory = true;
					RoleCategoryCheck roleCategoryCheck = new RoleCategoryCheck();
					// check which RE categories need to be specified
					for (RequiredRole role : rcomp.getRequiredRoles_InterfaceRequiringEntity()) {
						roleCategoryCheck.doSwitch(role);
					}
					infrastructureRECategory = roleCategoryCheck.infrastructureRECategory;
					operationRECategory = roleCategoryCheck.operationRECategory;
					if (rcomp.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().size() > 0) {
						resourceRECategory = true;
					}
					PCMServiceSpecification serviceSpec = QualityAnnotationFactory.eINSTANCE.createPCMServiceSpecification();
					serviceSpec.setResourceDemandingSEFF((ResourceDemandingSEFF) seff);
					qa.setForServiceSpecification(serviceSpec);
					PCMRECategory reCategory;
					REPrecision precision;
					if (infrastructureRECategory) {
						reCategory = QualityAnnotationFactory.eINSTANCE.createPCMRECategory();
						reCategory.setCategory(PCMRERequestCategory.INFRASTRUCTURE);
						precision = QualityAnnotationFactory.eINSTANCE.createREPrecision();
						precision.setDefaultPrecisionCallParameter(createPrecisionCallParameter());
						precision.setDefaultPrecisionNumberOfCalls(createPrecisionNumberOfCalls());
						reCategory.setPrecision(precision);
						qa.getStipulatedREPrecisions().add(reCategory);
					}
					if (operationRECategory) {
						reCategory = QualityAnnotationFactory.eINSTANCE.createPCMRECategory();
						reCategory.setCategory(PCMRERequestCategory.COMPONENT);
						precision = QualityAnnotationFactory.eINSTANCE.createREPrecision();
						precision.setDefaultPrecisionCallParameter(createPrecisionCallParameter());
						precision.setDefaultPrecisionNumberOfCalls(QualityAnnotationFactory.eINSTANCE.createExactlyAsSpecifiedPrecision());
						reCategory.setPrecision(precision);
						qa.getStipulatedREPrecisions().add(reCategory);
					}
					if (resourceRECategory) {
						reCategory = QualityAnnotationFactory.eINSTANCE.createPCMRECategory();
						reCategory.setCategory(PCMRERequestCategory.RESOURCE);
						precision = QualityAnnotationFactory.eINSTANCE.createREPrecision();
						precision.setDefaultPrecisionCallParameter(createPrecisionCallParameter());
						precision.setDefaultPrecisionNumberOfCalls(createPrecisionNumberOfCalls());
						reCategory.setPrecision(precision);
						qa.getStipulatedREPrecisions().add(reCategory);
					}
					if (resourceDemandRECategory) {
						reCategory = QualityAnnotationFactory.eINSTANCE.createPCMRECategory();
						reCategory.setCategory(PCMRERequestCategory.RESOURCE_DEMAND);
						precision = QualityAnnotationFactory.eINSTANCE.createREPrecision();
						precision.setDefaultPrecisionCallParameter(QualityAnnotationFactory.eINSTANCE.createNoPrecision());
						precision.setDefaultPrecisionNumberOfCalls(createPrecisionNumberOfCalls());
						reCategory.setPrecision(precision);
						qa.getStipulatedREPrecisions().add(reCategory);
					}
					qRepo.getQualityStatements().add(qa);
				}
			}
		}
		ModelHandlingUtil.saveToFile(repositoryFilename + ".validation", qRepo);
	}

	/**
	 * @return Default value for number of calls.
	 */
	private static Precision createPrecisionNumberOfCalls() {
		LimitedDeviationPrecision precision = QualityAnnotationFactory.eINSTANCE.createLimitedDeviationPrecision();
		precision.setAbsolute(5.0);
		precision.setRelative(0.10);
		return precision;
	}

	/**
	 * @return Default value for call parameters.
	 */
	private static Precision createPrecisionCallParameter() {
		LimitedDeviationPrecision precision = QualityAnnotationFactory.eINSTANCE.createLimitedDeviationPrecision();
		precision.setAbsolute(5.0);
		precision.setRelative(0.10);
		return precision;
	}


}
