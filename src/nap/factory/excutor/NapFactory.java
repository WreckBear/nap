package nap.factory.excutor;

import javax.sql.DataSource;

import nap.impl.excutor.Insert;
import nap.itf.excutor.IInsertExcutor;

public class NapFactory {

	/**
	 * ��ò���ִ����
	 * @param ds
	 * @return
	 */
	public static IInsertExcutor getInsertExcutor(DataSource ds) {
		return new Insert(ds);
	}
	
}
