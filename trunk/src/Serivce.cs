using System;
using System.Reflection;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A service consists of a provided method or function with an associated service
	/// effect specification describing its requirements.
	/// </summary>
	public class Service : ICloneable 
	{

		#region Data

		private IInterfaceModel effectSpec;
		private ISignature signature;

		#endregion

		#region Properties

		/// <summary>
		/// Describes the method provided by this service.
		/// </summary>
		public ISignature Signature 
		{
			get { return signature; }
		}

		/// <summary>
		/// Specifies the requirements of this service.
		/// </summary>
		public IInterfaceModel EffectSpec 
		{ 
			get { return effectSpec; }
		}

		#endregion

		#region Methods

		public override bool Equals(object obj)
		{
			if (obj is Service) 
			{
				Service srv = (Service)obj;
				return (this.Signature.Equals(srv.Signature) &&
						this.EffectSpec.Equals(srv.EffectSpec));
			}
			return false;
		}


		#endregion
		
		#region Constructors
		
		public Service(ISignature aSignature)
		{
			signature = (ISignature) aSignature.Clone();
		}

		public Service(IInterfaceModel aServiceEffectSpec, ISignature aSignature ) : this( aSignature )
		{
			effectSpec = (IInterfaceModel) aServiceEffectSpec.Clone();
		}

		public Service( Service aService ) : this( aService.EffectSpec, aService.Signature ) {}

		#endregion

		#region ICloneable Member

		public object Clone()
		{
			return new Service( this );
		}

		#endregion
	}
}
