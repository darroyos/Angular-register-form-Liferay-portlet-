package com.darroyo.headless.register.internal.resource.v1_0;

import com.darroyo.headless.register.dto.v1_0.FormUser;
import com.darroyo.headless.register.resource.v1_0.FormUserResource;

import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author David Arroyo
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/form-user.properties",
	scope = ServiceScope.PROTOTYPE, service = FormUserResource.class
)
public class FormUserResourceImpl extends BaseFormUserResourceImpl {
	@Override
	public Page<FormUser> getRegisterFormPage() {
		return Page.of(_users.values());
	}

	@Override
	public FormUser postRegisterForm(FormUser user) {
		if (_users.containsKey(user.getId())) {
			throw new IllegalArgumentException(
					"Duplicate user ID " + user.getId());
		}

		user.setRegisteredOn(new Date());

		_users.put(user.getId(), user);

		return user;
	}


	private static final Map<String, FormUser> _users = new Hashtable<>();
}