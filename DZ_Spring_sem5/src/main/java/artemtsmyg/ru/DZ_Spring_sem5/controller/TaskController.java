package artemtsmyg.ru.DZ_Spring_sem5.controller;

import artemtsmyg.ru.DZ_Spring_sem5.model.Task;
import artemtsmyg.ru.DZ_Spring_sem5.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * class TaskController - реализующий методы обработки запросов и управления потоком данных между клиентом и БД.
 */

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor

public class TaskController {
    private final TaskService taskService;
    /**
     * Получить все задачи
     *
     * @return список всех задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    /**
     * Добавить задачу
     *
     * @param task задача для добавления
     * @return добавленная задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    /**
     * Обновить статус задачи
     *
     * @param id     идентификатор задачи
     * @param status новый статус задачи
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task.Status status) {
        return taskService.updateStatusTask(id, status);
    }
    /**
     * Получить задачу по идентификатору
     *
     * @param id идентификатор задачи
     * @return задача с указанным идентификатором, если она существует
     */
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    /**
     * Получить список задач по статусу
     *
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.Status status) {
        return taskService.getTasksByStatus(status);
    }
    /**
     * Удалить задачу по идентификатору
     *
     * @param id идентификатор задачи для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}