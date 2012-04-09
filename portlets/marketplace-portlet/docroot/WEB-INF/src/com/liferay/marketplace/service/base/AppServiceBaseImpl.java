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

package com.liferay.marketplace.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.marketplace.model.App;
import com.liferay.marketplace.service.AppLocalService;
import com.liferay.marketplace.service.AppService;
import com.liferay.marketplace.service.ModuleLocalService;
import com.liferay.marketplace.service.persistence.AppPersistence;
import com.liferay.marketplace.service.persistence.ModulePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the app remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.marketplace.service.impl.AppServiceImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see com.liferay.marketplace.service.impl.AppServiceImpl
 * @see com.liferay.marketplace.service.AppServiceUtil
 * @generated
 */
public abstract class AppServiceBaseImpl extends PrincipalBean
	implements AppService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.marketplace.service.AppServiceUtil} to access the app remote service.
	 */

	/**
	 * Returns the app local service.
	 *
	 * @return the app local service
	 */
	public AppLocalService getAppLocalService() {
		return appLocalService;
	}

	/**
	 * Sets the app local service.
	 *
	 * @param appLocalService the app local service
	 */
	public void setAppLocalService(AppLocalService appLocalService) {
		this.appLocalService = appLocalService;
	}

	/**
	 * Returns the app remote service.
	 *
	 * @return the app remote service
	 */
	public AppService getAppService() {
		return appService;
	}

	/**
	 * Sets the app remote service.
	 *
	 * @param appService the app remote service
	 */
	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	/**
	 * Returns the app persistence.
	 *
	 * @return the app persistence
	 */
	public AppPersistence getAppPersistence() {
		return appPersistence;
	}

	/**
	 * Sets the app persistence.
	 *
	 * @param appPersistence the app persistence
	 */
	public void setAppPersistence(AppPersistence appPersistence) {
		this.appPersistence = appPersistence;
	}

	/**
	 * Returns the module local service.
	 *
	 * @return the module local service
	 */
	public ModuleLocalService getModuleLocalService() {
		return moduleLocalService;
	}

	/**
	 * Sets the module local service.
	 *
	 * @param moduleLocalService the module local service
	 */
	public void setModuleLocalService(ModuleLocalService moduleLocalService) {
		this.moduleLocalService = moduleLocalService;
	}

	/**
	 * Returns the module persistence.
	 *
	 * @return the module persistence
	 */
	public ModulePersistence getModulePersistence() {
		return modulePersistence;
	}

	/**
	 * Sets the module persistence.
	 *
	 * @param modulePersistence the module persistence
	 */
	public void setModulePersistence(ModulePersistence modulePersistence) {
		this.modulePersistence = modulePersistence;
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

	protected ClassLoader getClassLoader() {
		Class<?> clazz = getClass();

		return clazz.getClassLoader();
	}

	protected Class<?> getModelClass() {
		return App.class;
	}

	protected String getModelClassName() {
		return App.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = appPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AppLocalService.class)
	protected AppLocalService appLocalService;
	@BeanReference(type = AppService.class)
	protected AppService appService;
	@BeanReference(type = AppPersistence.class)
	protected AppPersistence appPersistence;
	@BeanReference(type = ModuleLocalService.class)
	protected ModuleLocalService moduleLocalService;
	@BeanReference(type = ModulePersistence.class)
	protected ModulePersistence modulePersistence;
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