# nap

超级傻瓜式ORM小型框架，基于DBUtils，目标是为小型项目提供简单的数据访问层

## 快速入门--构建Model
	第一步，是构建自己的Model，所有的Model需继承BaseModel接口,并实现其中的抽象方法
	第二步，配置数据源，如果有的话；框架内置mysql及c3p0数据源，不满足要求者可自行配置
	第三步，调用nap的API实现增删改查
>	INAPSession session = NapFactory.getSession();<br/>
	session.insert(obj);<br/>
	session.delete(obj);<br/>
	session.update(obj);<br/>
	session.queryByPK(obj);<br/>
	
· 对象所对应的表不存在，第一次插入的时候会自动构建表结构，并插入数据。·

## 此框架应该支持以下几个特性：

1.对象的类型名和表明可实现不一致

2.支持主键生成策略的配置

3.初次导入数据自动创建表

4.已存在表可以反向生成Model

5.可实现字段名和表的字段不一致