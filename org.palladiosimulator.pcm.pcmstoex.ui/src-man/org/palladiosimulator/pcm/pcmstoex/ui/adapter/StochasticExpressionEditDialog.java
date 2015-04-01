package org.palladiosimulator.pcm.pcmstoex.ui.adapter;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.palladiosimulator.pcm.pcmstoex.ui.contentassist.VariableContextProvider;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.exceptions.ExpectedTypeMismatchIssue;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.NonProbabilisticExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeCheckVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * This is an edit-dialog for the PCM-StoEx.
 * 
 * @author Jonas Heinisch based on work by Steffen Becker
 *
 */
@SuppressWarnings("restriction")
public class StochasticExpressionEditDialog extends TitleAreaDialog {
    /**
     * indicated the textlistener if the model has changed.
     */
    private volatile boolean modelChanged;

    /** The expected type. */
    private TypeEnum expectedType;

    /** The context. */
    protected Parameter[] context = null;

    /** The dialog title. */
    private String dialogtitle = "Edit a stochastic expression";

    /**
     * The initial input.
     */
    private String newText;

    /**
     * The embedded Editor.
     */
    private PCMStoExEditor editor;

    private boolean canceled = false;

    /**
     * Instantiates a new stochastic expression edit dialog.
     * 
     * @param parent
     *            the parent
     * @param expectedType
     *            the expected type
     */
    public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType) {
        super(parent);
        this.expectedType = expectedType;
        this.setShellStyle(SWT.RESIZE | SWT.MAX);
        this.context = new Parameter[] {};
    }

    /**
     * Instantiates a new stochastic expression edit dialog.
     * 
     * @param parent
     *            the parent
     * @param expectedType
     *            the expected type
     * @param context
     *            the context
     */
    public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType, Parameter[] context) {
        this(parent, expectedType);
        this.setHelpAvailable(true);
        this.context = context;
    }

    /**
     * Instantiates a new stochastic expression edit dialog.
     * 
     * @param parent
     *            The parent shell
     * @param expectedType
     *            The type of the expression to be entered
     * @param contextObject
     *            An EObject from which a parameter context is derived by searching for its parent
     *            SEFF and taking this SEFFs signature into account
     */
    public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType, EObject contextObject) {
        this(parent, expectedType);
        this.expectedType = expectedType;
        this.context = getContext(contextObject);
    }

    /**
     * Sets the initial expression.
     * 
     * @param ex
     *            the new initial expression
     */
    public void setInitialExpression(RandomVariable ex) {
        newText = ex.getSpecification();
    }

    /**
     * The parsed Expression of the textfield.
     * 
     * @return the parsed Expression.
     */
    public Expression getResult() {
        if (canceled) {
            return null;
        }
        return (Expression) editor.getRootNode();
    }

    /**
     * The serialized text of the Expression.
     * 
     * @return The serialized text of the Expression
     */
    public String getResultText() {
        if (canceled) {
            return "";
        }
        return editor.getContent();
    }

    /**
     * Initial Warning/Error-field.
     * 
     * @return Initial text of the Message
     */
    protected String getInitialText() {
        return "";
    }

    /**
     * The title of the Dialog.
     * 
     * @return the title
     */
    protected String getTitle() {
        return "Edit stochastic expression";
    }

    /**
     * Assert type.
     * 
     * @param result
     *            the result
     * @param typeVisitor
     *            the type visitor
     * @param expectedType
     *            the expected type
     * @return the collection<? extends i issue>
     */
    private Collection<? extends IIssue> assertType(EObject result, ExpressionInferTypeVisitor typeVisitor,
            TypeEnum expectedType) {
        if (!TypeCheckVisitor.typesCompatible(expectedType, typeVisitor.getType((Expression) result))) {
            return Collections.singletonList(new ExpectedTypeMismatchIssue(expectedType, typeVisitor
                    .getType((Expression) result)));
        }
        return Collections.emptyList();
    }

    /**
     * Get the type of an variable characterisation.
     * 
     * @param ch
     *            The characterisation to check.
     * @return INT for ByteSize and number of elements, ANY for all others.
     */
    public static TypeEnum getTypeFromVariableCharacterisation(VariableCharacterisation ch) {
        switch (ch.getType()) {
        case BYTESIZE:
        case NUMBER_OF_ELEMENTS:
            return TypeEnum.INT;
        default:
            // unspecified
        }
        return TypeEnum.ANY;
    }

    /**
     * Get the context the expression edit dialog is working on. This provides access to the
     * surrounding seff and the described signature. It is used to access provided variables etc.
     * 
     * @param rv
     *            the rv
     * @return The parameters found in the context.
     */
    private Parameter[] getContext(EObject rv) {
        Parameter[] parameters = new Parameter[] {};

        ResourceDemandingSEFF seff = getSEFF(rv);
        if (seff != null && seff.getDescribedService__SEFF() != null) {

            // if the seff is about an operation signature
            if (seff.getDescribedService__SEFF() instanceof OperationSignature) {
                OperationSignature signature = (OperationSignature) seff.getDescribedService__SEFF();
                parameters = (Parameter[]) signature.getParameters__OperationSignature().toArray();

                // if the seff is an handler for an EventType
            } else if (seff.getDescribedService__SEFF() instanceof EventType) {
                EventType eventType = (EventType) seff.getDescribedService__SEFF();
                if (eventType.getParameter__EventType() != null) {
                    parameters = new Parameter[] { eventType.getParameter__EventType() };
                }
            }

            // if the actual context is an ExternalCallAction, that has a return value other than
            // void
            // also provide the return parameter in the code complition
            ExternalCallAction eca = getParentCallAction(rv);
            if (eca != null && isOutputCharacterisation(eca, rv) && eca.getCalledService_ExternalService() != null
                    && eca.getCalledService_ExternalService().getReturnType__OperationSignature() != null) {
                Parameter[] parametersWithReturn = new Parameter[parameters.length + 1];
                System.arraycopy(parameters, 0, parametersWithReturn, 0, parameters.length);
                parametersWithReturn[parameters.length] = RepositoryFactory.eINSTANCE.createParameter();
                parametersWithReturn[parameters.length].setDataType__Parameter(eca.getCalledService_ExternalService()
                        .getReturnType__OperationSignature());
                parametersWithReturn[parameters.length].setParameterName("RETURN");
                parameters = parametersWithReturn;
            }
        }

        return parameters;
    }

    /**
     * Checks if is output characterisation.
     * 
     * @param eca
     *            the eca
     * @param rv
     *            the rv
     * @return true, if is output characterisation
     */
    private boolean isOutputCharacterisation(ExternalCallAction eca, EObject rv) {
        for (VariableUsage vu : eca.getReturnVariableUsage__CallReturnAction()) {
            if (vu.getVariableCharacterisation_VariableUsage().contains(rv)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the RessourceDemandingSeff an object is included in.
     * 
     * @param a
     *            The object to get the RDSEFF for.
     * @return The found ressource demanding seff or null if there is none.
     */
    private ResourceDemandingSEFF getSEFF(EObject a) {
        EObject container = a;
        while (container != null && !(container instanceof ResourceDemandingSEFF)) {
            container = container.eContainer();
        }
        if (container == null || !(container instanceof ResourceDemandingSEFF)) {
            return null;
        }
        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) container;
        return seff;
    }

    /**
     * Check if the actual container of an object is an external call action. If this is the case,
     * return the action, otherwise null.
     * 
     * @param a
     *            The object to check the container for.
     * @return The ExternalCallAction container or null if there is none.
     */
    private ExternalCallAction getParentCallAction(EObject a) {
        EObject container = a;
        while (!(container instanceof ResourceDemandingSEFF) && !(container instanceof ExternalCallAction)) {
            container = container.eContainer();
        }
        if (!(container instanceof ExternalCallAction)) {
            return null;
        }
        ExternalCallAction call = (ExternalCallAction) container;
        return call;
    }

    /**
     * Setter for the title.
     * 
     * @param newTitle
     *            the title
     */
    public void setDisplayTitle(String newTitle) {
        this.dialogtitle = newTitle;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayout(new GridLayout());
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        this.setTitle(dialogtitle);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "de.uka.ipd.sdq.pcmbench.help.stoexdialog");

        editor = new PCMStoExEditor(container, newText);

        editor.getEmbeddedEditor().getDocument().addModelListener(new IXtextModelListener() {
            @Override
            public void modelChanged(XtextResource resource) {
                // we can't call contentChanged() here because SWT does not want another thread to
                // operate on its components, so the TextListener does the real call if
                // neccesarry...
                modelChanged = true;
            }
        });

        editor.getEmbeddedEditor().getViewer().addTextListener(new ITextListener() {
            @Override
            public void textChanged(TextEvent event) {
                contentChanged();
            }
        });
        modelChanged = true;
        feedVariableContextProvider();
        return editor.getEmbeddedEditor().getViewer().getControl();
    }

    /**
     * Feeds the VariableContextProvider with Variables that can be used.
     */
    private void feedVariableContextProvider() {
        if (context != null) {
            for (Parameter par : context) {
                editor.getPCMProposalProvider().getVarContext()
                        .addVariable(par.getParameterName(), par.getParameterName());
            }
        }
    }

    /**
     * Is called when the Model has changed. Checks if the Resource contains errors and enables or
     * disables OK-Button. Also calls editorSpecificValidation().
     * 
     * @see #editorSpecificValidation()
     */
    protected void contentChanged() {
        if (modelChanged) {
            modelChanged = false;
            if (editor.getResource().getErrors().size() > 0) {
                setErrorMessage(editor.getResource().getErrors().get(0).getMessage());
                getButton(IDialogConstants.OK_ID).setEnabled(false);
                return;
            }
            List<IIssue> edSpecVal = new LinkedList<>();
            try{
            edSpecVal = editorSpecificValidation();
            } catch(Exception e){
                throw new RuntimeException("If this is thrown the validator missed something or there is a bad bug. You may be really fucked up...", e);
            }
            if (edSpecVal != null && edSpecVal.size() > 0) {
                setErrorMessage(edSpecVal.get(0).getMessage());
                getButton(IDialogConstants.OK_ID).setEnabled(false);
                return;
            }
            if (editor.getResource().getWarnings().size() > 0) {
                setMessage(editor.getResource().getWarnings().get(0).getMessage());
            } else {
                setMessage(null);
            }
            setErrorMessage(null);
            getButton(IDialogConstants.OK_ID).setEnabled(true);
        }
    }

    /**
     * Does some editor-specific validation. Here it does type-assertion.
     * 
     * @return List of issues.
     */
    protected List<IIssue> editorSpecificValidation() {
        List<IIssue> result = new LinkedList<IIssue>();
        NonProbabilisticExpressionInferTypeVisitor typeVisitor = new NonProbabilisticExpressionInferTypeVisitor();
        typeVisitor.doSwitch(getResult());
        result.addAll(assertType(getResult(), typeVisitor, expectedType));
        return result;
    }

    @Override
    protected void cancelPressed() {
        canceled = true;
        VariableContextProvider.resetInstance();
        super.cancelPressed();
    }

    @Override
    protected void okPressed() {
        // check a last time if it's really ok to click ok... (sometimes the parser is out of time)
        modelChanged = true;
        contentChanged();
        if (this.getButton(IDialogConstants.OK_ID).isEnabled()) {
            VariableContextProvider.resetInstance();
            super.okPressed();
        }
    }

}
