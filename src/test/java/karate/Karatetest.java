package karate;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Karatetest {

    @Test
    public void testParalell() {
        String tags = System.getProperty("runTags");
        if (null == tags) {
            tags = "~@ignore";
        }
        Results results = Runner.path("classpath:features").outputCucumberJson(true).parallel(1);
        generateReport(results.getReportDir());
        Assertions.assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    public static void generateReport(String reportPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(reportPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(jsonFile -> jsonPaths.add(jsonFile.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "TSKarateTest");
        new ReportBuilder(jsonPaths, config).generateReports();
    }
}
