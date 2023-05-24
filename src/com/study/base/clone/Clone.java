package com.study.base.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/24 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clone implements Cloneable {
    private String name;
    private CloneInner cloneInner;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
