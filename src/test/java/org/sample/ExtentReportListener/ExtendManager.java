/**
 * 
 */
package org.sample.ExtentReportListener;

import com.relevantcodes.extentreports.ExtentReports;
/**
 * @author hasan
 *
 */
public class ExtendManager {

	/**
	 * 
	 */
    private static ExtentReports extent;
    
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"/target/surefire-reports/ExtentReportResults.html", true);
            /*new ExtentReports(outputDirectory + File.separator
    				+ "ExtentReport.html", true);*/
        }
        return extent;
    }

}
