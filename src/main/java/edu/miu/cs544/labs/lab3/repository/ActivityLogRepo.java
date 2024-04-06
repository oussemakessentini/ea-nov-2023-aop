package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends ListCrudRepository<ActivityLog, Long> {
}
