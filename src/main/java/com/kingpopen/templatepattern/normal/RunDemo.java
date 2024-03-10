package com.kingpopen.templatepattern.normal;

import com.kingpopen.templatepattern.normal.impl.Caffe;
import com.kingpopen.templatepattern.normal.impl.Tea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/10 00:16:16
 */
@Slf4j
public class RunDemo {
    public static void main(String[] args) {
        demo();

        String[] strs = new String[]{"a", "b", "c"};
        Arrays.sort(strs);
    }

    private static void demo() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            log.info("=== 开始泡茶 ===");
            Tea tea = new Tea(in);
            tea.prepareBeverage();
            log.info("=== 开始泡咖啡 ===");
            Caffe caffe = new Caffe(in);
            caffe.prepareBeverage();
        }catch (Exception e){
            log.error("运行出现异常！", e);
        }
    }
}
