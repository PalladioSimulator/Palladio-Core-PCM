using Palladio.Attributes;
using Palladio.ComponentModel;
using Palladio.Math;

namespace Palladio.Reliability
{
	/// <summary>
	/// </summary>
	public class Reliability
	{
		IExecutionTime ServiceExecutionTime(IFSMInterface fsmInterface);

		IReliability ServiceReliability(IFSMInterface fsmInterface);
 
		IReliability BasicComponentReliablity(IBasicComponent basicComponent);

		IReliability CompositeComponentReliablity(ICompositeComponent compositeComponent);
		

		#region TimeAttribute
		
		public static void SetTimeAttribute(IAttributable obj, IFunction densityFunction)
		{
		}
		
		public static void SetTimeAttribute(IAttributable obj, double expectationValue)
		{
		}

		public static void SetTimeAttribute(IAttributable obj, ITimeAttribute timeAttribute)
		{
		}

		public static ITimeAttribute GetTimeAttribute(IAttributable obj)
		{
			return null;
		}
		#endregion

		#region ProbabilityAttribute
		
		public static void SetProbabilityAttribute(IAttributable obj, double probability)
		{
		}

		public static void SetProbabilityAttribute(IAttributable obj, IProbabilityAttribute ProbabilityAttribute)
		{
		}

		public static IProbabilityAttribute GetProbabilityAttribute(IAttributable obj)
		{
			return null;
		}
		#endregion

		private Reliability()
		{
		}
	}
}