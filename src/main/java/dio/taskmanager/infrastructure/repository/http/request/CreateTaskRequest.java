package dio.taskmanager.infrastructure.repository.http.request;

import dio.taskmanager.application.input.CreateTaskInput;

import java.util.Optional;

public record CreateTaskRequest(String title, String description) {
    public CreateTaskInput toinput(){
        return new CreateTaskInput(title, Optional.ofNullable(description));
    }
}
