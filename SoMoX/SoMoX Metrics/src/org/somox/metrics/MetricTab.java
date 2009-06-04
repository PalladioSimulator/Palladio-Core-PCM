package org.somox.metrics;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.somox.analyzer.ModelAnalyzerTabGroupBlackboard;


public abstract class MetricTab extends AbstractLaunchConfigurationTab {
		
	private ModelAnalyzerTabGroupBlackboard blackboard = null;
	
	public ModelAnalyzerTabGroupBlackboard getModelAnalyzerTabGroupBlackboard() {
		return blackboard;
	}
	
	public void setModelAnalyzerTabGroupBlackboard(ModelAnalyzerTabGroupBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
