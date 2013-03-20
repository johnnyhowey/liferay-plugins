<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<portlet:defineObjects />

<%

PortletPreferences prefs = renderRequest.getPreferences();

String greeting = renderRequest.getParameter("greeting");

if (greeting != null) {

	prefs.setValue("greeting", greeting);

	prefs.store();

%>

<p>Greeting saved successfully!</p>

<%

}

%>

<%

greeting = (String)prefs.getValue("greeting", "Hello! Welcome to our portal.");

%>

<portlet:renderURL var="editGreetingURL">

    <portlet:param name="jspPage" value="/edit.jsp" />

</portlet:renderURL>

<aui:form action="<%= editGreetingURL %>" method="post">

    <aui:input label="greeting" name="greeting" type="text" value="<%= greeting %>" />

    <aui:button type="submit" />

</aui:form>

<portlet:renderURL var="viewGreetingURL">

    <portlet:param name="jspPage" value="/view.jsp" />

</portlet:renderURL>

<p><a href="<%= viewGreetingURL %>">Back</a></p>