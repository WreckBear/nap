package nap.factory.excutor;

import javax.sql.DataSource;

import nap.impl.excutor.Insert;
import nap.itf.excutor.IInsertExcutor;

public class NapFactory {

	/**
	 * 获得插入执行器
	 * @param ds
	 * @return
	 */
	public static IInsertExcutor getInsertExcutor(DataSource ds) {
		return new Insert(ds);
	}
	
}
