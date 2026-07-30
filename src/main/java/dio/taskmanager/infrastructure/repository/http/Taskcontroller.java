package dio.taskmanager.infrastructure.repository.http;

import dio.taskmanager.application.CreateTaskUseCase;
import dio.taskmanager.application.DeleteTaskUseCase;
import dio.taskmanager.application.GetTaskByIdUseCase;
import dio.taskmanager.application.GetTasksUseCase;
import dio.taskmanager.application.UpdateTaskUseCase;
import dio.taskmanager.application.input.UpdateTaskInput;
import dio.taskmanager.domain.Taskid;
import dio.taskmanager.infrastructure.repository.http.request.CreateTaskRequest;
import dio.taskmanager.infrastructure.repository.http.request.UpdateTaskResquest;
import dio.taskmanager.infrastructure.repository.http.response.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class Taskcontroller {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTasksUseCase getTasksUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;

    public Taskcontroller(CreateTaskUseCase createTaskUseCase, GetTasksUseCase getTasksUseCase, GetTaskByIdUseCase getTaskByIdUseCase, DeleteTaskUseCase deleteTaskUseCase, UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTasksUseCase = getTasksUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }
    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request){
        var input = request.toinput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }

    @GetMapping
    List<TaskResponse> list(){
        return getTasksUseCase.execute().stream().map(TaskResponse::from).toList();
    }
    @GetMapping("/{id}")
    TaskResponse read(@PathVariable UUID id){
        var output = getTaskByIdUseCase.execute(new Taskid(id));
        return TaskResponse.from(output);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id){
        deleteTaskUseCase.execute(new Taskid(id));
    }
    @PatchMapping("/{id}")
    TaskResponse update(@PathVariable UUID id, @RequestBody UpdateTaskResquest request){
        var input = request.toinput();
        var output = updateTaskUseCase.execute(new Taskid(id), input);
        return TaskResponse.from(output);

    }
}
