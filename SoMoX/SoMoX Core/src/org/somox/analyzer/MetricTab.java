package org.somox.analyzer;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;


public abstract class MetricTab extends AbstractLaunchConfigurationTab {
	
	private ModelAnalyzerTabGroupBlackboard blackboard = null;
	
	public ModelAnalyzerTabGroupBlackboard getModelAnalyzerTabGroupBlackboard() {
		return blackboard;
	}
	
	public void setModelAnalyzerTabGroupBlackboard(ModelAnalyzerTabGroupBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
