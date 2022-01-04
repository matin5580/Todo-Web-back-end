package web.todo.ToDoWeb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "Planned")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Planned{

    @DBRef
    private User user;

    @DBRef
    private Set<ToDo> toDos;
}
