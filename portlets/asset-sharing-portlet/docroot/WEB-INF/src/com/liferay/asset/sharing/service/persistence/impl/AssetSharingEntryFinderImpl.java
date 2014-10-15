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

package com.liferay.asset.sharing.service.persistence.impl;

import com.liferay.asset.sharing.model.AssetSharingEntry;
import com.liferay.asset.sharing.service.persistence.AssetSharingEntryFinder;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ClassNameServiceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.social.model.SocialRelation;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Sherry Yang
 */
public class AssetSharingEntryFinderImpl
	extends BasePersistenceImpl<AssetSharingEntry>
	implements AssetSharingEntryFinder {

	public static final String COUNT_ASSET_ENTRIES_BY_USER_ID =
		AssetSharingEntryFinder.class.getName() + ".countAssetEntriesByUserId";

	public static final String FIND_ASSET_ENTRIES_BY_USER_ID =
		AssetSharingEntryFinder.class.getName() + ".findAssetEntriesByUserId";

	public int countAssetEntriesByUserId(
		long userId, long[] classNameIds, Map<Long, long[]> sharedTos) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_ASSET_ENTRIES_BY_USER_ID);

			sql = StringUtil.replace(
				sql, "[$CLASS_NAME_IDS_CLASS_PKS]",
				getClassNameIdsSharedTos(classNameIds, sharedTos));

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			setClassNameIdsSharedTos(qPos, userId, classNameIds, sharedTos);

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

	public List<Object[]> findAssetEntriesByUserId(
		long userId, long[] classNameIds, Map<Long, long[]> sharedTos,
		int start, int end) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_ASSET_ENTRIES_BY_USER_ID);

			sql = StringUtil.replace(
				sql, "[$CLASS_NAME_IDS_CLASS_PKS]",
				getClassNameIdsSharedTos(classNameIds, sharedTos));

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar("classNameId", Type.LONG);
			q.addScalar("classPK", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			setClassNameIdsSharedTos(qPos, userId, classNameIds, sharedTos);

			return (List<Object[]>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected String getClassNameIds(long[] classNameIds) {
		if (classNameIds.length == 0) {
			return StringPool.SPACE;
		}

		StringBundler sb = new StringBundler();

		sb.append(StringPool.OPEN_PARENTHESIS);

		for (int i = 0; i < classNameIds.length; i++) {
			sb.append("(AssetSharing_AssetSharingEntry.classNameId = ? )");

			if ((i + 1) < classNameIds.length) {
				sb.append(" OR ");
			}
		}

		sb.append(StringPool.CLOSE_PARENTHESIS);

		sb.append("AND");

		return sb.toString();
	}

	protected String getClassNameIdsSharedTos(
		long[] classNameIds, Map<Long, long[]> sharedTos) {

		StringBundler sb = new StringBundler();

		if (classNameIds != null) {
			sb.append(getClassNameIds(classNameIds));
		}

		sb.append(getSharedTos(sharedTos));

		return sb.toString();
	}

	protected String getSharedTos(Map<Long, long[]> sharedTos) {
		StringBundler sb = new StringBundler();

		sb.append(StringPool.OPEN_PARENTHESIS);

		if (sharedTos != null) {
			for (Map.Entry<Long, long[]> entry : sharedTos.entrySet()) {
				Long sharedToClassNameId = entry.getKey();
				long[] sharedToClassPKs = entry.getValue();

				if ((sharedToClassPKs == null) ||
					(sharedToClassPKs.length == 0)) {

					continue;
				}

				if (sharedToClassNameId == _SOCIAL_RELATION_CLASS_NAME_ID) {
					sb.append(getSocialRelationClassPKs(sharedToClassPKs));
				}
				else {
					sb.append(StringPool.OPEN_PARENTHESIS);
					sb.append(
						getShareTos(sharedToClassNameId, sharedToClassPKs));
					sb.append(StringPool.CLOSE_PARENTHESIS);
					sb.append(" OR ");
				}
			}
		}

		sb.append("(SocialActivitySet.userId = ?)");
		sb.append(StringPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}

	protected String getShareTos(
		long sharedToClassNameId, long[] sharedToClassPKs) {

		StringBundler sb = new StringBundler(sharedToClassPKs.length * 2 + 1);

		sb.append(
			"(AssetSharing_AssetSharingEntry.sharedToClassNameId = ?) AND (");

		for (int i = 0; i < sharedToClassPKs.length; i++) {
			sb.append("(AssetSharing_AssetSharingEntry.sharedToClassPK = ?)");

			if ((i + 1) < sharedToClassPKs.length) {
				sb.append(" OR ");
			}
			else {
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}
		}

		return sb.toString();
	}

	protected String getSocialRelationClassPKs(long[] sharedToClassPKs) {
		StringBundler sb = null;

		Arrays.sort(sharedToClassPKs);

		if (sharedToClassPKs.length == 1) {
			if (sharedToClassPKs[0] == _TYPE_EVERYONE) {
				sb = new StringBundler(3);

				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassNameId = ?)" +
					" AND ");
				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?)");
			}
			else {
				sb = new StringBundler(6);

				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassNameId = ?)" +
					" AND ");
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?)" +
					" AND ");
				sb.append("(SocialRelation.userId1 = ?)");
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}
		}
		else if (sharedToClassPKs.length == 2) {
			if (sharedToClassPKs[0] == _TYPE_EVERYONE) {
				sb = new StringBundler(9);

				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassNameId = ?)" +
					" AND ");
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?) OR ");
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?)" +
					" AND ");
				sb.append("(SocialRelation.userId1 = ?)");
				sb.append(StringPool.CLOSE_PARENTHESIS);
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}
			else {
				sb = new StringBundler(10);

				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassNameId = ?)" +
					" AND ");
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?) OR ");
				sb.append(
					"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?)");
				sb.append(StringPool.CLOSE_PARENTHESIS);
				sb.append(" AND ");
				sb.append("(SocialRelation.userId1 = ?)");
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}
		}
		else {
			sb = new StringBundler(15);

			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(
				"(AssetSharing_AssetSharingEntry.sharedToClassNameId = ?)" +
				" AND ");
			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(
				"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?) OR ");
			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(
				"(AssetSharing_AssetSharingEntry.sharedToClassPK = ?) OR ");
			sb.append("(AssetSharing_AssetSharingEntry.sharedToClassPK = ?)");
			sb.append(StringPool.CLOSE_PARENTHESIS);
			sb.append(" AND ");
			sb.append("(SocialRelation.userId1 = ?)");
			sb.append(StringPool.CLOSE_PARENTHESIS);
			sb.append(StringPool.CLOSE_PARENTHESIS);
			sb.append(StringPool.CLOSE_PARENTHESIS);
		}

		sb.append(" OR ");

		return sb.toString();
	}

	protected void setClassNameIdsSharedTos(
		QueryPos qPos, long userId, long[] classNameIds,
		Map<Long, long[]> sharedTos) {

		if (classNameIds != null) {
			for (long classNameId : classNameIds) {
				qPos.add(classNameId);
			}
		}

		if (sharedTos != null) {
			for (Long sharedToClassNameId : sharedTos.keySet()) {
				qPos.add(sharedToClassNameId);

				long[] sharedToClassPKs = sharedTos.get(sharedToClassNameId);

				if (sharedToClassNameId == _SOCIAL_RELATION_CLASS_NAME_ID) {
					Arrays.sort(sharedToClassPKs);

					if (sharedToClassPKs.length == 1) {
						if (sharedToClassPKs[0] == _TYPE_EVERYONE) {
							qPos.add(sharedToClassPKs[0]);
						}
						else {
							qPos.add(sharedToClassPKs[0]);
							qPos.add(userId);
						}
					}
					else {
						for (long sharedToClasPK : sharedToClassPKs) {
							qPos.add(sharedToClasPK);
						}

						qPos.add(userId);
					}
				}
				else {
					for (long sharedToClassPK : sharedToClassPKs) {
						qPos.add(sharedToClassPK);
					}
				}
			}
		}

		qPos.add(userId);
	}

	private static final long _SOCIAL_RELATION_CLASS_NAME_ID =
		ClassNameServiceUtil.fetchClassNameId(SocialRelation.class);

	private static final long _TYPE_EVERYONE = 0;

}