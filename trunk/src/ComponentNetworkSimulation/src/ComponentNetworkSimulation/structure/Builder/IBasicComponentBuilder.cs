using System;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This interface defines a componentbuilder for basic components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public interface IBasicComponentBuilder : IComponentBuilder
	{
        IServiceBuilder AddService(IIdentifier provIfaceID,IIdentifier signatureID);		
	}
}
//EOF
