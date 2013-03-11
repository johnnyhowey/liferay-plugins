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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialActivityImpl extends SocialActivityBaseImpl {

	public SocialActivityImpl() {
	}

	public long getGroupId() throws PortalException, SystemException {
		com.liferay.portlet.social.model.SocialActivity socialActivity =
			getPortalSocialActivity();

		return socialActivity.getGroupId();
	}

	public com.liferay.portlet.social.model.SocialActivity
			getPortalSocialActivity()
		throws PortalException, SystemException {

		if (_socialActivity == null) {
			_socialActivity = SocialActivityLocalServiceUtil.getActivity(
				getActivityId());
		}

		return _socialActivity;
	}

	private com.liferay.portlet.social.model.SocialActivity _socialActivity;

}