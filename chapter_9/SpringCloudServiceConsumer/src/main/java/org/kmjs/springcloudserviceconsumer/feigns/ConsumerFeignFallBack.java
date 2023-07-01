package org.kmjs.springcloudserviceconsumer.feigns;

import org.kmjs.springcloudserviceconsumer.domian.DomainUser;
import org.springframework.stereotype.Component;
import org.kmjs.springcloudserviceconsumer.result.Result;
import org.kmjs.springcloudserviceconsumer.result.ResultCode;

@Component
public class ConsumerFeignFallBack implements ConsumerFeign{

	@Override
	public Result<DomainUser> getUser(int id) {
		return new Result<>(ResultCode.Unavailable);
	}

	@Override
	public Result<String> addUser(DomainUser user) {
		return new Result<>(ResultCode.Unavailable);
	}
}
