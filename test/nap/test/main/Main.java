package nap.test.main;

import nap.ds.DataSourceUtil;
import nap.factory.excutor.NapFactory;
import nap.itf.excutor.IInsertExcutor;
import nap.test.model.Student;
import nap.test.model.Teacher;

public class Main {

	public static void main(String[] args) {
		// ����������
		IInsertExcutor insert = NapFactory.getInsertExcutor(DataSourceUtil.getDataSource());
		
		// ģ��������
		Teacher teacher = mockATeacher();
		Student student = mockAStudent();
		
		// ���в���
		insert.insert(teacher);
		insert.insert(student);
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
