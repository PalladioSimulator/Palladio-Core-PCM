using System;
using ReflectionBasedVisitor;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.CM.Example;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of MyClass.
	/// </summary>
	public class MyClass
	{
		
		public static void Main()
		{
			ICompositeComponent cc = (ICompositeComponent) CMBuilder.CreateCompositeComponent();
			CCVisitor v = new CCVisitor(cc);
			v.Run();
			Console.WriteLine(v.ReliabilityTree);
			Console.ReadLine();
		}
		
	}
}
