package cs3220.week13lab.controller;

import cs3220.week13lab.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.week13lab.model.Poll;

@Controller
public class PollController {

	@Autowired
	private final PollRepository dataStore;

	public PollController(PollRepository dataStore) {
		this.dataStore = dataStore;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("polls", dataStore.findAll());
		return "index";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable int id, Model model) {
		model.addAttribute("poll", dataStore.findById(id));
		return "view";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("poll", new Poll("", false));
		return "add";
	}

	@PostMapping("/add")
	public String add(Poll poll) {
		dataStore.save(poll);
		return "redirect:answers/" + poll.getId();
	}

	@GetMapping("/answers/{id}")
	public String answers(@PathVariable int id, Model model) {
		model.addAttribute("poll", dataStore.findById(id));
		return "answers";
	}

//	@PostMapping("/answers/{id}")
//	public String answers(@PathVariable int id, String answer) {
//		Optional<Poll> poll = dataStore.findById(id);
//		poll.get().getAnswers().add(answer);
//		return "redirect:" + id;
//	}
}
