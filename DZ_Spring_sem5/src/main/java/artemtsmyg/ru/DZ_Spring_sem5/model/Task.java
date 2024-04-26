package artemtsmyg.ru.DZ_Spring_sem5.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Класс задачи
 */

@Data
@Entity
@Table(name = "tasks")
public class Task {
    /**
     * Перечисление статусов задачи
     */
    public enum Status {TEMP, NOT_STARTED, IN_PROGRESS, COMPLETED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Описание задачи
     */
    @Column(nullable = false)
    private String description;
    /**
     * Текущий статус задачи
     */
    @Column(nullable = false)
    private Status status;
    /**
     * Время создания задачи
     */
    @Column
    private LocalDateTime local_date_time = LocalDateTime.now();
}