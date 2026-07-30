package dio.taskmanager.domain;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Taskid taskid) {
        super("Task with id " + taskid + "not found");
    }
}

