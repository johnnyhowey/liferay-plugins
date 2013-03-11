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

package com.liferay.so.activities.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.liferay.so.activities.model.SocialActivity;

import java.io.Serializable;

/**
 * The cache model class for representing SocialActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivity
 * @generated
 */
public class SocialActivityCacheModel implements CacheModel<SocialActivity>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{activityId=");
		sb.append(activityId);
		sb.append(", activitySetId=");
		sb.append(activitySetId);
		sb.append("}");

		return sb.toString();
	}

	public SocialActivity toEntityModel() {
		SocialActivityImpl socialActivityImpl = new SocialActivityImpl();

		socialActivityImpl.setActivityId(activityId);
		socialActivityImpl.setActivitySetId(activitySetId);

		socialActivityImpl.resetOriginalValues();

		return socialActivityImpl;
	}

	public long activityId;
	public long activitySetId;
}