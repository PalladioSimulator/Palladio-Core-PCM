package org.palladiosimulator.protocom.tech.pojo.repository;

import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import java.util.Collection;
import java.util.Collections;
import org.palladiosimulator.protocom.lang.java.util.DataTypes;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

/**
 * Defining the content of collection data type implementations.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoCollectionDataTypeClass extends PojoClass<CollectionDataType> {
  public String superClass() {
    String _xblockexpression = null;
    {
      DataType innerType = this.pcmEntity.getInnerType_CollectionDataType();
      String _dataType2 = DataTypes.getDataType2(innerType);
      String _plus = ("java.util.ArrayList<" + _dataType2);
      _xblockexpression = (_plus + ">");
    }
    return _xblockexpression;
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.SERIALIZABLE_INTERFACE));
  }
  
  public PojoCollectionDataTypeClass(final CollectionDataType pcmEntity) {
    super(pcmEntity);
  }
}
