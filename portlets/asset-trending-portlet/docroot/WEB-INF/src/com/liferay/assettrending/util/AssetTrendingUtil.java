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

package com.liferay.assettrending.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Lin Cui
 */
public class AssetTrendingUtil {

	public static String getInitPayload() {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("TS", System.currentTimeMillis());
		jsonObject.put("1", 0);
		jsonObject.put("2", 0);
		jsonObject.put("3", 0);
		jsonObject.put("4", 0);
		jsonObject.put("5", 0);
		jsonObject.put("6", 0);
		jsonObject.put("7", 0);

		return jsonObject.toString();
	}

}