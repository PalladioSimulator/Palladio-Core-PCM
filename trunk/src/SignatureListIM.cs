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
		#region Data

		private IList signatureList;

		#endregion


		#region Properties

		/// <summary>
		/// A list of ISignature objects.
		/// </summary>
		public IList SignatureList 
		{
			get { return signatureList; }
		}


		#endregion


		#region Constructors

		public SignatureListIModel() 
		{
		}


		public SignatureListIModel(IList aSignatureList) 
		{
			signatureList = new ArrayList(aSignatureList);
		}


		public SignatureListIModel(SignatureListIModel aSigIModel)
		{
			signatureList = new ArrayList(aSigIModel.SignatureList);
		}


		#endregion


		#region Methods

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			anErrorList = new ArrayList();

			if (anIModel is SignatureListIModel ) 
			{
				SignatureListIModel sigListIM = (SignatureListIModel) anIModel;

				//TODO Performance Tuning!
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
				SignatureListIModel sigListIM = (SignatureListIModel) anIModel;
				ArrayList mergedList = new ArrayList( this.SignatureList );
				//TODO handle matching signatures (how to choose??)
				mergedList.AddRange( sigListIM.SignatureList );
				SignatureListIModel resultIModel = (SignatureListIModel) this.Clone();
				resultIModel.signatureList = mergedList;
				return resultIModel;
			} 
			else 
			{
				throw new IModelNotSignatureListIModelException();
			}
		}


		public override IInterfaceModel Intersect( IInterfaceModel anIModel )
		{
			if ( anIModel is SignatureListIModel ) 
			{
				IList interList = new ArrayList();
				SignatureListIModel sigIModel = (SignatureListIModel) anIModel;

				foreach (ISignature sig in SignatureList) 
				{
					if ( sig.HasOneMatch(sigIModel.SignatureList) )
					{
						interList.Add( sig );
					}
				}
				SignatureListIModel resultIModel = (SignatureListIModel) this.Clone();
				resultIModel.signatureList = interList;
				return resultIModel;
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


		#endregion
	}
}
