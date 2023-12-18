package adraft;

import common.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2022-01-07 16:44
 */
public class Draft {
    public static void main(String[] args) {
        User user1 = new User(null, "atong", null);
        User user2 = new User(1L, "cc", null);
        User user3 = new User(2L, null, null);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        /*
         * value 值为null 的话, 就会造成 npe
         */
        Map<Long, String> collect = users.stream().collect(Collectors.toMap(User::getId, User::getName));
        System.out.println(collect.toString());
    }
}
