package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

import de.uka.ipd.sdq.pcm.dialogs.stoex.StoExCompletionProcessor;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;

public class StoExParser implements IParser {

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return new StoExCompletionProcessor(new Parameter[]{});
	}

	public String getEditString(IAdaptable element, int flags) {
		RandomVariable randomVariable = (RandomVariable) element.getAdapter(RandomVariable.class);
		return randomVariable.getSpecification();
	}

	public ICommand getParseCommand(IAdaptable element, String newString,
			int flags) {
		SetRequest req = new SetRequest((EObject)element.getAdapter(RandomVariable.class), StoexPackage.eINSTANCE.getRandomVariable_Specification(), newString);
		SetValueCommand cmd = new SetValueCommand(req);
		return cmd;
	}

	public String getPrintString(IAdaptable element, int flags) {
		RandomVariable randomVariable = (RandomVariable) element.getAdapter(RandomVariable.class);
		PCMStoExLexer lexer = new PCMStoExLexer(new ANTLRStringStream(randomVariable.getSpecification()));
		Expression expr;
		try {
			expr = new PCMStoExParser(new CommonTokenStream(lexer)).expression();
			String result = new PCMStoExPrettyPrintVisitor().prettyPrint(expr);
			return result;
		} catch (RecognitionException e) {
			return "<invalid StoEx>";
		} catch (Exception e) {
			return "<invalid StoEx>";
		}
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return true;
	}

	public IParserEditStatus isValidEditString(IAdaptable element,
			String editString) {
		PCMStoExLexer lexer = new PCMStoExLexer(new ANTLRStringStream(editString));
		Expression expr;
		try {
			expr = new PCMStoExParser(new CommonTokenStream(lexer)).expression();
			return new ParserEditStatus(
					"de.uka.ipd.sdq.pcm.gmf.seff.helper", IParserEditStatus.EDITABLE, "");
		} catch (RecognitionException e) {
			return new ParserEditStatus(IParserEditStatus.ERROR,
					"de.uka.ipd.sdq.pcm.gmf.seff.helper", IParserEditStatus.EDITABLE, "",e);
		} catch (Exception e) {
			return new ParserEditStatus(IParserEditStatus.ERROR,
					"de.uka.ipd.sdq.pcm.gmf.seff.helper", IParserEditStatus.EDITABLE, "",e);
		}
	}

}
