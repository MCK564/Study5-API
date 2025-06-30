package feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", path = "${api.prefix/users}")
public class UserClient {

}
