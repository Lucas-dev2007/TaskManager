package dio.taskmanager.infrastructure;

import dio.taskmanager.domain.Task;
import dio.taskmanager.domain.TaskRepository;
import dio.taskmanager.domain.Taskid;

import java.util.List;
import java.util.Optional;

public class InMemoryTaskRepositoryImpl implements TaskRepository {
    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findbyid(Taskid id) {
        return Optional.empty();
    }

    @Override
    public void delete(Task id) {

    }
}
