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

package com.darroyo.servicebuilder.register.service;

import com.darroyo.servicebuilder.register.model.PersistedUser;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PersistedUser. This utility wraps
 * <code>com.darroyo.servicebuilder.register.service.impl.PersistedUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUserLocalService
 * @generated
 */
public class PersistedUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.darroyo.servicebuilder.register.service.impl.PersistedUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the persisted user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedUser the persisted user
	 * @return the persisted user that was added
	 */
	public static PersistedUser addPersistedUser(PersistedUser persistedUser) {
		return getService().addPersistedUser(persistedUser);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new persisted user with the primary key. Does not add the persisted user to the database.
	 *
	 * @param userId the primary key for the new persisted user
	 * @return the new persisted user
	 */
	public static PersistedUser createPersistedUser(String userId) {
		return getService().createPersistedUser(userId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the persisted user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedUser the persisted user
	 * @return the persisted user that was removed
	 */
	public static PersistedUser deletePersistedUser(
		PersistedUser persistedUser) {

		return getService().deletePersistedUser(persistedUser);
	}

	/**
	 * Deletes the persisted user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user that was removed
	 * @throws PortalException if a persisted user with the primary key could not be found
	 */
	public static PersistedUser deletePersistedUser(String userId)
		throws PortalException {

		return getService().deletePersistedUser(userId);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.darroyo.servicebuilder.register.model.impl.PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.darroyo.servicebuilder.register.model.impl.PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PersistedUser fetchPersistedUser(String userId) {
		return getService().fetchPersistedUser(userId);
	}

	/**
	 * Returns the persisted user matching the UUID and group.
	 *
	 * @param uuid the persisted user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchPersistedUserByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPersistedUserByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted user with the primary key.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user
	 * @throws PortalException if a persisted user with the primary key could not be found
	 */
	public static PersistedUser getPersistedUser(String userId)
		throws PortalException {

		return getService().getPersistedUser(userId);
	}

	/**
	 * Returns the persisted user matching the UUID and group.
	 *
	 * @param uuid the persisted user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching persisted user
	 * @throws PortalException if a matching persisted user could not be found
	 */
	public static PersistedUser getPersistedUserByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPersistedUserByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the persisted users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.darroyo.servicebuilder.register.model.impl.PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @return the range of persisted users
	 */
	public static List<PersistedUser> getPersistedUsers(int start, int end) {
		return getService().getPersistedUsers(start, end);
	}

	/**
	 * Returns all the persisted users matching the UUID and company.
	 *
	 * @param uuid the UUID of the persisted users
	 * @param companyId the primary key of the company
	 * @return the matching persisted users, or an empty list if no matches were found
	 */
	public static List<PersistedUser> getPersistedUsersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPersistedUsersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of persisted users matching the UUID and company.
	 *
	 * @param uuid the UUID of the persisted users
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching persisted users, or an empty list if no matches were found
	 */
	public static List<PersistedUser> getPersistedUsersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getService().getPersistedUsersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted users.
	 *
	 * @return the number of persisted users
	 */
	public static int getPersistedUsersCount() {
		return getService().getPersistedUsersCount();
	}

	/**
	 * Updates the persisted user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedUser the persisted user
	 * @return the persisted user that was updated
	 */
	public static PersistedUser updatePersistedUser(
		PersistedUser persistedUser) {

		return getService().updatePersistedUser(persistedUser);
	}

	public static PersistedUserLocalService getService() {
		return _service;
	}

	private static volatile PersistedUserLocalService _service;

}