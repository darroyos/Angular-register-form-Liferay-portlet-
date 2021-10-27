package com.darroyo.headless.register.client.serdes.v1_0;

import com.darroyo.headless.register.client.dto.v1_0.FormUser;
import com.darroyo.headless.register.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Jonah the son of Amittai
 * @generated
 */
@Generated("")
public class FormUserSerDes {

	public static FormUser toDTO(String json) {
		FormUserJSONParser formUserJSONParser = new FormUserJSONParser();

		return formUserJSONParser.parseToDTO(json);
	}

	public static FormUser[] toDTOs(String json) {
		FormUserJSONParser formUserJSONParser = new FormUserJSONParser();

		return formUserJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FormUser formUser) {
		if (formUser == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (formUser.getBirthDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"birthDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(formUser.getBirthDate()));

			sb.append("\"");
		}

		if (formUser.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(formUser.getEmail()));

			sb.append("\"");
		}

		if (formUser.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(formUser.getId()));

			sb.append("\"");
		}

		if (formUser.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(formUser.getName()));

			sb.append("\"");
		}

		if (formUser.getRecaptcha() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"recaptcha\": ");

			sb.append("\"");

			sb.append(_escape(formUser.getRecaptcha()));

			sb.append("\"");
		}

		if (formUser.getRegisteredOn() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"registeredOn\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(formUser.getRegisteredOn()));

			sb.append("\"");
		}

		if (formUser.getSurname() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"surname\": ");

			sb.append("\"");

			sb.append(_escape(formUser.getSurname()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FormUserJSONParser formUserJSONParser = new FormUserJSONParser();

		return formUserJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FormUser formUser) {
		if (formUser == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (formUser.getBirthDate() == null) {
			map.put("birthDate", null);
		}
		else {
			map.put(
				"birthDate",
				liferayToJSONDateFormat.format(formUser.getBirthDate()));
		}

		if (formUser.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(formUser.getEmail()));
		}

		if (formUser.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(formUser.getId()));
		}

		if (formUser.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(formUser.getName()));
		}

		if (formUser.getRecaptcha() == null) {
			map.put("recaptcha", null);
		}
		else {
			map.put("recaptcha", String.valueOf(formUser.getRecaptcha()));
		}

		if (formUser.getRegisteredOn() == null) {
			map.put("registeredOn", null);
		}
		else {
			map.put(
				"registeredOn",
				liferayToJSONDateFormat.format(formUser.getRegisteredOn()));
		}

		if (formUser.getSurname() == null) {
			map.put("surname", null);
		}
		else {
			map.put("surname", String.valueOf(formUser.getSurname()));
		}

		return map;
	}

	public static class FormUserJSONParser extends BaseJSONParser<FormUser> {

		@Override
		protected FormUser createDTO() {
			return new FormUser();
		}

		@Override
		protected FormUser[] createDTOArray(int size) {
			return new FormUser[size];
		}

		@Override
		protected void setField(
			FormUser formUser, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "birthDate")) {
				if (jsonParserFieldValue != null) {
					formUser.setBirthDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					formUser.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					formUser.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					formUser.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "recaptcha")) {
				if (jsonParserFieldValue != null) {
					formUser.setRecaptcha((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "registeredOn")) {
				if (jsonParserFieldValue != null) {
					formUser.setRegisteredOn(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "surname")) {
				if (jsonParserFieldValue != null) {
					formUser.setSurname((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}