package open.nap.itf.excutor;

import java.sql.SQLException;

import open.nap.itf.model.base.BaseModel;

/**
 * ����ִ�����ӿ�
 * @author zhanghao10
 *
 */
public interface IInsertExcutor {

	/**
	 * �����κζ���Ĳ��룬��֧�ֽ��������������
	 * @param model
	 * @return
	 */
	public Object insert(BaseModel model);
	
}
