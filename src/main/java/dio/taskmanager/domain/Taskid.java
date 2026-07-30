package dio.taskmanager.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record Taskid(UUID id) {
    public Taskid {
        Assert.notNull(id,"ID must not to be null");
    }
    public Taskid() {
        this(UUID.randomUUID());
    }

}
