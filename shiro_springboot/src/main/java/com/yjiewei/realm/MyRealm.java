package com.yjiewei.realm;

import com.yjiewei.entity.TUser;
import com.yjiewei.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 自定义realm：是shiro和应用之间的桥梁
 * 做认证和授权的内容
 * @author yjiewei
 * @date 2021/10/22
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private TUserService userService;

    /**
     * 用来验证当前登录的用户，获取认证信息
     * 这里是在前面已经登录成功了？
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new
                SimpleAuthorizationInfo();
        // 给该用户设置角色，角色信息存在t_role表中取
        authorizationInfo.setRoles(userService.getRoles(username));
        // 给该用户设置权限，权限信息存在t_permission表中取
        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        return authorizationInfo;
    }

    /**
     * 用来为当前登陆成功的用户授予权限和角色
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据token获取用户名，如果您不知道该该token怎么来的，先可以不管，下文会解释
        String username = (String) authenticationToken.getPrincipal();
        // 根据用户名从数据库中查询该用户
        TUser user = userService.getByUsername(username);
        if(user != null) {
            // 把当前用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authcInfo = new
                    SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
