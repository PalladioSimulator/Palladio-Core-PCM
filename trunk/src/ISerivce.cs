using System;
using System.Reflection;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A service consists of a provided signature with an associated service
	/// effect specification describing its requirements.
	/// </summary>
	public interface IServiceEffectMapping : ICloneable 
	{
		#region Properties

		/// <summary>
		/// Describes the method provided by this service.
		/// </summary>
		ISignature Signature 
		{
			get; set;
		}

		/// <summary>
		/// Specifies the requirements of this service.
		/// </summary>
		ISignatureList EffectSpec 
		{ 
			get; set;
		}

		#endregion
	}
}
