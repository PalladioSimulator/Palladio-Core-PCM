package de.uka.ipd.sdq.measurements.driver.common.tasks;

public class FinishIndicator {
	private boolean finishSignal = false;

	public boolean getFinishSignal() {
		return finishSignal;
	}

	public void setFinishSignal(boolean finishSignal) {
		this.finishSignal = finishSignal;
	}
}