package nap.test.main;

import nap.test.model.Student;
import nap.test.model.Teacher;
import open.nap.util.common.SQLBuild;

public class TestSQlBuilder {

	public static void main(String[] args) {
		Student student = mockAStudent();
		String sql = SQLBuild.buildInsertSQL(student);
		System.out.println(sql);
	}
	
	private static Student mockAStudent() {
		Student student = new Student();
		student.setName("����");
		student.setStuID("XH001");
		return student;
	}

	private static Teacher mockATeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("����ʦ");
		teacher.setAge(34);
		return teacher;
	}
}
