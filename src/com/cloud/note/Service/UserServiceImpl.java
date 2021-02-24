package com.cloud.note.Service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.note.dao.UserDao;
import com.cloud.note.entity.NoteResult;
import com.cloud.note.entity.User;
import com.cloud.note.util.NoteUtil;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userdao;
	public NoteResult register(String name,String password,String nick) throws Exception {
		NoteResult result=new NoteResult();
		// TODO Auto-generated method stub
		User user=new User();
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_name(name);
		user.setCn_user_passwd(NoteUtil.md5(password));
		user.setCn_user_nick(nick);
		if(userdao.selectCountByName(name)==0) {
		userdao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");}
		else
		{
			result.setStatus(1);
			result.setMsg("该用户名已经存在，注册失败");
		}
		return result;
	}
	@Override
	public NoteResult checkLogin(String name, String password) throws NoSuchAlgorithmException {
		NoteResult result=new NoteResult();

		User user=userdao.findByName(name);
		if(user==null)
		{			result.setStatus(1);
            
			result.setMsg("用户名不存在");
		}
		else if(!user.getCn_user_password().equals(NoteUtil.md5(password)))
		{
			System.out.println(user.getCn_user_password());
			System.out.println(NoteUtil.md5(password));
			result.setStatus(2);
             
			result.setMsg("密码错误");
		}
		else
		{
			result.setMsg("登录成功");
			result.setStatus(0);
			//登陆成功后把当前的登录者的id记录下来
			result.setData(user.getCn_user_id());
		}
		return result;
	}
	@Override
	public NoteResult changePassword(String userId, String last_password, String new_password) throws NoSuchAlgorithmException {
		NoteResult result=new NoteResult();
		String real_password=userdao.selectPasswordByUserId(userId);
		String last_password1=NoteUtil.md5(last_password);
		if(!real_password.equals(last_password1))
		{
			result.setStatus(1);
			result.setMsg("修改失败，原密码错误");
		}
		else
		{  String new_password1=NoteUtil.md5(new_password);
			userdao.updatePassword(userId, new_password1);
			result.setStatus(0);
			result.setMsg("修改成功");
		}
		return result;
	}

}
