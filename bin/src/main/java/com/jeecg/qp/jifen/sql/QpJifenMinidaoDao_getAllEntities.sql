SELECT * FROM qp_jifen WHERE 1=1
<#if jeecgDemo.sqPoint ?exists && jeecgDemo.sqPoint ?length gt 0>
	and name = :jeecgDemo.sqPoint
</#if>
<#if authSql ?exists && authSql ?length gt 0>
	${authSql}
</#if>
