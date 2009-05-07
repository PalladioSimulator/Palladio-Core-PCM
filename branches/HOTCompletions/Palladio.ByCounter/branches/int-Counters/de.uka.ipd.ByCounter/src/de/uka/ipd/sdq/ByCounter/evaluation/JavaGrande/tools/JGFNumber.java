package de.uka.ipd.sdq.ByCounter.evaluation.JavaGrande.tools;

import java.util.*;
import java.io.*;
import java.text.NumberFormat;

public class JGFNumber {

  public static PrintWriter printw = null;

  public static void main(String[] args) {

    String Line;
    String jenv = null;
    String hwp = null;
    String opsy = null;

    sect1class sect1ob;
    sect2class sect2ob;
    sect3class sect3ob;

    StringTokenizer st;

    String fname = null;
    
    FileWriter filew = null;

    File file = new File ("JGFresults.html");

// open html output file and write the top of the file

   try {
   filew = new FileWriter (file);
   JGFNumber.printw = new PrintWriter (filew, true);
   } catch (IOException e ) { }

   JGFNumber.printw.println("<html>");
   JGFNumber.printw.println("<head>");
   JGFNumber.printw.println("<title>JavaG Benchmarking</title>");
   JGFNumber.printw.println("</head>");
   JGFNumber.printw.println("<body bgcolor=\"#FFCC99\" text=\"#000000\" link=\"#3333CC\" vlink=\"#6699CC\" alink=\"#FF3300\">");
   JGFNumber.printw.println("<p>");
   JGFNumber.printw.println("<center><h1><font color=\"#660000\">Java Grande Benchmark Results</h1></center>");


// read in information regarding the benchmarking and write to the html file

    JGFNumber.printw.println("<h2 align=\"justify\"><font color=\"#666600\">System Details </h2>");

    System.out.println("Please input the java environment (JDK/compiler) you were using ");
    InputStreamReader fjenvin = new InputStreamReader(System.in);
    BufferedReader jenvin = new BufferedReader(fjenvin);
    try {
     jenv = jenvin.readLine();
    } catch (IOException e ) { }

    JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\"> Java Environment: " + " " + jenv + " " + "</h3>");

    System.out.println("Please input the harware platform you were using ");
    InputStreamReader fhwpin = new InputStreamReader(System.in);
    BufferedReader hwpin = new BufferedReader(fhwpin);
    try {
     hwp = hwpin.readLine();
    } catch (IOException e ) { }

    JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\"> Hardware Platform: " + " " + hwp + " " + "</h3>");

    System.out.println("Please input the operating system you were using ");
    InputStreamReader fopsyin = new InputStreamReader(System.in);
    BufferedReader opsyin = new BufferedReader(fopsyin);
    try {
     opsy = opsyin.readLine();
    } catch (IOException e ) { }

    JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\"> Operating System: " + " " + opsy + " " + "</h3> <br>");



// read in the input file and check the file exists

    System.out.println("Please input the name of your input file ");
    InputStreamReader fnamein = new InputStreamReader(System.in); 
    BufferedReader namein = new BufferedReader(fnamein);
    try {
     fname = namein.readLine();
    } catch (IOException e ) { }

    File infile = new File(fname);
    if(!infile.exists()) {
     System.out.println("Sorry, that file doesn't exist ");
     return;
    }

// read in the results

    sect1ob = new sect1class();
    sect2ob = new sect2class();
    sect3ob = new sect3class();

    try {
      FileReader fin = new FileReader(infile);
      BufferedReader in = new BufferedReader(fin);  

      sect1ob.initialise();
      sect2ob.initialise();
      sect3ob.initialise();

      try {
        while (  (Line = in.readLine()) !=null ) { 
          st = new StringTokenizer(Line);

          if(Line.startsWith("Section1") ) {
            sect1ob.readin(Line);
          }
          else if(Line.startsWith("Section2") ) {
            sect2ob.readin(Line);
          }
           else if (Line.startsWith("Section3") ) {
            sect3ob.readin(Line);
          }

        }

      } catch (IOException e ) { }

    } catch (Exception e) { }


// calculate the JGF Number and write out the results

    sect1ob.stringtodouble();
    sect1ob.calcjavano();
    sect1ob.writetable();

    sect2ob.reorder();
    sect2ob.stringtodouble();
    sect2ob.calcjavano();
    sect2ob.writetable();

    sect3ob.reorder();
    sect3ob.stringtodouble();
    sect3ob.calcjavano();
    sect3ob.writetable();




// write out the end of the output

   System.out.println("We would welcome your results, please send the file \"JGFresults.html\" to: epcc-javagrande@epcc.ed.ac.uk");


// write out the foot of the html file and close this

   JGFNumber.printw.println("<h4><font color=\"#666600\">Any results, comments or suggestions would be warmly welcomed, please email <a href=\"mailto:epcc-javagrande@epcc.ed.ac.uk\"><i>epcc-javagrande@epcc.ed.ac.uk</a></i>)</h4> ");
   JGFNumber.printw.println("</body>");
   JGFNumber.printw.println("</html>");

   JGFNumber.printw.close(); 
 
  }

}




class sect1class {

    int section1total = 9;
    int total1 = 3;
    String section1[][][] = new String [section1total][][];
    double section1doubles[][][] = new double [section1total][][];
    String [] section1template = {"Section1:Arith:", "Section1:Assign:", "Section1:Cast:", "Section1:Create:", "Section1:Exception:", "Section1:Loop:", "Section1:Math:", "Section1:Method:", "Section1:Serial:"};

    String [] section1outtemplate = {"Arith Benchmark", "Assign Benchmark", "Cast Benchmark", "Create Benchmark", "Exception Benchmark", "Loop Benchmark", "Math Benchmark", "Method Benchmark", "Serial Benchmark"};

    int [] section1size = {12,10,4,43,3,3,30,8,8};

    StringTokenizer st;

    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;

    int arithi [] = new int [section1total];

    int length1 [] = new int [section1total];

    double javano1sum [] = new double [section1total];
    double javano1 [] = new double [section1total];
    double temp1 [] = new double [section1total];

    double javano1all = 0.0;
    double section1itotal = 0.0;

    double [][] section1e3000no = {{1.23992056E8, 6.2979052E7, 6.4006252E7, 5.5837096E7, 3.7419208E7, 1.1248112E7, 6.3993752E7, 4.1763956E7, 5019915.5, 2968331.0, 2.6808476E7, 1.7792258E7}, {8.4426408E7, 1.23992056E8, 8.0978624E7, 5.22116E7, 2.5767084E7, 4.0906312E7, 6.0108228E7, 6.0124772E7, 1.4479894E7, 1.6396297E7},{9713642.0, 8836156.0, 3759177.8, 3576355.5}, {5124804.5, 3928640.0, 3137495.2, 2416661.8, 1460041.4, 807953.3, 430541.53, 233257.4, 3966686.0, 3165868.0, 2426252.8, 1482124.8, 818087.4, 437906.25, 231464.73, 122429.46, 4858549.5, 3712162.5, 3039252.0, 2453282.2, 1444389.6, 801001.25, 425673.44, 232010.16, 4625374.0, 3754009.8, 3043090.8, 2442602.5, 1428471.8, 794352.6, 423140.5, 231443.81, 9245006.0, 5298835.5, 5334722.5, 4666477.0, 3531948.0, 3525260.2, 3488926.8, 2596513.5, 5314994.0, 2848796.8, 2833033.5}, {229411.23, 57829.582, 53981.105}, {1.23980328E8, 2.47960656E8, 1.65327952E8}, {1.7143456E7, 1.1082251E7, 1.24003784E8, 7.0861224E7, 1.5253701E7, 1.0039831E7, 4646361.5, 3263225.0, 1.4353044E7, 9609948.0, 4673931.5, 3263485.0, 1193821.0, 1092150.1, 1014263.06, 1737065.2, 551991.8, 1663012.6, 1619356.4, 1955691.4, 1884951.6, 1.044232E7, 1087510.6, 1031998.0, 423455.47, 1787241.5, 591599.75, 1014514.3, 715833.6, 1587843.1}, {2.2545754E7, 2644798.8, 2.122005E7, 2.122005E7, 2846421.2, 1.4107112E7, 1.323318E7, 1.9759996E7}, {94595.84, 22979.994, 94121.7, 19798.102, 105528.93, 22730.047, 120286.62, 23110.69} };

    FileWriter filew;
    private static NumberFormat nbf1 = NumberFormat.getInstance();
    private static NumberFormat nbf2 = NumberFormat.getInstance();


 public void initialise() {


    for(i=0;i<section1total;i++) {
      section1[i] = new String [section1size[i]][total1];
      section1doubles[i] = new double [section1size[i]][total1];
    }

    for(k=0;k<section1total;k++) {
      for(i=0;i<section1size[k];i++) {
        for(l=0;l<total1;l++) {
          section1[k][i][l] = null;
          section1doubles[k][i][l] = 0.0;
        }
      }
    }

    for(i=0;i<section1total;i++) { arithi[i] = 0; }

 }

 public void readin(String Line) {

    st = new StringTokenizer(Line);

    for (k=0;k<section1total;k++) {
      if((Line.indexOf(section1template[k])) != -1 ) {
         if(arithi[k] == section1size[k]) {
            arithi[k]++;
            break;
         }
         for(j=0;j<total1;j++) { section1[k][arithi[k]][j] = st.nextToken(); }
         arithi[k]++;
      }
    }

 }


  public void stringtodouble() {
// convert necessary strings to doubles for section 2

    System.out.println("Section 1 results for the Java Grande Benchmark Suite");
    System.out.println("-----------------------------------------------------");

// convert necessary strings to doubles for section 1

    for(k=0;k<section1total;k++) {
      for(i=0;i<section1size[k];i++) {
        if(section1[k][i][1] !=null) {
           section1doubles[k][i][0] = Double.valueOf(section1[k][i][1]).doubleValue();
        }
      }
    }

  }

  public void calcjavano() {
// calculate and print the JGFnumbers for section 2


    nbf1.setMaximumFractionDigits(2);
    nbf1.setMinimumFractionDigits(2);

    for(i=0;i<section1total;i++) {
         javano1sum[i] = 1.0;
         javano1[i] = 0.0;
         temp1[i] = 0.0;
    }


    for(k=0;k<section1total;k++) {
      if((section1doubles[k][1][0] != 0.0 ) && (arithi[k] == section1size[k])){
         for(i=0;i<section1size[k];i++) {
           temp1[k] = section1doubles[k][i][0]/section1e3000no[k][i];
           javano1sum[k] = javano1sum[k] * temp1[k];
         }
      }
    }

    for(i=0;i<section1total;i++) {
      if(temp1[i] !=0.0) {
         javano1[i] = Math.pow((javano1sum[i]),(1.00/section1size[i]));
         System.out.println(section1outtemplate[i] + " " + nbf1.format(javano1[i]));
      }
      else {
         System.out.println("Sorry, there was an incorrect amount of data to calculate the JGF Number for the"+ " "+ section1outtemplate[i]);
      }

    }

    if((arithi[0] == section1size[0]) && (arithi[1] == section1size[1]) && (arithi[2] == section1size[2]) && (arithi[3] == section1size[3]) && (arithi[4] == section1size[4]) && (arithi[5] == section1size[5]) && (arithi[6] == section1size[6]) && (arithi[7] == section1size[7]) && (arithi[8] == section1size[8])) {

      javano1all = Math.pow((javano1[0] * javano1[1] * javano1[2] * javano1[3] * javano1[4] * javano1[5] * javano1[6] * javano1[7] * javano1[8]),(1.00/section1total));

      System.out.println(" ");
      System.out.println("Section 1 overall JGFNumber = " + " " + nbf1.format(javano1all));
      System.out.println(" ");
    }

    else {
      System.out.println(" ");
      System.out.println("Sorry, there was an incorrect amount of data to calculate the JGF Number for Section 1");
      System.out.println(" ");
    }


  }


  public void writetable() {

// determine length of section2template array for table formatting

    nbf2.setMaximumFractionDigits(2);
    nbf2.setMinimumFractionDigits(2);


    for(i=0;i<section1total;i++) {
      length1[i] = section1template[i].length();
    }


// write out the results for Section 1 to tables

    section1itotal = arithi[0] + arithi[1] + arithi[2] + arithi[3] + arithi[4] + arithi[5] + arithi[6];

    if(section1itotal !=0.0) {
     JGFNumber.printw.println("<h2 align=\"justify\"><font color=\"#666600\">Section 1 Benchmarks </h2>");
      if(javano1all !=0.0) {JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">Overall JGF Number: " + " " + nbf2.format(javano1all) + " " + "</h3>");}

       for (k=0;k<section1total;k++) {
          if(section1[k][0][0] !=null) {
            JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">" + " " + section1outtemplate[k] + " " + "</h3>");
            if(javano1[k] !=0.0) {JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">JGF Number: " + " " + nbf2.format(javano1[k]) + " " + "</h3>");}
            JGFNumber.printw.println("<center> <p> <table border=2> <p>");
            JGFNumber.printw.println("<tr><td> Benchmark       </td><td> Performance </td><td> Units </tr></td>");
            for(i=0;i<section1size[k];i++) {
              if(section1[k][i][0] != null) {
                JGFNumber.printw.println("<tr><td>" + " " + section1[k][i][0].substring(length1[k]) + " " + "</td><td>" + " " + section1doubles[k][i][0] + " " + "</td><td>" + " " + section1[k][i][2].substring(1,(section1[k][i][2].length()-1)) + " " + "</tr></td>");
              }
            }
          JGFNumber.printw.println("</table> <p> </center> <p>");
          }
       }
      }

    }

}





class sect2class {

    int section2total = 7;
    int total2 = 5;
    int totalsize2 = 3;
    String section2 [][][] = new String [3][section2total][total2];
    String section2sorted [][][] = new String [3][section2total][total2];
    double section2doubles [][][] = new double [3][section2total][2];
    String [] section2sizetemplate = {"SizeA", "SizeB", "SizeC"};

    StringTokenizer st;

    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;

    int section2i[] = new int [totalsize2];

    String [] section2template = {"Section2:Crypt", "Section2:FFT", "Section2:HeapSort", "Section2:SOR", "Section2:LUFact", "Section2:Series", "Section2:SparseMatmult"};
    String [] section2outtemplate = {"SizeA Benchmarks", "SizeB Benchmarks", "SizeC Benchmarks" };

    String  sect2 = "Section2:";
    int sect2length = 0;

    int length2 [] = new int [section2total];

    double javano2sum [] = new double [totalsize2];
    double javano2 [] = new double [totalsize2];
    double temp2 [] = new double [totalsize2];

    double javano2all = 0.0;
    double section2itotal = 0.0;

    int inc2[] = new int [totalsize2];

    double [][] section2e3000no = {{15.139, 54.423, 4.364, 20.094, 5.61, 80.823, 24.111}, {100.992, 278.375, 31.073, 50.866, 49.166, 823.511, 80.816}, {252.504, 598.489, 208.266, 90.465, 378.784, 12757.538, 576.512}};

    FileWriter filew;

    private static NumberFormat nbf1 = NumberFormat.getInstance();
    private static NumberFormat nbf2 = NumberFormat.getInstance();


 public void initialise() {

    for(k=0;k<totalsize2;k++) {
      for(i=0;i<section2total;i++) {
       for(j=0;j<total2;j++) {
        for(l=0;l<2;l++) {
         section2 [k][i][j] = null;
         section2sorted [k][i][j] = null;
         section2doubles [k][i][l] = 0.0;
        }
       }
      }
    }


    for(i=0;i<totalsize2;i++) { section2i[i] = 0; }


 }

 public void readin(String Line) {

    st = new StringTokenizer(Line);

    for(k=0;k<totalsize2;k++) {
      if((Line.indexOf(section2sizetemplate[k])) != -1 ) {
         if(section2i[k] == section2total) {
             section2i[k]++;
             break;
         }
         for(j=0;j<total2;j++) { section2[k][section2i[k]][j] = st.nextToken(); }
             section2i[k]++;
      }
    }


 }


  public void reorder() {

// sort the results into the correct order for section2

    System.out.println("Section 2 results for the Java Grande Benchmark Suite");
    System.out.println("-----------------------------------------------------");

    for(k=0;k<3;k++) { inc2[k] = 0; }

    for(k=0;k<3;k++) {
     for (l=0;l<section2total;l++) {
      if(section2[k][l][0] != null) {
       for (j=0;j<section2total;j++) {
        if(section2[k][l][0].startsWith(section2template[j])) {
          for(i=0;i<total2;i++) { section2sorted[k][j][i] = section2[k][l][i]; }
          inc2[k]++;
        }
       }
      }
     }
    }

  }

  public void stringtodouble() {
// convert necessary strings to doubles for section 2


    for(k=0;k<3;k++) {
      for(i=0;i<section2total;i++) {
        if(section2sorted[k][i][1] != null) {
           section2doubles[k][i][0] = Double.valueOf(section2sorted[k][i][1]).doubleValue();
           section2doubles[k][i][1] = Double.valueOf(section2sorted[k][i][3]).doubleValue();
        }
      }
    }

  }

  public void calcjavano() {
// calculate and print the JGFnumbers for section 2


    nbf1.setMaximumFractionDigits(2);
    nbf1.setMinimumFractionDigits(2);


    for(i=0;i<totalsize2;i++) {
       javano2sum[i] = 1.0;
       javano2[i] = 0.0;
       temp2[i] = 0.0;
    }

    for(j=0;j<totalsize2;j++) {
       for(i=0;i<section2total;i++) {
          if((section2doubles[j][0][0] != 0.0) && (section2doubles[j][1][0] != 0.0) && (section2doubles[j][2][0] != 0.0) && (section2doubles[j][3][0] != 0.0) && (section2doubles[j][4][0] != 0.0) && (section2doubles[j][5][0] != 0.0) && (section2doubles[j][6][0] != 0.0) && (section2i[j] == section2total)) {
           temp2[j] = section2e3000no[j][i]/section2doubles[j][i][0];
           javano2sum[j] = javano2sum[j] * temp2[j];
          }

       }
    }

    for(j=0;j<totalsize2;j++) {
      if(temp2[j] != 0.0) {
         javano2[j] = Math.pow((javano2sum[j]),(1.00/section2total));
         System.out.println(section2outtemplate[j] + " " + nbf1.format(javano2[j]));
      }
      else {
         System.out.println("Sorry, there was an incorrect amount of data to calculate the JGF Number for the"+ " " + section2outtemplate[j]);
      }
    }


    if((section2i[0] == section2total) && (section2i[1] == section2total) && (section2i[2] == section2total)) {
      javano2all = Math.pow((javano2[0] * javano2[1] * javano2[2]),(1.00/totalsize2));
      System.out.println(" ");
      System.out.println("Section 2 overall JGFNumber = " + " " + nbf1.format(javano2all));
    }
    else {
      System.out.println(" ");
      System.out.println("Sorry, there was an incorrect amount of data to calculate the overall JGF Number");
    }

      System.out.println(" ");

  }


  public void writetable() {

// determine length of section2template array for table formatting

    nbf2.setMaximumFractionDigits(2);
    nbf2.setMinimumFractionDigits(2);


    for(i=0;i<section2total;i++) {
      length2[i] = section2template[i].length();
    }

    sect2length = sect2.length();


// write out the section2 results to tables

    section2itotal = section2i[0] + section2i[1] + section2i[2];

    if(section2itotal !=0.0) {
     JGFNumber.printw.println("<h2 align=\"justify\"><font color=\"#666600\">Section 2 Benchmarks </h2>");
      if(javano2all !=0.0) {JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">Overall JGF Number: " + " " + nbf2.format(javano2all) + " " + "</h3>");}

       for (k=0;k<totalsize2;k++) {
          if(section2i[k] !=0.0) {
            JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">" + " " + section2sizetemplate[k] + " " + "</h3>");
            if(javano2[k] !=0.0) {JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">JGF Number: " + " " + nbf2.format(javano2[k]) + " " + "</h3>");}
            JGFNumber.printw.println("<center> <p> <table border=2> <p>");
            JGFNumber.printw.println("<tr><td> Benchmark  </td><td> Time (s) </td><td> Performance </td><td> Performance Units </tr></td> </tr></td>");
            for(i=0;i<section2total;i++) {
              if(section2sorted[k][i][1] != null) {
                 JGFNumber.printw.println("<tr><td>" + " " + section2sorted[k][i][0].substring(sect2length,length2[i]) + " " + "</td><td>" + " " + nbf2.format(section2doubles[k][i][0]) + " " + "</td><td>" + " " + nbf2.format(section2doubles[k][i][1]) + " " + "</td><td>" + section2sorted[k][i][4].substring(1,(section2sorted[k][i][4].length()-1)) + " " + "</tr></td>");
              }
            }
            JGFNumber.printw.println("</table> <p> </center> <p>");
          }
       }
      }
    }


}


class sect3class {

    int section3total = 5;
    int total3 = 5;
    int totalsize3 = 2;
    String section3 [][][] = new String [2][section3total][total3];
    String section3sorted [][][] = new String [2][section3total][total3];
    double section3doubles [][][] = new double [2][section3total][2];
    String [] section3sizetemplate = {"Run:SizeA", "Run:SizeB"};
    String [] section3sizeouttemplate = {"SizeA", "SizeB"};

    StringTokenizer st;

    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;

    int section3i[] = new int [totalsize3];

    String [] section3template = {"Section3:AlphaBetaSearch", "Section3:Euler", "Section3:MolDyn", "Section3:MonteCarlo", "Section3:RayTracer"};

    String [] section3outtemplate = {"SizeA Benchmarks", "SizeB Benchmarks" };

    String  sect3 = "Section3:";
    int sect3length = 0;

    int length3 [] = new int [section3total];

    double javano3sum [] = new double [totalsize3];
    double javano3 [] = new double [totalsize3];
    double temp3 [] = new double [totalsize3];

    double javano3all = 0.0;
    double section3itotal = 0.0;

    int inc3[] = new int [totalsize3];

    double [][] section3e3000no  = {{54.221, 85.235, 61.462, 58.581, 82.481, 911.828}, {226.135, 193.285, 1146.655, 369.677, 911.828}};


    FileWriter filew;

    private static NumberFormat nbf1 = NumberFormat.getInstance();
    private static NumberFormat nbf2 = NumberFormat.getInstance();


 public void initialise() {

    for(k=0;k<totalsize3;k++) {
      for(i=0;i<section3total;i++) {
       for(j=0;j<total3;j++) {
        for(l=0;l<2;l++) {
         section3 [k][i][j] = null;
         section3sorted [k][i][j] = null;
         section3doubles [k][i][l] = 0.0;
        }
       }
      }
    }

    for(i=0;i<totalsize3;i++) { section3i[i] = 0; }

 }

 public void readin(String Line) {

     st = new StringTokenizer(Line);

     for(k=0;k<totalsize3;k++) {
        if((Line.indexOf(section3sizetemplate[k])) != -1 ) {
           if(section3i[k] == section3total) {
              section3i[k]++;
              break;
           }
           for(j=0;j<total3;j++) { section3[k][section3i[k]][j] = st.nextToken(); }
           section3i[k]++;
        }
     }


 }


  public void reorder() {

// sort the results into the correct order for section2

     System.out.println("Section 3 results for the Java Grande Benchmark Suite");
     System.out.println("-----------------------------------------------------");


     for(k=0;k<2;k++) { inc3[k] = 0; }

     for(k=0;k<2;k++) {
      for (l=0;l<section3total;l++) {
       if(section3[k][l][0] != null) {
        for (j=0;j<section3total;j++) {
          if(section3[k][l][0].startsWith(section3template[j])) {
            for(i=0;i<total3;i++) { section3sorted[k][j][i] = section3[k][l][i]; }
            inc3[k]++;
          }
        }
       }
      }
     }

  }

  public void stringtodouble() {
// convert necessary strings to doubles for section 2

     for(k=0;k<2;k++) {
        for(i=0;i<section3total;i++) {
         if(section3sorted[k][i][1] != null) {
           section3doubles[k][i][0] = Double.valueOf(section3sorted[k][i][1]).doubleValue();
           section3doubles[k][i][1] = Double.valueOf(section3sorted[k][i][3]).doubleValue();
         }
        }
     }


  }

  public void calcjavano() {
// calculate and print the JGFnumbers for section 2


     nbf1.setMaximumFractionDigits(2);
     nbf1.setMinimumFractionDigits(2);

     for(i=0;i<totalsize3;i++) {
       javano3sum[i] = 1.0;
       javano3[i] = 0.0;
       temp3[i] = 0.0;
     }

     for(j=0;j<totalsize3;j++) {
        for(i=0;i<section3total;i++) {
          if((section3doubles[j][0][0] != 0.0) && (section3doubles[j][1][0] != 0.0) && (section3doubles[j][2][0] != 0.0) && (section3doubles[j][3][0] != 0.0) && (section3doubles[j][4][0] != 0.0) && (section3i[j] == section3total)) {

           temp3[j] = section3e3000no[j][i]/section3doubles[j][i][0];
           javano3sum[j] = javano3sum[j] * temp3[j];
          }
        }
     }

     for(j=0;j<totalsize3;j++) {
       if(temp3[j] != 0.0) {
        javano3[j] = Math.pow((javano3sum[j]),(1.00/section3total));
        System.out.println(section3outtemplate[j] + " " + nbf1.format(javano3[j]));
       }
       else {
         System.out.println("Sorry, there was an incorrect amount of data to calculate the JGF Number for the" + " " + section3outtemplate[j]);
       }
     }

     if((section3i[0] == section3total) && (section3i[1] == section3total)) {
       javano3all = Math.pow((javano3[0] * javano3[1]),(1.00/totalsize3));
       System.out.println(" ");
       System.out.println("Section 3 overall JGFNumber = " + " " + nbf1.format(javano3all));
     }
     else {
       System.out.println(" ");
       System.out.println("Sorry, there was an incorrect amount of data to calculate the overall JGF Number");
     }
       System.out.println(" ");


  }


  public void writetable() {

// determine length of section2template array for table formatting

     nbf2.setMaximumFractionDigits(2);
     nbf2.setMinimumFractionDigits(2);


// determine length of section3template array for table formatting

    for(i=0;i<section3total;i++) {
      length3[i] = section3template[i].length();
    }

    sect3length = sect3.length();

// write out the section3 results to tables

    section3itotal = section3i[0] + section3i[1];

    if(section3itotal !=0.0) {
      JGFNumber.printw.println("<h2 align=\"justify\"><font color=\"#666600\">Section 3 Benchmarks </h2>");
      if(javano3all !=0.0) {JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">Overall JGF Number: " + " " + nbf2.format(javano3all) + " " + "</h3>");}

       for (k=0;k<totalsize3;k++) {
         if(section3i[k] !=0.0) {
            JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">" + " " + section3sizeouttemplate[k] + " " + "</h3>");
            if(javano3[k] !=0.0) {JGFNumber.printw.println("<h3 align=\"justify\"><font color=\"#666600\">JGF Number: " + " " + nbf2.format(javano3[k]) + " " + "</h3>");}
            JGFNumber.printw.println("<center> <p> <table border=2> <p>");
            JGFNumber.printw.println("<tr><td> Benchmark  </td><td> Time (s) </td><td> Performance </td><td> Performance Units </tr></td> </tr></td>");
            for(i=0;i<section3total;i++) {
              if(section3sorted[k][i][1] != null) {
                JGFNumber.printw.println("<tr><td>" + " " + section3sorted[k][i][0].substring(sect3length,length3[i]) + " " + "</td><td>" + " " + nbf2.format(section3doubles[k][i][0]) + " " + "</td><td>" + " " + nbf2.format(section3doubles[k][i][1]) + " " + "</td><td>" + section3sorted[k][i][4].substring(1,(section3sorted[k][i][4].length()-1)) + " " + "</tr></td>");
              }
            }
            JGFNumber.printw.println("</table> <p> </center> <p>");
         }
       }
     }


   }

}




