package com.palladio_simulator.protocom.traverse.framework.repository

import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import com.palladio_simulator.protocom.traverse.framework.PcmRepresentative

/**
 * Leaf for Composite Components.
 * 
 * Meant to be inherited by a specific transformation if this PCM entity should
 * result in generated files.
 * 
 * @author Thomas Zolynski
 */
class XCompositeComponent extends PcmRepresentative<CompositeComponent> {
	
}