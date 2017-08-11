package nap.test.main;

import javax.sql.DataSource;

import nap.ds.DataSourceUtil;
import nap.factory.excutor.NapFactory;
import nap.impl.excutor.Insert;
import nap.itf.excutor.IInsertExcutor;
import nap.test.model.Teacher;

public class Main {

	public static void main(String[] args) {
		// ����������
		IInsertExcutor insert = NapFactory.getInsertExcutor(DataSourceUtil.getDataSource());
		
		// ģ��������
		Teacher teacher = mockATeacher();
		
		// ���в���
		insert.insert(teacher);
	}

	private static Teacher mockATeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("����ʦ");
		teacher.setAge(34);
		return teacher;
	}
	
}
