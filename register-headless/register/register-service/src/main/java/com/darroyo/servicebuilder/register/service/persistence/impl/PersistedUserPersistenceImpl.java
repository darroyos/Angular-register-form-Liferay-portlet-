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

package com.darroyo.servicebuilder.register.service.persistence.impl;

import com.darroyo.servicebuilder.register.exception.NoSuchPersistedUserException;
import com.darroyo.servicebuilder.register.model.PersistedUser;
import com.darroyo.servicebuilder.register.model.PersistedUserTable;
import com.darroyo.servicebuilder.register.model.impl.PersistedUserImpl;
import com.darroyo.servicebuilder.register.model.impl.PersistedUserModelImpl;
import com.darroyo.servicebuilder.register.service.persistence.PersistedUserPersistence;
import com.darroyo.servicebuilder.register.service.persistence.impl.constants.DARROYOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PersistedUserPersistence.class, BasePersistence.class})
public class PersistedUserPersistenceImpl
	extends BasePersistenceImpl<PersistedUser>
	implements PersistedUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedUserUtil</code> to access the persisted user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the persisted users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted users
	 */
	@Override
	public List<PersistedUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PersistedUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PersistedUser> list = null;

		if (useFinderCache) {
			list = (List<PersistedUser>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedUser persistedUser : list) {
					if (!uuid.equals(persistedUser.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSISTEDUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<PersistedUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser findByUuid_First(
			String uuid, OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedUser != null) {
			return persistedUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedUserException(sb.toString());
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUuid_First(
		String uuid, OrderByComparator<PersistedUser> orderByComparator) {

		List<PersistedUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser findByUuid_Last(
			String uuid, OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUuid_Last(uuid, orderByComparator);

		if (persistedUser != null) {
			return persistedUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedUserException(sb.toString());
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedUser[] findByUuid_PrevAndNext(
			String userId, String uuid,
			OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		uuid = Objects.toString(uuid, "");

		PersistedUser persistedUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			PersistedUser[] array = new PersistedUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedUser, uuid, orderByComparator, true);

			array[1] = persistedUser;

			array[2] = getByUuid_PrevAndNext(
				session, persistedUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedUser getByUuid_PrevAndNext(
		Session session, PersistedUser persistedUser, String uuid,
		OrderByComparator<PersistedUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSISTEDUSER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedUser persistedUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedUser);
		}
	}

	/**
	 * Returns the number of persisted users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"persistedUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedUser.uuid IS NULL OR persistedUser.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersistedUserException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser findByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUUID_G(uuid, groupId);

		if (persistedUser == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPersistedUserException(sb.toString());
		}

		return persistedUser;
	}

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the persisted user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof PersistedUser) {
			PersistedUser persistedUser = (PersistedUser)result;

			if (!Objects.equals(uuid, persistedUser.getUuid()) ||
				(groupId != persistedUser.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERSISTEDUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<PersistedUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PersistedUser persistedUser = list.get(0);

					result = persistedUser;

					cacheResult(persistedUser);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PersistedUser)result;
		}
	}

	/**
	 * Removes the persisted user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the persisted user that was removed
	 */
	@Override
	public PersistedUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = findByUUID_G(uuid, groupId);

		return remove(persistedUser);
	}

	/**
	 * Returns the number of persisted users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persisted users
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"persistedUser.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(persistedUser.uuid IS NULL OR persistedUser.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"persistedUser.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted users
	 */
	@Override
	public List<PersistedUser> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<PersistedUser> list = null;

		if (useFinderCache) {
			list = (List<PersistedUser>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedUser persistedUser : list) {
					if (!uuid.equals(persistedUser.getUuid()) ||
						(companyId != persistedUser.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PERSISTEDUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<PersistedUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public PersistedUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedUser != null) {
			return persistedUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedUserException(sb.toString());
	}

	/**
	 * Returns the first persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedUser> orderByComparator) {

		List<PersistedUser> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedUser != null) {
			return persistedUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedUserException(sb.toString());
	}

	/**
	 * Returns the last persisted user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedUser> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedUser> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedUser[] findByUuid_C_PrevAndNext(
			String userId, String uuid, long companyId,
			OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		uuid = Objects.toString(uuid, "");

		PersistedUser persistedUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			PersistedUser[] array = new PersistedUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedUser, uuid, companyId, orderByComparator,
				true);

			array[1] = persistedUser;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedUser, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedUser getByUuid_C_PrevAndNext(
		Session session, PersistedUser persistedUser, String uuid,
		long companyId, OrderByComparator<PersistedUser> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PERSISTEDUSER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedUser persistedUser :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedUser);
		}
	}

	/**
	 * Returns the number of persisted users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted users
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"persistedUser.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedUser.uuid IS NULL OR persistedUser.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedUser.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the persisted users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching persisted users
	 */
	@Override
	public List<PersistedUser> findByUserId(String userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedUser> findByUserId(String userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<PersistedUser> findByUserId(
		String userId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedUser> findByUserId(
		String userId, int start, int end,
		OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		userId = Objects.toString(userId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<PersistedUser> list = null;

		if (useFinderCache) {
			list = (List<PersistedUser>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedUser persistedUser : list) {
					if (!userId.equals(persistedUser.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSISTEDUSER_WHERE);

			boolean bindUserId = false;

			if (userId.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERID_USERID_3);
			}
			else {
				bindUserId = true;

				sb.append(_FINDER_COLUMN_USERID_USERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserId) {
					queryPos.add(userId);
				}

				list = (List<PersistedUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser findByUserId_First(
			String userId, OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUserId_First(
			userId, orderByComparator);

		if (persistedUser != null) {
			return persistedUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchPersistedUserException(sb.toString());
	}

	/**
	 * Returns the first persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUserId_First(
		String userId, OrderByComparator<PersistedUser> orderByComparator) {

		List<PersistedUser> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user
	 * @throws NoSuchPersistedUserException if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser findByUserId_Last(
			String userId, OrderByComparator<PersistedUser> orderByComparator)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByUserId_Last(
			userId, orderByComparator);

		if (persistedUser != null) {
			return persistedUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchPersistedUserException(sb.toString());
	}

	/**
	 * Returns the last persisted user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public PersistedUser fetchByUserId_Last(
		String userId, OrderByComparator<PersistedUser> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<PersistedUser> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the persisted users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(String userId) {
		for (PersistedUser persistedUser :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedUser);
		}
	}

	/**
	 * Returns the number of persisted users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching persisted users
	 */
	@Override
	public int countByUserId(String userId) {
		userId = Objects.toString(userId, "");

		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDUSER_WHERE);

			boolean bindUserId = false;

			if (userId.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERID_USERID_3);
			}
			else {
				bindUserId = true;

				sb.append(_FINDER_COLUMN_USERID_USERID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserId) {
					queryPos.add(userId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"persistedUser.userId = ?";

	private static final String _FINDER_COLUMN_USERID_USERID_3 =
		"(persistedUser.userId IS NULL OR persistedUser.userId = '')";

	public PersistedUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersistedUser.class);

		setModelImplClass(PersistedUserImpl.class);
		setModelPKClass(String.class);

		setTable(PersistedUserTable.INSTANCE);
	}

	/**
	 * Caches the persisted user in the entity cache if it is enabled.
	 *
	 * @param persistedUser the persisted user
	 */
	@Override
	public void cacheResult(PersistedUser persistedUser) {
		entityCache.putResult(
			PersistedUserImpl.class, persistedUser.getPrimaryKey(),
			persistedUser);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {persistedUser.getUuid(), persistedUser.getGroupId()},
			persistedUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the persisted users in the entity cache if it is enabled.
	 *
	 * @param persistedUsers the persisted users
	 */
	@Override
	public void cacheResult(List<PersistedUser> persistedUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (persistedUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PersistedUser persistedUser : persistedUsers) {
			if (entityCache.getResult(
					PersistedUserImpl.class, persistedUser.getPrimaryKey()) ==
						null) {

				cacheResult(persistedUser);
			}
		}
	}

	/**
	 * Clears the cache for all persisted users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedUserImpl.class);

		finderCache.clearCache(PersistedUserImpl.class);
	}

	/**
	 * Clears the cache for the persisted user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedUser persistedUser) {
		entityCache.removeResult(PersistedUserImpl.class, persistedUser);
	}

	@Override
	public void clearCache(List<PersistedUser> persistedUsers) {
		for (PersistedUser persistedUser : persistedUsers) {
			entityCache.removeResult(PersistedUserImpl.class, persistedUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PersistedUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PersistedUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedUserModelImpl persistedUserModelImpl) {

		Object[] args = new Object[] {
			persistedUserModelImpl.getUuid(),
			persistedUserModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, persistedUserModelImpl);
	}

	/**
	 * Creates a new persisted user with the primary key. Does not add the persisted user to the database.
	 *
	 * @param userId the primary key for the new persisted user
	 * @return the new persisted user
	 */
	@Override
	public PersistedUser create(String userId) {
		PersistedUser persistedUser = new PersistedUserImpl();

		persistedUser.setNew(true);
		persistedUser.setPrimaryKey(userId);

		String uuid = PortalUUIDUtil.generate();

		persistedUser.setUuid(uuid);

		persistedUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedUser;
	}

	/**
	 * Removes the persisted user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user that was removed
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	@Override
	public PersistedUser remove(String userId)
		throws NoSuchPersistedUserException {

		return remove((Serializable)userId);
	}

	/**
	 * Removes the persisted user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted user
	 * @return the persisted user that was removed
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	@Override
	public PersistedUser remove(Serializable primaryKey)
		throws NoSuchPersistedUserException {

		Session session = null;

		try {
			session = openSession();

			PersistedUser persistedUser = (PersistedUser)session.get(
				PersistedUserImpl.class, primaryKey);

			if (persistedUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedUser);
		}
		catch (NoSuchPersistedUserException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PersistedUser removeImpl(PersistedUser persistedUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedUser)) {
				persistedUser = (PersistedUser)session.get(
					PersistedUserImpl.class, persistedUser.getPrimaryKeyObj());
			}

			if (persistedUser != null) {
				session.delete(persistedUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persistedUser != null) {
			clearCache(persistedUser);
		}

		return persistedUser;
	}

	@Override
	public PersistedUser updateImpl(PersistedUser persistedUser) {
		boolean isNew = persistedUser.isNew();

		if (!(persistedUser instanceof PersistedUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedUser implementation " +
					persistedUser.getClass());
		}

		PersistedUserModelImpl persistedUserModelImpl =
			(PersistedUserModelImpl)persistedUser;

		if (Validator.isNull(persistedUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedUser.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (persistedUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				persistedUser.setCreateDate(date);
			}
			else {
				persistedUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!persistedUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persistedUser.setModifiedDate(date);
			}
			else {
				persistedUser.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(persistedUser);
			}
			else {
				persistedUser = (PersistedUser)session.merge(persistedUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PersistedUserImpl.class, persistedUserModelImpl, false, true);

		cacheUniqueFindersCache(persistedUserModelImpl);

		if (isNew) {
			persistedUser.setNew(false);
		}

		persistedUser.resetOriginalValues();

		return persistedUser;
	}

	/**
	 * Returns the persisted user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted user
	 * @return the persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	@Override
	public PersistedUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedUserException {

		PersistedUser persistedUser = fetchByPrimaryKey(primaryKey);

		if (persistedUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedUser;
	}

	/**
	 * Returns the persisted user with the primary key or throws a <code>NoSuchPersistedUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user
	 * @throws NoSuchPersistedUserException if a persisted user with the primary key could not be found
	 */
	@Override
	public PersistedUser findByPrimaryKey(String userId)
		throws NoSuchPersistedUserException {

		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the persisted user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user, or <code>null</code> if a persisted user with the primary key could not be found
	 */
	@Override
	public PersistedUser fetchByPrimaryKey(String userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the persisted users.
	 *
	 * @return the persisted users
	 */
	@Override
	public List<PersistedUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PersistedUser> findAll(
		int start, int end,
		OrderByComparator<PersistedUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PersistedUser> findAll(
		int start, int end, OrderByComparator<PersistedUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PersistedUser> list = null;

		if (useFinderCache) {
			list = (List<PersistedUser>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSISTEDUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDUSER;

				sql = sql.concat(PersistedUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersistedUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the persisted users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedUser persistedUser : findAll()) {
			remove(persistedUser);
		}
	}

	/**
	 * Returns the number of persisted users.
	 *
	 * @return the number of persisted users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSISTEDUSER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted user persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {String.class.getName()}, new String[] {"userId"},
			true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {String.class.getName()}, new String[] {"userId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedUserImpl.class.getName());
	}

	@Override
	@Reference(
		target = DARROYOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DARROYOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DARROYOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PERSISTEDUSER =
		"SELECT persistedUser FROM PersistedUser persistedUser";

	private static final String _SQL_SELECT_PERSISTEDUSER_WHERE =
		"SELECT persistedUser FROM PersistedUser persistedUser WHERE ";

	private static final String _SQL_COUNT_PERSISTEDUSER =
		"SELECT COUNT(persistedUser) FROM PersistedUser persistedUser";

	private static final String _SQL_COUNT_PERSISTEDUSER_WHERE =
		"SELECT COUNT(persistedUser) FROM PersistedUser persistedUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PersistedUserModelArgumentsResolver
		_persistedUserModelArgumentsResolver;

}