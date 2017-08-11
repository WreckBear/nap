package nap.test.model;

import open.nap.itf.model.base.BaseModel;

public class Teacher implements BaseModel {

	private String id;
	private String name;
	private Integer age;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String getTableName() {
		return "teacher";
	}

	@Override
	public String getModelClassName() {
		return "nap.test.model.Teacher";
	}

	@Override
	public String getModelIDName() {
		return "id";
	}

}
