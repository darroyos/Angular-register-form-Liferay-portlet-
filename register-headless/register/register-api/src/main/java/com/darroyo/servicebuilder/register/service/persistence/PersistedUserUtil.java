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

package com.darroyo.servicebuilder.register.service.persistence;

import com.darroyo.servicebuilder.register.model.PersistedUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted user service. This utility wraps <code>com.darroyo.servicebuilder.register.service.persistence.impl.PersistedUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUserPersistence
 * @generated
 */
public class PersistedUserUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PersistedUser persistedUser) {
		getPersistence().clearCache(persistedUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PersistedUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedUser update(PersistedUser persistedUser) {
		return getPersistence().update(persistedUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedUser update(
		PersistedUser persistedUser, ServiceContext serviceContext) {

		return getPersistence().update(persistedUser, serviceContext);
	}

	/**
	 * Returns all the persisted users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted users
	 */
	public static List<PersistedUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the persisted users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @return the range of matching persisted users
	 */
	public static List<PersistedUser> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted users
	 */
	public static List<PersistedUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted users
	 */
	public static List<PersistedUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUuid_First(
			String uuid, OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUuid_First(
		String uuid, OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUuid_Last(
			String uuid, OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted users before and after the current persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param userId the primary key of the current persisted user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public static PersistedUser[] findByUuid_PrevAndNext(
			String userId, String uuid,
			OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUuid_PrevAndNext(
			userId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersistedUserException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUUID_G(String uuid, long groupId)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the persisted user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the persisted user that was removed
	 */
	public static PersistedUser removeByUUID_G(String uuid, long groupId)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of persisted users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persisted users
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted users
	 */
	public static List<PersistedUser> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @return the range of matching persisted users
	 */
	public static List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted users
	 */
	public static List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted users
	 */
	public static List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the persisted users before and after the current persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userId the primary key of the current persisted user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public static PersistedUser[] findByUuid_C_PrevAndNext(
			String userId, String uuid, long companyId,
			OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUuid_C_PrevAndNext(
			userId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted users
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the persisted users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching persisted users
	 */
	public static List<PersistedUser> findByUserId(String userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the persisted users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @return the range of matching persisted users
	 */
	public static List<PersistedUser> findByUserId(
		String userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted users
	 */
	public static List<PersistedUser> findByUserId(
		String userId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted users
	 */
	public static List<PersistedUser> findByUserId(
		String userId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUserId_First(
			String userId, OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUserId_First(
		String userId, OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public static PersistedUser findByUserId_Last(
			String userId, OrderByComparator<PersistedUser> orderByComparator)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public static PersistedUser fetchByUserId_Last(
		String userId, OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Removes all the persisted users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(String userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of persisted users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching persisted users
	 */
	public static int countByUserId(String userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the persisted user in the entity cache if it is enabled.
	 *
	 * @param persistedUser the persisted user
	 */
	public static void cacheResult(PersistedUser persistedUser) {
		getPersistence().cacheResult(persistedUser);
	}

	/**
	 * Caches the persisted users in the entity cache if it is enabled.
	 *
	 * @param persistedUsers the persisted users
	 */
	public static void cacheResult(List<PersistedUser> persistedUsers) {
		getPersistence().cacheResult(persistedUsers);
	}

	/**
	 * Creates a new persisted user with the primary key. Does not add the persisted user to the database.
	 *
	 * @param userId the primary key for the new persisted user
	 * @return the new persisted user
	 */
	public static PersistedUser create(String userId) {
		return getPersistence().create(userId);
	}

	/**
	 * Removes the persisted user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user that was removed
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public static PersistedUser remove(String userId)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().remove(userId);
	}

	public static PersistedUser updateImpl(PersistedUser persistedUser) {
		return getPersistence().updateImpl(persistedUser);
	}

	/**
	 * Returns the persisted user with the primary key or throws a <code>NoSuchPersistedUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public static PersistedUser findByPrimaryKey(String userId)
		throws com.darroyo.servicebuilder.register.exception.
			NoSuchPersistedUserException {

		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	 * Returns the persisted user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user, or <code>null</code> if a persisted user with the primary key could not be found
	 */
	public static PersistedUser fetchByPrimaryKey(String userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	 * Returns all the persisted users.
	 *
	 * @return the persisted users
	 */
	public static List<PersistedUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @return the range of persisted users
	 */
	public static List<PersistedUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted users
	 */
	public static List<PersistedUser> findAll(
		int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted users
	 * @param end the upper bound of the range of persisted users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted users
	 */
	public static List<PersistedUser> findAll(
		int start, int end, OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted users.
	 *
	 * @return the number of persisted users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersistedUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedUserPersistence, PersistedUserPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedUserPersistence.class);

		ServiceTracker<PersistedUserPersistence, PersistedUserPersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedUserPersistence, PersistedUserPersistence>(
						bundle.getBundleContext(),
						PersistedUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}