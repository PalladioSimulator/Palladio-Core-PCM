using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface ISignature
	{
		bool Match( ISignature anOtherSignature );

		bool MatchContraVariant( ISignature anOtherSignature );
	}
}
