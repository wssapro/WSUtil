package cn.ws.blazefire.log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-04-07 11:15
 */
public class CacheUtil {

    private static final HashMap<Integer, ConcurrentLinkedDeque<Object>> map = new HashMap<>();

    private static final HashSet<Integer> userIdSet = new HashSet<>();

    public static Object getCache(Integer id) {
        ConcurrentLinkedDeque<Object> queue = map.get(id);
        return queue.poll();
    }


    public static void addCache(Integer id, Integer userId, Object object) {
        if (userIdSet.contains(userId)) {
            return;
        }
        userIdSet.add(userId);
        ConcurrentLinkedDeque<Object> queue = map.get(id);
        if (queue == null) {
            queue = new ConcurrentLinkedDeque<>();
            map.put(id, queue);
        }
        queue.offer(object);
    }


    public static int getSize(Integer id) {
        ConcurrentLinkedDeque<Object> queue = map.get(id);
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }
}
