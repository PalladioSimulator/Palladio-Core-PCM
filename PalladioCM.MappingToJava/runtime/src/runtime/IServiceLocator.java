package runtime;

/**
 * architecture pattern ServiceLocator
 */
public interface IServiceLocator extends java.io.Serializable {
	/**
	 * delegates to {@link runtime.IServiceLocator#getTargetComponentPort(String, Class)} 
	 * with meaningful String representing a Client as first parameter
	 */
	IComponent getTargetComponentPort(Class reqInterface);

	/**
	 * @param contextId is a valid ContextId from an assembly for the calling
	 * component. This method creates a ComponentContext with the
	 * attribute {@link ComponentContext#contextId} set to name.
	 * @param reqInterface is the classname of the interface the calling component requires.
	 * @return an initialized ComponentPort for a component, if name is valid.
	 * use {@link #getInnerTargetComponentPort} instead when
	 * called from a Composite Component during initialization phase
	 */
	IComponent getTargetComponentPort(String contextId, Class reqInterface);

	/**
	 * @param contexId of the outer provided Role of the composite component that is
	 * delegated to one inner provided Role
	 * @return an initialized {@link ComponentPort} of the inner component
	 */
	IComponent getInnerTargetComponentPort(String contexId, Class provInterface);

	/**
	 * @param contextId AssemblyContextId of the implementation class, not of the Provided Role 
	 * @return implementation of a Component or null, if componentName is not bound
	 */
	IComponentInstance lookupInstance(String contextId);
}