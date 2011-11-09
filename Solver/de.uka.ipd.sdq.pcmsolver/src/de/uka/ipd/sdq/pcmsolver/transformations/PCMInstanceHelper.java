package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
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
	public static List<AssemblyContext> getHandlingAssemblyContexts(
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
						return getHandlingAssemblyContexts(nestedAssCtx,
								nestedProvidedRole, existingAssCtxs);
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
			return getHandlingAssemblyContexts(topLevelAssCtx,
					topLevelAssCtxProvidedRole,
					new BasicEList<AssemblyContext>());
		}

		// No matching ProvidedDelegationConnector found:
		throw new IllegalArgumentException(
				"No ProvidedDelegationConnector found in system \""
						+ system.getEntityName()
						+ "\" that matches the EntryLevelSystemCall \""
						+ systemCall.getEntityName() + "\".");
	}

	/**
	 * Searches for an AssemblyConnector that connects a given
	 * requiringAssemblyContext via its requiredRole to its providing
	 * counterpart.
	 * 
	 * Notice that the requiredRole of the requiringAssemblyContext could also
	 * be associated to a RequiredDelegationConnector instead of an
	 * AssemblyConnector. In this case, NULL is returned.
	 * 
	 * @param requiredRoleId
	 *            the id of the RequiredRole to match
	 * @param requiredInterfaceId
	 *            the id of the Interface to match
	 * @param requiringAssemblyContext
	 *            the AssemblyContext to match
	 * @return the matching AssemblyConnector within the parent
	 *         ComposedStructure
	 */
	public static AssemblyConnector findAssemblyConnectorForRequiringAssemblyContext(
			final String requiredRoleId, final String requiredInterfaceId,
			final AssemblyContext requiringAssemblyContext) {

		// Retrieve the list of connectors within the parent
		// ComposedStructure:
		EList<Connector> connList = requiringAssemblyContext
				.getParentStructure__AssemblyContext()
				.getConnectors__ComposedStructure();

		// Check for each AssemblyConnector in the list if it fulfills
		// the requirements:
		for (Connector conn : connList) {
			if (conn instanceof AssemblyConnector) {
				AssemblyConnector assConn = (AssemblyConnector) conn;
				if (assConn.getRequiringAssemblyContext_AssemblyConnector()
						.getId().equals(requiringAssemblyContext.getId())
						&& assConn.getRequiredRole_AssemblyConnector()
								.getRequiredInterface__OperationRequiredRole()
								.getId().equals(requiredInterfaceId)
						&& assConn.getRequiredRole_AssemblyConnector().getId()
								.equals(requiredRoleId)) {
					return assConn;
				}
			}
		}

		// No AssmblyConnector found:
		return null;
	}

	public static RequiredDelegationConnector findDelegationConnectorForRequiringAssemblyContext(
			String requiredRoleId, String requiredInterfaceId,
			AssemblyContext requiringAssemblyContext) {

		// Retrieve the list of connectors within the parent
		// ComposedStructure:
		EList<Connector> connList = requiringAssemblyContext
				.getParentStructure__AssemblyContext()
				.getConnectors__ComposedStructure();

		// Check for each RequiredDelegationConnector in the list if it fulfills
		// the requirements:
		for (Connector conn : connList) {
			if (conn instanceof RequiredDelegationConnector) {
				RequiredDelegationConnector dc = (RequiredDelegationConnector) conn;
				if (dc.getAssemblyContext_RequiredDelegationConnector().getId()
						.equals(requiringAssemblyContext.getId())
						&& dc.getInnerRequiredRole_RequiredDelegationConnector()
								.getRequiredInterface__OperationRequiredRole()
								.getId().equals(requiredInterfaceId)
						&& dc.getInnerRequiredRole_RequiredDelegationConnector().getId()
								.equals(requiredRoleId)) {
					return dc;
				}
			}
		}

		// No AssmblyConnector found:
		return null;
	}
}
