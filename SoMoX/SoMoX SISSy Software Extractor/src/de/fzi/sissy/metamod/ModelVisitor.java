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
public interface ModelVisitor {
	void visitAccess(Access a);
	void visitArray(Array a);
	void visitAttribute(Attribute a);
	void visitBehavioralEntity(BehavioralEntity be);
	void visitCastTypeAccess(CastTypeAccess cta);
	void visitCatchParameter(CatchParameter cp);
	void visitClass(Class c);
	void visitComment(Comment c);
	void visitCompositeAccess(CompositeAccess ca);
	void visitConstructor(Constructor c);
	void visitDeclarationTypeAccess(DeclarationTypeAccess dta);
	void visitDelegate(Delegate d);
	void visitDelegateAccess(DelegateAccess da);
	void visitDestructor(Destructor d);
	void visitField(Field f);
	void visitFile(File f);
	void visitFormalParameter(FormalParameter fp);
	void visitFunction(Function f);
	void visitFunctionAccess(FunctionAccess fa);
	void visitGenericClass(GenericClass gc);
	void visitGenericConstructor(GenericConstructor gc);	
	void visitGenericEntity(GenericEntity ge);
	void visitGenericFunction(GenericFunction gf);
	void visitGenericMethod(GenericMethod gm);
	void visitGlobalFunction(GlobalFunction gf);
	void visitGlobalVariable(GlobalVariable gv);
	void visitInheritanceTypeAccess(InheritanceTypeAccess ita);
	void visitLocalVariable(LocalVariable lv);
	void visitMember(Member m);
	void visitMethod(Method m);
	void visitModelAnnotation(ModelAnnotation ma);
	void visitModelElement(ModelElement elem);
	void visitNamedModelElement(NamedModelElement nme);
	void visitPackage(Package p);
	void visitPackageAlias(PackageAlias pa);
	void visitProperty(Property p);
	void visitPropertyAccess(PropertyAccess pa);
	void visitReference(Reference r);
	void visitReferenceable(Referenceable r);
	void visitRoot(Root r);
	void visitRunTimeTypeAccess(RunTimeTypeAccess a);
	void visitSelfAccess(SelfAccess sa);
	void visitSourceEntity(SourceEntity se);
	void visitStaticTypeAccess(StaticTypeAccess sa);
	void visitStructuralEntity(StructuralEntity se);
	void visitThrowTypeAccess(ThrowTypeAccess tta);
	void visitType(Type t);
	void visitTypeAccess(TypeAccess ta);
	void visitTypeAlias(TypeAlias ta);
	void visitTypeDecorator(TypeDecorator td);
	void visitTypeParameterClass(TypeParameterClass tpc);
	void visitVariable(Variable v);
	void visitVariableAccess(VariableAccess va);
	void visitStatement(Statement st);
	void visitClone(Clone cl);
	void visitCloneInstance(CloneInstance ci);
	void visitStructuralAbstraction(StructuralAbstraction sa);
	void visitSubsystem(Subsystem s);
}
