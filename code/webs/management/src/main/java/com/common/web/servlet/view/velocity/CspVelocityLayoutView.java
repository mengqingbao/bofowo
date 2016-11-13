package com.common.web.servlet.view.velocity;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

public class CspVelocityLayoutView extends VelocityLayoutView {

	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	@Override
	protected Context createVelocityContext(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.createVelocityContext(model, request, response);
	}
	
}
