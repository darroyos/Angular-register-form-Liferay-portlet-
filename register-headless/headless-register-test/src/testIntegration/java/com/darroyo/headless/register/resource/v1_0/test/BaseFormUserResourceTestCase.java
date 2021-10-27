package com.darroyo.headless.register.resource.v1_0.test;

import com.darroyo.headless.register.client.dto.v1_0.FormUser;
import com.darroyo.headless.register.client.http.HttpInvoker;
import com.darroyo.headless.register.client.pagination.Page;
import com.darroyo.headless.register.client.resource.v1_0.FormUserResource;
import com.darroyo.headless.register.client.serdes.v1_0.FormUserSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Jonah the son of Amittai
 * @generated
 */
@Generated("")
public abstract class BaseFormUserResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_formUserResource.setContextCompany(testCompany);

		FormUserResource.Builder builder = FormUserResource.builder();

		formUserResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		FormUser formUser1 = randomFormUser();

		String json = objectMapper.writeValueAsString(formUser1);

		FormUser formUser2 = FormUserSerDes.toDTO(json);

		Assert.assertTrue(equals(formUser1, formUser2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		FormUser formUser = randomFormUser();

		String json1 = objectMapper.writeValueAsString(formUser);
		String json2 = FormUserSerDes.toJSON(formUser);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		FormUser formUser = randomFormUser();

		formUser.setEmail(regex);
		formUser.setId(regex);
		formUser.setName(regex);
		formUser.setRecaptcha(regex);
		formUser.setSurname(regex);

		String json = FormUserSerDes.toJSON(formUser);

		Assert.assertFalse(json.contains(regex));

		formUser = FormUserSerDes.toDTO(json);

		Assert.assertEquals(regex, formUser.getEmail());
		Assert.assertEquals(regex, formUser.getId());
		Assert.assertEquals(regex, formUser.getName());
		Assert.assertEquals(regex, formUser.getRecaptcha());
		Assert.assertEquals(regex, formUser.getSurname());
	}

	@Test
	public void testGetRegisterFormPage() throws Exception {
		Page<FormUser> page = formUserResource.getRegisterFormPage();

		long totalCount = page.getTotalCount();

		FormUser formUser1 = testGetRegisterFormPage_addFormUser(
			randomFormUser());

		FormUser formUser2 = testGetRegisterFormPage_addFormUser(
			randomFormUser());

		page = formUserResource.getRegisterFormPage();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(formUser1, (List<FormUser>)page.getItems());
		assertContains(formUser2, (List<FormUser>)page.getItems());
		assertValid(page);
	}

	protected FormUser testGetRegisterFormPage_addFormUser(FormUser formUser)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostRegisterForm() throws Exception {
		FormUser randomFormUser = randomFormUser();

		FormUser postFormUser = testPostRegisterForm_addFormUser(
			randomFormUser);

		assertEquals(randomFormUser, postFormUser);
		assertValid(postFormUser);
	}

	protected FormUser testPostRegisterForm_addFormUser(FormUser formUser)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected FormUser testGraphQLFormUser_addFormUser() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(FormUser formUser, List<FormUser> formUsers) {
		boolean contains = false;

		for (FormUser item : formUsers) {
			if (equals(formUser, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			formUsers + " does not contain " + formUser, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(FormUser formUser1, FormUser formUser2) {
		Assert.assertTrue(
			formUser1 + " does not equal " + formUser2,
			equals(formUser1, formUser2));
	}

	protected void assertEquals(
		List<FormUser> formUsers1, List<FormUser> formUsers2) {

		Assert.assertEquals(formUsers1.size(), formUsers2.size());

		for (int i = 0; i < formUsers1.size(); i++) {
			FormUser formUser1 = formUsers1.get(i);
			FormUser formUser2 = formUsers2.get(i);

			assertEquals(formUser1, formUser2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<FormUser> formUsers1, List<FormUser> formUsers2) {

		Assert.assertEquals(formUsers1.size(), formUsers2.size());

		for (FormUser formUser1 : formUsers1) {
			boolean contains = false;

			for (FormUser formUser2 : formUsers2) {
				if (equals(formUser1, formUser2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				formUsers2 + " does not contain " + formUser1, contains);
		}
	}

	protected void assertValid(FormUser formUser) throws Exception {
		boolean valid = true;

		if (formUser.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("birthDate", additionalAssertFieldName)) {
				if (formUser.getBirthDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (formUser.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (formUser.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("recaptcha", additionalAssertFieldName)) {
				if (formUser.getRecaptcha() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("registeredOn", additionalAssertFieldName)) {
				if (formUser.getRegisteredOn() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("surname", additionalAssertFieldName)) {
				if (formUser.getSurname() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<FormUser> page) {
		boolean valid = false;

		java.util.Collection<FormUser> formUsers = page.getItems();

		int size = formUsers.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.darroyo.headless.register.dto.v1_0.FormUser.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(FormUser formUser1, FormUser formUser2) {
		if (formUser1 == formUser2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("birthDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						formUser1.getBirthDate(), formUser2.getBirthDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						formUser1.getEmail(), formUser2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(formUser1.getId(), formUser2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						formUser1.getName(), formUser2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("recaptcha", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						formUser1.getRecaptcha(), formUser2.getRecaptcha())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("registeredOn", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						formUser1.getRegisteredOn(),
						formUser2.getRegisteredOn())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("surname", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						formUser1.getSurname(), formUser2.getSurname())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_formUserResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_formUserResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, FormUser formUser) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("birthDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(formUser.getBirthDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(formUser.getBirthDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(formUser.getBirthDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(formUser.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			sb.append("'");
			sb.append(String.valueOf(formUser.getId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(formUser.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("recaptcha")) {
			sb.append("'");
			sb.append(String.valueOf(formUser.getRecaptcha()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("registeredOn")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(formUser.getRegisteredOn(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(formUser.getRegisteredOn(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(formUser.getRegisteredOn()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("surname")) {
			sb.append("'");
			sb.append(String.valueOf(formUser.getSurname()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected FormUser randomFormUser() throws Exception {
		return new FormUser() {
			{
				birthDate = RandomTestUtil.nextDate();
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				id = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				recaptcha = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				registeredOn = RandomTestUtil.nextDate();
				surname = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected FormUser randomIrrelevantFormUser() throws Exception {
		FormUser randomIrrelevantFormUser = randomFormUser();

		return randomIrrelevantFormUser;
	}

	protected FormUser randomPatchFormUser() throws Exception {
		return randomFormUser();
	}

	protected FormUserResource formUserResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseFormUserResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.darroyo.headless.register.resource.v1_0.FormUserResource
		_formUserResource;

}