package de.uka.ipd.sdq.edp2.visualization;

import java.util.Observer;

import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;

/**
 * Interface for {@link EditorPart}s, which are intended to display experiment
 * data. Editors should support Persistence @see {@link IPersistableEditor}. In
 * addition, they serve as {@link ITabbedPropertySheetPageContributor}.
 * Clients should not implement this interface but instead subclass {@link AbstractEditor}.
 * 
 * @author Dominik Ernst
 * 
 */
public interface IVisualization extends IPersistableEditor,
		ITabbedPropertySheetPageContributor, Observer {
	
	public IVisualizationInputHandle getEditorInputHandle();
	
}
