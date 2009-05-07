/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.metamod;

import java.util.Iterator;

/**
 * @author Mircea Trifu
 *
 */
public class CompositeAccess extends AccessImplementation implements Access, AccessContainer {
	private ModelElementList accesses = new ModelElementList();

	public CompositeAccess() {
		super(null);
        accesses = new ModelElementList();
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitCompositeAccess(this);
	}

	/**
	 * @param accesses The accesses to set.
	 */
	public void setAccesses(ModelElementList accesses) {
		this.accesses = accesses;
		Iterator it = this.accesses.iterator();
		while (it.hasNext()) {
			AccessImplementation acc = (AccessImplementation)it.next();
			acc.setSurroundingAccessContainer(this);
		}
	}
	
	public int getAccessCount() {
		int tmp = 0;
		
		Iterator it = accesses.iterator();
		while (it.hasNext()) {
			tmp++;
			Access acc = (Access)it.next();
			if (acc instanceof CompositeAccess)
				tmp += ((CompositeAccess)acc).getAccessCount();
		}
		return tmp;
	}

	/**
	 * @return Returns the accesses.
	 */
	public ModelElementList getAccesses() {
		return accesses;
	}
	
	public void addAccess(Access acc) {
		accesses.addUnique(acc);
		((AccessImplementation)acc).setSurroundingAccessContainer(this);		
	}

	public void insertAccess(Access access, int position) {
		accesses.add(position, access);
		((AccessImplementation)access).setSurroundingAccessContainer(this);
	}
	
	public void removeAccess(Access access) {
		accesses.remove(access);
		ModelElementRepository.getWorkingRepository().removeElement(access);
	}

	public void removeContainedAccess(Access acc) {
		accesses.remove(acc);
	}
    
    // TODO destroy for composite access????
    public void destroy() {
        accesses.destroy();
        accesses = null;
    }
}
