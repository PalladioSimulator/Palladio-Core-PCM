import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Package;
import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaRSAHelper {

    private static final String INKSCAPE_EXE = "inkscapeEXE";
    private static final String HTML_DOC_DIR = "htmlDocDirectory";
    private static final String IMAGE_OUTPUT_DIR = "imageOutputDirectory";

    /**
     * if set to false: RSA 7.5 mode RSA image file name encoding varies across different versions
     */
    private static final boolean RSA_7_0_MODE = false;

    private static Properties myProperties = new Properties();

    /**
     * hashmap for non full stop file name mapping key: id; value: obfuscated id; each without file
     * extension
     */
    private static HashMap<String, String> fileNamesMap;

    static {
        try {
            myProperties.load(new FileInputStream("src/JavaRSAHelper.properties"));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     */
    public static void main(final String[] args) throws SAXException, IOException, ParserConfigurationException,
            XPathExpressionException {
        getDiagramIDs("_b9LS4AYvEd2nT5sAX-421A", "model/CoreModel.uml");
    }

    public static List<String> getDiagrams(final Package p) {
        try {
            final String resourceURI = p.eResource().getURI().toFileString();
            final String packageID = ((XMLResource) p.eResource()).getID(p);

            try {
                return getDiagramIDs(packageID, resourceURI);
            } catch (final XPathExpressionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (final SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (final ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (final NullPointerException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<String> getDiagramIDs(final String packageID, final String resourceURI) throws SAXException,
            IOException, ParserConfigurationException, XPathExpressionException {
        prepareImageFileNameMap();
        final ArrayList<String> myResult = new ArrayList<String>();
        final String xmlFileName = resourceURI.replaceAll(".uml", ".emx");
        final File xmlFile = new File(xmlFileName);
        if (!xmlFile.exists()) {
            System.out.println("No RSA file found for file " + resourceURI
                    + "\nIf you would like to convert RSA diagrams as well, please put");
            System.out.println("the RSA .emx file in the same directory as your UML model file.");
            return Collections.emptyList();
        }
        System.out.println("Getting diagrams for package with ID " + packageID);
        final Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
        final XPath xp = XPathFactory.newInstance().newXPath();
        final String xpath = "//*[@id=\"" + packageID + "\"]";
        final Object result = xp.evaluate(xpath, xmlDoc, XPathConstants.NODE);
        if (result != null) {
            final String xpath2 = ".//contents[@type=\"notation:Diagram\"]";
            final NodeList result2 = (NodeList) xp.evaluate(xpath2, result, XPathConstants.NODESET);
            for (int i = 0; i < result2.getLength(); i++) {
                final Node n = result2.item(i);
                final String s = n.getAttributes().getNamedItem("xmi:id").getNodeValue();
                String svgFileName;
                if (RSA_7_0_MODE) {
                    // for RSA 7.0 exports:
                    svgFileName = convertToRSAEncoding(s);
                } else {
                    // for RSA 7.5 exports:
                    svgFileName = fileNamesMap.get(s);
                }

                if (svgFileName != null) {
                    convertSVG(svgFileName + ".svg");
                    final String xpath3 = ".//styles[@type=\"umlnotation:UMLDiagramStyle\"]";
                    final Node result3 = (Node) xp.evaluate(xpath3, n, XPathConstants.NODE);

                    String metaData = svgFileName + "\n";
                    metaData += n.getAttributes().getNamedItem("name").getNodeValue() + "\n";
                    if (result3 == null || result3.getAttributes().getNamedItem("description") == null) {
                        metaData += "TODO: No diagram documentation found. Provide a documentation for this diagram!\n";
                    } else {
                        metaData += result3.getAttributes().getNamedItem("description").getNodeValue() + "\n";
                    }

                    myResult.add(metaData);
                } else {
                    System.err.println("Could not fetch an image for id " + s);
                }

            }
        } else {
            System.out.println("Package with ID " + packageID
                    + " not found in RSA file. Your UML and RSA file are either");
            System.out.println("out of sync or you exported the UML file by creating new IDs. Please check this");
        }
        return myResult;
    }

    /**
     * svg file name conversion of RSA 7.5
     */
    private static void prepareImageFileNameMap() {
        fileNamesMap = new HashMap<String, String>();
        final String svgInputImagesDirectory = myProperties.getProperty("htmlDocDirectory") + "/images/";

        final File[] files = new File(svgInputImagesDirectory).listFiles();
        for (final File file : files) {
            fileNamesMap.put(removeAllDotsExceptTheLast(file.getName()), removeFileExtension(file.getName()));
        }

    }

    /**
     * convert _AB.SAd.asfee.a.b1.svg to _ABSAdasfeeab1.svg
     * 
     * @param fileName
     * @return
     */
    public static String removeAllDotsExceptTheLast(String fileName) {
        fileName = removeFileExtension(fileName);
        fileName = fileName.replace(".", "");

        return fileName;
    }

    private static String removeFileExtension(String fileName) {
        fileName = fileName.replace(".svg", "");
        fileName = fileName.replace(".SVG", "");
        return fileName;
    }

    private static void convertSVG(final String filename) {
        final String inkscapeEXE = myProperties.getProperty(INKSCAPE_EXE);

        final String inputDirectory = myProperties.getProperty(HTML_DOC_DIR) + File.separatorChar + "images"
                + File.separatorChar;
        final File baseFile = new File(inputDirectory + filename);

        final String outputDirectory = myProperties.getProperty(IMAGE_OUTPUT_DIR) + File.separatorChar;
        String outputFileName = filename;
        if (!RSA_7_0_MODE) {
            outputFileName = removeAllDotsExceptTheLast(outputFileName) + ".svg";
        }
        final String newPDFFilename = outputDirectory + outputFileName.replaceAll(".svg", ".pdf");
        final String newEPSFilename = outputDirectory + outputFileName.replaceAll(".svg", ".eps");

        if (!baseFile.exists()) {
            System.out.println("WARNING: Cannot find file: " + inputDirectory + filename
                    + "\nDid you forget to export the SVG based HTML doc?");
            return;
        }
        if (!new File(outputDirectory).exists()) {
            System.out
                    .println("Error: Output directory for converted images does not exist. Create it first and re-run the transformation.");
            return;
        }

        final String commandLinePDF = inkscapeEXE + " --g-fatal-warnings -A \"" + newPDFFilename + "\" -f \""
                + inputDirectory + filename + "\"";
        int errorCode = executeProcess(commandLinePDF);
        if (errorCode == 0) {
            System.out.println("File converted. New file " + newPDFFilename);
        } else {
            System.out.println("Converting SVG to PDF failed. Check Inkscape and the SVG input file.");
        }

        final String commandLineEPS = inkscapeEXE + " --g-fatal-warnings -E \"" + newEPSFilename + "\" -f \""
                + inputDirectory + filename + "\"";
        errorCode = executeProcess(commandLineEPS);
        if (errorCode == 0) {
            System.out.println("File converted. New file " + newEPSFilename);
        } else {
            System.out.println("Converting SVG to EPS failed. Check Inkscape and the SVG input file.");
        }

    }

    private static int executeProcess(final String commandLine) {
        try {
            String line;
            final Process p = Runtime.getRuntime().exec(commandLine);
            final BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
            return p.exitValue();
        } catch (final Exception err) {
            err.printStackTrace();
            return -1;
        }
    }

    /**
     * For RSA 7.0 file name encoding
     * 
     * @param guid
     * @return
     */
    private static String convertToRSAEncoding(final String guid) {
        final StringBuffer result = new StringBuffer();
        for (int i = 0; i < guid.length(); i++) {
            final String resultingEncoding = convertSingleChar(guid.charAt(i));
            result.append(resultingEncoding);
        }
        return result.toString();
    }

    private static String convertSingleChar(final char charAt) {
        if ((Character.getNumericValue(charAt) >= Character.getNumericValue('A') && Character.getNumericValue(charAt) <= Character
                .getNumericValue('Z'))
                || (Character.getNumericValue(charAt) >= Character.getNumericValue('a') && Character
                        .getNumericValue(charAt) <= Character.getNumericValue('z'))) {
            return ((int) charAt) + "";
        }
        return charAt + "";
    }

    public static String convertHtmlToPlaintext(final String input) {
        Parser parser;
        String textInPage = "";
        try {
            parser = new Parser(input);
            final TextExtractingVisitor visitor = new TextExtractingVisitor();
            parser.visitAllNodesWith(visitor);
            textInPage = visitor.getExtractedText();
        } catch (final ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return textInPage;
    }

}
