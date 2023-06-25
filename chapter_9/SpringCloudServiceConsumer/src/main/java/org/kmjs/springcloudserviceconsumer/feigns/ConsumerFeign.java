package org.kmjs.springcloudserviceconsumer.feigns;

import org.kmjs.springcloudserviceconsumer.domian.DomainUser;
import org.kmjs.springcloudserviceconsumer.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="SERVICE-PROVIDER")
public interface ConsumerFeign {
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public Result<DomainUser> getUser(@RequestParam("id") int id);
	
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public Result<String> addUser(@RequestBody DomainUser user);
}
