using Palladio.ComponentModel.Builder;

namespace Palladio.ComponentModel.BuilderConstraints
{

	/// <summary>
	/// Interface that has to be implemented by all protocol builder contraints.
	/// Contains all checks for this type of builder.
	/// </summary>
	/// <remarks>
	/// Currently just summarizes sub-interfaces.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// </pre>
	/// </remarks>
	public interface IProtocolBuilderConstraint : IBuilderConstraint, IProtocolBuilder
	{

	
	}
}
