package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.util.List;
import java.util.Map;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.IModel;;

public class QVTOTransformationJobConf {
	private Map<String, Object> opts;
	private List<IModel> models;
	private String scriptFile;
	private String traceFile;
	
	public Map<String, Object> getOptions() {
		return opts;
	}
	public void setOptions(Map<String, Object> opts) {
		this.opts = opts;
	}
	public void setModels(List<IModel> models) {
		this.models = models;
	}
	public List<IModel> getModels() {
		return models;
	}
	public void setScriptFile(String script) {
		this.scriptFile = script;
	}
	public String getScriptFile() {
		return scriptFile;
	}
	public void setTraceFile(String traceFile) {
		this.traceFile = traceFile;
	}
	public String getTraceFile() {
		return traceFile;
	}

}
