package de.uka.ipd.sdq.codegen.simucontroller.gui;

public class DockAddedEvent {

	private DockStatusModel addedDock;

	public DockAddedEvent(DockStatusModel dock) {
		this.addedDock = dock;
	}

	public DockStatusModel getAddedDock() {
		return addedDock;
	}

}
