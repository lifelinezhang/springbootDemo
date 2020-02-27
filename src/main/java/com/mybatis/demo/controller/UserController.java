package com.mybatis.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.demo.pojo.Permission;
import com.mybatis.demo.pojo.Role;
import com.mybatis.demo.pojo.RolePermission;
import com.mybatis.demo.pojo.User;
import com.mybatis.demo.service.PermissionService;
import com.mybatis.demo.service.RolePermissionService;
import com.mybatis.demo.service.UserRoleService;
import com.mybatis.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PermissionService permissionService;


    @PostMapping("/add")
    public int insertUser(@RequestBody Map<String, Object> requestMap){
        System.out.println(requestMap);
        User user = new User();
        user.setUserId(Integer.parseInt((String) requestMap.get("id")));
        user.setUserName((String)requestMap.get("name"));
        user.setPassword((String)requestMap.get("password"));
        user.setPhone((String)requestMap.get("phone"));
        return userService.insert(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> requestMap) {
        System.out.println("此时正在进行登录操作" + requestMap);
        Subject currentUser = SecurityUtils.getSubject();
        String name = (String) requestMap.get("name");
        String password = (String) requestMap.get("password");
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            // 执行登陆
            currentUser.login(token);
            return "success";
        } catch (UnknownAccountException e) {
            System.out.println("用户未注册!");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误!!");
        } catch (LockedAccountException e) {
            System.out.println("该账户不可用~");
        } catch (ExcessiveAttemptsException e) {
            System.out.println("尝试次数超限!!");
        }
        return "fail";
    }

    @PostMapping("/getInfo")
    public List getUserInfo(@RequestBody JSONObject requestJson) {
        String userName = requestJson.getString("username");
        // 获取用户角色
        User queryUser = new User();
        queryUser.setUserName(userName);
        String[] roles = userRoleService.getRolesByUserName(queryUser);
        // 根据角色获取权限id
        List<String> permissionList = new ArrayList<String>();
        for (int i = 0; i < roles.length; i++) {
            RolePermission queryRolePermission = new RolePermission();
            queryRolePermission.setRoleId(Integer.parseInt(roles[i]));
            List<String> permissions = rolePermissionService.getPermissionByRole(queryRolePermission);
            permissionList.addAll(permissions);
        }
        // 根据权限id获取权限内容
        List<Permission> resultList = new ArrayList<>();
        permissionList.stream().forEach(e -> {
            Permission permission = permissionService.selectByPrimaryKey(Integer.parseInt(e));
            resultList.add(permission);
        });
        // 整理权限的具体内容
        Set<String> permissionSet = new HashSet<>();
        resultList.forEach(e -> permissionSet.add(e.getPermissionCode()));
        // 将权限放到session里面
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("permission", permissionSet);
        return resultList;
    }


}
