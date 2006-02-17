using System;
using System.Collections;
using CodeSmith.Engine;

/// <summary>
/// </summary>
public class FSMHelper : CodeTemplate
{

	public class ServiceInfo
	{
		public string InterfaceName;
		public string MethodName;
		public string ServiceName;
		public string IModelName;
	}
	
	public ServiceInfo GetServiceInfo(string s)
	{
		ServiceInfo info = new ServiceInfo();
		string[] elems = s.Split('.');
		info.InterfaceName = elems[0].Trim();
		info.MethodName = elems[1].Trim();
		info.ServiceName = "service_"+elems[0].Trim()+"_"+elems[1].Trim();
		info.IModelName = "iModel_"+info.InterfaceName;
		return info;
	}


	public string CreateStateList(long cBase, long numOfStates)
	{
		string result = "";
		for (int i=1; i <= numOfStates; i++)
		{
			result += (cBase + i);
			if (i != numOfStates)
				result += ", ";
		}
		return result;
	}

	public string CreateFinalStateList(long cBase, long[] finalStates)
	{
		string result = "";
		for (int i=0; i<finalStates.Length; i++)
		{
			if (i!=0)
				result += ", ";
			result += "GetState(" + (cBase + finalStates[i]) + ")";
		}
		return result;
	}

	public string CreateFinalStateList(long cBase, string finalStatesString)
	{
		long[] finalStates = GetFinalStates(finalStatesString);
		string result = "";
		for (int i=0; i<finalStates.Length; i++)
		{
			if (i!=0)
				result += ", ";
			result += "GetState(" + (cBase + finalStates[i]) + ")";
		}
		return result;
	}

	/// <summary>
	/// FSMDefString:
	/// 
	/// InterfaceName;
	/// NumOfStates;
	/// StartState;
	/// FinalStates;
	/// Transition*;
	/// </summary>
	/// <param name="defString"></param>
	/// <returns></returns>
	public FSMInfo ParseFSMDefString(string defString)
	{
		FSMInfo info = new FSMInfo();
		string[] lines = defString.Split(';');
		info.InterfaceName = lines[0].Trim();
		info.NumOfStates = Int64.Parse(lines[1].Trim());
		info.StartState = Int64.Parse(lines[2].Trim());
		info.FinalStates = GetFinalStates(lines[3]);
		ArrayList transitions = new ArrayList();

		for (int i=4; i<lines.Length; i++)
		{
			string transString = lines[i].Trim();
			if (!transString.Equals(""))
				transitions.Add(ParseTransitionDefString(transString));
		}
		info.Transitions = (TransitionInfo[])transitions.ToArray(typeof(TransitionInfo));
		return info;
	}

	public TransitionInfo ParseTransitionDefString(string s)
	{
		TransitionInfo info = new TransitionInfo();
		string[] elems = s.Split('-');
		info.SourceID = Int64.Parse(elems[0].Trim());
		info.DestID = Int64.Parse(elems[2].Trim());
		info.MethodName = elems[1].Trim();
		return info;
	}

	public long[] GetFinalStates(string s)
	{
		string[] states = s.Split(',');
		long[] result = new long[states.Length];
		for (int i=0; i<states.Length; i++)
		{
			result[i] = Int64.Parse(states[i].Trim());
		}
		return result;
	}

	public class FSMInfo
	{
		public string InterfaceName;
		public long NumOfStates;
		public long StartState;
		public long[] FinalStates;
		public TransitionInfo[] Transitions;
	}

	public class TransitionInfo
	{
		public long SourceID;
		public long DestID;
		public string MethodName;
	}
}