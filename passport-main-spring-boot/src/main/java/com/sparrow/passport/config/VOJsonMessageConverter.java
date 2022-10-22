package com.sparrow.passport.config;

import com.sparrow.core.spi.JsonFactory;
import com.sparrow.json.Json;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.VO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.inject.Named;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

@Named
public class VOJsonMessageConverter extends AbstractHttpMessageConverter<VO> {
    private Json json = JsonFactory.getProvider();

    public VOJsonMessageConverter() {
        super(new MediaType("application", "json", StandardCharsets.UTF_8));
    }

    @Override
    public boolean supports(Class clazz) {
        return VO.class.isAssignableFrom(clazz);
    }

    @Override
    protected VO readInternal(Class<? extends VO> clazz,
        HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(VO result,
        HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (result instanceof Result) {
            outputMessage.getBody().write(this.json.toString(result).getBytes());
            return;
        }
        Result<VO> voResult = new Result<VO>(result);
        outputMessage.getBody().write(this.json.toString(voResult).getBytes());
    }
}
