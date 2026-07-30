package dio.taskmanager.infrastructure.repository;

import dio.taskmanager.domain.Task;
import dio.taskmanager.domain.TaskRepository;
import dio.taskmanager.domain.Taskid;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryTaskRepositoryImpl implements TaskRepository {
    private final Map<Taskid, Task> storage = new HashMap<>();
    @Override
    public Task save(Task task) {
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Task> findById(Taskid id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void delete(Taskid id) {
        storage.remove(id);

    }
}
