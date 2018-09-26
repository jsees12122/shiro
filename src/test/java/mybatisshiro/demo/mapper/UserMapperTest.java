package mybatisshiro.demo.mapper;

import mybatisshiro.demo.vo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        User u = userMapper.selectByPrimaryKey("1");
        System.out.println();
        Assert.assertNull(u);
    }

    @Test
    public void selectByusername() {
        User u = userMapper.selectByUsername("go");
        System.out.println();
        Assert.assertNull(u);
    }
}