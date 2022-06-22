package mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-06-22 16:42
 */
@Mapper
public interface UserConverter {
    UserConverter MAPPER = Mappers.getMapper(UserConverter.class);

    List<User> studentsToUsers(List<Student> students);

    @Mapping(source = "time", target = "graduationTime")
    User studentToUseraaa(Student student);
}
