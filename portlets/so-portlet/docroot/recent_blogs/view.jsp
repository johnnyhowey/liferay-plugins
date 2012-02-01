<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ include file="/init.jsp" %>

<%
long assetEntryId = ParamUtil.getLong(request, "assetEntryId", 0L);

AssetEntry entry = null;

try {
	entry = AssetEntryLocalServiceUtil.getEntry(assetEntryId);
}
catch (Exception e) {
}
%>

<c:choose>
	<c:when test="<%= entry != null %>">

		<%
		String className = PortalUtil.getClassName(entry.getClassNameId());
		long classPK = entry.getClassPK();

		AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(classPK);

		request.setAttribute("view.jsp-results", new ArrayList());

		request.setAttribute("view.jsp-assetEntryIndex", new Integer(1));

		request.setAttribute("view.jsp-assetEntry", entry);
		request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
		request.setAttribute("view.jsp-assetRenderer", assetRenderer);

		request.setAttribute("view.jsp-title", entry.getTitle());

		request.setAttribute("view.jsp-className", className);
		request.setAttribute("view.jsp-classPK", new Long(classPK));

		request.setAttribute("view.jsp-show", Boolean.TRUE);
		request.setAttribute("view.jsp-print", Boolean.FALSE);
		%>

		<liferay-util:include page="/html/portlet/asset_publisher/display/full_content.jsp" />
	</c:when>
	<c:otherwise>

		<%
		PortletPreferences preferences = renderRequest.getPreferences();

		String portletResource = ParamUtil.getString(request, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
		}

		String orderByColumn1 = GetterUtil.getString(preferences.getValue("orderByColumn1", "modifiedDate"));
		String orderByColumn2 = GetterUtil.getString(preferences.getValue("orderByColumn2", "title"));
		String orderByType1 = GetterUtil.getString(preferences.getValue("orderByType1", "DESC"));
		String orderByType2 = GetterUtil.getString(preferences.getValue("orderByType2", "ASC"));
		int delta = GetterUtil.getInteger(preferences.getValue("delta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

		assetEntryQuery.setGroupIds(new long[] {themeDisplay.getScopeGroupId()});

		assetEntryQuery.setOrderByCol1(orderByColumn1);
		assetEntryQuery.setOrderByCol2(orderByColumn2);
		assetEntryQuery.setOrderByType1(orderByType1);
		assetEntryQuery.setOrderByType2(orderByType2);

		assetEntryQuery.setClassNameIds(new long[] {PortalUtil.getClassNameId(BlogsEntry.class)});

		assetEntryQuery.setEnd(delta);
		assetEntryQuery.setStart(0);

		List<AssetEntry> results = AssetEntryServiceUtil.getEntries(assetEntryQuery);
		%>

		<c:choose>
			<c:when test="<%= !results.isEmpty() %>">

				<%
				request.setAttribute("view.jsp-results", results);

				request.setAttribute("view.jsp-show", Boolean.TRUE);
				request.setAttribute("view.jsp-print", Boolean.FALSE);

				for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
					AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);

					String className = PortalUtil.getClassName(assetEntry.getClassNameId());
					long classPK = assetEntry.getClassPK();

					AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

					if (assetRendererFactory == null) {
						continue;
					}

					AssetRenderer assetRenderer = null;

					try {
						assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
					}
					catch (Exception e) {
					}

					if ((assetRenderer == null) || !assetRenderer.isDisplayable()) {
						continue;
					}

					String title = assetRenderer.getTitle(locale);

					request.setAttribute("view.jsp-assetEntryIndex", new Integer(assetEntryIndex));

					request.setAttribute("view.jsp-assetEntry", assetEntry);
					request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
					request.setAttribute("view.jsp-assetRenderer", assetRenderer);

					request.setAttribute("view.jsp-title", title);

					try {
				%>

						<liferay-util:include page="/html/portlet/asset_publisher/display/title_list.jsp" />

				<%
					}
					catch (Exception e) {
					}
				}
				%>

			</c:when>
			<c:otherwise>
				<div class="portlet-msg-info">
					<liferay-ui:message key="there-are-no-results" />
				</div>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>