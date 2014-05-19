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

package com.liferay.so.activities.hook.social;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.portlet.social.model.SocialActivitySet;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivitySetLocalServiceUtil;
import com.liferay.portlet.social.service.persistence.SocialActivityUtil;
import com.liferay.so.activities.util.SocialActivityKeyConstants;

import java.util.Date;

/**
 * @author Evan Thibodeau
 * @author Matthew Kong
 */
public class BlogsActivityInterpreter extends SOSocialActivityInterpreter {

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	public void updateActivitySet(long activityId)
		throws PortalException, SystemException {

		SocialActivity activity = SocialActivityUtil.fetchByPrimaryKey(
			activityId);

		if ((activity == null) || (activity.getActivitySetId() > 0)) {
			return;
		}

		long activitySetId = getActivitySetId(activityId);

		SocialActivitySet activitySet = null;

		if (activitySetId > 0) {
			SocialActivitySetLocalServiceUtil.incrementActivityCount(
				activitySetId, activityId);

			activitySet =
				SocialActivitySetLocalServiceUtil.fetchSocialActivitySet(
					activity.getActivitySetId());
		}
		else {
			activitySet = SocialActivitySetLocalServiceUtil.addActivitySet(
				activityId);
		}

		if (activitySet == null) {
			return;
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("lastModifiedDate", activitySet.getModifiedDate());

		activitySet.setExtraData(jsonObject.toString());

		long displayTime = getBlogsEntryDisplayTime(activity.getClassPK());

		if (displayTime > activitySet.getModifiedDate()) {
			activitySet.setModifiedDate(displayTime);
		}

		SocialActivitySetLocalServiceUtil.updateSocialActivitySet(activitySet);
	}

	@Override
	protected long getActivitySetId(long activityId) {
		try {
			SocialActivitySet activitySet = null;

			boolean comment = false;

			SocialActivity activity =
				SocialActivityLocalServiceUtil.getActivity(activityId);

			if ((activity.getType() ==
					SocialActivityKeyConstants.BLOGS_ADD_COMMENT) ||
				(activity.getType() ==
					SocialActivityConstants.TYPE_ADD_COMMENT)) {

				activitySet =
					SocialActivitySetLocalServiceUtil.getClassActivitySet(
						activity.getClassNameId(), activity.getClassPK(),
						activity.getType());

				comment = true;
			}
			else if (activity.getType() ==
						SocialActivityKeyConstants.BLOGS_UPDATE_ENTRY) {

				activitySet =
					SocialActivitySetLocalServiceUtil.getClassActivitySet(
						activity.getUserId(), activity.getClassNameId(),
						activity.getClassPK(), activity.getType());
			}

			if ((activitySet != null) && !isExpired(activitySet, comment)) {
				return activitySet.getActivitySetId();
			}
		}
		catch (Exception e) {
		}

		return 0;
	}

	protected long getBlogsEntryDisplayTime(long entryId)
		throws SystemException {

		BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.fetchBlogsEntry(
			entryId);

		if (blogsEntry == null) {
			return 0;
		}

		Date displayDate = blogsEntry.getDisplayDate();

		return displayDate.getTime();
	}

	@Override
	protected String getBody(
			SocialActivity activity, ServiceContext serviceContext)
		throws Exception {

		return getBody(
			activity.getClassName(), activity.getClassPK(), serviceContext);
	}

	@Override
	protected String getBody(
			SocialActivitySet activitySet, ServiceContext serviceContext)
		throws Exception {

		if ((activitySet.getType() ==
				SocialActivityKeyConstants.BLOGS_ADD_COMMENT) ||
			(activitySet.getType() ==
				SocialActivityKeyConstants.BLOGS_UPDATE_ENTRY) ||
			(activitySet.getType() ==
				SocialActivityConstants.TYPE_ADD_COMMENT)) {

			return getBody(
				activitySet.getClassName(), activitySet.getClassPK(),
				serviceContext);
		}

		return super.getBody(activitySet, serviceContext);
	}

	protected String getBody(
			String className, long classPK, ServiceContext serviceContext)
		throws Exception {

		StringBundler sb = new StringBundler(5);

		sb.append("<div class=\"activity-body\"><div class=\"title\">");
		sb.append(getPageTitle(className, classPK, serviceContext));
		sb.append("</div><div class=\"blogs-page-content\">");

		BlogsEntry entry = BlogsEntryLocalServiceUtil.getEntry(classPK);

		String content = HtmlUtil.extractText(entry.getContent());

		sb.append(StringUtil.shorten(content, 200));

		sb.append("</div></div>");

		return sb.toString();
	}

	@Override
	protected SocialActivityFeedEntry getSubfeedEntry(
			SocialActivity activity, ServiceContext serviceContext)
		throws Exception {

		String title = getPageTitle(
			activity.getClassName(), activity.getClassPK(), serviceContext);

		BlogsEntry entry = BlogsEntryLocalServiceUtil.getEntry(
			activity.getClassPK());

		String content = HtmlUtil.extractText(entry.getContent());

		String body = StringUtil.shorten(content, 200);

		return new SocialActivityFeedEntry(title, body);
	}

	@Override
	protected String getTitlePattern(
		String groupName, SocialActivity activity) {

		if ((activity.getType() ==
				SocialActivityKeyConstants.BLOGS_ADD_COMMENT) ||
			(activity.getType() == SocialActivityConstants.TYPE_ADD_COMMENT)) {

			return "commented-on-a-blog-entry";
		}
		else if (activity.getType() ==
					SocialActivityKeyConstants.BLOGS_ADD_ENTRY) {

			return "wrote-a-new-blog-entry";
		}
		else if (activity.getType() ==
					SocialActivityKeyConstants.BLOGS_UPDATE_ENTRY) {

			return "updated-a-blog-entry";
		}

		return StringPool.BLANK;
	}

	@Override
	protected String getTitlePattern(
		String groupName, SocialActivitySet activitySet) {

		if ((activitySet.getType() ==
				SocialActivityKeyConstants.BLOGS_ADD_COMMENT) ||
			(activitySet.getType() ==
				SocialActivityConstants.TYPE_ADD_COMMENT)) {

			return "commented-on-a-blog-entry";
		}
		else if (activitySet.getType() ==
					SocialActivityKeyConstants.BLOGS_ADD_ENTRY) {

			return "wrote-x-new-blog-entries";
		}
		else if (activitySet.getType() ==
					SocialActivityKeyConstants.BLOGS_UPDATE_ENTRY) {

			return "made-x-updates-to-a-blog-entry";
		}

		return StringPool.BLANK;
	}

	@Override
	protected boolean isAfterDisplayDate(SocialActivity activity)
		throws Exception {

		long displayTime = getBlogsEntryDisplayTime(activity.getClassPK());

		if (displayTime < System.currentTimeMillis()) {
			return true;
		}

		return false;
	}

	@Override
	protected void setDisplayTime(long classNameId, long classPK)
		throws PortalException, SystemException {

		SocialActivitySet activitySet =
			SocialActivitySetLocalServiceUtil.getClassActivitySet(
				classNameId, classPK,
				SocialActivityKeyConstants.BLOGS_ADD_ENTRY);

		if (activitySet == null) {
			return;
		}

		long displayTime = getBlogsEntryDisplayTime(classPK);

		if (displayTime != activitySet.getModifiedDate()) {
			activitySet.setModifiedDate(displayTime);

			SocialActivitySetLocalServiceUtil.updateSocialActivitySet(
				activitySet);

			for (int type : _BLOGS_ACTIVITYSET_TYPES) {
				activitySet =
					SocialActivitySetLocalServiceUtil.getClassActivitySet(
						classNameId, classPK, type);

				if (activitySet == null) {
					continue;
				}

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
						activitySet.getExtraData());

				long lastModifiedDate = jsonObject.getLong("lastModifiedDate");

				if (displayTime > lastModifiedDate) {
					activitySet.setModifiedDate(displayTime);
				}
				else {
					activitySet.setModifiedDate(lastModifiedDate);
				}
			}

			SocialActivitySetLocalServiceUtil.updateSocialActivitySet(
				activitySet);
		}
	}

	private static final int[] _BLOGS_ACTIVITYSET_TYPES =
		new int[] {SocialActivityKeyConstants.BLOGS_ADD_COMMENT,
			SocialActivityKeyConstants.BLOGS_UPDATE_ENTRY,
			SocialActivityConstants.TYPE_ADD_COMMENT};

	private static final String[] _CLASS_NAMES = {BlogsEntry.class.getName()};

}