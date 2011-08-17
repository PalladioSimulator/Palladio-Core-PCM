/**
 *
 */
package de.fzi.se.accuracy.example.PrioritizingMediaStore;

/**Creates example specifications for the PrioritizingMediaStore.
 * @author groenda
 */
public class CreateLimitedDeviationSpecs {
	/**Creates the quality specifications for the PrioritizingMediaStore. The resulting quality annotation repository is stored in the filesystem.
	 * @param args
	 */
	public static void main(String[] args) {
		de.fzi.se.accuracy.util.CreateLimitedDeviationSpecs.createQualitaAnnotationRepository("model/mediastore");
	}
}
