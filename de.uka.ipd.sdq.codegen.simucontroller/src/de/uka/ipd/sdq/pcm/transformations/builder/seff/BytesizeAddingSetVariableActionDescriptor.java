package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;

/**
 * Adjust a single variable usage by adding the bytesize characterisations of the current signature
 * The bytesize information is added to the first bytesize variable characterisation of the passed
 * VariableUsage.
 * 
 * @author martens
 *
 */
public class BytesizeAddingSetVariableActionDescriptor extends SetVariableActionDescriptor implements
        ISignatureDependentAction {

    private OperationSignature currentSignature;

    private Modifier modifier;

    private VariableUsage variableUsage;

    // public BytesizeAddingSetVariableActionDescriptor(String variableName,
    // VariableCharacterisationType varCharacterisation, String specification,
    // Modifier modifier) {
    // // not nice here, but I cannot create the variable usage yet
    // super(ParameterFactory.eINSTANCE.createVariableUsage());
    //
    // this.variableName = variableName;
    // this.variableCharacterisation = varCharacterisation;
    // this.specification = specification;
    // this.modifier = modifier;
    // }

    public BytesizeAddingSetVariableActionDescriptor(VariableUsage variableUsage, Modifier modifier) {
        super(variableUsage);
        this.variableUsage = variableUsage;
        this.modifier = modifier;
    }

    public void setCurrentSignature(OperationSignature sig) {
        this.currentSignature = sig;

    }

    @Override
    protected Collection<? extends VariableUsage> getVariableUsages() {
        return getSignatureDependentVariableUsages(this.currentSignature);
    }

    protected Collection<? extends VariableUsage> getSignatureDependentVariableUsages(
            OperationSignature currentSignature) {
        String byteSizeString = getBytesizeString(this.currentSignature, this.modifier);

        VariableCharacterisation bytesizeCharacterisation = null;
        for (VariableCharacterisation vc : this.variableUsage.getVariableCharacterisation_VariableUsage()) {
            if (vc.getType().equals(VariableCharacterisationType.BYTESIZE)) {
                bytesizeCharacterisation = vc;
                break;
            }
        }
        if (bytesizeCharacterisation != null) {
            String oldSpec = bytesizeCharacterisation.getSpecification_VariableCharacterisation().getSpecification();
            bytesizeCharacterisation.getSpecification_VariableCharacterisation().setSpecification(
                    "(" + oldSpec + ") + " + byteSizeString);
        }
        List<VariableUsage> result = new ArrayList<VariableUsage>(1);
        result.add(this.variableUsage);
        return result;

    }

    private String getBytesizeString(OperationSignature currentSignature, Modifier modifier) {
        String specification = BytesizeComputationForSignature.getBytesizeForSignature(currentSignature, modifier);
        return specification;
    }

}
