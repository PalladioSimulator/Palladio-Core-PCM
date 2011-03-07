/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package de.uka.ipd.sdq.workflow.mdsd.emf.qvto.internal;

// Copied from QVT-O Plugin to enable trace output
// Remove this in future QVT-O versions when there is a
// public API to retrieve the trace

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.Messages;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerKernel;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.evaluator.InternalEvaluator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModelInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModelParameterHelper;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtAssertionFailed;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtInterruptedExecutionException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtStackOverFlowError;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.osgi.util.NLS;

/**
 * A utility class that enables to execute existing transformation in the
 * specified execution context.
 * 
 * @since 2.0
 */
public final class TransformationExecutor {

	/*
	 * TODO - Support execution with workspace located meta-model.ecore files
	 * via additional settings to this class
	 */

	private URI fURI;
	private CompiledUnit fCompiledUnit;
	private QvtCompilerKernel fCompilerKernel;
	private ExecutionDiagnostic fLoadDiagnostic;
	private OperationalTransformation fTransformation;
	private Trace trace;

	/**
	 * Constructs the executor for the given transformation URI.
	 * <p>
	 * No attempt to resolve and load the transformation is done at this step
	 * 
	 * @param uri
	 *            the URI of an existing transformation
	 */
	public TransformationExecutor(URI uri) {
		if (uri == null) {
			throw new IllegalArgumentException("null transformation URI"); //$NON-NLS-1$
		}

		fURI = uri;
	}

	/**
	 * Attempts to load the transformation referred by this executor and checks
	 * if it is valid for execution.
	 * <p>
	 * <b>Remark:</b></br> Only the first performs the actual transformation
	 * loading, subsequent calls to this method will return the existing
	 * diagnostic.
	 * 
	 * @return the diagnostic indicating possible problems of the load action
	 */
	public Diagnostic loadTransformation() {
		if (fLoadDiagnostic == null) {
			doLoad();
		}
		return fLoadDiagnostic;
	}

	/**
	 * Executes the transformation referred by this executor using the given
	 * model parameters and execution context.
	 * 
	 * @param executionContext
	 *            the context object keeping the execution environment details
	 * @param modelParameters
	 *            the actual model arguments to the transformation
	 * 
	 * @return the diagnostic object indicating the execution result status,
	 *         also keeping the details of possible problems
	 * @throws IllegalArgumentException
	 *             if the context or any of the model parameters is
	 *             <code>null</code>
	 */
	public ExecutionDiagnostic execute(ExecutionContext executionContext,
			ModelExtent... modelParameters) {
		// Java API check for nulls etc.
		if (executionContext == null) {
			throw new IllegalArgumentException();
		}
		checkLegalModelParams(modelParameters);

		// ensure transformation unit is loaded
		loadTransformation();

		// check if we have successfully loaded the transformation unit
		if (!isSuccess(fLoadDiagnostic)) {
			return fLoadDiagnostic;
		}

		try {
			return doExecute(modelParameters,
					createInternalContext(executionContext));
		} catch (QvtRuntimeException e) {
			return createExecutionFailure(e);
		}
	}

	private ExecutionDiagnostic doExecute(ModelExtent[] args, IContext context) {
		QvtOperationalEnvFactory factory = getEnvironmentFactory();
		QvtOperationalEvaluationEnv evaluationEnv = factory
				.createEvaluationEnvironment(context, null);

		ExecutionDiagnostic modelParamsDiagnostic = initArguments(
				evaluationEnv, fTransformation, args);
		if (modelParamsDiagnostic.getSeverity() != Diagnostic.OK) {
			return modelParamsDiagnostic;
		}

		QvtOperationalFileEnv rootEnv = factory.createEnvironment(fCompiledUnit
				.getURI(), fCompilerKernel);
		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> evaluator = factory
				.createEvaluationVisitor(rootEnv, evaluationEnv, null);

		// perform the actual execution
		assert evaluator instanceof InternalEvaluator : "expecting InternalEvaluator implementation"; //$NON-NLS-1$
		InternalEvaluator rawEvaluator = (InternalEvaluator) evaluator;

		rawEvaluator.execute(fTransformation);

		// instantiate trace model and pass it to transformation evaluation
		// TODO: traces not involved yet, as it is not part of the API,
		// provide an option to serialize to a resource
		this.trace =
		 evaluationEnv.getAdapter(InternalEvaluationEnv.class).getTraces();

		// unpack the internal extents into the passed model parameters
		List<Object> resultArgs = evaluationEnv.getOperationArgs();
		int i = 0;
		for (Object nextResultArg : resultArgs) {
			ModelInstance modelInstance = (ModelInstance) nextResultArg;
			ModelParameterExtent extent = modelInstance.getExtent();

			List<EObject> allRootElements = extent.getContents()
					.getAllRootElements();
			try {
				args[i++].setContents(allRootElements);
			} catch (UnsupportedOperationException e) {
				return new ExecutionDiagnostic(Diagnostic.ERROR,
						ExecutionDiagnostic.MODEL_PARAMETER_MISMATCH, NLS
								.bind(Messages.ReadOnlyExtentModificationError,
										i - 1));
			}
		}

		return ExecutionDiagnostic.OK_INSTANCE;
	}

	public Trace getLastTrace() {
		return trace;
	}
	
	private void doLoad() {
		fLoadDiagnostic = ExecutionDiagnostic.OK_INSTANCE;

		UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(fURI);
		if (unit == null) {
			fLoadDiagnostic = new ExecutionDiagnostic(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.UnitNotFoundError, fURI));
			return;
		}

		QVTOCompiler compiler = new QVTOCompiler(unit.getResolver());
		try {
			fCompiledUnit = compiler.compile(unit, null, null);
			fCompilerKernel = compiler.getKernel();

			fLoadDiagnostic = createCompilationDiagnostic(fCompiledUnit);

		} catch (MdaException e) {
			fLoadDiagnostic = new ExecutionDiagnostic(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.FailedToCompileUnitError, fURI));

			fLoadDiagnostic.merge(BasicDiagnostic.toDiagnostic(e));
		}

		if (fCompiledUnit != null
				&& fLoadDiagnostic.getSeverity() == Diagnostic.OK) {
			fTransformation = getTransformation();
			if (fTransformation == null) {
				fLoadDiagnostic = new ExecutionDiagnostic(Diagnostic.ERROR,
						ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS
								.bind(Messages.NotTransformationInUnitError,
										fURI));
			}

			ExecutionDiagnostic validForExecution = checkIsExecutable(fTransformation);
			if (validForExecution.getSeverity() != Diagnostic.OK) {
				fLoadDiagnostic = validForExecution;
			}
		}
	}

	private ExecutionDiagnostic initArguments(
			QvtOperationalEvaluationEnv evalEnv,
			OperationalTransformation transformationModel, ModelExtent[] args) {

		EList<ModelParameter> modelParameters = transformationModel
				.getModelParameter();
		if (modelParameters.size() != args.length) {
			return new ExecutionDiagnostic(Diagnostic.ERROR,
					ExecutionDiagnostic.MODEL_PARAMETER_MISMATCH, NLS.bind(
							Messages.InvalidModelParameterCountError,
							args.length, modelParameters.size()));
		}

		ExecutionDiagnostic result = ExecutionDiagnostic.OK_INSTANCE;
		List<ModelParameterExtent> extents = new ArrayList<ModelParameterExtent>(
				args.length);

		int argCount = 0;
		for (ModelParameter modelParam : modelParameters) {
			ModelParameterExtent nextExtent;
			ModelExtent nextArg = args[argCount++];

			if (modelParam.getKind() != org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
				nextExtent = new ModelParameterExtent(nextArg.getContents(), null, modelParam);
			} else {
				nextExtent = new ModelParameterExtent(null);
			}

			extents.add(nextExtent);
		}

		List<ModelInstance> modelArgs = ModelParameterHelper
				.createModelArguments(transformationModel, extents);
		evalEnv.getOperationArgs().addAll(modelArgs);

		return result;
	}

	private static ExecutionDiagnostic checkIsExecutable(
			OperationalTransformation transformation) {
		EList<EOperation> operations = transformation.getEOperations();
		for (EOperation oper : operations) {
			if (oper instanceof ImperativeOperation
					&& QvtOperationalEnv.MAIN.equals(oper.getName())) {
				return ExecutionDiagnostic.OK_INSTANCE;
			}
		}

		return new ExecutionDiagnostic(Diagnostic.ERROR,
				ExecutionDiagnostic.VALIDATION, NLS.bind(
						Messages.NoTransformationEntryPointError,
						transformation.getName()));
	}

	private OperationalTransformation getTransformation() {
		List<Module> allModules = fCompiledUnit.getModules();
		for (Module module : allModules) {
			if (module instanceof OperationalTransformation) {
				return (OperationalTransformation) module;
			}
		}

		return null;
	}

	private QvtOperationalEnvFactory getEnvironmentFactory() {
		return new QvtOperationalEnvFactory();
	}

	private static ExecutionDiagnostic createExecutionFailure(
			QvtRuntimeException qvtRuntimeException) {
		int code = 0;
		int severity = Diagnostic.ERROR;
		String message = qvtRuntimeException.getLocalizedMessage();
		Object[] data = null;

		if (qvtRuntimeException instanceof QvtAssertionFailed) {
			code = ExecutionDiagnostic.FATAL_ASSERTION;
		} else if (qvtRuntimeException instanceof QvtInterruptedExecutionException) {
			code = ExecutionDiagnostic.USER_INTERRUPTED;
			severity = Diagnostic.CANCEL;
		} else {
			code = ExecutionDiagnostic.EXCEPTION_THROWN;
			if (qvtRuntimeException instanceof QvtStackOverFlowError == false) {
				data = new Object[] { qvtRuntimeException };
			} else {
				message = Messages.StackTraceOverFlowError;
			}
		}

		if (message == null) {
			message = NLS.bind(Messages.QVTRuntimeExceptionCaught,
					qvtRuntimeException.getClass().getName());
		}
		ExecutionDiagnostic diagnostic = new ExecutionDiagnostic(severity,
				code, message, data);
		diagnostic.setStackTrace(qvtRuntimeException.getQvtStackTrace());
		return diagnostic;
	}

	private void checkLegalModelParams(ModelExtent[] extents)
			throws IllegalArgumentException {
		if (extents == null) {
			throw new IllegalArgumentException("Null model parameters"); //$NON-NLS-1$
		}

		for (int i = 0; i < extents.length; i++) {
			if (extents[i] == null) {
				throw new IllegalArgumentException(
						"Null model parameter[" + i + "]"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	private static ExecutionDiagnostic createCompilationDiagnostic(
			CompiledUnit compiledUnit) {
		List<QvtMessage> errors = compiledUnit.getErrors();
		if (errors.isEmpty()) {
			return ExecutionDiagnostic.OK_INSTANCE;
		}

		URI uri = compiledUnit.getURI();
		ExecutionDiagnostic mainDiagnostic = new ExecutionDiagnostic(
				Diagnostic.ERROR, ExecutionDiagnostic.VALIDATION, NLS.bind(
						Messages.CompilationErrorsFoundInUnit, uri.toString()));

		for (QvtMessage message : errors) {
			mainDiagnostic.add(createQVTErrorMessageDiagnostic(message, uri));
		}

		return mainDiagnostic;
	}

	private static Diagnostic createQVTErrorMessageDiagnostic(QvtMessage msg,
			URI uri) {
		String source = uri.toString();
		String message = msg.getMessage();
		// add the line number info if any
		if (msg.getLineNum() >= 0) {
			message = message + " (at:" + msg.getLineNum() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ 
		}

		return new BasicDiagnostic(Diagnostic.ERROR, source, 0, message, null);
	}

	private static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity == Diagnostic.OK || severity == Diagnostic.WARNING
				|| severity == Diagnostic.INFO;
	}

	private static IContext createInternalContext(
			ExecutionContext executionContext) {
		Context ctx = new Context();
		ctx.setLog(executionContext.getLog());
		ctx.setMonitor(executionContext.getMonitor());

		for (String key : executionContext.getConfigPropertyNames()) {
			Object value = executionContext.getConfigProperty(key);
			ctx.setConfigProperty(key, value);
		}

		return ctx;
	}

	@Override
	public String toString() {
		return "QVTO-Executor: " + fURI; //$NON-NLS-1$
	}
}
