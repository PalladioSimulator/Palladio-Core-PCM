package de.uka.ipd.sdq.sensorframework.tests.util;

//
// TempDir.java
//
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
    
public class TempDir
{
    private static DirDeleter deleterThread;
    
    static
    {
        deleterThread = new DirDeleter();
        Runtime.getRuntime().addShutdownHook(deleterThread);
    }
    
    /**
     * Creates a temp directory with a generated name (given a certain prefix) in a given directory.
     * The directory (and all its content) will be destroyed on exit.
     */    
    public static File createGeneratedName(String prefix)
    throws IOException
    {
    	return createGeneratedName(prefix, null);
    }
    
    /**
     * Creates a temp directory with a generated name (given a certain prefix) in a given directory.
     * The directory (and all its content) will be destroyed on exit.
     */    
    public static File createGeneratedName(String prefix, File directory)
    throws IOException
    {
        File tempFile = File.createTempFile(prefix, "", directory);
        if (!tempFile.delete())
            throw new IOException();
        if (!tempFile.mkdir())
            throw new IOException();
        deleterThread.add(tempFile);
        return tempFile;        
    }
    /**
     * Creates a temp directory with a given name in a given directory.
     * The directory (and all its content) will be destroyed on exit.
     */    
    public static File createNamed(String name, File directory)
    throws IOException
    {
        File tempFile = new File(directory, name);
        if (!tempFile.mkdir())
            throw new IOException();
        deleterThread.add(tempFile);
        return tempFile;        
    }
    
    /**
     * For testing purposes TODO make this a proper test
     */
    public static void main(String[] args)
    {
        try
        {
            int serial = 123;
            // create a temp directory with a given name in c:\\project root-directory
            File tempDir = TempDir.createNamed(""+serial, new File("c:\\project"));//TODO tststs
            // create an empty file in the temp directory.
            File f = new File(tempDir, "hello.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("hello");
            fw.close();
            System.out.println("Temp dir created is " + tempDir.getPath());
            System.out.println("Temp dir (and all its content) will be deleted on exit");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }    
}
