package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.allocation.Allocation
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.allocation.Allocation"
])
abstract class AllocationXpt {
	def String allocationTM(Allocation allocation)
}