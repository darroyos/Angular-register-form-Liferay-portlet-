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

package com.darroyo.servicebuilder.register.model.impl;

import com.darroyo.servicebuilder.register.model.PersistedUser;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersistedUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedUserCacheModel
	implements CacheModel<PersistedUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedUserCacheModel)) {
			return false;
		}

		PersistedUserCacheModel persistedUserCacheModel =
			(PersistedUserCacheModel)object;

		if (userId.equals(persistedUserCacheModel.userId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", registeredOn=");
		sb.append(registeredOn);
		sb.append(", recaptcha=");
		sb.append(recaptcha);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedUser toEntityModel() {
		PersistedUserImpl persistedUserImpl = new PersistedUserImpl();

		if (uuid == null) {
			persistedUserImpl.setUuid("");
		}
		else {
			persistedUserImpl.setUuid(uuid);
		}

		if (userId == null) {
			persistedUserImpl.setUserId("");
		}
		else {
			persistedUserImpl.setUserId(userId);
		}

		persistedUserImpl.setGroupId(groupId);
		persistedUserImpl.setCompanyId(companyId);

		if (userName == null) {
			persistedUserImpl.setUserName("");
		}
		else {
			persistedUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedUserImpl.setCreateDate(null);
		}
		else {
			persistedUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedUserImpl.setModifiedDate(null);
		}
		else {
			persistedUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			persistedUserImpl.setName("");
		}
		else {
			persistedUserImpl.setName(name);
		}

		if (surname == null) {
			persistedUserImpl.setSurname("");
		}
		else {
			persistedUserImpl.setSurname(surname);
		}

		if (email == null) {
			persistedUserImpl.setEmail("");
		}
		else {
			persistedUserImpl.setEmail(email);
		}

		if (birthDate == Long.MIN_VALUE) {
			persistedUserImpl.setBirthDate(null);
		}
		else {
			persistedUserImpl.setBirthDate(new Date(birthDate));
		}

		if (registeredOn == Long.MIN_VALUE) {
			persistedUserImpl.setRegisteredOn(null);
		}
		else {
			persistedUserImpl.setRegisteredOn(new Date(registeredOn));
		}

		if (recaptcha == null) {
			persistedUserImpl.setRecaptcha("");
		}
		else {
			persistedUserImpl.setRecaptcha(recaptcha);
		}

		persistedUserImpl.resetOriginalValues();

		return persistedUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		surname = objectInput.readUTF();
		email = objectInput.readUTF();
		birthDate = objectInput.readLong();
		registeredOn = objectInput.readLong();
		recaptcha = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (userId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(birthDate);
		objectOutput.writeLong(registeredOn);

		if (recaptcha == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recaptcha);
		}
	}

	public String uuid;
	public String userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String surname;
	public String email;
	public long birthDate;
	public long registeredOn;
	public String recaptcha;

}