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

package org.opt4j.operator.diversity;

import org.opt4j.config.annotations.Ignore;
import org.opt4j.config.annotations.Info;
import org.opt4j.start.Opt4JModule;

/**
 * The {@code BasicDiversityModule} is the basic {@code PropertyModule} for the
 * {@code Diversity} operator.
 * 
 * @author glass
 * 
 */
@Info("Setting for the basic diversity operators for genotypes.")
public class BasicDiversityModule extends Opt4JModule implements
		DiversityModule {

	@Ignore
	@Info("The type of the diversity operator for the Boolean genotype")
	BooleanType booleanType = BooleanType.FRACTION;

	@Info("The type of the diversity operator for the Double genotype")
	DoubleType doubleType = DoubleType.ABSOLUTE;

	/**
	 * Type of {@code Diversity} operator for the {@code BooleanGenotype}.
	 * 
	 * @author glass
	 */
	public enum BooleanType {
		/**
		 * Use the {@link DiversityBooleanFraction} operator.
		 */
		FRACTION;
	}

	/**
	 * Type of {@code Diversity} operator for the {@code DoubleGenotype}.
	 * 
	 * @author glass
	 */
	public enum DoubleType {
		/**
		 * Use the {@link DiversityDoubleAbsolute} operator.
		 */
		ABSOLUTE,
		/**
		 * Use the {@link DiversityDoubleEuclidean} operator.
		 */
		EUCLIDEAN;
	}

	/**
	 * Constructs a {@code BasicDiversityModule}.
	 * 
	 */
	public BasicDiversityModule() {
		super();
	}

	/**
	 * Returns the Type of {@code Diversity} operator for {@code
	 * BooleanGenotype}.
	 * 
	 * @return the type of diversity operator for boolean genotypes
	 */
	public BooleanType getBooleanType() {
		return booleanType;
	}

	/**
	 * Sets the Type of {@code Diversity} operator for {@code BooleanGenotype}.
	 * 
	 * @param booleanType
	 *            the booleanType to set
	 */
	public void setBooleanType(BooleanType booleanType) {
		this.booleanType = booleanType;
	}

	/**
	 * Returns the Type of {@code Diversity} operator for {@code DoubleGenotype}
	 * .
	 * 
	 * @return the type of diversity operator for double genotypes
	 */
	public DoubleType getDoubleType() {
		return doubleType;
	}

	/**
	 * Sets the the Type of {@code Diversity} operator for {@code
	 * DoubleGenotype}.
	 * 
	 * @param doubleType
	 *            the doubleType to set
	 */
	public void setDoubleType(DoubleType doubleType) {
		this.doubleType = doubleType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		switch (booleanType) {
		case FRACTION:
			bind(DiversityBoolean.class).to(DiversityBooleanFraction.class).in(
					SINGLETON);
			break;
		}

		switch (doubleType) {
		case ABSOLUTE:
			bind(DiversityDouble.class).to(DiversityDoubleAbsolute.class).in(
					SINGLETON);
			break;
		case EUCLIDEAN:
			bind(DiversityDouble.class).to(DiversityDoubleEuclidean.class).in(
					SINGLETON);
			break;
		}
	}
}
