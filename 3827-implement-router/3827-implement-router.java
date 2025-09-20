class Router {
    static class Packet {
        int src, dest, time;
        Packet(int s, int d, int t) { src = s; dest = d; time = t; }
    }

    private Deque<Packet> queue;
    private Set<String> seen;
    private int memory;
    private Map<Integer, List<Integer>> destTimestamps;

    public Router(int memoryLimit) {
        this.memory = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.destTimestamps = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false;
        if (queue.size() == memory) {
            Packet old = queue.poll();
            String oldKey = old.src + "#" + old.dest + "#" + old.time;
            seen.remove(oldKey);
            List<Integer> list = destTimestamps.get(old.dest);
            int idx = Collections.binarySearch(list, old.time);
            if (idx >= 0) list.remove(idx);
        }
        Packet p = new Packet(source, destination, timestamp);
        queue.offer(p);
        seen.add(key);
        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destTimestamps.get(destination).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        Packet p = queue.poll();
        String key = p.src + "#" + p.dest + "#" + p.time;
        seen.remove(key);
        List<Integer> list = destTimestamps.get(p.dest);
        int idx = Collections.binarySearch(list, p.time);
        if (idx >= 0) list.remove(idx);
        return new int[]{p.src, p.dest, p.time};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;
        List<Integer> list = destTimestamps.get(destination);
        if (list.isEmpty()) return 0;
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return Math.max(0, right - left);
    }

    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
