using System;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// Zusammenfassung für ISubCallingTimeConsumer.
	/// </summary>
	public interface ISubCallingTimeConsumer : ITimeConsumer
	{
		ITimeConsumer NextTimeConsumerAfterReturn 
		{
			get;
		}
	}
}
