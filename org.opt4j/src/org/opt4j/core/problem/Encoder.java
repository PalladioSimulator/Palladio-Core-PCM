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

package org.opt4j.core.problem;

import org.opt4j.core.Genotype;
import org.opt4j.core.Phenotype;

/**
 * The interface for {@code Decoders} that are able to obtain a {@code Genotype}
 * for a given {@code Phenotype}.
 * 
 * @author glass
 * @deprecated inject a custom individualBuilder instead
 * 
 */
@Deprecated
public interface Encoder {

	/**
	 * Encodes a {@code Phenotype} into a {@code Genotype}. Note that the used
	 * {@code Decoder} should return the given {@code Phenotype} when decoding
	 * the returned {@code Genotype}.
	 * 
	 * @param phenotype
	 *            the phenotype to encode
	 * @return the encoded genotype
	 */
	public Genotype encode(Phenotype phenotype);

}
