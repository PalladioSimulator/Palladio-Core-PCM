package com.palladio_simulator.protocom.traverse.framework.repository

import de.uka.ipd.sdq.pcm.repository.Repository
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import de.uka.ipd.sdq.pcm.repository.EventGroup
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.core.entity.Entity
import com.palladio_simulator.protocom.traverse.framework.PcmRepresentative

/**
 * Traversing Repository. Child elements are:
 * <ul>
 * 	<li>Basic Component,
 * 	<li>Composite Component,
 * 	<li>Infrastructure Interface,
 * 	<li>Operation Interface,
 * 	<li>Event Groups.
 * </ul>
 */
class XRepository extends PcmRepresentative<Repository> {

	override traverse() {
		entity.interfaces__Repository.forEach[
			createInterface(it)
		]

		entity.components__Repository.forEach[
			createComponent(it)
		]
	}

	/**
	 * Traverse through Composite Components.
	 */
	def dispatch createComponent(CompositeComponent componentEntity) {
		injector.getInstance(typeof(XCompositeComponent)).setEntity(componentEntity).transform
	}

	/**
	 * Traverse through Basic Components.
	 */
	def dispatch createComponent(BasicComponent componentEntity) {
		injector.getInstance(typeof(XBasicComponent)).setEntity(componentEntity).transform
	}

	/**
	 * Fallback for component traversing.
	 */
	def dispatch createComponent(Entity componentEntity) {
		// Default fallback. These are usually not necessary when using dispatch. However, if
		// you want to use dispatch through more than one level in a class hierarchy, you
		// still need to catch it manually.
		throw new UnsupportedOperationException("Unsupported component type.")
	}


	/**
	 * Traverse through Infrastructure Interfaces.
	 */
	def dispatch createInterface(InfrastructureInterface interfaceEntity) {
		injector.getInstance(typeof(XInfrastructureInterface)).setEntity(interfaceEntity).transform
	}

	/**
	 * Traverse through Operation Interfaces.
	 */
	def dispatch createInterface(OperationInterface interfaceEntity) {
		injector.getInstance(typeof(XOperationInterface)).setEntity(interfaceEntity).transform
	}
	
	/**
	 * Traverse through Event Groups.
	 */
	def dispatch createInterface(EventGroup interfaceEntity) {
		injector.getInstance(typeof(XEventGroup)).setEntity(interfaceEntity).transform
	}
}
