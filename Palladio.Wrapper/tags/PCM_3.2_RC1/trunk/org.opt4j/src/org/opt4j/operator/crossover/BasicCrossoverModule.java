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

package org.opt4j.operator.crossover;

import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Required;
import org.opt4j.operator.crossover.CrossoverDoubleSBX.Nu;
import org.opt4j.start.Constant;

/**
 * The basic {@code CrossoverModule}.
 * 
 * @author lukasiewycz
 * 
 */
@Info("Setting for the basic crossover operators for genotype variation.")
public class BasicCrossoverModule extends CrossoverModule {

	@Info("The type of the crossover operator for the Boolean genotype.")
	protected BooleanType booleanType = BooleanType.RATE;

	@Required(property = "booleanType", elements = { "RATE" })
	@Info("The probability for a crossover point.")
	@Constant(value = "rate", namespace = CrossoverBooleanRate.class)
	protected double booleanRate = 0.5;

	@Required(property = "booleanType", elements = { "XPOINT" })
	@Info("The number of crossover points.")
	@Constant(value = "x", namespace = CrossoverBooleanXPoint.class)
	protected int booleanXPoints = 1;

	@Info("The type of the crossover operator for the Double genotype.")
	protected DoubleType doubleType = DoubleType.SBX;

	@Required(property = "doubleType", elements = { "BLX", "UNFAIR_AVERAGE" })
	protected double alpha = 0.5;

	@Required(property = "doubleType", elements = { "SBX" })
	@Constant(value = "nu", namespace = CrossoverDoubleSBX.class)
	protected double nu = 15;

	@Info("The type of the crossover operator for the Permutation genotype.")
	protected PermutationType permutationType = PermutationType.ONEPOINT;

	@Required(property = "permutationType", elements = { "ONEPOINT" })
	@Constant(value = "rotation", namespace = CrossoverPermutationOnePoint.class)
	protected boolean rotation = false;

	@Info("The type of the crossover operator for the Integer genotype.")
	protected IntegerType integerType = IntegerType.RATE;

	@Required(property = "integerType", elements = { "RATE" })
	@Info("The probability for a crossover point.")
	@Constant(value = "rate", namespace = CrossoverIntegerRate.class)
	protected double integerRate = 0.5;

	@Required(property = "integerType", elements = { "XPOINT" })
	@Info("The number of crossover points.")
	@Constant(value = "x", namespace = CrossoverIntegerXPoint.class)
	protected int integerXPoints = 1;

	/**
	 * Type of {@code Crossover} operator for the {@code BooleanGenotype}.
	 * 
	 * @author lukasiewycz
	 */
	public enum BooleanType {
		/**
		 * Use the {@link CrossoverBooleanRate}.
		 */
		RATE,
		/**
		 * Use the {@link CrossoverBooleanXPoint}.
		 */
		XPOINT;
	}

	/**
	 * Type of {@code Crossover} operator for the {@code DoubleGenotype}.
	 * 
	 * @author glass
	 */
	public enum DoubleType {
		/**
		 * Use the {@link CrossoverDoubleBLX}.
		 */
		BLX,
		/**
		 * Use the {@link CrossoverDoubleSBX}.
		 */
		SBX,
		/**
		 * Use the {@link CrossoverDoubleUnfairAverage}.
		 */
		UNFAIR_AVERAGE;
	}

	/**
	 * Type of {@code Crossover} operator for the {@code PermutationGenotype}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum PermutationType {
		/**
		 * Use the {@link CrossoverPermutationOnePoint}.
		 */
		ONEPOINT,
		/**
		 * Use the {@link CrossoverPermutationBucket}.
		 */
		BUCKET;
	}

	/**
	 * Type of {@code Crossover} operator for the {@code IntegerGenotype}.
	 * 
	 * @author lukasiewycz
	 */
	public enum IntegerType {
		/**
		 * Use the {@link CrossoverBooleanRate}.
		 */
		RATE,
		/**
		 * Use the {@link CrossoverBooleanXPoint}.
		 */
		XPOINT;
	}

	/**
	 * Constructs a {@code BasicCrossoverModule}.
	 */
	public BasicCrossoverModule() {
		super();
	}

	/**
	 * Returns the rate of the {@code IntegerRate}.
	 * 
	 * @return the rate
	 */
	public double getIntegerRate() {
		return integerRate;
	}

	/**
	 * Sets the rate of the {@code IntegerCrossoverRate}.
	 * 
	 * @param integerRate
	 *            the rate
	 */
	public void setIntegerRate(double integerRate) {
		this.integerRate = integerRate;
	}

	/**
	 * Returns the number of crossover points of the {@code
	 * IntegerCrossoverXPoint}.
	 * 
	 * @return the number of crossover points
	 */
	public int getIntegerXPoints() {
		return integerXPoints;
	}

	/**
	 * Sets the number of crossover points of the {@code IntegerCrossoverXPoint}
	 * .
	 * 
	 * @param integerXPoint
	 *            the number of crossover points
	 */
	public void setIntegerXPoints(int integerXPoint) {
		this.integerXPoints = integerXPoint;
	}

	/**
	 * Return the {@code Operator} for {@code IntegerGenotype}.
	 * 
	 * @return the operator
	 */
	public IntegerType getIntegerType() {
		return integerType;
	}

	/**
	 * Sets the {@code Operator} for {@code IntegerGenotype}.
	 * 
	 * @param integerType
	 *            the operator
	 */
	public void setIntegerType(IntegerType integerType) {
		this.integerType = integerType;
	}

	/**
	 * Returns the rate of the {@code BooleanRate}.
	 * 
	 * @return the rate
	 */
	public double getBooleanRate() {
		return booleanRate;
	}

	/**
	 * Sets the rate of the {@code BooleanCrossoverRate}.
	 * 
	 * @param booleanRate
	 *            the rate
	 */
	public void setBooleanRate(double booleanRate) {
		this.booleanRate = booleanRate;
	}

	/**
	 * Returns the number of crossover points of the {@code
	 * BooleanCrossoverXPoint}.
	 * 
	 * @return the number of crossover points
	 */
	public int getBooleanXPoints() {
		return booleanXPoints;
	}

	/**
	 * Sets the number of crossover points of the {@code BooleanCrossoverXPoint}
	 * .
	 * 
	 * @param booleanXPoints
	 *            the number of crossover points
	 */
	public void setBooleanXPoints(int booleanXPoints) {
		this.booleanXPoints = booleanXPoints;
	}

	/**
	 * Return the {@code Operator} for {@code BooleanGenotype}.
	 * 
	 * @return the operator
	 */
	public BooleanType getBooleanType() {
		return booleanType;
	}

	/**
	 * Sets the {@code Operator} for {@code BooleanGenotype}.
	 * 
	 * @param booleanType
	 *            the operator
	 */
	public void setBooleanType(BooleanType booleanType) {
		this.booleanType = booleanType;
	}

	/**
	 * Returns the alpha value of the {@code CrossoverDoubleBLX} or {@code
	 * CrossoverDoubleUnfairAverage}, respectively.
	 * 
	 * @return the alpha value
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * Sets the alpha value of the {@code CrossoverDoubleBLX} or {@code
	 * CrossoverDoubleUnfairAverage}, respectively.
	 * 
	 * @param alpha
	 *            the alpha value
	 */
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	/**
	 * Returns the nu value of the {@code CrossoverDoubleSBX}.
	 * 
	 * @return the nu value
	 */
	public double getNu() {
		return nu;
	}

	/**
	 * Sets the nu value of the {@code CrossoverDoubleSBX}.
	 * 
	 * @param nu
	 *            the nu value
	 */
	public void setNu(double nu) {
		this.nu = nu;
	}

	/**
	 * Return the {@code Operator} for {@code DoubleGenotype}.
	 * 
	 * @return the operator
	 */
	public DoubleType getDoubleType() {
		return doubleType;
	}

	/**
	 * Sets the {@code Operator} for {@code DoubleGenotype}.
	 * 
	 * @param doubleType
	 *            the operator
	 */
	public void setDoubleType(DoubleType doubleType) {
		this.doubleType = doubleType;
	}

	/**
	 * Returns the {@code PermutationType}.
	 * 
	 * @return the permutation type
	 */
	public PermutationType getPermutationType() {
		return permutationType;
	}

	/**
	 * Sets the {@code PermutationType}.
	 * 
	 * @param permutationType
	 *            the permutation type
	 */
	public void setPermutationType(PermutationType permutationType) {
		this.permutationType = permutationType;
	}

	/**
	 * Returns {@code true} if rotation is used for the {@code Crossover}
	 * operator for the {@code PermutationGenotype}.
	 * 
	 * @return {@code true} if rotation is used
	 */
	public boolean isRotation() {
		return rotation;
	}

	/**
	 * Sets the rotation value for the {@code Crossover} operator for the
	 * {@code PermutationGenotype}.
	 * 
	 * @param rotation
	 *            the rotation value
	 */
	public void setRotation(boolean rotation) {
		this.rotation = rotation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		switch (booleanType) {
		case XPOINT:
			bind(CrossoverBoolean.class).to(CrossoverBooleanXPoint.class).in(
					SINGLETON);
			break;
		default: // RATE
			bind(CrossoverBoolean.class).to(CrossoverBooleanRate.class).in(
					SINGLETON);
			break;
		}

		switch (integerType) {
		case XPOINT:
			bind(CrossoverInteger.class).to(CrossoverIntegerXPoint.class).in(
					SINGLETON);
			break;
		default: // RATE
			bind(CrossoverInteger.class).to(CrossoverIntegerRate.class).in(
					SINGLETON);
			break;
		}

		switch (doubleType) {
		case BLX:
			bind(CrossoverDouble.class).to(CrossoverDoubleBLX.class).in(
					SINGLETON);
			break;
		case UNFAIR_AVERAGE:
			bind(CrossoverDouble.class).to(CrossoverDoubleUnfairAverage.class)
					.in(SINGLETON);

			break;
		default: // SBX
			bind(CrossoverDouble.class).to(CrossoverDoubleSBX.class).in(
					SINGLETON);
			break;
		}

		switch (permutationType) {
		case BUCKET:
			bind(CrossoverPermutation.class).to(
					CrossoverPermutationBucket.class).in(SINGLETON);
			break;
		default: // ONEPOINT
			bind(CrossoverPermutation.class).to(
					CrossoverPermutationOnePoint.class).in(SINGLETON);
			break;
		}

		bindConstant("alpha", CrossoverDoubleBLX.class).to(alpha);
		bindConstant("alpha", CrossoverDoubleUnfairAverage.class).to(alpha);
		bindConstant(Nu.class).to(nu);

	}

}
