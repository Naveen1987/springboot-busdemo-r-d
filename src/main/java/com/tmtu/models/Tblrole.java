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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="tblrole")
@Table(uniqueConstraints= {@UniqueConstraint(columnNames="roleName",name="rolename_unique")},indexes={@Index(name="roleId_tblrole", columnList="roleId"),@Index(name="roleName_tblrole", columnList="roleName")})
public class Tblrole implements Serializable {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long roleId;
    @Column(length=45)
    private String roleName;
    @Column(precision=19)
    private long createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastModifiedOn;
    @OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="tblrole",orphanRemoval=true)
    @JsonManagedReference
    private List<Tbllogin> tbllogin=new ArrayList<Tbllogin>();
    
    /*
     * 
     * */
    @OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="tblrole",orphanRemoval=true)
    @JsonManagedReference
	private List<Tblroletask> tblroletask=new ArrayList<Tblroletask>();
	
	public List<Tblroletask> getTblroletask() {
		return tblroletask;
	}

	public void setTblroletask(List<Tblroletask> tblroletask) {
		this.tblroletask = tblroletask;
	}
    
    /** Default constructor. */
    public Tblrole() {
        super();
    }

    /**
     * Access method for roleId.
     *
     * @return the current value of roleId
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * Setter method for roleId.
     *
     * @param aRoleId the new value for roleId
     */
    public void setRoleId(long aRoleId) {
        roleId = aRoleId;
    }

    /**
     * Access method for roleName.
     *
     * @return the current value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Setter method for roleName.
     *
     * @param aRoleName the new value for roleName
     */
    public void setRoleName(String aRoleName) {
        roleName = aRoleName;
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
     * Access method for tbllogin.
     *
     * @return the current value of tbllogin
     */  

    public List<Tbllogin> getTbllogin() {
		return tbllogin;
	}
    /**
     * Setter method for tbllogin.
     *
     * @param aTbllogin the new value for tbllogin
     */
    
	public void setTbllogin(List<Tbllogin> tbllogin) {
		this.tbllogin = tbllogin;
	}

	/**
     * Compares the key for this instance with another Tblrole.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblrole and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblrole)) {
            return false;
        }
        Tblrole that = (Tblrole) other;
        if (this.getRoleId() != that.getRoleId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblrole.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblrole)) return false;
        return this.equalKeys(other) && ((Tblrole)other).equalKeys(this);
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
        i = (int)(getRoleId() ^ (getRoleId()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
	public String toString() {
		return "Tblrole [roleId=" + roleId + ", roleName=" + roleName + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn
				+ ", tbllogin=" + tbllogin + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("roleId", new Long(getRoleId()));
        return ret;
    }
/*
 * 
 * For adding the dependency of foreign key
 * 
 * */
    public void addUser(Tbllogin user) {
        if (user != null) {
        	tbllogin.add(user);
        	user.setTblrolem(this);
        }
     }
    
    /*
     * 
     * For adding the dependency of foreign key
     * 
     * */
        public void addMenuTask(Tblroletask user) {
            if (user != null) {
            	tblroletask.add(user);
            	user.setTblrole(this);
            }
         }
}
