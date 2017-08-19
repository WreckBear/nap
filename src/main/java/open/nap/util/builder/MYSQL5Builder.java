package open.nap.util.builder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import open.nap.itf.model.base.BaseModel;
import open.nap.util.common.ReflectUtil;

/**
 * 针对MYSQL5 的SQL拼接工具
 * @author zhanghao10
 */
public class MYSQL5Builder extends CommonBuilder{

	/** 初始化映射表  **/
	static {
		typeMap = new HashMap<>();
		typeMap.put(String.class, "varchar(255)");
		typeMap.put(Integer.class, "int");
	}
	
	
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
			Class modelClass = model.getClass();
			// 获取到实体的全部属性
			Field[] declaredFields = ReflectUtil.getAllField(modelClass);
			// 创建属性和属性值两个拼接串
			StringBuffer attr = new StringBuffer(" ( ");
			StringBuffer attrVal = new StringBuffer(" values ( ");
			// 遍历所有属性，拼接sql的属性和值的部分
			for (Field field : declaredFields) {
				attr.append(field.getName()+",");
				Method method = ReflectUtil.getMethodByField(modelClass,field);
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
	 * 构建创建表的SQL语句
	 * @param tableName
	 * @param fields
	 */
	public static String buildCreateTableSQL(String tableName, Field[] fields) {
		StringBuffer sql = new StringBuffer("CREATE TABLE ");
		sql.append(tableName);
		sql.append(" (");
		for (Field field : fields) {
			sql.append(field.getName());
			sql.append(" ");
			sql.append(typeMap.get(field.getType()));
			sql.append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(" )");
		return sql.toString();
	}
	
}
