package web.todo.ToDoWeb.service;

import web.todo.ToDoWeb.model.ToDo;
import web.todo.ToDoWeb.model.User;


public interface ToDoService extends BaseService<ToDo, String> {

    /**
     * Get to do and list name and folder name and username
     * Throw an empty exception if to do doesn't have task
     * @param toDo at least include task
     * @param listName name of list to do add to it
     * @param folderName name of folder list belongs to
     * @param username username of user folder belongs to
     */
    void saveToDoInList(ToDo toDo, String listName, String folderName, String username);

    /**
     * Check if to do has task and update to do
     * Throw an empty exception if to do doesn't have task field
     * Throw an empty exception if to do doesn't have id
     * @param toDo the to do user wants to update
     */
    void updateToDo(ToDo toDo);

    /**
     * Delete to do from database and from folder and list
     * @param folderName name of folder list belongs to it
     * @param listName name of list to do belongs to it
     * @param userName name of user to do belongs to
     * @param toDo to do that mus have id
     */
    void deleteToDo(String folderName, String listName, String userName,ToDo toDo);

    /**
     * Save to do in category based on information user saved in to do
     * @param toDo user created
     * @param user that to do belongs to
     */
    void saveToDoInCategory(ToDo toDo, User user);
}
