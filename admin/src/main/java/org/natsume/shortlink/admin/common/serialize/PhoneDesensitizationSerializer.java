package org.natsume.shortlink.admin.common.serialize;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * ClassName: PhoneDesensitizationSerializer
 * Package: org.natsume.shortlink.admin.common.serialize
 * Description: 手机号脱敏反序列化
 *
 * @Author natsume
 * @Create 2025/1/22 19:44
 * @Version 1.0
 */
public class PhoneDesensitizationSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String phone, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String phoneDesensitization = DesensitizedUtil.mobilePhone(phone); // 使用hutool的工具来进行隐私信息的脱敏
        jsonGenerator.writeString(phoneDesensitization);
    }
}