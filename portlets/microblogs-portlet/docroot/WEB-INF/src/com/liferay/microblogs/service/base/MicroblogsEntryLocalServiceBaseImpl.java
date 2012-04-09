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

package com.liferay.microblogs.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.microblogs.model.MicroblogsEntry;
import com.liferay.microblogs.service.MicroblogsEntryLocalService;
import com.liferay.microblogs.service.MicroblogsEntryService;
import com.liferay.microblogs.service.persistence.MicroblogsEntryFinder;
import com.liferay.microblogs.service.persistence.MicroblogsEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the microblogs entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.microblogs.service.impl.MicroblogsEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.microblogs.service.impl.MicroblogsEntryLocalServiceImpl
 * @see com.liferay.microblogs.service.MicroblogsEntryLocalServiceUtil
 * @generated
 */
public abstract class MicroblogsEntryLocalServiceBaseImpl
	implements MicroblogsEntryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.microblogs.service.MicroblogsEntryLocalServiceUtil} to access the microblogs entry local service.
	 */

	/**
	 * Adds the microblogs entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param microblogsEntry the microblogs entry
	 * @return the microblogs entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MicroblogsEntry addMicroblogsEntry(MicroblogsEntry microblogsEntry)
		throws SystemException {
		microblogsEntry.setNew(true);

		return microblogsEntryPersistence.update(microblogsEntry, false);
	}

	/**
	 * Creates a new microblogs entry with the primary key. Does not add the microblogs entry to the database.
	 *
	 * @param microblogsEntryId the primary key for the new microblogs entry
	 * @return the new microblogs entry
	 */
	public MicroblogsEntry createMicroblogsEntry(long microblogsEntryId) {
		return microblogsEntryPersistence.create(microblogsEntryId);
	}

	/**
	 * Deletes the microblogs entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param microblogsEntryId the primary key of the microblogs entry
	 * @return the microblogs entry that was removed
	 * @throws PortalException if a microblogs entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public MicroblogsEntry deleteMicroblogsEntry(long microblogsEntryId)
		throws PortalException, SystemException {
		return microblogsEntryPersistence.remove(microblogsEntryId);
	}

	/**
	 * Deletes the microblogs entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param microblogsEntry the microblogs entry
	 * @return the microblogs entry that was removed
	 * @throws PortalException
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public MicroblogsEntry deleteMicroblogsEntry(
		MicroblogsEntry microblogsEntry)
		throws PortalException, SystemException {
		return microblogsEntryPersistence.remove(microblogsEntry);
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
		return microblogsEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return microblogsEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
		return microblogsEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return microblogsEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public MicroblogsEntry fetchMicroblogsEntry(long microblogsEntryId)
		throws SystemException {
		return microblogsEntryPersistence.fetchByPrimaryKey(microblogsEntryId);
	}

	/**
	 * Returns the microblogs entry with the primary key.
	 *
	 * @param microblogsEntryId the primary key of the microblogs entry
	 * @return the microblogs entry
	 * @throws PortalException if a microblogs entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MicroblogsEntry getMicroblogsEntry(long microblogsEntryId)
		throws PortalException, SystemException {
		return microblogsEntryPersistence.findByPrimaryKey(microblogsEntryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return microblogsEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the microblogs entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of microblogs entries
	 * @param end the upper bound of the range of microblogs entries (not inclusive)
	 * @return the range of microblogs entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<MicroblogsEntry> getMicroblogsEntries(int start, int end)
		throws SystemException {
		return microblogsEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of microblogs entries.
	 *
	 * @return the number of microblogs entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getMicroblogsEntriesCount() throws SystemException {
		return microblogsEntryPersistence.countAll();
	}

	/**
	 * Updates the microblogs entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param microblogsEntry the microblogs entry
	 * @return the microblogs entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MicroblogsEntry updateMicroblogsEntry(
		MicroblogsEntry microblogsEntry) throws SystemException {
		return updateMicroblogsEntry(microblogsEntry, true);
	}

	/**
	 * Updates the microblogs entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param microblogsEntry the microblogs entry
	 * @param merge whether to merge the microblogs entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the microblogs entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MicroblogsEntry updateMicroblogsEntry(
		MicroblogsEntry microblogsEntry, boolean merge)
		throws SystemException {
		microblogsEntry.setNew(false);

		return microblogsEntryPersistence.update(microblogsEntry, merge);
	}

	/**
	 * Returns the microblogs entry local service.
	 *
	 * @return the microblogs entry local service
	 */
	public MicroblogsEntryLocalService getMicroblogsEntryLocalService() {
		return microblogsEntryLocalService;
	}

	/**
	 * Sets the microblogs entry local service.
	 *
	 * @param microblogsEntryLocalService the microblogs entry local service
	 */
	public void setMicroblogsEntryLocalService(
		MicroblogsEntryLocalService microblogsEntryLocalService) {
		this.microblogsEntryLocalService = microblogsEntryLocalService;
	}

	/**
	 * Returns the microblogs entry remote service.
	 *
	 * @return the microblogs entry remote service
	 */
	public MicroblogsEntryService getMicroblogsEntryService() {
		return microblogsEntryService;
	}

	/**
	 * Sets the microblogs entry remote service.
	 *
	 * @param microblogsEntryService the microblogs entry remote service
	 */
	public void setMicroblogsEntryService(
		MicroblogsEntryService microblogsEntryService) {
		this.microblogsEntryService = microblogsEntryService;
	}

	/**
	 * Returns the microblogs entry persistence.
	 *
	 * @return the microblogs entry persistence
	 */
	public MicroblogsEntryPersistence getMicroblogsEntryPersistence() {
		return microblogsEntryPersistence;
	}

	/**
	 * Sets the microblogs entry persistence.
	 *
	 * @param microblogsEntryPersistence the microblogs entry persistence
	 */
	public void setMicroblogsEntryPersistence(
		MicroblogsEntryPersistence microblogsEntryPersistence) {
		this.microblogsEntryPersistence = microblogsEntryPersistence;
	}

	/**
	 * Returns the microblogs entry finder.
	 *
	 * @return the microblogs entry finder
	 */
	public MicroblogsEntryFinder getMicroblogsEntryFinder() {
		return microblogsEntryFinder;
	}

	/**
	 * Sets the microblogs entry finder.
	 *
	 * @param microblogsEntryFinder the microblogs entry finder
	 */
	public void setMicroblogsEntryFinder(
		MicroblogsEntryFinder microblogsEntryFinder) {
		this.microblogsEntryFinder = microblogsEntryFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.microblogs.model.MicroblogsEntry",
			microblogsEntryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.microblogs.model.MicroblogsEntry");
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

	protected ClassLoader getClassLoader() {
		Class<?> clazz = getClass();

		return clazz.getClassLoader();
	}

	protected Class<?> getModelClass() {
		return MicroblogsEntry.class;
	}

	protected String getModelClassName() {
		return MicroblogsEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = microblogsEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = MicroblogsEntryLocalService.class)
	protected MicroblogsEntryLocalService microblogsEntryLocalService;
	@BeanReference(type = MicroblogsEntryService.class)
	protected MicroblogsEntryService microblogsEntryService;
	@BeanReference(type = MicroblogsEntryPersistence.class)
	protected MicroblogsEntryPersistence microblogsEntryPersistence;
	@BeanReference(type = MicroblogsEntryFinder.class)
	protected MicroblogsEntryFinder microblogsEntryFinder;
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
}