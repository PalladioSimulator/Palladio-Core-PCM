package de.uka.ipd.sdq.measurement.strategies.system;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(SystemResourcesUtil.getCPUCores());
		
		System.out.println(SystemResourcesUtil.getFreePhysicalMemorySize());
		System.out.println(SystemResourcesUtil.getTotalPhysicalMemorySize());	
		
		System.out.println(SystemResourcesUtil.getCPUProcessTime());

		long start = System.currentTimeMillis();
		
		
		int i = 1;
		while (System.currentTimeMillis() - start < 1000) {
			i ++;
		}
		System.out.println(i);
		
		System.out.println(SystemResourcesUtil.getCPUProcessTime());

		System.out.println(SystemResourcesUtil.getFreeTempDirectorySize() / 1024 / 1024 / 1024);
		
	}
	
}
