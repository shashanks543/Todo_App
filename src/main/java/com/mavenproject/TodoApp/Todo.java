package com.mavenproject.TodoApp;

public class Todo {

    private Integer todoId;
    private String todoName;
    private Boolean todoStatus;

    public Todo(Integer todoId, String todoName, Boolean todoStatus) {
        this.todoId = todoId;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean isTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
