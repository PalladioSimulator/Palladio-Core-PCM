package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcmsolver.Pair;

/**
 * Stores triples of {@link ExternalCallAction}, {@link AllocationContext}, and
 * {@link CommunicationLinkResourceSpecification} to retrieve the linking
 * resource used if the call is issued to the allocation context. So to say,
 * realizes something like a Map<ExternalCallAction,Map<AllocationContext,
 * CommunicationLinkResourceSpecification>>. But does not use only maps
 * internally because not so many elements are expected.
 * 
 * @author martens
 * 
 */
class CallsToLinkResourcesMap {

	/**
	 * 
	 */
	Map<ExternalCallAction, List<Pair<AllocationContext, CommunicationLinkResourceSpecification>>> internalMap = new HashMap<ExternalCallAction, List<Pair<AllocationContext, CommunicationLinkResourceSpecification>>>();

	/**
	 * 
	 * @param eca
	 * @param allCtx
	 * @return
	 */
	public CommunicationLinkResourceSpecification get(ExternalCallAction eca,
			AllocationContext allCtx) {
		List<Pair<AllocationContext, CommunicationLinkResourceSpecification>> listForEca = internalMap
				.get(eca);
		if (listForEca == null) {
			return null;
		}
		for (Pair<AllocationContext, CommunicationLinkResourceSpecification> pair : listForEca) {
			if (pair.getFirst().getId().equals(allCtx.getId())) {
				return pair.getSecond();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param eca
	 * @param nextAllCtx
	 * @param clrs
	 */
	public void put(ExternalCallAction eca, AllocationContext nextAllCtx,
			CommunicationLinkResourceSpecification clrs) {
		Pair<AllocationContext, CommunicationLinkResourceSpecification> pair = new Pair<AllocationContext, CommunicationLinkResourceSpecification>(
				nextAllCtx, clrs);
		List<Pair<AllocationContext, CommunicationLinkResourceSpecification>> listForEca = internalMap
				.get(eca);
		if (listForEca == null) {
			listForEca = new ArrayList<Pair<AllocationContext, CommunicationLinkResourceSpecification>>();
			internalMap.put(eca, listForEca);
		}
		listForEca.add(pair);

	}
}