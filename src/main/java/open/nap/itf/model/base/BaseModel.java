package open.nap.itf.model.base;

public abstract class BaseModel {

	/**
	 * 得到该实体所对应的表名
	 * @return
	 */
	public abstract String getTableName();
	
	
	/**
	 * 得到该实体的主键名
	 * @return
	 */
	public abstract String getModelIDName();
	
}
