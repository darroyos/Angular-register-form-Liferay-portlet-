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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PersistedUser service. Represents a row in the &quot;DARROYO_PersistedUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.darroyo.servicebuilder.register.model.impl.PersistedUserModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.darroyo.servicebuilder.register.model.impl.PersistedUserImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUser
 * @generated
 */
@ProviderType
public interface PersistedUserModel
	extends BaseModel<PersistedUser>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a persisted user model instance should use the {@link PersistedUser} interface instead.
	 */

	/**
	 * Returns the primary key of this persisted user.
	 *
	 * @return the primary key of this persisted user
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this persisted user.
	 *
	 * @param primaryKey the primary key of this persisted user
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this persisted user.
	 *
	 * @return the uuid of this persisted user
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this persisted user.
	 *
	 * @param uuid the uuid of this persisted user
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the user ID of this persisted user.
	 *
	 * @return the user ID of this persisted user
	 */
	@AutoEscape
	@Override
	public String getUserId();

	/**
	 * Sets the user ID of this persisted user.
	 *
	 * @param userId the user ID of this persisted user
	 */
	@Override
	public void setUserId(String userId);

	/**
	 * Returns the group ID of this persisted user.
	 *
	 * @return the group ID of this persisted user
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this persisted user.
	 *
	 * @param groupId the group ID of this persisted user
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this persisted user.
	 *
	 * @return the company ID of this persisted user
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this persisted user.
	 *
	 * @param companyId the company ID of this persisted user
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this persisted user.
	 *
	 * @return the user name of this persisted user
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this persisted user.
	 *
	 * @param userName the user name of this persisted user
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this persisted user.
	 *
	 * @return the create date of this persisted user
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this persisted user.
	 *
	 * @param createDate the create date of this persisted user
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this persisted user.
	 *
	 * @return the modified date of this persisted user
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this persisted user.
	 *
	 * @param modifiedDate the modified date of this persisted user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this persisted user.
	 *
	 * @return the name of this persisted user
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this persisted user.
	 *
	 * @param name the name of this persisted user
	 */
	public void setName(String name);

	/**
	 * Returns the surname of this persisted user.
	 *
	 * @return the surname of this persisted user
	 */
	@AutoEscape
	public String getSurname();

	/**
	 * Sets the surname of this persisted user.
	 *
	 * @param surname the surname of this persisted user
	 */
	public void setSurname(String surname);

	/**
	 * Returns the email of this persisted user.
	 *
	 * @return the email of this persisted user
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this persisted user.
	 *
	 * @param email the email of this persisted user
	 */
	public void setEmail(String email);

	/**
	 * Returns the birth date of this persisted user.
	 *
	 * @return the birth date of this persisted user
	 */
	public Date getBirthDate();

	/**
	 * Sets the birth date of this persisted user.
	 *
	 * @param birthDate the birth date of this persisted user
	 */
	public void setBirthDate(Date birthDate);

	/**
	 * Returns the registered on of this persisted user.
	 *
	 * @return the registered on of this persisted user
	 */
	public Date getRegisteredOn();

	/**
	 * Sets the registered on of this persisted user.
	 *
	 * @param registeredOn the registered on of this persisted user
	 */
	public void setRegisteredOn(Date registeredOn);

	/**
	 * Returns the recaptcha of this persisted user.
	 *
	 * @return the recaptcha of this persisted user
	 */
	@AutoEscape
	public String getRecaptcha();

	/**
	 * Sets the recaptcha of this persisted user.
	 *
	 * @param recaptcha the recaptcha of this persisted user
	 */
	public void setRecaptcha(String recaptcha);

	@Override
	public PersistedUser cloneWithOriginalValues();

}