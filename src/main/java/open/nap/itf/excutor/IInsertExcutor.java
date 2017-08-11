package open.nap.itf.excutor;

import java.sql.SQLException;

import open.nap.itf.model.base.BaseModel;

/**
 * 插入执行器
 * @author zhanghao10
 *
 */
public interface IInsertExcutor {

	/**
	 * 对任意继承BaseModel的Model进行插入
	 * @param model
	 * @return
	 */
	public Object insert(BaseModel model);
	
}
