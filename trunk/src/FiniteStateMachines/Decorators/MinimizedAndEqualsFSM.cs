using System;
using System.Collections;
using Utils.Collections;


namespace FiniteStateMachines.Decorators 
{
	/// <summary>
	/// This class allows to minimizes a Fsm and it also can compare compare FSMs.
	/// When two FSMs should be compared, then the FSMs are minimized, reduce states
	/// are deleted.
	/// For the minimzation a verry popluar algorithmen is used. The states of the FSM
	/// are organized in groups with the same behavior. (Huffmann/Mealy) 
	/// </summary>
	public class MinimizedAndEqualsFSM : FiniteTabularMachine 
	{
		/// <summary>
		/// A FiniteTabluarMachine which should be minimized.
		/// </summary>
		protected IFiniteStateMachine fsm;

		/// <summary>
		/// for debugging 1
		/// </summary>
		protected bool debug = !true;

		/// <summary>
		/// for debugging 2
		/// </summary>
		protected bool createsFsmDebug = !true;

		/// <summary>
		/// for debugging 3
		/// </summary>
		protected bool equalsDebug = !true;

		/// <summary>
		/// A ArrayList which contains the groups 
		/// </summary>
		protected ArrayList groups;

		/// <summary>
		/// This stores the minimized FSM in a FinitTabularMashine
		/// </summary>
		protected FiniteTabularMachine minimized;

		/// <summary>
		/// count the number of group 
		/// </summary>
		protected int counterForNumberOfGroups;

		/// <summary>
		/// a counter which show which group is in the moment served.
		/// </summary>
		protected int actualGroupCounter;

		/// <summary>
		/// ????
		/// </summary>
		protected ArrayList mini;
		

		/// <summary>
		/// A Hashtable which represents a mapping between two FSMs. It is needed when 
		/// two FSMs are compared (calling equals). The keys are the states of a 
		/// first FSM and the values are the states of the other FSM to which the states 
		/// of the first FSM are mapped 
		/// </summary>
		public Hashtable myMin2d;

		/// <summary>
		/// A <code>Set</code> which contains ´the visited states.
		/// </summary>
		protected Set visited;

		/// <summary>
		///  Initates an empty class.
		/// </summary>
		public MinimizedAndEqualsFSM() 
		{
		}


		/// <summary>
		/// Initated this class, and generates a minmized FSM from the given FSM.
		/// </summary>
		/// <param name="notMin">A not minimized FSM, which should be minimized</param>
		public MinimizedAndEqualsFSM(IFiniteStateMachine notMin) 
		{
			this.fsm = notMin;
			this.groups = new ArrayList();
			this.Minimize(notMin);
			this.createNewFsm();
		}


		/// <summary>
		/// Returns the minimized FSM form a given FSM
		/// </summary>
		/// <param name="o">A instance of FSM, which should be minimized</param>
		/// <returns>a Minimized FSM or an empty FSM</returns>
		public FiniteTabularMachine MinOne(object o) 
		{
			if(equal(o))
				return this.minimized;
			else return new FiniteTabularMachine();
		}
	
		/// <summary>
		/// Checks if Minimized is equal to a given FSM.
		/// </summary>
		/// <param name="o">A FSM </param>
		/// <returns>true if they are equal</returns>
		public bool equal(object o) 
		{
			if((o is FiniteTabularMachine)== false)
				return false;
			MinimizedAndEqualsFSM dnotMin = new MinimizedAndEqualsFSM((FiniteTabularMachine) o);
			FiniteTabularMachine d = dnotMin.getMinimizedFSM();
			FiniteTabularMachine myMin = this.minimized;
			bool result = false;
			IEnumerator inputIter = myMin.InputAlphabet.GetEnumerator();
			while(inputIter.MoveNext())
				if(!d.InputAlphabet.Contains((Input) inputIter.Current))
					return false;
			
			Hashtable d2myStatesMap = null;
			try 
			{

				d2myStatesMap = (Hashtable) mapStates(myMin, d);
			}
			catch 
			{
				return false;
			}
			
			result = _equal(myMin, d, d2myStatesMap);
			return result;
		}


		/// <summary>
		/// A inner Method to get the result
		/// </summary>
		/// <param name="myMin">A FSM</param>
		/// <param name="dMin">another FSM</param>
		/// <param name="d2myStatesMap">the mapping</param>
		/// <returns>true if the two FSM are equal</returns>
		protected bool _equal(FiniteTabularMachine myMin, FiniteTabularMachine dMin, Hashtable d2myStatesMap) 
		{
			if(!myMin.StartState.Equals( dMin.StartState))
				return false;
			ArrayList dStates = new ArrayList();
			ArrayList myStates = new ArrayList();
			foreach(DictionaryEntry dic in d2myStatesMap) 
			{
				dStates.Add((AbstractState) dic.Key);
				myStates.Add((AbstractState)dic.Value);
			}
			dStates.TrimToSize();
			myStates.TrimToSize();
			AbstractState dNow = null;
			AbstractState myNow = null;
			if(dStates.Count != myStates.Count)
				return false;
			for(int i= 0; i<dStates.Count; i++) 
			{
				dNow = (AbstractState)dStates[i];
				myNow = (AbstractState) myStates[i];
				if(dNow.IsFinalState) 
				{
					if(!myNow.IsFinalState)
						return false;
				}
				else 
				{
					if(myNow.IsFinalState) 
					{
						return false;
					}
				}
			}
			return true;
		}


		/// <summary>
		/// Produces a Mapping between two FSMs
		/// </summary>
		/// <param name="myMin">A FSM</param>
		/// <param name="d">The other FSM</param>
		/// <returns>A Hashtable which contains the mapping betwenn the two FSMs</returns>
		protected Hashtable mapStates(FiniteTabularMachine myMin,FiniteTabularMachine d) 
		{
			Hashtable d2myMap = new Hashtable();
			d2myMap.Add(d.StartState,myMin.StartState);
			d2myMap.Add(d.ErrorState,myMin.ErrorState);
			mapStates(myMin,myMin.StartState,d,d.StartState,
				d2myMap, new Hashtable());
			return d2myMap;
			
		}


		/// <summary>
		/// Produces a mapping between two states
		/// </summary>
		/// <param name="myMin">A FSM</param>
		/// <param name="myState">A state of myFsm</param>
		/// <param name="d">Another FSM</param>
		/// <param name="dState">A state of the other FSM</param>
		/// <param name="d2myStates">the mapping</param>
		/// <param name="visited">a Hashtable which contains the alreday visted states</param>
		protected void mapStates(FiniteTabularMachine myMin, AbstractState myState, FiniteTabularMachine d, AbstractState dState,
			Hashtable d2myStates, Hashtable visited) 
		{
			foreach(DictionaryEntry da in visited) 
			{
				AbstractState sasa = (AbstractState) da.Value;
				if(myState.Equals(sasa)) 
				{
					return;
				}
			}
			if(visited.Contains(myState))
				return;
			visited.Add(myState,myState);
			AbstractState dNext= null;
			AbstractState myNext = null;
			IEnumerator inputIter = myMin.InputAlphabet.GetEnumerator();
			while(inputIter.MoveNext()) 
			{
				Input currentInput = (Input) inputIter.Current;

				myNext = myMin.GetNextState(myState,currentInput);
				dNext = d.GetNextState(dState,currentInput);
				if(!testStates(myMin,myState,d,dState,currentInput,d2myStates))
					throw new StatesNotMappableException();
				mapStates(myMin, myNext,d,dNext,d2myStates,visited);
			}
		}


		/// <summary>
		/// Controlls if the next states of a FSM are mappable
		/// </summary>
		/// <param name="myMin">A FSM</param>
		/// <param name="myState">A state of MyMin</param>
		/// <param name="d">Another FSM</param>
		/// <param name="dState">A State of d</param>
		/// <param name="i">An Input charakter</param>
		/// <param name="d2myStates">the mapping hashtable</param>
		/// <returns></returns>
		protected bool testStates(FiniteTabularMachine myMin,AbstractState myState, FiniteTabularMachine d, AbstractState dState,
			Input i, Hashtable d2myStates) 
		{
			AbstractState myNext = null;
			AbstractState dNext = null;
			myNext = myMin.GetNextState(myState,i);
			dNext = d.GetNextState(dState ,i);
			if(d2myStates.ContainsKey(dNext)) 
			{
				if(d2myStates[dNext].Equals(myNext)) 
				{
					return true;
				}
				else 
				{
					return false;
				}
				
			}
			d2myStates.Add(dNext,myNext);
			return true;
		}
			

		/// <summary>
		/// Return the notMiniized FSM
		/// </summary>
		/// <returns>Return the notMiniized FSM</returns>
		public IFiniteStateMachine getFSM() 
		{
			return this.fsm;
		}

		public IFiniteStateMachine originallyFiniteTabularMachine
		{
			get
			{
				return this.fsm;
			}
		}


		/// <summary>
		/// Returns the minimzed version of the FSM
		/// </summary>
		/// <returns>Returns the minimzed version of the FSM</returns>
		public FiniteTabularMachine getMinimizedFSM() 
		{
			return this.minimized;
		}


		/// <summary>
		/// A Finite TabularMachine is created from the groups which has been 
		/// found during iteration.
		/// </summary>
		protected void createNewFsm() 
		{
			
			this.minimized = new FiniteTabularMachine();
			int counter =0;
			AbstractState temp;
			ArrayList statesOfMini = new ArrayList();
			ArrayList oldStates = new ArrayList();
			foreach(ArrayList al in this.mini) 
			{
				temp = (AbstractState) al[0];
				AbstractState state = new State("state_"+counter,temp.IsStartState,temp.IsFinalState);
				statesOfMini.Add(state);
				oldStates.Add((AbstractState) al[0]);
				counter++;
			}
			statesOfMini.TrimToSize();
			if(this.createsFsmDebug) 
			{
				Console.WriteLine("The states of the minimized FSM: ");
				foreach(AbstractState s in statesOfMini)
					Console.WriteLine(s.ToString());
				Console.WriteLine("-------------------------");
			}
			for(int i = 0;i<statesOfMini.Count; i++) 
			{
				IEnumerator oldFsmInputIter = (IEnumerator)this.fsm.InputAlphabet.GetEnumerator();
				while(oldFsmInputIter.MoveNext()) 
				{
					AbstractState toState  = (AbstractState) this.fsm.GetNextState((AbstractState)oldStates[i],
						(Input)oldFsmInputIter.Current);
					if(toState == fsm.ErrorState) 
					{
						continue;
					}
					ArrayList newGroups = this.inGroup(toState,this.groups);
					int indexOfStateToState = this.mini.IndexOf((ArrayList) 
						this.inGroup(toState,this.mini));
					this.minimized.addTransition((AbstractState) statesOfMini[i],
						(Input)oldFsmInputIter.Current,
						(AbstractState) statesOfMini[indexOfStateToState]);
				}
			}
		}


		/// <summary>
		/// Removes the ErrorGroups from this.groups
		/// </summary>
		/// <param name="g">The group with should be removed</param>
		protected void RemoveErrorGroup(ArrayList g) 
		{
			ArrayList erroG = new ArrayList();
			erroG.Add(this.fsm.ErrorState);
			erroG.TrimToSize();
			foreach(ArrayList al in g) 
			{
				al.TrimToSize();
				foreach(AbstractState t in al) 
				{
					if(t.Equals(fsm.ErrorState)) 
					{
						g.Remove(al);
						return;
					}
				}
			}		
		}


		/// <summary>
		/// Minimizes a FSM 
		/// </summary>
		/// <param name="fsm">The FSM which should be minimized</param>
		protected  void Minimize(IFiniteStateMachine fsm) 
		{	
			this.initateGroups(fsm);
			if(this.debug) 
			{
				Console.WriteLine("IntialGroups");
				this.printGroups();
			}
			bool furtherIteration = false;
			this.actualGroupCounter = 0;
			while(this.actualGroupCounter< this.groups.Count || furtherIteration) 
			{
				furtherIteration = false;
				if(this.debug) 
				{
					Console.WriteLine("Number of Groups: "
						+this.counterForNumberOfGroups.ToString());
					Console.WriteLine("this.actualGroupCounter is : "
						+this.actualGroupCounter.ToString());
				}
				AbstractState first = null;
				AbstractState next = null;
				ArrayList newGroup = new ArrayList();
				ArrayList actualGroup = (ArrayList) this.groups[this.actualGroupCounter];
				if(actualGroup.Count == 1) 
				{
					this.actualGroupCounter++;
					continue;
				}
				actualGroup.TrimToSize();
				int lengthOfActualGroup = actualGroup.Count;
				first = (AbstractState) actualGroup[0];
				if(this.debug) 
				{
					Console.WriteLine("First is : "+first.ToString());
				}
				for(int i=1; i< lengthOfActualGroup; i++) 
				{
					next = (AbstractState) actualGroup[i];
					if(this.debug)
						Console.WriteLine("Next is : "+next.ToString());
					IEnumerator InputIter = fsm.InputAlphabet.GetEnumerator();
					while(InputIter.MoveNext()) 
					{
						Input currentInput = (Input) InputIter.Current;
						if(this.debug) 
						{
							Console.WriteLine("Reached states: ");
							Console.WriteLine("Current Input: "+currentInput.ToString());
							Console.WriteLine("first leads to: "+
								fsm.GetNextState(first,currentInput));
							Console.WriteLine("Next leads to: "+
								fsm.GetNextState(next,currentInput));
						}
						if(!sameGroup(fsm.GetNextState(first,currentInput),
							fsm.GetNextState(next,currentInput),newGroup)) 
						{
							if(this.debug) 
							{
								Console.WriteLine("States are not in the same Group");
							}
							if(!newGroup.Contains(next)) 
							{
								newGroup.Add(next);
								furtherIteration = true;
							}
							newGroup.TrimToSize();

						}
					}
				}
				//move elements
				if(newGroup.Count >0) 
				{
					MoveGroups(newGroup, actualGroup);
				}
				this.actualGroupCounter++;
			}
			this.tidyUp();
		}


		/// <summary>
		/// if a new group has been created this addes it to the exsiting groups.
		/// </summary>
		/// <param name="newGroup"></param>
		/// <param name="actualGroup"></param>
		private void MoveGroups(ArrayList newGroup, ArrayList actualGroup)
		{
			if(this.debug) 
			{
				Console.WriteLine("A new group has been created, it contains: ");
			}
			this.counterForNumberOfGroups++;
			this.groups.Add(newGroup);
			this.groups.TrimToSize();
			foreach(AbstractState s  in newGroup) 
			{
				if(actualGroup.Contains(s)) 
				{
					actualGroup.Remove(s);
				}
			}
			actualGroup.TrimToSize();
			this.groups.Remove(this.actualGroupCounter);

			this.groups.Insert(this.actualGroupCounter,actualGroup);
		}


		/// <summary>
		/// A method for debugging, desplays all elements of this.groups on the console
		/// </summary>
		protected void printGroups() 
		{
			foreach(ArrayList al in this.groups)
				this.printGroup(al);
		}


		/// <summary>
		/// checks if two states are in the same group
		/// </summary>
		/// <param name="first">the first state</param>
		/// <param name="next">the other state</param>
		/// <param name="newGroup">the new group, which has been initatited during 
		/// group Iteration. The elements which will be moved into the new group.
		/// </param>
		/// <returns>true, if the two given states are in the same group</returns>
		protected bool sameGroup(AbstractState first, AbstractState next, ArrayList newGroup) 
		{
			if(inGroup(first,newGroup)==inGroup(next,newGroup))
				return true;
			return false;	
		}


		/// <summary>
		/// Delivers the group in which a state is in
		/// </summary>
		/// <param name="state">the state which group should be found/>
		/// <param name="groups">a group which has not jet been added to this.groups.
		/// it's the newGroup./>
		/// <returns>A ArrayList from this.groups which contains state</returns>
		protected ArrayList inGroup(AbstractState state, ArrayList groups) 
		{

			if(groups.Contains(state))
				return groups;
			if(groups.Contains(fsm.ErrorState)) 
			{
				Console.WriteLine("in group has found ErrorState");
				return groups;
			}
			foreach(ArrayList al in this.groups) 
			{
				foreach(AbstractState s in al)
					if(s.Equals(state))
						return al;
			}
			throw new ProgrammingErrorException();
		}


		/// <summary>
		/// After iteration there are double groups in this.groups and here this groups are removed
		/// </summary>
		protected void tidyUp() 
		{
			ArrayList actualElement = new ArrayList();
			ArrayList newThisGroups = new ArrayList();
			ArrayList temp = new ArrayList();
			foreach(ArrayList al in this.groups) 
			{
				if(!newThisGroups.Contains(al))
					newThisGroups.Add(al);
			}
			this.mini = newThisGroups;
			this.RemoveErrorGroup(this.mini);
			this.groups = this.mini;
		}


		/// <summary>
		/// Delivers the initail partions 
		/// </summary>
		public void initateGroups(IFiniteStateMachine fsm) 
		{

			ArrayList conclusion = new ArrayList();
			ArrayList final = new ArrayList();
			ArrayList notFinal = new ArrayList();

			//is uses when startstate == finalstate;
			ArrayList both = new ArrayList();

			//in the beginig of minimation there are  only 2 (3) partions, the acceptiong and non accepting.
			StateIterator iter = new StateIterator(fsm);
			AbstractState actualState = null;
			while(iter.MoveNext()) 
			{
				both = null;
				actualState = (AbstractState) iter.Current;
				if(actualState.IsFinalState) 
				{
					if(actualState.IsStartState) 
					{
						both = new ArrayList();
						both.Add(actualState);
						both.TrimToSize();
					}
					final.Add(actualState);
				}
				else
					notFinal.Add(actualState);
			}
			final.TrimToSize();
			conclusion.Add(final);
			notFinal.TrimToSize();
			conclusion.Add(notFinal);
			this.counterForNumberOfGroups = 2;
			if(both != null) 
			{
				both.TrimToSize();
				conclusion.Add(both);
				this.counterForNumberOfGroups++;
			}
			ArrayList eGroup = new ArrayList();
			eGroup.Add(fsm.ErrorState);
			conclusion.Add(eGroup);
			conclusion.TrimToSize();
			this.groups = conclusion;
		}


		/// <summary>
		/// Another method for debugging, prints a elemenet of this.groups
		/// </summary>
		/// <param name="group">The group which should be displayed on the console</param>
		protected void printGroup(ArrayList group) 
		{
			IEnumerator iter = group.GetEnumerator();
			while(iter.MoveNext()) 
			{
				Console.WriteLine(iter.Current.ToString());
			}
			Console.WriteLine("---End of Group----");
		}
	}
}
