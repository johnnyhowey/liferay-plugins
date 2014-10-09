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

package com.liferay.assettrending.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.assettrending.NoSuchEntryException;
import com.liferay.assettrending.model.AssetTrendingEntry;
import com.liferay.assettrending.model.impl.AssetTrendingEntryImpl;
import com.liferay.assettrending.model.impl.AssetTrendingEntryModelImpl;
import com.liferay.assettrending.service.persistence.AssetTrendingEntryPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the asset trending entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntryPersistence
 * @see AssetTrendingEntryUtil
 * @generated
 */
@ProviderType
public class AssetTrendingEntryPersistenceImpl extends BasePersistenceImpl<AssetTrendingEntry>
	implements AssetTrendingEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssetTrendingEntryUtil} to access the asset trending entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssetTrendingEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED,
			AssetTrendingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED,
			AssetTrendingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ASSETENTRYID = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED,
			AssetTrendingEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByAssetEntryId", new String[] { Long.class.getName() },
			AssetTrendingEntryModelImpl.ASSETENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSETENTRYID = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssetEntryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the asset trending entry where assetEntryId = &#63; or throws a {@link com.liferay.assettrending.NoSuchEntryException} if it could not be found.
	 *
	 * @param assetEntryId the asset entry ID
	 * @return the matching asset trending entry
	 * @throws com.liferay.assettrending.NoSuchEntryException if a matching asset trending entry could not be found
	 */
	@Override
	public AssetTrendingEntry findByAssetEntryId(long assetEntryId)
		throws NoSuchEntryException {
		AssetTrendingEntry assetTrendingEntry = fetchByAssetEntryId(assetEntryId);

		if (assetTrendingEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return assetTrendingEntry;
	}

	/**
	 * Returns the asset trending entry where assetEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetEntryId the asset entry ID
	 * @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	 */
	@Override
	public AssetTrendingEntry fetchByAssetEntryId(long assetEntryId) {
		return fetchByAssetEntryId(assetEntryId, true);
	}

	/**
	 * Returns the asset trending entry where assetEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	 */
	@Override
	public AssetTrendingEntry fetchByAssetEntryId(long assetEntryId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { assetEntryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ASSETENTRYID,
					finderArgs, this);
		}

		if (result instanceof AssetTrendingEntry) {
			AssetTrendingEntry assetTrendingEntry = (AssetTrendingEntry)result;

			if ((assetEntryId != assetTrendingEntry.getAssetEntryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ASSETTRENDINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetEntryId);

				List<AssetTrendingEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSETENTRYID,
						finderArgs, list);
				}
				else {
					AssetTrendingEntry assetTrendingEntry = list.get(0);

					result = assetTrendingEntry;

					cacheResult(assetTrendingEntry);

					if ((assetTrendingEntry.getAssetEntryId() != assetEntryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSETENTRYID,
							finderArgs, assetTrendingEntry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSETENTRYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AssetTrendingEntry)result;
		}
	}

	/**
	 * Removes the asset trending entry where assetEntryId = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry ID
	 * @return the asset trending entry that was removed
	 */
	@Override
	public AssetTrendingEntry removeByAssetEntryId(long assetEntryId)
		throws NoSuchEntryException {
		AssetTrendingEntry assetTrendingEntry = findByAssetEntryId(assetEntryId);

		return remove(assetTrendingEntry);
	}

	/**
	 * Returns the number of asset trending entries where assetEntryId = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @return the number of matching asset trending entries
	 */
	@Override
	public int countByAssetEntryId(long assetEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSETENTRYID;

		Object[] finderArgs = new Object[] { assetEntryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSETTRENDINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetEntryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2 = "assetTrendingEntry.assetEntryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED,
			AssetTrendingEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			AssetTrendingEntryModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			AssetTrendingEntryModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.assettrending.NoSuchEntryException} if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching asset trending entry
	 * @throws com.liferay.assettrending.NoSuchEntryException if a matching asset trending entry could not be found
	 */
	@Override
	public AssetTrendingEntry findByC_C(long classNameId, long classPK)
		throws NoSuchEntryException {
		AssetTrendingEntry assetTrendingEntry = fetchByC_C(classNameId, classPK);

		if (assetTrendingEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return assetTrendingEntry;
	}

	/**
	 * Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	 */
	@Override
	public AssetTrendingEntry fetchByC_C(long classNameId, long classPK) {
		return fetchByC_C(classNameId, classPK, true);
	}

	/**
	 * Returns the asset trending entry where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching asset trending entry, or <code>null</code> if a matching asset trending entry could not be found
	 */
	@Override
	public AssetTrendingEntry fetchByC_C(long classNameId, long classPK,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C,
					finderArgs, this);
		}

		if (result instanceof AssetTrendingEntry) {
			AssetTrendingEntry assetTrendingEntry = (AssetTrendingEntry)result;

			if ((classNameId != assetTrendingEntry.getClassNameId()) ||
					(classPK != assetTrendingEntry.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ASSETTRENDINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<AssetTrendingEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
						finderArgs, list);
				}
				else {
					AssetTrendingEntry assetTrendingEntry = list.get(0);

					result = assetTrendingEntry;

					cacheResult(assetTrendingEntry);

					if ((assetTrendingEntry.getClassNameId() != classNameId) ||
							(assetTrendingEntry.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
							finderArgs, assetTrendingEntry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AssetTrendingEntry)result;
		}
	}

	/**
	 * Removes the asset trending entry where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the asset trending entry that was removed
	 */
	@Override
	public AssetTrendingEntry removeByC_C(long classNameId, long classPK)
		throws NoSuchEntryException {
		AssetTrendingEntry assetTrendingEntry = findByC_C(classNameId, classPK);

		return remove(assetTrendingEntry);
	}

	/**
	 * Returns the number of asset trending entries where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching asset trending entries
	 */
	@Override
	public int countByC_C(long classNameId, long classPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSETTRENDINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "assetTrendingEntry.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 = "assetTrendingEntry.classPK = ?";

	public AssetTrendingEntryPersistenceImpl() {
		setModelClass(AssetTrendingEntry.class);
	}

	/**
	 * Caches the asset trending entry in the entity cache if it is enabled.
	 *
	 * @param assetTrendingEntry the asset trending entry
	 */
	@Override
	public void cacheResult(AssetTrendingEntry assetTrendingEntry) {
		EntityCacheUtil.putResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryImpl.class, assetTrendingEntry.getPrimaryKey(),
			assetTrendingEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSETENTRYID,
			new Object[] { assetTrendingEntry.getAssetEntryId() },
			assetTrendingEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
			new Object[] {
				assetTrendingEntry.getClassNameId(),
				assetTrendingEntry.getClassPK()
			}, assetTrendingEntry);

		assetTrendingEntry.resetOriginalValues();
	}

	/**
	 * Caches the asset trending entries in the entity cache if it is enabled.
	 *
	 * @param assetTrendingEntries the asset trending entries
	 */
	@Override
	public void cacheResult(List<AssetTrendingEntry> assetTrendingEntries) {
		for (AssetTrendingEntry assetTrendingEntry : assetTrendingEntries) {
			if (EntityCacheUtil.getResult(
						AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
						AssetTrendingEntryImpl.class,
						assetTrendingEntry.getPrimaryKey()) == null) {
				cacheResult(assetTrendingEntry);
			}
			else {
				assetTrendingEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all asset trending entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AssetTrendingEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AssetTrendingEntryImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the asset trending entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AssetTrendingEntry assetTrendingEntry) {
		EntityCacheUtil.removeResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryImpl.class, assetTrendingEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(assetTrendingEntry);
	}

	@Override
	public void clearCache(List<AssetTrendingEntry> assetTrendingEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AssetTrendingEntry assetTrendingEntry : assetTrendingEntries) {
			EntityCacheUtil.removeResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
				AssetTrendingEntryImpl.class, assetTrendingEntry.getPrimaryKey());

			clearUniqueFindersCache(assetTrendingEntry);
		}
	}

	protected void cacheUniqueFindersCache(
		AssetTrendingEntry assetTrendingEntry) {
		if (assetTrendingEntry.isNew()) {
			Object[] args = new Object[] { assetTrendingEntry.getAssetEntryId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSETENTRYID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSETENTRYID, args,
				assetTrendingEntry);

			args = new Object[] {
					assetTrendingEntry.getClassNameId(),
					assetTrendingEntry.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C, args,
				assetTrendingEntry);
		}
		else {
			AssetTrendingEntryModelImpl assetTrendingEntryModelImpl = (AssetTrendingEntryModelImpl)assetTrendingEntry;

			if ((assetTrendingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ASSETENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assetTrendingEntry.getAssetEntryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSETENTRYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSETENTRYID,
					args, assetTrendingEntry);
			}

			if ((assetTrendingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assetTrendingEntry.getClassNameId(),
						assetTrendingEntry.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C, args,
					assetTrendingEntry);
			}
		}
	}

	protected void clearUniqueFindersCache(
		AssetTrendingEntry assetTrendingEntry) {
		AssetTrendingEntryModelImpl assetTrendingEntryModelImpl = (AssetTrendingEntryModelImpl)assetTrendingEntry;

		Object[] args = new Object[] { assetTrendingEntry.getAssetEntryId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSETENTRYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSETENTRYID, args);

		if ((assetTrendingEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ASSETENTRYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					assetTrendingEntryModelImpl.getOriginalAssetEntryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSETENTRYID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSETENTRYID, args);
		}

		args = new Object[] {
				assetTrendingEntry.getClassNameId(),
				assetTrendingEntry.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C, args);

		if ((assetTrendingEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					assetTrendingEntryModelImpl.getOriginalClassNameId(),
					assetTrendingEntryModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C, args);
		}
	}

	/**
	 * Creates a new asset trending entry with the primary key. Does not add the asset trending entry to the database.
	 *
	 * @param assetTrendingEntryId the primary key for the new asset trending entry
	 * @return the new asset trending entry
	 */
	@Override
	public AssetTrendingEntry create(long assetTrendingEntryId) {
		AssetTrendingEntry assetTrendingEntry = new AssetTrendingEntryImpl();

		assetTrendingEntry.setNew(true);
		assetTrendingEntry.setPrimaryKey(assetTrendingEntryId);

		return assetTrendingEntry;
	}

	/**
	 * Removes the asset trending entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetTrendingEntryId the primary key of the asset trending entry
	 * @return the asset trending entry that was removed
	 * @throws com.liferay.assettrending.NoSuchEntryException if a asset trending entry with the primary key could not be found
	 */
	@Override
	public AssetTrendingEntry remove(long assetTrendingEntryId)
		throws NoSuchEntryException {
		return remove((Serializable)assetTrendingEntryId);
	}

	/**
	 * Removes the asset trending entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the asset trending entry
	 * @return the asset trending entry that was removed
	 * @throws com.liferay.assettrending.NoSuchEntryException if a asset trending entry with the primary key could not be found
	 */
	@Override
	public AssetTrendingEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {
		Session session = null;

		try {
			session = openSession();

			AssetTrendingEntry assetTrendingEntry = (AssetTrendingEntry)session.get(AssetTrendingEntryImpl.class,
					primaryKey);

			if (assetTrendingEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(assetTrendingEntry);
		}
		catch (NoSuchEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AssetTrendingEntry removeImpl(
		AssetTrendingEntry assetTrendingEntry) {
		assetTrendingEntry = toUnwrappedModel(assetTrendingEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(assetTrendingEntry)) {
				assetTrendingEntry = (AssetTrendingEntry)session.get(AssetTrendingEntryImpl.class,
						assetTrendingEntry.getPrimaryKeyObj());
			}

			if (assetTrendingEntry != null) {
				session.delete(assetTrendingEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (assetTrendingEntry != null) {
			clearCache(assetTrendingEntry);
		}

		return assetTrendingEntry;
	}

	@Override
	public AssetTrendingEntry updateImpl(
		com.liferay.assettrending.model.AssetTrendingEntry assetTrendingEntry) {
		assetTrendingEntry = toUnwrappedModel(assetTrendingEntry);

		boolean isNew = assetTrendingEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (assetTrendingEntry.isNew()) {
				session.save(assetTrendingEntry);

				assetTrendingEntry.setNew(false);
			}
			else {
				session.merge(assetTrendingEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AssetTrendingEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
			AssetTrendingEntryImpl.class, assetTrendingEntry.getPrimaryKey(),
			assetTrendingEntry, false);

		clearUniqueFindersCache(assetTrendingEntry);
		cacheUniqueFindersCache(assetTrendingEntry);

		assetTrendingEntry.resetOriginalValues();

		return assetTrendingEntry;
	}

	protected AssetTrendingEntry toUnwrappedModel(
		AssetTrendingEntry assetTrendingEntry) {
		if (assetTrendingEntry instanceof AssetTrendingEntryImpl) {
			return assetTrendingEntry;
		}

		AssetTrendingEntryImpl assetTrendingEntryImpl = new AssetTrendingEntryImpl();

		assetTrendingEntryImpl.setNew(assetTrendingEntry.isNew());
		assetTrendingEntryImpl.setPrimaryKey(assetTrendingEntry.getPrimaryKey());

		assetTrendingEntryImpl.setAssetTrendingEntryId(assetTrendingEntry.getAssetTrendingEntryId());
		assetTrendingEntryImpl.setGroupId(assetTrendingEntry.getGroupId());
		assetTrendingEntryImpl.setCompanyId(assetTrendingEntry.getCompanyId());
		assetTrendingEntryImpl.setCreateDate(assetTrendingEntry.getCreateDate());
		assetTrendingEntryImpl.setModifiedDate(assetTrendingEntry.getModifiedDate());
		assetTrendingEntryImpl.setAssetEntryId(assetTrendingEntry.getAssetEntryId());
		assetTrendingEntryImpl.setClassNameId(assetTrendingEntry.getClassNameId());
		assetTrendingEntryImpl.setClassPK(assetTrendingEntry.getClassPK());
		assetTrendingEntryImpl.setCommentCount(assetTrendingEntry.getCommentCount());
		assetTrendingEntryImpl.setPayload(assetTrendingEntry.getPayload());
		assetTrendingEntryImpl.setPriority(assetTrendingEntry.getPriority());
		assetTrendingEntryImpl.setRatingScore(assetTrendingEntry.getRatingScore());
		assetTrendingEntryImpl.setTrendingScore(assetTrendingEntry.getTrendingScore());
		assetTrendingEntryImpl.setViewCount(assetTrendingEntry.getViewCount());

		return assetTrendingEntryImpl;
	}

	/**
	 * Returns the asset trending entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the asset trending entry
	 * @return the asset trending entry
	 * @throws com.liferay.assettrending.NoSuchEntryException if a asset trending entry with the primary key could not be found
	 */
	@Override
	public AssetTrendingEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {
		AssetTrendingEntry assetTrendingEntry = fetchByPrimaryKey(primaryKey);

		if (assetTrendingEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return assetTrendingEntry;
	}

	/**
	 * Returns the asset trending entry with the primary key or throws a {@link com.liferay.assettrending.NoSuchEntryException} if it could not be found.
	 *
	 * @param assetTrendingEntryId the primary key of the asset trending entry
	 * @return the asset trending entry
	 * @throws com.liferay.assettrending.NoSuchEntryException if a asset trending entry with the primary key could not be found
	 */
	@Override
	public AssetTrendingEntry findByPrimaryKey(long assetTrendingEntryId)
		throws NoSuchEntryException {
		return findByPrimaryKey((Serializable)assetTrendingEntryId);
	}

	/**
	 * Returns the asset trending entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the asset trending entry
	 * @return the asset trending entry, or <code>null</code> if a asset trending entry with the primary key could not be found
	 */
	@Override
	public AssetTrendingEntry fetchByPrimaryKey(Serializable primaryKey) {
		AssetTrendingEntry assetTrendingEntry = (AssetTrendingEntry)EntityCacheUtil.getResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
				AssetTrendingEntryImpl.class, primaryKey);

		if (assetTrendingEntry == _nullAssetTrendingEntry) {
			return null;
		}

		if (assetTrendingEntry == null) {
			Session session = null;

			try {
				session = openSession();

				assetTrendingEntry = (AssetTrendingEntry)session.get(AssetTrendingEntryImpl.class,
						primaryKey);

				if (assetTrendingEntry != null) {
					cacheResult(assetTrendingEntry);
				}
				else {
					EntityCacheUtil.putResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
						AssetTrendingEntryImpl.class, primaryKey,
						_nullAssetTrendingEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
					AssetTrendingEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return assetTrendingEntry;
	}

	/**
	 * Returns the asset trending entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assetTrendingEntryId the primary key of the asset trending entry
	 * @return the asset trending entry, or <code>null</code> if a asset trending entry with the primary key could not be found
	 */
	@Override
	public AssetTrendingEntry fetchByPrimaryKey(long assetTrendingEntryId) {
		return fetchByPrimaryKey((Serializable)assetTrendingEntryId);
	}

	@Override
	public Map<Serializable, AssetTrendingEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AssetTrendingEntry> map = new HashMap<Serializable, AssetTrendingEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AssetTrendingEntry assetTrendingEntry = fetchByPrimaryKey(primaryKey);

			if (assetTrendingEntry != null) {
				map.put(primaryKey, assetTrendingEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AssetTrendingEntry assetTrendingEntry = (AssetTrendingEntry)EntityCacheUtil.getResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
					AssetTrendingEntryImpl.class, primaryKey);

			if (assetTrendingEntry == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, assetTrendingEntry);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ASSETTRENDINGENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AssetTrendingEntry assetTrendingEntry : (List<AssetTrendingEntry>)q.list()) {
				map.put(assetTrendingEntry.getPrimaryKeyObj(),
					assetTrendingEntry);

				cacheResult(assetTrendingEntry);

				uncachedPrimaryKeys.remove(assetTrendingEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(AssetTrendingEntryModelImpl.ENTITY_CACHE_ENABLED,
					AssetTrendingEntryImpl.class, primaryKey,
					_nullAssetTrendingEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the asset trending entries.
	 *
	 * @return the asset trending entries
	 */
	@Override
	public List<AssetTrendingEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<AssetTrendingEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<AssetTrendingEntry> findAll(int start, int end,
		OrderByComparator<AssetTrendingEntry> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AssetTrendingEntry> list = (List<AssetTrendingEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSETTRENDINGENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSETTRENDINGENTRY;

				if (pagination) {
					sql = sql.concat(AssetTrendingEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AssetTrendingEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AssetTrendingEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the asset trending entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AssetTrendingEntry assetTrendingEntry : findAll()) {
			remove(assetTrendingEntry);
		}
	}

	/**
	 * Returns the number of asset trending entries.
	 *
	 * @return the number of asset trending entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ASSETTRENDINGENTRY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the asset trending entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AssetTrendingEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASSETTRENDINGENTRY = "SELECT assetTrendingEntry FROM AssetTrendingEntry assetTrendingEntry";
	private static final String _SQL_SELECT_ASSETTRENDINGENTRY_WHERE_PKS_IN = "SELECT assetTrendingEntry FROM AssetTrendingEntry assetTrendingEntry WHERE assetTrendingEntryId IN (";
	private static final String _SQL_SELECT_ASSETTRENDINGENTRY_WHERE = "SELECT assetTrendingEntry FROM AssetTrendingEntry assetTrendingEntry WHERE ";
	private static final String _SQL_COUNT_ASSETTRENDINGENTRY = "SELECT COUNT(assetTrendingEntry) FROM AssetTrendingEntry assetTrendingEntry";
	private static final String _SQL_COUNT_ASSETTRENDINGENTRY_WHERE = "SELECT COUNT(assetTrendingEntry) FROM AssetTrendingEntry assetTrendingEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "assetTrendingEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AssetTrendingEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AssetTrendingEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static final Log _log = LogFactoryUtil.getLog(AssetTrendingEntryPersistenceImpl.class);
	private static final AssetTrendingEntry _nullAssetTrendingEntry = new AssetTrendingEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AssetTrendingEntry> toCacheModel() {
				return _nullAssetTrendingEntryCacheModel;
			}
		};

	private static final CacheModel<AssetTrendingEntry> _nullAssetTrendingEntryCacheModel =
		new CacheModel<AssetTrendingEntry>() {
			@Override
			public AssetTrendingEntry toEntityModel() {
				return _nullAssetTrendingEntry;
			}
		};
}