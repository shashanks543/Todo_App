package com.mavenproject.TodoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class TodoController {
    @Autowired
    List<Todo> todoList;

    //create todos -Post APIs

    //add a todo:
    @PostMapping("api/todo")
    public String addTodo(@RequestBody Todo myTodo)
    {
        todoList.add(myTodo);
        return "todo added";
    }
    //add a list of todos:
    @PostMapping("api/todoList")
    public String addTodo(@RequestBody List<Todo> myTodos)
    {
//        for(Todo todo : myTodos)
//        {
//            todoList.add(todo);
//        }
        todoList.addAll(myTodos);

        return myTodos.size() + " todo were added";
    }

    //get api


    //get all todos:
    
    @GetMapping("api/todos")
    public List<Todo> getAllTodo()
    {
        return todoList;
    }

    // I want all the tasks which are undone
    @GetMapping("api/todoList/unDone")
    public List<Todo> getAllUndoneTodos()
    {
//       return todoList.stream().filter(todo -> !todo.isTodoStatus()).collect(Collectors.toList());

       List<Todo> unDoneTodo = new ArrayList<>();
       for (Todo todo : todoList)
       {
           if(!todo.isTodoStatus())
           {
               unDoneTodo.add(todo);
           }
       }
       return unDoneTodo;
    }

    //update todo:

    //send a todo id: id1 and status:s1
    @PutMapping("api/todo/id/{id}/status")
    public String setTodoStatusById(@PathVariable Integer id, @RequestParam boolean flag)
    {
        for (Todo todo: todoList)
        {
            if(todo.getTodoId().equals(id))
            {
                todo.setTodoStatus(flag);
                return "todo: " + id + "updated to " + flag;
            }
        }
        return "Invalid Id";
    }

    //delete api: id
    @DeleteMapping("api/todo/id/{id}")
    public String removedTodoById(@PathVariable Integer id)
    {
        for (Todo todo: todoList)
        {
            if(todo.getTodoId().equals(id))
            {
                todoList.remove(todo);
                return "todo:" + " " + id + " " + "deleted.";
            }
        }
        return "Invalid Id";
    }

    // delete todos by Ids
    @DeleteMapping("api/todo/ids")
    public List<Todo> deleteTodoById(@RequestBody List<Integer> idList)
    {
//        for (Todo todo : todoList)
//        {
//           for (Integer id : idList)
//           {
//               if(todo.getTodoId().equals(id))
//               {
//                   todoList.remove(todo);
////                   return "todo:" + " " + id + " " + "deleted.";
//               }
//           }
//        }

//        for (int idx=0;idx<todoList.size();idx++)
//        {
//            Todo todo = todoList.get(idx);
//            for (int idxs=0;idxs<idList.size();idxs++)
//            {
//                if (todo.getTodoId().equals(idList.get(idxs)))
//                {
//                    todoList.remove(todo);
//                }
//            }
//        }

        for (Integer id : idList)
        {
            for (int idx=0;idx<todoList.size();idx++)
            {
                if (id.equals(todoList.get(idx).getTodoId()))
                {
                    todoList.remove(todoList.get(idx));
                    break;
                }
            }
        }
        return todoList;
    }

    //add a list of todos
    @PostMapping("api/todoList/")
    public String addTodos(@RequestBody List<Todo> myTodos)
    {
//        for (Todo todo : myTodos)
//        {
//            todoList.add(todo);
//        }

        todoList.addAll(myTodos);
        return myTodos.size() + " " + "todos were added";
    }

    //get all done todos
}
