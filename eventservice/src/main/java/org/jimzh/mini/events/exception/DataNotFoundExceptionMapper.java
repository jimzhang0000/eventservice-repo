package org.jimzh.mini.events.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.jimzh.mini.events.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exp) {
		ErrorMessage errorMessage = new ErrorMessage(exp.getMessage(), 404);
		// TODO Auto-generated method stub
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}
