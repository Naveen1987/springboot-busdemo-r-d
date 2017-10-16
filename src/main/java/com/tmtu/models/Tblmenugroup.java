
package com.tmtu.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity(name="tblmenugroup")
@Table(indexes={@Index(name="menugroupId_tblmenugroup", columnList="menugroupId")})
public class Tblmenugroup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long menugroupId;
    @Column(length=45,name="groupName")
    private String groupName;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="tblmenugroup")
    @JsonManagedReference
    private List<Tblmenutask> tblmenutask  =new ArrayList<Tblmenutask>();    
    
    public List<Tblmenutask> getTblmenutask() {
		return tblmenutask;
	}

	public void setTblmenutask(List<Tblmenutask> tblmenutask) {
		this.tblmenutask = tblmenutask;
	}

	/** Default constructor. */
    public Tblmenugroup() {
        super();
    }

    /**
     * Access method for menugroupId.
     *
     * @return the current value of menugroupId
     */
    public long getMenugroupId() {
        return menugroupId;
    }

    /**
     * Setter method for menugroupId.
     *
     * @param aMenugroupId the new value for menugroupId
     */
    public void setMenugroupId(long aMenugroupId) {
        menugroupId = aMenugroupId;
    }

    /**
     * Access method for groupName.
     *
     * @return the current value of groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Setter method for groupName.
     *
     * @param aGroupName the new value for groupName
     */
    public void setGroupName(String aGroupName) {
        groupName = aGroupName;
    }

    /**
     * Compares the key for this instance with another Tblmenugroup.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblmenugroup and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblmenugroup)) {
            return false;
        }
        Tblmenugroup that = (Tblmenugroup) other;
        if (this.getMenugroupId() != that.getMenugroupId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblmenugroup.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblmenugroup)) return false;
        return this.equalKeys(other) && ((Tblmenugroup)other).equalKeys(this);
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
        i = (int)(getMenugroupId() ^ (getMenugroupId()>>>32));
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
		return "Tblmenugroup [menugroupId=" + menugroupId + ", groupName=" + groupName + "]";
	}

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("menugroupId", new Long(getMenugroupId()));
        return ret;
    }

	public void addMenu(Tblmenutask menu) {
		if(menu!=null) {
			tblmenutask.add(menu);
			menu.setTblmenugroup(this);
		}
	}

}
