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

import com.liferay.assettrending.model.AssetTrendingEntry;
import com.liferay.assettrending.model.impl.AssetTrendingEntryImpl;
import com.liferay.assettrending.model.impl.AssetTrendingEntryModelImpl;
import com.liferay.assettrending.service.persistence.AssetTrendingEntryFinder;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Lin Cui
 */
public class AssetTrendingEntryFinderImpl
	extends BasePersistenceImpl<AssetTrendingEntry>
	implements AssetTrendingEntryFinder {

	public static final String COUNT_ASSETS =
		AssetTrendingEntryFinder.class.getName() + ".countAssets";

	public static final String FIND_ASSETS =
		AssetTrendingEntryFinder.class.getName() + ".findAssets";

	public AssetTrendingEntryFinderImpl() {
	}

	public int countAssets(long[] classNameId, Date createDate) {
		return countAssets(StringUtil.merge(classNameId), createDate);
	}

	public int countAssets(String classNameIds, Date createDate) {
		Session session = null;

		try {
			session = openSession();

			StringBundler sql = new StringBundler();

			String countAssetsSQL = CustomSQLUtil.get(COUNT_ASSETS);

			if (Validator.isNull(classNameIds)) {
				countAssetsSQL =
					StringUtil.replace(
						countAssetsSQL,
						"[$ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS$]",
						StringPool.BLANK);
			}

			if (Validator.isNotNull(classNameIds)) {
				countAssetsSQL =
					StringUtil.replace(
						countAssetsSQL,
						"[$ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS$]",
						_ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS);

				countAssetsSQL = StringUtil.replace(
					countAssetsSQL, "[$CLASS_NAME_IDS$]", classNameIds);
			}

			countAssetsSQL = CustomSQLUtil.replaceAndOperator(
				countAssetsSQL, true);

			sql.append(countAssetsSQL);

			SQLQuery q = session.createSynchronizedSQLQuery(sql.toString());

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(createDate);
			qPos.add(createDate);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<AssetTrendingEntry> findAssets(
		long[] classNameId, Date createDate, int start, int end,
		OrderByComparator orderByComparator) {

		return findAssets(
			StringUtil.merge(classNameId), createDate, start, end,
			orderByComparator);
	}

	public List<AssetTrendingEntry> findAssets(
		String classNameIds, Date createDate, int start, int end,
		OrderByComparator orderByComparator) {

		Session session = null;

		try {
			session = openSession();

			StringBundler sql = new StringBundler();

			String findAssetsSQL = CustomSQLUtil.get(FIND_ASSETS);

			if (Validator.isNull(classNameIds)) {
				findAssetsSQL =
					StringUtil.replace(
						findAssetsSQL,
						"[$ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS$]",
						StringPool.BLANK);
			}

			if (Validator.isNotNull(classNameIds)) {
				findAssetsSQL =
					StringUtil.replace(
						findAssetsSQL,
						"[$ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS$]",
						_ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS);

				findAssetsSQL = StringUtil.replace(
					findAssetsSQL, "[$CLASS_NAME_IDS$]", classNameIds);
			}

			findAssetsSQL = CustomSQLUtil.replaceAndOperator(
				findAssetsSQL, true);

			sql.append(findAssetsSQL);

			StringBundler orderBy = new StringBundler();

			if (orderByComparator != null) {
				appendOrderByComparator(
					orderBy, StringPool.BLANK, orderByComparator);
			}
			else {
				orderBy.append(AssetTrendingEntryModelImpl.ORDER_BY_JPQL);
			}

			sql.append(orderBy.toString());

			SQLQuery q = session.createSynchronizedSQLQuery(sql.toString());

			q.addEntity("AssetTrendingEntry", AssetTrendingEntryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(createDate);
			qPos.add(createDate);

			return (List<AssetTrendingEntry>)QueryUtil.list(
						q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _ASSET_TRENDING_ENTRY_IN_CLASS_NAME_IDS =
		"(AssetTrendingEntry.classNameId in ([$CLASS_NAME_IDS$])) AND ";

}