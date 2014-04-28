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

package com.liferay.pushnotifications.sender.apple;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.pushnotifications.sender.PushNotificationsSender;
import com.liferay.pushnotifications.util.PortletPropsValues;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;
import com.notnoop.apns.PayloadBuilder;

import java.util.List;

/**
 * @author Silvio Santos
 * @author Bruno Farache
 */
public class ApplePushNotificationsSender implements PushNotificationsSender {

	public ApplePushNotificationsSender() {
		ApnsServiceBuilder appleServiceBuilder = APNS.newService();

		appleServiceBuilder.withCert(
			PortletPropsValues.APPLE_CERTIFICATE_PATH,
			PortletPropsValues.APPLE_CERTIFICATE_PASSWORD);

		if (PortletPropsValues.APPLE_SANDBOX) {
			appleServiceBuilder.withSandboxDestination();
		}

		_apnsService = appleServiceBuilder.build();
	}

	@Override
	public void send(List<String> tokens, JSONObject jsonObject)
		throws Exception {

		String payload = buildPayload(jsonObject);

		_apnsService.push(tokens, payload);
	}

	protected String buildPayload(JSONObject jsonObject) {
		PayloadBuilder builder = PayloadBuilder.newPayload();

		String entryTitle = jsonObject.getString("entryTitle");

		if (entryTitle != null) {
			builder.alertBody(entryTitle);
		}

		return builder.build();
	}

	private ApnsService _apnsService;

}