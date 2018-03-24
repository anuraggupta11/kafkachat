package viksit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import dao.ChatMessageDAO;
import dao.UserDAO;
import rest.response.ListOfUser;
import viksit.chat.ChatMessage;
import viksit.chat.User;

public class ChatService {
	public String userCollegue(Integer userId) {
		JSONArray jsonArray=new JSONArray();
		String images[]= {"https://i.pinimg.com/736x/d3/5f/2d/d35f2d55563776031e72ad301dff640a--corporate-portrait-corporate-headshots.jpg",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTf4Zve_lwmThG52urei1XM5aO2AocmWK6iVuSEaBh3_8__O7fNEg",
"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSR2lOiII5fucG5PDH1ZI-ZYV8xT2jfUcFpFkOgqxcYrVFHpvx3vA",
"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTIWHAhUb2w9cRbSNMDDzaMBlZnndnNEOlZn8GIDTPAw_Ev5lu",
"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTKtfkH277K_FW2ydMS5xhsn5DWBUj-XmG75qiqSIKjF1wS4JHgw",
"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRs58_UFL6sGN61TLohxzC7sveTKCdby8fS9r7hK0a1jfZvxmo"};
		Random r=new Random();
		int resullt = r.nextInt(4-1)+1;
		HashSet<Integer> userIds=new HashSet<Integer>();
		List<ChatMessage>  chatMessages= new ChatMessageDAO().findAll();
		for(ChatMessage chatMessage: chatMessages ) 
		{
			if(chatMessage.getReceiverId().intValue() == userId.intValue()) {
				userIds.add(chatMessage.getSenderId());
			}
			if(chatMessage.getSenderId().intValue() == userId.intValue()) {
				userIds.add(chatMessage.getReceiverId());
			}
		}
		ArrayList<ListOfUser> listOfUsers = new ArrayList<ListOfUser>();
		
		for(Integer id :userIds) {
			User user=new UserDAO().findById(id);
			ListOfUser listOfUser = new ListOfUser(user.getId(),user.getName(),images[resullt]);
			listOfUsers.add(listOfUser);
			/*JSONObject jsonObject=new JSONObject();
			jsonObject.put("name", user.getName());
			jsonObject.put("id", user.getId());
			jsonObject.put("image", r.nextInt(images.length));
			jsonArray.put(jsonObject);*/
		}
		
		return new Gson().toJson(listOfUsers);
		
	}
}
