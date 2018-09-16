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
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 部门机构表
 * @author  张代浩
 */
@Entity
@Table(name = "t_s_depart")
public class TSDepart extends IdEntity implements java.io.Serializable {
	private TSDepart TSPDepart;//上级部门
	@Excel(name = "部门名称" ,width = 20)
	private String departname;//部门名称
	@Excel(name = "部门描述",width = 20)
	private String description;//部门描述
	@Excel(name = "机构编码",width = 20)
    private String orgCode;//机构编码
	@Excel(name = "机构类型编码",width = 25)
    private String orgType;//机构编码
	@Excel(name = "电话",width = 20)
	private String mobile;//电话
	@Excel(name = "传真",width = 20)
	private String fax;//传真
	@Excel(name = "地址",width = 20)
	private String address;//地址
 
	private String areaCode ;//58同城对应的区域编码
  
	
	private String province ;//省份编码
	private String city ;//城市编码
	private String town ;//区域编码
	
	private String provinceid ;//省份编码
	private String cityid ;//城市编码
	private String townid ;//区域编码
	
	 
	@Column(name = "province" )
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name = "city" )
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "town" )
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	@Column(name = "provinceid" )
	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	@Column(name = "cityid" )
	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	@Column(name = "townid" )
	public String getTownid() {
		return townid;
	}

	public void setTownid(String townid) {
		this.townid = townid;
	}

	@Column(name = "area_code" )
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	  

	private String departOrder;//排序
	
	private List<TSDepart> TSDeparts = new ArrayList<TSDepart>();//下属部门
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentdepartid")
	public TSDepart getTSPDepart() {
		return this.TSPDepart;
	}

	public void setTSPDepart(TSDepart TSPDepart) {
		this.TSPDepart = TSPDepart;
	}

	@Column(name = "departname", nullable = false, length = 100)
	public String getDepartname() {
		return this.departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSPDepart")
	public List<TSDepart> getTSDeparts() {
		return TSDeparts;
	}

	public void setTSDeparts(List<TSDepart> tSDeparts) {
		TSDeparts = tSDeparts;
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

	@Column(name = "mobile", length = 32)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "fax", length = 32)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="depart_order")
	public String getDepartOrder() {
		return departOrder;
	}

	public void setDepartOrder(String departOrder) {
		this.departOrder = departOrder;
	}
	
	
	
}