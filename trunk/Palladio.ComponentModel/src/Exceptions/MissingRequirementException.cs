namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the requirements of a service effect
	/// specification cannot be fulfilled by the RequiresInterfaces of
	/// the component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	public class MissingRequirementException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the requirements of a service effect
		/// specification cannot be fulfilled by the RequiresInterfaces of
		/// the component.
		/// </summary>
		/// <param name="aSig">Signature whichs requirements are missing.</param>
		public MissingRequirementException(ISignature aSig) : base( "Signature \"" + aSig + "\" is not in the component requirements!" )
		{
		}
	}
}