using System.Collections;
using System;

namespace FiniteStateMachines {

	/// <summary>
	///A <code>StackState</code> consists of a set of abstract states and a number of 
	///service names stored as <code>Input</code>. 
	///The combination of states and service names is leading to an unique identification of
	///each <code>StackState</code>. Each abstract state is associated with a service name 
	///(the top state with the top service), indicating that the state belongs 
	///to this service. The last abstract state belongs to the provides protocol.
	/// </summary>
	public class StackState : AbstractState {

		/// <summary>
		/// Default name for the top service.
		/// </summary>
		public static string TOP_SERVICE_NAME = "top";

		/// <summary>
		/// Stack containing all contexts of this state
		/// </summary>
		private Stack contextStack;

		/// <summary>
		/// Creates an empty StackState. Invisible to the public.
		/// </summary>
		private StackState(){
		}


		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="aState">The copied state.</param>
		public StackState(StackState aState) {
			contextStack = (Stack)aState.contextStack.Clone();
		}


		/// <summary>
		/// Creates a new <code>StackState</code> for a top service.
		/// </summary>
		/// <param name="aState">The state of the top service</param>
		public StackState(AbstractState aState){
			contextStack = new Stack();
			contextStack.Push(new Context(new Input(TOP_SERVICE_NAME),aState));
		}


		/// <summary>
		/// Identifies the name of the state by composing the names 
		/// of its services and abstract states.
		/// </summary>
		public override string Name {
			get {
				string result = "";
				foreach(Context con in contextStack){
					result+="("+con+") ";
				}
				return result;
			}
		}


		/// <summary>
		/// True, if the top state belongs to the provides protocol and it
		/// is a start state, otherwise false.
		/// </summary>
		public override bool IsStartState {
			get {
				if (IsEmpty) {
					return Peek().State.IsStartState;
				}
				return false;
			}
		}


		/// <summary>
		/// True, if the top state belongs to the provides protocol and it
		/// is a final state, otherwise false.
		/// </summary>
		public override bool IsFinalState {
			get {
				if (IsEmpty) {
					return Peek().State.IsFinalState;
				}
				return false;
			}
		}
		
		
		/// <summary>
		/// Stores a state and a service name on the stack. The state 
		/// must belong to the service effect specification of the service.
		/// </summary>
		/// <param name="aService">Name of the service</param>
		/// <param name="aState">State of the service</param>
		public void Push(Input aServiceName, AbstractState aState){
			contextStack.Push(new Context(aServiceName,aState));
		}


		/// <summary>
		/// Changes the state of the top service effect specification to 
		/// <code>newState</code>.
		/// </summary>
		/// <param name="newState"></param>
		public void ChangeTopState(AbstractState newState){
			try {
				Context con = new Context((Context)contextStack.Pop()); // Create a clone
				con.State = newState;
				contextStack.Push(con);
			} catch(InvalidOperationException) {
				throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
			}
		}

		
		/// <summary>
		/// Pops the top context.
		/// </summary>
		/// <returns>Top context</returns>
		public Context Pop(){
			try{
				if (contextStack.Count > 1) {
					return (Context)contextStack.Pop();
				} else {
					return Peek();
				}
			} catch(InvalidOperationException){
				throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
			}
		}
		

		/// <summary>
		/// Lookup the top context .
		/// </summary>
		/// <returns>Context of the top service</returns>
		public Context Peek(){
			try {
				return ((Context)contextStack.Peek());
			} catch(InvalidOperationException){
				throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
			}
		}

		
		/// <summary>
		/// Checks if there are any services left except the top service.
		/// </summary>
		public bool IsEmpty {
			get { return (contextStack.Count == 1); }
		}

		
		/// <summary>
		/// Lookup the service <code>aServiceName</code> on the service stack.
		/// </summary>
		/// <param name="service">Name of a service</param>
		/// <returns>A copy of this StackState. All services and its associated states  
		/// are removed down to <code>aServiceName</code>. If this StackState does not 
		/// contain <code>aServiceName</code> the result is an empty <code>StackState</code>
		/// containg only the state of the provides protocol.</returns>
		public StackState LookupServiceName(Input aServiceName){
			StackState resultState = new StackState(this);
			while ((!resultState.IsEmpty) && (resultState.Peek().ServiceName != aServiceName)) {
				resultState.Pop();
			}
			return resultState;
		}

		
		/// <summary>
		/// Lookup the second appearance of <code>aServiceName</code> on the service stack.
		/// </summary>
		/// <param name="service">Name of a service</param>
		/// <returns>A copy of this StackState. All services and its associated states are 
		/// removed down to the second appearance of <code>aServiceName</code>. If this 
		/// StackState does not contain <code>aServiceName</code> the result is an empty 
		/// StackState containg only the state of the provides protocol.</returns>
		public StackState LookupServiceNameTwice(Input aServiceName){
			StackState resultState = LookupServiceName(aServiceName);
			if(!resultState.IsEmpty) {
				resultState.Pop();
				return resultState.LookupServiceName(aServiceName);
			} else {
				return resultState;
			}
		}
	}
}
