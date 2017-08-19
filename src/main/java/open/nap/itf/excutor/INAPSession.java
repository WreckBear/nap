package open.nap.itf.excutor;

import open.nap.itf.model.base.BaseModel;

public interface INAPSession {
	
	/**
	 * 插入一条记录
	 * @param model
	 * @return
	 */
	public Object insert(BaseModel model);
	
	/**
	 * 根据主键删除一条记录
	 * @param model
	 * @return
	 */
	public Object delete(BaseModel model);
	
	/**
	 * 根据主键更新一条记录
	 * @param model
	 * @return
	 */
	public Object update(BaseModel model);
	
	/**
	 * 根据主键获取一条记录
	 * @param model
	 * @return
	 */
	public Object queryByPK(BaseModel model);
}
