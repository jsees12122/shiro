package mybatisshiro.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class TestController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public HashMap login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        HashMap res = new HashMap();
        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                //将存有用户名和密码的token存进subject中
                subject.login(token);
            }catch (UnknownAccountException uae){
                System.out.println("没有用户名为"+token.getPrincipal()+"的用户");
            } catch (IncorrectCredentialsException ice){
                System.out.println("用户名为："+token.getPrincipal()+"的用户密码不正确");
            } catch (LockedAccountException lae){
                System.out.println("用户名为："+token.getPrincipal()+"的用户已被冻结");
            } catch (AuthenticationException e){
                System.out.println("未知错误！");
            }
            finally {
                res.put("message","登陆成功");
            }
        }else {
            res.put("message","已经登陆");
        }

        return res;
    }
}
