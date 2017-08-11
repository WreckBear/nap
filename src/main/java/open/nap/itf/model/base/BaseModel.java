package open.nap.itf.model.base;

public interface BaseModel {

	/**
	 * ��ȡ�����Model��Ӧ�ı���
	 * @return
	 */
	public String getTableName();
	
	
	/**
	 * ��ȡ����Model��ȫ����
	 * @return
	 */
	public String getModelClassName();
	
	/**
	 * ��ȡ����Model��������
	 * @return
	 */
	public String getModelIDName();
	
}
