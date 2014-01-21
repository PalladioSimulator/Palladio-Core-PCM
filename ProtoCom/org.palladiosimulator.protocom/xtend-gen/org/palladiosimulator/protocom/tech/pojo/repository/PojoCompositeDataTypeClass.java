package org.palladiosimulator.protocom.tech.pojo.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.impl.JField;
import org.palladiosimulator.protocom.lang.java.util.DataTypes;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

/**
 * Defining the content of composite data type implementations.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoCompositeDataTypeClass extends PojoClass<CompositeDataType> {
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.SERIALIZABLE_INTERFACE));
  }
  
  public PojoCompositeDataTypeClass(final CompositeDataType pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<JField> _xblockexpression = null;
    {
      final LinkedList<JField> results = CollectionLiterals.<JField>newLinkedList();
      EList<InnerDeclaration> _innerDeclaration_CompositeDataType = this.pcmEntity.getInnerDeclaration_CompositeDataType();
      final Function1<InnerDeclaration,JField> _function = new Function1<InnerDeclaration,JField>() {
        public JField apply(final InnerDeclaration it) {
          JField _jField = new JField();
          JField _withModifierVisibility = _jField.withModifierVisibility("public");
          String _entityName = it.getEntityName();
          JField _withName = _withModifierVisibility.withName(_entityName);
          DataType _datatype_InnerDeclaration = it.getDatatype_InnerDeclaration();
          String _dataType = DataTypes.getDataType(_datatype_InnerDeclaration);
          JField _withType = _withName.withType(_dataType);
          return _withType;
        }
      };
      List<JField> _map = ListExtensions.<InnerDeclaration, JField>map(_innerDeclaration_CompositeDataType, _function);
      Iterables.<JField>addAll(results, _map);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
}
