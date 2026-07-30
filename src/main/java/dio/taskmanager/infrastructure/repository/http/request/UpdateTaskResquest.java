package dio.taskmanager.infrastructure.repository.http.request;

import dio.taskmanager.application.UpdateTaskUseCase;
import dio.taskmanager.application.input.UpdateTaskInput;
import dio.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskResquest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
){
    public UpdateTaskInput toinput(){
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
