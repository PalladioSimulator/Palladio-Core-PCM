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

/**
 * @author Mircea Trifu
 *
 */
public class Array extends TypeDecoratorImplementation implements TypeDecorator, Referenceable {
	private int dimensions = 1;
	
	public Array(Type componentType) {
		this(componentType, 1);
	}
	
	public Array(Type componentType, int dim) {
		super(componentType, componentType.getSimpleName()+"[]");
		if (dim > 0) {
			dimensions = dim;
			String commaStr = "";
			for (int i=0; i < dim - 1; i++)
				commaStr += ",";
			setSimpleName(componentType.getSimpleName()+"[" + commaStr + "]");
		}
	}

	public Type getComponentType() {
		return getDecoratedType();
	}

    public Type getBaseType() {
		Type tmp = getDecoratedType();
		while (tmp instanceof Array)
			tmp = ((Array)tmp).getDecoratedType();
		return tmp;
    }
    
    public int getDimensions() {
    	return dimensions;
    }

    public ModelElement getParent() {
		return getRoot();
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitArray(this);
	}
}
