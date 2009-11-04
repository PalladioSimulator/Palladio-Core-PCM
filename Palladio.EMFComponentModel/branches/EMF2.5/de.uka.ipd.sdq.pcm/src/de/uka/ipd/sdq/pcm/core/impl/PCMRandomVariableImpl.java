/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.impl;

import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.util.CoreValidator;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExParser;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.impl.RandomVariableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Random Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PCMRandomVariableImpl extends RandomVariableImpl implements PCMRandomVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMRandomVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PCM_RANDOM_VARIABLE;
	}

	/**
	 * The cached OCL expression body for the '{@link #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specification Must Not Be NULL</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.specification.oclIsUndefined() and self.specification <> ''";
	/**
	 * The cached OCL invariant for the '{@link #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specification Must Not Be NULL</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SpecificationMustNotBeNULL(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(CorePackage.Literals.PCM_RANDOM_VARIABLE);
			try {
				SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CoreValidator.DIAGNOSTIC_SOURCE,
						 CoreValidator.PCM_RANDOM_VARIABLE__SPECIFICATION_MUST_NOT_BE_NULL,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SpecificationMustNotBeNULL", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

	@Override
	public Expression basicGetExpression() {
		if (specification == null)
			return null;
		MyPCMStoExLexer lexer = new MyPCMStoExLexer(new ANTLRStringStream(this.getSpecification()));
		MyPCMStoExParser parser = new MyPCMStoExParser(new CommonTokenStream(lexer));
		Expression e;
		try {
			e = parser.expression();
		} catch (RecognitionException e1) {
			return null;
		}
		if (parser.hasErrors())
			return null;
		return e;
	}
	
} //PCMRandomVariableImpl
