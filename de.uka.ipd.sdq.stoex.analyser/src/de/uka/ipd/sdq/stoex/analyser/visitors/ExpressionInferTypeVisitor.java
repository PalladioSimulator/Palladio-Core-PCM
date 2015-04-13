package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.probfunction.ProbfunctionHelper;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

/**
 * A visitor for stochastic expression, which infers the types before evaluating these expressions.
 *
 * For example, it infers the result type of an operation add on a INT and a INT_PMF to a INT_PMF,
 * as the add operation with a constant shifts the INT_PMF.
 *
 * It stores the inferred types for each expression in a hashmap, which can be retrieved via
 * getTypeAnnotation().
 *
 * @author koziolek
 */
public class ExpressionInferTypeVisitor extends StoexSwitch<Object> {

    private static final Logger LOGGER = Logger.getLogger(ExpressionInferTypeVisitor.class.getName());

    private HashMap<Expression, TypeEnum> typeAnnotation = new HashMap<Expression, TypeEnum>();

    /**
     * Result of a compare expression is always of type BOOL_PMF.
     */
    @Override
    public Object caseCompareExpression(CompareExpression expr) {
        doSwitch(expr.getLeft());
        doSwitch(expr.getRight());

        typeAnnotation.put(expr, TypeEnum.BOOL_PMF);
        return expr;
    }

    /**
     * Result of a product expression can be of type INT, DOUBLE, INT_PMF, DOUBLE_PMF, ANY_PMF,
     * DOUBLE_PDF depending on the operands.
     */
    @Override
    public Object caseProductExpression(ProductExpression expr) {
        TypeEnum leftType = getTypeOfChild(expr.getLeft());
        TypeEnum rightType = getTypeOfChild(expr.getRight());

        ProductOperations op = expr.getOperation();
        if (op.getName().equals("MULT") || op.getName().equals("DIV")) {
            // may result in ints or doubles
            inferIntAndDouble(expr, leftType, rightType);
        } else if (op.getName().equals("MOD")) {
            this.typeAnnotation.put(expr, TypeEnum.INT_PMF);
        } else {
            throw new UnsupportedOperationException();
            // LOGGER.debug(expr.getOperation().toString());
        }

        return expr;
    }

    /**
     * Result of a power expression so far only be of type DOUBLE, as the power operation is only
     * allowed on NUMBERs, not PMFs.
     */
    @Override
    public Object casePowerExpression(PowerExpression expr) {
        doSwitch(expr.getBase());
        doSwitch(expr.getExponent());

        TypeEnum baseType = getType(expr.getBase());
        TypeEnum exponentType = getType(expr.getExponent());

        if (isNumeric(baseType) && isNumeric(exponentType)) {
            typeAnnotation.put(expr, TypeEnum.DOUBLE);
        } else {
            // this is not right, as the outcome could also be a probability function.
            // However, those are not supported yet for the power expression, so there will be an
            // error raised later.
            typeAnnotation.put(expr, TypeEnum.ANY);
            // throw new
            // UnsupportedOperationException("Power expression is not supported fo non-numeric base or exponent");
        }

        return expr;
    }

    @Override
    public Object caseNegativeExpression(NegativeExpression object) {
        this.doSwitch(object.getInner());
        typeAnnotation.put(object, typeAnnotation.get(object.getInner()));
        return object;
    }

    @Override
    public Object caseBooleanOperatorExpression(BooleanOperatorExpression object) {
        doSwitch(object.getLeft());
        doSwitch(object.getRight());

        typeAnnotation.put(object, TypeEnum.BOOL);
        return object;
    }

    @Override
    public Object caseNotExpression(NotExpression object) {
        this.doSwitch(object.getInner());
        typeAnnotation.put(object, TypeEnum.BOOL);
        return object;
    }

    /**
     * Result of a term expression can be of type INT, DOUBLE, INT_PMF, DOUBLE_PMF, ANY_PMF,
     * DOUBLE_PDF depending on the operands.
     */
    @Override
    public Object caseTermExpression(TermExpression expr) {
        TypeEnum leftType = getTypeOfChild(expr.getLeft());
        TypeEnum rightType = getTypeOfChild(expr.getRight());

        TermOperations op = expr.getOperation();
        if (op.getName().equals("ADD") || op.getName().equals("SUB")) {
            // may result in ints or doubles
            inferIntAndDouble(expr, leftType, rightType);
        } else {
            throw new UnsupportedOperationException();
        }
        LOGGER.debug(expr.getOperation().toString());

        return expr;
    }

    /**
     * Infers the type of a probability function literal.
     */
    @Override
    public Object caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral pfl) {
        ProbabilityFunction pf = pfl.getFunction_ProbabilityFunctionLiteral();
        if (pf instanceof ProbabilityMassFunction) {
            ProbabilityMassFunction pmf = (ProbabilityMassFunction) pf;
            Sample firstSample = pmf.getSamples().get(0);
            Object value = firstSample.getValue();
            if (value instanceof Integer) {
                typeAnnotation.put(pfl, TypeEnum.INT_PMF);
            } else if (value instanceof Double) {
                typeAnnotation.put(pfl, TypeEnum.DOUBLE_PMF);
            } else if (value instanceof String) {
                typeAnnotation.put(pfl, TypeEnum.ENUM_PMF);
            } else if (value instanceof Boolean) {
                typeAnnotation.put(pfl, TypeEnum.BOOL_PMF);
            } else {
                LOGGER.error("Could not determine type of PMF!");
            }
        } else if (pf instanceof ProbabilityDensityFunction) {
            typeAnnotation.put(pfl, TypeEnum.DOUBLE_PDF);
        } else {
            LOGGER.error("Could not determine type of ProbabilityFunctionLiteral!");
        }
        return pfl;
    }

    /**
     * Infers the type of an int literal to INT.
     */
    @Override
    public Object caseIntLiteral(IntLiteral il) {
        typeAnnotation.put(il, TypeEnum.INT);
        return il;
    }

    /**
     * Infers the type of an double literal to DOUBLE.
     */
    @Override
    public Object caseDoubleLiteral(DoubleLiteral dl) {
        typeAnnotation.put(dl, TypeEnum.DOUBLE);
        return dl;
    }

    /**
     * Infers the type of a variable depending on its characterisation type. Infers VALUE, DATATYPE,
     * STRUCUTURE to ANY_PMF, while NUMBER_OF_ELEMENTS and BYTESIZE to INT_PMF.
     *
     * If later in the {@link ExpressionSolveVisitor} the result is solved and the supposed INT_PMF
     * turns out to be something else, an exception is thrown. If the behaviour is changed here, the
     * exception handling in {@link ExpressionSolveVisitor#extractIPMFFromLiteral} needs to be
     * adjusted, too.
     */
    @Override
    public Object caseVariable(Variable var) {
        // LOGGER.debug("Found variable: " + var.getId_Variable());
        if (var instanceof CharacterisedVariable) {
            CharacterisedVariable chVar = (CharacterisedVariable) var;
            VariableCharacterisationType chType = chVar.getCharacterisationType();
            if (chType == VariableCharacterisationType.VALUE || chType == VariableCharacterisationType.TYPE
                    || chType == VariableCharacterisationType.STRUCTURE) {
                typeAnnotation.put(var, TypeEnum.ANY_PMF);
                // LOGGER.debug("Inferred to ENUM_PMF");
            } else if (chType == VariableCharacterisationType.NUMBER_OF_ELEMENTS
                    || chType == VariableCharacterisationType.BYTESIZE) {
                typeAnnotation.put(var, TypeEnum.INT_PMF);
                // LOGGER.debug("Inferred to INT_PMF");
            }
        }
        return var;
    }

    /**
     * Infers the type of an bool literal to BOOL.
     */
    @Override
    public Object caseBoolLiteral(BoolLiteral bl) {
        typeAnnotation.put(bl, TypeEnum.BOOL);
        return bl;
    }

    /**
     * Infers the type of an parenthesis to its inner encapsulated expression.
     */
    @Override
    public Object caseParenthesis(Parenthesis parenthesis) {
        TypeEnum type = getTypeOfChild(parenthesis.getInnerExpression());
        typeAnnotation.put(parenthesis, type);
        return parenthesis;
    }

    /**
     * @param expr
     * @param leftType
     * @param rightType
     */
    private void inferIntAndDouble(Expression expr, TypeEnum leftType, TypeEnum rightType) {

        if (leftType == null || rightType == null) {
            return;
        }

        if (leftType == TypeEnum.INT && rightType == TypeEnum.INT) {
            typeAnnotation.put(expr, TypeEnum.INT);
        } else if (isIntPMF(leftType) && isIntPMF(rightType)) {
            typeAnnotation.put(expr, TypeEnum.INT_PMF);
        } else if (isNumeric(leftType) && isNumeric(rightType)) {
            typeAnnotation.put(expr, TypeEnum.DOUBLE);
        } else if (isDoubleIntPMF(leftType) && isDoubleIntPMF(rightType)) {
            typeAnnotation.put(expr, TypeEnum.DOUBLE_PMF);
        } else if (isDoubleIntAnyPMF(leftType) && isDoubleIntAnyPMF(rightType)) {
            typeAnnotation.put(expr, TypeEnum.ANY_PMF);
        } else if (isDoubleIntPDF(leftType) && isDoubleIntPDF(rightType)) {
            typeAnnotation.put(expr, TypeEnum.DOUBLE_PDF);
        } else {
            LOGGER.error("Type inference of " + leftType.name() + " and " + rightType.name()
                    + " failed. Incompatible types for operation. Will try to continue.");
        }
    }

    /**
     * @param expr
     * @return
     */
    private TypeEnum getTypeOfChild(Expression expr) {
        Expression childExpr = (Expression) doSwitch(expr);
        TypeEnum type = typeAnnotation.get(childExpr);
        // if (type == null) {
        // throw new TypeInferenceFailedException(expr);
        // }
        return type;
    }

    private boolean isIntPMF(TypeEnum type) {
        return (type == TypeEnum.INT || type == TypeEnum.INT_PMF);
    }

    protected boolean isNumeric(TypeEnum type) {
        return (type == TypeEnum.INT || type == TypeEnum.DOUBLE);
    }

    private boolean isDoubleIntPMF(TypeEnum type) {
        return (type == TypeEnum.DOUBLE || type == TypeEnum.INT || type == TypeEnum.INT_PMF || type == TypeEnum.DOUBLE_PMF);

    }

    private boolean isDoubleIntAnyPMF(TypeEnum type) {
        return (type == TypeEnum.DOUBLE || type == TypeEnum.INT || type == TypeEnum.ANY || type == TypeEnum.INT_PMF
                || type == TypeEnum.DOUBLE_PMF || type == TypeEnum.ANY_PMF);
    }

    private boolean isDoubleIntPDF(TypeEnum type) {
        return (type == TypeEnum.DOUBLE || type == TypeEnum.INT || type == TypeEnum.INT_PMF
                || type == TypeEnum.DOUBLE_PMF || type == TypeEnum.DOUBLE_PDF);
    }

    /**
     * Getter for the type annotation hashmap.
     * 
     * @return
     */
    public HashMap<Expression, TypeEnum> getTypeAnnotation() {
        return typeAnnotation;
    }

    /**
     * Setter for the type annotation hashmap.
     * 
     * @param typeAnnotation
     */
    public void setTypeAnnotation(HashMap<Expression, TypeEnum> typeAnnotation) {
        this.typeAnnotation = typeAnnotation;
    }

    /**
     * Return the inferred type of the passed expression node. The type annotation is automatically
     * stored in the Map if it has not been inferred before.
     * 
     * @param e
     *            The node whose type should be returned.
     * @return The inferred type of the expression.
     */
    public TypeEnum getType(Expression e) {
        if (!typeAnnotation.containsKey(e)) {
            doSwitch(e);
        }
        return typeAnnotation.get(e);
    }

    @Override
    public Object caseFunctionLiteral(FunctionLiteral object) {
        for (Expression e : object.getParameters_FunctionLiteral()) {
            doSwitch(e);
        }

        if (object.getId().equals(ProbfunctionHelper.UNIDOUBLE)) {
            typeAnnotation.put(object, TypeEnum.DOUBLE_PDF);
        } else if (ProbfunctionHelper.isFunctionWithTwoParameterID(object.getId())) {
            typeAnnotation.put(object, TypeEnum.DOUBLE_PDF);
        } else if (object.getId().equals(ProbfunctionHelper.EXP)) {
            typeAnnotation.put(object, TypeEnum.DOUBLE_PDF);
        } else if (object.getId().equals(ProbfunctionHelper.POIS)) {
            typeAnnotation.put(object, TypeEnum.INT_PMF);
        } else if (object.getId().equals(ProbfunctionHelper.UNIINT)) {
            typeAnnotation.put(object, TypeEnum.INT_PMF);
        } else if (object.getId().equals("Trunc")) {
            typeAnnotation.put(object, TypeEnum.INT_PMF);
        } else if (object.getId().equals("Round")) {
            typeAnnotation.put(object, TypeEnum.INT_PMF);
        } else if (object.getId().equals("Min")) {
            if (object.getParameters_FunctionLiteral().size() > 0) {
                typeAnnotation.put(object, typeAnnotation.get(object.getParameters_FunctionLiteral().get(0)));
            } else {
                typeAnnotation.put(object, TypeEnum.ANY);
            }
        } else if (object.getId().equals("Max")) {
            if (object.getParameters_FunctionLiteral().size() > 0) {
                typeAnnotation.put(object, typeAnnotation.get(object.getParameters_FunctionLiteral().get(0)));
            } else {
                typeAnnotation.put(object, TypeEnum.ANY);
            }
        } else if (object.getId().equals("MinDeviation")) {
            if (object.getParameters_FunctionLiteral().size() > 0) {
                typeAnnotation.put(object, typeAnnotation.get(object.getParameters_FunctionLiteral().get(0)));
            } else {
                typeAnnotation.put(object, TypeEnum.ANY);
            }
        } else if (object.getId().equals("MaxDeviation")) {
            if (object.getParameters_FunctionLiteral().size() > 0) {
                typeAnnotation.put(object, typeAnnotation.get(object.getParameters_FunctionLiteral().get(0)));
            } else {
                typeAnnotation.put(object, TypeEnum.ANY);
            }
        } else if (object.getId().equals(ProbfunctionHelper.BINOM)) {
            typeAnnotation.put(object, TypeEnum.INT_PMF);
        } else {
            throw new UnsupportedOperationException(this.getClass().getName() + ": Function " + object.getId()
                    + " not supported!");
        }
        return object;
    }

    @Override
    public Object caseIfElseExpression(IfElseExpression object) {
        doSwitch(object.getConditionExpression());
        doSwitch(object.getElseExpression());
        doSwitch(object.getIfExpression());

        typeAnnotation.put(object, TypeEnum.ANY);
        return object;
    }

    @Override
    public Object caseStringLiteral(StringLiteral object) {
        typeAnnotation.put(object, TypeEnum.ENUM);
        return object;
    }

}
