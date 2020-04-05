package com.cloudnative.grokking.mars.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.cloudnative.grokking.mars.dto.SampleMessage;
import com.cloudnative.grokking.mars.entity.Message;

/**
 * @author vietdv272
 */
@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    Message to(SampleMessage dto);
}
