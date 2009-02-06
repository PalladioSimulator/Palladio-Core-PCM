package de.uka.ipd.sdq.sensorframework.tests.util;

//
// DirDeleter.java
//
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
    
public class DirDeleter extends Thread
{
    @SuppressWarnings("unchecked")
	private ArrayList dirList = new ArrayList();
    
    @SuppressWarnings("unchecked")
	public synchronized void add(File dir)
    {
        dirList.add(dir);
    }
    
    @SuppressWarnings("unchecked")
	public void run()
    {
        synchronized (this)
        {
            Iterator iterator = dirList.iterator();
            while (iterator.hasNext())
            {
                File dir = (File)iterator.next();
                deleteDirectory(dir);
                iterator.remove();
            }
        }
    }
    
    private void deleteDirectory(File dir)
    {
        File[] fileArray = dir.listFiles();
        
        if (fileArray != null)
        {
            for (int i = 0; i < fileArray.length; i++)
            {
                if (fileArray[i].isDirectory())
                    deleteDirectory(fileArray[i]);
                else
                    fileArray[i].delete();
            }
        }
        dir.delete();
    }
}
