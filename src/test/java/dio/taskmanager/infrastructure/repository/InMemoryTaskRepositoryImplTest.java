package dio.taskmanager.infrastructure.repository;


import dio.taskmanager.domain.Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryTaskRepositoryImplTest {

    private InMemoryTaskRepositoryImpl taskRepository;
    @BeforeEach
    void setUp() {
        taskRepository = new InMemoryTaskRepositoryImpl();
    }

    @Test
    void findById(){
        var task = taskRepository.save(new Task("Tarefa A", Optional.empty()));
        var returnId = taskRepository.findById(task.getId());
        assertTrue(returnId.isPresent());
        assertEquals(task.getId(), returnId.get().getId());
    }
    @Test
    void save(){
        var task = taskRepository.save(new Task("Tarefa A", Optional.empty()));
        assertThat(task).isNotNull();
        assertThat(task.getId()).isNotNull();
        assertThat(task.getTitle()).isEqualTo("Tarefa A");
    }
    @Test
    void findAll(){
        var task1 = taskRepository.save(new Task("Tarefa 1", Optional.empty()));
        var task2 = taskRepository.save(new Task("Tarefa 2", Optional.empty()));

        List<Task> result = taskRepository.findAll();

        assertThat(result)
                .isNotNull()
                .containsExactlyInAnyOrder(task1, task2);
    }
    @Test
    void delete(){
        var task = taskRepository.save(new Task("Tarefa A", Optional.empty()));
        taskRepository.delete(task.getId());

        var result = taskRepository.findById(task.getId());
        assertThat(result).isEmpty();
    }
}