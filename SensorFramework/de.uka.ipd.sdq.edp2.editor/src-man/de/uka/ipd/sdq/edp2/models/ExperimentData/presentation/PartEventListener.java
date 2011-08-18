/**
 * 
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.EditorPart;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.visualization.IDataFlow;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.filter.WarmupFilter;

/**
 * @author Dominik Ernst
 *
 */
public class PartEventListener implements IPartListener2 {
	
	/**
	 * Logger for this class
	 */
	private final static Logger logger = Logger.getLogger(PartEventListener.class
			.getCanonicalName());

	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partClosed(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		logger.log(Level.INFO, "partClosed of Part is called");
		IEditorPart part = (IEditorPart) partRef.getPart(false);
		if (partRef.getPart(false) instanceof AbstractEditor){
			logger.log(Level.INFO, "closed Editor is an AbstractEditor");
			AbstractEditor editor = (AbstractEditor)part;
			IDataSink input = (IDataSink)editor.getEditorInput();
			IDataFlow flow = input.getSource();
			
			/*while (flow != null) {
				flow = ((IDataSink)flow).getSource();
			}
			
			if (flow != null){*/
				for (Repository repo : RepositoryManager.getCentralRepository().getAvailableRepositories()){
					if (repo.canClose()){
						try {
							repo.close();
							logger.log(Level.INFO, "Repository with UUID "+repo.getUuid()+" closed");
						} catch (DataNotAccessibleException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				//TODO close repository of EDP2Source
			//}
			
		}

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partHidden(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partOpened(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener2#partVisible(org.eclipse.ui.IWorkbenchPartReference)
	 */
	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub

	}

}
