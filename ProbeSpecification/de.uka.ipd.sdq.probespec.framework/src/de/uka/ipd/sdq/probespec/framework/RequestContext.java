package de.uka.ipd.sdq.probespec.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the execution context of a request. Normally the
 * execution context of a request is the thread which processes this request.
 * Then the thread's id is a unique identifier for this execution context.
 * <p>
 * A RequestContext simply wraps an identifier that represents the execution
 * context clearly. The thread id is such an identifier.
 * <p>
 * In order to represent a sequence of requests so that request1 spawned
 * request2, which in turn spawned request3 and so forth, a parent context can
 * be specified by using constructor
 * {@link #RequestContext(String, RequestContext)}. In this way the
 * execution of forks can be represented.
 * 
 * @author Faber
 * @author Philipp Merkle
 * 
 */
public class RequestContext {

	public static final RequestContext EMPTY_REQUEST_CONTEXT = new RequestContext("");
	
	// unique identifier of the request context
	private String requestContextId;

	private RequestContext parentContext;
	
	private List<RequestContext> childContexts;

	/**
	 * Default Constructor. 
	 * 
	 * @param requestContextId
	 *            the unique identifier of the request context
	 */
	public RequestContext(String requestContextId) {
		this(requestContextId, null);
	}

	/**
	 * Constructor to be used when there is a parent context.
	 * 
	 * @param requestContextId
	 *            the unique identifier of the request context
	 * @param parentContext
	 *            the parent context of the context which is to be constructed
	 */
	public RequestContext(String requestContextId, RequestContext parentContext) {
		this.requestContextId = requestContextId;
		this.parentContext = parentContext;
		
		if (parentContext != null) {
			parentContext.addChildContext(this);
		}
		
		if (this.requestContextId == null) {
			this.requestContextId = "";
		}
	}

	/**
	 * Returns the unique identifier of the request context represented by this
	 * object.
	 * 
	 * @return the request context identifier
	 */
	public String getRequestContextId() {
		return requestContextId;
	}

	public RequestContext getParentContext() {
		return parentContext;
	}
	
	private void addChildContext(RequestContext context) {
		if (childContexts == null) {
			childContexts = new ArrayList<RequestContext>();
		}
		childContexts.add(context);
	}
	
	public List<RequestContext> getChildContexts() {
		if (childContexts == null) {
			return null;
		}
		return Collections.unmodifiableList(childContexts);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((parentContext == null) ? 0 : parentContext.hashCode());
		result = prime * result
				+ ((requestContextId == null) ? 0 : requestContextId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RequestContext)) {
			return false;
		}
		RequestContext other = (RequestContext) obj;
		if (parentContext == null) {
			if (other.parentContext != null) {
				return false;
			}
		} else if (!parentContext.equals(other.parentContext)) {
			return false;
		}
		if (requestContextId == null) {
			if (other.requestContextId != null) {
				return false;
			}
		} else if (!requestContextId.equals(other.requestContextId)) {
			return false;
		}
		return true;
	}

	/**
	 * Appends the specified addition to the request context id and returns a
	 * new {@link RequestContext} containing the extended request context id.
	 * The parent context will be retained.
	 * 
	 * @param addition
	 *            the String to append
	 * @return
	 */
	public RequestContext append(String addition) {
		return new RequestContext(getRequestContextId() + addition,
				getParentContext());
	}
	
	public RequestContext rootContext() {
		RequestContext context = this;
		while (context.getParentContext() != null) {
			context = context.getParentContext();
		}
		return context;
	}
	
	@Override
	public String toString() {
		return parentContext != null ? parentContext.toString() + " called "
				+ "<" + requestContextId + ">" : "<" + requestContextId + ">";
	}

}
