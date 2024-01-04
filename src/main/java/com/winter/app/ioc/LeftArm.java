package com.winter.app.ioc;

import org.springframework.stereotype.Component;


public class LeftArm extends Arm {

	@Override
	public void act() {
		System.out.println("왼쪽팔");
		
	}
}
