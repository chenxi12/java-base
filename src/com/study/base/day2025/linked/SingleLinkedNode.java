package com.study.base.day2025.linked;

import lombok.Data;

/**
 * @author LiBing
 * @since 2025-03-10 下午8:26
 */
@Data
public class SingleLinkedNode {

    private Object value;

    private SingleLinkedNode nextNode;

    public SingleLinkedNode(Object value){
        this.value = value;
    }
}
