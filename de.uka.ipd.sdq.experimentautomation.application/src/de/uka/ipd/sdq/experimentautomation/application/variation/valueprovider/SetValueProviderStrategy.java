package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider;

public class SetValueProviderStrategy implements IValueProviderStrategy {

    private SetValueProvider specification;
    private List<Double> values;

    public SetValueProviderStrategy(SetValueProvider specification) {
        this.specification = specification;
        this.values = parseValueString(this.specification.getValues());
    }

    @Override
    public long valueAtPosition(int position) {
        if (position > values.size() - 1) {
            return -1;
//            throw new RuntimeException("Requested the value at position " + (position + 1)
//                    + ", but the set contains only " + values.size() + " values.");
        }
        return values.get(position).longValue();
    }

    private static List<Double> parseValueString(String values) {
        List<Double> result = new ArrayList<Double>();
        StringTokenizer tokens = new StringTokenizer(values, ",");
        while (tokens.hasMoreElements()) {
            String value = tokens.nextToken();
            Double d = new Double(value);
            result.add(d);
        }
        return result;
    }

}
