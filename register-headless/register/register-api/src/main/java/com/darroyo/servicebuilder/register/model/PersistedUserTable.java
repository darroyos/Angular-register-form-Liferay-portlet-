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

package com.darroyo.servicebuilder.register.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DARROYO_PersistedUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedUser
 * @generated
 */
public class PersistedUserTable extends BaseTable<PersistedUserTable> {

	public static final PersistedUserTable INSTANCE = new PersistedUserTable();

	public final Column<PersistedUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, String> userId = createColumn(
		"userId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<PersistedUserTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, String> surname = createColumn(
		"surname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, Date> birthDate = createColumn(
		"birthDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, Date> registeredOn = createColumn(
		"registeredOn", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersistedUserTable, String> recaptcha = createColumn(
		"recaptcha", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PersistedUserTable() {
		super("DARROYO_PersistedUser", PersistedUserTable::new);
	}

}