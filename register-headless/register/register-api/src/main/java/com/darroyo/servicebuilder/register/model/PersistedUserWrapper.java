/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.darroyo.servicebuilder.register.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PersistedUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUser
 * @generated
 */
public class PersistedUserWrapper
	extends BaseModelWrapper<PersistedUser>
	implements ModelWrapper<PersistedUser>, PersistedUser {

	public PersistedUserWrapper(PersistedUser persistedUser) {
		super(persistedUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("surname", getSurname());
		attributes.put("email", getEmail());
		attributes.put("birthDate", getBirthDate());
		attributes.put("registeredOn", getRegisteredOn());
		attributes.put("recaptcha", getRecaptcha());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		Date registeredOn = (Date)attributes.get("registeredOn");

		if (registeredOn != null) {
			setRegisteredOn(registeredOn);
		}

		String recaptcha = (String)attributes.get("recaptcha");

		if (recaptcha != null) {
			setRecaptcha(recaptcha);
		}
	}

	@Override
	public PersistedUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the birth date of this persisted user.
	 *
	 * @return the birth date of this persisted user
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the company ID of this persisted user.
	 *
	 * @return the company ID of this persisted user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted user.
	 *
	 * @return the create date of this persisted user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this persisted user.
	 *
	 * @return the email of this persisted user
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this persisted user.
	 *
	 * @return the group ID of this persisted user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this persisted user.
	 *
	 * @return the modified date of this persisted user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this persisted user.
	 *
	 * @return the name of this persisted user
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this persisted user.
	 *
	 * @return the primary key of this persisted user
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recaptcha of this persisted user.
	 *
	 * @return the recaptcha of this persisted user
	 */
	@Override
	public String getRecaptcha() {
		return model.getRecaptcha();
	}

	/**
	 * Returns the registered on of this persisted user.
	 *
	 * @return the registered on of this persisted user
	 */
	@Override
	public Date getRegisteredOn() {
		return model.getRegisteredOn();
	}

	/**
	 * Returns the surname of this persisted user.
	 *
	 * @return the surname of this persisted user
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	/**
	 * Returns the user ID of this persisted user.
	 *
	 * @return the user ID of this persisted user
	 */
	@Override
	public String getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted user.
	 *
	 * @return the user name of this persisted user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this persisted user.
	 *
	 * @return the uuid of this persisted user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birth date of this persisted user.
	 *
	 * @param birthDate the birth date of this persisted user
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the company ID of this persisted user.
	 *
	 * @param companyId the company ID of this persisted user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted user.
	 *
	 * @param createDate the create date of this persisted user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this persisted user.
	 *
	 * @param email the email of this persisted user
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this persisted user.
	 *
	 * @param groupId the group ID of this persisted user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this persisted user.
	 *
	 * @param modifiedDate the modified date of this persisted user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this persisted user.
	 *
	 * @param name the name of this persisted user
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this persisted user.
	 *
	 * @param primaryKey the primary key of this persisted user
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recaptcha of this persisted user.
	 *
	 * @param recaptcha the recaptcha of this persisted user
	 */
	@Override
	public void setRecaptcha(String recaptcha) {
		model.setRecaptcha(recaptcha);
	}

	/**
	 * Sets the registered on of this persisted user.
	 *
	 * @param registeredOn the registered on of this persisted user
	 */
	@Override
	public void setRegisteredOn(Date registeredOn) {
		model.setRegisteredOn(registeredOn);
	}

	/**
	 * Sets the surname of this persisted user.
	 *
	 * @param surname the surname of this persisted user
	 */
	@Override
	public void setSurname(String surname) {
		model.setSurname(surname);
	}

	/**
	 * Sets the user ID of this persisted user.
	 *
	 * @param userId the user ID of this persisted user
	 */
	@Override
	public void setUserId(String userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted user.
	 *
	 * @param userName the user name of this persisted user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this persisted user.
	 *
	 * @param uuid the uuid of this persisted user
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PersistedUserWrapper wrap(PersistedUser persistedUser) {
		return new PersistedUserWrapper(persistedUser);
	}

}