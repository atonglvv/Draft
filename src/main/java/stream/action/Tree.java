package stream.action;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: list结构转为tree
 * @author: atong
 * @create: 2020-12-17 19:54
 */
public class Tree {

    static List<TreeEntity> listTree = new ArrayList<>();
    static {
        listTree.add(new TreeEntity(1,"爷",0,null));
        listTree.add(new TreeEntity(2,"二爷",0,null));
        listTree.add(new TreeEntity(3,"爷-爸",1,null));
        listTree.add(new TreeEntity(4,"爷-叔",1,null));
        listTree.add(new TreeEntity(5,"二爷-爸",2,null));
        listTree.add(new TreeEntity(6,"爷-爸-大儿子",3,null));
        listTree.add(new TreeEntity(7,"爷-爸-小儿子",3,null));
        listTree.add(new TreeEntity(8,"二爷-爸-大儿子",5,null));
        listTree.add(new TreeEntity(9,"二爷-爸-小儿子",5,null));
        listTree.add(new TreeEntity(10,"爷-叔-大儿子",4,null));
        listTree.add(new TreeEntity(11,"爷-叔-小儿子",4,null));
    }

    /**
     * 获取树结构
     * @param listTree  list
     * @return List<TreeEntity>
     */
    public List<TreeEntity> selectTree(List<TreeEntity> listTree) {
        return listTree.stream().filter(treeEntity ->
                treeEntity.getParentId() == 0
        ).map((menus) ->{
            menus.setChildNodeList(getChildNode(menus,listTree));
            return menus;
        }).collect(Collectors.toList());
    }


    /**
     * 递归子节点
     * @param root   当前单个菜单
     * @param allListTree   表中的所有菜单集合
     * @return List<TreeEntity>
     */
    private List<TreeEntity> getChildNode(TreeEntity root, List<TreeEntity> allListTree){

        return allListTree.stream().filter((treeEntity) -> {
            return treeEntity.getParentId().equals(root.getId());
        }).map((treeEntity)->{
            treeEntity.setChildNodeList(getChildNode(treeEntity,allListTree));
            return treeEntity;
        }).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Tree().selectTree(listTree)));
    }

}
