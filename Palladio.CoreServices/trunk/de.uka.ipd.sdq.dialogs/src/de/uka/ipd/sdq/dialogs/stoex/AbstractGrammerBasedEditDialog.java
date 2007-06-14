/**
 * 
 */
package de.uka.ipd.sdq.dialogs.stoex;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dialogs.SWTResourceManager;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.ErrorEntry;

/**
 * @author Snowball
 * 
 */
public abstract class AbstractGrammerBasedEditDialog extends TitleAreaDialog {

	private static final String DIALOG_TITLE = "Edit a stochastic expression";

	public static final String ERROR_TYPE = "ERROR";

	// private Text editText;
	private SourceViewer textViewer;

	protected String newText = null;

	private AnnotationModel fAnnotationModel;
	
	private Object result = null;
	
	private Parameter[] context = null;

	/**
	 * @param parent
	 */
	public AbstractGrammerBasedEditDialog(Shell parent) {
		super(parent);
		newText = getInitialText();
		this.context = new Parameter[]{};
	}

	/**
	 * @param parent
	 * @param context - A list of parameters used in code completion
	 */
	public AbstractGrammerBasedEditDialog(Shell parent, Parameter[] context) {
		super(parent);
		newText = getInitialText();
		this.context = context;
		setShellStyle(SWT.RESIZE|SWT.MAX);
		this.setHelpAvailable(true);
	}

	protected abstract String getInitialText();
	
	@Override
	protected void cancelPressed() {
		super.cancelPressed();
		result = null;
	}

	@Override
	protected Control createDialogArea(Composite parent) {		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FillLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		this.setTitle(DIALOG_TITLE);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "de.uka.ipd.sdq.pcmbench.help.stoexdialog");

		IAnnotationAccess fAnnotationAccess = new AnnotationMarkerAccess();

		final Group editStochasticExpressionGroup = new Group(container, SWT.NONE);
		editStochasticExpressionGroup.setText("");
		editStochasticExpressionGroup.setLayout(new FillLayout());
		
		fAnnotationModel = new AnnotationModel();
		CompositeRuler fCompositeRuler = new CompositeRuler();
		AnnotationRulerColumn annotationRuler = new AnnotationRulerColumn(
				fAnnotationModel, 16, fAnnotationAccess);
		fCompositeRuler.setModel(fAnnotationModel);
		// annotation ruler is decorating our composite ruler
		fCompositeRuler.addDecorator(0, annotationRuler);

		// add what types are show on the different rulers
		annotationRuler.addAnnotationType(ERROR_TYPE);
		textViewer = new SourceViewer(editStochasticExpressionGroup,
				fCompositeRuler, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.RESIZE);
		final StyledText styledText = textViewer.getTextWidget();
		styledText.setWordWrap(true);
		final AbstractGrammarBasedViewerConfiguration config = new AbstractGrammarBasedViewerConfiguration(fAnnotationModel,context,getLexerClass(),getTokenMapper());
		styledText.setFont(SWTResourceManager.getFont("Courier New", 12,
				SWT.NONE));
		styledText.addListener(SWT.KeyDown, new Listener(){

			public void handleEvent(Event event) {
				if (event.character == ' ' && (event.stateMask & SWT.CTRL) == SWT.CTRL){
					config.getContentAssistant(textViewer).showPossibleCompletions();
				}
				
			}
			
		});

		// to paint the annotations
		AnnotationPainter ap = new AnnotationPainter(textViewer,
				fAnnotationAccess);
		ap.addAnnotationType(ERROR_TYPE);
		ap.setAnnotationTypeColor(ERROR_TYPE, new Color(Display.getDefault(),
				new RGB(255, 0, 0)));

		// this will draw the squigglies under the text
		textViewer.addPainter(ap);

		textViewer.configure(config);
		GridData layoutData = new GridData(GridData.FILL_BOTH);//new GridData(GridData.FILL_BOTH
				//| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
		//layoutData.heightHint = 300;
		//layoutData.widthHint = 450;
		
		//textViewer.getControl().setLayoutData(layoutData);
		// editText.setText(newText);
		textViewer.setDocument(new Document(newText), fAnnotationModel);
		textViewer.addTextListener(new ITextListener(){
			
			public void textChanged(TextEvent event) {
				if (event.getDocumentEvent() != null)
				{
					parseInputAndRefreshAnnotations();
				}
			}
			
		});
		return textViewer.getControl();
	}

	protected abstract ITokenMapper getTokenMapper();
	protected abstract Class<?> getLexerClass();

	protected abstract String getTitle();

	protected void parseInputAndRefreshAnnotations() {
		EObject value = null;
		fAnnotationModel.removeAllAnnotations();
		Lexer lexer = null;
		try {
			String text = this.textViewer.getDocument().get();
			lexer = getLexer(text);
			value = parse(lexer);
		} catch (RecognitionException e) {
			showInputInvalidInfo(e);
			return;
		} catch (StoExParserException e) {
			for (ErrorEntry ex : e.getErrorList())
				showInputInvalidInfo(ex);
			return;
		} catch (Exception e) {
			showInputInvalidInfo(e);
			return;
		}
		this.getButton(IDialogConstants.OK_ID).setEnabled(true);
		this.setErrorMessage(null);
		result = value;
	}

	protected abstract Lexer getLexer(String text);
	protected abstract EObject parse(Lexer lexer) throws RecognitionException, StoExParserException;
	
//	private void showInputInvalidInfo(TokenStreamException e,CharScanner scanner) {
//		result = null;
//		fAnnotationModel.addAnnotation(
//				new Annotation(ERROR_TYPE, false, 
//				e.getMessage()),
//				new Position(ParserHelper.positionToOffset(textViewer.getDocument(), scanner.getLine(), scanner.getColumn()),1));
//		this.getButton(IDialogConstants.OK_ID).setEnabled(false);
//		this.setErrorMessage("Entered stochastic expression is invalid. Cause given: "+e.getMessage());
//	}

	/**
	 * @param e
	 */
	private void showInputInvalidInfo(Exception e) {
		result = null;
		fAnnotationModel.addAnnotation(
				new Annotation(ERROR_TYPE, false, 
				e.getMessage()),
				guessPosition(e));
		this.getButton(IDialogConstants.OK_ID).setEnabled(false);
		this.setErrorMessage("Entered stochastic expression is invalid. Cause given: "+e.getLocalizedMessage());
	}

	private void showInputInvalidInfo(ErrorEntry e) {
		result = null;
		fAnnotationModel.addAnnotation(
				new Annotation(ERROR_TYPE, false, 
				e.getErrorText()),
				guessPosition(e.getEx()));
		this.getButton(IDialogConstants.OK_ID).setEnabled(false);
		this.setErrorMessage("Entered stochastic expression is invalid. Cause given: "+e.getErrorText());
	}
	
	/**
	 * @param e 
	 * @return
	 */
	private Position guessPosition(Exception e) {
		if (e instanceof RecognitionException)
		{
			RecognitionException recException = (RecognitionException) e;
			int col = recException.charPositionInLine; 
			int line = recException.line;
			int offset = ParserHelper.positionToOffset(textViewer.getDocument(),line,col);
			offset = offset < 0 ? 0 : offset;
			return new Position(offset, textViewer.getDocument().getLength()-offset);
		}
		return new Position(0, textViewer.getDocument().getLength());
	}

	protected Object getResult()
	{
		return result;
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(getTitle());
	}
}

class AnnotationMarkerAccess implements IAnnotationAccess,
		IAnnotationAccessExtension {
	public Object getType(Annotation annotation) {
		return annotation.getType();
	}

	public boolean isMultiLine(Annotation annotation) {
		return true;
	}

	public boolean isTemporary(Annotation annotation) {
		return !annotation.isPersistent();
	}

	public String getTypeLabel(Annotation annotation) {
		if (annotation instanceof Annotation)
			return "Errors";

		return null;
	}

	public int getLayer(Annotation annotation) {
		return 0;
	}

	public void paint(Annotation annotation, GC gc, Canvas canvas,
			Rectangle bounds) {
		ImageUtilities.drawImage(SWTResourceManager.getImage("xxx.gif"),
				gc, canvas, bounds, SWT.CENTER, SWT.TOP);
	}

	public boolean isPaintable(Annotation annotation) {
		return true;
	}

	public boolean isSubtype(Object annotationType, Object potentialSupertype) {
		if (annotationType.equals(potentialSupertype))
			return true;

		return false;
	}

	public Object[] getSupertypes(Object annotationType) {
		return new Object[0];
	}
}
