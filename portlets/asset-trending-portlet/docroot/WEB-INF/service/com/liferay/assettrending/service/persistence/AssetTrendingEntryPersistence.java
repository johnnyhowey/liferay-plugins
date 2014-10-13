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

package com.liferay.assettrending.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.assettrending.model.AssetTrendingEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the asset trending entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntryPersistenceImpl
 * @see AssetTrendingEntryUtil
 * @generated
 */
@ProviderType
public interface AssetTrendingEntryPersistence extends BasePersistence<AssetTrendingEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssetTrendingEntryUtil} to access the asset trending entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the asset trending entry where assetEntryId = &#63; or throws a {@link com.liferay.assettrending.NoSuchEntryException} if it could not be found.
	*
	* @param assetEntryId the asset entry ID
	* @return the matching asset trending entry
	* @throws com.liferay.assettrending.NoSuchEntryException if a matching asset trending entry could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry findByAssetEntryId(
		long assetEntryId)
		throws com.liferay.assettrending.NoSuchEntryException;

	/**
	* Returns the asset trending entry where assetEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assetEntryId the asset entry ID
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry fetchByAssetEntryId(
		long assetEntryId);

	/**
	* Returns the asset trending entry where assetEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assetEntryId the asset entry ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry fetchByAssetEntryId(
		long assetEntryId, boolean retrieveFromCache);

	/**
	* Removes the asset trending entry where assetEntryId = &#63; from the database.
	*
	* @param assetEntryId the asset entry ID
	* @return the asset trending entry that was removed
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry removeByAssetEntryId(
		long assetEntryId)
		throws com.liferay.assettrending.NoSuchEntryException;

	/**
	* Returns the number of asset trending entries where assetEntryId = &#63;.
	*
	* @param assetEntryId the asset entry ID
	* @return the number of matching asset trending entries
	*/
	public int countByAssetEntryId(long assetEntryId);

	/**
	* Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.assettrending.NoSuchEntryException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching asset trending entry
	* @throws com.liferay.assettrending.NoSuchEntryException if a matching asset trending entry could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry findByC_C(
		long classNameId, long classPK)
		throws com.liferay.assettrending.NoSuchEntryException;

	/**
	* Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry fetchByC_C(
		long classNameId, long classPK);

	/**
	* Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry fetchByC_C(
		long classNameId, long classPK, boolean retrieveFromCache);

	/**
	* Removes the asset trending entry where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the asset trending entry that was removed
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry removeByC_C(
		long classNameId, long classPK)
		throws com.liferay.assettrending.NoSuchEntryException;

	/**
	* Returns the number of asset trending entries where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching asset trending entries
	*/
	public int countByC_C(long classNameId, long classPK);

	/**
	* Caches the asset trending entry in the entity cache if it is enabled.
	*
	* @param assetTrendingEntry the asset trending entry
	*/
	public void cacheResult(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry);

	/**
	* Caches the asset trending entries in the entity cache if it is enabled.
	*
	* @param assetTrendingEntries the asset trending entries
	*/
	public void cacheResult(
		java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> assetTrendingEntries);

	/**
	* Creates a new asset trending entry with the primary key. Does not add the asset trending entry to the database.
	*
	* @param assetTrendingEntryId the primary key for the new asset trending entry
	* @return the new asset trending entry
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry create(
		long assetTrendingEntryId);

	/**
	* Removes the asset trending entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry that was removed
	* @throws com.liferay.assettrending.NoSuchEntryException if a asset trending entry with the primary key could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry remove(
		long assetTrendingEntryId)
		throws com.liferay.assettrending.NoSuchEntryException;

	public com.liferay.assettrending.model.AssetTrendingEntry updateImpl(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry);

	/**
	* Returns the asset trending entry with the primary key or throws a {@link com.liferay.assettrending.NoSuchEntryException} if it could not be found.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry
	* @throws com.liferay.assettrending.NoSuchEntryException if a asset trending entry with the primary key could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry findByPrimaryKey(
		long assetTrendingEntryId)
		throws com.liferay.assettrending.NoSuchEntryException;

	/**
	* Returns the asset trending entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assetTrendingEntryId the primary key of the asset trending entry
	* @return the asset trending entry, or <code>null</code> if a asset trending entry with the primary key could not be found
	*/
	public com.liferay.assettrending.model.AssetTrendingEntry fetchByPrimaryKey(
		long assetTrendingEntryId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.assettrending.model.AssetTrendingEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the asset trending entries.
	*
	* @return the asset trending entries
	*/
	public java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> findAll();

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
	public java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> findAll(
		int start, int end);

	/**
	* Returns an ordered range of all the asset trending entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.assettrending.model.impl.AssetTrendingEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset trending entries
	* @param end the upper bound of the range of asset trending entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of asset trending entries
	*/
	public java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.assettrending.model.AssetTrendingEntry> orderByComparator);

	/**
	* Removes all the asset trending entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of asset trending entries.
	*
	* @return the number of asset trending entries
	*/
	public int countAll();
}