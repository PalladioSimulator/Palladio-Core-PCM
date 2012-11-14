package de.uka.ipd.sdq.reliability.solver.compare;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.markov.Label;
import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.Transition;
import de.uka.ipd.sdq.reliability.core.helper.EMFHelper;

/**
 * Provides functionality to compare two Markov models.
 * 
 * The comparison is based on the tracing information which uniquely identifies each Markov state.
 * 
 * @author brosch
 * 
 */
public class MarkovComparator {

    /**
     * A logger for printing the comparison result.
     */
    private static Logger logger = Logger.getLogger(MarkovComparator.class.getName());

    /**
     * Counts the overall number of changes in chains #1 and #2.
     */
    private long changeCount = 0;

    /**
     * Counts the number of deleted states in chain #1.
     */
    private int deletedStateCount = 0;

    /**
     * Counts the number of deleted transitions in chain #1.
     */
    private int deletedTransitionCount = 0;

    /**
     * The name of the first Markov chain.
     */
    private String firstName = "";

    /**
     * Counts the number of newly introduced states in chain #2.
     */
    private int newStateCount = 0;

    /**
     * Counts the number of newly introduced transitions in chain #2.
     */
    private int newTransitionCount = 0;

    /**
     * The name of the second Markov chain.
     */
    private String secondName = "";

    /**
     * Counts the overall number of state changes in chains #1 and #2.
     */
    private long stateChangeCount = 0;

    /**
     * Counts the number of states with changed properties in chains #1 and #2.
     */
    private int statePropertyChangeCount = 0;

    /**
     * Counts the overall number of transition changes in chains #1 and #2.
     */
    private long transitionChangeCount = 0;

    /**
     * Counts the number of transitions with changed properties in chains #1 and #2.
     */
    private int transitionPropertyChangeCount = 0;

    /**
     * Compares two Markov chains.
     * 
     * @param firstChain
     *            the first chain
     * @param secondChain
     *            the second chain
     */
    public void compare(final MarkovChain firstChain, final MarkovChain secondChain) {
        logger.info("Start Markov compare");
        if (firstName == "") {
            firstName = firstChain.getName();
        }
        if (secondName == "") {
            secondName = secondChain.getName();
        }
        compareProperties(firstChain, secondChain);
        compareStates(firstChain.getStates(), secondChain.getStates());
        compareTransitions(firstChain.getTransitions(), secondChain.getTransitions());
        printCompareStatistics(firstChain, secondChain);
        logger.info("End Markov compare");
    }

    /**
     * Loads and compares the Markov models identified by the two given file names.
     * 
     * The files must exist and contain valid Markov models.
     * 
     * @param firstMarkovFileName
     *            the file name of the first Markov model
     * @param secondMarkovFileName
     *            the file name of the second Markov model
     */
    public void compare(final String firstMarkovFileName, final String secondMarkovFileName) {
        firstName = new File(firstMarkovFileName).getName();
        secondName = new File(secondMarkovFileName).getName();
        EObject ch1 = EMFHelper.loadFromXMIFile(firstMarkovFileName);
        EObject ch2 = EMFHelper.loadFromXMIFile(secondMarkovFileName);
        if ((ch1 == null) || !(ch1 instanceof MarkovChain) || (ch2 == null) || !(ch2 instanceof MarkovChain)) {
            return;
        }
        compare((MarkovChain) ch1, (MarkovChain) ch2);
    }

    /**
     * Compares the general properties of two Markov chains.
     * 
     * @param ch1
     *            the first chain
     * @param ch2
     *            the second chain
     */
    private void compareProperties(final MarkovChain ch1, final MarkovChain ch2) {
        if (!ch1.getName().equals(ch2.getName())) {
            logger.debug("Chain name changed from \"" + ch1.getName() + "\" to \"" + ch2.getName() + "\"");
        }
    }

    /**
     * Compares the properties of two Markov states.
     * 
     * The states are assumed to have the same identity.
     * 
     * @param st1
     *            the first state
     * @param st2
     *            the second state
     */
    private void compareProperties(final State st1, final State st2) {

        boolean typeEquals = st1.getType().equals(st2.getType());
        boolean nameEquals = st1.getName().equals(st2.getName());
        boolean labelsEqual = testEquality(st1.getLabels(), st2.getLabels());

        if (!typeEquals || !nameEquals || !labelsEqual) {
            logger.debug("State \"" + st1.getName() + "\" changed:");
            increaseStatePropertyChangeCount();
            if (!nameEquals) {
                logger.debug("- mame changed from \"" + st1.getName() + "\" to \"" + st2.getName() + "\"");
            }
            if (!typeEquals) {
                logger.debug("- type changed from \"" + st1.getType().toString() + "\" to \""
                        + st2.getType().toString() + "\"");
            }
            if (!labelsEqual) {
                logger.debug("- labels changed");
            }
        }
    }

    /**
     * Compares the transitions of two Markov chains.
     * 
     * @param tr1
     *            the transitions of the first chain
     * @param tr2
     *            the transitions of the second chain
     */
    private void compareProperties(final Transition tr1, final Transition tr2) {

        boolean nameEquals = tr1.getName().equals(tr2.getName());
        boolean probabilityEquals = (tr1.getProbability() == tr2.getProbability());

        if (!nameEquals || !probabilityEquals) {
            logger.debug("Transition \"" + tr1.getName() + "\" changed:");
            increaseTransitionPropertyChangeCount();
            if (!nameEquals) {
                logger.debug("- mame changed from \"" + tr1.getName() + "\" to \"" + tr2.getName() + "\"");
            }
            if (!probabilityEquals) {
                logger.debug("- probability changed from " + tr1.getProbability() + " to " + tr2.getProbability());
            }
        }
    }

    /**
     * Compares the states of two Markov chains.
     * 
     * @param states1
     *            the states of the first chain
     * @param states2
     *            the states of the second chain
     */
    private void compareStates(final EList<State> states1, final EList<State> states2) {

        // Create private copies of the lists:
        List<State> statesCopy1 = new ArrayList<State>();
        statesCopy1.addAll(states1);
        List<State> statesCopy2 = new ArrayList<State>();
        statesCopy2.addAll(states2);

        // Iterate over the states of the first chain:
        while (statesCopy1.size() > 0) {

            // Retrieve the first state:
            State st1 = statesCopy1.get(0);

            // Search for an identical state in the second chain:
            State st2 = null;
            for (State st2_candidate : statesCopy2) {
                if (testIdentity(st1, st2_candidate)) {
                    st2 = st2_candidate;
                    break;
                }
            }

            // Check if an identical state exists:
            if (st2 != null) {

                // check for changed state properties:
                compareProperties(st1, st2);

                // delete the states:
                statesCopy1.remove(st1);
                statesCopy2.remove(st2);

            } else {

                // st1 does not longer exist:
                logger.debug("State \"" + st1.getName() + "\" deleted");
                increaseDeletedStateCount();

                // delete the state:
                statesCopy1.remove(st1);
            }
        }

        // Iterate over the states of the second chain:
        while (statesCopy2.size() > 0) {

            // Retrieve the first state:
            State st2 = statesCopy2.get(0);

            // st2 is a new state:
            logger.debug("State \"" + st2.getName() + "\" added");
            increaseNewStateCount();

            // delete the state:
            statesCopy2.remove(st2);
        }
    }

    /**
     * Compares the transitions of two Markov chains.
     * 
     * @param transitions1
     *            the transitions of the first chain
     * @param transitions2
     *            the transitions of the second chain
     */
    private void compareTransitions(final EList<Transition> transitions1, final EList<Transition> transitions2) {

        // Create private copies of the lists:
        List<Transition> transitionsCopy1 = new ArrayList<Transition>();
        transitionsCopy1.addAll(transitions1);
        List<Transition> transitionsCopy2 = new ArrayList<Transition>();
        transitionsCopy2.addAll(transitions2);

        // Iterate over the transitions of the first chain:
        while (transitionsCopy1.size() > 0) {

            // Retrieve the first transition:
            Transition tr1 = transitionsCopy1.get(0);

            // Search for an identical transition in the second chain:
            Transition tr2 = null;
            for (Transition tr2_candidate : transitionsCopy2) {
                if (testIdentity(tr1, tr2_candidate)) {
                    tr2 = tr2_candidate;
                    break;
                }
            }

            // Check if an identical transition exists:
            if (tr2 != null) {

                // check for changed state properties:
                compareProperties(tr1, tr2);

                // delete the states:
                transitionsCopy1.remove(tr1);
                transitionsCopy2.remove(tr2);

            } else {

                // tr1 does not longer exist:
                logger.debug("Transition \"" + tr1.getName() + "\" deleted");
                increaseDeletedTransitionCount();

                // delete the state:
                transitionsCopy1.remove(tr1);
            }
        }

        // Iterate over the transitions of the second chain:
        while (transitionsCopy2.size() > 0) {

            // Retrieve the first transition:
            Transition tr2 = transitionsCopy2.get(0);

            // tr2 is a new transition:
            logger.debug("Transition \"" + tr2.getName() + "\" added");
            increaseNewTransitionCount();

            // delete the state:
            transitionsCopy2.remove(tr2);
        }
    }

    /**
     * Creates a decimal format based on the given numbers.
     * 
     * @param numbers
     *            the list of numbers
     * @return the resulting decimal format
     */
    private DecimalFormat getDecimalFormat(final ArrayList<Integer> numbers) {

        // Search for the maximal number of decimal places:
        int maxPlaces = 0;
        for (Integer number : numbers) {
            int places = number.toString().length();
            if (places > maxPlaces) {
                maxPlaces = places;
            }
        }

        // Generate a format string corresponding to the places:
        String formatString = "";
        for (int i = 0; i < maxPlaces; i++) {
            formatString += "0";
        }
        return new DecimalFormat(formatString);
    }

    /**
     * Increases the deleted state count.
     */
    private void increaseDeletedStateCount() {
        changeCount++;
        stateChangeCount++;
        deletedStateCount++;
    }

    /**
     * Increases the deleted transition count.
     */
    private void increaseDeletedTransitionCount() {
        changeCount++;
        transitionChangeCount++;
        deletedTransitionCount++;
    }

    /**
     * Increases the new state count.
     */
    private void increaseNewStateCount() {
        changeCount++;
        stateChangeCount++;
        newStateCount++;
    }

    /**
     * Increases the new transition count.
     */
    private void increaseNewTransitionCount() {
        changeCount++;
        transitionChangeCount++;
        newTransitionCount++;
    }

    /**
     * Increases the changed state property count.
     */
    private void increaseStatePropertyChangeCount() {
        changeCount++;
        stateChangeCount++;
        statePropertyChangeCount++;
    }

    /**
     * Increases the deleted transition count.
     */
    private void increaseTransitionPropertyChangeCount() {
        changeCount++;
        transitionChangeCount++;
        transitionPropertyChangeCount++;
    }

    /**
     * Prints the statistics of the compare operation.
     * 
     * @param secondChain
     *            the first Markov chain
     * @param firstChain
     *            the second Markov chain
     */
    private void printCompareStatistics(final MarkovChain firstChain, final MarkovChain secondChain) {

        // Assume that the chains are not so big that Integer.MAX_VALUE is
        // reached:
        int numberOfStates1 = firstChain.getStates().size();
        int numberOfStates2 = secondChain.getStates().size();
        int numberOfTransitions1 = firstChain.getTransitions().size();
        int numberOfTransitions2 = secondChain.getTransitions().size();

        // Collect state statistics:
        int numberOfChangedStates1 = statePropertyChangeCount;
        int numberOfDeletedStates1 = deletedStateCount;
        int numberOfUnchangedStates1 = numberOfStates1 - numberOfChangedStates1 - numberOfDeletedStates1;
        int numberOfChangedStates2 = statePropertyChangeCount;
        int numberOfAddedStates2 = newStateCount;
        int numberOfUnchangedStates2 = numberOfStates2 - numberOfChangedStates2 - numberOfAddedStates2;

        // Collect transition statistics:
        int numberOfChangedTransitions1 = transitionPropertyChangeCount;
        int numberOfDeletedTransitions1 = deletedTransitionCount;
        int numberOfUnchangedTransitions1 = numberOfTransitions1 - numberOfChangedTransitions1
                - numberOfDeletedTransitions1;
        int numberOfChangedTransitions2 = transitionPropertyChangeCount;
        int numberOfAddedTransitions2 = newTransitionCount;
        int numberOfUnchangedTransitions2 = numberOfTransitions2 - numberOfChangedTransitions2
                - numberOfAddedTransitions2;

        // Collect percentages:
        double percentageOfChangedStates1 = 100.0 * ((double) numberOfChangedStates1 / (double) numberOfStates1);
        double percentageOfDeletedStates1 = 100.0 * ((double) numberOfDeletedStates1 / (double) numberOfStates1);
        double percentageOfUnchangedStates1 = 100.0 * ((double) numberOfUnchangedStates1 / (double) numberOfStates1);
        double percentageOfChangedTransitions1 = 100.0 * ((double) numberOfChangedTransitions1 / (double) numberOfTransitions1);
        double percentageOfDeletedTransitions1 = 100.0 * ((double) numberOfDeletedTransitions1 / (double) numberOfTransitions1);
        double percentageOfUnchangedTransitions1 = 100.0 * ((double) numberOfUnchangedTransitions1 / (double) numberOfTransitions1);
        double percentageOfChangedStates2 = 100.0 * ((double) numberOfChangedStates2 / (double) numberOfStates2);
        double percentageOfAddedStates2 = 100.0 * ((double) numberOfAddedStates2 / (double) numberOfStates2);
        double percentageOfUnchangedStates2 = 100.0 * ((double) numberOfUnchangedStates2 / (double) numberOfStates2);
        double percentageOfChangedTransitions2 = 100.0 * ((double) numberOfChangedTransitions2 / (double) numberOfTransitions2);
        double percentageOfAddedTransitions2 = 100.0 * ((double) numberOfAddedTransitions2 / (double) numberOfTransitions2);
        double percentageOfUnchangedTransitions2 = 100.0 * ((double) numberOfUnchangedTransitions2 / (double) numberOfTransitions2);

        // Derive string formats:
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(numberOfStates1);
        numbers.add(numberOfStates2);
        numbers.add(numberOfTransitions1);
        numbers.add(numberOfTransitions2);
        DecimalFormat df1 = getDecimalFormat(numbers);
        DecimalFormat df2 = new DecimalFormat("00.00");

        // Print statistics:
        logger.info("States chain 1 [" + firstName + "]:");
        logger.info("- total:     " + df1.format(numberOfStates1));
        logger.info("- changed:   " + df1.format(numberOfChangedStates1) + " ("
                + df2.format(percentageOfChangedStates1) + "%)");
        logger.info("- deleted:   " + df1.format(numberOfDeletedStates1) + " ("
                + df2.format(percentageOfDeletedStates1) + "%)");
        logger.info("- unchanged: " + df1.format(numberOfUnchangedStates1) + " ("
                + df2.format(percentageOfUnchangedStates1) + "%)");
        logger.info("Transitions chain 1 [" + firstName + "]:");
        logger.info("- total:     " + df1.format(numberOfTransitions1));
        logger.info("- changed:   " + df1.format(numberOfChangedTransitions1) + " ("
                + df2.format(percentageOfChangedTransitions1) + "%)");
        logger.info("- deleted:   " + df1.format(numberOfDeletedTransitions1) + " ("
                + df2.format(percentageOfDeletedTransitions1) + "%)");
        logger.info("- unchanged: " + df1.format(numberOfUnchangedTransitions1) + " ("
                + df2.format(percentageOfUnchangedTransitions1) + "%)");
        logger.info("States chain 2 [" + secondName + "]:");
        logger.info("- total:     " + df1.format(numberOfStates2));
        logger.info("- changed:   " + df1.format(numberOfChangedStates2) + " ("
                + df2.format(percentageOfChangedStates2) + "%)");
        logger.info("- added:     " + df1.format(numberOfAddedStates2) + " (" + df2.format(percentageOfAddedStates2)
                + "%)");
        logger.info("- unchanged: " + df1.format(numberOfUnchangedStates2) + " ("
                + df2.format(percentageOfUnchangedStates2) + "%)");
        logger.info("Transitions chain 2 [" + secondName + "]:");
        logger.info("- total:     " + df1.format(numberOfTransitions2));
        logger.info("- changed:   " + df1.format(numberOfChangedTransitions2) + " ("
                + df2.format(percentageOfChangedTransitions2) + "%)");
        logger.info("- added:     " + df1.format(numberOfAddedTransitions2) + " ("
                + df2.format(percentageOfAddedTransitions2) + "%)");
        logger.info("- unchanged: " + df1.format(numberOfUnchangedTransitions2) + " ("
                + df2.format(percentageOfUnchangedTransitions2) + "%)");
    }

    /**
     * Searches a list of labels for a given key.
     * 
     * @param labels
     *            the list of labels
     * @param key
     *            the key
     * @return the label; NULL if no corresponding label has been found.
     */
    private Label searchLabelsForKey(final EList<Label> labels, final String key) {
        for (Label label : labels) {
            if (label.getKey().equals(key)) {
                return label;
            }
        }
        return null;
    }

    /**
     * Checks if the labels of two Markov states are equal.
     * 
     * It is assumed that each key appears only once in each list of labels
     * 
     * @param labels1
     *            the labels of the first state
     * @param labels2
     *            the labels of the second state
     * @return
     */
    private boolean testEquality(final EList<Label> labels1, final EList<Label> labels2) {
        if (labels1.size() != labels2.size()) {
            return false;
        }
        for (int i = 0; i < labels1.size(); i++) {
            Label label1 = labels1.get(i);
            Label label1_2 = searchLabelsForKey(labels2, label1.getKey());
            Label label2 = labels2.get(i);
            Label label2_1 = searchLabelsForKey(labels1, label2.getKey());
            if ((label1_2 == null) || (label2_1 == null)) {
                return false;
            }
            if (!label1.getValue().equals(label1_2.getValue()) || !label2.getValue().equals(label2_1.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks two Markov States for having the same identity.
     * 
     * The identity is checked through the trace information.
     * 
     * @param st1
     *            the first state
     * @param st2
     *            the second state
     * @return true, if the states are identical; false otherwise
     */
    private boolean testIdentity(final State st1, final State st2) {
        if (st1.getTraces().size() != st2.getTraces().size()) {
            return false;
        }
        for (int i = 0; i < st1.getTraces().size(); i++) {
            if (!st1.getTraces().get(i).equals(st2.getTraces().get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks two Markov Transitions for having the same identity.
     * 
     * The transitions are considered to have the same identity if they connected the same states.
     * 
     * @param t1
     *            the first transition
     * @param t2
     *            the second transition
     * @return true, if the transitions are identical; false otherwise
     */
    private boolean testIdentity(final Transition t1, final Transition t2) {
        return testIdentity(t1.getFromState(), t2.getFromState()) && testIdentity(t1.getToState(), t2.getToState());
    }
}
