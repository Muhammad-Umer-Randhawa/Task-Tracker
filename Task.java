import java.time.LocalDateTime;
public class Task{
    int id;
    String description;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Task(int id,String description,String status){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    public int getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setID(int id){
        this.id = id;
    }
}