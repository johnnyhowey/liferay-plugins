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

package com.liferay.assettrending.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.assettrending.service.AssetTrendingEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AssetTrendingEntryLocalServiceClpInvoker {
	public AssetTrendingEntryLocalServiceClpInvoker() {
		_methodName0 = "addAssetTrendingEntry";

		_methodParameterTypes0 = new String[] {
				"com.liferay.assettrending.model.AssetTrendingEntry"
			};

		_methodName1 = "createAssetTrendingEntry";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteAssetTrendingEntry";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteAssetTrendingEntry";

		_methodParameterTypes3 = new String[] {
				"com.liferay.assettrending.model.AssetTrendingEntry"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchAssetTrendingEntry";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getAssetTrendingEntry";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getActionableDynamicQuery";

		_methodParameterTypes12 = new String[] {  };

		_methodName14 = "deletePersistedModel";

		_methodParameterTypes14 = new String[] {
				"com.liferay.portal.model.PersistedModel"
			};

		_methodName15 = "getPersistedModel";

		_methodParameterTypes15 = new String[] { "java.io.Serializable" };

		_methodName16 = "getAssetTrendingEntries";

		_methodParameterTypes16 = new String[] { "int", "int" };

		_methodName17 = "getAssetTrendingEntriesCount";

		_methodParameterTypes17 = new String[] {  };

		_methodName18 = "updateAssetTrendingEntry";

		_methodParameterTypes18 = new String[] {
				"com.liferay.assettrending.model.AssetTrendingEntry"
			};

		_methodName43 = "getBeanIdentifier";

		_methodParameterTypes43 = new String[] {  };

		_methodName44 = "setBeanIdentifier";

		_methodParameterTypes44 = new String[] { "java.lang.String" };

		_methodName49 = "addAssetTrendingEntry";

		_methodParameterTypes49 = new String[] {
				"long", "long", "java.util.Date", "java.util.Date", "long",
				"long", "long", "int", "double", "double", "int"
			};

		_methodName50 = "deleteAssetTrendingEntry";

		_methodParameterTypes50 = new String[] { "long", "long" };

		_methodName51 = "getAssetTrendingEntries";

		_methodParameterTypes51 = new String[] {
				"java.lang.String", "java.util.Date", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName52 = "getAssetTrendingEntriesCount";

		_methodParameterTypes52 = new String[] {
				"java.lang.String", "java.util.Date"
			};

		_methodName53 = "getAssetTrendingEntry";

		_methodParameterTypes53 = new String[] { "long" };

		_methodName54 = "getAssetTrendingEntry";

		_methodParameterTypes54 = new String[] { "long", "long" };

		_methodName55 = "updateAssetTrendingEntry";

		_methodParameterTypes55 = new String[] {
				"com.liferay.assettrending.model.AssetTrendingEntry", "double"
			};

		_methodName56 = "updateAssetTrendingEntry";

		_methodParameterTypes56 = new String[] {
				"long", "long", "java.util.Date", "java.util.Date", "long",
				"long", "long", "int", "double", "double", "int"
			};

		_methodName57 = "updateAssetTrendingEntry";

		_methodParameterTypes57 = new String[] { "long", "long", "double" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.addAssetTrendingEntry((com.liferay.assettrending.model.AssetTrendingEntry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.createAssetTrendingEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.deleteAssetTrendingEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.deleteAssetTrendingEntry((com.liferay.assettrending.model.AssetTrendingEntry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator<?>)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.fetchAssetTrendingEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getActionableDynamicQuery();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.deletePersistedModel((com.liferay.portal.model.PersistedModel)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntriesCount();
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.updateAssetTrendingEntry((com.liferay.assettrending.model.AssetTrendingEntry)arguments[0]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			AssetTrendingEntryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.addAssetTrendingEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], ((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Integer)arguments[7]).intValue(),
				((Double)arguments[8]).doubleValue(),
				((Double)arguments[9]).doubleValue(),
				((Integer)arguments[10]).intValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.deleteAssetTrendingEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntries((java.lang.String)arguments[0],
				(java.util.Date)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntriesCount((java.lang.String)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.getAssetTrendingEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.updateAssetTrendingEntry((com.liferay.assettrending.model.AssetTrendingEntry)arguments[0],
				((Double)arguments[1]).doubleValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.updateAssetTrendingEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], ((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Integer)arguments[7]).intValue(),
				((Double)arguments[8]).doubleValue(),
				((Double)arguments[9]).doubleValue(),
				((Integer)arguments[10]).intValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return AssetTrendingEntryLocalServiceUtil.updateAssetTrendingEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Double)arguments[2]).doubleValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
}