package org.palladiosimulator.protocom.traverse.framework

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.palladiosimulator.protocom.lang.GeneratedFile
import org.palladiosimulator.protocom.lang.ICompilationUnit
import de.uka.ipd.sdq.pcm.core.entity.NamedElement

/**
 * Abstract class representing a generic PCM model entity. Includes methods to
 * further traverse the underlying PCM model. 
 * 
 * Note that the generic type E extends NamedElement and not Entity. Due to some
 * (to me unknown) reasons an Allocation is a sub type of Entity, but a 
 * ResourceEnvironment is not.
 * 
 * @author Thomas Zolynski
 */
abstract class PcmRepresentative<E extends NamedElement> {

	@Inject
	protected Injector injector

	/**
	 * Lift of all files to be generated.
	 */
	protected List<GeneratedFile<? extends ICompilationUnit>> generatedFiles = newLinkedList

	/**
	 * The represented element of the loaded PCM model.
	 */
	protected E entity

	/**
	 * Set the entity which will be represented by this object.
	 */
	def PcmRepresentative<E> setEntity(E entity) {
		this.entity = entity
		this
	}

	/**
	 * Transformation process:
	 * <ul>
	 * 	<li>Traverse through all relevant entities connected to this entity.
	 *  <li>Generate files necessary for this entity, depending on the language and technology used.
	 * 	<li>Store generated files.
	 * </ul>
	 * Traverse and Generate are template methods.
	 */
	def void transform() {
		traverse
		generate
		store
	}

	/**
	 * Traverse through the PCM model, following all relevant connections starting
	 * from the represented element. Nothing is traversed in the default case.
	 */
	protected def void traverse() {
	}

	/**
	 * Generate the files needed for this entity. Nothing is generated in the
	 * default case.
	 */
	protected def void generate() {
	}

	/**
	 * Store created files.
	 */
	private def void store() {
		generatedFiles.forEach[it.store]
	}

}
