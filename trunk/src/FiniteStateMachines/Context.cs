using System;
using FiniteStateMachines;

namespace ParameterisedContracts {
	
	/// <summary>
	/// Represents the Context of a FSM. A Context consists of
	/// a service name and a state, which belongs to that service.
	/// </summary>
	public class Context {

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
		private Context() {
		}


		/// <summary>
		/// Creates a new <code>Context</code> with the state <code>aState</code>
		/// for the service <code>aServiceName</code>.
		/// </summary>
		/// <param name="aServiceName">Name of the service</param>
		/// <param name="aState">State of the service</param>
		public Context(Input aServiceName, AbstractState aState){
			serviceName = aServiceName;
			state = aState;
		}


		/// <summary>
		/// Copy-Constructor.
		/// </summary>
		/// <param name="aContext"><code>Context</code> which should be cloned</param>
		public Context(Context aContext){
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
		/// <returns></returns>
		public override string ToString() {
			return ServiceName + "; " + State;
		}


		/// <summary>
		/// Default implementation.
		/// </summary>
		/// <returns></returns>
		public object Clone() {
			return new Context(this);
		}


		/// <summary>
		/// Default implementation.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj) {
			if (obj is Context) {
				Context other = (Context)obj;
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
		/// <param name="one"></param>
		/// <param name="two"></param>
		/// <returns></returns>
		public static bool operator == (Context one, Context two){
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
		/// <param name="one"></param>
		/// <param name="two"></param>
		/// <returns></returns>
		public static bool operator != (Context one, Context two){
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
