using System;
using System.Collections;

namespace FSM
{
	public class Getters
	{
		protected Set InputAl;
		protected Hashtable transitions;
		
		public Getters()
		{
			this.InputAl = new Set();
			this.transitions = new Hashtable();
		}

		public Getters(Setters input)
		{
			this.InputAl = input.getInputAl();
			this.transitions = input.getTransitions();
		}
		

		//t
		public State getStartState()
		{
			Transition[] tmp = this.getTransitions();
			foreach(Transition tr in tmp)
			{
				if(tr.fromState.getStart() == true)
					return tr.fromState;
			}
			throw new ProgrammingErrorException();
		}
		//t
		public State getFinalState()
		{
			Transition[] tmp = this.getTransitions();
			foreach(Transition tr in tmp)
			{

				if(tr.toState.getFinal()== false)
					return tr.toState;
			}
			throw new ProgrammingErrorException();
		}

		//t
		public State getNextState(State fromState, Input input)
		{

			if(this.InputAl.BinarySearch(input) > 0)
				throw new InvalidInputException();

			if(this.transitions.ContainsKey(fromState.GetHashCode())==false)
				throw new InvalidStateException();

			int hashState = fromState.GetHashCode();

			Object tmp = this.transitions[hashState];
			if(tmp is Transition)
			{
				Transition tr = (Transition) tmp;

				if(tr.input == input)
					return new State(tr.toState);
				else
					throw new InvalidInputException();
					
			}
			else if(tmp is Set)
			{
				Set a = (Set) tmp;
				foreach(Transition t in a.contens)
				{
					if(t.input == input)
						return new State(t.toState);
					throw new InvalidInputException();
				}
				Console.WriteLine("fehler!!");
				throw new ProgrammingErrorException();
			}
			else 
			{
				throw new ProgrammingErrorException();
				
			}
		}

		public Transition getTransition(State fromState, Input inChar) 
		{

			if(this.InputAl.BinarySearch(inChar) > 0)
				throw new InvalidInputException();
			
			if(this.transitions.ContainsKey(fromState.GetHashCode())!=true)
				throw new InvalidStateException();
			
			int hashState = fromState.GetHashCode();

			Object tmp = this.transitions[hashState];
			if(tmp is Transition)
			{
				Transition tr = (Transition) tmp;
				if(tr.input == inChar)
					return new Transition(tr);
				else
					throw new InvalidInputException();
			}
			else if(tmp is Set)
			{
				Set s = (Set) tmp;
				foreach(Transition t in s.contens)
				{
					if(t.input == inChar)
						return new Transition(t);
					throw new InvalidInputException();
				}
				throw new ProgrammingErrorException();
			}
			else
			{
				Console.WriteLine("nichts gefunden!");
				throw new ProgrammingErrorException();
				
			}
		}

		public Hashtable getTransitionMap(State state)
		{
			Hashtable tmp = new Hashtable();
			int hashcode = state.GetHashCode();
			Object help = this.transitions[hashcode];
			if(help == null)
				throw new InvalidStateException();
			if(help is Transition)
			{
				tmp.Add(help.GetHashCode(),(Transition) help);
				return tmp;
			}
			if(help is Set)
			{
				Set s = (Set) help;
				foreach(Transition t in s.contens)
					tmp.Add(t.GetHashCode(), t);
				return tmp;
			}
			throw new ProgrammingErrorException();
		}
	
		public Transition[] getTransitions()
		{
			
			int i = 0;
			DynamicArray tmp = new DynamicArray(i);
			IDictionaryEnumerator myEnumerator = this.transitions.GetEnumerator();
			while ( myEnumerator.MoveNext() )
			{
				Object item = myEnumerator.Value;
				//Console.WriteLine(item.ToString());
				if(item is Transition)
				{
					tmp.AddE(item,i);
					i++;
				}
				else if(item is Set)
				{
					Set so = (Set) item;
					foreach(Transition s in so.contens)
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
			//sauber nachen 
			Transition[] fi = new Transition[tmp.array.Length];
			int z =0;
			//Console.WriteLine("Packe folegendes in das Transition[]: ");
			foreach(Transition t in tmp.array)
			{
				
				fi[z] = t;
				//Console.WriteLine(fi[z].ToString());
			}
			return fi;

		}
		//t
		public Set getInputAl()
		{
			return this.InputAl;
		}
		//Gibt macht Transitions toString und gibt sie aus()
		public void transitionsToString()
		{
			Hashtable tmp = this.transitions;
			ICollection coll = tmp.Keys;
			int anzahlKeys = coll.Count;
			int[] d  = new int[anzahlKeys];
			coll.CopyTo(d,0);
			for(int i = 0; i<anzahlKeys; i++)
			{
				//Console.WriteLine(d[i]);
				Object tel = tmp[d[i]];
				if(tel is Transition)
				{
					//Console.WriteLine("habe Transition gefunden!");
					Console.WriteLine(tel.ToString());
				}
				if(tel is Set)
				{
					//Console.WriteLine("habe Set gefunden!");
					Set s = (Set) tel;
					foreach(Transition so in s.contens)
						Console.WriteLine(so.ToString());
				}

			}
			
		}
		
	}

}




