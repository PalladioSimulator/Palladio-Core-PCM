using System;

namespace FSM
{
	/// <summary>
	/// Zusammendfassende Beschreibung für Test.
	/// </summary>
	public class Test
	{
		public Test()
		{
		}
			public static void Main()
			{
				//Kommentare  
				Console.WriteLine("Test gestartet!");
				FSM test = new FSM();
				Input a = new Input("a");
				Input b = new Input("b");
				State eins = new State("eins",true, false);
				State zwei = new State("zwei",false,true);
				State drei = new State("drei",false,false);
				//Transitionen setzen
				test.setTransition(eins,a,zwei);
				test.setTransition(eins,a,drei);
				test.setTransition(eins,a,eins);
				test.setTransition(zwei,a,zwei);
				test.setTransition(eins,b,drei);
				//Methoden testen
				test.getTransition(eins,a);
				test.getEigenschaften();
				test.EverythingToString(eins,a);
				Console.WriteLine("fertig");
				Console.Read();
			}
						  
		}
	
}
