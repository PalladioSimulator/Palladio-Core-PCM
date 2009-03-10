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
package de.fzi.sissy.extractors.java.builders;
import java.util.List;

import recoder.abstraction.ClassType;
import recoder.abstraction.EnumConstant;
import recoder.abstraction.Field;
import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.java.declaration.FieldSpecification;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.util.Debug;

/**
 *
 * It extracts all field declarations in a class.
 * @author szulman
 *
 */
public class FieldBuilder extends Builder {

	private static FieldBuilder singleton;

	/**
	 * 
	 */
	private FieldBuilder() {
		super();
	}

	public static FieldBuilder getSingleton() {
		if (singleton == null) {
			singleton = new FieldBuilder();
		}
		return singleton;
	}

	public void extractFromRecoder(ClassType containingClassType_recoder) {
        List<? extends Field> fieldList_recoder = containingClassType_recoder.getFields();
		if (fieldList_recoder == null)
			return;

		recoder.abstraction.Field[] fieldArray_recoder = fieldList_recoder.toArray(new Field[0]);
		for (int i = 0; i < fieldArray_recoder.length; i++) {
			Field field_recoder = fieldArray_recoder[i];
			if (field_recoder instanceof EnumConstant) {
			    System.out.println("jo");
            }
            createField(containingClassType_recoder, field_recoder);
		} //for

	} //extractFromRecoder

	public de.fzi.sissy.metamod.Field createField(ClassType containingClassType_recoder, Field field_recoder) {
		// We extract the simpleName, position, modifiers fields of
		// the variable using RECODER.
		String simpleName = field_recoder.getName();

		// First we have to create a DeclarationTypeAccess-Object for this Field:
		// 1. get recoder-type
		Type type_recoder = field_recoder.getType();
        if (type_recoder instanceof ParameterizedType)
            type_recoder = ((ParameterizedType)type_recoder).getGenericType();
		// 2. get mapped metamod-type
		de.fzi.sissy.metamod.Type type_metamod = (de.fzi.sissy.metamod.Type) ClassTypeBuilder.getSingleton().getInstanceFromMapper(type_recoder);
		// 3. create DeclarationTypeAccess
		de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
		Common.extractTypeArguments(dta, field_recoder.getType());
        // 4. setup Position of DeclarationTypeAccess:
		// Position for dta
		boolean positionSetted = false;
		if (field_recoder instanceof FieldSpecification) {
			dta.setPosition(FileBuilder.getSingleton().getSourcePosition((FieldSpecification)field_recoder));
			positionSetted = true;			
		} 
		
		// (09a) Field-Object created.
		// we create the corresponding field instance in METAMOD
		de.fzi.sissy.metamod.Field field_metamod = new de.fzi.sissy.metamod.Field(simpleName);
		
		// Class-Field-Containment-Relation
		// we also set the hasMember between this field and the sourrounding classtype
		de.fzi.sissy.metamod.Class containingClassType_metamod =
			(de.fzi.sissy.metamod.Class) ClassTypeBuilder.getSingleton().getInstanceFromMapper(containingClassType_recoder);
		
		containingClassType_metamod.addField(field_metamod);

		if (!positionSetted) {
			// TODO missing Position ???
			// get position of surrounding class
			Position position = containingClassType_metamod.getPosition();
			if (position != null) {
				Position pos = new Position(position.getSourceFile(), -1, -1, -1, -1);
				pos.setAssembly(position.getAssembly());
				dta.setPosition(pos);
			} else {
				Debug.warning("Null-Position for Field, DeclarationTypeAccess setted!"); 
			}
		}

		field_metamod.setTypeDeclaration(dta);
		
		// setup position of metamod-Field-object
		field_metamod.setPosition(dta.getPosition());
			
		// mapping
		RecoderToOMMapper.getSingleton().addInstanceToMapper(field_recoder, field_metamod);

		extractModifiers(field_recoder);
		
		return field_metamod;

	} //extractFromRecoder

	private void extractModifiers(Field field_recoder) {

		// (09b) Field - Modifier extrahieren.

		//we look up the appropriate member
		Member member_metamod = (Member) RecoderToOMMapper.getSingleton().getInstanceFromMapper(field_recoder);

		if (field_recoder.isFinal()) {
			member_metamod.setFinal(true);
		}

		if (field_recoder.isPrivate()) {
			member_metamod.setPrivate();
		}

		if (field_recoder.isProtected()) {
			member_metamod.setProtected();
		}

		if (field_recoder.isPublic()) {
			member_metamod.setPublic();
		}

		if (field_recoder.isStatic()) {
			member_metamod.setStatic(true);
		}

	} //extractModifiers

}
