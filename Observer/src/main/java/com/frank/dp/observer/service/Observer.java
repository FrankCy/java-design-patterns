package com.frank.dp.observer.service;

import com.frank.dp.observer.core.NumberGenerator;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.service、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午5:54
 * @mofified By:
 */
public interface Observer {

    void update (NumberGenerator generator);

}
