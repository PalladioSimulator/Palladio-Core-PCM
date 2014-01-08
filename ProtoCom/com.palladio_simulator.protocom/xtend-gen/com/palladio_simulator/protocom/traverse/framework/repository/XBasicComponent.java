package com.palladio_simulator.protocom.traverse.framework.repository;

import com.palladio_simulator.protocom.traverse.framework.PcmRepresentative;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;

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
@SuppressWarnings("all")
public class XBasicComponent extends PcmRepresentative<BasicComponent> {
}
