package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ui.INewWizard;

public interface IModelSelectionWizard extends INewWizard {

		public Collection<EPackage> getSelectedModelPackages();
}
