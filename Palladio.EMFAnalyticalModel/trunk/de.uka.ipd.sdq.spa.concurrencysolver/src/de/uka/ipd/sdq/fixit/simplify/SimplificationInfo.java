package de.uka.ipd.sdq.fixit.simplify;

public class SimplificationInfo {
	private boolean resourceOp;
	
	public SimplificationInfo(){
		resourceOp = false;
	}

	public boolean isResourceOp() {
		return resourceOp;
	}

	public void setResourceOp(boolean resourceOp) {
		this.resourceOp = resourceOp;
	}
	
	
}
