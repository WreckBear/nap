package nap.itf.excutor;

import java.sql.SQLException;

import nap.itf.model.base.BaseModel;

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
