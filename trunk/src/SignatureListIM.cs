using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// A SignatureList is the simplest form of an IInterfaceModel, just
	/// containing a set of signatures.
	/// </summary>
	public class SignatureListIM : AbstractIM {

		private IList signatureList;

		/// <summary>
		/// A list of Service objects.
		/// </summary>
		public IList SignatureList {
			get { return signatureList; }
		}

		public SignatureListIM(IList aSignatureList) {
			signatureList = aSignatureList;
		}

		public override bool SubTypeCheck(IInterfaceModel anIModel, out IList anErrorList) {
			anErrorList = new ArrayList();
			bool result = false;

			if (anIModel is SignatureListIM ) {
				SignatureListIM sigIM = (SignatureListIM) anIModel;
				foreach( Service signature in SignatureList ) {
				}
			}
			//TODO add subtypecheck here (contra-variance!)
			return result;
		}

		public override IList GetInterOperabilityErrors(IInterfaceModel anIModel) {
			IList errorList = new ArrayList();
			// modified subtypecheck? if got to look it up
			return errorList;
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) {
			if ( anIModel is SignatureListIM ) {
				SignatureListIM sigIM = (SignatureListIM) anIModel;
				ArrayList mergedList = new ArrayList(SignatureList);
				mergedList.AddRange( sigIM.SignatureList );
				return new SignatureListIM( mergedList );
			} else {
				// TODO introduce new Exception
				throw new ApplicationException ("IM is not a SignatureListIM");
			}
		}

	}
}
