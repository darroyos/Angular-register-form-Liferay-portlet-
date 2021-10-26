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

import com.darroyo.servicebuilder.register.exception.NoSuchPersistedUserException;
import com.darroyo.servicebuilder.register.model.PersistedUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUserUtil
 * @generated
 */
@ProviderType
public interface PersistedUserPersistence
	extends BasePersistence<PersistedUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedUserUtil} to access the persisted user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted users
	 */
	public java.util.List<PersistedUser> findByUuid(String uuid);

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
	public java.util.List<PersistedUser> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PersistedUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

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
	public java.util.List<PersistedUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

	/**
	 * Returns the persisted users before and after the current persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param userId the primary key of the current persisted user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public PersistedUser[] findByUuid_PrevAndNext(
			String userId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Removes all the persisted users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersistedUserException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the persisted user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the persisted user that was removed
	 */
	public PersistedUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the number of persisted users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persisted users
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted users
	 */
	public java.util.List<PersistedUser> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

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
	public java.util.List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

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
	public PersistedUser[] findByUuid_C_PrevAndNext(
			String userId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Removes all the persisted users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted users
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the persisted users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching persisted users
	 */
	public java.util.List<PersistedUser> findByUserId(String userId);

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
	public java.util.List<PersistedUser> findByUserId(
		String userId, int start, int end);

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
	public java.util.List<PersistedUser> findByUserId(
		String userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

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
	public java.util.List<PersistedUser> findByUserId(
		String userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUserId_First(
			String userId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the first persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUserId_First(
		String userId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

	/**
	 * Returns the last persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	public PersistedUser findByUserId_Last(
			String userId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
				orderByComparator)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the last persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	public PersistedUser fetchByUserId_Last(
		String userId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

	/**
	 * Removes all the persisted users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(String userId);

	/**
	 * Returns the number of persisted users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching persisted users
	 */
	public int countByUserId(String userId);

	/**
	 * Caches the persisted user in the entity cache if it is enabled.
	 *
	 * @param persistedUser the persisted user
	 */
	public void cacheResult(PersistedUser persistedUser);

	/**
	 * Caches the persisted users in the entity cache if it is enabled.
	 *
	 * @param persistedUsers the persisted users
	 */
	public void cacheResult(java.util.List<PersistedUser> persistedUsers);

	/**
	 * Creates a new persisted user with the primary key. Does not add the persisted user to the database.
	 *
	 * @param userId the primary key for the new persisted user
	 * @return the new persisted user
	 */
	public PersistedUser create(String userId);

	/**
	 * Removes the persisted user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user that was removed
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public PersistedUser remove(String userId)
		throws NoSuchPersistedUserException;

	public PersistedUser updateImpl(PersistedUser persistedUser);

	/**
	 * Returns the persisted user with the primary key or throws a <code>NoSuchPersistedUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	public PersistedUser findByPrimaryKey(String userId)
		throws NoSuchPersistedUserException;

	/**
	 * Returns the persisted user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user, or <code>null</code> if a persisted user with the primary key could not be found
	 */
	public PersistedUser fetchByPrimaryKey(String userId);

	/**
	 * Returns all the persisted users.
	 *
	 * @return the persisted users
	 */
	public java.util.List<PersistedUser> findAll();

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
	public java.util.List<PersistedUser> findAll(int start, int end);

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
	public java.util.List<PersistedUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator);

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
	public java.util.List<PersistedUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted users.
	 *
	 * @return the number of persisted users
	 */
	public int countAll();

}