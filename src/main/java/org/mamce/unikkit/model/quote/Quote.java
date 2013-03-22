package org.mamce.unikkit.model.quote;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author Ramesh
 *
 */
public class Quote extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String who;
	private String what;
	private String avatar;
	private boolean featured;
	/**
	 * @return the who
	 */
	public String getWho() {
		return who;
	}
	/**
	 * @param who the who to set
	 */
	public void setWho(String who) {
		this.who = who;
	}
	/**
	 * @return the what
	 */
	public String getWhat() {
		return what;
	}
	/**
	 * @param what the what to set
	 */
	public void setWhat(String what) {
		this.what = what;
	}
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @return the featured
	 */
	public boolean isFeatured() {
		return featured;
	}
	/**
	 * @param featured the featured to set
	 */
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	
}
