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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.darroyo.servicebuilder.register.service.http.PersistedUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersistedUserSoap implements Serializable {

	public static PersistedUserSoap toSoapModel(PersistedUser model) {
		PersistedUserSoap soapModel = new PersistedUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setSurname(model.getSurname());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthDate(model.getBirthDate());
		soapModel.setRegisteredOn(model.getRegisteredOn());
		soapModel.setRecaptcha(model.getRecaptcha());

		return soapModel;
	}

	public static PersistedUserSoap[] toSoapModels(PersistedUser[] models) {
		PersistedUserSoap[] soapModels = new PersistedUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedUserSoap[][] toSoapModels(PersistedUser[][] models) {
		PersistedUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersistedUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedUserSoap[] toSoapModels(List<PersistedUser> models) {
		List<PersistedUserSoap> soapModels = new ArrayList<PersistedUserSoap>(
			models.size());

		for (PersistedUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedUserSoap[soapModels.size()]);
	}

	public PersistedUserSoap() {
	}

	public String getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(String pk) {
		setUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSurname() {
		return _surname;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	public Date getRegisteredOn() {
		return _registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		_registeredOn = registeredOn;
	}

	public String getRecaptcha() {
		return _recaptcha;
	}

	public void setRecaptcha(String recaptcha) {
		_recaptcha = recaptcha;
	}

	private String _uuid;
	private String _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _surname;
	private String _email;
	private Date _birthDate;
	private Date _registeredOn;
	private String _recaptcha;

}