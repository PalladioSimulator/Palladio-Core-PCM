/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/07/30 01:25:52  sliver
 * Some changes...
 *
 * Revision 1.1  2004/07/13 02:14:53  sliver
 * Added comments
 * 
 */

#if TEST

using System;
using System.Diagnostics;

using NUnit.Framework;

using Palladio.ComponentModel;
using Palladio.Reliability.Model;

using log4net;
using log4net.Config;

namespace Palladio.Reliability.Tests
{
	[TestFixture]
	public class ModelTest
	{
		[Test]
		public void TestMethod()
		{
			log.Debug("\n"+reliabilityTree);
		}
		
		[TestFixtureSetUp]
		public void Init()
		{
			BasicConfigurator.Configure();
			cmpModel = CMBuilder.CreateCM();
			CCVisitor v = new CCVisitor(cmpModel);
			reliabilityTree = v.ReliabilityTree;
		}
		
		private ICompositeComponent cmpModel;
		private TreeNode reliabilityTree;
		
		private static readonly ILog log = LogManager.GetLogger(typeof(ModelTest));
	}
}
#endif
