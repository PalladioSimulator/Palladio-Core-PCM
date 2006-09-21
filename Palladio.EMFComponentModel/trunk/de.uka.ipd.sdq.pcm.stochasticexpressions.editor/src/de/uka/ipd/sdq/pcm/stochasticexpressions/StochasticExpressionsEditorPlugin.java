package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.openarchitectureware.xtext.AbstractXtextEditorPlugin;
import org.openarchitectureware.xtext.LanguageUtilities;
import org.osgi.framework.BundleContext;

public class StochasticExpressionsEditorPlugin extends AbstractXtextEditorPlugin {
   private static StochasticExpressionsEditorPlugin plugin;
   public static StochasticExpressionsEditorPlugin getDefault() {
      return plugin;
   }

   private StochasticExpressionsUtilities utilities = new StochasticExpressionsUtilities();
   public LanguageUtilities getUtilities() {
      return utilities;
   }

   public StochasticExpressionsEditorPlugin() {
      plugin = this;
   }

   public void stop(BundleContext context) throws Exception {
      super.stop(context);
      plugin = null;
   }
}
