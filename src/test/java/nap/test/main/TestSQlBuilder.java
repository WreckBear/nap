package nap.test.main;

import nap.test.model.Student;
import nap.test.model.Teacher;
import open.nap.util.builder.MYSQL5Builder;

public class TestSQlBuilder {

	public static void main(String[] args) {
		Student student = mockAStudent();
		String sql = MYSQL5Builder.buildInsertSQL(student);
		System.out.println(sql);
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
