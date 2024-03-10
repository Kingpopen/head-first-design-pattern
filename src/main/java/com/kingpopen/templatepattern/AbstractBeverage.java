package com.kingpopen.templatepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 抽象的饮料类
 * @date 2024/3/10 00:05:49
 */
@Slf4j
public abstract class AbstractBeverage {
    /**
     * 模板方法
     * 添加final关键字，防止子类覆盖
     */
    public final void prepareBeverage() {
        // 烧水
        boilWater();
        // 冲泡
        brew();
        // 倒入杯中
        pourInCup();
        // 加入调料
        if (isAddCondiments()){
            addCondiments();
        }
    }

    /**
     * 煮水
     * 使用protected关键字，只有子类可以访问
     */
    protected void boilWater() {
        log.info("Boiling water");
    }

    /**
     * 冲泡
     * protected关键字，只有子类可以访问
     */
    protected abstract void brew();

    /**
     * 倒入杯中
     */
    protected void pourInCup() {
        log.info("Pouring into cup");
    }

    /**
     * 加入调料
     */
    protected abstract void addCondiments();

    /**
     * 钩子方法
     * 是否加入调料
     * @return
     */
    protected boolean isAddCondiments() {
        return true;
    }
}
