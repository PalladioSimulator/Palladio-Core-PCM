package org.palladiosimulator.pcm.stoex.api.impl;

import java.io.NotSerializableException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.stoex.api.impl.generic.GenericStoExSerialiserImpl;
import org.palladiosimulator.pcm.parameter.CharacterisedVariable;
import org.palladiosimulator.pcm.parameter.ParameterFactory;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;

/**
 * Wrapper for an serialize for StoEx expressions.
 */
public class StoExSerialiserImpl extends GenericStoExSerialiserImpl implements StoExSerialiser {

    /**
     * Constructs new serialiser instance.
     */
    public StoExSerialiserImpl() {
        super(new XtextStoExSerialiserProvider());
    }

    @Override
    public String serialise(AbstractNamedReference reference) throws NotSerializableException {
        CharacterisedVariable wrapper = ParameterFactory.eINSTANCE.createCharacterisedVariable();
        AbstractNamedReference referenceCopy = EcoreUtil.copy(reference);
        wrapper.setId_Variable(referenceCopy);
        String suffixRemovalRegex = String.format("\\.\\s*%s\\s*$", wrapper.getCharacterisationType()
            .getLiteral());
        String result = serialiseWithoutTypeCheck(wrapper);
        return result.replaceFirst(suffixRemovalRegex, "");
    }

}
