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
package de.fzi.sissy.extractors.java.recoder;
import recoder.ServiceConfiguration;
import recoder.abstraction.ProgramModelElement;
import recoder.abstraction.Type;
import recoder.java.Expression;
import recoder.java.ProgramElement;
import recoder.java.Reference;
import recoder.java.declaration.VariableSpecification;
import recoder.java.reference.TypeReference;
import recoder.java.reference.UncollatedReferenceQualifier;
import recoder.service.DefaultCrossReferenceSourceInfo;

/**
 * @author haller
 */
public class CustomSourceInfo extends DefaultCrossReferenceSourceInfo {

	public CustomSourceInfo(ServiceConfiguration config) {
		super(config);
	}
	
	public Reference resolveURQ(UncollatedReferenceQualifier urq) {
		try {
			return super.resolveURQ(urq);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public Type getType(Expression expr) {
		try {
			return super.getType(expr);
		}
		catch(Exception e) {
			return null;
		}
	}

	public Type getType(ProgramElement pe) {
		try {
			return super.getType(pe);
		}
		catch(Exception e) {
			return null;
		}
	}

	public Type getType(ProgramModelElement pme) {
		try {
			return super.getType(pme);
		}
		catch(Exception e) {
			return null;
		}
	}

	public Type getType(java.lang.String name, ProgramElement context) {
		try {
			return super.getType(name, context);
		}
		catch(Exception e) {
			return null;
		}
	}

	public Type getType(TypeReference tr) {
		try {
			return super.getType(tr);
		}
		catch(Exception e) {
			return null;
		}
	}

	public Type getType(VariableSpecification vs) {
		try {
			return super.getType(vs);
		}
		catch(Exception e) {
			return null;
		}
	}

}
