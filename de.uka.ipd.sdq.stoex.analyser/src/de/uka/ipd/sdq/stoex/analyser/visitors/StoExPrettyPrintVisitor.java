package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import de.uka.ipd.sdq.probfunction.print.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

public class StoExPrettyPrintVisitor extends StoexSwitch<StringBuilder> {

    protected static final int AVERAGE_STOEX_SIZE = 30;
    protected final StringBuilder resultBuilder = new StringBuilder(AVERAGE_STOEX_SIZE);
    protected final static DecimalFormat df = new DecimalFormat("#0.0###########", new DecimalFormatSymbols(Locale.US));


    @Override
    public StringBuilder caseBoolLiteral(final BoolLiteral object) {
        resultBuilder.append(object.isValue() ? "true" : "false");
        return resultBuilder;
    }

    @Override
    public StringBuilder casePowerExpression(final PowerExpression object) {
        doSwitch(object.getBase());
        resultBuilder.append(" ^ ");
        doSwitch(object.getExponent());
        return resultBuilder;
    }

    @Override
    public StringBuilder caseStringLiteral(final StringLiteral object) {
        resultBuilder.append("\"");
        resultBuilder.append(object.getValue());
        resultBuilder.append("\"");
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseCompareExpression(org.palladiosimulator.pcm.core.stochastics.CompareExpression)
     */
    @Override
    public StringBuilder caseCompareExpression(final CompareExpression object) {
        String op;
        switch(object.getOperation())
        {
        case EQUALS:
            op = " == ";
            break;
        case GREATER:
            op = " > ";
            break;
        case GREATEREQUAL:
            op = " >= ";
            break;
        case LESS:
            op = " < ";
            break;
        case LESSEQUAL:
            op = " <= ";
            break;
        case NOTEQUAL:
            op = " <> ";
            break;
        default:
            throw new RuntimeException("Unsupported StoEx comparison detected.");
        }
        doSwitch(object.getLeft());
        resultBuilder.append(op);
        doSwitch(object.getRight());
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseDoubleLiteral(org.palladiosimulator.pcm.core.stochastics.DoubleLiteral)
     */
    @Override
    public StringBuilder caseDoubleLiteral(final DoubleLiteral object) {
        resultBuilder.append(df.format(object.getValue()));
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseIntLiteral(org.palladiosimulator.pcm.core.stochastics.IntLiteral)
     */
    @Override
    public StringBuilder caseIntLiteral(final IntLiteral object) {
        resultBuilder.append(Integer.toString(object.getValue()));
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseParantesis(org.palladiosimulator.pcm.core.stochastics.Parantesis)
     */
    @Override
    public StringBuilder caseParenthesis(final Parenthesis object) {
        resultBuilder.append("(");
        doSwitch(object.getInnerExpression());
        resultBuilder.append(")");
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseProbabilityFunctionLiteral(org.palladiosimulator.pcm.core.stochastics.ProbabilityFunctionLiteral)
     */
    @Override
    public StringBuilder caseProbabilityFunctionLiteral(final ProbabilityFunctionLiteral object) {
        new ProbFunctionPrettyPrint(resultBuilder).doSwitch(object.getFunction_ProbabilityFunctionLiteral());
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseProductExpression(org.palladiosimulator.pcm.core.stochastics.ProductExpression)
     */
    @Override
    public StringBuilder caseProductExpression(final ProductExpression object) {
        String op;
        switch(object.getOperation())
        {
        case MULT:
            op = " * ";
            break;
        case MOD:
            op = " % ";
            break;
        case DIV:
            op = " / ";
            break;
        default:
            throw new RuntimeException("Unknown operator found in StoEx!");
        }
        doSwitch(object.getLeft());
        resultBuilder.append(op);
        doSwitch(object.getRight());
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseTermExpression(org.palladiosimulator.pcm.core.stochastics.TermExpression)
     */
    @Override
    public StringBuilder caseTermExpression(final TermExpression object) {
        String op;
        switch(object.getOperation())
        {
        case ADD:
            op = " + ";
            break;
        case SUB:
            op = " - ";
            break;
        default:
            throw new RuntimeException("Unknown operator found in StoEx!");
        }
        doSwitch(object.getLeft());
        resultBuilder.append(op);
        doSwitch(object.getRight());
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.parameter.util.ParameterSwitch#caseNamespaceReference(org.palladiosimulator.pcm.parameter.NamespaceReference)
     */
    @Override
    public StringBuilder caseNamespaceReference(final NamespaceReference object) {
        resultBuilder.append(object.getReferenceName());
        resultBuilder.append(".");
        doSwitch(object.getInnerReference_NamespaceReference());
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.parameter.util.ParameterSwitch#caseVariableReference(org.palladiosimulator.pcm.parameter.VariableReference)
     */
    @Override
    public StringBuilder caseVariableReference(final VariableReference object) {
        resultBuilder.append(object.getReferenceName());
        return resultBuilder;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcm.core.stochastics.util.StochasticsSwitch#caseVariable(org.palladiosimulator.pcm.core.stochastics.Variable)
     */
    @Override
    public StringBuilder caseVariable(final Variable object) {
        doSwitch(object.getId_Variable());
        return resultBuilder;
    }

    @Override
    public StringBuilder caseBooleanOperatorExpression(final BooleanOperatorExpression object) {
        this.doSwitch(object.getLeft());
        resultBuilder.append(" ");
        resultBuilder.append(object.getOperation().getLiteral());
        resultBuilder.append(" ");
        this.doSwitch(object.getRight());
        return resultBuilder;
    }

    @Override
    public StringBuilder caseNegativeExpression(final NegativeExpression object) {
        resultBuilder.append("-");
        this.doSwitch(object.getInner());
        return resultBuilder;
    }

    @Override
    public StringBuilder caseNotExpression(final NotExpression object) {
        resultBuilder.append("NOT ");
        this.doSwitch(object.getInner());
        return resultBuilder;
    }

    @Override
    public StringBuilder caseFunctionLiteral(final FunctionLiteral object) {
        resultBuilder.append(object.getId());
        resultBuilder.append("(");

        if (object.getParameters_FunctionLiteral().size() > 0) {
            for (final Expression parameter : object.getParameters_FunctionLiteral()) {
                this.doSwitch(parameter);
                resultBuilder.append(", ");
            }
            resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());
        }
        resultBuilder.append(")");

        return resultBuilder;
    }

    @Override
    public StringBuilder caseIfElseExpression(final IfElseExpression object) {
        this.doSwitch(object.getConditionExpression());
        resultBuilder.append(" ? ");
        this.doSwitch(object.getIfExpression());
        resultBuilder.append(" : ");
        this.doSwitch(object.getElseExpression());
        return  resultBuilder;
    }

}
