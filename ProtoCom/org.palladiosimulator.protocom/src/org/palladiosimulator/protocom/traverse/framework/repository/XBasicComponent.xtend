package com.palladio_simulator.protocom.traverse.framework.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import com.palladio_simulator.protocom.traverse.framework.PcmRepresentative

/**
 * Leaf for Basic Components.
 * 
 * MAYBE TODO? This class could also traverse through the ports.
 * 
 * Meant to be inherited by a specific transformation if this PCM entity should
 * result in generated files.
 * 
 * @author Thomas Zolynski
 */
class XBasicComponent extends PcmRepresentative<BasicComponent> {
	
}