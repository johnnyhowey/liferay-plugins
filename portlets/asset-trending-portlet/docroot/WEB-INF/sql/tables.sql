create table AssetTrendingEntry (
	assetTrendingEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	assetEntryId LONG,
	classNameId LONG,
	classPK LONG,
	commentCount INTEGER,
	payload VARCHAR(75) null,
	priority DOUBLE,
	ratingScore DOUBLE,
	trendingScore DOUBLE,
	viewCount INTEGER
);