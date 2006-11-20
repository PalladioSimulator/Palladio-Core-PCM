/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringBufferInputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.stochasticexpressions.StoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;

/**
 * @author Snowball
 *
 */
public class StoachasticExpressionEditDialog extends Dialog {

	private Expression result;
	//private Text editText;
	private SourceViewer textViewer;
	private String newText = "= ";

	/**
	 * @param parent
	 */
	public StoachasticExpressionEditDialog(Shell parent) {
		super(parent);
	}

	/**
	 * @param parent
	 * @param style
	 */
	public StoachasticExpressionEditDialog(Shell parent, int style) {
		super(parent);
	}

	public void setInitialExpression(Expression ex)
	{
	    newText = "= "+new StoExPrettyPrintVisitor().prettyPrint(ex); 
	}
	
	@Override
	protected void okPressed() {
		EObject value = null;
		
		try {
			String text = this.textViewer.getDocument().get();
			StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
					new StringBufferInputStream(text));
			StochasticExpressionsParser parser = new StochasticExpressionsParser(lexer);
			value = parser.expression();
		} catch (RecognitionException e) {
			result = null;
			MessageDialog.openError(this.getParentShell(), "Parser error", e.getMessage());
			return;
		} catch (TokenStreamException e) {
			result = null;
			MessageDialog.openError(this.getParentShell(), "Parser error", e.getMessage());
			return;
		} catch (Exception e) {
			result = null;
			MessageDialog.openError(this.getParentShell(), "Parser error", e.getMessage());
			return;
		}
		result = (Expression)value;
		super.okPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		final Group editStochasticExpressionGroup = new Group(parent, SWT.NONE);
		editStochasticExpressionGroup.setText("Edit stochastic expression");
		editStochasticExpressionGroup.setLayout(new GridLayout());
		//editText = new Text((Composite) parent,SWT.MULTI);
		textViewer = new SourceViewer(editStochasticExpressionGroup,null, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER | SWT.WRAP);
		final StyledText styledText = textViewer.getTextWidget();
		styledText.setFont(SWTResourceManager.getFont("Courier New", 12, SWT.NONE));
		textViewer.configure(new StoExSourceViewerConfiguration());
		GridData layoutData = new GridData(GridData.FILL_BOTH|GridData.GRAB_HORIZONTAL|GridData.GRAB_VERTICAL);
		layoutData.heightHint = 300;
		layoutData.widthHint = 450;
		textViewer.getControl().setLayoutData(layoutData);
		//editText.setText(newText);
		textViewer.setDocument(new Document(newText));
		return textViewer.getControl();
	}
	
	public Expression getResult()
	{
		return result;
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Edit stochastic expression");
	}
}
