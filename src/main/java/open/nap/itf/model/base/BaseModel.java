package open.nap.itf.model.base;

public interface BaseModel {

	/**
	 * 得到该实体所对应的表名
	 * @return
	 */
	public String getTableName();
	
	
	/**
	 * 得到该实体的全类名
	 * @return
	 */
	public String getModelClassName();
	
	/**
	 * 得到该实体的主键名
	 * @return
	 */
	public String getModelIDName();
	
}
