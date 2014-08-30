/**
 * 
 */
package util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**Various helper functions.
 * @author groenda
 *
 */
public class Helper {
	 public static String getText(AdapterFactory adapterFactory, Object target) {
		 IItemLabelProvider itemProvider = (IItemLabelProvider) adapterFactory.adapt(target, IItemLabelProvider.class);
		 return itemProvider.getText(target);
	}
}
