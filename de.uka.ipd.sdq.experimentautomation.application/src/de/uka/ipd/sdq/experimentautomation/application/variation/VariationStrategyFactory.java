package de.uka.ipd.sdq.experimentautomation.application.variation;

import de.uka.ipd.sdq.experimentautomation.variation.VariationType;


public class VariationStrategyFactory {

    public static IVariationStrategy createStrategy(VariationType type) {
        assert type != null : "The variation type may not be null";
        String className = type.getStrategyClass();

        Object o = null;
        try {
            o = Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (!IVariationStrategy.class.isInstance(o)) {
            throw new RuntimeException("Expected a class implementing " + IVariationStrategy.class.getName());
        }

        return (IVariationStrategy) o;
    }

}
