package com.darroyo.headless.register.internal.graphql.servlet.v1_0;

import com.darroyo.headless.register.internal.graphql.mutation.v1_0.Mutation;
import com.darroyo.headless.register.internal.graphql.query.v1_0.Query;
import com.darroyo.headless.register.resource.v1_0.FormUserResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Jonah the son of Amittai
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFormUserResourceComponentServiceObjects(
			_formUserResourceComponentServiceObjects);

		Query.setFormUserResourceComponentServiceObjects(
			_formUserResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/headless-register-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FormUserResource>
		_formUserResourceComponentServiceObjects;

}