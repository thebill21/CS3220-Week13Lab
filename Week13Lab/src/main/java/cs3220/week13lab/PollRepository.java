package cs3220.week13lab;

import cs3220.week13lab.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> {
    // Custom database queries can be defined here
}
