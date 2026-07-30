package dio.taskmanager.application;

import dio.taskmanager.application.input.UpdateTaskInput;
import dio.taskmanager.application.output.TaskOutput;
import dio.taskmanager.domain.TaskNotFoundException;
import dio.taskmanager.domain.TaskRepository;
import dio.taskmanager.domain.Taskid;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;
    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(Taskid id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var update = repository.save(task);
        return TaskOutput.from(update);


    }
}
