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
abstract class ModelElementImplementation implements ModelElement, Comparable {
	private int uniqueId;
	private ModelAnnotationList annotations;
	private int status = Status.LIBRARY;

	public ModelElementImplementation() {
		uniqueId = ModelElementRepository.getWorkingRepository().getNextId(this);
		annotations = new ModelAnnotationList();
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int id) {
		ModelElementRepository.getWorkingRepository().updateId(this, id);
		uniqueId = id;
	}
		/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#setAnnotations(de.fzi.sissy.metamod.ModelAnnotationList)
	 */
	public void setAnnotations(ModelAnnotationList annotations) {
		this.annotations = annotations;
		if (this.annotations == null)
			this.annotations = new ModelAnnotationList();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getAnnotations()
	 */
	public ModelAnnotationList getAnnotations() {
		return annotations;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#addAnnotation(de.fzi.sissy.metamod.ModelAnnotation)
	 */
	public void addAnnotation(ModelAnnotation annotation) {
		annotations.add(annotation);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getAnnotations(java.lang.String)
	 */
	public ModelAnnotationList getAnnotations(String typeName) {
		ModelAnnotationList list = new ModelAnnotationList();
		try {
			java.lang.Class cls = java.lang.Class.forName(typeName);
			Iterator it = annotations.iterator();
			while (it.hasNext()) {
				Object annotation = it.next();
				if (cls.isInstance(annotation))
					list.add(annotation);
			}
		} catch (ClassNotFoundException e) {
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getFirstAnnotation()
	 */
	public ModelAnnotation getFirstAnnotation() {
		Iterator it = annotations.iterator();
		if (it.hasNext())
			return (ModelAnnotation)it.next();
		return null;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getFirstAnnotation(java.lang.String)
	 */
	public ModelAnnotation getFirstAnnotation(String typeName) {
		try {
			java.lang.Class cls = java.lang.Class.forName(typeName);
			Iterator it = annotations.iterator();
			while (it.hasNext()) {
				Object annotation = it.next();
				if (cls.isInstance(annotation))
					return (ModelAnnotation)annotation;
			}
		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#removeAnnotation(de.fzi.sissy.metamod.ModelAnnotation)
	 */
	public void removeAnnotation(ModelAnnotation annotation) {
		annotations.remove(annotation);		
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#removeAllAnnotations()
	 */
	public void removeAllAnnotations() {
		annotations.clear();
	}

	// TODO OK check destroy() 
	void destroy() {
		annotations.destroy();
		annotations = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitModelElement(this);
	}

	public int compareTo(Object arg0) {
		if (arg0 instanceof ModelElement) {
			ModelElement elem = (ModelElement)arg0;
			if (getUniqueId() < elem.getUniqueId())
				return -1;
			else if (getUniqueId() > elem.getUniqueId())
				return 1;
		}
		return 0;
	}

	/**
	 * @param status The status to set.
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return Returns the status.
	 */
	public int getStatus() {
		return status;
	}

	public boolean isFailedDependency() {
		return status == Status.FAILEDDEP;
	}

	public void setFailedDependency() {
		status = Status.FAILEDDEP;
	}

	public boolean isLibrary() {
		return status == Status.LIBRARY;
	}

	public void setLibrary() {
		status = Status.LIBRARY;
	}
	
	public boolean isImplicit() {
		return status == Status.IMPLICIT;
	}

	public void setImplicit() {
		status = Status.IMPLICIT;
	}
	
	public boolean isNormal() {
		return status == Status.NORMAL;
	}

	public void setNormal() {
		status = Status.NORMAL;
	}
}
