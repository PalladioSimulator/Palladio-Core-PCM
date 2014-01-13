package org.palladiosimulator.protocom.lang.java.util;

import com.google.common.base.Objects;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.Signature;
import java.util.Arrays;

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
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.INT)) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.DOUBLE)) {
        _matched=true;
        _switchResult = "double";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.CHAR)) {
        _matched=true;
        _switchResult = "char";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,PrimitiveTypeEnum.BYTE)) {
        _matched=true;
        _switchResult = "byte";
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
   * Uses an array for collections while resolving inner types.
   */
  protected static String _getDataType(final CollectionDataType d) {
    DataType _innerType_CollectionDataType = d.getInnerType_CollectionDataType();
    String _dataType = DataTypes.getDataType(_innerType_CollectionDataType);
    String _plus = (_dataType + "[]");
    return _plus;
  }
  
  /**
   * Composite data types can directly be resolved by their name.
   */
  protected static String _getDataType(final CompositeDataType d) {
    String _entityName = d.getEntityName();
    return _entityName;
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
  
  public static String getReturnDataType(final Signature s) {
    if (s instanceof InfrastructureSignature) {
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
