/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.Adapter;

/**QualityAnnotationItemProviderAdapterFactory which provides human-readable and meaningful text messages.
 * 
 * @author groenda
 *
 */
public class DetailedQualityAnnotationItemProviderAdapterFactory extends
		QualityAnnotationItemProviderAdapterFactory {
	@Override
	public Adapter createQualityAnnotationAdapter() {
		if (this.qualityAnnotationItemProvider == null) {
			this.qualityAnnotationItemProvider = new DetailedQualityAnnotationItemProvider(this);
		}
		return this.qualityAnnotationItemProvider;
	}
	
	@Override
	public Adapter createPCMServiceSpecificationAdapter() {
		if (this.pcmServiceSpecificationItemProvider == null) {
			this.pcmServiceSpecificationItemProvider = new DetailedPCMServiceSpecificationItemProvider(this);
		}
		return this.pcmServiceSpecificationItemProvider;
	}
	
	@Override
	public Adapter createExactlyAsSpecifiedPrecisionAdapter() {
		if (this.exactlyAsSpecifiedPrecisionItemProvider == null) {
			this.exactlyAsSpecifiedPrecisionItemProvider = new DetailedExactylAsSpecifiedPrecisionItemProvider(this);
		}
		return this.exactlyAsSpecifiedPrecisionItemProvider;
	}
	
	@Override
	public Adapter createLimitedDeviationPrecisionAdapter() {
		if (this.limitedDeviationPrecisionItemProvider == null) {
			this.limitedDeviationPrecisionItemProvider = new DetailedLimitedDeviationPrecisionItemProvider(this);
		}
		return this.limitedDeviationPrecisionItemProvider;
	}
	
	@Override
	public Adapter createPCMRECategoryAdapter() {
		if (this.pcmreCategoryItemProvider == null) {
			this.pcmreCategoryItemProvider = new DetailedPCMRECategory(this);
		}
		return this.pcmreCategoryItemProvider;
	}
	
	@Override
	public Adapter createREPrecisionAdapter() {
		if (this.rePrecisionItemProvider == null) {
			this.rePrecisionItemProvider = new DetailedREPrecisionItemProvider(this);
		}
		return this.rePrecisionItemProvider;
	}
	
	@Override
	public Adapter createNoPrecisionAdapter() {
		if (this.noPrecisionItemProvider == null) {
			this.noPrecisionItemProvider = new DetailedNoPrecisionItemProvider(this);
		}
		return this.noPrecisionItemProvider;
	}
	
	@Override
	public Adapter createCharacterisedPCMParameterPartitionIntervalAdapter() {
		if (this.characterisedPCMParameterPartitionIntervalItemProvider == null) {
			this.characterisedPCMParameterPartitionIntervalItemProvider = new QualityCharacterisedPCMParameterPartitionIntervalItemProvider(this);
		}
		return this.characterisedPCMParameterPartitionIntervalItemProvider;
	}
	
	@Override
	public Adapter createCharacterisedPCMParameterPartitionRangeAdapter() {
		if (this.characterisedPCMParameterPartitionRangeItemProvider == null) {
			this.characterisedPCMParameterPartitionRangeItemProvider = new QualityCharacterisedPCMParameterPartitionRangeItemProvider(this);
		}
		return this.characterisedPCMParameterPartitionRangeItemProvider;
	}
}
