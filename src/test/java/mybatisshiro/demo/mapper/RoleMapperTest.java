package mybatisshiro.demo.mapper;

import mybatisshiro.demo.vo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    private RoleMapper mapper;
    @Test
    public void selectByKey() {
        Role r = mapper.selectByKey("1");
        System.out.println(r.getRname());
    }
}