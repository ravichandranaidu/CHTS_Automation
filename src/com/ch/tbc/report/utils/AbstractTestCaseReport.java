package com.ch.tbc.report.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.ch.occ.constants.FileConstants;
import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.tbc.email.EmailUtility;
import com.ch.tbc.reports.ReportGenerator;
import com.ch.tbc.reports.TestCaseDetail;
import com.ch.tbc.reports.TestCaseFactory;
import com.ch.tbc.reports.TestSummaryResult;

public class AbstractTestCaseReport extends CommonUtility implements FileConstants
{

    @AfterClass
    public void testQuitDriver()
    {
        SeleniumUtils.quitDriver();
        System.out.println("Browser CLosed");
    }

    @AfterSuite
    public void reportgenerator()
    {
        generateHTML(TestCaseFactory.getTestcases());
        System.out.println("Report generated");
    }

    public void generateHTML(ArrayList<TestCaseDetail> list)
    {
        try
        {
            String starthtml = "<html>";
            String head = FileUtility.readContent(HEAD_FILE);
            String body = "<body bgcolor=\"#f1f1c1\">";
            String endhtml = "</body></html>";

            ArrayList<TestSummaryResult> testSuites = getAllTestSuites(list);
            String summaryTable = ReportGenerator.generateSummaryTable(testSuites);
            String detailReport = generateCaseDetailTable(testSuites, list);
           
            String htmlContent = starthtml + head + body + summaryTable + detailReport + endhtml;
            String currentDate = getCurrentDate();
            FileUtility.writeHTMLContent(REPORTS_HOME + "ExecutionReport"+ currentDate + ".html", htmlContent);
            EmailUtility.sendEmail("OCC Report-"+ currentDate, htmlContent);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String generateCaseDetailTable(ArrayList<TestSummaryResult> testSuites,
            ArrayList<TestCaseDetail> testcases) throws Exception
    {
        if (0 == testcases.size())
        {
            return "";
        }
        String starttable = FileUtility.readContent(TABLEDEATILCASE_HEAD_FILE);
        String content = "";
        
        for (Iterator<TestSummaryResult> iterator = testSuites.iterator(); iterator.hasNext();)
        {
            TestSummaryResult suite = (TestSummaryResult) iterator.next();
            boolean flag = true;
            
            for (Iterator<TestCaseDetail> iterator1 = testcases.iterator(); iterator1.hasNext();)
            {
                TestCaseDetail testcase = (TestCaseDetail) iterator1.next();
                if (suite.getSuiteName().equalsIgnoreCase(testcase.getTestsuitename()))
                {
                    String color;
                    if ("Pass".equalsIgnoreCase(testcase.getResult()))
                    {
                        color = "green";
                    } else
                    {
                        color = "red";
                    }
                    if (true == flag)
                    {
                        content = content + "<tr><td rowspan=" + suite.getTotal() + ">" + suite.getSuiteName()
                                + "</td><td>" + testcase.getTestcasename() + "</td><td>" + testcase.getExpectedresult()
                                + "</td><td> <font color= \"" + color + "\">" + testcase.getResult() + "</td><td>"
                                + testcase.getErrorlog() + "</td></tr>";
                        flag = false;
                    } else
                    {
                        content = content + "<tr><td>" + testcase.getTestcasename() + "</td><td>"
                                + testcase.getExpectedresult() + "</td><td> <font color= \"" + color + "\">"
                                + testcase.getResult() + "</td><td>" + testcase.getErrorlog() + "</td></tr>";
                    }
                }
            }
        }
        String endtable = "</table>";

        return starttable + content + endtable;
    }

    private ArrayList<TestSummaryResult> getAllTestSuites(ArrayList<TestCaseDetail> list)
    {
        HashMap<String, TestSummaryResult> suites = new HashMap<String, TestSummaryResult>();
        for (Iterator<TestCaseDetail> iterator = list.iterator(); iterator.hasNext();)
        {
            TestCaseDetail testCaseDetail = (TestCaseDetail) iterator.next();
            String suite = testCaseDetail.getTestsuitename();
            int pass = 0, fail = 0;
            if (testCaseDetail.getResult().equalsIgnoreCase("PASS"))
            {
                pass = 1;
            } else
            {
                fail = 1;
            }
            if (suites.get(suite) == null)
            {
                suites.put(suite, new TestSummaryResult(suite, pass, fail));
            } else
            {
                TestSummaryResult result = suites.get(suite);
                if (pass == 1)
                {
                    result.incrementPass();
                } else
                {
                    result.incrementFail();
                }
            }
        }
        Set<String> set = suites.keySet();
        ArrayList<TestSummaryResult> testsuites = new ArrayList<TestSummaryResult>();
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();)
        {
            String name = (String) iterator.next();
            testsuites.add(suites.get(name));
        }
        return testsuites;
    }

}
