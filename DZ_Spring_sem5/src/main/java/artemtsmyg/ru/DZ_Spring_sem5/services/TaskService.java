package artemtsmyg.ru.DZ_Spring_sem5.services;

import artemtsmyg.ru.DZ_Spring_sem5.model.Task;
import artemtsmyg.ru.DZ_Spring_sem5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TaskService - служебный класс, обеспечивающий функционирование сущности "Задачи" в соответствии с предназначением.
 */
@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * addTask - метод добавления задач в список.
     *
     * @param task - задача.
     * @return - сохранение задачи в БД.
     */
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * getAllTasks - метод, возвращающий список всех задач, имеющихся в БД.
     *
     * @return - список задач.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * getTaskById - метод выдачи сведений о задаче по ее номеру.
     *
     * @param id - номер задачи.
     * @return - сведения о задаче с определенным номером.
     */
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * deleteTask - метод удаления задач по ее номеру.
     *
     * @param id - номер задачи.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * updateStatusTask - метод обновления задачи.
     *
     * @param id     - номер задачи.
     * @param status - статус задачи.
     * @return список сохраненных задач или сообщение об исключении.
     */
    public Task updateStatusTask(Long id, Task.Status status) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(status);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * getTasksByStatus - метод выдачи сведений о задачах, имеющих определенный статус.
     *
     * @param status - статус задачи.
     * @return - сведения о задачах с запрошенным статусом.
     */
    public List<Task> getTasksByStatus(Task.Status status) {
        return taskRepository.getTasksByStatus(status);
    }
}
