package de.uka.ipd.sdq.dsexplore.analysis;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;

public abstract class AbstractPerformanceAttributeDeclaration implements IAnalysisQualityAttributeDeclaration{

	protected Dimension responseTimeDimension;
	protected Dimension throughputDimension;
	protected Dimension maxUtilizationDimension;
	
	public static final String[] qualityAttributes = {
			QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH,
			QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH,
			QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_MAX_UTIL_DEFINITION_PATH};

	public AbstractPerformanceAttributeDeclaration() {
		super();
		QMLDimensionReader reader = new QMLDimensionReader();
		responseTimeDimension = reader.getDimension(qualityAttributes[0]);
		throughputDimension = reader.getDimension(qualityAttributes[1]);
		maxUtilizationDimension = reader.getDimension(qualityAttributes[2]);
	}

	@Override
	public List<Dimension> getDimensions() {
		
		List<Dimension> dimensionList = new ArrayList<Dimension>(2);
		dimensionList.add(responseTimeDimension);
		dimensionList.add(throughputDimension);
		dimensionList.add(maxUtilizationDimension);
	
		return dimensionList;
	}

	@Override
	public QualityAttribute getQualityAttribute() {
		return QualityAttribute.PERFORMANCE_QUALITY;
	}
	

	public Dimension getResponseTime() {
		return this.responseTimeDimension;
	}

	public Dimension getThroughput() {
		return this.throughputDimension;
	}
	
	public Dimension getMaxUtilization() {
		return this.maxUtilizationDimension;
	}

}