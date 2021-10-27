package com.darroyo.headless.register.internal.graphql.mutation.v1_0;

import com.darroyo.headless.register.dto.v1_0.FormUser;
import com.darroyo.headless.register.resource.v1_0.FormUserResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Jonah the son of Amittai
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFormUserResourceComponentServiceObjects(
		ComponentServiceObjects<FormUserResource>
			formUserResourceComponentServiceObjects) {

		_formUserResourceComponentServiceObjects =
			formUserResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new registration.")
	public FormUser createRegisterForm(
			@GraphQLName("formUser") FormUser formUser)
		throws Exception {

		return _applyComponentServiceObjects(
			_formUserResourceComponentServiceObjects,
			this::_populateResourceContext,
			formUserResource -> formUserResource.postRegisterForm(formUser));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(FormUserResource formUserResource)
		throws Exception {

		formUserResource.setContextAcceptLanguage(_acceptLanguage);
		formUserResource.setContextCompany(_company);
		formUserResource.setContextHttpServletRequest(_httpServletRequest);
		formUserResource.setContextHttpServletResponse(_httpServletResponse);
		formUserResource.setContextUriInfo(_uriInfo);
		formUserResource.setContextUser(_user);
		formUserResource.setGroupLocalService(_groupLocalService);
		formUserResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FormUserResource>
		_formUserResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}