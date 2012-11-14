/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.expressions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;

/**
 * The Class PalladioComponentModelAbstractExpression.
 *
 * @generated
 */
public abstract class PalladioComponentModelAbstractExpression {
    
    /** The status. @generated */
    private IStatus status = Status.OK_STATUS;

    /**
     * Instantiates a new palladio component model abstract expression.
     *
     * @param body the body
     * @param context the context
     * @generated
     */
    protected PalladioComponentModelAbstractExpression(String body, EClassifier context) {
        myBody = body;
        myContext = context;
    }

    /**
     * Sets the status.
     *
     * @param severity the severity
     * @param message the message
     * @param throwable the throwable
     * @generated
     */
    protected void setStatus(int severity, String message, Throwable throwable) {
        String pluginID = PalladioComponentModelSeffDiagramEditorPlugin.ID;
        this.status = new Status(severity, pluginID, -1, (message != null) ? message : "", throwable); //$NON-NLS-1$
        if (!this.status.isOK()) {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Expression problem:" + message + "body:" + body(), throwable); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * Do evaluate.
     *
     * @param context the context
     * @param env the env
     * @return the object
     * @generated
     */
    protected abstract Object doEvaluate(Object context, Map env);

    /**
     * Evaluate.
     *
     * @param context the context
     * @return the object
     * @generated
     */
    public Object evaluate(Object context) {
        return evaluate(context, Collections.EMPTY_MAP);
    }

    /**
     * Evaluate.
     *
     * @param context the context
     * @param env the env
     * @return the object
     * @generated
     */
    public Object evaluate(Object context, Map env) {
        if (context().isInstance(context)) {
            try {
                return doEvaluate(context, env);
            } catch (Exception e) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                        "Expression evaluation failure: " + body(), e); //$NON-NLS-1$
            }
        }
        return null;
    }

    /**
     * Expression may return number value which is not directly compatible with feature type (e.g.
     * Double when Integer is expected), or EEnumLiteral meta-object when literal instance is
     * expected
     *
     * @param value the value
     * @param targetType the target type
     * @return the object
     * @generated
     */
    public static Object performCast(Object value, EDataType targetType) {
        if (targetType instanceof EEnum) {
            if (value instanceof EEnumLiteral) {
                EEnumLiteral literal = (EEnumLiteral) value;
                return (literal.getInstance() != null) ? literal.getInstance() : literal;
            }
        }
        if (false == value instanceof Number || targetType == null || targetType.getInstanceClass() == null) {
            return value;
        }
        Class targetClass = targetType.getInstanceClass();
        Number num = (Number) value;
        Class valClass = value.getClass();
        Class targetWrapperClass = targetClass;
        if (targetClass.isPrimitive()) {
            targetWrapperClass = EcoreUtil.wrapperClassFor(targetClass);
        }
        if (valClass.equals(targetWrapperClass)) {
            return value;
        }
        if (Number.class.isAssignableFrom(targetWrapperClass)) {
            if (targetWrapperClass.equals(Byte.class))
                return new Byte(num.byteValue());
            if (targetWrapperClass.equals(Integer.class))
                return new Integer(num.intValue());
            if (targetWrapperClass.equals(Short.class))
                return new Short(num.shortValue());
            if (targetWrapperClass.equals(Long.class))
                return new Long(num.longValue());
            if (targetWrapperClass.equals(BigInteger.class))
                return BigInteger.valueOf(num.longValue());
            if (targetWrapperClass.equals(Float.class))
                return new Float(num.floatValue());
            if (targetWrapperClass.equals(Double.class))
                return new Double(num.doubleValue());
            if (targetWrapperClass.equals(BigDecimal.class))
                return new BigDecimal(num.doubleValue());
        }
        return value;
    }

    /**
     * Gets the status.
     *
     * @return the status
     * @generated
     */
    public IStatus getStatus() {
        return status;
    }

    /** The my body. @generated */
    private final String myBody;

    /**
     * Body.
     *
     * @return the string
     * @generated
     */
    public String body() {
        return myBody;
    }

    /** The my context. @generated */
    private final EClassifier myContext;

    /**
     * Context.
     *
     * @return the e classifier
     * @generated
     */
    public EClassifier context() {
        return myContext;
    }
}
