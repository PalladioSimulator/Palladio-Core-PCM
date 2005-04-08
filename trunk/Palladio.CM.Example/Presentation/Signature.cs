using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for all visual representations of the componentmodels signatures in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class Signature : AbstractEntity
	{
		/// <summary>
		/// called to create a visual representation of a signature
		/// </summary>
		/// <param name="signature">the signature</param>
		/// <param name="modelEnvironment">the model</param>
		public Signature(ISignature signature, ComponentModelEnvironment modelEnvironment) : base(signature, modelEnvironment)
		{
		}

		/// <summary>
		/// called to paint the component
		/// </summary>
		public override void Paint()
		{
			Console.WriteLine("Signature "+this.entity.Name+" painted.");
		}
	}
}
