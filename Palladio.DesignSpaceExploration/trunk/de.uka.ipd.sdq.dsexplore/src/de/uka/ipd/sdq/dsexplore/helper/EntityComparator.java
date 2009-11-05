package de.uka.ipd.sdq.dsexplore.helper;

import java.util.Comparator;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

public class EntityComparator implements Comparator<Entity> {

		@Override
		public int compare(Entity arg0, Entity arg1) {
			return arg0.getId().compareTo(arg1.getId());
		}
}
