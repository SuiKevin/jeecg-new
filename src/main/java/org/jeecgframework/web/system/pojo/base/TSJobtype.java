package org.jeecgframework.web.system.pojo.base;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

 
@Entity
@Table(name = "t_s_jobtype" )
public class TSJobtype extends IdEntity  implements java.io.Serializable {
 
	private TSJobtype TSPJobtype;//父节点
	private String jobname;
	private String jobcode;
	private String orgType;
	private String orgCode;
	private Set<TSJobtype> TSJobtypes = new HashSet<TSJobtype>(0);

	// Constructors

	/** default constructor */
	public TSJobtype() {
	}

	  

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid")
	public TSJobtype getTSPJobtype() {
		return this.TSPJobtype;
	}

	public void setTSPJobtype(TSJobtype TSJobtype) {
		this.TSPJobtype = TSJobtype;
	}

	@Column(name = "jobname", length = 50)
	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	@Column(name = "jobcode", length = 50)
	public String getJobcode() {
		return this.jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	@Column(name = "org_type", length = 10)
	public String getOrgType() {
		return this.orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	@Column(name = "org_code", length = 200)
	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSPJobtype")
	public Set<TSJobtype> getTSJobtypes() {
		return this.TSJobtypes;
	}

	public void setTSJobtypes(Set<TSJobtype> TSJobtypes) {
		this.TSJobtypes = TSJobtypes;
	}

}