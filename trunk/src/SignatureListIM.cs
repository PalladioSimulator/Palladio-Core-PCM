using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A SignatureList is the simplest form of an IInterfaceModel, just
	/// containing a set of signatures.
	/// </summary>
	public class SignatureListIModel : AbstractIModel 
	{
		private IList signatureList;

		/// <summary>
		/// A list of ISignature objects.
		/// </summary>
		public IList SignatureList 
		{
			get { return signatureList; }
		}

		public SignatureListIModel() 
		{
		}

		public SignatureListIModel(IList aSignatureList) 
		{
			signatureList = new ArrayList(aSignatureList);
		}

		public SignatureListIModel(SignatureListIModel anSigIModel)
		{
			signatureList = new ArrayList(anSigIModel.SignatureList);
		}

		public SignatureListIModel(SignatureListIModel anSigIModelOne, SignatureListIModel anSigIModelTwo)
		{
			ArrayList mergedList = new ArrayList( anSigIModelOne.SignatureList );
			mergedList.AddRange( anSigIModelTwo.SignatureList );
			signatureList = mergedList;
		}
		
		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			anErrorList = new ArrayList();

			if (anIModel is SignatureListIModel ) 
			{
				SignatureListIModel sigListIM = (SignatureListIModel) anIModel;

				foreach( ISignature sI in this.SignatureList ) 
				{
					IList matchList = new ArrayList();
					foreach( ISignature sJ in sigListIM.SignatureList ) 
					{
						if (sI.Match(sJ)) 
						{
							matchList.Add(sJ);
						}
					}
					if (matchList.Count == 0)  // no match found
					{
						anErrorList.Add( new NoMatchFoundError(sI) );
					}
					else if (matchList.Count > 1) // ambiguous match
					{
						anErrorList.Add( new AmbiguousMatchError(sI,matchList) );
					}
				}
				return (anErrorList.Count == 0);
			} 
			else 
			{
				throw new IModelNotSignatureListIModelException();
			}
		}
	

		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if ( anIModel is SignatureListIModel ) 
			{
				SignatureListIModel sigIM = (SignatureListIModel) anIModel;
				return new SignatureListIModel(this, sigIM);
			} 
			else 
			{
				throw new IModelNotSignatureListIModelException();
			}
		}


		public override object Clone() 
		{
			return new SignatureListIModel(this);
		}
	}
}
