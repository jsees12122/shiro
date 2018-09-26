package mybatisshiro.demo.controller;

import mybatisshiro.demo.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
@RestController
@RequestMapping("/go")
public class PermissionController {

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @RequiresPermissions(value = "go")
    public Map go(){
        System.out.println("test");
        Subject sub = SecurityUtils.getSubject();
        User u = (User) sub.getPrincipals().getPrimaryPrincipal();
        System.out.println(u.getUsername());
        AuthenticationToken token = new UsernamePasswordToken("fdf","fsdf");
        sub.login(token);
        HashMap map = new HashMap();
        Hashtable hashtable = new Hashtable();

        return null;
    }

    @RequestMapping("403")
    public void error(){
        System.out.println("403");
    }
}
