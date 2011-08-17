package wiresharktool.capture;

public class CaptureLine {

	private String source, destination, protocol, info;
	private long number;
	private double time;
	
	public CaptureLine(String line) {
		String[] parts = getParts(line);
		this.number = Long.parseLong(parts[0]);
		this.time = Double.parseDouble(parts[1]);
		this.source = parts[2];
		this.destination = parts[3];
		this.protocol = parts[4];
		this.info = parts[5];
	}
	
	private String[] getParts(String line) {
		String[] parts = line.split(",");
		for(int i=0; i<parts.length; i++)
			parts[i] = parts[i].replace("\"","");
		return parts;
	}

	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public String getProtocol() {
		return protocol;
	}
	public String getInfo() {
		return info;
	}
	public long getNumber() {
		return number;
	}
	public double getTime() {
		return time;
	}
}
