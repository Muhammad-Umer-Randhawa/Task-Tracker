import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();
    int nextId = 1;
    Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    public void saveTasks(){
        try(Writer writer = new FileWriter("tasks.json")){
            gson.toJson(tasks, writer);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public void addTask(String description){
        Task task = new Task(nextId, description, "todo");
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully (ID: " + nextId + ")");
        nextId += 1;
    }
    public void loadTasks(){
        try(Reader reader = new FileReader("tasks.json")){
            Type listType = new TypeToken<ArrayList<Task>>(){}.getType();
            tasks = gson.fromJson(reader, listType);
            if(tasks == null) tasks = new ArrayList<>();
            if(!tasks.isEmpty()) nextId = tasks.get(tasks.size() - 1).getId() + 1;
            
        }
        catch(FileNotFoundException e){
            
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public void listTasks(String status){
        for(Task t: tasks){
            if(status.equals("all")){
                System.out.println(t.getId() + ". " + t.getDescription());
            }
            else if(t.getStatus().equals(status)){
                System.out.println(t.getId() + ". " + t.getDescription());
            }
        }
    }
    public void markTask(int id, String status){
        for(Task t: tasks){
            if(t.getId() == id){
                t.setStatus(status);
                saveTasks();
                System.out.println("Task " + id + " marked as " + status);
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }
    public void updateTask(int id, String newDescription){
        for(Task t: tasks){
            if(t.getId() == id){
                t.setDescription(newDescription);
                t.setUpdatedAt();
                saveTasks(); 
                System.out.println("Task updated successfully");
                return;
            }
        }
        System.out.println("No task found of the id " + id);
    }
    public void deleteTask(int id){
        for(Task t: tasks){
            if(t.getId() == id){
                tasks.remove(t);
                saveTasks(); 
                System.out.println("Task deleted successfully");
                return;
            }
        }
        System.out.println("No task found of the id " + id);
    }
}
