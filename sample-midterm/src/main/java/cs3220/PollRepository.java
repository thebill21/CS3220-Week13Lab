package cs3220;

import cs3220.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> {
    // Custom database queries can be defined here
}
