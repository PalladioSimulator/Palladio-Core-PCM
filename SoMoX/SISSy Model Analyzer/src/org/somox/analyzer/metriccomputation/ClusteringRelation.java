package org.somox.analyzer.metriccomputation;

import java.util.List;

import de.fzi.gast.types.GASTClass;

public class ClusteringRelation {
	private List<GASTClass> componentA;
	private List<GASTClass> componentB;
	private double result;
	
	public ClusteringRelation (List<GASTClass> componentA, List<GASTClass> componentB) {
		this.componentA = componentA;
		this.componentB = componentB;		
	}
	
	public void setComponentA(List<GASTClass> componentA) {
		this.componentA = componentA;
	}
	
	public List<GASTClass> getComponentA() {
		return componentA;
	}
	
	public void setComponentB(List<GASTClass> componentB) {
		this.componentB = componentB;
	}
	
	public List<GASTClass> getComponentB() {
		return componentB;
	}
	
	public void setResult (double result) {
		this.result = result;
	}
	
	public double getResult() {
		return result;
	}
}
