using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	///Represents a FSM.
	/// </summary>
	public class FSM : Getters 
	{
		protected Set inputAl;
		protected Hashtable transitions;
		protected State StartState;
		protected Set FinalSates;
		protected State ErrorState;
		protected bool ErrorStateSet;


		/// <summary>
		/// Creates a FSM
		/// </summary>
		public FSM()
		{
			this.inputAl = new Set();
			this.transitions = new Hashtable();
			this.FinalSates = new Set();
			this.ErrorState = new State("ErrorState",false,false);
			this.ErrorStateSet = true;

		}
		public State getErrorState()
		{
			return new State("ErrorState",false,false);
		}
		/// <summary>
		/// Adds a Transition to the FSM. 
		/// </summary>
		/// <param name="fromState"></param>
		/// <param name="inChar"></param>
		/// <param name="toState"></param>
		public void setTransition(State fromState, Input inChar, State toState)
		{	
			Transition tr = new Transition(fromState, inChar, toState);
			this.setTransition(tr);
		}
		
		/// <summary>
		/// Displays the startstate and the fianalstate of the FSM on the console.
		/// It's a method for testing my implementation of the FSM.
		/// </summary>
		public void writeStartFinal()
		{
			if(this.ErrorStateSet==false)
			{
				this.ErrorStateSet = true;
				this.setErrorStates();
			}
			Console.WriteLine("startstate is: "+this.getStartState().ToString());
			Console.WriteLine("finalstate is: "+this.getFinalStates().ToString());
		}
		/// <summary>
		/// Also for testing
		/// </summary>
		public void DisplayOnConsole()
		{
			if(this.ErrorStateSet==false)
			{
				this.ErrorStateSet = true;
				this.setErrorStates();
			}
			try
			{

				Console.WriteLine("Startstate: "+this.getStartState());
				Console.WriteLine("Finalstate: "+this.getFinalStates());
				Console.WriteLine("Input: ");
				Console.WriteLine(this.inputAl.ToString());
				Console.WriteLine("All transitions: " );
				Console.WriteLine(this.transitionsToString());
			
			}
			catch(Exception e)
			{
				Console.WriteLine("Error !");
				Console.WriteLine(e.Source);
				Console.WriteLine(e.Message);
			}
			
		
		}

		/// <summary>
		/// Another method witch tests the implentation of FSM.
		/// </summary>
		/// <param name="state"></param>
		/// <param name="inChar"></param>
		public string EverythingToString(State state, Input inChar)
		{
			string s ="";
			try
			{
				
				s+="Input: ";
				Set input = this.getInputAl();
					s+= input.ToString()+"\n";
				//Console.WriteLine("-----------------------------");
				s+="Hashtable transitions from "+state.ToString()+": "+"\n";
				Hashtable transitionen = this.getTransitionMap(state);
				IDictionaryEnumerator enu = transitionen.GetEnumerator();
				while(enu.MoveNext())
					s+=enu.Value.ToString()+"\n";
				//Console.WriteLine("-----------------------------");

			
				//next state
				s+="Next state from "+state.ToString()+" : "+"\n";
				State next = this.getNextState(state, inChar);
				s+=next.ToString()+"\n";
				//Console.WriteLine("-----------------------------");
				//all transitions
				s+="All transitions: "+"\n";
				s += this.transitionsToString();
				
			}
			catch(Exception e)
			{
				Console.WriteLine("Error !");
				Console.WriteLine(e.Source);
				Console.WriteLine(e.Message);
			}
			return s;
		
		}
		/// <summary>
		/// Returns the input of the FSM.
		/// </summary>
		/// <returns>The input of the FSM as Set.</returns>
		public Set getInputAl()
		{
			return this.inputAl;
		}
		//RR Implementation of the Getters interface

		/// <summary>
		/// Returns the startatate of the FSM
		/// </summary>
		/// <returns>State, witch is the startstate of the FSM.</returns>
		public State getStartState()
		{
			return this.StartState;

		}
		/// <summary>
		/// Returns the FinalState of the FSM.
		/// </summary>
		/// <returns>State, the fianalstate of the FSM.</returns>
		public Set getFinalStates()
		{
			return this.FinalSates;
		}
		
		/// <summary>
		/// Retruns the next State from a given State and an inputcharacter.
		/// </summary>
		/// <param name="fromState"> from State </param>
		/// <param name="input">the inputcharacter</param>
		/// <returns>the next State witch is reachable with the state and the inputcharacter</returns>
		public State getNextState(State fromState, Input input)
		{
			if(this.ErrorStateSet==false)
			{
				this.ErrorStateSet = true;
				this.setErrorStates();
			}

			if(fromState == null)
				Console.WriteLine("The fromState I got was null");

			if(this.inputAl.Contains(input)== false)
				throw new InvalidInputException();

			
			if(this.transitions.ContainsKey(fromState)==false)
				throw new InvalidStateException();
			

			Object tmp = this.transitions[fromState];
			
				Set a = (Set) tmp;
				IEnumerator k = a.GetEnumerator(); 
				while(k.MoveNext())
				{
					Transition t = (Transition)k.Current;
					if(t.input == input)
						return new State(t.toState);
				}
			//return new State("ErrorState",false,false);
			//ErrorStates must be extra declarated this.setErrotStates();
			throw new ProgrammingErrorException();

			
		}
		/// <summary>
		/// Returns the next possible Transition from a given State and a given Input.
		/// </summary>
		/// <param name="fromState">State from witch the next Transition should be delivered.</param>
		/// <param name="inChar">The inputcharakter witch should be in the delivered Transition.</param>
		/// <returns>The next possible Transition.</returns>
		public Transition getTransition(State fromState, Input inChar) 
		{
			if(this.ErrorStateSet==false)
			{
				this.ErrorStateSet = true;
				this.setErrorStates();
			}
			if(this.inputAl.Contains(inChar) ==  false)
				throw new InvalidInputException();
			
			if(this.transitions.ContainsKey(fromState)!=true)
				throw new InvalidStateException();

			Object tmp = this.transitions[fromState];
				Set s = (Set) tmp;
				Transition back = new Transition();
				Transition tr = new Transition();
				IEnumerator eda = s.GetEnumerator();
				while(eda.MoveNext())
				{
					if(eda.Current is Transition)
						tr = (Transition) eda.Current;
				
					if(tr.input == inChar)
						back = new Transition(tr);
				}
				if(back.input == null)
					throw new InvalidInputException();
				return back;
				/**else
					{
						Console.WriteLine("nothing found!");
						throw new ProgrammingErrorException();
				
					}
					*/
			
			//throw new ProgrammingErrorException();
				
		}

		/// <summary>
		/// Returns all transitions from a given State in a Hashtable.
		/// </summary>
		/// <param name="state">The State from witch all Transitions should be delivered</param>
		/// <returns>All transition from the given state</returns>
		public Hashtable getTransitionMap(State state)
		{
			if(this.ErrorStateSet==false)
			{
				this.ErrorStateSet = true;
				this.setErrorStates();
			}
			Hashtable tmp = new Hashtable();
			Object help = this.transitions[state];
			if(help == null)
				//before a Exception was thrown here, but I changed this, because for further implemetation
				//it'S better to have a null, instad of catch a Exception.
				return null;
			if(help is Set)
			{
				Set s = (Set) help;
				Transition trans = new Transition();
				IEnumerator iter = s.GetEnumerator();
				while(iter.MoveNext())
				{
					trans = (Transition) iter.Current;
					tmp.Add(trans, trans);
				}
				return tmp;
			}
			throw new ProgrammingErrorException();
		}
	
		/// <summary>
		/// Returns all transitions from the FSM in a Transition Array
		/// </summary>
		/// <returns>All Transitions of the FSM in a Array</returns>
		public Transition[] getTransitions()
		{
			if(this.ErrorStateSet==false)
			{
				this.ErrorStateSet = true;
				this.setErrorStates();
			}
			int i = 0;
			DynamicArray tmp = new DynamicArray(i);
			IDictionaryEnumerator myEnumerator = this.transitions.GetEnumerator();
			while ( myEnumerator.MoveNext() )
			{
				Object item = myEnumerator.Value;
				
				if(item is Set)
				{
					Set so = (Set) item;
					foreach(Transition s in so)
					{
						tmp.AddE(s,i);
						i++;
					}
				}
				else
				{
					throw new ProgrammingErrorException();
				}
			}
			Transition[] fi = new Transition[tmp.array.Length];
			int z =0;
			foreach(Transition t in tmp.array)
			{
				
				fi[z] = t;
				//Console.WriteLine(fi[z].ToString());
				z++;
			}
			return fi;

		}
		/// <summary>
		/// Displays all Transition of a FSM on the console.
		/// </summary>
		public string transitionsToString()
		{
			string st ="";
			Transition[] bla = this.getTransitions();
			foreach(Transition tr in bla)
			{
				if(tr.fromState.Equals(this.ErrorState))
					continue;
				if(tr.toState.Equals(this.ErrorState))
					continue;
				st+= tr.ToString()+"\n";
			}
			return st;

		}
	
		//implementation of the  Setters interface.

		/// <summary>
		/// Adds a Transtion to the Transitionmap of the FSM.
		/// </summary>
		/// <param name="tr"></param>
		public void setTransition(Transition tr)
		{	
			//stores only one startState, no exceptionhandling
			if(tr.fromState.getStart()==true)
				this.StartState = tr.fromState;
			if(tr.toState.getFinal()==true)
				this.FinalSates.Add(tr.toState);

			if(this.transitions[tr.fromState] == null)
			{	
				Set tmp = new Set();
				tmp.Add(tr);
				this.transitions.Add(tr.fromState, tmp);
				this.inputAl.Add(tr.input);
			}
			else
			{

				if(this.transitions[tr.fromState] is  Set)
				{ 
					Set tmp = (Set) this.transitions[tr.fromState];
					tmp.Add(tr);
					this.transitions.Remove(tr.fromState);
					this.transitions.Add(tr.fromState,tmp);
					this.inputAl.Add(tr.input);
				}
			}
		}
		/// <summary>
		/// Adds a Array of Ttransitions into the Transitions of a FSM. 
		/// </summary>
		/// <param name="tr">An Array of a Transitions.</param>
		public void setTransitions(Transition[] tr)
		{	
			foreach (Transition t in tr)
				this.setTransition(t);
		}
		public void setErrorStates()
		{
			StateIterator stateIter = new StateIterator(this);
			State actual = new State();
			State next;
			IEnumerator myInputIter;
			while(stateIter.MoveNext())
			{
				actual = (State) stateIter.Current;
				myInputIter = this.getInputAl().GetEnumerator();
				while(myInputIter.MoveNext())
				{
					try
					{
						next = this.getNextState(actual,(Input)myInputIter.Current);
					}
					catch
					{
						this.setTransition(actual,(Input)myInputIter.Current,this.ErrorState);
					}
				}
			}
			myInputIter= this.getInputAl().GetEnumerator();
			while(myInputIter.MoveNext())
			{

				this.setTransition(this.ErrorState, (Input)myInputIter.Current, this.ErrorState);
			}	
				
		}
	}

}
