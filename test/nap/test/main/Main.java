package nap.test.main;

import javax.sql.DataSource;

import nap.ds.DataSourceUtil;
import nap.factory.excutor.NapFactory;
import nap.impl.excutor.Insert;
import nap.itf.excutor.IInsertExcutor;
import nap.test.model.Teacher;

public class Main {

	public static void main(String[] args) {
		// 构建插入器
		IInsertExcutor insert = NapFactory.getInsertExcutor(DataSourceUtil.getDataSource());
		
		// 模拟插入对象
		Teacher teacher = mockATeacher();
		
		// 进行插入
		insert.insert(teacher);
	}

	private static Teacher mockATeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("张老师");
		teacher.setAge(34);
		return teacher;
	}
	
}
