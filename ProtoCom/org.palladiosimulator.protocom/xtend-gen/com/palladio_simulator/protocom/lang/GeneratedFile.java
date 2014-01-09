package com.palladio_simulator.protocom.lang;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.palladio_simulator.protocom.lang.ICompilationUnit;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;

/**
 * Abstract class representing generated files.
 * 
 * Generic type defines the common interface for language and provider classes.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class GeneratedFile<L extends ICompilationUnit> implements ICompilationUnit {
  @Inject
  protected Injector injector;
  
  /**
   * File System Access used for storing this file.
   */
  @Inject
  protected AbstractFileSystemAccess2 fsa;
  
  /**
   * Provider for this compilation unit. Providers need to implement the language interface,
   * since these are used for delegation.
   * 
   * TODO: Add (Xtend) annotations which generate the boilerplate code for provider delegation.
   *       e.g. @Provided
   */
  protected L provider;
  
  public String filePath() {
    String _filePath = this.provider.filePath();
    return _filePath;
  }
  
  /**
   * Inject the provider for this generated file.
   */
  public GeneratedFile<L> createFor(final L concept) {
    GeneratedFile<L> _xblockexpression = null;
    {
      this.provider = concept;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  /**
   * Generate the source code for this compilation unit.
   */
  public abstract String generate();
  
  /**
   * Store the generated file using Xtext/Xtend file system access.
   */
  public void store() {
    String _filePath = this.filePath();
    String _generate = this.generate();
    this.fsa.generateFile(_filePath, "PCM", _generate);
  }
}
