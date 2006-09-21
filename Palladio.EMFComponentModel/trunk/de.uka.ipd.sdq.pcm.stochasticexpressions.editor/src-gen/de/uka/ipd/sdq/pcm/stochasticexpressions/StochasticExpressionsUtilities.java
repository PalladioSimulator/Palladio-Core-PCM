package de.uka.ipd.sdq.pcm.stochasticexpressions;

import java.io.InputStreamReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.openarchitectureware.xtext.AbstractLanguageUtilities;
import de.uka.ipd.sdq.pcm.stochasticexpressions.StochasticExpressionsEditorPlugin;
import org.openarchitectureware.xtext.parser.EcoreModelFactory;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.Scanner;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;

import antlr.RecognitionException;
import antlr.TokenStream;
import antlr.TokenStreamException;

public class StochasticExpressionsUtilities extends AbstractLanguageUtilities {

   public TokenStream getScanner(InputStreamReader reader) {
      return new Scanner(reader);
   }

   public EObject internalParse(TokenStream scanner, EcoreModelFactory f) throws RecognitionException, TokenStreamException {
      StochasticExpressionsParser p = new StochasticExpressionsParser(scanner, f);
      return p.ruleFormular();
   }

   public String getCheckFileName() {
      return "de::uka::ipd::sdq::pcm::stochasticexpressions::StochasticExpressionsChecks";
   }

   public String getFileExtension() {
      return "stoex";
   }

   public String getPathToEcoreFile() {
      return "de/uka/ipd/sdq/pcm/stochasticexpressions/stochasticexpressions.ecore";
   }

   public String getProblemId() {
      return StochasticExpressionsEditorPlugin.getDefault().getId() + ".Problem";
   }

   public String getLabelExtensionsFileName() {
      return "de::uka::ipd::sdq::pcm::stochasticexpressions::StochasticExpressionsEditorExtensions";
   }
   
   public String getImageExtensionsFileName() {
      return "de::uka::ipd::sdq::pcm::stochasticexpressions::StochasticExpressionsEditorExtensions";
   }

   public String[] allKeywords() {
      return new String[] { "false","true" };
   }
   
   public ClassLoader getClassLoader() {
      return this.getClass().getClassLoader();
   }
   
   public IPartitionTokenScanner getPartitionScanner() {
      return new GeneratedPartitionScanner();
   }
}
