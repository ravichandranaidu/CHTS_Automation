
package com.ch.tbc.reports;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.ch.occ.constants.FileConstants;
import com.ch.tbc.report.utils.CommonUtility;

public class TestCaseDetail extends CommonUtility implements FileConstants
{
    String testsuitename    = "";
    String testcasename     = "";
    String expectedresult   = "";
    String result           = "";
    String errorlog         = "";
    String exceptionmessage = "";

    /**
     * @return the testsuitename
     */

    public TestCaseDetail(String testsuitename, String tcname, String expectdresult, String result, String errorlog,
            String excepmsg)
    {
        this.testsuitename = testsuitename;
        testcasename = tcname;
        this.expectedresult = expectdresult;
        this.result = result;
        this.errorlog = errorlog;
        exceptionmessage = excepmsg;
    }

    public TestCaseDetail(Class<?> object, String name)
    {
        this.testsuitename = object.getSimpleName();
        this.testcasename = name;
    }

    public void pass(String expectedResult)
    {
        if ("".equalsIgnoreCase(result))
        {
            this.expectedresult = expectedResult;
            result = "PASS";
        }
    }

    public void setErrorLogFile(Throwable trace)
    {
        String errorFile = REPORTS_HOME + getCurrentDate() + ".log";
        try
        {
            PrintWriter printWriter = new PrintWriter(errorFile);
            trace.printStackTrace(printWriter);
            printWriter.close();
            this.errorlog = "<a target=\"_balnk\" href=\"" + "./" + getCurrentDate() + ".log"
                    + "\"> <font color=\"red\">Error Log</a>";
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void fail(String expectedResult, String actual)
    {
        if ("".equalsIgnoreCase(result))
        {
            this.expectedresult = expectedResult;
            result = "FAIL";
            exceptionmessage = actual;
        } else
        {
            this.expectedresult = this.expectedresult + "\n" + expectedResult;
            result = "FAIL";
            exceptionmessage = this.exceptionmessage + "\n" + actual;
        }
    }

    public void error(String expectedResult, Throwable trace)
    {
        this.expectedresult = expectedResult;
        result = "ERROR";
        exceptionmessage = trace.getMessage();
        setErrorLogFile(trace);
    }

    public String getTestsuitename()
    {
        return testsuitename;
    }

    /**
     * @param testsuitename
     *            the testsuitename to set
     */
    public void setTestsuitename(String testsuitename)
    {
        this.testsuitename = testsuitename;
    }

    /**
     * @return the testcasename
     */
    public String getTestcasename()
    {
        return testcasename;
    }

    /**
     * @param testcasename
     *            the testcasename to set
     */
    public void setTestcasename(String testcasename)
    {
        this.testcasename = testcasename;
    }

    /**
     * @return the expectedresult
     */
    public String getExpectedresult()
    {
        return expectedresult;
    }

    /**
     * @param expectedresult
     *            the expectedresult to set
     */
    public void setExpectedresult(String expectedresult)
    {
        this.expectedresult = expectedresult;
    }

    /**
     * @return the result
     */
    public String getResult()
    {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * @return the errorlog
     */
    public String getErrorlog()
    {
        return errorlog;
    }

    /**
     * @param errorlog
     *            the errorlog to set
     */
    public void setErrorlog(String errorlog)
    {
        this.errorlog = errorlog;
    }

    /**
     * @return the exceptionmessage
     */
    public String getExceptionmessage()
    {
        return exceptionmessage;
    }

    /**
     * @param exceptionmessage
     *            the exceptionmessage to set
     */
    public void setExceptionmessage(String exceptionmessage)
    {
        this.exceptionmessage = exceptionmessage;
    }

}
