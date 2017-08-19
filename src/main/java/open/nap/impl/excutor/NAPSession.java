package open.nap.impl.excutor;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import open.nap.itf.excutor.INAPSession;
import open.nap.itf.model.base.BaseModel;
import open.nap.util.common.ExceptionWrap;
import open.nap.util.createtor.TabelCreator;

public class NAPSession implements INAPSession{

	private DataSource ds;
	
	@Override
	public Object insert(BaseModel model) {
		try {
			Connection con = ds.getConnection();
			TabelCreator.constructTable(con, model);
			new Insert(con).insert(model);
		} catch (SQLException e) {
			ExceptionWrap.wrapNapException(e);
		}
		return null;
	}

	@Override
	public Object delete(BaseModel model) {
		return null;
	}

	@Override
	public Object update(BaseModel model) {
		return null;
	}

	@Override
	public Object queryByPK(BaseModel model) {
		return null;
	}

	
	
}
