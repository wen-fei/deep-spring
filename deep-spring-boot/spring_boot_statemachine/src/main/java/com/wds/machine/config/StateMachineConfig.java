package com.wds.machine.config;

import com.wds.machine.event.Events;
import com.wds.machine.event.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * @author : TenYun
 * @date : 2019-06-18 16:48
 * @description :
 **/

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 初始化状态机拥有的状态
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.UNPAID)
                .states(EnumSet.allOf(States.class));
    }


    /**
     * 定义状态迁移动作
     * 命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event。
     * @param transitions
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                    .source(States.UNPAID).target(States.WAITING_FOR_PECEIVE)
                    .event(Events.PAY)
                    .and()
                .withExternal()
                    .source(States.WAITING_FOR_PECEIVE).target(States.DONE)
                    .event(Events.RECEIVE);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                // 指定状态机的处理监听器
                .listener(listener());
    }


    /**
     * 状态监听器的实例
     * 定义具体的状态迁移处理逻辑，上面的实现中只是做了一些输出，实际业务场景会会有更负责的逻辑
     * 所以通常情况下，我们可以将该实例的定义放到独立的类定义中，并用注入的方式加载进来。
     * @return
     */
    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>(){
            @Override
            public void transition(Transition<States, Events> transition) {
                if (transition.getTarget().getId() == States.UNPAID) {
                    logger.info("订单创建，待支付");
                    return;
                }

                if (transition.getSource().getId() == States.UNPAID &&
                        transition.getTarget().getId() == States.WAITING_FOR_PECEIVE) {
                    logger.info("用户支付完成，待收货");
                    return;
                }

                if (transition.getSource().getId() == States.WAITING_FOR_PECEIVE &&
                        transition.getTarget().getId() == States.DONE) {
                    logger.info("用户已收货，订单已完成");
                    return;
                }
            }
        };
    }
}
