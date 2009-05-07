package de.uka.ipd.sdq.code2model.wizards;

import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.code2model.Helpers;
import de.uka.ipd.sdq.code2model.wrappers.Method;
import de.uka.ipd.sdq.code2model.wrappers.Package;


/**
 * @author thomas
 *
 */
public class InvokedMethodsLabelProvider extends LabelProvider {
	private ISharedImages images;
	{
		images = JavaUI.getSharedImages();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Package) {
			Package pkg = (Package) element;
			return pkg.getName();
		} else if (element instanceof Method) {
			Method method = (Method) element;
			String simpleDeclaringClassName = Helpers.getSimpleNameFromQualified(
					method.getQualifiedDeclaringClassName() );
			return simpleDeclaringClassName + "." + method.getMethodName();
		}
		return "<unknown element>";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof Package) {
			return images.getImage(ISharedImages.IMG_OBJS_PACKAGE);			
		}
		return null;
	}
}
