package runtime;

/**
 * one ComponentPort implements one provided interface and delegates to an
 * instance of the corresponding {@link ComponentInstance} where you can find
 * the implementation
 */
public abstract class ComponentPort implements IComponent {
	protected transient IServiceLocator serviceLocator;
	/**
	 * equals the assemblyContextId
	 * unique for each component instance
	 * to get the correct object at runtime
	 */
	protected String contextId;

	/**
	 * reference to build up a (complex) state of one component instance
	 */
	//private transient ComponentInstance component;
	public abstract void setComponentInstance(IComponentInstance impl);

	/**
	 * standard constructor is empty, 
	 * just used by reflection and the application server
	 */
	public ComponentPort() {
		//empty
	}

	public void setContextId(String id) {
		contextId = id;
	}

}