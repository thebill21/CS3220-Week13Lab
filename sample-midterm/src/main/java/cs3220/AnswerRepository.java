package cs3220;

import cs3220.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
//    Object findByPollId(Integer id);
    List<Answer> findByPollId(Integer id);
}