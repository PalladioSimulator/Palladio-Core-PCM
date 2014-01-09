package org.palladiosimulator.protocom.traverse.framework;

import com.google.inject.Inject;
import com.google.inject.Injector;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.ICompilationUnit;

/**
 * Abstract class representing a generic PCM model entity. Includes methods to
 * further traverse the underlying PCM model.
 * 
 * Note that the generic type E extends NamedElement and not Entity. Due to some
 * (to me unknown) reasons an Allocation is a sub type of Entity, but a
 * ResourceEnvironment is not.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class PcmRepresentative<E extends NamedElement> {
  @Inject
  protected Injector injector;
  
  /**
   * Lift of all files to be generated.
   */
  protected List<GeneratedFile<? extends ICompilationUnit>> generatedFiles = CollectionLiterals.<GeneratedFile<? extends ICompilationUnit>>newLinkedList();
  
  /**
   * The represented element of the loaded PCM model.
   */
  protected E entity;
  
  /**
   * Set the entity which will be represented by this object.
   */
  public PcmRepresentative<E> setEntity(final E entity) {
    PcmRepresentative<E> _xblockexpression = null;
    {
      this.entity = entity;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  /**
   * Transformation process:
   * <ul>
   * 	<li>Traverse through all relevant entities connected to this entity.
   *  <li>Generate files necessary for this entity, depending on the language and technology used.
   * 	<li>Store generated files.
   * </ul>
   * Traverse and Generate are template methods.
   */
  public void transform() {
    this.traverse();
    this.generate();
    this.store();
  }
  
  /**
   * Traverse through the PCM model, following all relevant connections starting
   * from the represented element. Nothing is traversed in the default case.
   */
  protected void traverse() {
  }
  
  /**
   * Generate the files needed for this entity. Nothing is generated in the
   * default case.
   */
  protected void generate() {
  }
  
  /**
   * Store created files.
   */
  private void store() {
    final Procedure1<GeneratedFile<? extends ICompilationUnit>> _function = new Procedure1<GeneratedFile<? extends ICompilationUnit>>() {
      public void apply(final GeneratedFile<? extends ICompilationUnit> it) {
        it.store();
      }
    };
    IterableExtensions.<GeneratedFile<? extends ICompilationUnit>>forEach(this.generatedFiles, _function);
  }
}
