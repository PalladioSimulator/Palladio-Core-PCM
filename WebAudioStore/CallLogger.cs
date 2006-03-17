using System;
using System.Collections;
using System.Reflection;
using System.Threading;
using System.Xml;
using WebAudioStore;

namespace WebAudioStore
{
	public class CallInfo
	{
		public long ThreadID;
		public long CallNumber;
		public long CallLevel;
		public long CallerID;
		public string InterfaceName;
		public MethodInfo MethodInfo;
		public long StartTime;
		public long StopTime;
		public string Calls;
		public HiResTimer timer;

		public CallInfo(long callId, long callLevel, long callerId, string interfaceName, MethodInfo info, long threadID)
		{
			CallNumber = callId;
			CallLevel = callLevel;
			CallerID = callerId;
			MethodInfo = info;
			StartTime = 0;
			StopTime = 0;
			ThreadID = threadID;
			InterfaceName = interfaceName;
			timer = new HiResTimer();
		}
	}


	/// <summary>
	/// </summary>
	public class CallLogger
	{
		public static long callId = 0;

		static ArrayList callInfoList = new ArrayList();

		/// <summary>
		/// Key: Thread
		/// Value: ThreadInfo
		/// 
		/// GetHashCode provides identification for managed threads. 
		/// For the lifetime of your thread, it will not collide with the 
		/// value from any other thread, regardless of the application domain 
		/// from which you obtain the value.
		/// </summary>
		private static Hashtable threadStackTable = new Hashtable();

		/// <summary>
		/// ID for the current execution. So, (runID,threadID) is unique.
		/// </summary>
		public static long runID;

		private static Hashtable callIDHash = new Hashtable();

		public static object myLock = new object();

		/// <summary>
		/// Dataset for the logged info is stored.
		/// </summary>
		public static CallInfo[] Calls
		{
			get
			{
				lock(myLock)
				{
					return (CallInfo[])callInfoList.ToArray(typeof(CallInfo));
				}
			}
		}

		public CallLogger()
		{

		}

		/// <summary>
		/// Executed before a method is called.
		/// </summary>
		/// <param name="method">Called Method.</param>
		public static void OnCall(string interfaceName, MethodInfo method)
		{
			lock(myLock){
				long id = callId++;
				ThreadInfo threadInfo = GetCurrentThreadInfo();
				long caller = ((CallInfo) threadInfo.CallStack.Peek()).CallNumber;
				threadInfo.CallLevel++;
				if(callIDHash[caller] == null) 
				{
					callIDHash[caller] = "_"+Convert.ToString(id);
				} 
				else 
				{
					callIDHash[caller] += " _"+Convert.ToString(id);
				}
				CallInfo info = new CallInfo(id, threadInfo.CallLevel, caller, interfaceName, method, threadInfo.ThreadId);
				info.timer.Start();
				info.StartTime = (long) info.timer.StartTime;
				threadInfo.CallStack.Push(info);
			}
		}

		/// <summary>
		/// Executed after a method call.
		/// </summary>
		public static void OnReturn()
		{
			lock(myLock)
			{
				ThreadInfo threadInfo = GetCurrentThreadInfo();
				CallInfo info = (CallInfo) threadInfo.CallStack.Pop();
				info.Calls = (string) callIDHash[info.CallNumber];
				callInfoList.Add(info);
				info.timer.Stop();
				info.StopTime = (long) info.timer.StopTime;
				threadInfo.CallLevel--;
			}
		}

		/// <summary>
		/// Get Stack and CallLevel of the current thread.
		/// </summary>
		/// <returns></returns>
		private static ThreadInfo GetCurrentThreadInfo()
		{
			lock(myLock)
			{
				Thread t = Thread.CurrentThread;
				ThreadInfo info;
				if (!threadStackTable.Contains(t))
					threadStackTable[t] = new ThreadInfo();
				info = (ThreadInfo) threadStackTable[t];
				return info;
			}
		}

		/// <summary>
		/// Contains the ID and Stack of a thread.
		/// </summary>
		private class ThreadInfo
		{
			/// <summary>
			/// Depth of the stack.
			/// </summary>
			public long CallLevel;

			/// <summary>
			/// Method stack of the thread.
			/// </summary>
			public Stack CallStack;

			/// <summary>
			/// ID of the thread.
			/// </summary>
			public long ThreadId;

			public ThreadInfo()
			{
				CallLevel = 0;
				CallStack = new Stack();
				CallStack.Push(new CallInfo(0, 0, 0,"Base", null, 0));
				threadCnt++;
				ThreadId = threadCnt;
			}

			private static long threadCnt = 0;
		}
		
		public static void SaveLoggedInformationXML(long runID)
		{
			string tempPath = @"C:\Inetpub\wwwroot\WebAudioStore\Data\";
			XmlDocument document = new XmlDocument();
			XmlDeclaration decl = document.CreateXmlDeclaration("1.0",null,null);
			document.AppendChild(decl);
			XmlDocumentType type = document.CreateDocumentType("WebserverMeasure",null,tempPath+"WebAudioStoreMeasure.dtd",null);
			document.AppendChild(type);
			XmlElement rootElem = document.CreateElement("WebserverMeasure");
			document.AppendChild(rootElem);
			XmlElement id = document.CreateElement("RunID");
			id.AppendChild(document.CreateTextNode(Convert.ToString(runID)));
			document.DocumentElement.AppendChild(id);
			foreach (CallInfo callInfo in Calls)
			{
				 XmlElement measure = document.CreateElement
					(callInfo.MethodInfo.DeclaringType.ToString() + "_" + callInfo.InterfaceName +
					"_" + callInfo.MethodInfo.Name);
				measure.SetAttribute("CallNumber","_"+Convert.ToString(callInfo.CallNumber));
				if(callInfo.CallerID != 0)
					measure.SetAttribute("CallerID","_"+Convert.ToString(callInfo.CallerID));
				if(callInfo.Calls != null)
					measure.SetAttribute("Calls",callInfo.Calls);
				//				XmlElement callNumber = document.CreateElement("CallNumber");
				//				XmlElement callLevel = document.CreateElement("CallLevel");
				//				XmlElement callerID = document.CreateElement("CallerID");
				XmlElement className = document.CreateElement("ClassName");
				XmlElement interfaceName = document.CreateElement("InterfaceName");
				XmlElement methodName = document.CreateElement("MethodName");
				XmlElement callTime = document.CreateElement("CallTime");
				XmlElement returnTime = document.CreateElement("ReturnTime");
				XmlElement executionTime = document.CreateElement("ExecutionTime");
				//				XmlElement threadID = document.CreateElement("ThreadID");

				//				callNumber.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.CallNumber)));
				//				callLevel.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.CallLevel)));
				//				callerID.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.CallerID)));
				className.AppendChild(document.CreateTextNode(callInfo.MethodInfo.DeclaringType.ToString()));
				interfaceName.AppendChild(document.CreateTextNode(callInfo.InterfaceName));
				methodName.AppendChild(document.CreateTextNode(callInfo.MethodInfo.Name));
				callTime.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.StartTime)));
				returnTime.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.StopTime)));
				executionTime.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.StopTime - callInfo.StartTime)));
				//				threadID.AppendChild(document.CreateTextNode(Convert.ToString(callInfo.ThreadID)));

				//				measure.AppendChild(callNumber);
				//				measure.AppendChild(callLevel);
				//				measure.AppendChild(callerID);
				measure.AppendChild(className);
				measure.AppendChild(interfaceName);
				measure.AppendChild(methodName);
				measure.AppendChild(callTime);
				measure.AppendChild(returnTime);
				measure.AppendChild(executionTime);
				//				measure.AppendChild(threadID);

				document.DocumentElement.AppendChild(measure);
			}
			
			document.Save(tempPath+"measure" + runID +".xml");
			ResetLogger();
		}

		public static void ResetLogger()
		{
			callId = 0;
			callInfoList.Clear();
			threadStackTable.Clear();
			callIDHash.Clear();
		}
	}
}