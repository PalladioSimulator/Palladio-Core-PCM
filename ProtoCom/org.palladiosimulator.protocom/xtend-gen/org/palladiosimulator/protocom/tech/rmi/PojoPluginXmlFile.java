package org.palladiosimulator.protocom.tech.rmi;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.xml.IPluginXml;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class PojoPluginXmlFile<E extends Entity> extends ConceptMapping<E> implements IPluginXml {
  public PojoPluginXmlFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String extensionPoint() {
    return null;
  }
  
  public String actionDelegateClass() {
    return null;
  }
  
  public String actionDelegateId() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
