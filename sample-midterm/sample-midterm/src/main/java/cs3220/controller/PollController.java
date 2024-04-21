package cs3220.controller;

import cs3220.AnswerRepository;
import cs3220.PollRepository;
import cs3220.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cs3220.PollRepository;
import cs3220.model.Poll;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PollController {

	@Autowired
	private PollRepository pollRepository;
	@Autowired
	private AnswerRepository answerRepository;

	public PollController(PollRepository dataStore) {
		this.pollRepository = dataStore;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("polls", pollRepository.findAll());
		return "index";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable int id, Model model) {
		model.addAttribute("poll", pollRepository.findById(id).orElse(null));
		model.addAttribute("answers", answerRepository.findByPollId(id));
		return "view";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("poll", new Poll());
		return "add";
	}

	@PostMapping("/add")
	public String add(Poll poll) {
		Poll newPoll = pollRepository.save(poll);
		return "redirect:answers/" + newPoll.getId();
	}

	@GetMapping("/answers/{id}")
	public String answers(@PathVariable int id, Model model) {
		model.addAttribute("polls", pollRepository.findById(id).orElse(null));
		model.addAttribute("answers", answerRepository.findByPollId(id));
		return "answers";
	}

	@PostMapping("/answers/{id}")
	public String addAnswer(@PathVariable("id") Integer id, @RequestParam("answer") String answerContent, RedirectAttributes redirectAttributes) {
		return pollRepository.findById(id)
				.map(poll -> {
					Answer newAnswer = new Answer();
					newAnswer.setContent(answerContent);
					newAnswer.setPoll(poll);  // Link the answer to the poll
					poll.getAnswers().add(newAnswer);  // Add to the poll's list of answers

					// Now save the answer using AnswerRepository
					answerRepository.save(newAnswer);  // This explicitly saves the new answer to the database

					redirectAttributes.addFlashAttribute("message", "Answer added successfully!");
					return "redirect:/answers/" + id;  // Redirect to a confirmation page or back to the poll
				})
				.orElse("redirect:/");  // Redirect to a default page if poll not found
	}
}
