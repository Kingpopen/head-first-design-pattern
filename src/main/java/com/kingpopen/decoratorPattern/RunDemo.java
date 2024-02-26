package com.kingpopen.decoratorPattern;

import com.kingpopen.decoratorPattern.baseimpl.Espresso;
import com.kingpopen.decoratorPattern.baseimpl.HouseBlend;
import com.kingpopen.decoratorPattern.decoratorimpl.Mocha;
import com.kingpopen.decoratorPattern.decoratorimpl.Whip;
import com.kingpopen.decoratorPattern.enums.SizeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 运行类
 * @date 2024/02/26 22:09:21
 */
@Slf4j
public class RunDemo {

  public static void main(String[] args) {
    normalWithSize();
  }

  public static void normal(){
    // 浓缩咖啡
    Espresso espresso = new Espresso();

    // 小料
    Mocha mocha = new Mocha(espresso);
    Whip whip = new Whip(mocha);

    // 结账
    log.info("饮品:{}, 价格:{}", whip.getDescription(), whip.cost());
  }

  public static void normalWithSize(){
    // 综合咖啡
    HouseBlend houseBlend = new HouseBlend(SizeEnum.BIG);

    // 小料
    Mocha mocha = new Mocha(houseBlend, SizeEnum.SMALL);
    Whip whip = new Whip(mocha, SizeEnum.Middle);

    // 结账
    log.info("饮品:{}, 价格:{}", whip.getDescription(), whip.cost());
  }


}
