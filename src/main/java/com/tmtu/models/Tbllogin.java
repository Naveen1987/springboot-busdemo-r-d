package com.tmtu.models;

import java.io.Serializable;
import java.util.Calendar;
//import java.sql.Timestamp;
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
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonBackReference;


//import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name="tbllogin", uniqueConstraints= {@UniqueConstraint(columnNames= "userName",name="userName_UNIQUE")},indexes={@Index(name="tbllogin_userName_IX", columnList="userName")})
public class Tbllogin implements Serializable {
    /**
	 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long tblloginId;
    @Column(nullable=false, length=45)
    private String userName;
    @Column(length=45)
    private String password;
    @Column(precision=19)
    private long createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastModifiedOn;
    @Column(length=45)
    private String email;
    @Column(length=200)
    private String displayName;
    @Column(precision=19)
    private long flag;
    @Column(length=2)
    private String isActive;
    @ManyToOne
    @JoinColumn(name="roleId",foreignKey=@ForeignKey(name="tbllogin_ibfk_1"))
    @JsonBackReference
    private Tblrole tblrole;

    /** Default constructor. */
    public Tbllogin() {
        super();
    }

    /**
     * Access method for Tbllogin.
     *
     * @return the current value of loginId
     */
    public long getTblloginId() {
		return tblloginId;
	}

    /**
     * Setter method for Tbllogin.
     *
     * @param aLoginId the new value for loginId
     */  

    public void setTblloginId(long tblloginId) {
		this.tblloginId = tblloginId;
	}

	/**
     * Access method for userName.
     *
     * @return the current value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for userName.
     *
     * @param aUserName the new value for userName
     */
    public void setUserName(String aUserName) {
        userName = aUserName;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
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
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for displayName.
     *
     * @return the current value of displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Setter method for displayName.
     *
     * @param aDisplayName the new value for displayName
     */
    public void setDisplayName(String aDisplayName) {
        displayName = aDisplayName;
    }

    /**
     * Access method for flag.
     *
     * @return the current value of flag
     */
    public long getFlag() {
        return flag;
    }

    /**
     * Setter method for flag.
     *
     * @param aFlag the new value for flag
     */
    public void setFlag(long aFlag) {
        flag = aFlag;
    }

    /**
     * Access method for isActive.
     *
     * @return the current value of isActive
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Setter method for isActive.
     *
     * @param aIsActive the new value for isActive
     */
    public void setIsActive(String aIsActive) {
        isActive = aIsActive;
    }

   
    /**
     * Access method for tblrole.
     *
     * @return the current value of tblrole
     */
    public Tblrole getTblrolem() {
        return tblrole;
    }

    /**
     * Setter method for tblrole.
     *
     * @param aTblrole the new value for tblrole
     */
    public void setTblrolem(Tblrole aTblrole) {
        tblrole = aTblrole;
    }

    /**
     * Compares the key for this instance with another Tbllogin.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbllogin and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbllogin)) {
            return false;
        }
        Tbllogin that = (Tbllogin) other;
        if (this.getTblloginId() != that.getTblloginId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbllogin.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbllogin)) return false;
        return this.equalKeys(other) && ((Tbllogin)other).equalKeys(this);
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
        i = (int)(getTblloginId() ^ (getTblloginId()>>>32));
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
		
		return "Tbllogin [loginId=" + tblloginId + ", userName=" + userName + ", password=" + password + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + ", email=" + email + ", displayName=" + displayName + ", flag=" + flag
				+ ", isActive=" + isActive + ", tblrole=" + tblrole.getTbllogin() + "]";
	}
	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("loginId", new Long(getTblloginId()));
        return ret;
    }

}
