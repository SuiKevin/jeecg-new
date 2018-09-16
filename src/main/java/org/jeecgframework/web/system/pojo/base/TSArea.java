package org.jeecgframework.web.system.pojo.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

@Entity
@Table(name = "t_s_area")
public class TSArea extends IdEntity implements java.io.Serializable {

	private static final long serialVersionUID = 2971806322315146917L;

	private TSArea TSPArea;// 上级区域

	private List<TSArea> TSAreas = new ArrayList<TSArea>();// 下属部门

	@Excel(name = "名称", width = 20)
	private String areaname;// 部门名称
	@Excel(name = "区号", width = 20)
	private String areacode;// 部门名称
	private String orgCode;// 机构编码
	private String orgType;// 机构编码

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid")
	public TSArea getTSPArea() {
		return this.TSPArea;
	}

	public void setTSPArea(TSArea TSArea) {
		this.TSPArea = TSArea;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSPArea")
	public List<TSArea> getTSAreas() {
		return TSAreas;
	}

	public void setTSAreas(List<TSArea> tSAreas) {
		TSAreas = tSAreas;
	}

	@Column(name = "areaname", nullable = false, length = 100)
	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	@Column(name = "areacode", nullable = false, length = 100)
	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	@Column(name = "org_code", length = 64)
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "org_type", length = 1)
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}