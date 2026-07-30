package dio.taskmanager.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
public class Task {
    private Taskid id;
    private String title;
    private Optional<String> description;
    private TaskStatus status;

    public Task(String title,  Optional<String> description) {
        Assert.notNull(title, "title must not to be null");
        this.id = new Taskid();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.PENDING;

    }
    public void update(Optional<String> title, Optional<String> description, Optional<TaskStatus> status ){

        title.ifPresent(this::setTitle);
        description.ifPresent(d -> this.setDescription(Optional.of(d)));
        status.ifPresent(this::setStatus);
    }
}
