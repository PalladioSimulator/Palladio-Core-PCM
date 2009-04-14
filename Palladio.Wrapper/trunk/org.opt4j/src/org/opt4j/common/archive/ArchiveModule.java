/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.common.archive;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Required;
import org.opt4j.core.Archive;
import org.opt4j.start.Constant;
import org.opt4j.start.Opt4JModule;

/**
 * The {@code ArchiveModule} determines an implementation for the {@code
 * Archive} interface.
 * 
 * @author helwig, lukasiewycz
 * @see Archive
 * 
 */
@Icon(Icons.PUZZLE_BLUE)
@Info("The archive of non-dominated solutions found throughout optimization.")
public class ArchiveModule extends Opt4JModule {

	@Info("Archive type")
	protected Type type = Type.CROWDING;

	@Info("Maximal archive capacity if a bounded archive is selected")
	@Required(property = "type", elements = { "ADAPTIVE_GRID", "CROWDING" })
	@Constant(value = "capapcity", namespace = BoundedArchive.class)
	protected int capacity = 100;

	/** Archive type */
	public enum Type {
		@Info("Archive of unlimited size")
		UNBOUNDED, @Info("Archive that keeps the non-dominated individual of the population")
		POPULATION, @Info("Adaptive grid archive")
		ADAPTIVE_GRID, @Info("Bounded archive based on the NSGA2 crowding distance")
		CROWDING,
		BASIC;
	}

	/**
	 * Sets the archive type to the specified value
	 * 
	 * @param type
	 *            the new archive type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Returns the archive type
	 * 
	 * @return the archive type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the archive's capacity to the specified value
	 * 
	 * @param capacity
	 *            the new capacity (using namespace {@code BoundedArchive})
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Returns the archive's capacity
	 * 
	 * @return the archive's capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		Class<? extends Archive> archiveClass = null;

		switch (type) {
		case ADAPTIVE_GRID:
			archiveClass = AdaptiveGridArchive.class;
			break;
		case POPULATION:
			archiveClass = PopulationArchive.class;
			break;
		case CROWDING:
			archiveClass = CrowdingArchive.class;
			break;
		case BASIC:
			archiveClass = BasicArchive.class;
			break;
		default: // UNBOUNDED
			archiveClass = UnboundedArchive.class;
			break;
		}

		bind(Archive.class).to(archiveClass).in(SINGLETON);
	}
}
