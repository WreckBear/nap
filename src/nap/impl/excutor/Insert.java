package nap.impl.excutor;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import nap.itf.excutor.IInsertExcutor;
import nap.itf.model.base.BaseModel;
import nap.util.common.ExceptionWrap;
import nap.util.common.SQLBuild;

public class Insert implements IInsertExcutor{

	private DataSource ds;
	
	public Insert(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Object insert(BaseModel model) {
		Object result = null;
		try {
			QueryRunner qr = new QueryRunner(ds);
			String insertSQL = SQLBuild.buildInsertSQL(model);
			Class handleClass = Class.forName(model.getModelClassName());
			result = qr.insert(insertSQL, new BeanHandler<>(handleClass));
		} catch (SQLException e) {
			ExceptionWrap.wrapNapException(e);
		} catch (ClassNotFoundException e) {
			ExceptionWrap.wrapNapException(e);
		}
		return result;
	}

	
}
