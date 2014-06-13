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

package com.liferay.testblob.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.testblob.model.TestBlobEntry;

import java.util.List;

/**
 * The persistence utility for the test blob entry service. This utility wraps {@link TestBlobEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestBlobEntryPersistence
 * @see TestBlobEntryPersistenceImpl
 * @generated
 */
public class TestBlobEntryUtil {
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
	public static void clearCache(TestBlobEntry testBlobEntry) {
		getPersistence().clearCache(testBlobEntry);
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
	public static List<TestBlobEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TestBlobEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TestBlobEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TestBlobEntry update(TestBlobEntry testBlobEntry) {
		return getPersistence().update(testBlobEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TestBlobEntry update(TestBlobEntry testBlobEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(testBlobEntry, serviceContext);
	}

	/**
	* Returns all the test blob entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching test blob entries
	*/
	public static java.util.List<com.liferay.testblob.model.TestBlobEntry> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the test blob entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.testblob.model.impl.TestBlobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of test blob entries
	* @param end the upper bound of the range of test blob entries (not inclusive)
	* @return the range of matching test blob entries
	*/
	public static java.util.List<com.liferay.testblob.model.TestBlobEntry> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the test blob entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.testblob.model.impl.TestBlobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of test blob entries
	* @param end the upper bound of the range of test blob entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching test blob entries
	*/
	public static java.util.List<com.liferay.testblob.model.TestBlobEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first test blob entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching test blob entry
	* @throws com.liferay.testblob.NoSuchEntryException if a matching test blob entry could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.testblob.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first test blob entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching test blob entry, or <code>null</code> if a matching test blob entry could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last test blob entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching test blob entry
	* @throws com.liferay.testblob.NoSuchEntryException if a matching test blob entry could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.testblob.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last test blob entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching test blob entry, or <code>null</code> if a matching test blob entry could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the test blob entries before and after the current test blob entry in the ordered set where uuid = &#63;.
	*
	* @param testBlobEntryId the primary key of the current test blob entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next test blob entry
	* @throws com.liferay.testblob.NoSuchEntryException if a test blob entry with the primary key could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry[] findByUuid_PrevAndNext(
		long testBlobEntryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.testblob.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(testBlobEntryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the test blob entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of test blob entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching test blob entries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the test blob entry in the entity cache if it is enabled.
	*
	* @param testBlobEntry the test blob entry
	*/
	public static void cacheResult(
		com.liferay.testblob.model.TestBlobEntry testBlobEntry) {
		getPersistence().cacheResult(testBlobEntry);
	}

	/**
	* Caches the test blob entries in the entity cache if it is enabled.
	*
	* @param testBlobEntries the test blob entries
	*/
	public static void cacheResult(
		java.util.List<com.liferay.testblob.model.TestBlobEntry> testBlobEntries) {
		getPersistence().cacheResult(testBlobEntries);
	}

	/**
	* Creates a new test blob entry with the primary key. Does not add the test blob entry to the database.
	*
	* @param testBlobEntryId the primary key for the new test blob entry
	* @return the new test blob entry
	*/
	public static com.liferay.testblob.model.TestBlobEntry create(
		long testBlobEntryId) {
		return getPersistence().create(testBlobEntryId);
	}

	/**
	* Removes the test blob entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testBlobEntryId the primary key of the test blob entry
	* @return the test blob entry that was removed
	* @throws com.liferay.testblob.NoSuchEntryException if a test blob entry with the primary key could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry remove(
		long testBlobEntryId) throws com.liferay.testblob.NoSuchEntryException {
		return getPersistence().remove(testBlobEntryId);
	}

	public static com.liferay.testblob.model.TestBlobEntry updateImpl(
		com.liferay.testblob.model.TestBlobEntry testBlobEntry) {
		return getPersistence().updateImpl(testBlobEntry);
	}

	/**
	* Returns the test blob entry with the primary key or throws a {@link com.liferay.testblob.NoSuchEntryException} if it could not be found.
	*
	* @param testBlobEntryId the primary key of the test blob entry
	* @return the test blob entry
	* @throws com.liferay.testblob.NoSuchEntryException if a test blob entry with the primary key could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry findByPrimaryKey(
		long testBlobEntryId) throws com.liferay.testblob.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(testBlobEntryId);
	}

	/**
	* Returns the test blob entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testBlobEntryId the primary key of the test blob entry
	* @return the test blob entry, or <code>null</code> if a test blob entry with the primary key could not be found
	*/
	public static com.liferay.testblob.model.TestBlobEntry fetchByPrimaryKey(
		long testBlobEntryId) {
		return getPersistence().fetchByPrimaryKey(testBlobEntryId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.testblob.model.TestBlobEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the test blob entries.
	*
	* @return the test blob entries
	*/
	public static java.util.List<com.liferay.testblob.model.TestBlobEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the test blob entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.testblob.model.impl.TestBlobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test blob entries
	* @param end the upper bound of the range of test blob entries (not inclusive)
	* @return the range of test blob entries
	*/
	public static java.util.List<com.liferay.testblob.model.TestBlobEntry> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the test blob entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.testblob.model.impl.TestBlobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test blob entries
	* @param end the upper bound of the range of test blob entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of test blob entries
	*/
	public static java.util.List<com.liferay.testblob.model.TestBlobEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the test blob entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of test blob entries.
	*
	* @return the number of test blob entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TestBlobEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TestBlobEntryPersistence)PortletBeanLocatorUtil.locate(com.liferay.testblob.service.ClpSerializer.getServletContextName(),
					TestBlobEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(TestBlobEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(TestBlobEntryPersistence persistence) {
	}

	private static TestBlobEntryPersistence _persistence;
}