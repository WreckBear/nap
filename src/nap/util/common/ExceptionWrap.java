package nap.util.common;

import nap.exception.dao.NapException;

public class ExceptionWrap {

	/**
	 * 将其他的异常包装成框架的异常
	 * @param e
	 */
	public static void wrapNapException(Exception e) {
		throw new NapException(e);
	}
	
}
