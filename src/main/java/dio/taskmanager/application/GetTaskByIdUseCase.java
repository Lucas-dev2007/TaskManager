package dio.taskmanager.application;

import dio.taskmanager.application.output.TaskOutput;
import dio.taskmanager.domain.TaskNotFoundException;
import dio.taskmanager.domain.TaskRepository;
import dio.taskmanager.domain.Taskid;
import org.springframework.stereotype.Service;


@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }
    public TaskOutput execute(Taskid id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(()-> new TaskNotFoundException(id));
    }
}
