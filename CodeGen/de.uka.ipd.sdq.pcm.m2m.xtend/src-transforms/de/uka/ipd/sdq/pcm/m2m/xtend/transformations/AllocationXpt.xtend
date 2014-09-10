package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.allocation.Allocation
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn
import edu.kit.ipd.sdq.xtend2m.annotations.Strict
import edu.kit.ipd.sdq.xtend2m.annotations.TransformationInterface

//@TransformationInterface
//@ModelIn(#[
//	"pcm.allocation.*",
//	"pcm.core.composition.AssemblyContext",
//	"pcm.repository.CompositeComponent",
//	"pcm.subsystem.SubSystem",
//	"pcm.system.System"
//])
//@Strict
abstract class AllocationXpt {
	def String allocationTM(Allocation allocation)
}