package validation;

import cn.hutool.core.util.IdcardUtil;

/**
 * @program: draft
 * @description: IdCard 校验
 * @author: atong
 * @create: 2022-05-16 23:18
 */
public class IdCard {
    public static void main(String[] args) {
        boolean validCard = IdcardUtil.isValidCard("aaa");
        System.out.println(validCard);
    }
}
