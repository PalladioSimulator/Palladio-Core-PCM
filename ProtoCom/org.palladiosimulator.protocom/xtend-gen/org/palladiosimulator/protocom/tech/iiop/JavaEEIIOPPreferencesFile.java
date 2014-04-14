package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.prefs.IJeePreferences;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPPreferencesFile<E extends Entity> extends ConceptMapping<E> implements IJeePreferences {
  public JavaEEIIOPPreferencesFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String eclipsePreferencesVersion() {
    return null;
  }
  
  public String codegenInlineJsrBytecode() {
    return null;
  }
  
  public String codegenTargetPlatform() {
    return null;
  }
  
  public String compliance() {
    return null;
  }
  
  public String problemAssertIdentifier() {
    return null;
  }
  
  public String problemEnumIdentifier() {
    return null;
  }
  
  public String source() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
