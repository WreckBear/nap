package open.nap.util.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import open.nap.itf.model.base.BaseModel;

public class SQLBuild {

	/**
	 * ����ƴ��sql
	 * @param model
	 * @param objects
	 * @return
	 */
	public static String buildInsertSQL(BaseModel model) {
		StringBuffer sql = new StringBuffer("insert into ");
		sql.append(model.getTableName());
		try {
			// ��ȡModel�������
			String modelClassName = model.getModelClassName();
			Class<?> modelClass = Class.forName(modelClassName);
			// ��ȡModel�������������
			Field[] declaredFields = modelClass.getDeclaredFields();
			// ������������
			StringBuffer attr = new StringBuffer(" ( ");
			StringBuffer attrVal = new StringBuffer(" values ( ");
			for (Field field : declaredFields) {
				attr.append(field.getName()+",");
				Method method = getMethodByField(modelClass,field);
				attrVal.append(method.invoke(model)+",");
			}
			// ȥ�����Ķ���
			attr.delete(attr.length()-1, attr.length());
			attrVal.delete(attrVal.length()-1, attrVal.length());
			// ����������
			attr.append(" )");
			attrVal.append(" )");
			// ƴ��sql
			sql.append(attr).append(attrVal);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	
	private static Method getMethodByField(Class clazz,Field field) throws NoSuchMethodException, SecurityException {
		String fieldName = field.getName();
		char firstChar = fieldName.charAt(0);
		String firstStr = new String(new char[]{firstChar});
		String methodName = fieldName.replaceFirst(firstStr, firstStr.toUpperCase());
		return clazz.getMethod("get"+methodName);
	}
	
}
