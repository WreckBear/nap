package open.nap.impl.excutor;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import open.nap.itf.excutor.IInsertExcutor;
import open.nap.itf.model.base.BaseModel;
import open.nap.util.builder.MYSQL5Builder;
import open.nap.util.common.ExceptionWrap;

public class Insert implements IInsertExcutor {

	private DataSource ds;
	private Connection con;

	public Insert(DataSource ds) {
		this.ds = ds;
		initConnect();
	}

	private void initConnect() {
		try {
			this.con = ds.getConnection();
		} catch (SQLException e) {
			ExceptionWrap.wrapNapException(e);
		}		
	}

	public Insert(Connection con) {
		this.con = con;
	}

	@Override
	public Object insert(BaseModel model) {
		Object result = null;
		try {
			QueryRunner qr = new QueryRunner();
			String insertSQL = MYSQL5Builder.buildInsertSQL(model);
			result = qr.insert(con,insertSQL, new BeanHandler<>(model.getClass()));
		} catch (SQLException e) {
			ExceptionWrap.wrapNapException(e);
		}
		return result;
	}

}
