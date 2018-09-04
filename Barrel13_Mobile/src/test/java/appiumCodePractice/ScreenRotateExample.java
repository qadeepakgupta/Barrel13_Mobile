package appiumCodePractice;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;

/**
 * @author CHIRAG
 *
 */
public class ScreenRotateExample extends TestBase {

	private static final Logger log = Logger.getLogger(ScreenRotateExample.class.getName());

	@Test
	public void testLoginErrorMessage() throws InterruptedException {
		try {

			log.info("======= starting testLoginErrorMessage() test========");

			screenRotate();
		
			log.info("======= finished testLoginErrorMessage() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLoginErrorMessage() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}