public class Main{
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.loadTasks();
        if(args.length == 0){
            System.out.println("No Command provided!");
            return;
        }
        String command = args[0];
        switch(command){
            case "add": {
                if (args.length < 2) {
                    System.out.println("Usage: add <task>");
                    return;
                }
                String description = args[1];
                manager.addTask(description);
                break;
            }
            case "delete":
                if(args.length < 2){
                    System.out.println("Usage: delete <id>");
                    return;
                }
                int id1 = Integer.parseInt(args[1]);
                manager.deleteTask(id1);
                break;
            case "update": {
                if (args.length < 3) {
                    System.out.println("Usage: update <id> <description>");
                    return;
                }
                int id = Integer.parseInt(args[1]);
                String description = args[2];
                manager.updateTask(id, description);
                break;
            }
            case "list":
                if(args.length < 2){
                    System.out.println("Enter status(Usage: list <status>");
                    return;
                } 
                String status = args[1];
                switch(status){
                    case "all":
                        manager.listTasks("all");
                        break;
                    case "done":
                        manager.listTasks("done");
                        break;
                    case "todo":
                        manager.listTasks("todo");
                        break;
                    case "in-progress":
                        manager.listTasks("in-progress");
                        break;
                    default:
                        System.out.println("Invalid task status");
                } 
                break;
            case "mark":
                if(args.length < 3){
                    System.out.println("Usage: mark <status> <id>");
                    return;
                } 
                String markStatus = args[1];
                String id = args[2];
                switch(markStatus){
                    case "done":
                        manager.markTask(Integer.parseInt(id), "done");
                        break;
                    case "in-progress":
                        manager.markTask(Integer.parseInt(id), "in-progress");
                        break;
                    default:
                        System.out.println("Invalid status for mark");
                }
                break;
            default:
                System.out.println("Enter a valid Command!!!");
                break;
        }
    }
}