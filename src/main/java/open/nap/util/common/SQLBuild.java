package open.nap.util.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import open.nap.itf.model.base.BaseModel;

public class SQLBuild {

	/**
	 * 自动构建插入的sql
	 * @param model
	 * @param objects
	 * @return
	 */
	public static String buildInsertSQL(BaseModel model) {
		StringBuffer sql = new StringBuffer("insert into ");
		sql.append(model.getTableName());
		try {
			// 获取到实体的类对象
			Class modelClass = getModelClassByModel(model);
			// 获取到实体的全部属性
			Field[] declaredFields = getAllField(modelClass);
			// 创建属性和属性值两个拼接串
			StringBuffer attr = new StringBuffer(" ( ");
			StringBuffer attrVal = new StringBuffer(" values ( ");
			// 遍历所有属性，拼接sql的属性和值的部分
			for (Field field : declaredFields) {
				attr.append(field.getName()+",");
				Method method = getMethodByField(modelClass,field);
				attrVal.append(method.invoke(model)+",");
			}
			// 删除末尾的逗号
			attr.delete(attr.length()-1, attr.length());
			attrVal.delete(attrVal.length()-1, attrVal.length());
			// 末尾加上右括号
			attr.append(" )");
			attrVal.append(" )");
			// 拼接sql
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

	/**
	 * 根据模型获取到模型对应的类对象
	 * @param modelClassName
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static Class getModelClassByModel(BaseModel model) throws ClassNotFoundException {
		String modelClassName = model.getModelClassName();
		return Class.forName(modelClassName);
	}


	/**
	 * 得到某类对象中的所有属性值
	 * @param modelClass
	 * @return
	 */
	private static Field[] getAllField(Class<?> modelClass) {
		return modelClass.getDeclaredFields();
	}


	/**
	 * 根据Field获取到类对象对应的get方法
	 * @param clazz
	 * @param field
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private static Method getMethodByField(Class clazz,Field field) throws NoSuchMethodException, SecurityException {
		String fieldName = field.getName();
		char firstChar = fieldName.charAt(0);
		String firstStr = new String(new char[]{firstChar});
		String methodName = fieldName.replaceFirst(firstStr, firstStr.toUpperCase());
		return clazz.getMethod("get"+methodName);
	}
	
}
