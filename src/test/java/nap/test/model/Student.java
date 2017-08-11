package nap.test.model;

import open.nap.itf.model.base.BaseModel;

public class Student implements BaseModel {

	private String id;
	private String name;
	private String StuID;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuID() {
		return StuID;
	}

	public void setStuID(String stuID) {
		StuID = stuID;
	}

	@Override
	public String getTableName() {
		return "student";
	}

	@Override
	public String getModelClassName() {
		return "nap.test.model.Student";
	}

	@Override
	public String getModelIDName() {
		return "id";
	}
	
}
