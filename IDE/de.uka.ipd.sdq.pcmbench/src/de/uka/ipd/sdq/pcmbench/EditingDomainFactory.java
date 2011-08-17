/**
 * 
 */
package de.uka.ipd.sdq.pcmbench;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Factory;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

/**
 * @author Snowball
 *
 */
public class EditingDomainFactory 
	implements Factory {

		public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";

		public TransactionalEditingDomain createEditingDomain() {
			TransactionalEditingDomain result = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain(); 
			return result;
		}
	
		public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
			return TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
		}
	
		public TransactionalEditingDomain getEditingDomain(ResourceSet rset) {
			return TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(rset);
		}
}
