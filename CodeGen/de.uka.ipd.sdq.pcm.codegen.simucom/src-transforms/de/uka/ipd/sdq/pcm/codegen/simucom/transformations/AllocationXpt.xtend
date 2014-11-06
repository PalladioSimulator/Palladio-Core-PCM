package de.uka.ipd.sdq.pcm.codegen.simucom.transformations

import de.uka.ipd.sdq.pcm.allocation.Allocation

abstract class AllocationXpt {
	def String allocationTM(Allocation allocation)
}