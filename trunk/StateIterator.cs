using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// Iterates of the States of a FSM
	/// </summary>
	public class StateIterator
	{
		protected Hashtable visited;
		protected Stack states;
		protected bool init;
		protected FSM myFSM;
		protected State returnState;
		protected Transition currentTransition;
		protected Stack transitions;
		
		
		/// <summary>
		/// Initiates a FSM Iterator.
		/// </summary>
		/// <param name="d">The FSM witch should be iterated</param>i
		public StateIterator(Getters d)
		{
			this.myFSM = (FSM) d;
			this.init = false;
			this.states = new Stack();
			this.visited = new Hashtable();
			this.transitions = new Stack();
		}
		/// <summary>
		/// Checks if there is another State to visit.
		/// </summary>
		/// <returns>True if there is another state, false if not</returns>
		public bool MoveNext()
		{
			if(!this.init)
			{
				this.states.Push(this.myFSM.getStartState());
				this.init = true;
				this.returnState = (State) this.states.Peek();
				State none = new State("null",false,false);
				Input nichts = new Input("null");
				Transition g = new Transition(none,nichts,this.returnState);
				this.transitions.Push(g);
				this.visited.Add(this.returnState,this.returnState);
				this.currentTransition = (Transition) this.transitions.Peek();
				State toll = this.myFSM.getStartState();
				if(toll.getFinal())
					try
					{
						Hashtable t  = this.myFSM.getTransitionMap(toll);
					}
					catch(Exception)
					{
						return false;
					}
					
				return true;
			
			}
			if(this.states.Count==0)
			{
				return false;
			}
			else
			{
				State tmp = (State) this.states.Pop();
				this.transitions.Pop();
				
				{}
				Transition tempTransition = new Transition();
				try
				{
					Hashtable nextStates = this.myFSM.getTransitionMap(tmp);
				
				IDictionaryEnumerator iterate = nextStates.GetEnumerator();
				while(iterate.MoveNext())
				{
					
					tempTransition = (Transition) iterate.Value;
					
					tmp = tempTransition.toState;
					if(!this.visited.Contains(tmp)& !this.states.Contains(tmp))
					{
						this.states.Push(tmp);
						try
						{
							this.visited.Add(tmp,tmp);
						}
						catch(Exception){}
						this.transitions.Push(tempTransition);
					}
				}
				}
				catch(Exception)
				{}
				if(this.states.Count==0)
					return false;
				this.returnState = (State) this.states.Peek();
				this.currentTransition = (Transition) this.transitions.Peek();
				return true;
			}
		}
		/// <summary>
		/// Returns the current object of the FSM.
		/// </summary>
		public object Current
		{
			get
			{
				return this.returnState;
			}
		}
		public object getCurrentTransition
		{
			get
			{
				return this.currentTransition;
			}
		}
	
		}
	}
	