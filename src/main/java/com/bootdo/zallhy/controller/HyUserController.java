package com.bootdo.zallhy.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.zallhy.domain.HyUserDO;
import com.bootdo.zallhy.service.HyUserService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汉艺user表
 * 
 * @author barry
 * @email 1992lcg@163.com
 * @date 2017-12-26 14:41:55
 */
 
@Controller
@RequestMapping("/zallhy/hyUser")
public class HyUserController {
	@Autowired
	private HyUserService hyUserService;
	
	@GetMapping()
	@RequiresPermissions("zallhy:hyUser:hyUser")
	String HyUser(){
	    return "zallhy/hyUser/hyUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zallhy:hyUser:hyUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HyUserDO> hyUserList = hyUserService.list(query);
		int total = hyUserService.count(query);
		PageUtils pageUtils = new PageUtils(hyUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	/*@RequiresPermissions("zallhy:hyUser:add")*/
	String add(){
	    return "zallhy/hyUser/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("zallhy:hyUser:edit")
	String edit(@PathVariable("userId") String userId,Model model){
		HyUserDO hyUser = hyUserService.get(userId);
		model.addAttribute("hyUser", hyUser);
	    return "zallhy/hyUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zallhy:hyUser:add")
	public R save( HyUserDO hyUser){
		if(hyUserService.save(hyUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zallhy:hyUser:edit")
	public R update( HyUserDO hyUser){
		hyUserService.update(hyUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zallhy:hyUser:remove")
	public R remove( String userId){
		if(hyUserService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zallhy:hyUser:batchRemove")
	public R remove(@RequestParam("ids[]") String[] userIds){
		hyUserService.batchRemove(userIds);
		return R.ok();
	}
	
}
