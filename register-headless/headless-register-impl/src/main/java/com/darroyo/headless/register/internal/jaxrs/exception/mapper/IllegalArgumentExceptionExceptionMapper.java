package com.darroyo.headless.register.internal.jaxrs.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author David Arroyo
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Darroyo.Headless.Register)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Darroyo.Headless.Register.IllegalArgumentExceptionExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class IllegalArgumentExceptionExceptionMapper
	extends BaseExceptionMapper<IllegalArgumentException> {

	@Override
	protected Problem getProblem(
		IllegalArgumentException illegalArgumentException) {

		return new Problem(
			Response.Status.CONFLICT, illegalArgumentException.getMessage());
	}

}