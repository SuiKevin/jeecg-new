package com.jeecg.qp.jifen.dao;

import java.util.List;
import java.util.Map;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage; 
import com.jeecg.qp.jifen.entity.QpJifenEntity;

/**
 * Minidao例子
 * 
 */
@MiniDao
public interface QpJifenMinidaoDao {
	
	@Arguments("pid")
 	@Sql("select ID,NAME,PID from t_s_region where pid=:pid order by name_en")
    List<Map<String, String>> getProCity(String pid);
	
 	@Sql("select ID,NAME,PID from t_s_region order by name_en")
    List<Map<String, String>> getAllRegions();

 	@ResultType(QpJifenEntity.class)
	public MiniDaoPage<QpJifenEntity> getAllEntities(@Param("jeecgDemo") QpJifenEntity jeecgDemo, @Param("page")  int page, @Param("rows") int rows,@Param("authSql") String authSql);

	@Sql("SELECT count(*) FROM jeecg_demo")
	Integer getCount();

	@Sql("SELECT SUM(salary) FROM jeecg_demo")
	Integer getSumSalary();
	
	@Arguments("id")
	@ResultType(QpJifenEntity.class)
	@Sql("SELECT * FROM qp_jifen where id=:id")
	public QpJifenEntity getEntitie(String id);
	
	@Sql("update qp_jifen set sq_point=sq_point+:jifen where id = :id")
	public void addpoint(@Param("jifen") Integer jifen,@Param("id") String id);
	
	@Sql("update qp_jifen set sq_point=sq_point-:jifen where id = :id")
	public void delpoint(@Param("jifen") Integer jifen,@Param("id") String id);
	
	/*@Arguments({"jeecgMinidao", "page", "rows"})
	public List<Map> getAllEntities(JeecgMinidaoEntity jeecgMinidao, int page, int rows);

	@Arguments({"jeecgMinidao", "page", "rows"})
	@ResultType(JeecgMinidaoEntity.class)
	public List<JeecgMinidaoEntity> getAllEntities2(JeecgMinidaoEntity jeecgMinidao, int page, int rows);*/

	//@Arguments("id")
	//JeecgMinidaoEntity getJeecgMinidao(String id);

	/*@Arguments("jeecgMinidao")
	int update(JeecgMinidaoEntity jeecgMinidao);

	@Arguments("jeecgMinidao")
	void insert(JeecgMinidaoEntity jeecgMinidao);

	@Arguments("jeecgMinidao")
	void delete(JeecgMinidaoEntity jeecgMinidao);*/
	@Sql("insert into qp_jifen(id) values(:id)")
	public void insertjifen(@Param("id") String id);
	
	@Arguments("log")
	@ResultType(QpJifenEntity.class)
	List<QpJifenEntity> getLogReportData(QpJifenEntity log);
	
	@Arguments("log")
	List<Map<String, Object>> getLogChartData(QpJifenEntity log);
}
