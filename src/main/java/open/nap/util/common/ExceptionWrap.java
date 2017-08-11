package open.nap.util.common;

import open.nap.exception.NapException;

public class ExceptionWrap {

	/**
	 * 用来将其他异常包装成框架异常
	 * @param e
	 */
	public static void wrapNapException(Exception e) {
		throw new NapException(e);
	}
	
}
