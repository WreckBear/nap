package open.nap.factory;

import javax.sql.DataSource;

import open.nap.impl.excutor.Insert;
import open.nap.itf.excutor.IInsertExcutor;
import open.nap.itf.excutor.INAPSession;

public class NapFactory {
	
	/**
	 * 工厂方法，用来返回NapSession
	 * @param ds
	 * @return
	 */
	public static INAPSession getSession() {
		return null;
	}

	/**
	 * 工厂方法，用来返回插入执行器的实例
	 * @param ds
	 * @return
	 */
	public static IInsertExcutor getInsertExcutor(DataSource ds) {
		return new Insert(ds);
	}
	
}
