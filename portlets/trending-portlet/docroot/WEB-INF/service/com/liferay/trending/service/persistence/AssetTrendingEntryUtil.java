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

package com.liferay.trending.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.trending.model.AssetTrendingEntry;

import java.util.List;

/**
 * The persistence utility for the asset trending entry service. This utility wraps {@link AssetTrendingEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntryPersistence
 * @see AssetTrendingEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class AssetTrendingEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AssetTrendingEntry assetTrendingEntry) {
		getPersistence().clearCache(assetTrendingEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AssetTrendingEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AssetTrendingEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AssetTrendingEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AssetTrendingEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AssetTrendingEntry update(
		AssetTrendingEntry assetTrendingEntry) {
		return getPersistence().update(assetTrendingEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AssetTrendingEntry update(
		AssetTrendingEntry assetTrendingEntry, ServiceContext serviceContext) {
		return getPersistence().update(assetTrendingEntry, serviceContext);
	}

	/**
	* Returns the asset trending entry where assetEntryId = &#63; or throws a {@link com.liferay.trending.NoSuchAssetTrendingEntryException} if it could not be found.
	*
	* @param assetEntryId the asset entry ID
	* @return the matching asset trending entry
	* @throws com.liferay.trending.NoSuchAssetTrendingEntryException if a matching asset trending entry could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry findByAssetEntryId(
		long assetEntryId)
		throws com.liferay.trending.NoSuchAssetTrendingEntryException {
		return getPersistence().findByAssetEntryId(assetEntryId);
	}

	/**
	* Returns the asset trending entry where assetEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assetEntryId the asset entry ID
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry fetchByAssetEntryId(
		long assetEntryId) {
		return getPersistence().fetchByAssetEntryId(assetEntryId);
	}

	/**
	* Returns the asset trending entry where assetEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assetEntryId the asset entry ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry fetchByAssetEntryId(
		long assetEntryId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByAssetEntryId(assetEntryId, retrieveFromCache);
	}

	/**
	* Removes the asset trending entry where assetEntryId = &#63; from the database.
	*
	* @param assetEntryId the asset entry ID
	* @return the asset trending entry that was removed
	*/
	public static com.liferay.trending.model.AssetTrendingEntry removeByAssetEntryId(
		long assetEntryId)
		throws com.liferay.trending.NoSuchAssetTrendingEntryException {
		return getPersistence().removeByAssetEntryId(assetEntryId);
	}

	/**
	* Returns the number of asset trending entries where assetEntryId = &#63;.
	*
	* @param assetEntryId the asset entry ID
	* @return the number of matching asset trending entries
	*/
	public static int countByAssetEntryId(long assetEntryId) {
		return getPersistence().countByAssetEntryId(assetEntryId);
	}

	/**
	* Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.trending.NoSuchAssetTrendingEntryException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching asset trending entry
	* @throws com.liferay.trending.NoSuchAssetTrendingEntryException if a matching asset trending entry could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry findByC_C(
		long classNameId, long classPK)
		throws com.liferay.trending.NoSuchAssetTrendingEntryException {
		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	* Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry fetchByC_C(
		long classNameId, long classPK) {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	* Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry fetchByC_C(
		long classNameId, long classPK, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_C(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Removes the asset trending entry where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the asset trending entry that was removed
	*/
	public static com.liferay.trending.model.AssetTrendingEntry removeByC_C(
		long classNameId, long classPK)
		throws com.liferay.trending.NoSuchAssetTrendingEntryException {
		return getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	* Returns the number of asset trending entries where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching asset trending entries
	*/
	public static int countByC_C(long classNameId, long classPK) {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	* Caches the asset trending entry in the entity cache if it is enabled.
	*
	* @param assetTrendingEntry the asset trending entry
	*/
	public static void cacheResult(
		com.liferay.trending.model.AssetTrendingEntry assetTrendingEntry) {
		getPersistence().cacheResult(assetTrendingEntry);
	}

	/**
	* Caches the asset trending entries in the entity cache if it is enabled.
	*
	* @param assetTrendingEntries the asset trending entries
	*/
	public static void cacheResult(
		java.util.List<com.liferay.trending.model.AssetTrendingEntry> assetTrendingEntries) {
		getPersistence().cacheResult(assetTrendingEntries);
	}

	/**
	* Creates a new asset trending entry with the primary key. Does not add the asset trending entry to the database.
	*
	* @param assetTrendingEntryId the primary key for the new asset trending entry
	* @return the new asset trending entry
	*/
	public static com.liferay.trending.model.AssetTrendingEntry create(
		long assetTrendingEntryId) {
		return getPersistence().create(assetTrendingEntryId);
	}

	/**
	* Removes the asset trending entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry that was removed
	* @throws com.liferay.trending.NoSuchAssetTrendingEntryException if a asset trending entry with the primary key could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry remove(
		long assetTrendingEntryId)
		throws com.liferay.trending.NoSuchAssetTrendingEntryException {
		return getPersistence().remove(assetTrendingEntryId);
	}

	public static com.liferay.trending.model.AssetTrendingEntry updateImpl(
		com.liferay.trending.model.AssetTrendingEntry assetTrendingEntry) {
		return getPersistence().updateImpl(assetTrendingEntry);
	}

	/**
	* Returns the asset trending entry with the primary key or throws a {@link com.liferay.trending.NoSuchAssetTrendingEntryException} if it could not be found.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry
	* @throws com.liferay.trending.NoSuchAssetTrendingEntryException if a asset trending entry with the primary key could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry findByPrimaryKey(
		long assetTrendingEntryId)
		throws com.liferay.trending.NoSuchAssetTrendingEntryException {
		return getPersistence().findByPrimaryKey(assetTrendingEntryId);
	}

	/**
	* Returns the asset trending entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry, or <code>null</code> if a asset trending entry with the primary key could not be found
	*/
	public static com.liferay.trending.model.AssetTrendingEntry fetchByPrimaryKey(
		long assetTrendingEntryId) {
		return getPersistence().fetchByPrimaryKey(assetTrendingEntryId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.trending.model.AssetTrendingEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the asset trending entries.
	*
	* @return the asset trending entries
	*/
	public static java.util.List<com.liferay.trending.model.AssetTrendingEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the asset trending entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.trending.model.impl.AssetTrendingEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset trending entries
	* @param end the upper bound of the range of asset trending entries (not inclusive)
	* @return the range of asset trending entries
	*/
	public static java.util.List<com.liferay.trending.model.AssetTrendingEntry> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the asset trending entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.trending.model.impl.AssetTrendingEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset trending entries
	* @param end the upper bound of the range of asset trending entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of asset trending entries
	*/
	public static java.util.List<com.liferay.trending.model.AssetTrendingEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.trending.model.AssetTrendingEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the asset trending entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of asset trending entries.
	*
	* @return the number of asset trending entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AssetTrendingEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AssetTrendingEntryPersistence)PortletBeanLocatorUtil.locate(com.liferay.trending.service.ClpSerializer.getServletContextName(),
					AssetTrendingEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(AssetTrendingEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(AssetTrendingEntryPersistence persistence) {
	}

	private static AssetTrendingEntryPersistence _persistence;
}