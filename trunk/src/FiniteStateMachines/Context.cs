using System;
using FiniteStateMachines;

namespace ParameterisedContracts {
	
	/// <summary>
	/// Represents the Context of a FSM. A Context consists of
	/// a service name and a state, which belongs to that service.
	/// 
	/// author: JH
	/// </summary>
	public class StackContext {

		/// <summary>
		/// State of the service.
		/// </summary>
		private AbstractState state;

		/// <summary>
		/// Name of the service
		/// </summary>
		private Input serviceName;

		
		/// <summary>
		/// Default constructor, invisible.
		/// </summary>
		private StackContext() {
		}


		/// <summary>
		/// Creates a new <code>Context</code> with the state <code>aState</code>
		/// for the service <code>aServiceName</code>.
		/// </summary>
		/// <param name="aServiceName">Name of the service</param>
		/// <param name="aState">State of the service</param>
		public StackContext(Input aServiceName, AbstractState aState){
			serviceName = aServiceName;
			state = aState;
		}


		/// <summary>
		/// Copy-Constructor.
		/// </summary>
		/// <param name="aContext"><code>Context</code> which should be cloned</param>
		public StackContext(StackContext aContext){
			serviceName = aContext.ServiceName;
			state = aContext.State;
		}

		/// <summary>
		/// State of the service.
		/// </summary>
		public AbstractState State {
			get {
				return state;
			}
			set {
				state = value;
			}
		}


		/// <summary>
		/// Name of the service
		/// </summary>
		public Input ServiceName {
			get {
				return serviceName;
			}
			set {
				serviceName = value;
			}
		}

		
		/// <summary>
		/// Default implementation.
		/// </summary>
		public override string ToString() {
			return ServiceName + "; " + State;
		}


		/// <summary>
		/// Default implementation.
		/// </summary>
		public object Clone() {
			return new StackContext(this);
		}


		/// <summary>
		/// Default implementation.
		/// </summary>
		public override bool Equals(object obj) {
			if (obj is StackContext) {
				StackContext other = (StackContext)obj;
				return ((State == other.State) && (ServiceName == other.ServiceName));
			}
			return false;
		}


		public override int GetHashCode(){
			string sum = State.ToString();
			sum += ServiceName;
			return sum.GetHashCode();
		}

		/// <summary>
		/// Operator uses the implementation of Equals.
		/// </summary>
		public static bool operator == (StackContext one, StackContext two){
			try {
				return one.Equals(two);
			} catch( NullReferenceException  ) {
				try {
					return two.Equals(one);
				} catch( NullReferenceException ) {
					return true;
				}
			}
		}

		/// <summary>
		/// Operator uses the implementation of Equals.
		/// </summary>
		public static bool operator != (StackContext one, StackContext two){
			try {
				return !one.Equals(two);
			} catch( NullReferenceException  ) {
				try {
					return !two.Equals(one);
				} catch( NullReferenceException ) {
					return false;
				}
			}
		}

	}
}
