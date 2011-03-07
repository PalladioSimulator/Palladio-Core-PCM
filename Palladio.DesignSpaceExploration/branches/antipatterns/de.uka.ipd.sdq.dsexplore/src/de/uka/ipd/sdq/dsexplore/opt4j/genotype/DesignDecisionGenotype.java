package de.uka.ipd.sdq.dsexplore.opt4j.genotype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.ListGenotype;

import de.uka.ipd.sdq.pcm.designdecision.Choice;

public class DesignDecisionGenotype implements ListGenotype<Choice> {
	
	private List<Choice> choices;
	
	public DesignDecisionGenotype() {
		this.choices = new ArrayList<Choice>(20);
	}

	private DesignDecisionGenotype(List<Choice> internalList) {
		this.choices = internalList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <G extends Genotype> G newInstance() {
		return (G) new DesignDecisionGenotype();
	}

	@Override
	public int size() {
		return this.choices.size();
	}

	@Override
	public boolean add(Choice e) {
		return this.choices.add(e);
	}

	@Override
	public void add(int index, Choice element) {
		this.choices.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends Choice> c) {
		return this.choices.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Choice> c) {
		return this.choices.addAll(index, c);
	}

	@Override
	public void clear() {
		this.clear();
	}

	@Override
	public boolean contains(Object o) {
		return this.choices.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.choices.containsAll(c);
	}

	@Override
	public Choice get(int index) {
		return this.choices.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return this.choices.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return this.choices.isEmpty();
	}

	@Override
	public Iterator<Choice> iterator() {
		return new InternalIterator(this.choices,0);
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.choices.lastIndexOf(o);
	}

	@Override
	public ListIterator<Choice> listIterator() {
		return new InternalIterator(this.choices,0);
	}

	@Override
	public ListIterator<Choice> listIterator(int index) {
		return new InternalIterator(this.choices, index);
	}

	@Override
	public boolean remove(Object o) {
		return this.choices.remove(o);
	}

	@Override
	public Choice remove(int index) {
		return this.choices.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return this.choices.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return this.choices.retainAll(c);
	}

	@Override
	public Choice set(int index, Choice element) {
		return this.choices.set(index, element);
	}

	@Override
	public List<Choice> subList(int fromIndex, int toIndex) {
		return new DesignDecisionGenotype(choices.subList(fromIndex, toIndex));
	}

	@Override
	public Object[] toArray() {
		return this.choices.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.choices.toArray(a);
	}
	
	protected List<Choice> getInternalList(){
		return this.choices;
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
