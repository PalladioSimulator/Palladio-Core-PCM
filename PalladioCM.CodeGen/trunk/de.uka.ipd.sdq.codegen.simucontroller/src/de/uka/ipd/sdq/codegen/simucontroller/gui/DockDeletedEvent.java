package de.uka.ipd.sdq.codegen.simucontroller.gui;

public class DockDeletedEvent {

	private DockStatusModel addedDock;

	public DockDeletedEvent(DockStatusModel dock) {
		this.addedDock = dock;
	}

	public DockStatusModel getDeletedDock() {
		return addedDock;
	}

}
