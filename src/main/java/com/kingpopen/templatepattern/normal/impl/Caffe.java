package com.kingpopen.templatepattern.normal.impl;

import com.kingpopen.templatepattern.normal.AbstractBeverage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 咖啡类
 * @date 2024/3/10 00:15:33
 */
@Slf4j
@AllArgsConstructor
public class Caffe extends AbstractBeverage {
    private BufferedReader in;

    @Override
    protected void brew() {
        log.info("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        log.info("Adding Sugar and Milk");
    }

    // 对钩子方法进行覆盖
    @Override
    protected boolean isAddCondiments() {
        if (Objects.isNull(in)) {
            throw new RuntimeException("BufferedReader对象为空！");
        }
        System.out.println("是否加入糖 和 牛奶的调料？");
        try {
            String s = in.readLine();
            return s.toLowerCase().startsWith("y");
        } catch (IOException e) {
            log.error("Caffe的添加调料方法发生异常！", e);
            throw new RuntimeException("Caffe的添加调料方法发生异常！");
        }
    }
}
