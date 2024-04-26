package artemtsmyg.ru.DZ_Spring_sem5.repository;

import artemtsmyg.ru.DZ_Spring_sem5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface TaskRepository расширяет интерфейс JpaRepository.
 */

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получить список задач по статусу.
     * @param status статус задачи
     * @return список задач с указанным статусом
     */

    List<Task> getTasksByStatus(Task.Status status);
}