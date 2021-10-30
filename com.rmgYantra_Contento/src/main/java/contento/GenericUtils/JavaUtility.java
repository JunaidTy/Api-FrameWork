package contento.GenericUtils;

import java.util.Random;

/**
 * This class is created for java methods.
 * @author JAnsari
 *
 */

public class JavaUtility {
	
	/**
	 * This method is used to generate random number.
	 * @return
	 */
	public int getRandomNumber() {
		Random random=new Random();
		int ran = random.nextInt(100);
		return ran;
	}

}
