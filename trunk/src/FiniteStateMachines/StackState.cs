using System.Collections;

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
		/// Stack containing the states of all active services.
		/// </summary>
		private Stack stateStack;

		/// <summary>
		/// Stack containing the names of all active services.
		/// </summary>
		private Stack serviceNameStack;
		

		/// <summary>
		/// Creates an empty StackState. Invisible to the public.
		/// </summary>
		private StackState(){
			stateStack = new Stack();
			serviceNameStack = new Stack();
		}


		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="aState">The copied state.</param>
		public StackState(StackState aState) {
			stateStack = (Stack)aState.stateStack.Clone();
			serviceNameStack = (Stack)aState.serviceNameStack.Clone();
		}


		/// <summary>
		/// Creates a new <code>StackState</code> for an abstract state.
		/// It belongs to the provides protocol.
		/// </summary>
		/// <param name="state">An abstract state of the provides protocol</param>
		public StackState(AbstractState aState){
			stateStack = new Stack();
			serviceNameStack = new Stack();
			stateStack.Push(aState);
		}


		/// <summary>
		/// Identifies the name of the state by composing the names 
		/// of its services and abstract states.
		/// </summary>
		public override string Name {
			get {
				string result = "s: ";
				for (IEnumerator e = serviceNameStack.GetEnumerator();e.MoveNext();){
					result += (e.Current + " ");
				}
				result += "\t"+"q: ";
				for (IEnumerator e = stateStack.GetEnumerator();e.MoveNext();){
					result+=(e.Current + " ");
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
					return PeekState().IsStartState;
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
					return PeekState().IsFinalState;
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
			serviceNameStack.Push(aServiceName);
			stateStack.Push(aState);
		}


		/// <summary>
		/// Changes the state of the top service effect specification to 
		/// <code>newState</code>.
		/// </summary>
		/// <param name="newState"></param>
		public void ChangeTopState(AbstractState newState){
			stateStack.Pop();
			stateStack.Push(newState);
		}

		
		/// <summary>
		/// Pop the name of the service on top.
		/// </summary>
		/// <returns>Name of the top service</returns>
		public Input PopServiceName(){
			return (Input)serviceNameStack.Pop();
		}

		
		/// <summary>
		/// Pop the state of the service on top.
		/// </summary>
		/// <returns>State of the top service</returns>
		public AbstractState PopState(){
			return (AbstractState)stateStack.Pop();
		}

		
		/// <summary>
		/// Lookup the name of the service on top.
		/// </summary>
		/// <returns>Name of the top service</returns>
		public Input PeekServiceName(){
			return (Input)serviceNameStack.Peek();
		}

		
		/// <summary>
		/// Lookup the state of the service on top.
		/// </summary>
		/// <returns>State of the top service</returns>
		public AbstractState PeekState(){
			return (AbstractState) stateStack.Peek();
		}

		
		/// <summary>
		/// Checks if there are any services left.
		/// </summary>
		public bool IsEmpty {
			get { return (serviceNameStack.Count == 0); }
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
			while ((!resultState.IsEmpty) && (resultState.PeekServiceName() != aServiceName)) {
				resultState.PopServiceName();
				resultState.PopState();
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
				resultState.PopServiceName();
				resultState.PopState();
				return resultState.LookupServiceName(aServiceName);
			} else {
				return resultState;
			}
		}
	}
}