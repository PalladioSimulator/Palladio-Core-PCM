package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.palladiosimulator.pcm.parameter.CharacterisedVariable;

import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.visitors.ITypeInference;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * Extension for the StoEx Analyser (de.uka.ipd.sdq.stoex.analyser) to determine
 * the type of a variable based on its characterization type. The method of this
 * extension contains the variable characterization dependencies to the pcm
 * core. In order to move the StoEx Analyser to pcm commons, it was made
 * extensible via extension points and the functionality of the variable
 * characterizations was provided as this extension.
 *
 * @author Yves Schneider
 */
public class TypeInference implements ITypeInference {

    /**
     * Explicit standard constructor. If you create your class directly using the
     * class IConfigurationElement of the extension, you are limited to classes that
     * have a default constructor.
     */
    public TypeInference() {
        super();
    }

    @Override
    public TypeEnum getType(final Variable var) {
        if ((var != null) && (var instanceof CharacterisedVariable)) {
            switch (((CharacterisedVariable) var).getCharacterisationType()) {
                case VALUE:
                case TYPE:
                case STRUCTURE:
                    return TypeEnum.ANY_PMF; // Inferred to ANY_PMF
                case NUMBER_OF_ELEMENTS:
                case BYTESIZE:
                    return TypeEnum.INT_PMF; // Inferred to ENUM_PMF
            }
        }
        return null;

    }

}
