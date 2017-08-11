package nap.util.common;

import nap.itf.model.base.BaseModel;

public class SQLBuild {

	/**
	 * ¸ù¾ÝÆ´½Ósql
	 * @param model
	 * @param objects
	 * @return
	 */
	public static String buildInsertSQL(BaseModel model) {
		try {
			String modelClassName = model.getModelClassName();
			Class<?> forName = Class.forName(modelClassName);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
}
