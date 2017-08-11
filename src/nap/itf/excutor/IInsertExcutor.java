package nap.itf.excutor;

import java.sql.SQLException;

import nap.itf.model.base.BaseModel;

/**
 * 插入执行器接口
 * @author zhanghao10
 *
 */
public interface IInsertExcutor {

	/**
	 * 对于任何对象的插入，都支持仅传对象参数即可
	 * @param model
	 * @return
	 */
	public Object insert(BaseModel model);
	
}
