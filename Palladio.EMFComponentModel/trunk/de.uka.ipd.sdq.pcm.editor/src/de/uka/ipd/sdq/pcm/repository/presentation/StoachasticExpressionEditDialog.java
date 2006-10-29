/**
 * 
 */
package de.uka.ipd.sdq.pcm.repository.presentation;

import java.io.StringBufferInputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
	private Text editText;
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
			StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
					new StringBufferInputStream(editText.getText()));
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
		editText = new Text((Composite) parent,SWT.MULTI);
		GridData layoutData = new GridData(GridData.FILL_BOTH|GridData.GRAB_HORIZONTAL|GridData.GRAB_VERTICAL);
		layoutData.heightHint = 300;
		layoutData.widthHint = 450;
		editText.setLayoutData(layoutData);
		editText.setText(newText);
		return editText;
	}
	
	public Expression getResult()
	{
		return result;
	}
}
