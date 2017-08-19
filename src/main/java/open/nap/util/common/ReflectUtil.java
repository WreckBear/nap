package open.nap.util.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {

	/**
	 * 得到某类对象中的所有属性值
	 * @param modelClass
	 * @return
	 */
	public static Field[] getAllField(Class<?> clazz) {
		return clazz.getDeclaredFields();
	}
	
	/**
	 * 根据Field获取到类对象对应的get方法
	 * @param clazz
	 * @param field
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Method getMethodByField(Class clazz,Field field) throws NoSuchMethodException, SecurityException {
		String fieldName = field.getName();
		char firstChar = fieldName.charAt(0);
		String firstStr = new String(new char[]{firstChar});
		String methodName = fieldName.replaceFirst(firstStr, firstStr.toUpperCase());
		return clazz.getMethod("get"+methodName);
	}
}
