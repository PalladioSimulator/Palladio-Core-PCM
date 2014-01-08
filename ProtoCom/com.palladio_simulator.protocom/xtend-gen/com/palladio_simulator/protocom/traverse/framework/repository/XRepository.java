package com.palladio_simulator.protocom.traverse.framework.repository;

import com.palladio_simulator.protocom.traverse.framework.PcmRepresentative;
import com.palladio_simulator.protocom.traverse.framework.repository.XBasicComponent;
import com.palladio_simulator.protocom.traverse.framework.repository.XCompositeComponent;
import com.palladio_simulator.protocom.traverse.framework.repository.XEventGroup;
import com.palladio_simulator.protocom.traverse.framework.repository.XInfrastructureInterface;
import com.palladio_simulator.protocom.traverse.framework.repository.XOperationInterface;
import java.util.Arrays;

/**
 * Traversing Repository. Child elements are:
 * <ul>
 * 	<li>Basic Component,
 * 	<li>Composite Component,
 * 	<li>Infrastructure Interface,
 * 	<li>Operation Interface,
 * 	<li>Event Groups.
 * </ul>
 */
@SuppressWarnings("all")
public class XRepository /* extends /* PcmRepresentative<Repository> */  */{
  public void traverse() {
    throw new Error("Unresolved compilation problems:"
      + "\ninterfaces__Repository cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\ncomponents__Repository cannot be resolved"
      + "\nforEach cannot be resolved");
  }
  
  /**
   * Traverse through Composite Components.
   */
  protected void _createComponent(final /* CompositeComponent */Object componentEntity) {
    XCompositeComponent _instance = this.injector.<XCompositeComponent>getInstance(XCompositeComponent.class);
    PcmRepresentative<CompositeComponent> _setEntity = _instance.setEntity(componentEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Basic Components.
   */
  protected void _createComponent(final /* BasicComponent */Object componentEntity) {
    XBasicComponent _instance = this.injector.<XBasicComponent>getInstance(XBasicComponent.class);
    PcmRepresentative<BasicComponent> _setEntity = _instance.setEntity(componentEntity);
    _setEntity.transform();
  }
  
  /**
   * Fallback for component traversing.
   */
  protected void _createComponent(final /* Entity */Object componentEntity) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Unsupported component type.");
    throw _unsupportedOperationException;
  }
  
  /**
   * Traverse through Infrastructure Interfaces.
   */
  protected void _createInterface(final /* InfrastructureInterface */Object interfaceEntity) {
    XInfrastructureInterface _instance = this.injector.<XInfrastructureInterface>getInstance(XInfrastructureInterface.class);
    PcmRepresentative<InfrastructureInterface> _setEntity = _instance.setEntity(interfaceEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Operation Interfaces.
   */
  protected void _createInterface(final /* OperationInterface */Object interfaceEntity) {
    XOperationInterface _instance = this.injector.<XOperationInterface>getInstance(XOperationInterface.class);
    PcmRepresentative<OperationInterface> _setEntity = _instance.setEntity(interfaceEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Event Groups.
   */
  protected void _createInterface(final /* EventGroup */Object interfaceEntity) {
    XEventGroup _instance = this.injector.<XEventGroup>getInstance(XEventGroup.class);
    PcmRepresentative<EventGroup> _setEntity = _instance.setEntity(interfaceEntity);
    _setEntity.transform();
  }
  
  public void createComponent(final CompositeComponent componentEntity) {
    if (componentEntity != null) {
      _createComponent(componentEntity);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(componentEntity).toString());
    }
  }
  
  public void createInterface(final InfrastructureInterface interfaceEntity) {
    if (interfaceEntity != null) {
      _createInterface(interfaceEntity);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(interfaceEntity).toString());
    }
  }
}
