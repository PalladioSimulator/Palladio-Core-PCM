using System;

namespace ComponentNetworkSimulation.Structure.Attributes
{
	/// <summary>
	/// This class contains an instance of all attribute types used in this framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/05/25 16:18:56  joemal
	/// initial creation
	///
	/// 
	/// </pre>	
	/// </remarks>		
	public class DefaultAttributeTypeSet
	{
		#region data

		//holds the instance of ControlFlowStrategyAttributeType
		private static ControlFlowStrategyAttributeType controlFlowStrategyType = null;

		//holds the instance of StaticProbabilityAttributeType
		private static StaticProbabilityAttributeType staticProbabilityType = null;

		//holds the instance of StaticTmeAttributeType
		private static StaticTmeAttributeType staticTimeType = null;

		//holds the instance of IDAttributeType
		private static IDAttributeType idType = null;

		//holds the instance of LoggingTypeAttributeType
		private static LoggingTypeAttributeType loggingAttributeType = null;

		#endregion

		#region properties

		/// <summary>
		/// get the attributetype of the controlflow strategy attribute
		/// </summary>
		public static ControlFlowStrategyAttributeType ControlFlowStrategyType
		{
			get
			{
				if (controlFlowStrategyType == null)
					controlFlowStrategyType = new ControlFlowStrategyAttributeType();

				return controlFlowStrategyType;
			}
		}

		/// <summary>
		/// get the attributetype of the static probability attribute
		/// </summary>
		public static StaticProbabilityAttributeType StaticProbabilityType
		{
			get
			{
				if (staticProbabilityType == null)
					staticProbabilityType = new StaticProbabilityAttributeType();

				return staticProbabilityType;
			}
		}		

		/// <summary>
		/// get the attributetype of the static time attribute
		/// </summary>
		public static StaticTmeAttributeType StaticTimeType
		{
			get
			{
				if (staticTimeType == null)
					staticTimeType = new StaticTmeAttributeType();

				return staticTimeType;
			}
		}
		
		/// <summary>
		/// get the attributetype of the static time attribute
		/// </summary>
		public static IDAttributeType IDType
		{
			get
			{
				if (idType == null)
					idType = new IDAttributeType();

				return idType;
			}
		}

		/// <summary>
		/// get the attributetype of the static time attribute
		/// </summary>
		public static LoggingTypeAttributeType LoggingAttributeType
		{
			get
			{
				if (loggingAttributeType == null)
					loggingAttributeType = new LoggingTypeAttributeType();

				return loggingAttributeType;
			}
		}
		
		#endregion
	}
}
//EOF