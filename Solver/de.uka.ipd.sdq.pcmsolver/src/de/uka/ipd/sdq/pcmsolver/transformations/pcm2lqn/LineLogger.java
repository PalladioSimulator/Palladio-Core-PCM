package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LineLogger implements Runnable {
	private BufferedReader in;
	private boolean read = true;
	private boolean running = false;
	private boolean connected = false;
	private Map<String,String> evaluations = new HashMap<String, String>();

	String prefix="";
	public LineLogger(BufferedReader in, String prefix) {
		this.in = in;
		if(prefix != null)
			this.prefix = prefix; 
	}
	public synchronized void close(){
		read = false;
	}

	private synchronized boolean isRead() {
		return read;
	}

	public synchronized boolean isRunning() {
		return running;
	}

	public synchronized boolean isConnected(){
		return connected;
	}

	@Override
	public void run() {
		while(isRead())
			try {
				Thread.sleep(100);
				if(in.ready()){
					String line = in.readLine();
					System.out.println("LINE "+prefix+": "+line);

					//set the starting
					if(line.contains("Listening on port"))
						setRunning(true);
					if(line.contains("LINE READY"))
						setConnected(true);
					if(line.contains("LINE STOP"))
						setRunning(false);
					if(line.contains("MODEL"))
						updateModelEvaluation(line);
				}

			} catch (IOException e) {
				if(e.getMessage().equals("Stream closed"))
					System.out.println("LINE "+prefix+": "+e.getMessage());
				else 
					e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private synchronized void setRunning(boolean running){
		this.running = running;
	}

	private synchronized void setConnected(boolean connected){
		this.connected = connected;
	}

	private synchronized void updateModelEvaluation(String message){
		message = message.trim().replaceAll(" +", " ");		
		String[] tokens = message.split(" ");
		String modelName = tokens[1];		
		modelName = modelName.replace("_res.xml", ".xml");
		modelName = Paths.get(modelName).toString();
		String status = null;		
		if(tokens.length == 4)
			status = tokens[3];
		else
			status = tokens[2];
		evaluations.put(modelName,status);
	}
	
	public synchronized boolean isModelEvaluated(String modelPath){
		modelPath = Paths.get(modelPath).toString();
		return evaluations.containsKey(modelPath) && evaluations.get(modelPath).equals("SOLVED");		
		//TODO clear the model form the map?
	}


}
