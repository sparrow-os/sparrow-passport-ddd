package com.sparrow.passport.config;

import com.sparrow.core.spi.JsonFactory;
import com.sparrow.json.Json;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.VO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.inject.Named;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

@Named
public class VOListJsonMessageConverter extends AbstractHttpMessageConverter<List<VO>> {
    private Json json = JsonFactory.getProvider();

    public VOListJsonMessageConverter() {
        super(new MediaType("application", "json", StandardCharsets.UTF_8));
    }

    @Override
    public boolean supports(Class<?> clazz) {
        if (clazz.getTypeParameters().length == 0) {
            return false;
        }
        return clazz.getTypeParameters()[0].getGenericDeclaration().isAssignableFrom(clazz);
    }

    @Override
    protected List<VO> readInternal(Class<? extends List<VO>> clazz,
        HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void writeInternal(List<VO> voList,
        HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Result<List<VO>> result = new Result<List<VO>>(voList);
        outputMessage.getBody().write(this.json.toString(result).getBytes());
    }
}
