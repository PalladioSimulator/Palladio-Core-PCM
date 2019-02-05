package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * An interface for term (+,-) and product (*,/,%) operations.
 * @author koziolek
 */
public abstract class TermProductOperation {

    /**
     * @author martens, Philipp Meier
     */
    public IProbabilityMassFunction compute(final IProbabilityMassFunction left,
            final IProbabilityMassFunction right) throws DifferentDomainsException {

        final IUnit resultUnit = IProbabilityFunctionFactory.eINSTANCE
                .createUnit(left.getUnit() + " * " + right.getUnit());
        final boolean resultHasOrderedDomain = (left.hasOrderedDomain() && right
                .hasOrderedDomain());

        final boolean isInteger = isIntegerSample(left) && isIntegerSample(right);

        // left and right are PMFs with samples nleft and nright
        // generate a PMF with nleft*nright samples by
        // multiplying both the probabilies and the values each

        final List<ISample> resultList = new ArrayList<ISample>();

        for (final ISample sleft : left.getSamples()) {
            for (final ISample sright : right.getSamples()) {
                if (isInteger) {
                    resultList
                    .add(IProbabilityFunctionFactory.eINSTANCE
                            .createSample(new Integer(
                                    calculateOperationForValues(
                                            getDoubleValue(sleft),
                                            getDoubleValue(sright))
                                    .intValue()), sleft
                                    .getProbability()
                                    * sright.getProbability()));
                } else {
                    resultList.add(IProbabilityFunctionFactory.eINSTANCE
                            .createSample(new Double(
                                    calculateOperationForValues(
                                            getDoubleValue(sleft),
                                            getDoubleValue(sright))), sleft
                                    .getProbability()
                                    * sright.getProbability()));
                }
            }
        }

        Collections.sort(resultList, new ValueBasedComparator());

        // join two samples with the same value
        final Iterator<ISample> iterator = resultList.iterator();
        if (iterator.hasNext()){
            ISample previousSample = iterator.next();
            while (iterator.hasNext()) {
                final ISample iSample = iterator.next();

                if (iSample.getValue().equals(previousSample.getValue())){
                    iterator.remove();
                    previousSample.setProbability(previousSample.getProbability()+iSample.getProbability());
                } else {
                    previousSample = iSample;
                }

            }
        }

        return IProbabilityFunctionFactory.eINSTANCE
                .createProbabilityMassFunction(resultList, resultUnit,
                        resultHasOrderedDomain);

    }

    private boolean isIntegerSample(final IProbabilityMassFunction function) {
        boolean isInteger = true;

        for (final ISample sample : function.getSamples()) {
            if (!(sample.getValue() instanceof Integer)){
                isInteger = false;
                break;
            }
        }
        return isInteger;
    }

    private Double getDoubleValue(final ISample sample) {
        if (sample.getValue() instanceof Number){
            return ((Number)sample.getValue()).doubleValue();
        } else {
            return Double.NaN;
        }

    }

    public abstract int compute(int left, int right);

    public abstract double compute(double left, double right);

    public abstract IProbabilityMassFunction compute(IProbabilityMassFunction left,
            double right) throws DomainNotNumbersException;

    public IProbabilityDensityFunction compute(
            final IProbabilityDensityFunction leftPDF,
            final IProbabilityDensityFunction rightPDF)
                    throws FunctionsInDifferenDomainsException,
                    UnknownPDFTypeException, IncompatibleUnitsException {

        throw new UnsupportedOperationException("StoEx does not support calculation with two PDFs, like multiplying two PDFs. " +
                "Check whether you actually mean to do this. " +
                "The left PDF to calculate with is "+leftPDF.toString()+
                ", the right is "+rightPDF.toString());

    }

    protected abstract Double calculateOperationForValues(Double value1, Double value2);

    public abstract IProbabilityDensityFunction compute(
            IProbabilityDensityFunction left, double right)
                    throws DomainNotNumbersException;

}

class ValueBasedComparator implements Comparator<ISample> {

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int compare(final ISample arg0, final ISample arg1) {
        final Object value0 = arg0.getValue();
        final Object value1 = arg1.getValue();

        if (value0.getClass().isInstance(value1)) {
            return ((Comparable) value0).compareTo(value1);
        } else if (value1.getClass().isInstance(value0)) {
            final int result = ((Comparable) value1).compareTo(value0);
            return result * -1;
        } else if (value1 instanceof Number && value0 instanceof Number) {
            final Number number0 = (Number) value0;
            final Number number1 = (Number) value1;

            return new Double(number0.doubleValue()).compareTo(new Double(
                    number1.doubleValue()));
        } else {
            throw new DifferentDomainsException();
        }
    }

}
