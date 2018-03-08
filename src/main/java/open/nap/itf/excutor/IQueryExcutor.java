package open.nap.itf.excutor;

import org.omg.CORBA.Object;

import open.nap.itf.model.base.BaseModel;

public interface IQueryExcutor {
	public Object Querybypk(BaseModel model);
}
