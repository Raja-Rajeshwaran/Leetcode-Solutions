class TaskManager {
    static class Task {
        int userId, taskId, priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private TreeSet<Task> tasks;
    private Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> initTasks) {
        tasks = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : initTasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        tasks.add(t);
        taskMap.put(taskId, t);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        tasks.remove(old);
        Task updated = new Task(old.userId, taskId, newPriority);
        tasks.add(updated);
        taskMap.put(taskId, updated);
    }

    public void rmv(int taskId) {
        Task t = taskMap.remove(taskId);
        tasks.remove(t);
    }

    public int execTop() {
        if (tasks.isEmpty()) return -1;
        Task top = tasks.pollFirst();
        taskMap.remove(top.taskId);
        return top.userId;
    }
}
