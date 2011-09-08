/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;

/**
 * @author Dominik Ernst
 *
 */
public abstract class JFreeChartEditorInput implements IDataSink, ISelection {

	/**
	 * Key under which this class' name is stored in the properties.
	 */
	protected static final String ELEMENT_KEY = "elementName";
	
	protected HashMap<String, Object> properties;
	private IDataSource source;
	private String title;

	public JFreeChartEditorInput(){
		properties = new HashMap<String, Object>();
	}
	
	public JFreeChartEditorInput(IDataSource source){
		properties = new HashMap<String, Object>();
		setSource(source);
		source.addObserver(this);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getSource()
	 */
	@Override
	public IDataSource getSource() {
		return source;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#setSource(de.uka.ipd.sdq.edp2.visualization.IDataSource)
	 */
	@Override
	public void setSource(IDataSource source) {
		this.source = source;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		return source != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return title;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	@Override
	public IPersistableElement getPersistable() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	@Override
	public String getToolTipText() {
		return title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
