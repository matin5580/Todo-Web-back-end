package web.todo.ToDoWeb.service.impl;

import org.springframework.stereotype.Service;
import web.todo.ToDoWeb.enumeration.Category;
import web.todo.ToDoWeb.exception.NotFoundException;
import web.todo.ToDoWeb.model.ToDo;
import web.todo.ToDoWeb.model.User;
import web.todo.ToDoWeb.repository.UserRepository;
import web.todo.ToDoWeb.service.TasksService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl extends BaseServiceImpl<User, String, UserRepository> implements TasksService {

    private final UserRepository userRepository;

    public TasksServiceImpl(UserRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }


    @Override
    public Set<ToDo> get(String username) {
        User user = userRepository.findByIdAndIsDeletedFalse(username)
                .orElseThrow(() -> new NotFoundException("No user found with provided username"));

        return user.getToDos()
                .stream()
                .peek(toDo -> {
                    toDo.setComments(null);
                    toDo.setLikes(null);
                }).filter(toDo -> toDo.getCategory().equals(Category.TASKS))
                .collect(Collectors.toSet());
    }
}
