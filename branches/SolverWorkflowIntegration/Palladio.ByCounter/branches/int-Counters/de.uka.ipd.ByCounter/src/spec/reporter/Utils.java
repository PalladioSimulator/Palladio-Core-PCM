/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package spec.reporter;

import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Iterator;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import spec.harness.Constants;

public class Utils {

    static final String RUN_INFO = "run-info";
    static final String JVM_INFO = "jvm-info";
    static final String SW_INFO = "sw-info";
    static final String HW_INFO = "hw-info";
    static final String WORKLOAD_ENAME = "workload";
    static final String VIOLATIONS_ENAME = "violations";
    static final String VIOLATION_ENAME = "violation";
    static final String CONFIGS_ENAME = "configs";
    static final String CONFIG_ENAME = "config";
    static final String ERRORS_ENAME = "errors";
    static final String ERROR_ENAME = "error";
    static final String LOOPS_ENAME = "loops";
    static final String ANALYZERS_ENAME = "analyzers";
    static final String ANALYZER_SUMMARIES_ENAME = "analyzer-results";
    static final String ITERATIONS_ENAME = "iterations";
    static final String LOOP_RESULT_ENAME = "loop-result";
    static final String TYINFO_ENAME = "tyinfo";
    static final String ITERATION_ENAME = "iteration";
    static final String NAME_ENAME = "name";
    static final String UNIT_ENAME = "unit";
    static final String NUM_BM_THREADS_ENAME = "numberBmThreads";
    static final String ITERATION_TIME_ENAME = "iterationTime";
    static final String WARMUP_TIME_ENAME = "warmupTime";
    static final String MIN_ITER_ENAME = "minIter";
    static final String MAX_ITER_ENAME = "maxIter";
    static final String ANALYZER_FREQ_ENAME = "analyzerFreq";
    static final String BM_DELAY_ENAME = "benchmarkDelay";
    static final String ITER_DELAY_ENAME = "iterationDelay";
    static final String START_TIME_ENAME = "startTime";
    static final String END_TIME_ENAME = "endTime";
    static final String EXPECTED_DURATION_ENAME = "expectedDuration";
    static final String OPERATIONS_ENAME = "operations";
    static final String BM_THREAD_ID_ENAME = "bmThreadId";
    static final String TIME_ENAME = "time";
    static final String VALUE_ENAME = "value";
    static final String HEAP_SIZE_ENAME = "Total Memory in Heap";
    static final String FREE_MEMORY_ENAME = "Free Memory in Heap";
    static final String BM_RESULTS_ENAME = "benchmark-results";
    static final String HTML_WRITER_TYPE = "html";
    static final String PLAIN_WRITER_TYPE = "plain";
    //SUMMARY PROPS
    static final String STATUS_PROPS = "spec.jvm2008.report.result.status";
    static final String SCORE_PROPS = "spec.jvm2008.report.result.score";
    static final String METRIC_PROPS = "spec.jvm2008.report.result.metric";
    static final String WORKLOAD_NAME_PROPS = "spec.jvm2008.report.result.workload.name";
    static final String WORKLOAD_MODE_PROPS = "spec.jvm2008.report.result.workload.mode";
    static final String[] DETAILS_TABLE_COLUMNS_NAMES = new String[]{
        "benchmark name",
        "configuration",
        "iteration",
        "expected run time (millis)",
        "actual run time(millis)",
        "operations",
        Constants.WORKLOAD_METRIC,
        "graph"
    };
    static final String[] DETAILS_TABLE_BM_CONF_NAMES = new String[]{
        "number of threads",
        "minIter",
        "maxIter",
        "warmup time",
        "run time",
        "iteration delay",
        "analyzers",
        "analyzers frequency"
    };
    static final String[] BM_CONFIGURATION_ENAMES = new String[]{
        NUM_BM_THREADS_ENAME,
        MIN_ITER_ENAME,
        MAX_ITER_ENAME,
        WARMUP_TIME_ENAME,
        ITERATION_TIME_ENAME,
        ITER_DELAY_ENAME,
        ANALYZERS_ENAME,
        ANALYZER_FREQ_ENAME
    };
    static final String SCIMARK_LARGE_SBNAME = "scimark.large";
    static final String SCIMARK_SMALL_SBNAME = "scimark.small";
    static final String CRYPTO_SBNAME = "crypto";
    static final String XML_SBNAME = "xml";
    static final String STARTUP_SBNAME = "startup";
    static final String COMPILER_SBNAME = "compiler";
    //directories for reporter
    public static String REPORTER_DIR;
    public static String IMAGES_DIR;

    public static void createBmResultGraph(BenchmarkRecord record) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String iterName = "";
        double max = 0;
        double min = Long.MAX_VALUE;
        for (int i = 0; i < record.iterRecords.size(); i++) {
            BenchmarkRecord.IterationRecord iterRecord =
                    (BenchmarkRecord.IterationRecord) record.iterRecords.get(i);
            String shortName = iterRecord.iterName.replaceFirst("ation", "");
            if (iterRecord.score > max) {
                max = iterRecord.score;
                iterName = shortName;
            }

            if (iterRecord.score < min) {
                min = iterRecord.score;
            }

            dataset.addValue(iterRecord.score, " ",
                    shortName);
        }

        JFreeChart chart = ChartFactory.createLineChart("  ",
                "iterations",
                Constants.WORKLOAD_METRIC,
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(201, 222, 254));
        plot.setRangeGridlinePaint(Color.WHITE);
        if (record.isValidRun() && min != Long.MAX_VALUE) {
            plot.getRangeAxis().setRange(min - 10, max + 10);
        } else {
            plot.getRangeAxis().setRange(0, max + 10);
        }
        ValueMarker vm = new ValueMarker(record.maxScore);
        vm.setLabel(Utils.df.format(record.maxScore));
        vm.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        vm.setLabelTextAnchor(TextAnchor.HALF_ASCENT_LEFT);

        plot.addRangeMarker(vm);
        CategoryMarker marker = new CategoryMarker(iterName);
        marker.setDrawAsLine(true);
        marker.setPaint(vm.getPaint());
        plot.addDomainMarker(marker);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setFillPaint(Color.WHITE);
        renderer.setSeriesPaint(0, Color.BLUE.darker());

        try {
            ChartUtilities.saveChartAsJPEG(new File(Utils.getFullImageName(
                    record.name + "_results")), chart, 300, 200);
        } catch (Exception e) {
            System.out.println("Problems...");
        }
    }
    private static Hashtable<String, String> descriptions;
    final static DecimalFormat df = new DecimalFormat("#.##");

    private static void initDescriptions() {
        descriptions = new Hashtable<String, String>();
        //run info
        descriptions.put(Constants.REPORTER_RUN_DATE, "Test date:");
        descriptions.put(Constants.REPORTER_RUN_SUBMITTER_URL, "Submitter URL");
        descriptions.put(Constants.REPORTER_RUN_LICENSE, "SPEC license");
        descriptions.put(Constants.REPORTER_RUN_TESTER, "Tester");
        descriptions.put(Constants.REPORTER_RUN_SUBMITTER, "Submitter");
        descriptions.put(Constants.REPORTER_RUN_LOCATION, "Location");

        //jvm info
        descriptions.put(Constants.REPORTER_JVM_VENDOR, "Vendor");
        descriptions.put(Constants.REPORTER_JVM_VENDOR_URL, "Vendor URL");
        descriptions.put(Constants.REPORTER_JVM_NAME, "JVM name");
        descriptions.put(Constants.REPORTER_JVM_VERSION, "JVM version");
        descriptions.put(Constants.REPORTER_JVM_AVAILABLE_DATE, "JVM available");
        descriptions.put(Constants.REPORTER_JVM_JAVA_SPECIFICATION, "Java Specification");
        descriptions.put(Constants.REPORTER_JVM_ADDRESS_BITS, "JVM address bits");
        descriptions.put(Constants.REPORTER_JVM_COMMAND_LINE_INITIAL_HEAP_SIZE, "JVM initial heap memory");
        descriptions.put(Constants.REPORTER_JVM_COMMAND_LINE_MAX_HEAP_SIZE, "JVM maximum heap memory");
        descriptions.put(Constants.REPORTER_JVM_COMMAND_LINE, "JVM command line");
        descriptions.put(Constants.REPORTER_JVM_STARTUP_COMMAND_LINE, "JVM command line startup");
        descriptions.put(Constants.REPORTER_JVM_STARTUP_LAUNCHER, "JVM launcher startup");
        descriptions.put(Constants.REPORTER_JVM_OTHER_TUNING, "Additional JVM tuning");
        descriptions.put(Constants.REPORTER_JVM_APP_CLASS_PATH, "JVM class path");
        descriptions.put(Constants.REPORTER_JVM_BOOT_CLASS_PATH, "JVM boot class path");

        //sw-info
        descriptions.put(Constants.REPORTER_OS_NAME, "OS name");
        descriptions.put(Constants.REPORTER_OS_AVAILABLE_DATE, "OS available");
        descriptions.put(Constants.REPORTER_OS_ADDRESS_BITS, "OS address bits");
        descriptions.put(Constants.REPORTER_OS_TUNING, "OS tuning");
        descriptions.put(Constants.REPORTER_SW_FILESYSTEM, "Filesystem");
        descriptions.put(Constants.REPORTER_SW_OTHER_NAME, "Other s/w name");
        descriptions.put(Constants.REPORTER_SW_OTHER_TUNING, "Other s/w tuning");
        descriptions.put(Constants.REPORTER_SW_OTHER_AVAILABLE, "Other s/w available");

        //hw-info
        descriptions.put(Constants.REPORTER_HW_VENDOR, "HW vendor");
        descriptions.put(Constants.REPORTER_HW_VENDOR_URL, "HW vendor's URL");
        descriptions.put(Constants.REPORTER_HW_MODEL, "HW model");
        descriptions.put(Constants.REPORTER_HW_AVAILABLE, "HW available");
        descriptions.put(Constants.REPORTER_HW_CPU_VENDOR, "CPU vendor");
        descriptions.put(Constants.REPORTER_HW_CPU_VENDOR_URL, "CPU vendor's URL");
        descriptions.put(Constants.REPORTER_HW_CPU_NAME, "CPU name");
        descriptions.put(Constants.REPORTER_HW_CPU_SPEED, "CPU frequency");
        descriptions.put(Constants.REPORTER_HW_LOGICAL_CPUS, "# of logical cpus");
        descriptions.put(Constants.REPORTER_HW_NUMBER_OF_CHIPS, "# of chips");
        descriptions.put(Constants.REPORTER_HW_NUMBER_OF_CORES, "# of cores");
        descriptions.put(Constants.REPORTER_HW_NUMBER_OF_CORES_PER_CHIP, "Cores per chip");
        descriptions.put(Constants.REPORTER_HW_THREADS_PER_CORE, "Threads per core");
        descriptions.put(Constants.REPORTER_HW_THREADING_ENABLED, "Threading enabled");
        descriptions.put(Constants.REPORTER_HW_ADDRESS_BITS, "HW address bits");
        descriptions.put(Constants.REPORTER_HW_CPU_CACHE_L1, "Primary cache");
        descriptions.put(Constants.REPORTER_HW_CPU_CACHE_L2, "Secondary cache");
        descriptions.put(Constants.REPORTER_HW_CPU_CACHE_OTHER, "Other cache");
        descriptions.put(Constants.REPORTER_HW_MEMORY_DETAILS, "Memory details");
        descriptions.put(Constants.REPORTER_HW_MEMORY_SIZE, "Memory size");
        descriptions.put(Constants.REPORTER_HW_DETAILS_OTHER, "Other HW details");

        descriptions.put("category", "Category of run");
        descriptions.put("iterationTime", "Iteration duration");
        descriptions.put("warmupTime", "Warm up time");
        descriptions.put("minIter", "Minimum Iterations");
        descriptions.put("maxIter", "Maximum Iterations");
        descriptions.put("analyzers", "Analyzer names");
        descriptions.put("analyzerFreq", "Analyzer frequency");
        descriptions.put("specjvm.benchmark.systemgc", "System.gc in between benchmarks");
        descriptions.put("benchmarkDelay", "Benchmark delay");
        descriptions.put("specjvm.iteration.systemgc", "System.gc in between iterations");
        descriptions.put("iterationDelay", "Iteration delay");
    }

    public static String getDescription(String prop) {
        if (descriptions == null) {
            initDescriptions();
        }
        Object result = descriptions.get(prop);
        return (result != null) ? (String) result : prop;
    }
    static final HashMap colorMap = initColorMap();

    public static final HashMap initColorMap() {
        HashMap<String, Color> result = new HashMap<String, Color>();
        result.put("composite score", new Color(192, 0, 0));
        //TODO
        //result.put("db", new Color())
        result.put(Constants.SUNFLOW_BNAME, new Color(85, 255, 85));
        result.put(Constants.MPEGAUDIO_BNAME, new Color(169, 22, 218));
        result.put(SCIMARK_LARGE_SBNAME, new Color(90, 150, 77));
        result.put(SCIMARK_SMALL_SBNAME, new Color(255, 85, 255));
        result.put(STARTUP_SBNAME, new Color(85, 255, 255));
        //result.put(SCIMARK_SOR_BNAME, new Color(240, 205, 0));
        result.put(Constants.COMPRESS_BNAME, new Color(0, 0, 192));
        result.put(Constants.SERIAL_BNAME, new Color(0, 192, 0));
        result.put(CRYPTO_SBNAME, new Color(192, 0, 192));
        result.put(COMPILER_SBNAME, new Color(0, 192, 192));
        result.put(Constants.DERBY_BNAME, new Color(255, 64, 64));
        result.put(XML_SBNAME, new Color(64, 64, 255));
        //result.put(CHART_BNAME, new Color(242, 147, 77));
        return result;
    }

    public static void generateMainChart(ArrayList benchmarksRecords,
            double compositeScore,
            int validBenchmarksNumber,
            TreeMap<String, Double> sbScores) {

        // Valid benchmarks + room for all possible extra - compiler, crypto, scimark, scimark.small, scimark.large, startup, xml, composite score
        Color[] colors = new Color[validBenchmarksNumber + 8];

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int count = 0;
        String benchmarkDone = null;
        boolean done = false;      
        for (int i = 0; i < benchmarksRecords.size(); i++) {
            BenchmarkRecord record = (BenchmarkRecord) benchmarksRecords.get(i);
            String[] recB = record.name.split("\\.");

            if (benchmarkDone != null) {
                if (recB[0].equals(benchmarkDone) == true) {
                    done = true;
                }
            }
            if (record.isSubgroupMember && false == done) {
                Iterator<String> iterator = sbScores.keySet().iterator();

                while (iterator.hasNext()) {
                    String key = iterator.next();
                    Double value = sbScores.get(key);
                    String[] benchmark = key.split("\\.");
                    String[] recordB = record.name.split("\\.");
                    if (value != null && benchmark[0].equals(recordB[0])) {
                        benchmarkDone = benchmark[0];
                        dataset.addValue(value, key, key);
                        colors[count++] = (Color) colorMap.get(key);
                    }
                }
            }

            if (!Utils.isCheck(record) && !record.isSubgroupMember) {
                dataset.addValue(record.maxScore, record.name, record.name);
                colors[count++] = (Color)colorMap.get(record.name);
            }
        }

        Iterator<String> iter = sbScores.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Object value = sbScores.get(key);
            if (value != null) {
                dataset.addValue(((Double) value).doubleValue(), key, key);
                colors[count++] = (Color) colorMap.get(key);
            }
        }

        Double dataDouble = compositeScore;
        dataset.addValue(dataDouble.doubleValue(), "composite score", "composite score");

        colors[count++] = (Color) colorMap.get("composite score");

        JFreeChart chart = ChartFactory.createStackedBarChart(
                "Scores", // chart title
                "", // domain axis label
                "",
                dataset, // data
                PlotOrientation.HORIZONTAL, // orientation
                false, // include legend
                false, // tooltips?
                false // URLs?
                );

        CategoryItemRenderer renderer = chart.getCategoryPlot().getRendererForDataset(dataset);
        for (int i = 0; i < count; i++) {
            Color paint = (Color) colors[i];
            if (paint != null) {
                renderer.setSeriesPaint(i, paint);
            }
        }

        try {
            ChartUtilities.saveChartAsJPEG(new File(getFullImageName("all")),
                    chart, 600, 50 + (dataset.getRowCount()) * 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static final boolean isCheck(BenchmarkRecord record) {
        return Constants.CHECK_BNAME.equals(record.name);
    }

    static final boolean isScimark(BenchmarkRecord record) {
        return record.name.startsWith(Constants.SCIMARK_BNAME_PREFIX);
    }

    static final boolean isScimarkMonteCarlo(BenchmarkRecord record) {
        return Constants.SCIMARK_MONTE_CARLO_BNAME.equals(record.name);
    }

    static final boolean isScimarkLarge(BenchmarkRecord record) {
        return record.name.startsWith(Constants.SCIMARK_BNAME_PREFIX) && record.name.endsWith(Constants.SCIMARK_BNAME_LARGE_POSTFIX);
    }

    static final boolean isScimarkSmall(BenchmarkRecord record) {
        return record.name.startsWith(Constants.SCIMARK_BNAME_PREFIX) && record.name.endsWith(Constants.SCIMARK_BNAME_SMALL_POSTFIX);
    }

    static final boolean isStartup(BenchmarkRecord record) {
        return record.name.startsWith(Constants.STARTUP_BNAME_PREFIX);
    }

    static final boolean isCompiler(BenchmarkRecord record) {
        return record.name.startsWith(Constants.COMPILER_BNAME_PREFIX);
    }

    static final boolean isCrypto(BenchmarkRecord record) {
        return record.name.startsWith(Constants.CRYPTO_BNAME_PREFIX);
    }

    static final boolean isXML(BenchmarkRecord record) {
        return record.name.startsWith(Constants.XML_BNAME_PREFIX);
    }

    static final String getImageName(String pictureName) {
        return "images/" + pictureName + ".jpg";
    }

    static final String getFullImageName(String pictureName) {
        return IMAGES_DIR + "/" + pictureName + ".jpg";
    }

    static final String getRunStatus(boolean validRun,
            boolean compliantRun) {
        if (validRun && compliantRun) {
            return "Run is compliant";
        } else if (validRun) {
            return "Run is valid, but not compliant";
        } else {
            return "Run isn't valid";
        }
    }
}
