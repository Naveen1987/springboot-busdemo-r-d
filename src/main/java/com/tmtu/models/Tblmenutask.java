package com.tmtu.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="tblmenutask")
@Table(indexes={@Index(name="menuName_tblmenutask", columnList="menuName"),@Index(name="menutaskId_tblmenutask", columnList="menutaskId")})
public class Tblmenutask implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long menutaskId;
    @Column(length=45)
    private String menuName;
    @Column(precision=19)
    private long createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastModifiedOn;
    /*@Column(precision=19)
    private long groupId;*/
    @Column(length=100)
    private String redirectPage;

    @ManyToOne
    @JoinColumn(name="menugroupId",foreignKey=@ForeignKey(name="tblmenugroup_ibfk_1"))
    @JsonBackReference
    private Tblmenugroup tblmenugroup;
    
    public Tblmenugroup getTblmenugroup() {
		return tblmenugroup;
	}

	public void setTblmenugroup(Tblmenugroup tblmenugroup) {
		this.tblmenugroup = tblmenugroup;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="tblmenutask",orphanRemoval=true)
    @JsonManagedReference
	private List<Tblroletask> tblroletask=new ArrayList<Tblroletask>();
	
	public List<Tblroletask> getTblroletask() {
		return tblroletask;
	}

	public void setTblroletask(List<Tblroletask> tblroletask) {
		this.tblroletask = tblroletask;
	}

	/** Default constructor. */
    public Tblmenutask() {
        super();
    }

    /**
     * Access method for menutaskId.
     *
     * @return the current value of menutaskId
     */
    public long getMenutaskId() {
        return menutaskId;
    }

    /**
     * Setter method for menutaskId.
     *
     * @param aMenutaskId the new value for menutaskId
     */
    public void setMenutaskId(long aMenutaskId) {
        menutaskId = aMenutaskId;
    }

    /**
     * Access method for menuName.
     *
     * @return the current value of menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Setter method for menuName.
     *
     * @param aMenuName the new value for menuName
     */
    public void setMenuName(String aMenuName) {
        menuName = aMenuName;
    }

    /**
     * Access method for createdBy.
     *
     * @return the current value of createdBy
     */
    public long getCreatedBy() {
        return createdBy;
    }

    /**
     * Setter method for createdBy.
     *
     * @param aCreatedBy the new value for createdBy
     */
    public void setCreatedBy(long aCreatedBy) {
        createdBy = aCreatedBy;
    }

    /**
     * Access method for createdOn.
     *
     * @return the current value of createdOn
     */
    public Calendar getCreatedOn() {
        return createdOn;
    }

    /**
     * Setter method for createdOn.
     *
     * @param aCreatedOn the new value for createdOn
     */
    public void setCreatedOn(Calendar aCreatedOn) {
        createdOn = aCreatedOn;
    }

    /**
     * Access method for lastModifiedBy.
     *
     * @return the current value of lastModifiedBy
     */
    public long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Setter method for lastModifiedBy.
     *
     * @param aLastModifiedBy the new value for lastModifiedBy
     */
    public void setLastModifiedBy(long aLastModifiedBy) {
        lastModifiedBy = aLastModifiedBy;
    }

    /**
     * Access method for lastModifiedOn.
     *
     * @return the current value of lastModifiedOn
     */
    public Calendar getLastModifiedOn() {
        return lastModifiedOn;
    }

    /**
     * Setter method for lastModifiedOn.
     *
     * @param aLastModifiedOn the new value for lastModifiedOn
     */
    public void setLastModifiedOn(Calendar aLastModifiedOn) {
        lastModifiedOn = aLastModifiedOn;
    }

    /**
     * Access method for groupId.
     *
     * @return the current value of groupId
     */
   /* public long getGroupId() {
        return groupId;
    }*/

    /**
     * Setter method for groupId.
     *
     * @param aGroupId the new value for groupId
     */
  /*  public void setGroupId(long aGroupId) {
        groupId = aGroupId;
    }*/

    /**
     * Access method for redirectPage.
     *
     * @return the current value of redirectPage
     */
    public String getRedirectPage() {
        return redirectPage;
    }

    /**
     * Setter method for redirectPage.
     *
     * @param aRedirectPage the new value for redirectPage
     */
    public void setRedirectPage(String aRedirectPage) {
        redirectPage = aRedirectPage;
    }

    /**
     * Compares the key for this instance with another Tblmenutask.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblmenutask and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblmenutask)) {
            return false;
        }
        Tblmenutask that = (Tblmenutask) other;
        if (this.getMenutaskId() != that.getMenutaskId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblmenutask.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblmenutask)) return false;
        return this.equalKeys(other) && ((Tblmenutask)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getMenutaskId() ^ (getMenutaskId()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
  

/*    @Override
	public String toString() {
		return "Tblmenutask [menutaskId=" + menutaskId + ", menuName=" + menuName + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + ", groupId=" + groupId + ", redirectPage=" + redirectPage + "]";
	}*/

    @Override
	public String toString() {
		return "Tblmenutask [menutaskId=" + menutaskId + ", menuName=" + menuName + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + ", redirectPage=" + redirectPage + "]";
	}
	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("menutaskId", new Long(getMenutaskId()));
        return ret;
    }
    
    public void addMenutask(Tblroletask task) {
		if(task!=null) {
		tblroletask.add(task);
		task.setTblmenutask(this);
		}
	}
}
