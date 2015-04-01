package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;

@Deprecated
public class PCMStoExPrettyPrintVisitor {
    
    private class PCMStoExPrettyPrintVisitorInner extends StoExPrettyPrintVisitor {

        protected StringBuilder doSwitch(EClass theEClass, EObject theEObject) {
            if (theEClass == ParameterPackage.eINSTANCE.getCharacterisedVariable()) {
                return caseCharacterisedVariable((CharacterisedVariable) theEObject);
            } else if (theEClass == ParameterPackage.eINSTANCE.getVariableUsage()) {
                return caseVariableUsage((VariableUsage) theEObject);
            } else if (theEClass == ParameterPackage.eINSTANCE.getVariableCharacterisation()) {
                return caseVariableCharacterisation((VariableCharacterisation) theEObject);
            } else {
                return super.doSwitch(theEClass, theEObject);
            }
        }

        public StringBuilder caseCharacterisedVariable(CharacterisedVariable object) {
            StringBuilder result = doSwitch(object.getId_Variable());
            result.append("." + object.getCharacterisationType().getLiteral());
            return result;
        }

        public StringBuilder caseVariableUsage(VariableUsage object) {
            if (object.getNamedReference__VariableUsage() != null)
                doSwitch(object.getNamedReference__VariableUsage());
            else
                resultBuilder.append("<not set yet>");
            
            if (object.getVariableCharacterisation_VariableUsage().size() > 0) {
                resultBuilder.append(".");
                doSwitch((VariableCharacterisation) object.getVariableCharacterisation_VariableUsage().get(0));
            } else {
                resultBuilder.append(".<missing characterisation> = <missing expression>");
            }
            return resultBuilder;
        }

        public StringBuilder caseVariableCharacterisation(VariableCharacterisation object) {
            resultBuilder.append(object.getType().getLiteral());
            // result += " = " +
            // object.getSpecification_VariableCharacterisation().getSpecification();
            return resultBuilder;
        }
    }
    
    public String prettyPrint(EObject theObject) {
        return new PCMStoExPrettyPrintVisitorInner().doSwitch(theObject).toString();
    }
}
