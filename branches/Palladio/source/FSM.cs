using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// Zusammendfassende Beschreibung für FSM.
	/// </summary>
	public class FSM 
	{
		protected Setters setAll;
		protected Getters getAll;
		protected Set inputAl;

		public FSM()
		{
			this.setAll = new Setters();
			this.getAll = new Getters(this.setAll);
			this.inputAl = getAll.getInputAl();

		}
		
		public void setTransition(Transition tr)
		{
			this.setAll.setTransition(tr);
		}
		public void setTransition(State fromState, Input inChar, State toState)
		{	
			Transition tr = new Transition(fromState, inChar, toState);
			this.setAll.setTransition(tr);
		}
		public void getTransition(State fromState, Input inChar)
		{
			try
			{
				Console.WriteLine("Man kann von: " +fromState.ToString() + " mit: "
					+inChar.ToString() + " folgende Transitionen machen:" );
				Console.WriteLine(getAll.getTransition(fromState, inChar).ToString());
			
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine(e.Source);
			}
			
		}
		public void getEigenschaften()
		{
			Console.WriteLine("Startzustand ist: "+getAll.getStartState().ToString());
			Console.WriteLine("Endzustand ist: "+getAll.getFinalState().ToString());
		}
		//gibt alles in einem String aus
		//zur Kontrolle ob die Methoden fUnktionieren
		public void EverythingToString(State state, Input inChar)
		{
			try
			{
				//Eingabealphabet ausgeben
				Console.WriteLine("Eingabealphabet");
				Set input = getAll.getInputAl();
				input.gibAus();
				Console.WriteLine("-----------------------------");
				//Transitionen voj einem Zustand
				Console.WriteLine("Hashmap: Transitionen von "+state.ToString()+": ");
				Hashtable transitionen = getAll.getTransitionMap(state);
				IDictionaryEnumerator enu = transitionen.GetEnumerator();
				while(enu.MoveNext())
					Console.WriteLine(enu.Value.ToString());
				Console.WriteLine("-----------------------------");

			
				//nächster Zustand
				Console.WriteLine("Nächster Zustand von "+state.ToString()+" : ");
				State next = getAll.getNextState(state, inChar);
				Console.WriteLine(next.ToString());
				Console.WriteLine("-----------------------------");
				//Alle Transitionen
				Console.WriteLine("Transition[] Alle Transitionen: ");
				this.getAll.transitionsToString();
			}
			catch(Exception e)
			{
				Console.WriteLine("Ein Fehler ist eingetreten !");
				Console.WriteLine(e.Source);
			}
		
		}
		public Set getInputAl()
		{
			return this.inputAl;
		}
	}
}
