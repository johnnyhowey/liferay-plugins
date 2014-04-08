<#list dataFactory.expandoColumnModels as expandoColumnModel>
	insert into ExpandoColumn values (${expandoColumnModel.columnId}, ${expandoColumnModel.companyId}, ${expandoColumnModel.tableId}, '${expandoColumnModel.name}', ${expandoColumnModel.type}, '${expandoColumnModel.defaultData}', '${expandoColumnModel.typeSettings}');
</#list>

<#list dataFactory.expandoRowModels as expandoRowModel>
	insert into ExpandoRow values (${expandoRowModel.rowId}, ${expandoRowModel.companyId}, ${dataFactory.getDateString(expandoRowModel.modifiedDate)}, ${expandoRowModel.tableId}, ${expandoRowModel.classPK});
</#list>

<#list dataFactory.expandoTableModels as expandoTableModel>
	insert into ExpandoTable values (${expandoTableModel.tableId}, ${expandoTableModel.companyId}, ${expandoTableModel.classNameId}, '${expandoTableModel.name}');
</#list>

<#list dataFactory.expandoValueModels as expandoValueModel>
	insert into ExpandoValue values (${expandoValueModel.valueId}, ${expandoValueModel.companyId}, ${expandoValueModel.tableId}, ${expandoValueModel.columnId}, ${expandoValueModel.rowId}, ${expandoValueModel.classNameId}, ${expandoValueModel.classPK}, '${expandoValueModel.data}');
</#list>