package rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import viksit.service.ChatService;

 
@Path("/chat")
public class RestChatAPI {
	@GET
	@Path("/chat_user/{user_id}")
	 @Produces(MediaType.APPLICATION_JSON)
	public Response getTodaysGroupTrainingProjectsForOrg(@PathParam("user_id") Integer userId) {
		JSONObject jsonObject=new JSONObject();
		ChatService chatService=new ChatService();
		
		return Response.status(200).entity(chatService.userCollegue(userId)).build();
	}

}	
