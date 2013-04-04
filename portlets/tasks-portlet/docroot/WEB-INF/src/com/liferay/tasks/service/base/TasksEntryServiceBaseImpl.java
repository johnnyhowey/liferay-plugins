/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.tasks.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.tasks.model.TasksEntry;
import com.liferay.tasks.service.TasksEntryLocalService;
import com.liferay.tasks.service.TasksEntryService;
import com.liferay.tasks.service.persistence.TasksEntryFinder;
import com.liferay.tasks.service.persistence.TasksEntryPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the tasks entry remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.tasks.service.impl.TasksEntryServiceImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see com.liferay.tasks.service.impl.TasksEntryServiceImpl
 * @see com.liferay.tasks.service.TasksEntryServiceUtil
 * @generated
 */
public abstract class TasksEntryServiceBaseImpl extends BaseServiceImpl
	implements TasksEntryService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.tasks.service.TasksEntryServiceUtil} to access the tasks entry remote service.
	 */

	/**
	 * Returns the tasks entry local service.
	 *
	 * @return the tasks entry local service
	 */
	public TasksEntryLocalService getTasksEntryLocalService() {
		return tasksEntryLocalService;
	}

	/**
	 * Sets the tasks entry local service.
	 *
	 * @param tasksEntryLocalService the tasks entry local service
	 */
	public void setTasksEntryLocalService(
		TasksEntryLocalService tasksEntryLocalService) {
		this.tasksEntryLocalService = tasksEntryLocalService;
	}

	/**
	 * Returns the tasks entry remote service.
	 *
	 * @return the tasks entry remote service
	 */
	public TasksEntryService getTasksEntryService() {
		return tasksEntryService;
	}

	/**
	 * Sets the tasks entry remote service.
	 *
	 * @param tasksEntryService the tasks entry remote service
	 */
	public void setTasksEntryService(TasksEntryService tasksEntryService) {
		this.tasksEntryService = tasksEntryService;
	}

	/**
	 * Returns the tasks entry persistence.
	 *
	 * @return the tasks entry persistence
	 */
	public TasksEntryPersistence getTasksEntryPersistence() {
		return tasksEntryPersistence;
	}

	/**
	 * Sets the tasks entry persistence.
	 *
	 * @param tasksEntryPersistence the tasks entry persistence
	 */
	public void setTasksEntryPersistence(
		TasksEntryPersistence tasksEntryPersistence) {
		this.tasksEntryPersistence = tasksEntryPersistence;
	}

	/**
	 * Returns the tasks entry finder.
	 *
	 * @return the tasks entry finder
	 */
	public TasksEntryFinder getTasksEntryFinder() {
		return tasksEntryFinder;
	}

	/**
	 * Sets the tasks entry finder.
	 *
	 * @param tasksEntryFinder the tasks entry finder
	 */
	public void setTasksEntryFinder(TasksEntryFinder tasksEntryFinder) {
		this.tasksEntryFinder = tasksEntryFinder;
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
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
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
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
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
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TasksEntry.class;
	}

	protected String getModelClassName() {
		return TasksEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tasksEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = TasksEntryLocalService.class)
	protected TasksEntryLocalService tasksEntryLocalService;
	@BeanReference(type = TasksEntryService.class)
	protected TasksEntryService tasksEntryService;
	@BeanReference(type = TasksEntryPersistence.class)
	protected TasksEntryPersistence tasksEntryPersistence;
	@BeanReference(type = TasksEntryFinder.class)
	protected TasksEntryFinder tasksEntryFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TasksEntryServiceClpInvoker _clpInvoker = new TasksEntryServiceClpInvoker();
}