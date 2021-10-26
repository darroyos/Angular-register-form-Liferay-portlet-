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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersistedUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUserLocalService
 * @generated
 */
public class PersistedUserLocalServiceWrapper
	implements PersistedUserLocalService,
			   ServiceWrapper<PersistedUserLocalService> {

	public PersistedUserLocalServiceWrapper(
		PersistedUserLocalService persistedUserLocalService) {

		_persistedUserLocalService = persistedUserLocalService;
	}

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
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
		addPersistedUser(
			com.darroyo.servicebuilder.register.model.PersistedUser
				persistedUser) {

		return _persistedUserLocalService.addPersistedUser(persistedUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new persisted user with the primary key. Does not add the persisted user to the database.
	 *
	 * @param userId the primary key for the new persisted user
	 * @return the new persisted user
	 */
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
		createPersistedUser(String userId) {

		return _persistedUserLocalService.createPersistedUser(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedUserLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
		deletePersistedUser(
			com.darroyo.servicebuilder.register.model.PersistedUser
				persistedUser) {

		return _persistedUserLocalService.deletePersistedUser(persistedUser);
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
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
			deletePersistedUser(String userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedUserLocalService.deletePersistedUser(userId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _persistedUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _persistedUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedUserLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _persistedUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _persistedUserLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _persistedUserLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _persistedUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _persistedUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
		fetchPersistedUser(String userId) {

		return _persistedUserLocalService.fetchPersistedUser(userId);
	}

	/**
	 * Returns the persisted user matching the UUID and group.
	 *
	 * @param uuid the persisted user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching persisted user, or <code>null</code> if a matching persisted user could not be found
	 */
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
		fetchPersistedUserByUuidAndGroupId(String uuid, long groupId) {

		return _persistedUserLocalService.fetchPersistedUserByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted user with the primary key.
	 *
	 * @param userId the primary key of the persisted user
	 * @return the persisted user
	 * @throws PortalException if a persisted user with the primary key could not be found
	 */
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
			getPersistedUser(String userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedUserLocalService.getPersistedUser(userId);
	}

	/**
	 * Returns the persisted user matching the UUID and group.
	 *
	 * @param uuid the persisted user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching persisted user
	 * @throws PortalException if a matching persisted user could not be found
	 */
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
			getPersistedUserByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedUserLocalService.getPersistedUserByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List
		<com.darroyo.servicebuilder.register.model.PersistedUser>
			getPersistedUsers(int start, int end) {

		return _persistedUserLocalService.getPersistedUsers(start, end);
	}

	/**
	 * Returns all the persisted users matching the UUID and company.
	 *
	 * @param uuid the UUID of the persisted users
	 * @param companyId the primary key of the company
	 * @return the matching persisted users, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.darroyo.servicebuilder.register.model.PersistedUser>
			getPersistedUsersByUuidAndCompanyId(String uuid, long companyId) {

		return _persistedUserLocalService.getPersistedUsersByUuidAndCompanyId(
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
	@Override
	public java.util.List
		<com.darroyo.servicebuilder.register.model.PersistedUser>
			getPersistedUsersByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.darroyo.servicebuilder.register.model.PersistedUser>
						orderByComparator) {

		return _persistedUserLocalService.getPersistedUsersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted users.
	 *
	 * @return the number of persisted users
	 */
	@Override
	public int getPersistedUsersCount() {
		return _persistedUserLocalService.getPersistedUsersCount();
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
	@Override
	public com.darroyo.servicebuilder.register.model.PersistedUser
		updatePersistedUser(
			com.darroyo.servicebuilder.register.model.PersistedUser
				persistedUser) {

		return _persistedUserLocalService.updatePersistedUser(persistedUser);
	}

	@Override
	public PersistedUserLocalService getWrappedService() {
		return _persistedUserLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedUserLocalService persistedUserLocalService) {

		_persistedUserLocalService = persistedUserLocalService;
	}

	private PersistedUserLocalService _persistedUserLocalService;

}