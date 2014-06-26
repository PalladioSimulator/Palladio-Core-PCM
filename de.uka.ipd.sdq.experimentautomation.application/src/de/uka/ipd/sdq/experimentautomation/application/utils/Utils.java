package de.uka.ipd.sdq.experimentautomation.application.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Utils {

	/**
	 * Creates a zip-archive containing the specified <code>sourceFolder</code>.
	 * 
	 * (Source: http://www.lalitmehta.com/home/wp-content/uploads/2007/09/zipfile.txt)
	 * 
	 */
	public static void zipFolder(File sourceFolder, File destinationFile) {
		try {

            // create ZipOutputStream object
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destinationFile));

            // get path prefix so that the zip file does not contain the whole path
            // eg. if folder to be zipped is /home/lalit/test
            // the zip file when opened will have test folder and not home/lalit/test folder
            int len = sourceFolder.getAbsolutePath().lastIndexOf(File.separator);
            String baseName = sourceFolder.getAbsolutePath().substring(0, len + 1);

            addFolderToZip(sourceFolder, out, baseName);

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Uploads the specified <code>sourceFile</code> file via FTP.
	 */
	public static void ftpUpload(String hostName, String user, String password, File sourceFile, String destinationFileName) {
        FTPClient ftp = new FTPClient();
        InputStream in = null;
        try {
            ftp.connect(hostName);
            ftp.login(user, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory("/httpdocs");
            
            int reply = ftp.getReplyCode();
            if(FTPReply.isPositiveCompletion(reply)){
               System.out.println("FTP connection established");
               in = new FileInputStream(sourceFile);
             
               ftp.storeFile(destinationFileName,in);
            }
            
            ftp.logout();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*
     * Source: http://www.lalitmehta.com/home/wp-content/uploads/2007/09/zipfile.txt
     */
    private static void addFolderToZip(File folder, ZipOutputStream zip, String baseName) throws IOException {
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                addFolderToZip(file, zip, baseName);
            } else {
                String name = file.getAbsolutePath().substring(baseName.length());
                ZipEntry zipEntry = new ZipEntry(name);
                zip.putNextEntry(zipEntry);
                IOUtils.copy(new FileInputStream(file), zip);
                zip.closeEntry();
            }
        }
    }
	
}
