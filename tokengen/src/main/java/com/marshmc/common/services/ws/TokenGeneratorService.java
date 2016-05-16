package com.marshmc.common.services.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.marshmc.common.services.xml.entity.Token;

@Path("token")
public class TokenGeneratorService {

	@GET
	@Path("generate")
	@Produces(MediaType.APPLICATION_JSON)
	public Token generateToken(){
		Token t = new Token("test");
		return t;
	}
}
