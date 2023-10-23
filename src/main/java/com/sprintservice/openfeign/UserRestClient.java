package com.sprintservice.openfeign;

import com.sprintservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserRestClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable(name="id") Long id);
}
