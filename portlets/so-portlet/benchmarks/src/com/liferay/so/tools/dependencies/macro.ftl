<#setting number_format = "computer">

<#macro insertRole
	_userId
>
	insert into users_roles values(${_userId}, ${soUserRoleModel.roleId});
</#macro>

<#macro insertExpando
	_userId
>
	<#local groupExpandoColumnId = dataFactory.groupExpandoColumnId>
	<#local groupExpandoTableId = dataFactory.groupExpandoTableId>
	<#local groupId = dataFactory.getGroupId(_userId)>
	<#local rowId = dataFactory.getCounterNext()>
	<#local userExpandoRowModel = dataFactory.newExpandoRowModel(rowId, groupExpandoTableId, groupId)>

	insert into ExpandoRow values (${userExpandoRowModel.rowId}, ${userExpandoRowModel.companyId}, '${dataFactory.getDateString(userExpandoRowModel.modifiedDate)}', ${userExpandoRowModel.tableId}, ${userExpandoRowModel.classPK});

	<#local valueId = dataFactory.getCounterNext()>
	<#local userExpandoValueModel = dataFactory.newExpandoValueModel(valueId, groupExpandoTableId, groupExpandoColumnId, rowId, groupId, dataFactory.getGroupClassNameId(), "true")>

	insert into ExpandoValue values (${userExpandoValueModel.valueId}, ${userExpandoValueModel.companyId}, ${userExpandoValueModel.tableId}, ${userExpandoValueModel.columnId}, ${userExpandoValueModel.rowId}, ${userExpandoValueModel.classNameId}, ${userExpandoValueModel.classPK}, '${userExpandoValueModel.data}');
</#macro>

<#macro updateGroup
	_userId
>
	<#local treePath = dataFactory.getFriendlyURL(_userId) + "/">

	update Group_ set mvccVersion=0, uuid_='${dataFactory.getUUID()}',  companyId=${dataFactory.companyId}, creatorUserId=${_userId}, classNameId=${dataFactory.userClassNameId}, classPK=${_userId}, parentGroupId=0, liveGroupId=0, treePath='${treePath}', name='${_userId}', description='', type_=0, typeSettings='${dataFactory.groupTypeSettings}', manualMembership=1, membershipRestriction=0, friendlyURL='${dataFactory.getFriendlyURL(_userId)}', site=0, remoteStagingGroupCount=0, active_=1 where groupId=${dataFactory.getGroupId(_userId)};
</#macro>

<#macro updateUserLayoutSet
	_userId
>
	<#local layoutSetPrototypeUserPrivate = dataFactory.layoutSetPrototypeUserPrivateModel>

	update LayoutSet set mvccVersion = 0, layoutSetId=${dataFactory.getCounterNext()}, groupId=${dataFactory.getGroupId(_userId)}, companyId=${dataFactory.companyId}, createDate='${dataFactory.getDate()}', modifiedDate='${dataFactory.getDate()}', privateLayout=1, logoId=0, themeId='${dataFactory.themeId}', colorSchemeId='${dataFactory.colorSchemeId}', wapThemeId='mobile', wapColorSchemeId='01', css='', pageCount=7, settings_='${dataFactory.getSOTypeSettings()}', layoutSetPrototypeUuid='${layoutSetPrototypeUserPrivate.uuid}', layoutSetPrototypeLinkEnabled=1 where groupId=${dataFactory.getGroupId(_userId)} and privateLayout=1;

	<#local layoutSetPrototypeUserPublic = dataFactory.layoutSetPrototypeUserPublicModel>

	update LayoutSet set mvccVersion = 0, layoutSetId=${dataFactory.getCounterNext()}, groupId=${dataFactory.getGroupId(_userId)}, companyId=${dataFactory.companyId}, createDate='${dataFactory.getDate()}', modifiedDate='${dataFactory.getDate()}', privateLayout=1, logoId=0, themeId='${dataFactory.themeId}', colorSchemeId='${dataFactory.colorSchemeId}', wapThemeId='mobile', wapColorSchemeId='01', css='', pageCount=7, settings_='${dataFactory.getSOTypeSettings()}', layoutSetPrototypeUuid='${layoutSetPrototypeUserPublic.uuid}', layoutSetPrototypeLinkEnabled=1 where groupId=${dataFactory.getGroupId(_userId)} and privateLayout=0;
</#macro>

<#macro updateUserLayouts
	_userId
>
	<#local groupId = dataFactory.getGroupId(_userId)>

	<#list dataFactory.userLayoutModels as userLayoutModel>
		<#local plid = dataFactory.getCounterNext()>
		<#local typeSettings = dataFactory.getSOTypeSettings() + " " + userLayoutModel.typeSettings>

		insert into layout values (0, '${userLayoutModel.uuid}', ${plid}, ${groupId}, ${userLayoutModel.companyId}, 0, '', null, null, '${userLayoutModel.privateLayout?string}', ${dataFactory.getCounterNext()}, ${userLayoutModel.parentLayoutId}, '${userLayoutModel.name}', '', '', '', '', '${userLayoutModel.type}', '${typeSettings}', '${userLayoutModel.hidden?string}', '${userLayoutModel.friendlyURL}', ${userLayoutModel.iconImageId}, '${userLayoutModel.themeId}', '${userLayoutModel.colorSchemeId}', '${userLayoutModel.wapThemeId}', '${userLayoutModel.wapColorSchemeId}', '${userLayoutModel.css}', ${userLayoutModel.priority}, '${userLayoutModel.layoutPrototypeUuid}', '${userLayoutModel.layoutPrototypeLinkEnabled?string}', '${userLayoutModel.uuid}');
		insert into layoutFriendlyURL values (0, '${dataFactory.getUUID()}', ${dataFactory.getCounterNext()},${groupId}, ${dataFactory.companyId}, ${_userId}, '', '${dataFactory.getDate()}', '${dataFactory.getDate()}', ${plid}, '${userLayoutModel.privateLayout?string}', '${userLayoutModel.friendlyURL}', 'en_US');
	</#list>
</#macro>