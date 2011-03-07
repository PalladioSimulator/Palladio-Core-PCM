package de.uka.ipd.sdq.dsexplore.opt4j.genotype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.ListGenotype;

import de.uka.ipd.sdq.pcm.designdecision.Candidate;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;

public class DesignDecisionGenotype implements ListGenotype<Choice> {
	
	private Candidate choices;
	
	/*
	 * Internal static class to disallow any changes of the individual counter except increasing it.  
	 */
	static class IndividualID { 
		private static long individualIDCounter = 0;
		protected static long incID(){
			return individualIDCounter++;
		}
	}
	private long numericId = IndividualID.incID();
	
	public DesignDecisionGenotype() {
		this.choices = designdecisionFactory.eINSTANCE.createCandidate();
	}
	
	public DesignDecisionGenotype(Candidate emfCandidate){
		this.choices = emfCandidate;
	}
	
	/**
	 * create new genotype. Sort choice in the order of the passed Problem.  
	 * @param emfCandidate
	 */
	public DesignDecisionGenotype(Candidate emfCandidate, Problem problem, DesignDecisionGenotype initialCandidateGenotype){
		// sort by designdecision order (time doesnot matter so much as this is only done at optimisation startup)
		this.choices = designdecisionFactory.eINSTANCE.createCandidate();
		for (DegreeOfFreedom dof : problem.getDesigndecision()) {
			boolean foundChoice = false;
			for (Choice choice : emfCandidate.getChoice()) {
				if (choice.getDegreeOfFreedom() == dof){
					this.choices.getChoice().add(choice);
					foundChoice = true;
					break;
				}
			}
			if (!foundChoice){
				// if not found take from initial genotype
				for (Choice choice : initialCandidateGenotype.getEMFCandidate().getChoice()) {
					if (EcoreUtil.equals(choice.getDegreeOfFreedom(),dof)){
						this.choices.getChoice().add((Choice)EcoreUtil.copy(choice));
						foundChoice = true;
						break;
					}
				}
			}
		}
	}

	private DesignDecisionGenotype(List<Choice> internalList) {
		this.choices = designdecisionFactory.eINSTANCE.createCandidate();
		this.choices.getChoice().addAll(internalList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <G extends Genotype> G newInstance() {
		return (G) new DesignDecisionGenotype();
	}

	@Override
	public int size() {
		return this.choices.getChoice().size();
	}

	@Override
	public boolean add(Choice e) {
		return this.choices.getChoice().add(e);
	}

	@Override
	public void add(int index, Choice element) {
		this.choices.getChoice().add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends Choice> c) {
		return this.choices.getChoice().addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Choice> c) {
		return this.choices.getChoice().addAll(index, c);
	}

	@Override
	public void clear() {
		this.clear();
	}

	@Override
	public boolean contains(Object o) {
		return this.choices.getChoice().contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.choices.getChoice().containsAll(c);
	}

	@Override
	public Choice get(int index) {
		return this.choices.getChoice().get(index);
	}

	@Override
	public int indexOf(Object o) {
		return this.choices.getChoice().indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return this.choices.getChoice().isEmpty();
	}

	@Override
	public Iterator<Choice> iterator() {
		return new InternalIterator(this.choices.getChoice(),0);
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.choices.getChoice().lastIndexOf(o);
	}

	@Override
	public ListIterator<Choice> listIterator() {
		return new InternalIterator(this.choices.getChoice(),0);
	}

	@Override
	public ListIterator<Choice> listIterator(int index) {
		return new InternalIterator(this.choices.getChoice(), index);
	}

	@Override
	public boolean remove(Object o) {
		return this.choices.getChoice().remove(o);
	}

	@Override
	public Choice remove(int index) {
		return this.choices.getChoice().remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return this.choices.getChoice().removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return this.choices.getChoice().retainAll(c);
	}

	@Override
	public Choice set(int index, Choice element) {
		return this.choices.getChoice().set(index, element);
	}

	@Override
	public List<Choice> subList(int fromIndex, int toIndex) {
		return new DesignDecisionGenotype(choices.getChoice().subList(fromIndex, toIndex));
	}

	@Override
	public Object[] toArray() {
		return this.choices.getChoice().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.choices.getChoice().toArray(a);
	}
	
	protected List<Choice> getInternalList(){
		return this.choices.getChoice();
	}
	
	public Candidate getEMFCandidate(){
		return this.choices;
	}
	
	public long getNumericID() {
		return this.numericId;
	}



}

/**
 * This allows us to intercept uses of the iterator when needed. 
 * @author martens
 *
 */
class InternalIterator implements ListIterator<Choice>{
	
	ListIterator<Choice> decoratedIterator;
	
	public InternalIterator(List<Choice> internalList, int index){
		this.decoratedIterator = internalList.listIterator(index);
	}

	@Override
	public boolean hasNext() {
		return decoratedIterator.hasNext();
	}

	@Override
	public Choice next() {
		return decoratedIterator.next();
	}

	@Override
	public void remove() {
		decoratedIterator.remove();
	}

	@Override
	public void add(Choice e) {
		this.decoratedIterator.add(e);
	}

	@Override
	public boolean hasPrevious() {
		return this.decoratedIterator.hasPrevious();
	}

	@Override
	public int nextIndex() {
		return this.decoratedIterator.nextIndex();
	}

	@Override
	public Choice previous() {
		return this.decoratedIterator.previous();
	}

	@Override
	public int previousIndex() {
		return this.decoratedIterator.previousIndex();
	}

	@Override
	public void set(Choice e) {
		this.decoratedIterator.set(e);
	}
	
}
