/**
 * Class is used to check the validity of the SPECjvm2008 files.
 * Based on the SPECjbb2000 code for spec.jbb.validity.digest
 *
 * History:
 * 2000/12/15: Chris Beer <Chris.Beer@compaq.com>
 *	       Modified for use with SPECmail code.
 * 2001/12/14: Chris Beer <Chris.Beer@compaq.com>
 *             Modified for use with SPECjbb2000 code.
 * 2007/10/02: Richard Allen <richard.allen@hp.com>
 *             Modified for use with SPECjvm2008 code.
 */

package spec.digest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * This class is used to get the 'digest' of a JAR/resource file. A digest is a
 * checksum (using the SHA algorithm) of the file.
 */
public class Digest {

    private static boolean debug = false;

    /**
     * Constructor for checker class.
     */
    public Digest() {
    }

    /**
     * Given a file name, generate a digest for that file.
     * 
     * @param fileName
     *            String: name of file to create a digest for.
     * @return byte[]: the generated digest.
     */
    private byte[] getDigest(String fileName) throws IOException {

        byte actualDigest[] = null;

        try {
            File fileHandle = new File(fileName);
            if (!fileHandle.exists()) {
                throw new IOException("Cannot find file '" + fileName + "'");
            }

            FileInputStream fis = new FileInputStream(fileHandle);
            MessageDigest md = MessageDigest.getInstance("SHA");
            DigestInputStream dis = new DigestInputStream(fis, md);

            int fileLength = (int) fileHandle.length();
            for (int i = 0; i < fileLength; i++) {
                dis.read();
            }

            actualDigest = md.digest();
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
            throw new IOException("Could not get digest for " + fileName);
        }

        return actualDigest;
    }

    /**
     * Main method for testing the class.
     */
    public static void main(String[] args) {

        Digest digest = new Digest();

        if (args.length < 4) {
            System.err.println("Not enough arguments\n");
            return;
        }

        String filetype = args[0];
        String srcDir = args[1];
        String baseDir = args[2];

        if (debug) {
            System.out.println("filetype=" + filetype);
            System.out.println("srcDir=" + srcDir);
            System.out.println("baseDir=" + baseDir);
        }

        if (!(filetype.equals("Jar") || filetype.equals("Resource"))) {
            throw new RuntimeException("Unknown file type for digest generation: '" + filetype + "'");
        }

        StringBuffer nameBuf = new StringBuffer();
        StringBuffer digestBuf = new StringBuffer();

        for (int j = 3; j < args.length; j++) {
            // If a command line parameter was provided, assume its a file name
            // and
            // attempt to create a digest for it.
            String fileName = args[j];
            try {

                nameBuf.append("        \"" + fileName + "\",\n");

                byte[] fileDigest = digest.getDigest(baseDir + "/" + fileName);
                int digestLength = fileDigest.length;
                if (digestLength > 10)
                    digestLength = 10;

                digestBuf.append("        {");
                for (int i = 0; i < 10; i++) {
                    String sep = i != 0 ? ", " : " ";
                    digestBuf.append(sep + Byte.toString(fileDigest[i]));
                }
                digestBuf.append(" },\n");
            } catch (IOException ioe) {
                System.err.println("Could not get digest for " + fileName);
                System.err.println(ioe.getLocalizedMessage());
                return;
            }
        }

        // write to file

        writeToFile(srcDir, filetype, nameBuf, digestBuf);
    }

    private static void writeToFile(String srcDir, String filetype, StringBuffer nameBuf, StringBuffer digestBuf) {

        try {
            FileWriter fileStream = new FileWriter(srcDir + "/Expected" + filetype + "Digests.java");
            BufferedWriter out = new BufferedWriter(fileStream);

            out.write("/*\n");
            out.write(" * \n");
            out.write(" * Copyright (c) 2000-2008 Standard Performance Evaluation Corporation (SPEC)\n");
            out.write(" *               All rights reserved. \n");
            out.write(" * Copyright (c) 2000-2008 Hewlett-Packard All rights reserved.\n");
            out.write(" * Copyright (c) 1997-2008 Sun Microsystems, Inc. All rights reserved.\n");
            out.write(" * \n");
            out.write(" * This source code is provided as is, without any express or implied warranty.\n");
            out.write(" *  \n");
            out.write(" */\n");
            out.write("\n");
            out.write("/* THIS IS A GENERATED FILE: DO NOT EDIT DIRECTLY. */\n");
            out.write("\n");
            out.write("package spec.validity;\n");
            out.write("\n");
            out.write("import java.util.*;\n");
            out.write("import java.lang.*;\n");
            out.write("\n");
            out.write("public class Expected" + filetype + "Digests \n");
            out.write("    implements DigestDefinition\n");
            out.write("{ \n");
            out.write("    HashMap<String, byte[]> hm;\n");
            out.write("\n");

            out.write("    private final static String[] " + filetype + " = {\n");
            out.write(nameBuf.toString());
            out.write("    };\n\n");
            out.write("    private final static byte[][] " + filetype + "Digests = {\n");
            out.write(digestBuf.toString());
            out.write("    };\n\n");

            out.write("    public Expected" + filetype + "Digests() { \n");
            out.write("\n");
            out.write("        hm = new HashMap<String, byte[]>();\n");
            out.write("\n");
            out.write("        // Insert " + filetype + " file-digest pairs\n");
            out.write("        for (int i=0; i < " + filetype + ".length; i++) {\n");
            out.write("            hm.put(" + filetype + "[i], " + filetype + "Digests[i]); \n");
            out.write("        }\n");
            out.write("    }\n");
            out.write("\n");
            out.write("    public Iterator<String> iterator() {\n");
            out.write("        return hm.keySet().iterator();\n");
            out.write("    }\n");
            out.write("\n");
            out.write("    public byte[] getArray(String key) { \n");
            out.write("        return hm.get(key);\n");
            out.write("    } \n");
            out.write("} \n");

            out.flush();
            out.close();
        } catch (IOException ioe) {
            System.err.println("IO Exception occurred: " + ioe.getLocalizedMessage());
            return;
        }
    }
}
