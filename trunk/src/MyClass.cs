using System;
using System.IO;

using ReflectionBasedVisitor;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.CM.Example;
using Palladio.Attributes;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of MyClass.
	/// </summary>
	public class MyClass
	{
		
		public static void Main()
		{
			ICompositeComponent cc = (ICompositeComponent) TestCMBuilder.CreateCM();
			CCVisitor v = new CCVisitor(cc);
			Console.WriteLine(v.ReliabilityTree);
			
			AttributesFactory factory = new AttributesFactory();
			IAttributeType attributeType = factory.Default.CreateAttributeType(new Guid("d3b77ea3-be07-4ee1-959f-a90cf75ca5c8") ,"MarkovProbability", typeof(MarkovProbability));
			
			
			
			Console.ReadLine();
		}
		
	}
}

//	using( StreamWriter sw = new StreamWriter("../../markov probability.guid"))
//	{
//		Guid g = Guid.NewGuid();
//		sw.WriteLine(g.ToString());
//	}
