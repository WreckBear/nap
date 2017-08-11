package nap.test.main;

import nap.test.model.Student;
import nap.test.model.Teacher;
import open.nap.factory.NapFactory;
import open.nap.itf.excutor.IInsertExcutor;
import open.nap.util.common.DataSourceUtil;

public class Main {

	public static void main(String[] args) {
		// 获取插入执行器
		IInsertExcutor insert = NapFactory.getInsertExcutor(DataSourceUtil.getDataSource());
		
		// 生成模拟对象
		Teacher teacher = mockATeacher();
		Student student = mockAStudent();
		
		// 插入数据
		insert.insert(teacher);
		insert.insert(student);
	}

	
	private static Student mockAStudent() {
		Student student = new Student();
		student.setName("张三");
		student.setStuID("XH001");
		return student;
	}

	private static Teacher mockATeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("张老师");
		teacher.setAge(34);
		return teacher;
	}
	
}
