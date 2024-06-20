import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> subTasks;


    public Epic(int id, String title, String description, Status status, ArrayList<Integer> subTasks) {
        super(id, title, description, status);
        this.subTasks = subTasks;
    }

    public ArrayList<Integer> getSubTasks() {   // геттер для получения списка подзадач
        return subTasks;
    }

    public void setSubTasks(ArrayList<Integer> subTasks) {  // сеттер для установки списка подзадач
        this.subTasks = subTasks;
    }
}
