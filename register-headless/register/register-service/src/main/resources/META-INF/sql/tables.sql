create table DARROYO_PersistedUser (
	uuid_ VARCHAR(75) null,
	userId VARCHAR(75) not null primary key,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	email VARCHAR(75) null,
	birthDate DATE null,
	registeredOn DATE null,
	recaptcha VARCHAR(75) null
);