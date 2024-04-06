package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import edu.miu.cs544.labs.lab3.repository.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo repo;
    @Override
    public void save(ActivityLog log) {
        repo.save(log);
    }
}
