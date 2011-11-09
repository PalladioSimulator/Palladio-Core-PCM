package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

/**
 * This class provides auxiliary functionality factored out from the
 * ContextWrapper for examining PCM instances.
 * 
 * TODO: continue the outsourcing to separate context-independent tasks from the
 * ContextWrapper class!
 * 
 * @author brosch
 * 
 */
public class PCMInstanceHelper {

	/**
	 * Extends a given list of AssemblyContexts with a given top-level
	 * AssemblyContext and all nested ones, according to a given top-level
	 * OperationProvidedRole.
	 * 
	 * @param topLevelAssCtx
	 *            the top-level AssemblyContext
	 * @param topLevelProvidedRole
	 *            the top-level OperationProvidedRole, which is assumed to
	 *            belong to the component encapsulated by the top-level
	 *            AssemblyContext.
	 * @param existingAssCtxs
	 *            the existing list of AssemblyContexts
	 * @return the extended AssemblyContext list
	 */
	public static List<AssemblyContext> getAssCtxs(
			final AssemblyContext topLevelAssCtx,
			final OperationProvidedRole topLevelProvidedRole,
			final List<AssemblyContext> existingAssCtxs) {

		// In any case, the top-level AssemblyContext itself
		// will be added to the list:
		existingAssCtxs.add(topLevelAssCtx);

		// Retrieve the encapsulated top-level component:
		RepositoryComponent rc = topLevelAssCtx
				.getEncapsulatedComponent__AssemblyContext();

		// Check for the type of the top-level component:
		if (rc instanceof BasicComponent) {

			// Case 1: We already have a basic component. Hence,
			// there are no more nested AssemblyContexts to add:
			return existingAssCtxs;

		} else if (rc instanceof ComposedStructure) {

			// Case 2: We have a composed structure. Hence, a
			// ProvidedDelegationConnector will lead us to a
			// nested AssemblyContext:
			ComposedStructure cs = (ComposedStructure) rc;
			for (Connector conn : cs.getConnectors__ComposedStructure()) {
				if (conn instanceof ProvidedDelegationConnector) {
					ProvidedDelegationConnector pdc = (ProvidedDelegationConnector) conn;
					if (pdc.getOuterProvidedRole_ProvidedDelegationConnector()
							.getId().equals(topLevelProvidedRole.getId())) {

						// We have found a ProvidedDelegationConnector that
						// delegates from a nested AssemblyContext to the
						// top-level ProvidedRole. Now, we recursively
						// continue with the nested AssemblyContext:
						AssemblyContext nestedAssCtx = pdc
								.getAssemblyContext_ProvidedDelegationConnector();
						OperationProvidedRole nestedProvidedRole = pdc
								.getInnerProvidedRole_ProvidedDelegationConnector();
						return getAssCtxs(nestedAssCtx, nestedProvidedRole,
								existingAssCtxs);
					}
				}
			}

			// Error handling in case no matching ProvidedDelegationConnector
			// has been found:
			throw new IllegalArgumentException(
					"No ProvidedDelegationConnector found in ComposedStructure \""
							+ cs.getEntityName()
							+ "\" that matches the OperationProvidedRole \""
							+ topLevelProvidedRole.getEntityName() + "\".");
		}

		// Error handling in case an unknown component type is encountered:
		throw new IllegalArgumentException("Unknown component type \""
				+ rc.eClass().getName()
				+ "\" encapsulated by AssemblyContext \""
				+ topLevelAssCtx.getEntityName() + "\"");
	}

	/**
	 * Retrieves the list of nested handling AssemblyContexts for the given
	 * EntryLevelSystemCall.
	 * 
	 * A handling AssemblyContext is one that includes the executing behavior
	 * triggered by the call.
	 * 
	 * @param systemCall
	 *            the EntryLevelSystemCall
	 * @param system
	 *            the involved System instance
	 * @return the list of nested handlingAssemblyContexts.
	 */
	public static List<AssemblyContext> getHandlingAssemblyContexts(
			final EntryLevelSystemCall systemCall, final System system) {

		// Find the top-level assembly context and
		// providing role for the call:
		AssemblyContext topLevelAssCtx = null;
		OperationProvidedRole topLevelAssCtxProvidedRole = null;
		for (Connector conn : system.getConnectors__ComposedStructure()) {
			if (conn instanceof ProvidedDelegationConnector) {
				ProvidedDelegationConnector pdc = (ProvidedDelegationConnector) conn;
				if (pdc.getOuterProvidedRole_ProvidedDelegationConnector()
						.getId().equals(
								systemCall
										.getProvidedRole_EntryLevelSystemCall()
										.getId())) {
					topLevelAssCtx = pdc
							.getAssemblyContext_ProvidedDelegationConnector();
					topLevelAssCtxProvidedRole = pdc
							.getInnerProvidedRole_ProvidedDelegationConnector();
				}
			}
		}

		if (topLevelAssCtx != null) {
			return getAssCtxs(topLevelAssCtx, topLevelAssCtxProvidedRole,
					new BasicEList<AssemblyContext>());
		}

		// No matching ProvidedDelegationConnector found:
		throw new IllegalArgumentException(
				"No ProvidedDelegationConnector found in system \""
						+ system.getEntityName()
						+ "\" that matches the EntryLevelSystemCall \""
						+ systemCall.getEntityName() + "\".");
	}
}
