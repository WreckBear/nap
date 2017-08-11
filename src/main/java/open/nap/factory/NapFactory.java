package open.nap.factory;

import javax.sql.DataSource;

import open.nap.impl.excutor.Insert;
import open.nap.itf.excutor.IInsertExcutor;

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
