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
public class StructuralAbstraction extends NamedModelElementImplementation implements ModelAnnotation, NamedModelElement {
	private Root root;
	private String type;
	private ModelElementList elements;
	
	public StructuralAbstraction(String name, String type) {
		super(name);
		this.type = type;
		elements = new ModelElementList();
	}

	public void setModelElements(ModelElementList elems) {
	    this.elements.clear();
		Iterator it = elems.iterator();
		while (it.hasNext()) {
			ModelElement elem = (ModelElement)it.next();
			addModelElement(elem);
		}
	}

	public ModelElementList getModelElements() {
		return elements;
	}

	public void addModelElement(ModelElement elem) {
		elements.addUnique(elem);
	}
	
    public void addModelElements(ModelElementList list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModelElement elem = (ModelElement)it.next();
            addModelElement(elem);
        }
    }
    
    public boolean hasModelElement(ModelElement element) {
        return elements.contains(element);
    }
    
    public void clearModelElements() {
        elements.clear();
    }
    
    public boolean intersects(StructuralAbstraction abstraction) {
        Iterator itor = elements.iterator();
        while (itor.hasNext()) {
            if (abstraction.hasModelElement((ModelElement)itor.next()))
                return true;
        }
        return false;
    }

    
	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Do not call this method directly. Use Root.addPackage instead.
	 */
	void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}
	
	public ModelElement getParent() {
		return root;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitStructuralAbstraction(this);
	}	
}
