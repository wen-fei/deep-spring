package com.wds.hystrix.command;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;
import com.wds.hystrix.entity.User;
import com.wds.hystrix.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : TenYun
 * @date : 2019-06-19 21:42
 * @description :
 **/
public class UserCollapseCommand extends HystrixCollapser<List<User>, User, Long> {

    private UserService userService;
    private Long userId;

    public UserCollapseCommand(UserService userService, Long userId) {
        // 为请求合并器设置了时间延迟属性
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("userCollapseCommand")).andCollapserPropertiesDefaults(
                HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)
        ));
        this.userService = userService;
        this.userId = userId;
    }

    @Override
    public Long getRequestArgument() {
        return userId;
    }

    /**
     * @param collapsedRequests 保存了延迟时间窗口中收集到的所有获取单个User的请求
     * @return
     */
    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        List<Long> userIds = new ArrayList<>(collapsedRequests.size());
        userIds.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService, userIds);
    }


    /**
     * 批量请求命令实例被触发执行完成后此方法开始执行
     * @param batchResponse 保存了createCommand中组织的批量请求命令的返回结果
     * @param collapsedRequests 代表了每个被合并的请求
     */
    @Override
    protected void mapResponseToRequests(List<User> batchResponse,
                                         Collection<CollapsedRequest<User, Long>> collapsedRequests) {

        int count = 0;
        /**
         * 遍历请求结果对象，为collapsedRequest中每个合并前的单个请求设置返回结果
         * 以此完成批量结果到单个请求结果的转换
         */
        for (CollapsedRequest<User, Long> collapsedRequest: collapsedRequests) {
            User user = batchResponse.get(count++);
            collapsedRequest.setResponse(user);
        }
    }
}
