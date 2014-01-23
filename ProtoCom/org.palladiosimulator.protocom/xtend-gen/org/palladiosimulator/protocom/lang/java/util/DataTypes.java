package org.palladiosimulator.protocom.lang.java.util;

import com.google.common.base.Objects;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import java.util.Arrays;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;

/**
 * Utility class for creating datatype strings. Inspired by the old datatype xpand template.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class DataTypes {
  /**
   * If this method is called, an error occured because every possible data type should be covered.
   */
  protected static String _getDataType(final DataType d) {
    String _plus = ("Xtend2 GENERATION ERROR [org.palladiosimulator.protocom.lang.java.util.DataTypes]:" + 
      "Unknown data type found (");
    String _plus_1 = (_plus + d);
    String _plus_2 = (_plus_1 + ").");
    return _plus_2;
  }
  
  /**
   * Handles "void" as return type.
   */
  protected static String _getDataType(final Void d) {
    return "void";
  }
  
  /**
   * Primitive types can directly be resolved.
   */
  protected static String _getDataType(final PrimitiveDataType d) {
    String _switchResult = null;
    PrimitiveTypeEnum _type = d.getType();
    final PrimitiveTypeEnum _switchValue = _type;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.BOOL)) {
        _matched=true;
        _switchResult = "Boolean";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.BYTE)) {
        _matched=true;
        _switchResult = "byte";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.CHAR)) {
        _matched=true;
        _switchResult = "char";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.DOUBLE)) {
        _matched=true;
        _switchResult = "double";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.INT)) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.LONG)) {
        _matched=true;
        _switchResult = "long";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.STRING)) {
        _matched=true;
        _switchResult = "String";
      }
    }
    if (!_matched) {
      String _plus = ("Xtend2 GENERATION ERROR [org.palladiosimulator.protocom.lang.java.util.DataTypes]:" + 
        "Unknown primitive data type found (");
      String _plus_1 = (_plus + d);
      String _plus_2 = (_plus_1 + ").");
      _switchResult = _plus_2;
    }
    return _switchResult;
  }
  
  protected static String _getDataType2(final DataType d) {
    String _dataType = DataTypes.getDataType(d);
    return _dataType;
  }
  
  /**
   * Primitive types can directly be resolved.
   */
  protected static String _getDataType2(final PrimitiveDataType d) {
    String _switchResult = null;
    PrimitiveTypeEnum _type = d.getType();
    final PrimitiveTypeEnum _switchValue = _type;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.BOOL)) {
        _matched=true;
        _switchResult = "Boolean";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.BYTE)) {
        _matched=true;
        _switchResult = "Byte";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.CHAR)) {
        _matched=true;
        _switchResult = "Character";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.DOUBLE)) {
        _matched=true;
        _switchResult = "Double";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.INT)) {
        _matched=true;
        _switchResult = "Integer";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.LONG)) {
        _matched=true;
        _switchResult = "Long";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.STRING)) {
        _matched=true;
        _switchResult = "String";
      }
    }
    if (!_matched) {
      String _plus = ("Xtend2 GENERATION ERROR [org.palladiosimulator.protocom.lang.java.util.DataTypes]:" + 
        "Unknown primitive data type found (");
      String _plus_1 = (_plus + d);
      String _plus_2 = (_plus_1 + ").");
      _switchResult = _plus_2;
    }
    return _switchResult;
  }
  
  /**
   * Collection data types can directly be resolved by their name.
   */
  protected static String _getDataType(final CollectionDataType d) {
    Repository _repository__DataType = d.getRepository__DataType();
    String _basePackageName = JavaNames.basePackageName(_repository__DataType);
    String _plus = (_basePackageName + ".datatypes.");
    String _entityName = d.getEntityName();
    String _plus_1 = (_plus + _entityName);
    return _plus_1;
  }
  
  /**
   * Composite data types can directly be resolved by their name.
   */
  protected static String _getDataType(final CompositeDataType d) {
    Repository _repository__DataType = d.getRepository__DataType();
    String _basePackageName = JavaNames.basePackageName(_repository__DataType);
    String _plus = (_basePackageName + ".datatypes.");
    String _entityName = d.getEntityName();
    String _plus_1 = (_plus + _entityName);
    return _plus_1;
  }
  
  protected static String _getReturnDataType(final Signature s) {
    return null;
  }
  
  protected static String _getReturnDataType(final OperationSignature s) {
    DataType _returnType__OperationSignature = s.getReturnType__OperationSignature();
    String _dataType = DataTypes.getDataType(_returnType__OperationSignature);
    return _dataType;
  }
  
  protected static String _getReturnDataType(final InfrastructureSignature s) {
    return "void";
  }
  
  /**
   * TODO Implement EventTypes?
   */
  protected static String _getReturnDataType(final EventType s) {
    return "FIXME";
  }
  
  public static String getDataType(final DataType d) {
    if (d instanceof CollectionDataType) {
      return _getDataType((CollectionDataType)d);
    } else if (d instanceof CompositeDataType) {
      return _getDataType((CompositeDataType)d);
    } else if (d instanceof PrimitiveDataType) {
      return _getDataType((PrimitiveDataType)d);
    } else if (d != null) {
      return _getDataType(d);
    } else if (d == null) {
      return _getDataType((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(d).toString());
    }
  }
  
  public static String getDataType2(final DataType d) {
    if (d instanceof PrimitiveDataType) {
      return _getDataType2((PrimitiveDataType)d);
    } else if (d != null) {
      return _getDataType2(d);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(d).toString());
    }
  }
  
  public static String getReturnDataType(final Signature s) {
    if (s instanceof EventType) {
      return _getReturnDataType((EventType)s);
    } else if (s instanceof InfrastructureSignature) {
      return _getReturnDataType((InfrastructureSignature)s);
    } else if (s instanceof OperationSignature) {
      return _getReturnDataType((OperationSignature)s);
    } else if (s != null) {
      return _getReturnDataType(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
