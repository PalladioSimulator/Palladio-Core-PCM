using System.Collections;
using System;

using Palladio.FiniteStateMachines;

namespace Palladio.ParameterisedContracts {

	/// <summary>
	///		A StackState consists of a set of abstract states and a number of 
	///		service names stored as Input. The combination of states and service 
	///		names is leading to an unique identification of each StackState. 
	///		Each abstract state is associated with a service name (the top state with 
	///		the top service), indicating that the state belongs to this service. 
	///		
	///		author: JH
	/// </summary>
	public class StackState : AbstractState {

		/// <summary>
		///		Default name for the top service.
		/// </summary>
		public static Input TOP_SERVICE_NAME = new Input("top");

		/// <summary>
		///		Stack containing all contexts of this state
		/// </summary>
		private Stack contextStack;

		/// <summary>
		///		Creates an empty StackState.
		/// </summary>
		public StackState(){
			contextStack = new Stack();
		}

		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="aState">The copied state.</param>
		public StackState(StackState aState) {
			contextStack = (Stack)aState.contextStack.Clone();
		}


		/// <summary>
		/// Creates a new StackState for a top service.
		/// </summary>
		/// <param name="aState">The state of the top service</param>
		public StackState(IState aState, Input aTopServiceName){
			contextStack = new Stack();
			contextStack.Push(new StackContext(aTopServiceName,aState));
		}


		/// <summary>
		/// Simplyfied version of the above constructor.
		/// </summary>
		/// <param name="aState"></param>
		public StackState(IState aState) : this(aState,StackState.TOP_SERVICE_NAME){}


		/// <summary>
		/// Identifies the name of the state by composing the names 
		/// of its services and abstract states.
		/// </summary>
		public override string Name {
			get {
				string result = "";
				foreach(StackContext con in contextStack){
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
				if (InTopService) {
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
				if (InTopService) {
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
		public void Push(Input aServiceName, IState aState){
			contextStack.Push(new StackContext(aServiceName,aState));
		}


		/// <summary>
		/// Changes the state of the top service effect specification to 
		/// newState.
		/// </summary>
		/// <param name="newState"></param>
		public void ChangeTopState(IState newState){
			try {
				StackContext con = new StackContext((StackContext)contextStack.Pop()); // Create a clone
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
		public StackContext Pop(){
			try{
				if (contextStack.Count > 0) {
					return (StackContext)contextStack.Pop();
				} else {
					throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
				}
			} catch(InvalidOperationException){
				throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
			}
			//			try{
			//				if (contextStack.Count > 1) {
			//					return (Context)contextStack.Pop();
			//				} else {
			//					return Peek();
			//				}
			//			} catch(InvalidOperationException){
			//				throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
			//			}
		}
		

		/// <summary>
		/// Lookup the top context .
		/// </summary>
		/// <returns>Context of the top service</returns>
		public StackContext Peek(){
			try {
				return ((StackContext)contextStack.Peek());
			} catch(InvalidOperationException){
				throw new InvalidStateException("This is not a valid state! - There are no states on the stack.");
			}
		}

		
		/// <summary>
		/// Checks if there are any services left except the top service.
		/// </summary>
		public bool InTopService {
			get { return (contextStack.Count == 1); }
		}

		/// <summary>
		/// Checks if there are any services left.
		/// </summary>
		public bool IsEmpty {
			get { return (contextStack.Count == 0); }
		}
		
		/// <summary>
		///		Lookup the service aServiceName on the service stack.
		/// </summary>
		/// <param name="service">
		///		Name of a service
		///	</param>
		/// <returns>
		///		A copy of this StackState. All services and its associated states  
		///		are removed down to aServiceName. If this StackState does not 
		///		contain aServiceName the result is an empty StackState.
		///	</returns>
		public StackState LookupServiceName(Input aServiceName){
			StackState resultState = new StackState(this);
			while ((!resultState.IsEmpty) && (resultState.Peek().ServiceName != aServiceName)) {
				resultState.Pop();
			}
			return resultState;
		}

		
		/// <summary>
		///		Lookup the second appearance of aServiceName on the service stack.
		/// </summary>
		/// <param name="service">
		///		Name of a service
		///	</param>
		/// <returns>
		///		A copy of this StackState. All services and its associated states are 
		///		removed down to the second appearance of aServiceName. If this 
		///		StackState does not contain aServiceName the result is an empty 
		///		StackState.
		///	</returns>
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
