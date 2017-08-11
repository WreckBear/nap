package nap.test.main;

import nap.ds.DataSourceUtil;
import nap.factory.excutor.NapFactory;
import nap.itf.excutor.IInsertExcutor;
import nap.test.model.Student;
import nap.test.model.Teacher;

public class Main {

	public static void main(String[] args) {
		// 构建插入器
		IInsertExcutor insert = NapFactory.getInsertExcutor(DataSourceUtil.getDataSource());
		
		// 模拟插入对象
		Teacher teacher = mockATeacher();
		Student student = mockAStudent();
		
		// 进行插入
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
