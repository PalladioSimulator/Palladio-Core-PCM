using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// This class allows to minimize and compares FSM
	/// </summary>
	public class FEC : FSM
	{
		protected FSM fsm;
		protected bool debug = !true;
		protected bool createsFsmDebug = !true;
		protected bool equalsDebug = !true;
		protected ArrayList groups;
		protected int zaehler;
		protected FSM minimized;
		protected int counterForNumberOfGroups;
		protected int actualGroupCounter;
		protected ArrayList mini;
		// for equals
		public Hashtable myMin2d;
		protected Set visited;

		/// <summary>
		/// A temp Konstruktor
		/// </summary>
		public FEC()
		{
		}
		/// <summary>
		/// A temp Konstruktor
		/// </summary>
		/// <param name="notMin">A not minimized FSM, witch should be minimized</param>
		public FEC(FSM notMin)
		{
			this.fsm = notMin;
			this.groups = new ArrayList();
			this.Minimize(notMin);
			this.createNewFsm();
			this.minimized.DisplayOnConsole();
//						if(this.debug)
//						{
//							Console.WriteLine("After Minmasation the follwing groups exzits:");
//							this.printGroups();
//						}
		}

		/// <summary>
		/// Returns the minimized FSM form a given FSM
		/// </summary>
		/// <param name="o">A instance of FSM, witch should be minimized</param>
		/// <returns>a Minimized FSM or an empty FSM</returns>
		public FSM MinOne(object o)
		{
			if(equal(o))
				return this.minimized;
			else return new FSM();
		}
	
		/// <summary>
		/// checks if this.Minimized is equal to a given FSM.
		/// </summary>
		/// <param name="o">A FSM </param>
		/// <returns>true if they are equal</returns>
		public bool equal(object o)
		{
			if((o is FSM)== false)
				return false;
			FEC dnotMin = new FEC((FSM) o);
			FSM d = dnotMin.getMinimizedFSM();
			FSM myMin = this.minimized;
			bool result = false;
			IEnumerator inputIter = myMin.getInputAl().GetEnumerator();
			while(inputIter.MoveNext())
				if(!d.getInputAl().Contains((Input) inputIter.Current))
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
		protected bool _equal(FSM myMin, FSM dMin, Hashtable d2myStatesMap)
		{
			if(!myMin.getStartState().Equals( dMin.getStartState()))
				return false;
			ArrayList dStates = new ArrayList();
			ArrayList myStates = new ArrayList();
			foreach(DictionaryEntry dic in d2myStatesMap)
			{
				dStates.Add((State) dic.Key);
				myStates.Add((State)dic.Value);
			}
			dStates.TrimToSize();
			myStates.TrimToSize();
			State dNow = null;
			State myNow = null;
			if(dStates.Count != myStates.Count)
				return false;
			for(int i= 0; i<dStates.Count; i++)
			{
				dNow = (State)dStates[i];
				myNow = (State) myStates[i];
				if(dNow.getFinal())
				{
					if(!myNow.getFinal())
						return false;
				}
				else
				{
					if(myNow.getFinal())
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
		/// <returns>A Hashtable witch contains the mapping betwenn the two FSMs</returns>
		protected Hashtable mapStates(FSM myMin,FSM d)
		{
			Hashtable d2myMap = new Hashtable();
			d2myMap.Add(d.getStartState(),myMin.getStartState());
			d2myMap.Add(d.ErrorState,myMin.ErrorState);
			mapStates(myMin,myMin.getStartState(),d,d.getStartState(),
				d2myMap, new Hashtable());
			return d2myMap;
			
		}
		/// <summary>
		/// Produces a´mapping between two states
		/// </summary>
		/// <param name="myMin">A FSM</param>
		/// <param name="myState">A state of myFsm</param>
		/// <param name="d">Another FSM</param>
		/// <param name="dState">A state of the other FSM</param>
		/// <param name="d2myStates">the mapping</param>
		/// <param name="visited">a Hashtable witch contains the alreday visted states</param>
		protected void mapStates(FSM myMin, State myState, FSM d, State dState,
			Hashtable d2myStates, Hashtable visited)
		{
			foreach(DictionaryEntry da in visited)
			{
				State sasa = (State) da.Value;
				if(myState.Equals(sasa))
				{
					return;
				}
			}
			if(visited.Contains(myState))
				return;
			visited.Add(myState,myState);
			State dNext= null;
			State myNext = null;
			IEnumerator inputIter = myMin.getInputAl().GetEnumerator();
			while(inputIter.MoveNext())
			{
				Input currentInput = (Input) inputIter.Current;
//				foreach(State s in myMin.getStates())
//				{
//					if(myState.Equals(s))
//					{

						myNext = myMin.getNextState(myState,currentInput);
//						break;
//					}
//				}
//				foreach(State z in d.getStates())
//				{
//					if(z.Equals(dState))
//					{
						dNext = d.getNextState(dState,currentInput);
//						break;
//					}
//				}
				
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
		protected bool testStates(FSM myMin,State myState, FSM d, State dState,
			Input i, Hashtable d2myStates)
		{
			State myNext = null;
			State dNext = null;

		
//			foreach(State s in myMin.getStates())
//			{
//
//				if(myState.Equals(s))
//				{
					myNext = myMin.getNextState(myState,i);
//					break;
//				}
//			}
//			foreach(State z in d.getStates())
//			{
//				if(z.Equals(dState))
//				{
					dNext = d.getNextState(dState ,i);
//					break;
//				}
//			}

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
		public FSM getFSM()
		{
			return this.fsm;
		}
		/// <summary>
		/// Returns the minimzed version of the FSM
		/// </summary>
		/// <returns>Returns the minimzed version of the FSM</returns>
		public FSM getMinimizedFSM()
		{
			return this.minimized;
		}
		/// <summary>
		/// Creates the minimized FSM
		/// </summary>
		protected void createNewFsm()
		{
			
			this.minimized = new FSM();
			int counter =0;
			State temp;
			ArrayList statesOfMini = new ArrayList();
			ArrayList oldStates = new ArrayList();
			foreach(ArrayList al in this.mini)
			{
				
				temp = (State) al[0];
				State state = new State("state_"+counter,temp.getStart(),temp.getFinal());
				statesOfMini.Add(state);
				oldStates.Add((State) al[0]);
				counter++;
			}
			statesOfMini.TrimToSize();
			if(this.createsFsmDebug)
			{
				Console.WriteLine("The states of the minimized FSM: ");
				foreach(State s in statesOfMini)
					Console.WriteLine(s.ToString());
				Console.WriteLine("-------------------------");
			}
			for(int i = 0;i<statesOfMini.Count; i++)
			{
				IEnumerator oldFsmInputIter = (IEnumerator)this.fsm.getInputAl().GetEnumerator();
				while(oldFsmInputIter.MoveNext())
				{
					State toState  = (State) this.fsm.getNextState((State)oldStates[i],
						(Input)oldFsmInputIter.Current);
		
					//Console.WriteLine("toState is: "+toState.ToString());
					if(toState == fsm.ErrorState)
					{
						//Console.WriteLine("ErrorState found");
						continue;
					}
					ArrayList newGroups = this.inGroup(toState,this.groups);
					int indexOfStateToState = this.mini.IndexOf((ArrayList) 
						this.inGroup(toState,this.mini));
					this.minimized.setTransition((State) statesOfMini[i],
						(Input)oldFsmInputIter.Current,
						(State) statesOfMini[indexOfStateToState]);
				}
			}
		}
		/// <summary>
		/// Removes the ErrorGroups from this.groups
		/// </summary>
		/// <param name="g">The groupwith should be removed</param>
		protected void RemoveErrorGroup(ArrayList g)
		{

			ArrayList erroG = new ArrayList();
			erroG.Add(this.fsm.ErrorState);
			erroG.TrimToSize();
			foreach(ArrayList al in g)
			{
				al.TrimToSize();
				foreach(State t in al)
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
		/// <param name="fsm">The FSM witch should be minimized</param>
		protected  void Minimize(FSM fsm)
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
				State first = new State();
				State next = new State();
				ArrayList newGroup = new ArrayList();
				ArrayList actualGroup = (ArrayList) this.groups[this.actualGroupCounter];
				if(actualGroup.Count == 1)
				{
					this.actualGroupCounter++;
					continue;
				}
				actualGroup.TrimToSize();
				int lengthOfActualGroup = actualGroup.Count;
				first = (State) actualGroup[0];
				if(this.debug)
				{
					Console.WriteLine("First is : "+first.ToString());
				}
				for(int i=1; i< lengthOfActualGroup; i++)
				{
					next = (State) actualGroup[i];
					if(this.debug)
						Console.WriteLine("Next is : "+next.ToString());
					IEnumerator InputIter = fsm.getInputAl().GetEnumerator();
					while(InputIter.MoveNext())
					{
						Input currentInput = (Input) InputIter.Current;
						if(this.debug)
						{
							Console.WriteLine("Reached states: ");
							Console.WriteLine("Current Input: "+currentInput.ToString());
							Console.WriteLine("first leads to: "+
								fsm.getNextState(first,currentInput));
							Console.WriteLine("Next leads to: "+
								fsm.getNextState(next,currentInput));
						}
						if(!sameGroup(fsm.getNextState(first,currentInput),
							fsm.getNextState(next,currentInput),newGroup))
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
					if(this.debug)
					{
						Console.WriteLine("A new group has been created, it contains: ");
					}
					this.counterForNumberOfGroups++;
					this.groups.Add(newGroup);
					this.groups.TrimToSize();
					foreach(State s  in newGroup)
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
				this.actualGroupCounter++;
			}
			this.tidyUp();
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
		/// <param name="newGroup">the new group, witch has been initatited during 
		/// group Iteration. The elements witch will be moved into the new group.
		/// </param>
		/// <returns>true, if the two given states are in the same group</returns>
		protected bool sameGroup(State first, State next, ArrayList newGroup)
		{
			if(inGroup(first,newGroup)==inGroup(next,newGroup))
				return true;
			return false;	
		}
		/// <summary>
		/// Delivers the group in witch a state is in
		/// </summary>
		/// <param name="state">the state witch group should be found</param>
		/// <param name="groups">a group witch has not jet been added to this.groups.
		/// it's the newGroup.
		/// <returns>A ArrayList from this.groups witch contains state</returns>
		protected ArrayList inGroup(State state, ArrayList groups)
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
				foreach(State s in al)
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
		public void initateGroups(FSM fsm)
		{

			ArrayList conclusion = new ArrayList();
			ArrayList final = new ArrayList();
			ArrayList notFinal = new ArrayList();

			//is uses when startstate == finalstate;
			ArrayList both = new ArrayList();

			//in the beginig of minimation there are  only 2 (3) partions, the acceptiong and non accepting.
			StateIterator iter = new StateIterator(fsm);
			State actualState = new State();
			while(iter.MoveNext())
			{
				both = null;
				actualState = (State) iter.Current;

//								//now useless
//								if(actualState.Equals(new State("ErrorState",false,false)))
//								{
//									if(debug)
//										Console.WriteLine("ErrorState in init found!");
//									
//								}
				if(actualState.getFinal())
				{
					if(actualState.getStart())
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
		/// <param name="group">The group witch should be displayed on the console</param>
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
