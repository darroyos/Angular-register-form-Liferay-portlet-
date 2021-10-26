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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PersistedUser service. Represents a row in the &quot;DARROYO_PersistedUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUserModel
 * @generated
 */
@ImplementationClassName(
	"com.darroyo.servicebuilder.register.model.impl.PersistedUserImpl"
)
@ProviderType
public interface PersistedUser extends PersistedModel, PersistedUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.darroyo.servicebuilder.register.model.impl.PersistedUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PersistedUser, String> USER_ID_ACCESSOR =
		new Accessor<PersistedUser, String>() {

			@Override
			public String get(PersistedUser persistedUser) {
				return persistedUser.getUserId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<PersistedUser> getTypeClass() {
				return PersistedUser.class;
			}

		};

}