using System;
using System.Collections;
using FSM;

namespace FSM {

	/// <summary>
	///States used by StackFSM. A StackState consists of a number of 
	///different 'nomral' states and a number of services stored as Input. 
	///The combination of states and services gives it an unique identification.
	///Each of the 'normal' states is associated with one of the services (the first 
	///state belongs to the first service) This indicates that the state belongs 
	///to that service. If there is a state left, but no more service it belongs to the 
	///provides protocol.
	/// </summary>
	public class StackState : State {

		/// <summary>
		/// Stack containing the states of all active services.
		/// </summary>
		private Stack stateStack;

		/// <summary>
		/// Stack containing all active services.
		/// </summary>
		private Stack serviceStack;
		
		/// <summary>
		/// Creates an empty StackState.
		/// </summary>
		public StackState(){
			stateStack = new Stack();
			serviceStack = new Stack();
		}

		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="aState">The copied state.</param>
		public StackState(StackState aState) : base(aState) {
			stateStack = (Stack)aState.stateStack.Clone();
			serviceStack = (Stack)aState.serviceStack.Clone();
		}

		/// <summary>
		/// Creates a Stackstate for a state of the provides protocol.
		/// </summary>
		/// <param name="state">State of the provides protocol</param>
		public StackState(State state){
			stateStack = new Stack();
			serviceStack = new Stack();
			stateStack.Push(state);
		}

		/// <summary>
		/// Stores a state and a service on the stack. The state 
		/// must belong to the service effect specification of the service.
		/// </summary>
		/// <param name="aService">Name of the service</param>
		/// <param name="aState">State of the service</param>
		public void Push(Input aService,State aState){
			serviceStack.Push(aService);
			stateStack.Push(aState);
		}

		public void ChangeTopState(State newState){
			stateStack.Pop();
			stateStack.Push(newState);
		}

		public Input PopService(){
			return (Input)serviceStack.Pop();
		}

		public State PopState(){
			return (State)stateStack.Pop();
		}

		public Input PeekService(){
			return (Input)serviceStack.Peek();
		}

		public State PeekState(){
			return (State) stateStack.Peek();
		}

		public bool IsEmpty {
			get {
				return (serviceStack.Count == 0);
			}
		}

		/// <summary>
		/// Lookup the Service aService in the service stack.
		/// </summary>
		/// <param name="service">Name of a service</param>
		/// <returns>A copy of this StackState. All services and its associated states  
		/// are removed down to aService. If this StackState does not contain aService the 
		/// result is an empty StackState. </returns>
		public StackState LookupService(Input aService){
			StackState resultState = new StackState(this);
			while ((!resultState.IsEmpty) && (resultState.PeekService() != aService)) {
				resultState.PopService();
				resultState.PopState();
			}
			return resultState;
		}

		/// <summary>
		/// Lookup the second appearance of aService in the service stack.
		/// </summary>
		/// <param name="service">Name of a service</param>
		/// <returns>A copy of this StackState. All services and its associated states are 
		/// removed down to the second appearance of aService. If this StackState does not 
		/// contain aService the result is an empty StackState.</returns>
		public StackState LookupServiceTwice(Input service){
			StackState resultState = LookupService(service);
			if(!resultState.IsEmpty) {
				resultState.PopService();
				resultState.PopState();
				return resultState.LookupService(service);
			} else {
				return resultState;
			}
		}

		/// <returns>The name of the current state.</returns>
		public override string getName() {
			string result = "Services: ";
			for (IEnumerator e = serviceStack.GetEnumerator();e.MoveNext();){
				result += (e.Current + " ");
			}
			result += "\n"+"States  : ";
			for (IEnumerator e = stateStack.GetEnumerator();e.MoveNext();){
				result+=(e.Current + " ");
			}
			return result;
		}

		/// <returns>True if the current state is a startstate of the FSM, false otherwise</returns>
		public override bool getStart() {
			if (IsEmpty) {
				return PeekState().getStart();
			}
			return false;
		}


		/// <returns>True if the current state is a final state, false otherwise</returns>
		public override bool getFinal() {
			if (IsEmpty) {
				return PeekState().getFinal();
			}
			return false;
		}

		public State TopState {
			get {
				return PeekState();
			}
		}

		public Input TopService {
			get {
				return PeekService();
			}
		}
	}
}