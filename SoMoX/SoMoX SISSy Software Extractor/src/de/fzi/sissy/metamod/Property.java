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
public class Property extends Field implements BehavioralEntity, Member, Referenceable {
	private Method getter;
	private Method setter;
	private Class implementedInterface;

	public Property(String name) {
		super(name);
	}

	public boolean isPropertyField() {
		return true;
	}

	public Method getGetter() {
		return getter;
	}

	public Method getSetter() {
		return setter;
	}

	public void setGetter(Method m) {
		if (getter != null)
			getter.setSurroundingProperty(null);
		if (m != null)
			m.setSurroundingProperty(this);
		getter = m;
	}

	public void setSetter(Method m) {
		if (setter != null)
			setter.setSurroundingProperty(null);
		if (m != null)
			m.setSurroundingProperty(this);
		setter = m;
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		setPosition(null);
		setGetter(null);
		setSetter(null);
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitProperty(this);
	}

	public void changeGetter(Method method) {
		setGetter(method);
	}

	public void changeSetter(Method method) {
		setSetter(method);
	}

	public void moveToClass(Class cls) {
		getter.moveToClass(cls);
		setter.moveToClass(cls);
		super.moveToClass(cls);
		setSetter(setter);
		setGetter(getter);
	}

	/**
	 * @param implementedInterface The implementedInterface to set.
	 */
	public void setImplementedInterface(Class implementedInterface) {
		this.implementedInterface = implementedInterface;
	}

	/**
	 * @return Returns the implementedInterface.
	 */
	public Class getImplementedInterface() {
		return implementedInterface;
	}
}
