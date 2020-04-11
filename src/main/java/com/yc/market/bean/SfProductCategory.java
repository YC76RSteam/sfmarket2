package com.yc.market.bean;

import java.util.List;

public class SfProductCategory implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pcid;

    private String name;

    private Integer parentid;

    private Integer type;

    private String iconclass;

    private List<SfProductCategory> children;
    
    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass == null ? null : iconclass.trim();
    }

	public List<SfProductCategory> getChildren() {
		return children;
	}

	public void setChildren(List<SfProductCategory> children) {
		this.children = children;
	}
}