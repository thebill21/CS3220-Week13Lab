package cs3220.week13lab.model;

import jakarta.persistence.*;
import java.util.List;

public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String question;

	private boolean singleChoice;

	@ElementCollection
	@OrderColumn
	private List<String> answers;

	public Poll(String s, boolean b) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isSingleChoice() {
		return singleChoice;
	}

	public void setSingleChoice(boolean singleChoice) {
		this.singleChoice = singleChoice;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
