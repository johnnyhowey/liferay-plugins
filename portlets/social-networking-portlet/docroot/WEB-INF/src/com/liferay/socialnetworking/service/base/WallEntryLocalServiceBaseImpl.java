/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.socialnetworking.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.socialnetworking.model.WallEntry;
import com.liferay.socialnetworking.service.MeetupsEntryLocalService;
import com.liferay.socialnetworking.service.MeetupsRegistrationLocalService;
import com.liferay.socialnetworking.service.WallEntryLocalService;
import com.liferay.socialnetworking.service.persistence.MeetupsEntryPersistence;
import com.liferay.socialnetworking.service.persistence.MeetupsRegistrationPersistence;
import com.liferay.socialnetworking.service.persistence.WallEntryFinder;
import com.liferay.socialnetworking.service.persistence.WallEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the wall entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.socialnetworking.service.impl.WallEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.socialnetworking.service.impl.WallEntryLocalServiceImpl
 * @see com.liferay.socialnetworking.service.WallEntryLocalServiceUtil
 * @generated
 */
public abstract class WallEntryLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements WallEntryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.socialnetworking.service.WallEntryLocalServiceUtil} to access the wall entry local service.
	 */

	/**
	 * Adds the wall entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param wallEntry the wall entry
	 * @return the wall entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WallEntry addWallEntry(WallEntry wallEntry)
		throws SystemException {
		wallEntry.setNew(true);

		return wallEntryPersistence.update(wallEntry, false);
	}

	/**
	 * Creates a new wall entry with the primary key. Does not add the wall entry to the database.
	 *
	 * @param wallEntryId the primary key for the new wall entry
	 * @return the new wall entry
	 */
	public WallEntry createWallEntry(long wallEntryId) {
		return wallEntryPersistence.create(wallEntryId);
	}

	/**
	 * Deletes the wall entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wallEntryId the primary key of the wall entry
	 * @return the wall entry that was removed
	 * @throws PortalException if a wall entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public WallEntry deleteWallEntry(long wallEntryId)
		throws PortalException, SystemException {
		return wallEntryPersistence.remove(wallEntryId);
	}

	/**
	 * Deletes the wall entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wallEntry the wall entry
	 * @return the wall entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public WallEntry deleteWallEntry(WallEntry wallEntry)
		throws SystemException {
		return wallEntryPersistence.remove(wallEntry);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(WallEntry.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return wallEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return wallEntryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return wallEntryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return wallEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public WallEntry fetchWallEntry(long wallEntryId) throws SystemException {
		return wallEntryPersistence.fetchByPrimaryKey(wallEntryId);
	}

	/**
	 * Returns the wall entry with the primary key.
	 *
	 * @param wallEntryId the primary key of the wall entry
	 * @return the wall entry
	 * @throws PortalException if a wall entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WallEntry getWallEntry(long wallEntryId)
		throws PortalException, SystemException {
		return wallEntryPersistence.findByPrimaryKey(wallEntryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return wallEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the wall entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of wall entries
	 * @param end the upper bound of the range of wall entries (not inclusive)
	 * @return the range of wall entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WallEntry> getWallEntries(int start, int end)
		throws SystemException {
		return wallEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of wall entries.
	 *
	 * @return the number of wall entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getWallEntriesCount() throws SystemException {
		return wallEntryPersistence.countAll();
	}

	/**
	 * Updates the wall entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param wallEntry the wall entry
	 * @return the wall entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WallEntry updateWallEntry(WallEntry wallEntry)
		throws SystemException {
		return updateWallEntry(wallEntry, true);
	}

	/**
	 * Updates the wall entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param wallEntry the wall entry
	 * @param merge whether to merge the wall entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the wall entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WallEntry updateWallEntry(WallEntry wallEntry, boolean merge)
		throws SystemException {
		wallEntry.setNew(false);

		return wallEntryPersistence.update(wallEntry, merge);
	}

	/**
	 * Returns the meetups entry local service.
	 *
	 * @return the meetups entry local service
	 */
	public MeetupsEntryLocalService getMeetupsEntryLocalService() {
		return meetupsEntryLocalService;
	}

	/**
	 * Sets the meetups entry local service.
	 *
	 * @param meetupsEntryLocalService the meetups entry local service
	 */
	public void setMeetupsEntryLocalService(
		MeetupsEntryLocalService meetupsEntryLocalService) {
		this.meetupsEntryLocalService = meetupsEntryLocalService;
	}

	/**
	 * Returns the meetups entry persistence.
	 *
	 * @return the meetups entry persistence
	 */
	public MeetupsEntryPersistence getMeetupsEntryPersistence() {
		return meetupsEntryPersistence;
	}

	/**
	 * Sets the meetups entry persistence.
	 *
	 * @param meetupsEntryPersistence the meetups entry persistence
	 */
	public void setMeetupsEntryPersistence(
		MeetupsEntryPersistence meetupsEntryPersistence) {
		this.meetupsEntryPersistence = meetupsEntryPersistence;
	}

	/**
	 * Returns the meetups registration local service.
	 *
	 * @return the meetups registration local service
	 */
	public MeetupsRegistrationLocalService getMeetupsRegistrationLocalService() {
		return meetupsRegistrationLocalService;
	}

	/**
	 * Sets the meetups registration local service.
	 *
	 * @param meetupsRegistrationLocalService the meetups registration local service
	 */
	public void setMeetupsRegistrationLocalService(
		MeetupsRegistrationLocalService meetupsRegistrationLocalService) {
		this.meetupsRegistrationLocalService = meetupsRegistrationLocalService;
	}

	/**
	 * Returns the meetups registration persistence.
	 *
	 * @return the meetups registration persistence
	 */
	public MeetupsRegistrationPersistence getMeetupsRegistrationPersistence() {
		return meetupsRegistrationPersistence;
	}

	/**
	 * Sets the meetups registration persistence.
	 *
	 * @param meetupsRegistrationPersistence the meetups registration persistence
	 */
	public void setMeetupsRegistrationPersistence(
		MeetupsRegistrationPersistence meetupsRegistrationPersistence) {
		this.meetupsRegistrationPersistence = meetupsRegistrationPersistence;
	}

	/**
	 * Returns the wall entry local service.
	 *
	 * @return the wall entry local service
	 */
	public WallEntryLocalService getWallEntryLocalService() {
		return wallEntryLocalService;
	}

	/**
	 * Sets the wall entry local service.
	 *
	 * @param wallEntryLocalService the wall entry local service
	 */
	public void setWallEntryLocalService(
		WallEntryLocalService wallEntryLocalService) {
		this.wallEntryLocalService = wallEntryLocalService;
	}

	/**
	 * Returns the wall entry persistence.
	 *
	 * @return the wall entry persistence
	 */
	public WallEntryPersistence getWallEntryPersistence() {
		return wallEntryPersistence;
	}

	/**
	 * Sets the wall entry persistence.
	 *
	 * @param wallEntryPersistence the wall entry persistence
	 */
	public void setWallEntryPersistence(
		WallEntryPersistence wallEntryPersistence) {
		this.wallEntryPersistence = wallEntryPersistence;
	}

	/**
	 * Returns the wall entry finder.
	 *
	 * @return the wall entry finder
	 */
	public WallEntryFinder getWallEntryFinder() {
		return wallEntryFinder;
	}

	/**
	 * Sets the wall entry finder.
	 *
	 * @param wallEntryFinder the wall entry finder
	 */
	public void setWallEntryFinder(WallEntryFinder wallEntryFinder) {
		this.wallEntryFinder = wallEntryFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.socialnetworking.model.WallEntry",
			wallEntryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.socialnetworking.model.WallEntry");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return WallEntry.class;
	}

	protected String getModelClassName() {
		return WallEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = wallEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = MeetupsEntryLocalService.class)
	protected MeetupsEntryLocalService meetupsEntryLocalService;
	@BeanReference(type = MeetupsEntryPersistence.class)
	protected MeetupsEntryPersistence meetupsEntryPersistence;
	@BeanReference(type = MeetupsRegistrationLocalService.class)
	protected MeetupsRegistrationLocalService meetupsRegistrationLocalService;
	@BeanReference(type = MeetupsRegistrationPersistence.class)
	protected MeetupsRegistrationPersistence meetupsRegistrationPersistence;
	@BeanReference(type = WallEntryLocalService.class)
	protected WallEntryLocalService wallEntryLocalService;
	@BeanReference(type = WallEntryPersistence.class)
	protected WallEntryPersistence wallEntryPersistence;
	@BeanReference(type = WallEntryFinder.class)
	protected WallEntryFinder wallEntryFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private WallEntryLocalServiceClpInvoker _clpInvoker = new WallEntryLocalServiceClpInvoker();
}