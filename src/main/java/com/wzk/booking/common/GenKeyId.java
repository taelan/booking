package com.wzk.booking.common;

import tk.mybatis.mapper.genid.GenId;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/7 - 14:36
 */
public class GenKeyId implements GenId<String> {

    private GenerateIdHelper generateIdHelper = new GenerateIdHelper();

    @Override
    public String genId(String s, String s1) {
        return Long.toString(generateIdHelper.nextId());
    }
}
