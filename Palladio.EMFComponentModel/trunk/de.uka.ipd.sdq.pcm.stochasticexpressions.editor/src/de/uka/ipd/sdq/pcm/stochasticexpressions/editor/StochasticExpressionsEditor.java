package de.uka.ipd.sdq.pcm.stochasticexpressions.editor;

import org.openarchitectureware.xtext.AbstractXtextEditorPlugin;
import org.openarchitectureware.xtext.editor.AbstractXtextEditor;

import de.uka.ipd.sdq.pcm.stochasticexpressions.StochasticExpressionsEditorPlugin;

public class StochasticExpressionsEditor extends AbstractXtextEditor {

   protected AbstractXtextEditorPlugin getPlugin() {
      return StochasticExpressionsEditorPlugin.getDefault();
   }

}
