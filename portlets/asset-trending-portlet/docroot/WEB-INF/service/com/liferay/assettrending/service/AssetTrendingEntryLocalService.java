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

package com.liferay.assettrending.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for AssetTrendingEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntryLocalServiceUtil
 * @see com.liferay.assettrending.service.base.AssetTrendingEntryLocalServiceBaseImpl
 * @see com.liferay.assettrending.service.impl.AssetTrendingEntryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AssetTrendingEntryLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssetTrendingEntryLocalServiceUtil} to access the asset trending entry local service. Add custom service methods to {@link com.liferay.assettrending.service.impl.AssetTrendingEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the asset trending entry to the database. Also notifies the appropriate model listeners.
	*
	* @param assetTrendingEntry the asset trending entry
	* @return the asset trending entry that was added
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.liferay.assettrending.model.AssetTrendingEntry addAssetTrendingEntry(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry);

	public com.liferay.assettrending.model.AssetTrendingEntry addAssetTrendingEntry(
		long groupId, long companyId, java.util.Date createDate,
		java.util.Date modifiedDate, long assetEntryId, long classNameId,
		long classPK, int commentCount, double priority, double ratingScore,
		int viewCount);

	/**
	* Creates a new asset trending entry with the primary key. Does not add the asset trending entry to the database.
	*
	* @param assetTrendingEntryId the primary key for the new asset trending entry
	* @return the new asset trending entry
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry createAssetTrendingEntry(
		long assetTrendingEntryId);

	/**
	* Deletes the asset trending entry from the database. Also notifies the appropriate model listeners.
	*
	* @param assetTrendingEntry the asset trending entry
	* @return the asset trending entry that was removed
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.liferay.assettrending.model.AssetTrendingEntry deleteAssetTrendingEntry(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry);

	/**
	* Deletes the asset trending entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry that was removed
	* @throws PortalException if a asset trending entry with the primary key could not be found
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.liferay.assettrending.model.AssetTrendingEntry deleteAssetTrendingEntry(
		long assetTrendingEntryId)
		throws com.liferay.portal.kernel.exception.PortalException;

	public com.liferay.assettrending.model.AssetTrendingEntry deleteAssetTrendingEntry(
		long classNameId, long classPK);

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.assettrending.model.impl.AssetTrendingEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.assettrending.model.impl.AssetTrendingEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.assettrending.model.AssetTrendingEntry fetchAssetTrendingEntry(
		long assetTrendingEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> getAssetTrendingEntries(
		java.lang.String classNameIds, java.util.Date createDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	* Returns a range of all the asset trending entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.assettrending.model.impl.AssetTrendingEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset trending entries
	* @param end the upper bound of the range of asset trending entries (not inclusive)
	* @return the range of asset trending entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> getAssetTrendingEntries(
		int start, int end);

	/**
	* Returns the number of asset trending entries.
	*
	* @return the number of asset trending entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssetTrendingEntriesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssetTrendingEntriesCount(java.lang.String classNameIds,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	* Returns the asset trending entry with the primary key.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry
	* @throws PortalException if a asset trending entry with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.assettrending.model.AssetTrendingEntry getAssetTrendingEntry(
		long assetTrendingEntryId)
		throws com.liferay.portal.kernel.exception.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.assettrending.model.AssetTrendingEntry getAssetTrendingEntry(
		long classNameId, long classPK);

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException;

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	/**
	* Updates the asset trending entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assetTrendingEntry the asset trending entry
	* @return the asset trending entry that was updated
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.liferay.assettrending.model.AssetTrendingEntry updateAssetTrendingEntry(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry);

	public com.liferay.assettrending.model.AssetTrendingEntry updateAssetTrendingEntry(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry,
		double trendingScore);

	public com.liferay.assettrending.model.AssetTrendingEntry updateAssetTrendingEntry(
		long classNameId, long classPK, double ratingScore);

	public com.liferay.assettrending.model.AssetTrendingEntry updateAssetTrendingEntry(
		long groupId, long companyId, java.util.Date createDate,
		java.util.Date modifiedDate, long assetEntryId, long classNameId,
		long classPK, int commentCount, double priority, double ratingScore,
		int viewCount);
}