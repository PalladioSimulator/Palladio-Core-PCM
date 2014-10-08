package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.allocation.Allocation
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn
import edu.kit.ipd.sdq.xtend2m.annotations.Strict
import edu.kit.ipd.sdq.xtend2m.annotations.TransformationInterface

@TransformationInterface
@ModelIn(#[
	"de.uka.ipd.sdq.pcm.allocation.*",
	"de.uka.ipd.sdq.pcm.resourceenvironment.*",
	"de.uka.ipd.sdq.pcm.core.composition.*",
	"de.uka.ipd.sdq.pcm.repository.*",
	"de.uka.ipd.sdq.pcm.subsystem.SubSystem",
	"de.uka.ipd.sdq.pcm.system.System",
	"de.uka.ipd.sdq.identifier.Identifier"
])
@Strict
interface AllocationXpt {
	def String allocationTM(Allocation allocation)
}