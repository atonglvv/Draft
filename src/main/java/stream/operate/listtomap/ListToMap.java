package stream.operate.listtomap;

import com.alibaba.fastjson.JSON;
import common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-07-27 17:19
 */
public class ListToMap {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L).setAge(20);
        User user1 = new User();
        user1.setId(2L).setAge(21);
        User user2 = new User();
        user2.setId(3L).setAge(22);
        User user3 = new User();
        user3.setId(4L).setAge(23);
        User user4 = new User();
        user4.setId(5L).setAge(24);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user);

        // npe 因为 Name没有数据
        /*Map<Long, String> collect = users.stream().collect(Collectors.toMap(User::getId, User::getName));
        System.out.println(JSON.toJSON(collect));*/

        Map<Long, String> collect = users.stream()
                .collect(Collectors.toMap(User::getId, item -> Optional.ofNullable(item.getName()).orElse("")));
        System.out.println(JSON.toJSON(collect));
    }
}
