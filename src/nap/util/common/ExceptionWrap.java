package nap.util.common;

import nap.exception.dao.NapException;

public class ExceptionWrap {

	/**
	 * ���������쳣��װ�ɿ�ܵ��쳣
	 * @param e
	 */
	public static void wrapNapException(Exception e) {
		throw new NapException(e);
	}
	
}
