package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.xml.IJeeFacetCoreXml;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPFacetCoreFile<E extends Entity> extends ConceptMapping<E> implements IJeeFacetCoreXml {
  public JavaEEIIOPFacetCoreFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String runtimeName() {
    return null;
  }
  
  public Collection<String> fixedFacet() {
    return CollectionLiterals.<String>newLinkedList();
  }
  
  public HashMap<String,String> installedFacet() {
    return CollectionLiterals.<String, String>newHashMap();
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
