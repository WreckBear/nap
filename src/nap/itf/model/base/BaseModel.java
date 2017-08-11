package nap.itf.model.base;

public interface BaseModel {

	/**
	 * 获取到与该Model对应的表名
	 * @return
	 */
	public String getTableName();
	
	
	/**
	 * 获取到该Model的全类名
	 * @return
	 */
	public String getModelClassName();
	
	/**
	 * 获取到该Model的主键名
	 * @return
	 */
	public String getModelIDName();
	
}
