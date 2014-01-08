package com.palladio_simulator.protocom.traverse.framework.repository;

import com.palladio_simulator.protocom.traverse.framework.PcmRepresentative;
import de.uka.ipd.sdq.pcm.repository.EventGroup;

/**
 * Leaf for Event Groups.
 * 
 * Meant to be inherited by a specific transformation if this PCM entity should
 * result in generated files.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class XEventGroup extends PcmRepresentative<EventGroup> {
}
