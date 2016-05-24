package com.games.sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	Map<String, Room> roomList = new HashMap<String, Room>();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "test";
	}

	@RequestMapping(value = "/createRoom", method = RequestMethod.POST)
	public void createRoom(@RequestBody final String roomId) {
		System.out.println("create : "+ roomId);
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean check = true;
				Room r = new Room();
				while (check) {
					try {
						if(roomList.get(roomId)==null){
							r.setRoomID(roomId);
							r.setTurnTeam("runner");
							roomList.put(roomId, r);
						} else {
							if (r.getTurnTeam().equals("runner"))
								r.setTurnTeam("hunter");
							else
								r.setTurnTeam("runner");
							roomList.put(roomId, r);
							Thread.sleep(10000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th.start();

	}

	@RequestMapping(value = "/checkTurn", method = RequestMethod.POST)
	public @ResponseBody String checkTurn(@RequestBody final String roomId) {
		Room r = roomList.get(roomId);
		String turn = "";
		if(r!=null){
			turn = r.getTurnTeam();
			System.out.println(turn);
		}
		return turn;
	}

}
