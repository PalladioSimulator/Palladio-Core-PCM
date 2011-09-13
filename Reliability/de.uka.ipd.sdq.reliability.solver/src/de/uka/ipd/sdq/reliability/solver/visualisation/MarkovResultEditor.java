package de.uka.ipd.sdq.reliability.solver.visualisation;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReporting;

public class MarkovResultEditor extends EditorPart {

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site); 
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		IEditorInput input = getEditorInput();
		Browser browser = new Browser(parent, SWT.BORDER);
		if (input != null) {
			if (input instanceof MarkovResultEditorInput) {
				// get Markov transformation results
				List<MarkovTransformationResult> markovResults = ((MarkovResultEditorInput) input).getMarkovResults();
				// generate HTML code using those results as data source
				MarkovHtmlGenerator htmlGenerator = new MarkovHtmlGenerator(new MarkovReporting(markovResults));
				// create final HTML page
				StringBuilder htmlCode = new StringBuilder("<html><head><title>Markov Results</title></head><body>");
				htmlCode.append(htmlGenerator.getHtml());
				htmlCode.append("</body></html>");
				// display HTML code in browser
				browser.setText(htmlCode.toString());
			} else {
				browser.setText("<html><head><title>Markov Results</title></head>"
						+ "<body><font face=\"Arial\" color=\"red\">Error:"
						+ " The given editor input is not an instance of MarkovResultEditorInput.</font>"
						+ "</body></html>");
			}
		}

//				StringBuilder resultBuilder = new StringBuilder();
//				for (MarkovTransformationResult markovResult : markovResults) {
//					for (String item : markovResult.getTextualResults(true)) {	// TODO get boolean approximate value from config?
//						resultBuilder.append(item + "<br />");
//					}
//				}
//				browser.setText("<html>"
//						+ "<head><title>Markov Results</title></head>"
//						+ "<body>"
//						+ "<div style=\"font: bold 15px Arial; font-variant: small-caps;"
//						+ "border-bottom: 2px black dashed; width: 200px; margin-bottom: 5mm; padding-left: 8px\">"
//						+ "Markov Results"
//						+ "</div>"
//						+ "<div style=\"font-family: Arial; font-size: 11px; color: #404050; line-height: 18px\">"
//						+ resultBuilder
//						+ "</div>"
//						+ "</body>"
//						+ "</html>");
//			} else {
//				browser.setText("<html>"
//						+ "<head><title>Markov Results</title></head>"
//						+ "<body><font face=\"Arial\" color=\"red\">Error:"
//						+ " The input is not an instance of MarkovResultEditorInput.</font></body>"
//						+ "</html>");
//			}
//		} else {
//			browser.setText("<html>"
//					+ "<head><title>Markov Results</title></head>"
//					+ "<body><font face=\"Arial\" color=\"red\">Error:"
//					+ " The input is null.</font></body>"
//					+ "</html>");
//		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
