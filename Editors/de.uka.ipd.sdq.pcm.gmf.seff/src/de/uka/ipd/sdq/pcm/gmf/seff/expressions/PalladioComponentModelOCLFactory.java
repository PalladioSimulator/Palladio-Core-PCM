/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.expressions;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * A factory for creating PalladioComponentModelOCL objects.
 *
 * @generated
 */
public class PalladioComponentModelOCLFactory {

    /**
     * Instantiates a new palladio component model ocl factory.
     *
     * @generated
     */
    private PalladioComponentModelOCLFactory() {
    }

    /**
     * Gets the expression.
     *
     * @param body the body
     * @param context the context
     * @param environment the environment
     * @return the expression
     * @generated
     */
    public static PalladioComponentModelAbstractExpression getExpression(String body, EClassifier context,
            Map environment) {
        return new Expression(body, context, environment);
    }

    /**
     * Gets the expression.
     *
     * @param body the body
     * @param context the context
     * @return the expression
     * @generated
     */
    public static PalladioComponentModelAbstractExpression getExpression(String body, EClassifier context) {
        return getExpression(body, context, Collections.EMPTY_MAP);
    }

    /**
     * The Class Expression.
     *
     * @generated
     */
    private static class Expression extends PalladioComponentModelAbstractExpression {
        
        /** The query ref. @generated */
        private WeakReference queryRef;

        /** The ocl instance. @generated */
        private final org.eclipse.ocl.ecore.OCL oclInstance;

        /**
         * Instantiates a new expression.
         *
         * @param body the body
         * @param context the context
         * @param environment the environment
         * @generated
         */
        public Expression(String body, EClassifier context, Map environment) {
            super(body, context);
            oclInstance = org.eclipse.ocl.ecore.OCL.newInstance();
            initCustomEnv(oclInstance.getEnvironment(), environment);
        }

        /**
         * Gets the query.
         *
         * @return the query
         * @generated
         */
        protected Query getQuery() {
            Query oclQuery = null;
            if (this.queryRef != null) {
                oclQuery = (Query) this.queryRef.get();
            }
            if (oclQuery == null) {
                OCLHelper oclHelper = oclInstance.createOCLHelper();
                oclHelper.setContext(context());
                try {
                    OCLExpression oclExpression = oclHelper.createQuery(body());
                    oclQuery = oclInstance.createQuery(oclExpression);
                    this.queryRef = new WeakReference(oclQuery);
                    setStatus(IStatus.OK, null, null);
                } catch (ParserException e) {
                    setStatus(IStatus.ERROR, e.getMessage(), e);
                }
            }
            return oclQuery;
        }

        /**
         * Do evaluate.
         *
         * @param context the context
         * @param env the env
         * @return the object
         * @generated
         */
        protected Object doEvaluate(Object context, Map env) {
            Query oclQuery = getQuery();
            if (oclQuery == null) {
                return null;
            }
            EvaluationEnvironment evalEnv = oclQuery.getEvaluationEnvironment();
            // init environment
            for (Iterator it = env.entrySet().iterator(); it.hasNext();) {
                Map.Entry nextEntry = (Map.Entry) it.next();
                evalEnv.replace((String) nextEntry.getKey(), nextEntry.getValue());
            }
            try {
                initExtentMap(context);
                Object result = oclQuery.evaluate(context);
                return (result != oclInstance.getEnvironment().getOCLStandardLibrary().getOclInvalid()) ? result : null;
            } finally {
                evalEnv.clear();
                oclQuery.getExtentMap().clear();
            }
        }

        /**
         * Inits the extent map.
         *
         * @param context the context
         * @generated
         */
        private void initExtentMap(Object context) {
            if (!getStatus().isOK() || context == null) {
                return;
            }
            final Query queryToInit = getQuery();
            final Object extentContext = context;
            queryToInit.getExtentMap().clear();
            if (queryToInit.queryText() != null
                    && queryToInit.queryText().indexOf(PredefinedType.ALL_INSTANCES_NAME) >= 0) {
                AbstractVisitor visitior = new AbstractVisitor() {

                    private boolean usesAllInstances = false;

                    public Object visitOperationCallExp(OperationCallExp oc) {
                        if (!usesAllInstances) {
                            usesAllInstances = PredefinedType.ALL_INSTANCES == oc.getOperationCode();
                            if (usesAllInstances) {
                                queryToInit.getExtentMap().putAll(
                                        oclInstance.getEvaluationEnvironment().createExtentMap(extentContext));
                            }
                        }
                        return super.visitOperationCallExp(oc);
                    }
                };
                queryToInit.getExpression().accept(visitior);
            }
        }

        /**
         * Inits the custom env.
         *
         * @param ecoreEnv the ecore env
         * @param environment the environment
         * @generated
         */
        private static void initCustomEnv(Environment ecoreEnv, Map environment) {
            for (Iterator it = environment.keySet().iterator(); it.hasNext();) {
                String varName = (String) it.next();
                EClassifier varType = (EClassifier) environment.get(varName);
                ecoreEnv.addElement(varName, createVar(ecoreEnv, varName, varType), false);
            }
        }

        /**
         * Creates the var.
         *
         * @param ecoreEnv the ecore env
         * @param name the name
         * @param type the type
         * @return the variable
         * @generated
         */
        private static Variable createVar(Environment ecoreEnv, String name, EClassifier type) {
            Variable var = EcoreFactory.eINSTANCE.createVariable();
            var.setName(name);
            var.setType(ecoreEnv.getUMLReflection().getOCLType(type));
            return var;
        }
    }
}
