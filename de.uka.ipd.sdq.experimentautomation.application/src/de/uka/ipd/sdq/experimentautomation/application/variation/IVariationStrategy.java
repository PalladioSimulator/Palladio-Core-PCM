package de.uka.ipd.sdq.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

public interface IVariationStrategy {

    public void setVariedObject(EObject o);

    /**
     * 
     * @param value
     * @return a textual description of the variation
     */
    public String vary(long value);

}
