package com.tmtu.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name="tblroletask")
@Table(indexes={@Index(name="roletaskId_tblroletask", columnList="roletaskId")})
public class Tblroletask implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long roletaskId;
    /*@Column(precision=19)
    private long roleId;
    @Column(precision=19)
    private long taskId;
    @Column(precision=19)*/
    private long createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastModifiedOn;
    /** Default constructor. */
    public Tblroletask() {
        super();
    }

    @ManyToOne
    @JoinColumn(name="menutaskId",foreignKey=@ForeignKey(name="tblmenutask_ibfk_1"))
    @JsonBackReference
    private Tblmenutask  tblmenutask;
    
    public Tblmenutask getTblmenutask() {
		return tblmenutask;
	}

	public void setTblmenutask(Tblmenutask tblmenutask) {
		this.tblmenutask = tblmenutask;
	}

	@ManyToOne
	@JoinColumn(name="roleId",foreignKey=@ForeignKey(name="tblmenutask_ibfk_2"))
	@JsonBackReference
	private Tblrole tblrole;

	
	public Tblrole getTblrole() {
		return tblrole;
	}

	public void setTblrole(Tblrole tblrole) {
		this.tblrole = tblrole;
	}

	/**
     * Access method for roletaskId.
     *
     * @return the current value of roletaskId
     */
    public long getRoletaskId() {
        return roletaskId;
    }

    /**
     * Setter method for roletaskId.
     *
     * @param aRoletaskId the new value for roletaskId
     */
    public void setRoletaskId(long aRoletaskId) {
        roletaskId = aRoletaskId;
    }

    /**
     * Access method for roleId.
     *
     * @return the current value of roleId
     */
    /*public long getRoleId() {
        return roleId;
    }

    *//**
     * Setter method for roleId.
     *
     * @param aRoleId the new value for roleId
     *//*
    public void setRoleId(long aRoleId) {
        roleId = aRoleId;
    }

    *//**
     * Access method for taskId.
     *
     * @return the current value of taskId
     *//*
    public long getTaskId() {
        return taskId;
    }

    *//**
     * Setter method for taskId.
     *
     * @param aTaskId the new value for taskId
     *//*
    public void setTaskId(long aTaskId) {
        taskId = aTaskId;
    }*/

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
     * Compares the key for this instance with another Tblroletask.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblroletask and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblroletask)) {
            return false;
        }
        Tblroletask that = (Tblroletask) other;
        if (this.getRoletaskId() != that.getRoletaskId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblroletask.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblroletask)) return false;
        return this.equalKeys(other) && ((Tblroletask)other).equalKeys(this);
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
        i = (int)(getRoletaskId() ^ (getRoletaskId()>>>32));
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
		return "Tblroletask [roletaskId=" + roletaskId + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + "]";
	}
   /* @Override
	public String toString() {
		return "Tblroletask [roletaskId=" + roletaskId + ", roleId=" + roleId + ", taskId=" + taskId + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + "]";
	}*/

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("roletaskId", new Long(getRoletaskId()));
        return ret;
    }

}
