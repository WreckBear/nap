package open.nap.util.createtor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import open.nap.itf.model.base.BaseModel;
import open.nap.util.builder.MYSQL5Builder;
import open.nap.util.common.ReflectUtil;

/**
 * 根据现有Model自动生成数据库表的生成器
 * 
 * @author zhanghao10
 *
 */
public class TabelCreator {


	/**
	 * 判断某个表名是否存在
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	public static boolean checkTable(Connection con,String tableName) throws SQLException{
		DatabaseMetaData dsMeta = con.getMetaData();
		ResultSet tables = dsMeta.getTables(null, null, tableName, null);
		// 如果有表，则表明该表存在
		if(tables.next())
			return true;
		// 否则不存在
		return false;
	}
	
	/**
	 * 构建表，如果表不在存在，则构建表，如果存在则不构建
	 * @param model
	 * @throws SQLException 
	 */
	public static void constructTable(Connection con,BaseModel model) throws SQLException {
		// 如果已经存在表，则不需新建表了
		if(checkTable(con, model.getTableName())) {
			return;
		}
		// 开始新建表
		String tableName = model.getTableName();
		Field[] fields = ReflectUtil.getAllField(model.getClass());
		String createTableSQL = MYSQL5Builder.buildCreateTableSQL(tableName,fields);
		
	}
	
}
