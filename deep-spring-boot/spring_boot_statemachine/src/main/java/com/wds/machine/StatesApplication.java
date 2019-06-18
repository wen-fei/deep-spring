package com.wds.machine;

import com.wds.machine.event.Events;
import com.wds.machine.event.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import javax.swing.plaf.nimbus.State;

/**
 * @author : TenYun
 * @date : 2019-06-18 18:22
 * @description :
 **/
@SpringBootApplication
public class StatesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StatesApplication.class, args);
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
