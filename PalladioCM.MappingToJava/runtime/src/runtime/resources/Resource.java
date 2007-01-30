package runtime.resources;

/**
 * semaphore implementieren
 */
public class Resource extends java.util.concurrent.Semaphore {
	private static final long serialVersionUID = 10L;
	private String name, id;

	/**
	 * constructor for mutex
	 * @param name
	 * @param id
	 */
	Resource(String name, String id) {
		this(name, id, 1);
	}

	/**
	 * constructor for semaphore delegates to super(int permits)
	 * @param name
	 * @param id
	 */
	Resource(String name, String id, int n) {
		super(n);
		this.name = name;
		this.id = id;
	}
	
	String getId() {
		return id;
	}
	
	String getName() {
		return name;
	}
}